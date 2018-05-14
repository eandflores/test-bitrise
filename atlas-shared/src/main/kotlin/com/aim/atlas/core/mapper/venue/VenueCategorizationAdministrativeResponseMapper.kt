package com.aim.atlas.core.mapper.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.venue.VenueCategorizationAdministrative
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.venue.venuecategorizationadministrative.VenueCategorizationAdministrativeResponse
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class VenueCategorizationAdministrativeResponseMapper :
        Mapper<VenueCategorizationAdministrative,VenueCategorizationAdministrativeResponse>,
        ListMapper<VenueCategorizationAdministrative, VenueCategorizationAdministrativeResponse>,
        PaginationMapper<VenueCategorizationAdministrative, VenueCategorizationAdministrativeResponse> {

    override fun transform(source: List<VenueCategorizationAdministrative>): List<VenueCategorizationAdministrativeResponse> {
        return source.map { this.transform(it) }
    }

    override fun transform(source: Pagination<VenueCategorizationAdministrative>): Pagination<VenueCategorizationAdministrativeResponse> {
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

    override fun transform(source: VenueCategorizationAdministrative): VenueCategorizationAdministrativeResponse {
        return with(source) {
            VenueCategorizationAdministrativeResponse(
                    id = id,
                    name = name!!,
                    businessAreaId = businessArea!!.id
            )
        }
    }

}