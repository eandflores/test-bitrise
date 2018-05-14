package com.aim.atlas.core.interactor.venue.venuecategorizationadministrative

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel

@TestOpen
class VenueCategorizationAdministrativeResponse(
        val id: Long,
        val name: String,
        val businessAreaId: Long
) : ResponseModel