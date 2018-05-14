package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.mapper.organization.BusinessLineResponseMapper
import com.aim.atlas.core.repository.organization.BusinessLineRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test

class GetBusinessLineByIdInteractorTest {
    private lateinit var interactor: GetBusinessLineByIdInteractor

    private lateinit var repository: BusinessLineRepository
    private lateinit var responseMapper: BusinessLineResponseMapper

    private var request: Long = 1

    private lateinit var businessLine: BusinessLine


    @Before
    fun setUp() {
        repository = mock()
        responseMapper = mock()

        interactor = GetBusinessLineByIdInteractor(repository, responseMapper)

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
    fun getBusinessLineById(){
        interactor.input(request)

        val expectedBusinessLine = interactor.execute().toFlowable()

        val testObserver = TestSubscriber<BusinessLineResponse>()
        expectedBusinessLine.subscribe(testObserver)

        testObserver.assertOf{
            verify(repository, times(1)).find(any())
        }


    }
}