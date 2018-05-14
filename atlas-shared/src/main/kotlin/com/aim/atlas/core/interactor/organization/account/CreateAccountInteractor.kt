package com.aim.atlas.core.interactor.organization.account

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.AccountResponseMapper
import com.aim.atlas.core.mapper.organization.CreateAccountRequestMapper
import com.aim.atlas.core.repository.organization.AccountRepository
import com.aim.atlas.core.specification.organization.AccountSpecification
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("account")
class CreateAccountInteractor(
        private val repository: AccountRepository,
        private val specification: AccountSpecification,
        private val requestMapperCreate: CreateAccountRequestMapper,
        private val responseMapper: AccountResponseMapper
) :
        MaybeInteractor<AccountResponse>(),
        InputBoundary<CreateAccountRequest, CreateAccountInteractor> {

    private lateinit var request: CreateAccountRequest

    override fun input(input: CreateAccountRequest): CreateAccountInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<AccountResponse> {
        return Maybe.just(request)
                .map { requestMapperCreate.transform(it) }
                .filter { specification.isSatisfiedBy(it) }
                .flatMap { repository.create(it) }
                .filter { specification.isSatisfiedBy(it) }
                .doOnSuccess({ broadcast(it) })
                .map { responseMapper.transform(it) }
    }

    fun broadcast(account: Account) {

    }

}