package com.aim.atlas.core.repository.organization

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.repository.Repository
import io.reactivex.Maybe

interface AccountRepository : Repository {

    /**
     * Find all accounts
     */
    fun all() : Maybe<List<Account>>

    /**
     * Find account given id
     */
    fun find(id: Long): Maybe<Account>

    /**
     * Create a new organization given [Account].
     */
    fun create(account: Account) : Maybe<Account>

    /**
     * Update an existing organization given [Account].
     */
    fun update(account: Account): Maybe<Account>

    fun getById(id: Long) : Account

}