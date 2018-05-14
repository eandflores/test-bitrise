package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.mapper.membership.UserResponseMapper
import com.aim.atlas.core.repository.membership.UserRepository
import io.reactivex.Flowable
import javax.inject.Named

@Named("find_user_by_id")
class UserFindByIdInteractor(
        private val repository: UserRepository,
        private val responseMapper: UserResponseMapper) : Interactor<UserResponseModel>(), InputBoundary<Long, UserFindByIdInteractor> {

    private var request: Long = 0

    override fun input(input: Long): UserFindByIdInteractor {
        request = input
        return this
    }

    override fun execute(): Flowable<UserResponseModel> {
        return Flowable.just(request)
                .flatMap { repository.findById(it) }
                .map { responseMapper.transform(it) }
    }

}