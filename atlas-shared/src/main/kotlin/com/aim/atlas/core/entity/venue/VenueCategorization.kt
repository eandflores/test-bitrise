package com.aim.atlas.core.entity.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessArea

@TestOpen
class VenueCategorization(val id: Long){
    final var businessArea: BusinessArea? = null
    final var name: String? = null
    final var account: Account? = null
    final var venues: List<Venue>? = null

    constructor(id: Long, name: String, account: Account, venues: List<Venue>, businessArea: BusinessArea) : this(id) {
        this.name = name
        this.account = account
        this.venues = venues
        this.businessArea = businessArea
    }
}
