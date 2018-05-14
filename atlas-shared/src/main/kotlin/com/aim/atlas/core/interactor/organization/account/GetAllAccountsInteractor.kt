package com.aim.atlas.core.interactor.organization.account

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.AccountResponseMapper
import com.aim.atlas.core.repository.organization.AccountRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject
import javax.inject.Named

@TestOpen
@Named("get_all_accounts")
class GetAllAccountsInteractor(
        @Inject private val repository: AccountRepository,
        @Inject private val responseMapper: AccountResponseMapper
) :
        MaybeInteractor<List<AccountResponse>>() {
    override fun execute(): Maybe<List<AccountResponse>> {
        return repository.all()
                .map { responseMapper.transform(it) }
    }
}