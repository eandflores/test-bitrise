package com.aim.atlas.core.interactor.venue.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.venue.Venue
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.venue.VenueRequestMapper
import com.aim.atlas.core.mapper.venue.VenueResponseMapper
import com.aim.atlas.core.repository.venue.VenueRepository
import com.aim.atlas.core.specification.venue.VenueSpecification
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named


@TestOpen
@Named("update_venue_interactor")
class UpdateVenueInteractor (
        private val repository : VenueRepository,
        private val specification: VenueSpecification,
        private val requestMapper: VenueRequestMapper,
        private val responseMapper: VenueResponseMapper
) :
        MaybeInteractor<VenueResponse>(),
        InputBoundary<VenueRequest, UpdateVenueInteractor> {

    private lateinit var request : VenueRequest

    override fun input(input: VenueRequest): UpdateVenueInteractor {
        this.request = input
        return this
    }

    override fun execute(): Maybe<VenueResponse> {
        return Maybe.just(request)
                .map { requestMapper.transform(it) }
                .filter { specification.isSatisfiedBy(it) }
                .flatMap { repository.create(it) }
                .filter { specification.isSatisfiedBy(it) }
                .doOnSuccess{ broadcast(it) }
                .map { responseMapper.transform(it) }
    }

    fun broadcast(venue: Venue) {
    }

}