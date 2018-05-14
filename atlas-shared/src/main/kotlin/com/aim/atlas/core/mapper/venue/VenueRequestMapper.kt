package com.aim.atlas.core.mapper.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.entity.venue.Venue
import com.aim.atlas.core.interactor.venue.venue.VenueRequest
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class VenueRequestMapper : Mapper<VenueRequest, Venue> {

    override fun transform(source: VenueRequest): Venue {
        return with(source) {
            Venue(
                    id = id,
                    name = name!!,
                    alias = alias!!,
                    code = code!!,
                    address = address!!,
                    locale = locale!!,
                    timeZone = timeZone!!,
                    picture = picture!!,
                    businessLine = BusinessLine(businessLineId!!),
                    account = Account(accountId!!)
            )
        }
    }
}