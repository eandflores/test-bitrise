package com.aim.atlas.core.interactor.organization.businessarea

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.organization.BusinessAreaResponseMapper
import com.aim.atlas.core.repository.organization.BusinessAreaRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Maybe
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetBusinessAreasByAccountIntercatorTest {

    private lateinit var repository: BusinessAreaRepository
    private lateinit var responseMapper: BusinessAreaResponseMapper
    private lateinit var request: PaginationRequest<Long>

    private lateinit var interactor: GetBusinessAreasByAccountIntercator

    private lateinit var businessArea: BusinessArea
    private lateinit var foundAccount: Maybe<Pagination<BusinessArea>>

    @Before
    fun setUp() {

        repository = mock()
        responseMapper = mock()
        request = mock()

        interactor = GetBusinessAreasByAccountIntercator(repository, responseMapper)

        foundAccount = mock()

        businessArea = BusinessArea(
                1,
                "Test Test Test",
                Account(1),
                listOf()
        )
    }

    @Test
    fun getBusinessAreaByAccount(){
        Mockito.`when`(repository.findAllByAccountId(any())).thenReturn(foundAccount)
        interactor.input(request)

        val expectedBusinessArea = interactor.execute().toFlowable()

        val testObserver = TestSubscriber<Pagination<BusinessAreaResponse>>()
        expectedBusinessArea.subscribe(testObserver)

        testObserver.assertOf{
            verify(repository, times(1)).findAllByAccountId(any())
        }
    }
}