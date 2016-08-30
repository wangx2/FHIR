/**
 * (C) Copyright IBM Corp. 2016,2017,2018,2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.server.listener;

import static com.ibm.watsonhealth.fhir.config.FHIRConfiguration.PROPERTY_KAFKA_CONNECTIONPROPS;
import static com.ibm.watsonhealth.fhir.config.FHIRConfiguration.PROPERTY_KAFKA_ENABLED;
import static com.ibm.watsonhealth.fhir.config.FHIRConfiguration.PROPERTY_KAFKA_TOPICNAME;
import static com.ibm.watsonhealth.fhir.config.FHIRConfiguration.PROPERTY_WEBSOCKET_ENABLED;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.websocket.server.ServerContainer;

import com.ibm.watsonhealth.fhir.config.FHIRConfiguration;
import com.ibm.watsonhealth.fhir.config.PropertyGroup;
import com.ibm.watsonhealth.fhir.config.PropertyGroup.PropertyEntry;
import com.ibm.watsonhealth.fhir.model.util.FHIRUtil;
import com.ibm.watsonhealth.fhir.notification.websocket.impl.FHIRNotificationServiceEndpointConfig;
import com.ibm.watsonhealth.fhir.notifications.kafka.impl.FHIRNotificationKafkaPublisher;
import com.ibm.watsonhealth.fhir.persistence.helper.FHIRPersistenceHelper;
import com.ibm.watsonhealth.fhir.search.util.SearchUtil;
import com.ibm.watsonhealth.fhir.server.util.RestAuditLogger;

@WebListener("IBM Watson Health Cloud FHIR Server Servlet Context Listener")
public class FHIRServletContextListener implements ServletContextListener {
    private static final Logger log = Logger.getLogger(FHIRServletContextListener.class.getName());
	
	private static final String ATTRNAME_WEBSOCKET_SERVERCONTAINER = "javax.websocket.server.ServerContainer";
	private static final String DEFAULT_KAFKA_TOPICNAME = "fhirNotifications";
    private static FHIRNotificationKafkaPublisher kafkaPublisher = null;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		if (log.isLoggable(Level.FINER)) {
			log.entering(FHIRServletContextListener.class.getName(), "contextInitialized");
		}
		try {
		    PropertyGroup fhirConfig = FHIRConfiguration.loadConfiguration();
		    
		    log.fine("Current working directory: " + System.getProperty("user.dir"));
		    
		    log.fine("Initializing FHIRUtil...");
		    FHIRUtil.init();
		    
		    log.fine("Initializing SearchUtil...");
		    SearchUtil.init();
		    
			// For any singleton resources that need to be shared among our resource class instances,
		    // we'll add them to our servlet context so that the resource class can easily retrieve them.
		    
			// Set the shared FHIRPersistenceHelper.
            event.getServletContext().setAttribute(FHIRPersistenceHelper.class.getName(), new FHIRPersistenceHelper());
            log.fine("Set shared persistence helper on servlet context.");

            // If websocket notifications are enabled, then initialize the endpoint.
            Boolean websocketEnabled = fhirConfig.getBooleanProperty(PROPERTY_WEBSOCKET_ENABLED, Boolean.FALSE);
            if (websocketEnabled) {
                log.info("Initializing WebSocket notification publisher.");
                ServerContainer container = (ServerContainer) event.getServletContext().getAttribute(ATTRNAME_WEBSOCKET_SERVERCONTAINER);
                container.addEndpoint(new FHIRNotificationServiceEndpointConfig());
            } else {
                log.info("Bypassing WebSocket notification init.");
            }
            
            // If Kafka notifications are enabled, start up our Kafka notification publisher.
            Boolean kafkaEnabled = fhirConfig.getBooleanProperty(PROPERTY_KAFKA_ENABLED, Boolean.FALSE);
            if (kafkaEnabled) {
                // Retrieve the topic name.
                String topicName = fhirConfig.getStringProperty(PROPERTY_KAFKA_TOPICNAME, DEFAULT_KAFKA_TOPICNAME);
                
                // Gather up the Kafka connection properties.
                Properties kafkaProps = new Properties();
                PropertyGroup pg = fhirConfig.getPropertyGroup(PROPERTY_KAFKA_CONNECTIONPROPS);
                if (pg != null) {
                    List<PropertyEntry> connectionProps = pg.getProperties();
                    if (connectionProps != null) {
                        for (PropertyEntry entry : connectionProps) {
                            kafkaProps.setProperty(entry.getName(), entry.getValue().toString());
                        }
                    }
                }
                
                log.info("Initializing Kafka notification publisher.");
                kafkaPublisher = new FHIRNotificationKafkaPublisher(topicName, kafkaProps);
            } else {
                log.info("Bypassing Kafka notification init.");
            }
            logConfigData();
		} catch(Throwable t) {
		    String msg = "Encountered an exception while initializing the servlet context.";
		    log.log(Level.SEVERE, msg, t);
		    throw new RuntimeException(msg, t);
		} finally {
			if (log.isLoggable(Level.FINER)) {
				log.exiting(FHIRServletContextListener.class.getName(), "contextInitialized");
			}
		}
	}

    @Override
	public void contextDestroyed(ServletContextEvent event) {
		if (log.isLoggable(Level.FINER)) {
			log.entering(FHIRServletContextListener.class.getName(), "contextDestroyed");
		}
		try {
		    
		    // If we previously intialized the Kafka publisher, then shut it down now.
		    if (kafkaPublisher != null) {
		        kafkaPublisher.shutdown();
		        kafkaPublisher = null;
		    }
		} catch (Exception e) {
		} finally {
			if (log.isLoggable(Level.FINER)) {
				log.exiting(FHIRServletContextListener.class.getName(), "contextDestroyed");
			}
		}
	}
    
    /**
     * Logs server configuration data using the REST audit log service.
     */
    private void logConfigData() {
    	if (log.isLoggable(Level.FINER)) {
			log.entering(FHIRServletContextListener.class.getName(), "logConfigData");
		}
    	
    	String configData;
    	String configFilePath = null;
    	    	
    	try {
    		// Read files containing config data from the current directory.
    		configFilePath = "server.xml";
			configData = new String(Files.readAllBytes(Paths.get(configFilePath)));
			RestAuditLogger.logConfig(configData);
			configFilePath = "fhir-server-config.json";
			configData = new String(Files.readAllBytes(Paths.get(configFilePath)));
			RestAuditLogger.logConfig(configData);
		} catch (IOException e) {
			log.severe("Failure reading server config file: " + configFilePath + "\n" + e.toString());
		}
    	
    	if (log.isLoggable(Level.FINER)) {
			log.exiting(FHIRServletContextListener.class.getName(), "logConfigData");
		}
    }

}
