package com.aim.atlas.core.specification.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.venue.Venue
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class VenueSpecification : AbstractSpecification<Venue>() {

    override fun isSatisfiedBy(candidate: Venue): Boolean {
        return true
    }
}