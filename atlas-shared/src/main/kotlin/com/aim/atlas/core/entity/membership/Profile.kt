package com.aim.atlas.core.entity.membership

class Profile() {
    var id : Long? = null
    var image: String? = null

    constructor(id: Long, image: String?) : this(){
        this.id = id
        this.image = image
    }

}