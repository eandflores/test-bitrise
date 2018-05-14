package com.aim.atlas.core.entity.membership

class User(){
    var id: Long? = null
    var name: String? = null
    var email: String? = null
    var oktaId: String? = null
    var password: String? = null
    var profile: Profile? = null

    constructor(id: Long?, name: String, email: String, oktaId: String? = "", password: String, profile: Profile): this(){
        this.id  = id
        this.name = name
        this.email = email
        this.oktaId = oktaId
        this.password = password
        this.profile = profile
    }

}