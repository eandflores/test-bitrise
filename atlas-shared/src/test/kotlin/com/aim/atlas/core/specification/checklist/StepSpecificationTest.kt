package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.entity.checklist.Answer
import com.aim.atlas.core.entity.checklist.Label
import com.aim.atlas.core.entity.checklist.Step
import com.aim.atlas.core.entity.checklist.StepLabel
import com.aim.atlas.core.valueObjects.Trilean
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class StepSpecificationTest {
    private lateinit var specification: StepSpecification
    private lateinit var answerSpecification: AnswerSpecification
    private lateinit var stepLabelSpecification: StepLabelSpecification

    private lateinit var goodStep: Step
    private lateinit var badNameStep: Step
    private lateinit var badAnswerStep: Step
    private lateinit var badStepLabelStep: Step

    @Before
    fun setUp() {
        answerSpecification = AnswerSpecification()
        stepLabelSpecification = StepLabelSpecification()
        specification = StepSpecification(stepLabelSpecification, answerSpecification)

        val goodAnswer = Answer(0L, true, true, "<=", 5, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.REQUIRED, listOf())
        val badAnswer = Answer(0L, true, true, "=<", 5, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.REQUIRED, listOf())
        val goodStepLabel = StepLabel(0L, 0.5F, 1, Label(0L))
        val badStepLabel = StepLabel(0L, -0.5F, 1, Label(0L))

        goodStep = Step(0L, "Hay ratones?", listOf(goodStepLabel), goodAnswer)
        badNameStep = Step(0L, "Si", listOf(goodStepLabel), goodAnswer)
        badAnswerStep = Step(0L, "Hay ratones?", listOf(goodStepLabel), badAnswer)
        badStepLabelStep = Step(0L, "Hay ratones?", listOf(badStepLabel), goodAnswer)

    }

    @Test
    fun isSatisfiedBy() {
        assertEquals(true, specification.isSatisfiedBy(goodStep))
    }

    @Test
    fun isNotSatisfiedByName() {
        assertEquals(false, specification.isSatisfiedBy(badNameStep))
    }

    @Test
    fun isNotSatisfiedByAnswer() {
        assertEquals(false, specification.isSatisfiedBy(badAnswerStep))
    }

    @Test
    fun isNotSatisfiedByStepLabel() {
        assertEquals(false, specification.isSatisfiedBy(badStepLabelStep))
    }
}