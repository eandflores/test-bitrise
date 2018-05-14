package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.entity.checklist.ChecklistConfiguration
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class ConfigurationSpecificationTest {
    private lateinit var specification: ConfigurationSpecification
    private lateinit var badMinGradeConfig: ChecklistConfiguration
    private lateinit var badMaxGradeConfig: ChecklistConfiguration
    private lateinit var badIntervalConfig: ChecklistConfiguration
    private lateinit var badIntervalConfig2: ChecklistConfiguration
    private lateinit var badExecutionTimeConfig: ChecklistConfiguration
    private lateinit var badPublicationTimeConfig: ChecklistConfiguration
    private lateinit var badExpirationTimeConfig: ChecklistConfiguration
    private lateinit var badWithConfig: ChecklistConfiguration
    private lateinit var badDefaultConceptIdConfig: ChecklistConfiguration
    private lateinit var badTourConceptIdConfig: ChecklistConfiguration
    private lateinit var goodConfig: ChecklistConfiguration

    @Before
    fun setUp() {
        specification = ConfigurationSpecification()

        val futureDate = LocalDateTime.of(2100,12,31,12,0)
        val futureDate2 = LocalDateTime.of(2101,1,31,12,0)

        goodConfig = ChecklistConfiguration(0L,0, 100, 1, 100, futureDate, futureDate2, true, false, false, 1, 2)

        badMinGradeConfig = ChecklistConfiguration(0L,-1, 100, 1, 100, futureDate, futureDate2, true, false, false, 1, 2)
        badMaxGradeConfig = ChecklistConfiguration(0L,5, 0, 1, 100, futureDate, futureDate2, true, false, false, 1, 2)
        badIntervalConfig = ChecklistConfiguration(0L,0, 100, -2, 100, futureDate, futureDate2, true, false, false, 1, 2)
        badIntervalConfig2 = ChecklistConfiguration(0L,0, 100, 101, 100, futureDate, futureDate2, true, false, false, 1, 2)
        badExecutionTimeConfig = ChecklistConfiguration(0L,0, 100, 1, -1, futureDate, futureDate2, true, false, false, 1, 2)
        badPublicationTimeConfig = ChecklistConfiguration(0L,0, 100, 1, 100, LocalDateTime.now(), futureDate2, true, false, false, 1, 2)
        badExpirationTimeConfig = ChecklistConfiguration(0L,0, 100, 1, 100, futureDate, LocalDateTime.now(), true, false, false, 1, 2)
        badWithConfig = ChecklistConfiguration(0L,0, 100, 1, 100, futureDate, futureDate2, false, false, false, 1, 2)
        badDefaultConceptIdConfig = ChecklistConfiguration(0L,0, 100, 1, 100, futureDate, futureDate2, true, false, false, 1, null)
        badTourConceptIdConfig = ChecklistConfiguration(0L,0, 100, 1, 100, futureDate, futureDate2, true, false, false, null, 2)
    }

    @Test
    fun isSatisfiedBy() {
        assertEquals(true, specification.isSatisfiedBy(goodConfig))
    }

    @Test
    fun isNotSatisfiedByMinGrade() {
        assertEquals(false, specification.isSatisfiedBy(badMinGradeConfig))
    }

    @Test
    fun isNotSatisfiedByMaxGrade() {
        assertEquals(false, specification.isSatisfiedBy(badMaxGradeConfig))
    }

    @Test
    fun isNotSatisfiedByInterval() {
        assertEquals(false, specification.isSatisfiedBy(badIntervalConfig))
        assertEquals(false, specification.isSatisfiedBy(badIntervalConfig2))
    }

    @Test
    fun isNotSatisFiedByExecutionTime() {
        assertEquals(false, specification.isSatisfiedBy(badExecutionTimeConfig))
    }

    @Test
    fun isNotSatisfiedByPublicationTime() {
        assertEquals(false, specification.isSatisfiedBy(badPublicationTimeConfig))
    }

    @Test
    fun isNotSatisfiedByExpirationTime() {
        assertEquals(false, specification.isSatisfiedBy(badExpirationTimeConfig))
    }

    @Test
    fun isNotSatisfiedByWith() {
        assertEquals(false, specification.isSatisfiedBy(badWithConfig))
    }

    @Test
    fun isNotSatisfiedByDefaultConcept() {
        assertEquals(false, specification.isSatisfiedBy(badDefaultConceptIdConfig))
    }

    @Test
    fun isNotSatisfiedByTourConcept() {
        assertEquals(false, specification.isSatisfiedBy(badTourConceptIdConfig))
    }
}