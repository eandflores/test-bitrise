package com.aim.atlas.core.interactor.organization.account

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel
import com.aim.atlas.core.entity.membership.User

@TestOpen
class CreateAccountRequest() : RequestModel {

    var id: Long? = null
    var contractNumber: String? = null
    var name: String? = null
    var subdomain: String? = null
    var managers: List<ManagerAccountRequest>? = null
    var timeZone: String? = null

    constructor(name: String, subdomain: String) : this() {
        this.contractNumber = contractNumber
        this.name = name
        this.subdomain = subdomain
    }

    constructor(id: Long, name: String, subdomain: String) : this(name, subdomain) {
        this.id = id
    }

    constructor(name: String, subdomain: String, contractNumber: String) : this(name, subdomain) {
        this.name = name;
        this.subdomain = subdomain;
        this.contractNumber = contractNumber
    }

    constructor(id: Long, name: String, subdomain: String, contractNumber: String) : this(name, subdomain, contractNumber) {
        this.id = id
    }


}