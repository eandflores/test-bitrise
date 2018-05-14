package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.boundary.ResponseModel
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.membership.UserResponseMapper
import com.aim.atlas.core.repository.membership.UserRepository
import io.reactivex.Maybe
import javax.inject.Inject
import javax.inject.Named

@Named("get_all_users_by_account_id")
class GetAllUsersByAccountIdInteractor(
    @Inject private val repository: UserRepository,
    @Inject private val responseMapper: UserResponseMapper) :
        MaybeInteractor<List<ResponseModel>>(), InputBoundary<Long, GetAllUsersByAccountIdInteractor> {

    private var request: Long = 0

    override fun input(input: Long): GetAllUsersByAccountIdInteractor {
       request = input
        return this
    }

    override fun execute(): Maybe<List<ResponseModel>> {
        return repository.findAllByAccountId(request)
                .map { responseMapper.transform(it) }
    }
}
