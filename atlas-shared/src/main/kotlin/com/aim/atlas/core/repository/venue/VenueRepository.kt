package com.aim.atlas.core.repository.venue

import com.aim.atlas.core.entity.venue.Venue
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import io.reactivex.Flowable
import io.reactivex.Maybe

interface VenueRepository {

    /** Create new [Venue] */
    fun create(venue: Venue) : Maybe<Venue>

    /** Update an existing [Venue] */
    fun update(venue: Venue) : Maybe<Venue>

    /** Get [Venue] given id */
    fun find(id: Long) : Maybe<Venue>

    /** Get all [Venue] of a [VenueCategorizationAdministrative] */
    fun findAllByVenueCategorizationAdministrativeId(request: PaginationRequest<Long>) : Maybe<Pagination<Venue>>

    /** Get all [Venue] of a [BusinessLine] */
    fun findAllByBusinessLineId(request: PaginationRequest<Long>) : Maybe<Pagination<Venue>>

    /** Get all [Venue] of an [Account] */
    fun findAllByAccountId(request: PaginationRequest<Long>) : Maybe<Pagination<Venue>>

    /** Count all [Venue] of a [BusinessLine] */
    fun countByBusinessLine(businessLineId: Long) : Maybe<Long>
}