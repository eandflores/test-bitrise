package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.mapper.membership.SessionResponseMapper
import com.aim.atlas.core.repository.membership.SessionRepository
import com.aim.atlas.core.repository.membership.UserRepository
import io.reactivex.Flowable
import javax.inject.Named

@Named("get_session_by_email_and_password_interactor")
class GetSessionByEmailAndPasswordInteractor(
        private val repository: SessionRepository,
        private val responseMapper: SessionResponseMapper) : Interactor<SessionResponseModel>(), InputBoundary<SessionRequestModel, GetSessionByEmailAndPasswordInteractor> {

    private lateinit var request: SessionRequestModel

    override fun input(input: SessionRequestModel): GetSessionByEmailAndPasswordInteractor {
        request = input
        return this
    }

    override fun execute(): Flowable<SessionResponseModel> {
        return Flowable.just(request)
                .flatMap { repository.findByUsernameAndPassword(it) }
                .map { responseMapper.transform(it) }
    }

}