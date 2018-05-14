package com.aim.atlas.core.interactor.organization.account

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.mapper.organization.AccountResponseMapper
import com.aim.atlas.core.mapper.organization.CreateAccountRequestMapper
import com.aim.atlas.core.repository.organization.AccountRepository
import com.aim.atlas.core.specification.organization.AccountSpecification
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CreateAccountInteractorTest {

    lateinit var createCreateAccountInteractor: CreateAccountInteractor
    lateinit var repository: AccountRepository
    lateinit var specification: AccountSpecification
    lateinit var requestMapperCreate: CreateAccountRequestMapper
    lateinit var responseMapper: AccountResponseMapper
    lateinit var requestModel: CreateAccountRequest
    lateinit var account: Account
    lateinit var accountResponse: AccountResponse


    @Before
    fun setUp() {
        /** Init mocks */
        repository = mock<AccountRepository>()
        specification = mock<AccountSpecification>()
        requestMapperCreate = mock<CreateAccountRequestMapper>()
        responseMapper = mock<AccountResponseMapper>()
        requestModel = mock<CreateAccountRequest>()
        accountResponse = mock<AccountResponse>()

        createCreateAccountInteractor = CreateAccountInteractor(
                repository = repository,
                specification = specification,
                requestMapperCreate = requestMapperCreate,
                responseMapper = responseMapper)

        account = Account(0L, "2121", "smu", "SMU")

    }

    @Test
    fun succesCreation() {
        Mockito.`when`(specification.isSatisfiedBy(any<Account>())).thenReturn(true)
        Mockito.`when`(requestMapperCreate.transform(any<CreateAccountRequest>())).thenReturn(account)
        createCreateAccountInteractor.input(requestModel)

        // Execution
        val expectedAccount = createCreateAccountInteractor.execute().toFlowable()

        val testObserver = TestSubscriber<AccountResponse>()
        expectedAccount.subscribe(testObserver)

        testObserver.assertOf {
            verify(requestMapperCreate, times(1)).transform(any<CreateAccountRequest>())
            verify(specification, times(1)).isSatisfiedBy(any<Account>())
            verify(repository, times(1)).create(any<Account>())
        }
        // Assertions

    }
}