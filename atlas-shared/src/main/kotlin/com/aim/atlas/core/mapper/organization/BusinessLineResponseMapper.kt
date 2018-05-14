package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.interactor.organization.businessline.BusinessLineResponse
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class BusinessLineResponseMapper :
        Mapper<BusinessLine, BusinessLineResponse>,
        PaginationMapper<BusinessLine, BusinessLineResponse>,
        ListMapper<BusinessLine, BusinessLineResponse> {

    override fun transform(source: Pagination<BusinessLine>): Pagination<BusinessLineResponse> {
        return Pagination(
                root = this.transform(source.root),
                size = source.size,
                page = source.page,
                place = source.place,
                totalElements = source.totalElements,
                totalPages = source.totalPages
        )
    }

    override fun transform(source: List<BusinessLine>): List<BusinessLineResponse> {
        return source.map { this.transform(it) }
    }

    override fun transform(source: BusinessLine): BusinessLineResponse {
        return BusinessLineResponse(
                id = source.id,
                name = source.name!!,
                alias = source.alias!!,
                description = source.description!!,
                accountId = source.account!!.id,
                configurationId = source.configuration!!.id
        )
    }
}