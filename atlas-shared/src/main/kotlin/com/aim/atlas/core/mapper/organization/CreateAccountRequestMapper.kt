package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.organization.account.CreateAccountRequest
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import java.util.*
import javax.inject.Named

@TestOpen
@Named
class CreateAccountRequestMapper : Mapper<CreateAccountRequest, Account> {
    override fun transform(source: CreateAccountRequest): Account {
        return with(source) {
            val subdomain = subdomainFormatter(source?.subdomain!!)
            Account(id = 1L, name = source?.name!!, subdomain = subdomain, contractNumber = source.contractNumber!!)
        }
    }

    private fun subdomainFormatter(subdomain: String): String {
        return Optional.of(subdomain)
                .map { subdomain -> subdomain.toLowerCase() }
                .map { subdomain -> subdomain.replace(" ", "_") }
                .map { subdomain -> Regex("[^A-Za-z0-9_]").replace(subdomain, "") }
                .map { subdomain -> Regex("_*$").replace(subdomain, "") }
                .orElse("")
    }



}