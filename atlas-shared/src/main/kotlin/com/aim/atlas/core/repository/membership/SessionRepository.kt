package com.aim.atlas.core.repository.membership

import com.aim.atlas.core.entity.membership.Session
import com.aim.atlas.core.interactor.membership.user.SessionRequestModel
import com.aim.atlas.core.repository.Repository
import io.reactivex.Flowable

interface SessionRepository : Repository {

    fun findByUsernameAndPassword(request: SessionRequestModel) : Flowable<Session>

}
