package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.organization.businessline.BusinessLineRequest
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class BusinessLineRequestMapper : Mapper<BusinessLineRequest, BusinessLine> {
    override fun transform(source: BusinessLineRequest) = with(source) {
        BusinessLine(
                id = id,
                name = name!!,
                alias = alias!!,
                description = description!!,
                account = Account(accountId!!),
                configuration = Configuration(configurationId!!)
        )
    }

}