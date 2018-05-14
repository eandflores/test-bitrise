package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.organization.businessarea.BusinessAreaResponse
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class BusinessAreaResponseMapper:
        Mapper<BusinessArea, BusinessAreaResponse>,
        PaginationMapper<BusinessArea, BusinessAreaResponse>,
        ListMapper<BusinessArea, BusinessAreaResponse> {

    override fun transform(source: List<BusinessArea>): List<BusinessAreaResponse> =
            source.map{ transform(it) }

    override fun transform(source: Pagination<BusinessArea>): Pagination<BusinessAreaResponse> =
            with(source){
                Pagination(
                        root = transform(root),
                        size = source.size,
                        page = source.page,
                        place = source.place,
                        totalElements = source.totalElements,
                        totalPages = source.totalPages
                )
            }

    override fun transform(source: BusinessArea): BusinessAreaResponse =
        with(source){
            BusinessAreaResponse(
                    id = id,
                    name = name!!,
                    accountId = account!!.id,
                    businessLinesIds = businessLines!!.map { it.id }
            )
        }
}
