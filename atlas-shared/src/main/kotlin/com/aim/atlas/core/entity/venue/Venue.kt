package com.aim.atlas.core.entity.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.entity.organization.BusinessLine

@TestOpen
class Venue(val id: Long) {
    final var name: String? = null
    final var alias: String? = null
    final var code: String? = null
    final var address: String? = null
    final var locale: String? = null
    final var timeZone: String? = null
    final var picture: String? = null
    final var businessLine: BusinessLine? = null
    final var account: Account? = null

    constructor(
            id: Long,
            name: String,
            alias: String,
            code: String,
            address: String,
            locale: String,
            timeZone: String,
            picture: String,
            businessLine: BusinessLine,
            account: Account
    ) :
            this(id) {

        this.name = name
        this.alias = alias
        this.code = code
        this.address = address
        this.locale = locale
        this.timeZone = timeZone
        this.picture = picture
        this.businessLine = businessLine
        this.account = account
    }
}