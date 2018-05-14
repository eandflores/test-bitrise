package com.aim.atlas.core.entity.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessArea

@TestOpen
class VenueCategorizationAdministrative(id: Long): VenueCategorization(id) {
    final var administrativeDescription: String? = null

    constructor(id: Long, name: String, account: Account, venues: List<Venue>, businessArea: BusinessArea, administrativeDescription: String): this(id){
        this.name = name
        this.account = account
        this.venues = venues
        this.businessArea = businessArea
        this.administrativeDescription = administrativeDescription;
    }
}
