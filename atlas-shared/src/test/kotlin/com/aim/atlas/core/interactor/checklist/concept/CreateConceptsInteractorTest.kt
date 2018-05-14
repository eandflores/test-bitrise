package com.aim.atlas.core.interactor.checklist.concept

import com.aim.atlas.core.entity.checklist.Concept
import com.aim.atlas.core.entity.checklist.Label
import com.aim.atlas.core.interactor.checklist.label.LabelRequest
import com.aim.atlas.core.interactor.checklist.label.LabelResponse
import com.aim.atlas.core.mapper.checklist.ConceptRequestMapper
import com.aim.atlas.core.mapper.checklist.ConceptResponseMapper
import com.aim.atlas.core.repository.checklist.ConceptRepository
import com.aim.atlas.core.repository.checklist.LabelRepository
import com.aim.atlas.core.specification.checklist.ConceptSpecification
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Maybe
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CreateConceptsInteractorTest {
    /* Interactor */
    lateinit var interactor: CreateConceptsInteractor

    /* Specification */
    lateinit var specification: ConceptSpecification

    /* Repositories */
    lateinit var conceptRepository: ConceptRepository
    lateinit var labelRepository: LabelRepository

    /* Mappers */
    lateinit var mapper: ConceptRequestMapper
    lateinit var responseMapper: ConceptResponseMapper

    /* Entities */
    lateinit var request: CreateConceptsRequest
    lateinit var response: List<ConceptResponse>
    lateinit var concepts: List<Concept>
    lateinit var dbConcepts: List<Concept>

    @Before
    fun setUp() {
        conceptRepository = mock()
        labelRepository = mock()
        specification = mock()
        mapper = mock()
        responseMapper = mock()

        interactor = CreateConceptsInteractor(conceptRepository, labelRepository, specification, mapper, responseMapper)

        request = CreateConceptsRequest().apply {
            checklistId = 1
            concepts = listOf(
                    ConceptRequest().apply {
                        name = "Plagas"
                        color = "AA0000"
                        isPonderated = true
                        labels = listOf(
                                LabelRequest().apply {
                                    name = "Ratones"
                                    place = 1
                                },
                                LabelRequest().apply {
                                    name = "Palomas"
                                    place = 2
                                }
                        )
                    }
            )
        }

        concepts = listOf(
                Concept().apply {
                    name = "Plagas"
                    color = "AA0000"
                    isPonderated = true
                    labels = listOf(
                            Label().apply {
                                name = "Ratones"
                                place = 1
                            },
                            Label().apply {
                                name = "Palomas"
                                place = 2
                            }
                    )
                }
        )

        dbConcepts = listOf(
                Concept(1).apply {
                    name = "Plagas"
                    color = "AA0000"
                    isPonderated = true
                    labels = listOf(
                            Label(1).apply {
                                name = "Ratones"
                                place = 1
                            },
                            Label(2).apply {
                                name = "Palomas"
                                place = 2
                            }
                    )
                }
        )

        response = listOf(
                ConceptResponse(
                        1,
                        "Plagas",
                        "#AA0000",
                        true,
                        listOf(
                                LabelResponse(
                                        1,
                                        "Ratones",
                                        1,
                                        0F
                                )
                        )
                )
        )
    }

    @Test
    fun execute() {
        Mockito.`when`(mapper.transform(request.concepts[0])).thenReturn(concepts[0])
        Mockito.`when`(specification.isSatisfiedBy(any())).thenReturn(true)
        Mockito.`when`(labelRepository.create(concepts[0].labels!![0])).thenReturn(Maybe.just(dbConcepts[0].labels!![0]))
        Mockito.`when`(labelRepository.create(concepts[0].labels!![1])).thenReturn(Maybe.just(dbConcepts[0].labels!![1]))
        Mockito.`when`(conceptRepository.create(concepts[0])).thenReturn(Maybe.just(dbConcepts[0]))
        Mockito.`when`(responseMapper.transform(dbConcepts[0])).thenReturn(response[0])

        interactor.input(request)

        val expectedResponse = interactor.execute()
        val testObserver = TestObserver<List<ConceptResponse>>()

        expectedResponse.subscribe(testObserver)

        testObserver.assertOf {
            verify(mapper, times(1)).transform(request.concepts[0])
            verify(specification, times(1)).isSatisfiedBy(any())
            verify(labelRepository, times(2)).create(any())
            verify(conceptRepository, times(1)).create(any())
            verify(responseMapper, times(1)).transform(dbConcepts[0])
        }
    }
}