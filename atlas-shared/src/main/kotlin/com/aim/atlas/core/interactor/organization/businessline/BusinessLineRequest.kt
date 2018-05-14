package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class BusinessLineRequest : RequestModel {
    var id: Long = 0
    var name : String? = null
    var alias : String? = null
    var description : String? = ""
    var accountId: Long? = null
    var configurationId: Long? = null
}