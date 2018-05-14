package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel


@TestOpen
class SessionResponseModel (
        val access_token: String,
        val expires_in: Int
) : ResponseModel