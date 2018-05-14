package com.aim.atlas.core.entity.membership

class Session() {
    var access_token : String = ""
    var expires_in: Int = 0

    constructor(access_token: String, expires_in: Int) : this(){
        this.access_token = access_token
        this.expires_in = expires_in
    }

}