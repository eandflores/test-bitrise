package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.entity.checklist.Label
import com.aim.atlas.core.entity.checklist.StepLabel
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class StepLabelSpecificationTest {
    private lateinit var specification: StepLabelSpecification

    private lateinit var goodStepLabel: StepLabel
    private lateinit var badWeightStepLabel: StepLabel
    private lateinit var badPlaceStepLabel: StepLabel

    @Before
    fun setUp() {
        specification = StepLabelSpecification()

        goodStepLabel = StepLabel(0L, 0.5F, 1, Label(0L))
        badPlaceStepLabel = StepLabel(0L, 0.5F, 0, Label(0L))
        badWeightStepLabel = StepLabel(0L, -0.5F, 1, Label(0L))
    }

    @Test
    fun isSatisfiedBy() {
        assertEquals(true, specification.isSatisfiedBy(goodStepLabel))
    }

    @Test
    fun isNotSatisfiedByPlace() {
        assertEquals(false, specification.isSatisfiedBy(badPlaceStepLabel))
    }

    @Test
    fun isNotSatisfiedByWeight() {
        assertEquals(false, specification.isSatisfiedBy(badWeightStepLabel))
    }
}