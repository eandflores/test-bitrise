package com.aim.atlas.core.interactor.venue.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.venue.VenueResponseMapper
import com.aim.atlas.core.repository.venue.VenueRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_venue_by_id_interactor")
class GetVenueByIdInteractor (
        private val repository : VenueRepository,
        private val responseMapper: VenueResponseMapper
) :
        MaybeInteractor<VenueResponse>(),
        InputBoundary<Long, GetVenueByIdInteractor> {

    private var request: Long = 0L

    override fun input(input: Long): GetVenueByIdInteractor {
        this.request = input
        return this
    }

    override fun execute(): Maybe<VenueResponse> {
        return Maybe.just(request)
                .flatMap { repository.find(it) }
                .map { responseMapper.transform(it) }
    }
}