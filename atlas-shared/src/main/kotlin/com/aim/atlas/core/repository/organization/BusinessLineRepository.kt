package com.aim.atlas.core.repository.organization

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.repository.Repository
import io.reactivex.Flowable
import io.reactivex.Maybe

interface BusinessLineRepository : Repository {

    /** Create new [BusinessLine] */
    fun create(businessLine: BusinessLine) : Maybe<BusinessLine>

    /** Update an existing [BusinessLine] */
    fun update(businessLine: BusinessLine) : Maybe<BusinessLine>

    /** Get one [BusinessLine] from its id */
    fun find(businessLineId: Long) : Maybe<BusinessLine>

    /** Get all [BusinessLine] of an [Account] */
    fun findAllByAccountId(request: PaginationRequest<Long>) : Maybe<Pagination<BusinessLine>>

    fun findAllByBusinessArea(request: PaginationRequest<List<Long>>): Maybe<Pagination<BusinessLine>>
}