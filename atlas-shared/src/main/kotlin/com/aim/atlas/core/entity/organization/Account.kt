package com.aim.atlas.core.entity.organization

import com.aim.atlas.core.annotations.TestOpen
import java.util.*


@TestOpen
class Account (
        val id : Long
//        val timeZone: TimeZone,
//        val status: String,
//        val createdAt: String,
//        val accountProfile: DataAccountProfile,
//        val configuration: DataConfiguration
) {
    var contractNumber: String? = null
    var subdomain: String? = null
    var name: String? = null
    var timeZone: String? = null

    constructor(id: Long, contractNumber: String, subdomain: String, name: String) : this(id) {
        this.contractNumber = contractNumber
        this.subdomain = subdomain
        this.name = name
    }

    constructor(id: Long, contractNumber: String, subdomain: String, name: String, timeZone: String) : this(id, contractNumber, subdomain, name) {
        this.contractNumber = contractNumber
        this.subdomain = subdomain
        this.name = name
        this.timeZone = timeZone
    }
}