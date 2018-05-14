package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.entity.checklist.*
import com.aim.atlas.core.valueObjects.Trilean
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class ChecklistSpecificationTest {
    private lateinit var specification: ChecklistSpecification
    private lateinit var answerSpecification: AnswerSpecification
    private lateinit var stepLabelSpecification: StepLabelSpecification
    private lateinit var stepSpecification: StepSpecification
    private lateinit var configurationSpecification: ConfigurationSpecification

    private lateinit var goodChecklist: Checklist
    private lateinit var badNameChecklist: Checklist
    private lateinit var badBusinessAreaChecklist: Checklist
    private lateinit var badConfigurationChecklist: Checklist
    private lateinit var badNullConceptsChecklist: Checklist
    private lateinit var badNulLStepsChecklist: Checklist
    private lateinit var badStepsChecklist: Checklist

    @Before
    fun setUp() {
        answerSpecification = AnswerSpecification()
        stepLabelSpecification = StepLabelSpecification()
        stepSpecification = StepSpecification(stepLabelSpecification, answerSpecification)
        configurationSpecification = ConfigurationSpecification()
        specification = ChecklistSpecification(configurationSpecification, stepSpecification)

        val futureDate = LocalDateTime.of(2100,12,31,12,0)
        val futureDate2 = LocalDateTime.of(2101,1,31,12,0)

        val goodConfig = ChecklistConfiguration(0L,0, 100, 1, 100, futureDate, futureDate2, true, false, false, 1, 2)
        val badConfig = ChecklistConfiguration(0L,-10, 100, 1, 100, futureDate, futureDate2, true, false, false, 1, 2)

        val goodConcepts = listOf(
                Concept(
                        0L,
                        "Okey",
                        "#FFCC99",
                        true,
                        listOf(
                                Label(0L, "Label", 1, 0.5F),
                                Label(0L, "Label2", 1, 0.5F)
                        ))
        )

        val goodAnswer = Answer(0L, true, true, "<=", 5, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.REQUIRED, listOf())
        val goodStepLabel = StepLabel(0L, 0.5F, 1, Label(0L))

        val goodStep = Step(0L, "Hay ratones?", listOf(goodStepLabel), goodAnswer)
        val badStep = Step(0L, "Si", listOf(goodStepLabel), goodAnswer)

        goodChecklist = Checklist(
                0L,
                1L,
                "Test Checklist",
                "Description",
                "circle-check",
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                goodConcepts,
                listOf(goodStep),
                goodConfig
                )

        badNameChecklist = Checklist(
                0L,
                1L,
                "Ok",
                "Description",
                "circle-check",
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                goodConcepts,
                listOf(goodStep),
                goodConfig
        )

        badBusinessAreaChecklist = Checklist(
                0L,
                null,
                "Test Checklist",
                "Description",
                "circle-check",
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                goodConcepts,
                listOf(goodStep),
                goodConfig
        )

        badConfigurationChecklist = Checklist(
                0L,
                null,
                "Test Checklist",
                "Description",
                "circle-check",
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                goodConcepts,
                listOf(goodStep),
                badConfig
        )

        badNullConceptsChecklist = Checklist(
                0L,
                null,
                "Test Checklist",
                "Description",
                "circle-check",
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                listOf(),
                listOf(goodStep),
                goodConfig
        )

        badNulLStepsChecklist = Checklist(
                0L,
                null,
                "Test Checklist",
                "Description",
                "circle-check",
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                goodConcepts,
                listOf(),
                goodConfig
        )

        badStepsChecklist = Checklist(
                0L,
                null,
                "Test Checklist",
                "Description",
                "circle-check",
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                goodConcepts,
                listOf(badStep),
                goodConfig
        )
    }

    @Test
    fun isSatisfiedBy() {
        assertEquals(true, specification.isSatisfiedBy(goodChecklist))
    }

    @Test
    fun isNotSatisfiedByName() {
        assertEquals(false, specification.isSatisfiedBy(badNameChecklist))
    }

    @Test
    fun isNotSatisfiedByBusinessArea() {
        assertEquals(false, specification.isSatisfiedBy(badBusinessAreaChecklist))
    }

    @Test
    fun isNotSatisfiedByConfiguration() {
        assertEquals(false, specification.isSatisfiedBy(badConfigurationChecklist))
    }

    @Test
    fun isNotSatisfiedByNullConcepts() {
        assertEquals(false, specification.isSatisfiedBy(badNullConceptsChecklist))
    }

    @Test
    fun isNotSatisfiedByNullSteps() {
        assertEquals(false, specification.isSatisfiedBy(badNulLStepsChecklist))
    }

    @Test
    fun isNotSatisfiedBySteps() {
        assertEquals(false, specification.isSatisfiedBy(badStepsChecklist))
    }
}