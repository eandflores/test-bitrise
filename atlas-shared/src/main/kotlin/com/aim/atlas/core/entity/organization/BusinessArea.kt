package com.aim.atlas.core.entity.organization

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
class BusinessArea(val id: Long) {
    var name : String? = null
    var account : Account? = null
    var businessLines: List<BusinessLine>? = null

    constructor(id: Long, name: String, account: Account, businessLine: List<BusinessLine>) : this(id) {
        this.name = name
        this.account = account
        this.businessLines = businessLine
    }
}
