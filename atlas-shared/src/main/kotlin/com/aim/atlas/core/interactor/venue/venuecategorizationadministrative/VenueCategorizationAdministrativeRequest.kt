package com.aim.atlas.core.interactor.venue.venuecategorizationadministrative

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.interactor.venue.VenueCategorizationRequest

@TestOpen
class VenueCategorizationAdministrativeRequest : VenueCategorizationRequest() {
    var administrativeDescription: String? = null
}