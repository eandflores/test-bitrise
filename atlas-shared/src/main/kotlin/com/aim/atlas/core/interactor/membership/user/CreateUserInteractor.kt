package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.membership.User
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.mapper.membership.UserRequestMapper
import com.aim.atlas.core.mapper.membership.UserResponseMapper
import com.aim.atlas.core.repository.membership.UserRepository
import com.aim.atlas.core.specification.membership.UserSpecification
import io.reactivex.Flowable
import javax.inject.Named

@Named("create_user_interactor")
class CreateUserInteractor(
        private val repository: UserRepository,
        private val specification: UserSpecification,
        private val requestMapper: UserRequestMapper,
        private val responseMapper: UserResponseMapper) : Interactor<UserResponseModel>(), InputBoundary<UserRequestModel, CreateUserInteractor> {

    private lateinit var request: UserRequestModel

    override fun input(input: UserRequestModel): CreateUserInteractor {
        request = input
        return this
    }

    override fun execute(): Flowable<UserResponseModel> {
        return Flowable.just(request)
                .map { requestMapper.transform(it) }
                .filter { specification.isSatisfiedBy(it) }
                .flatMap { repository.create(it) }
                .doOnNext({ broadcast(it) })
                .map { responseMapper.transform(it) }
    }

    fun broadcast(user: User) {

    }
}
