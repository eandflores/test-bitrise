package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.organization.account.AccountResponse
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class AccountResponseMapper :
        Mapper<Account, AccountResponse>,
        PaginationMapper<Account, AccountResponse>,
        ListMapper<Account, AccountResponse>
{
    override fun transform(source: Pagination<Account>): Pagination<AccountResponse> =
        with(source) {
            Pagination(
                    root = transform(root),
                    size = source.size,
                    page = source.page,
                    place = source.place,
                    totalElements = source.totalElements,
                    totalPages = source.totalPages
            )
        }

    override fun transform(source: List<Account>) = source.map { transform(it) }

    override fun transform(source: Account) =
            with(source) {
                AccountResponse(
                        id = id,
                        contractNumber = contractNumber!!,
                        name = name!!,
                        subdomain = subdomain!!
                )
            }


}