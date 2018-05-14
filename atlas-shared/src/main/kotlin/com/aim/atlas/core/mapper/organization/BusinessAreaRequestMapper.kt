package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.interactor.organization.businessarea.BusinessAreaRequest
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class BusinessAreaRequestMapper: Mapper<BusinessAreaRequest, BusinessArea> {
    override fun transform(source: BusinessAreaRequest) =
            with(source){
                BusinessArea(
                        id = id,
                        name = name!!,
                        account = Account(accountId!!),
                        businessLine = businessLinesIds.map { BusinessLine(it) }
                )
            }

}
