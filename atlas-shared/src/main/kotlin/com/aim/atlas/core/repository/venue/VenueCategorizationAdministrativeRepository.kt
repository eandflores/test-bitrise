package com.aim.atlas.core.repository.venue

import com.aim.atlas.core.entity.venue.VenueCategorizationAdministrative
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import io.reactivex.Maybe

interface VenueCategorizationAdministrativeRepository {

    /** Create a [VenueCategorizationAdministrative] */
    fun create(venueCategorization: VenueCategorizationAdministrative) : Maybe<VenueCategorizationAdministrative>

    /** Updates a [VenueCategorizationAdministrative] */
    fun update(venueCategorization: VenueCategorizationAdministrative) : Maybe<VenueCategorizationAdministrative>

    /** Get [VenueCategorizationAdministrative] given id */
    fun find(id: Long) : Maybe<VenueCategorizationAdministrative>

    /** Get All [VenueCategorizationAdministrative] of an [Account] */
    fun findAllByAccountId(request: PaginationRequest<Long>) : Maybe<Pagination<VenueCategorizationAdministrative>>

    /** Get all [VenueCategorizationAdministrative] of a [BusinessArea] */
    fun findAllByBusinessAreaId(request: PaginationRequest<Long>) : Maybe<Pagination<VenueCategorizationAdministrative>>

    /** Get all [VenueCategorizationAdministrative] of a [Venue] */
    fun findAllByVenueId(request: PaginationRequest<Long>): Maybe<Pagination<VenueCategorizationAdministrative>>
}