/*
 * (C) Copyright IBM Corp. 2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.term.service;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Set;

import com.ibm.fhir.model.resource.CodeSystem.Concept;
import com.ibm.fhir.model.resource.ValueSet;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.code.ConceptSubsumptionOutcome;
import com.ibm.fhir.term.service.provider.DefaultTermServiceProvider;
import com.ibm.fhir.term.spi.FHIRTermServiceProvider;

public class FHIRTermService {
    private static final FHIRTermService INSTANCE = new FHIRTermService();

    private final FHIRTermServiceProvider provider;

    private FHIRTermService() {
        provider = loadProvider();
    }

    /**
     * Expand the given value set per the algorithm here: http://hl7.org/fhir/valueset.html#expansion
     *
     * @param valueSet
     *     the value set to be expanded
     * @return
     *     the expanded value set, or the original value set if already expanded or unable to expand
     */
    public ValueSet expand(ValueSet valueSet) {
        return provider.expand(valueSet);
    }

    /**
     * Lookup the code system concept for the given coding
     *
     * @param coding
     *     the coding to lookup
     * @return
     *     the code system concept that matches the given coding, or null if no such concept exists
     */
    public Concept lookup(Coding coding) {
        return provider.lookup(coding);
    }

    /**
     * Perform a subsumption test to determine if the code system concept represented by the given coding "A" subsumes
     * the code system concept represented by the given coding "B"
     *
     * @param codingA
     *     the coding "A"
     * @param codingB
     *     the coding "B"
     * @return
     *     the outcome of the subsumption test
     */
    public ConceptSubsumptionOutcome subsumes(Coding codingA, Coding codingB) {
        return provider.subsumes(codingA, codingB);
    }

    /**
     * Generate the transitive closure for the code system concept represented by the given coding
     *
     * @param coding
     *     the coding
     * @return
     *     a set containing the transitive closure for the code system concept represented by the given coding
     */
    public Set<Concept> closure(Coding coding) {
        return provider.closure(coding);
    }

    /**
     * Indicates whether a code system concept matches the given coding
     *
     * @param coding
     *     the coding
     * @return
     *     true if a code system concept matches the given coding, false otherwise
     */
    public boolean validateCode(Coding coding) {
        return provider.validateCode(coding);
    }

    /**
     * Indicates whether the given coding is a member of the specified value set
     *
     * @param valueSet
     *     the value set
     * @param coding
     *     the coding
     * @return
     *     true if the given coding is a member of the specified value set, false otherwise
     */
    public boolean validateCode(ValueSet valueSet, Coding coding) {
        return provider.validateCode(valueSet, coding);
    }

    public static FHIRTermService getInstance() {
        return INSTANCE;
    }

    private FHIRTermServiceProvider loadProvider() {
        Iterator<FHIRTermServiceProvider> iterator = ServiceLoader.load(FHIRTermServiceProvider.class).iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return new DefaultTermServiceProvider();
    }
}