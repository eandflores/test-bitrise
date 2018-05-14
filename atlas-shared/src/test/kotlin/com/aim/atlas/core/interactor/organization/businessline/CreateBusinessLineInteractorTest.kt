package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.mapper.organization.BusinessLineRequestMapper
import com.aim.atlas.core.mapper.organization.BusinessLineResponseMapper
import com.aim.atlas.core.repository.organization.BusinessLineRepository
import com.aim.atlas.core.specification.organization.BusinessLineSpecification
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito

class CreateBusinessLineInteractorTest {

    lateinit var interactor: CreateBusinessLineInteractor
    lateinit var repository: BusinessLineRepository
    lateinit var specification: BusinessLineSpecification

    /** Mappers **/
    lateinit var responseMapper: BusinessLineResponseMapper
    lateinit var requestMapper: BusinessLineRequestMapper


    /** Modelos/Entidades */
    lateinit var businessLine: BusinessLine
    lateinit var request: BusinessLineRequest

    @Before
    fun setUp() {
        repository = mock()
        specification = mock()

        responseMapper = mock()
        requestMapper = mock()

        request = mock()

        interactor = CreateBusinessLineInteractor(repository, specification, requestMapper, responseMapper)

        businessLine = BusinessLine(
                id = 1,
                name = "Lider",
                alias = "Laider",
                description = "Descripcion detallada sobre el business line",
                account = Account(1),
                configuration = Configuration(1)
        )
    }

    @Test
    fun createBusinessLine() {
        Mockito.`when`(specification.isSatisfiedBy(any<BusinessLine>())).thenReturn(true)
        Mockito.`when`(requestMapper.transform(any<BusinessLineRequest>())).thenReturn(businessLine)
        interactor.input(request)

        val expectedBusinessLine = interactor.execute().toFlowable()

        val testObserver = TestSubscriber<BusinessLineResponse>()
        expectedBusinessLine.subscribe(testObserver)

        testObserver.assertOf{
            verify(requestMapper, times(1)).transform(any<BusinessLineRequest>())
            verify(specification, times(1)).isSatisfiedBy(any())
            verify(repository, times(1)).create(any())
        }
    }
}