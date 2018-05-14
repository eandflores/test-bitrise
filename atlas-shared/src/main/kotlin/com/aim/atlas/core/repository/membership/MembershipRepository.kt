package com.aim.atlas.core.repository.membership

import com.aim.atlas.core.entity.membership.Membership
import com.aim.atlas.core.repository.Repository
import io.reactivex.Flowable

interface MembershipRepository : Repository {
    fun create(membership : Membership) : Flowable<Membership>
    fun update(membership: Membership) : Flowable<Membership>
}