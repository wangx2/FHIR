/**
 * (C) Copyright IBM Corp. 2018,2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.persistence.search.test;

import org.testng.annotations.Test;

import com.ibm.watsonhealth.fhir.model.Basic;

/**
 * @author lmsurpre
 * @see https://hl7.org/fhir/dstu2/search.html#date
 */
public abstract class AbstractSearchDateTest extends AbstractPLSearchTest {

    @Test
    public void testCreateBasicResource() throws Exception {
        Basic resource = readResource(Basic.class, "BasicDate.json");
        saveBasicResource(resource);
    }
    
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testCreateChainedBasicResource() throws Exception {
        createCompositionReferencingSavedResource();
    }
    
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_date() throws Exception {
        assertSearchReturnsSavedResource("date", "2018-10-29");
        // This should return the resource but does not
//        assertSearchReturnsSavedResource("date", "2018-10-29T17:12:00-04:00");
        // This throws an error
//        assertSearchReturnsSavedResource("date", "2018-10-29T17:12:00");
        assertSearchDoesntReturnSavedResource("date", "2025-10-29");
    }
    
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_date_missing() throws Exception {
        assertSearchReturnsSavedResource("date:missing", "false");
        assertSearchDoesntReturnSavedResource("date:missing", "true");
        
        assertSearchReturnsSavedResource("missing-date:missing", "true");
        assertSearchDoesntReturnSavedResource("missing-date:missing", "false");
    }

    @Test(dependsOnMethods = { "testCreateChainedBasicResource" })
    public void testSearchDate_date_chained() throws Exception {
        assertSearchReturnsComposition("subject:Basic.date", "2018-10-29");
        // This should return the resource but does not
//        assertSearchReturnsComposition("date", "2018-10-29T17:12:00-04:00");
        // This throws an error
//        assertSearchReturnsComposition("date", "2018-10-29T17:12:00");
        assertSearchDoesntReturnComposition("subject:Basic.date", "2025-10-29");
    }

CODE_REMOVED
//    @Test(dependsOnMethods = { "testCreateChainedBasicResource" })
//    public void testSearchDate_date_chained_missing() throws Exception {
//        assertSearchReturnsComposition("subject:Basic.date:missing", "false");
//        assertSearchDoesntReturnSavedResource("subject:Basic.date:missing", "true");
//        
//        assertSearchReturnsComposition("subject:Basic.missing-date:missing", "true");
//        assertSearchDoesntReturnSavedResource("subject:Basic.missing-date:missing", "false");
//    }

    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_dateTime() throws Exception {
        assertSearchReturnsSavedResource("dateTime", "2018-10-29T17:12:00-04:00");
        assertSearchReturnsSavedResource("dateTime", "2018-10-29");
        
        assertSearchDoesntReturnSavedResource("dateTime", "2025-10-29");
    }
    
    @Test(dependsOnMethods = { "testCreateChainedBasicResource" })
    public void testSearchDate_dateTime_chained() throws Exception {
        assertSearchReturnsComposition("subject:Basic.dateTime", "2018-10-29T17:12:00-04:00");
        assertSearchReturnsComposition("subject:Basic.dateTime", "2018-10-29");
        
        assertSearchDoesntReturnSavedResource("subject:Basic.dateTime", "2025-10-29");
    }
    
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_dateTime_missing() throws Exception {
        assertSearchReturnsSavedResource("dateTime:missing", "false");
        assertSearchDoesntReturnSavedResource("dateTime:missing", "true");
        
        assertSearchReturnsSavedResource("missing-dateTime:missing", "true");
        assertSearchDoesntReturnSavedResource("missing-dateTime:missing", "false");
    }
    
CODE_REMOVED
//    @Test(dependsOnMethods = { "testCreateChainedBasicResource" })
//    public void testSearchDate_dateTime_chained_missing() throws Exception {
//        assertSearchReturnsComposition("subject:Basic.dateTime:missing", "false");
//        assertSearchDoesntReturnComposition("subject:Basic.dateTime:missing", "true");
//        
//        assertSearchReturnsComposition("subject:Basic.missing-dateTime:missing", "true");
//        assertSearchDoesntReturnComposition("subject:Basic.missing-dateTime:missing", "false");
//    }
    
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_instant() throws Exception {
        assertSearchReturnsSavedResource("instant", "2018-10-29T17:12:44-04:00");
    }
    
