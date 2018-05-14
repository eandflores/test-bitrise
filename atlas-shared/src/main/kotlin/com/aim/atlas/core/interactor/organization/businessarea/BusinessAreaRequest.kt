package com.aim.atlas.core.interactor.organization.businessarea

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class BusinessAreaRequest(): RequestModel {
    var id: Long = 0
    var name: String? = null
    var accountId: Long? = null
    var businessLinesIds: List<Long> = listOf()

    constructor(name: String, accountId: Long, businessLines: List<Long>): this(){
        this.name = name
        this.accountId = accountId
        this.businessLinesIds = businessLines
    }

}