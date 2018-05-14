package com.aim.atlas.core.interactor.venue.venuecategorizationadministrative

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.venue.VenueCategorizationAdministrativeResponseMapper
import com.aim.atlas.core.repository.venue.VenueCategorizationAdministrativeRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_venue_categorization_administrative_by_id_interactor")
class GetVenueCategorizationAdministrativeByIdInteractor(
        private val repository: VenueCategorizationAdministrativeRepository,
        private val responseMapper: VenueCategorizationAdministrativeResponseMapper
) :
        MaybeInteractor<VenueCategorizationAdministrativeResponse>(),
        InputBoundary<Long, GetVenueCategorizationAdministrativeByIdInteractor>
{

    private var request: Long = 0L

    override fun input(input: Long): GetVenueCategorizationAdministrativeByIdInteractor {
        this.request = input
        return this
    }

    override fun execute(): Maybe<VenueCategorizationAdministrativeResponse> {
        return Maybe.just(request)
                .flatMap { repository.find(it) }
                .map { responseMapper.transform(it) }
    }

}