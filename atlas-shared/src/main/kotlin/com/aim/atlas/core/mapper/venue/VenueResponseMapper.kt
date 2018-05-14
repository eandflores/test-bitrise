package com.aim.atlas.core.mapper.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.venue.Venue
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.venue.venue.VenueResponse
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class VenueResponseMapper :
        Mapper<Venue, VenueResponse>,
        ListMapper<Venue, VenueResponse>,
        PaginationMapper<Venue, VenueResponse> {

    override fun transform(source: List<Venue>): List<VenueResponse> {
        return source.map { this.transform(it) }
    }

    override fun transform(source: Pagination<Venue>): Pagination<VenueResponse> {
        return with(source) {
            Pagination(
                    root = transform(root),
                    size = source.size,
                    page = source.page,
                    place = source.place,
                    totalElements = source.totalElements,
                    totalPages = source.totalPages
            )
        }
    }

    override fun transform(source: Venue): VenueResponse {
        return with(source) {
            VenueResponse(
                    id = id,
                    name = name!!,
                    alias = alias!!,
                    code = code!!,
                    address = address!!,
                    locale = locale!!,
                    timeZone = timeZone!!,
                    picture = picture!!,
                    businessLineId = businessLine!!.id,
                    accountId = account!!.id
            )
        }
    }
}