    @Test(dependsOnMethods = { "testCreateChainedBasicResource" })
    public void testSearchDate_instant_chained() throws Exception {
        assertSearchReturnsComposition("subject:Basic.instant", "2018-10-29T17:12:44-04:00");
    }
    
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_instant_missing() throws Exception {
        assertSearchReturnsSavedResource("instant:missing", "false");
        assertSearchDoesntReturnSavedResource("instant:missing", "true");
        
        assertSearchReturnsSavedResource("missing-instant:missing", "true");
        assertSearchDoesntReturnSavedResource("missing-instant:missing", "false");
    }
    
CODE_REMOVED
//    @Test(dependsOnMethods = { "testCreateChainedBasicResource" })
//    public void testSearchDate_instant_chained_missing() throws Exception {
//        assertSearchReturnsSavedResource("subject:Basic.instant:missing", "false");
//        assertSearchDoesntReturnSavedResource("subject:Basic.instant:missing", "true");
//        
//        assertSearchReturnsSavedResource("subject:Basic.missing-instant:missing", "true");
//        assertSearchDoesntReturnSavedResource("subject:Basic.missing-instant:missing", "false");
//    }
    
    ///////////////
    // Period tests
    ///////////////
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_Period() throws Exception {
        assertSearchReturnsSavedResource("Period", "2018-10-29T17:12:44-04:00");
    }
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_Period_NoStart() throws Exception {
        assertSearchReturnsSavedResource("Period-noStart", "2018-10-29T17:12:44-04:00");
    }
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_Period_NoEnd() throws Exception {
        assertSearchReturnsSavedResource("Period-noEnd", "2018-10-29T17:12:44-04:00");
    }
    // TODO: chained Period search is not supported yet
    @Test(dependsOnMethods = { "testCreateChainedBasicResource" })
    public void testSearchDate_Period_chained() throws Exception {
        assertSearchReturnsComposition("subject:Basic.Period", "2018-10-29T17:12:44-04:00");
    }
    @Test(dependsOnMethods = { "testCreateBasicResource" })
    public void testSearchDate_Period_missing() throws Exception {
        assertSearchReturnsSavedResource("Period:missing", "false");
        assertSearchDoesntReturnSavedResource("Period:missing", "true");
        
        assertSearchReturnsSavedResource("missing-Period:missing", "true");
        assertSearchDoesntReturnSavedResource("missing-Period:missing", "false");
    }
CODE_REMOVED
//    @Test(dependsOnMethods = { "testCreateChainedBasicResource" })
//    public void testSearchDate_Period_chained_missing() throws Exception {
//        assertSearchReturnsComposition("subject:Basic.Period:missing", "false");
//        assertSearchDoesntReturnComposition("subject:Basic.Period:missing", "true");
//        
//        assertSearchReturnsComposition("subject:Basic.missing-Period:missing", "true");
//        assertSearchDoesntReturnComposition("subject:Basic.missing-Period:missing", "false");
//    }
    
    // We decided that Periods with no start or end should not even be indexed 
//    @Test(dependsOnMethods = { "testCreateBasicResource" })
//    public void testSearchDate_Period_NoStartOrEnd() throws Exception {
//        assertSearchReturnsSavedResource("Period-noStartOrEnd", "2018-10-29T17:12:44-04:00");
//    }
    
    // Timing search is not working properly.
//    @Test(dependsOnMethods = { "testCreateBasicResource" })
//    public void testSearchDate_Timing_EventsOnly() throws Exception {
//        testSearchDateReturnsResourceWithExtension("Timing-eventsOnly", "2018-10-29T17:12:44-04:00", "http://example.org/TimingEventsOnly");
//    }
//    @Test(dependsOnMethods = { "testCreateBasicResource" })
//    public void testSearchDate_Timing_BoundQuantity() throws Exception {
//        testSearchDateReturnsResourceWithExtension("Timing-boundQuantity", "2018-10-29T17:12:44-04:00", "http://example.org/TimingBoundsQuantity");
//    }
//    @Test(dependsOnMethods = { "testCreateBasicResource" })
//    public void testSearchDate_Timing_BoundRange() throws Exception {
//        testSearchDateReturnsResourceWithExtension("Timing-boundRange", "2018-10-29T17:12:00-04:00", "http://example.org/TimingBoundsRange");
//    }
//    @Test(dependsOnMethods = { "testCreateBasicResource" })
//    public void testSearchDate_Timing_BoundPeriod() throws Exception {
//        testSearchDateReturnsResourceWithExtension("Timing-boundPeriod", "2018-10-29T17:18:00-04:00", "http://example.org/TimingBoundsPeriod");
//    }
}