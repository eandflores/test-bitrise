package com.aim.atlas.core.interactor.venue.venuecategorizationadministrative

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.venue.VenueCategorizationAdministrativeResponseMapper
import com.aim.atlas.core.repository.venue.VenueCategorizationAdministrativeRepository
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_venue_categorization_administrative_by_venue_id")
class GetVenueCategorizationAdministrativeByVenueIdInteractor(
        private val repository: VenueCategorizationAdministrativeRepository,
        private val responseMapper: VenueCategorizationAdministrativeResponseMapper
) :
        MaybeInteractor<Pagination<VenueCategorizationAdministrativeResponse>>(),
        InputBoundary<PaginationRequest<Long>, GetVenueCategorizationAdministrativeByVenueIdInteractor>
{

    private lateinit var request: PaginationRequest<Long>

    override fun input(input: PaginationRequest<Long>): GetVenueCategorizationAdministrativeByVenueIdInteractor {
        this.request = input
        return this
    }

    override fun execute(): Maybe<Pagination<VenueCategorizationAdministrativeResponse>> {
        return repository.findAllByBusinessAreaId(request)
                .map{ responseMapper.transform(it)}
    }

}