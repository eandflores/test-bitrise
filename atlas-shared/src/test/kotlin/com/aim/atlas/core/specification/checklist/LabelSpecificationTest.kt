package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.entity.checklist.Label
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class LabelSpecificationTest {
    private lateinit var specification: LabelSpecification
    private lateinit var badNameLabel: Label
    private lateinit var badWeightLabel: Label
    private lateinit var badPlaceLabel: Label
    private lateinit var goodLabel: Label

    @Before
    fun setUp() {
        specification = LabelSpecification()

        badNameLabel = Label(0L, "Ok", 2,0.5F)
        badWeightLabel = Label(0L, "Piso", 2, -0.8F)
        badPlaceLabel = Label(0L, "Piso", -1, 0.5F)
        goodLabel = Label(0L, "Piso", 1, 0.5F)
    }

    @Test
    fun isSatisfiedBy() {
        assertEquals(true, specification.isSatisfiedBy(goodLabel))
    }

    @Test
    fun isNotSatisfiedByName() {
        assertEquals(false, specification.isSatisfiedBy(badNameLabel))
    }

    @Test
    fun isNotSatisfiedByWeight() {
        assertEquals(false, specification.isSatisfiedBy(badWeightLabel))
    }

    @Test
    fun isNotSatisfiedByPlace() {
        assertEquals(false, specification.isSatisfiedBy(badPlaceLabel))
    }
}