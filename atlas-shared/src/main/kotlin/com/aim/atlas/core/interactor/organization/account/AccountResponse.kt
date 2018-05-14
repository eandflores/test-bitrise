package com.aim.atlas.core.interactor.organization.account

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel

@TestOpen
class AccountResponse(
        val id: Long,
        val contractNumber: String,
        val name: String,
        val subdomain: String
) : ResponseModel