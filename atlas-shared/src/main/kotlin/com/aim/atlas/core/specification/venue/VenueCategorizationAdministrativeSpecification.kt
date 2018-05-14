package com.aim.atlas.core.specification.venue

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.venue.VenueCategorizationAdministrative
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class VenueCategorizationAdministrativeSpecification : AbstractSpecification<VenueCategorizationAdministrative>() {
    override fun isSatisfiedBy(candidate: VenueCategorizationAdministrative): Boolean {
        return true
    }
}