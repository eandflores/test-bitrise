package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.entity.checklist.Concept
import com.aim.atlas.core.entity.checklist.Label
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ConceptSpecificationTest {
    private lateinit var specification: ConceptSpecification
    private lateinit var labelSpecification: LabelSpecification

    private lateinit var badNameConcept: Concept
    private lateinit var badColorConcept: Concept
    private lateinit var emptyLabelConcept: Concept
    private lateinit var sameLabelNamesConcept: Concept
    private lateinit var badLabelConcept: Concept
    private lateinit var goodConcept: Concept

    @Before
    fun setUp() {
        labelSpecification = LabelSpecification()
        specification = ConceptSpecification(labelSpecification)

        badNameConcept = Concept(0L, "Ok", "#FFCC99", true, listOf(Label(0L, "Label", 1, 0.5F)))
        badColorConcept = Concept(0L, "Okey", "red", true, listOf(Label(0L, "Label", 1, 0.5F)))
        emptyLabelConcept = Concept(0L, "Okey", "#FFCC99", true, listOf())
        sameLabelNamesConcept = Concept(
                0L,
                "Okey",
                "#FFCC99",
                true,
                listOf(
                        Label(0L, "Label", 1, 0.5F),
                        Label(0L, "Label", 1, 0.5F)
                ))

        badLabelConcept = Concept(
                0L,
                "Okey",
                "#FFCC99",
                true,
                listOf(
                        Label(0L, "Ok", 1, 0.5F)
                ))

        goodConcept = Concept(
                0L,
                "Okey",
                "#FFCC99",
                true,
                listOf(
                        Label(0L, "Label", 1, 0.5F),
                        Label(0L, "Label2", 1, 0.5F)
                ))
    }

    @Test
    fun isSatisfiedBy() {
        assertEquals(true, specification.isSatisfiedBy(goodConcept))
    }

    @Test
    fun isNotSatisfiedByName() {
        assertEquals(false, specification.isSatisfiedBy(badNameConcept))
    }

    @Test
    fun isNotSatisfiedByColor() {
        assertEquals(false, specification.isSatisfiedBy(badColorConcept))
    }

    @Test
    fun isNotSatisfiedByEmptyLabel() {
        assertEquals(false, specification.isSatisfiedBy(emptyLabelConcept))
    }

    @Test
    fun isNotSatisfiedBySameLabelName() {
        assertEquals(false, specification.isSatisfiedBy(sameLabelNamesConcept))
    }

    @Test
    fun isNotSatisfiedByBadLabel() {
        assertEquals(false, specification.isSatisfiedBy(badLabelConcept))
    }
}