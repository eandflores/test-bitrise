package com.aim.atlas.core.mapper.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.entity.venue.Venue
import com.aim.atlas.core.entity.venue.VenueCategorizationAdministrative
import com.aim.atlas.core.interactor.venue.venuecategorizationadministrative.VenueCategorizationAdministrativeRequest
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class VenueCategorizationAdministrativeRequestMapper :
        Mapper<VenueCategorizationAdministrativeRequest, VenueCategorizationAdministrative> {

    override fun transform(source: VenueCategorizationAdministrativeRequest): VenueCategorizationAdministrative {
        return with(source) {
            VenueCategorizationAdministrative(
                    id = id,
                    name = name!!,
                    account = Account(accountId!!),
                    businessArea = BusinessArea(businessAreaId!!),
                    venues = venues!!.map { Venue(it) },
                    administrativeDescription = "Reemplazar esto" //TODO: Esto es sólo una prueba de cómo quedaría ésto
            )
        }
    }
}