package com.aim.atlas.core.interactor.venue.venuecategorizationadministrative

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.venue.VenueCategorizationAdministrative
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.venue.VenueCategorizationAdministrativeRequestMapper
import com.aim.atlas.core.mapper.venue.VenueCategorizationAdministrativeResponseMapper
import com.aim.atlas.core.repository.venue.VenueCategorizationAdministrativeRepository
import com.aim.atlas.core.specification.venue.VenueCategorizationAdministrativeSpecification
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("add_venues_to_venue_categorization_administrative_interactor")
class UpdateVenueCategorizationAdministrativeInteractor(
        private val repository: VenueCategorizationAdministrativeRepository,
        private val specification: VenueCategorizationAdministrativeSpecification,
        private val requestMapper: VenueCategorizationAdministrativeRequestMapper,
        private val responseMapper: VenueCategorizationAdministrativeResponseMapper
) :
        MaybeInteractor<VenueCategorizationAdministrativeResponse>(),
        InputBoundary<VenueCategorizationAdministrativeRequest, UpdateVenueCategorizationAdministrativeInteractor>
{
    private lateinit var request: VenueCategorizationAdministrativeRequest

    override fun input(input: VenueCategorizationAdministrativeRequest): UpdateVenueCategorizationAdministrativeInteractor {
        this.request = input
        return this
    }

    override fun execute(): Maybe<VenueCategorizationAdministrativeResponse> {
        return Maybe.just(request)
                .map { requestMapper.transform(it) }
                .filter { specification.isSatisfiedBy(it) }
                .flatMap { repository.update(it) }
                .filter { specification.isSatisfiedBy(it) }
                .doOnSuccess({ broadcast(it) })
                .map { responseMapper.transform(it) }
    }

    fun broadcast(venueCategorizationAdministrative: VenueCategorizationAdministrative) {
    }

}