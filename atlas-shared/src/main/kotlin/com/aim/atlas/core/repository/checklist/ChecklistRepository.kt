package com.aim.atlas.core.repository.checklist

import com.aim.atlas.core.entity.checklist.Checklist
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import io.reactivex.Flowable
import io.reactivex.Maybe

interface ChecklistRepository{
    fun create(checklist: Checklist): Maybe<Checklist>

    fun update(checklist: Checklist): Flowable<Checklist>

    fun find(id: Long): Maybe<Checklist>

    fun findByAccountId(request: PaginationRequest<Long>): Flowable<Pagination<Checklist>>
}
