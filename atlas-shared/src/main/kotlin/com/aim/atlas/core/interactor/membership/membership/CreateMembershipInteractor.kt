package com.aim.atlas.core.interactor.membership.membership

import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.membership.Membership
import com.aim.atlas.core.entity.membership.MembershipStatus
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.mapper.membership.MembershipRequestMapper
import com.aim.atlas.core.mapper.membership.MembershipResponseMapper
import com.aim.atlas.core.repository.membership.MembershipRepository
import com.aim.atlas.core.specification.membership.MembershipSpecification
import io.reactivex.Flowable
import javax.inject.Named

@Named("create_membership_interactor")
class CreateMembershipInteractor(
         private val repository: MembershipRepository,
         private val specification: MembershipSpecification,
         private val requestMapper: MembershipRequestMapper,
         private val responseMapper: MembershipResponseMapper) :
        Interactor<MembershipResponse>(), InputBoundary<MembershipRequest, CreateMembershipInteractor> {

    private lateinit var request : MembershipRequest

    override fun execute(): Flowable<MembershipResponse> {
        return Flowable.just(request)
                .map { requestMapper.transform(it) }
                .filter{ specification.isSatisfiedBy(it) }
                .flatMap { repository.create(it) }
                .doOnNext({ broadcast(it) })
                .map { responseMapper.transform(it) }
    }

    override fun input(input: MembershipRequest): CreateMembershipInteractor {
        request = input
        return this
    }

    fun broadcast(user: Membership) {

    }

}