package com.aim.atlas.core.interactor.venue.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.venue.VenueResponseMapper
import com.aim.atlas.core.repository.venue.VenueRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_venue_by_account_id_interactor")
class GetVenueByAccountIdInteractor(
        private val repository: VenueRepository,
        private val responseMapper: VenueResponseMapper
) :
        MaybeInteractor<Pagination<VenueResponse>>(),
        InputBoundary<PaginationRequest<Long>, GetVenueByAccountIdInteractor>
{

    private lateinit var request: PaginationRequest<Long>

    override fun input(input: PaginationRequest<Long>): GetVenueByAccountIdInteractor {
        this.request = input
        return this
    }

    override fun execute(): Maybe<Pagination<VenueResponse>> {
        return repository.findAllByAccountId(request)
                .map{ responseMapper.transform(it)}
    }

}