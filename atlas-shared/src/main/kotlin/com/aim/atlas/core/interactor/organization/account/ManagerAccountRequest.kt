package com.aim.atlas.core.interactor.organization.account

import com.aim.atlas.core.boundary.RequestModel

class ManagerAccountRequest() : RequestModel {

    var id: Long? = null
    var name: String? = null
    var email: String? = null
    var memberType: String? = null

    constructor(id: Long, name: String, email: String, memberType: String = ""): this(){
        this.id  = id
        this.name = name
        this.email = email
        this.memberType = memberType
    }

}