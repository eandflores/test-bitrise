package com.aim.atlas.core.interactor.venue

import com.aim.atlas.core.boundary.RequestModel

open class VenueCategorizationRequest: RequestModel{
    var id: Long = 0L
    var name: String? = null
    var businessAreaId: Long? = null
    var accountId: Long? = null
    var venues: List<Long>? = null
}