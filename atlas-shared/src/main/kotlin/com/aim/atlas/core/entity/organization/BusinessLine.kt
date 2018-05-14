package com.aim.atlas.core.entity.organization

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
class BusinessLine (val id : Long) {
    final var name : String? = null
    final var alias : String? = null
    final var description : String? = null
    final var account : Account? = null
    final var configuration : Configuration? = null
    //final var venues: List<Venue>? = null

    constructor(id: Long, name: String, alias: String, description: String, account: Account, configuration: Configuration/*, venues: List<Venue>*/) : this(id) {
        this.name = name
        this.alias = alias
        this.description = description
        this.account = account
        this.configuration = configuration
       // this.venues = venues
    }
}
