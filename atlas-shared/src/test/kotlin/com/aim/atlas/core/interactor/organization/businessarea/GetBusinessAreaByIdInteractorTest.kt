package com.aim.atlas.core.interactor.organization.businessarea

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.mapper.organization.BusinessAreaResponseMapper
import com.aim.atlas.core.repository.organization.BusinessAreaRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test

class GetBusinessAreaByIdInteractorTest {

    private lateinit var interactor: GetBusinessAreaByIdInteractor

    private lateinit var repository: BusinessAreaRepository
    private lateinit var responseMapper: BusinessAreaResponseMapper

    private var request: Long = 1

    private lateinit var businessArea: BusinessArea


    @Before
    fun setUp() {
        repository = mock()
        responseMapper = mock()

        interactor = GetBusinessAreaByIdInteractor(repository, responseMapper)

        businessArea = BusinessArea(
                1,
                "Test Test Test",
                Account(request),
                listOf()
        )
    }

    @Test
    fun getBusinessAreaById(){
        interactor.input(request)

        val expectedBusinessArea = interactor.execute().toFlowable()

        val testObserver = TestSubscriber<BusinessAreaResponse>()
        expectedBusinessArea.subscribe(testObserver)

        testObserver.assertOf{
            verify(repository, times(1)).find(any())
        }


    }
}