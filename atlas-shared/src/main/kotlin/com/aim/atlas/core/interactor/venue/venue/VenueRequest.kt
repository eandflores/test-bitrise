package com.aim.atlas.core.interactor.venue.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class VenueRequest : RequestModel {
    var id: Long = 0L
    var name: String? = null
    var alias: String? = null
    var code: String? = null
    var address: String? = null
    var locale: String? = null
    var timeZone: String? = null
    var picture: String? = null
    var businessLineId: Long? = null
    var accountId: Long? = null
}