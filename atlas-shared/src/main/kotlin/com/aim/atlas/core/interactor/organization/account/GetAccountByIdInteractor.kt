package com.aim.atlas.core.interactor.organization.account

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.AccountResponseMapper
import com.aim.atlas.core.repository.organization.AccountRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject
import javax.inject.Named

@TestOpen
@Named("get_account_by_id")
class GetAccountByIdInteractor(
        @Inject private val repository: AccountRepository,
        @Inject private val responseMapper: AccountResponseMapper
) :
        MaybeInteractor<AccountResponse>(),
        InputBoundary<Long, GetAccountByIdInteractor> {
    override fun input(input: Long): GetAccountByIdInteractor {
        request = input
        return this
    }

    private var request: Long = 0

    override fun execute(): Maybe<AccountResponse> {
        return Maybe.just(request)
                .flatMap { repository.find(it) }
                .map { responseMapper.transform(it) }
    }
}