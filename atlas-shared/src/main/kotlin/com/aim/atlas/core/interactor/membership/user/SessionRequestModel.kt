package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel


@TestOpen
class SessionRequestModel() : RequestModel {
    var username: String = ""
    var password: String = ""
}