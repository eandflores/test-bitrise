package com.aim.atlas.core.interactor.checklist.checklist

import com.aim.atlas.core.entity.checklist.*
import com.aim.atlas.core.mapper.checklist.ChecklistRequestMapper
import com.aim.atlas.core.mapper.checklist.ChecklistResponseMapper
import com.aim.atlas.core.repository.checklist.*
import com.aim.atlas.core.specification.checklist.ChecklistSpecification
import com.aim.atlas.core.valueObjects.Trilean
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Maybe
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.time.LocalDateTime

class CreateChecklistInteractorTest {
    /* Interactor */
    lateinit var interactor: CreateChecklistInteractor

    /* Specification */
    lateinit var specification: ChecklistSpecification

    /* Repositories */
    lateinit var checklistRepository: ChecklistRepository
    lateinit var configurationRepository: ConfigurationRepository
    lateinit var stepRepository: StepRepository
    lateinit var answerRepository: AnswerRepository
    lateinit var stepLabelRepository: StepLabelRepository

    /* Mapper */
    lateinit var requestMapper: ChecklistRequestMapper
    lateinit var responseMapper: ChecklistResponseMapper

    /* Entities */
    lateinit var request: ChecklistRequest
    lateinit var checklist: Checklist
    lateinit var concepts: List<Concept>
    lateinit var steps: List<Step>

    @Before
    fun setUp() {
        checklistRepository = mock()
        configurationRepository = mock()
        stepRepository = mock()
        answerRepository = mock()
        stepLabelRepository = mock()

        specification = mock()

        request = mock()
        requestMapper = mock()
        responseMapper = mock()

        interactor = CreateChecklistInteractor(
                checklistRepository,
                configurationRepository,
                stepRepository,
                answerRepository,
                stepLabelRepository,
                specification,
                requestMapper,
                responseMapper
        )

        concepts = listOf(
            Concept(
                1L,
                "Plagas",
                "#0099cc",
                true,
                listOf(
                    Label(
                        1L,
                        "Ratones",
                        1,
                        0.3F
                    ),
                    Label(
                        2L,
                        "Palomas",
                        2,
                        0.7F
                    )
                )
            )
        )

        steps = listOf(
                Step(
                        0L,
                        "Hay ratones en el pasillo?",
                        listOf(
                                StepLabel(
                                        0L,
                                        0.4F,
                                        2,
                                        Label(
                                                2L,
                                                "Palomas",
                                                2,
                                                0.7F
                                        )
                                )
                        ),
                        Answer(
                                0L,
                                true,
                                true,
                                "<",
                                5,
                                Trilean.OPTIONAL,
                                Trilean.OPTIONAL,
                                Trilean.OPTIONAL,
                                Trilean.REQUIRED,
                                listOf()
                        )
                ),
                Step(
                        0L,
                        "Hay caca en el piso?",
                        listOf(
                                StepLabel(
                                        0L,
                                        0.4F,
                                        2,
                                        Label(
                                                2L,
                                                "Palomas",
                                                2,
                                                0.7F
                                        )
                                )
                        ),
                        Answer(
                                0L,
                                true,
                                true,
                                "<",
                                5,
                                Trilean.OPTIONAL,
                                Trilean.OPTIONAL,
                                Trilean.OPTIONAL,
                                Trilean.REQUIRED,
                                listOf()
                        )
                )
        )


        checklist = Checklist(
                0L,
                1L,
                "Checklist de prueba",
                "Pruebas",
                "circle-check",
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                concepts,
                steps,
                ChecklistConfiguration(
                        0L,
                        0,
                        100,
                        1,
                        180,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        true,
                        false,
                        false,
                        null,
                        null
                )
        )
    }

    @Test
    fun input() {
    }

    @Test
    fun execute() {
        Mockito.`when`(requestMapper.transform(any())).thenReturn(checklist)
        Mockito.`when`(configurationRepository.create(any())).thenReturn(Maybe.just(ChecklistConfiguration(0L)))
        Mockito.`when`(checklistRepository.create(any())).thenReturn(Maybe.just(Checklist(0L)))
        Mockito.`when`(stepRepository.create(any())).thenReturn(Maybe.just(Step(0L)))
        Mockito.`when`(answerRepository.create(any())).thenReturn(Maybe.just(Answer(0L)))
        Mockito.`when`(stepLabelRepository.create(any())).thenReturn(Maybe.just(StepLabel(0L)))

        interactor.input(request)

        val expectedChecklist = interactor.execute()
        val testObserver = TestObserver<ChecklistResponse>()

        expectedChecklist.subscribe(testObserver)

        testObserver.assertOf {
            verify(requestMapper, times(1)).transform(any())
            verify(configurationRepository, times(1)).create(any())
            verify(stepRepository, times(2)).create(any())
            verify(checklistRepository, times(1)).create(any())
        }
    }

    @Test
    fun broadcast() {
    }
}