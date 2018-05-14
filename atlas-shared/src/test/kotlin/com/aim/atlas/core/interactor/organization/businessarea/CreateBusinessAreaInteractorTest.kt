package com.aim.atlas.core.interactor.organization.businessarea

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.mapper.organization.BusinessAreaRequestMapper
import com.aim.atlas.core.mapper.organization.BusinessAreaResponseMapper
import com.aim.atlas.core.repository.organization.BusinessAreaRepository
import com.aim.atlas.core.specification.organization.BusinessAreaSpecification
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CreateBusinessAreaInteractorTest {

    lateinit var interactor: CreateBusinessAreaInteractor

    lateinit var repository: BusinessAreaRepository
    lateinit var specification: BusinessAreaSpecification

    /** Mappers **/
    lateinit var responseMapper: BusinessAreaResponseMapper
    lateinit var requestMapper: BusinessAreaRequestMapper


    /** Modelos/Entidades */
    lateinit var businessArea: BusinessArea
    lateinit var request: BusinessAreaRequest

    @Before
    fun setUp() {
        repository = mock()
        specification = mock()

        responseMapper = mock()
        requestMapper = mock()

        request = mock()

        interactor = CreateBusinessAreaInteractor(
                repository,
                requestMapper,
                specification,
                responseMapper
        )

        businessArea = BusinessArea(
                1,
                "Test Test Test",
                Account(1),
                listOf()
        )
    }

    @Test
    fun createBusinessArea(){
        Mockito.`when`(specification.isSatisfiedBy(any<BusinessArea>())).thenReturn(true)
        Mockito.`when`(requestMapper.transform(any<BusinessAreaRequest>())).thenReturn(businessArea)
        interactor.input(request)

        val expectedBusinessArea = interactor.execute().toFlowable()

        val testObserver = TestSubscriber<BusinessAreaResponse>()
        expectedBusinessArea.subscribe(testObserver)

        testObserver.assertOf{
            verify(requestMapper, times(1)).transform(any<BusinessAreaRequest>())
            verify(specification, times(1)).isSatisfiedBy(any())
            verify(repository, times(1)).create(any())
        }
    }
}