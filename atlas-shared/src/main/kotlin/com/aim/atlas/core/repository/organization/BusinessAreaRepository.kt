package com.aim.atlas.core.repository.organization

import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import io.reactivex.Maybe

interface BusinessAreaRepository {
    
    fun create(businessArea: BusinessArea) : Maybe<BusinessArea>

    fun update(businessArea: BusinessArea) : Maybe<BusinessArea>

    fun find(businessAreaId: Long) : Maybe<BusinessArea>

    fun findAllByAccountId(request: PaginationRequest<Long>) : Maybe<Pagination<BusinessArea>>
}
