package com.aim.atlas.core.entity.membership

data class Membership (val id: Long){

    var accountId: Long? = null
    var user: User? = null
    var status: MembershipStatus = MembershipStatus.PENDING
    var memberType: MemberType  = MemberType.VIEWER

    constructor(id: Long,
                 user: User,
                 accountId: Long,
                 status: MembershipStatus,
                 memberType: MemberType) : this(id){
        this.id
        this.user = user
        this.accountId = accountId
        this.status = status
        this.memberType = memberType
    }

}
