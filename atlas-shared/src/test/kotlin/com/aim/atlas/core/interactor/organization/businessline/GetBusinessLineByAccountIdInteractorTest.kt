package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.organization.BusinessLineRequestMapper
import com.aim.atlas.core.mapper.organization.BusinessLineResponseMapper
import com.aim.atlas.core.repository.organization.BusinessLineRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetBusinessLineByAccountIdInteractorTest {
    lateinit var interactor: GetBusinessLineByAccountIdInteractor
    lateinit var repository: BusinessLineRepository

    /** Mappers **/
    lateinit var responseMapper: BusinessLineResponseMapper
    lateinit var requestMapper: BusinessLineRequestMapper


    /** Modelos/Entidades */
    lateinit var businessLine: BusinessLine
    lateinit var paginationRequest: PaginationRequest<Long>
    var accountId: Long? = null

    @Before
    fun setUp() {
        repository = mock()

        responseMapper = mock()
        paginationRequest = mock()

        interactor = GetBusinessLineByAccountIdInteractor(repository, responseMapper)

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
    fun getBusinessLineByAccountId() {
        Mockito.`when`(repository.findAllByAccountId(any())).thenReturn(mock())
        interactor.input(paginationRequest)

        val expectedBusinessLine = interactor.execute().toFlowable()

        val testObserver = TestSubscriber<Pagination<BusinessLineResponse>>()
        expectedBusinessLine.subscribe(testObserver)

        testObserver.assertOf{
            verify(repository, times(1)).findAllByAccountId(any())
        }
    }
}