package com.aim.atlas.core.interactor.venue.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel

@TestOpen
class VenueResponse(
        val id: Long,
        val name: String,
        val alias: String,
        val code: String,
        val address: String,
        val locale: String,
        val timeZone: String,
        val picture: String,
        val businessLineId: Long,
        val accountId: Long
) : ResponseModel