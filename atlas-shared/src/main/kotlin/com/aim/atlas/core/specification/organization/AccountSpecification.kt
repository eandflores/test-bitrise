package com.aim.atlas.core.specification.organization

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class AccountSpecification : AbstractSpecification<Account>() {


    override fun isSatisfiedBy(t: Account): Boolean {
        return true
    }

}