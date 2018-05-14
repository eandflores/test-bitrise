package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel
import com.aim.atlas.core.entity.membership.Profile

@TestOpen
class UserRequestModel() : RequestModel {
    var id: Long? = 0
    var name: String? = null
    var email: String? = null
    var oktaId: String? = null
    var password: String? = null
    var profile: Profile? = Profile()
}