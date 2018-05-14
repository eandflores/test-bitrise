package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.membership.UserResponseMapper
import com.aim.atlas.core.repository.membership.UserRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Named

@Named("get_all_user_interactor")
class GetAllUsersInteractor(
        @Inject private val repository: UserRepository,
        @Inject private val responseMapper: UserResponseMapper
) : Interactor<Pagination<UserResponseModel>>(), InputBoundary<PaginationRequest<Long>, GetAllUsersInteractor> {
    private lateinit var request: PaginationRequest<Long>

    override fun input(input: PaginationRequest<Long>): GetAllUsersInteractor {
        request = input
        return this
    }

    override fun execute(): Flowable<Pagination<UserResponseModel>> {
        return repository.all(request)
                .map { responseMapper.transform(it) }
    }
}