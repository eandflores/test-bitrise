package com.aim.atlas.core.repository.membership

import com.aim.atlas.core.entity.membership.User
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.repository.Repository
import io.reactivex.Flowable
import io.reactivex.Maybe

interface UserRepository : Repository {
    fun create(user: User) : Flowable<User>

    fun update(user: User) : Flowable<User>

    fun findById(userId: Long) : Flowable<User>

    fun all(request: PaginationRequest<Long>) : Flowable<Pagination<User>>

    fun findAllByAccountId(request: Long) : Maybe<List<User>>
}
