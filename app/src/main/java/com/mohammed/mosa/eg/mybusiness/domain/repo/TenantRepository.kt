package com.mohammed.mosa.eg.mybusiness.domain.repo


import com.mohammed.mosa.eg.mybusiness.data.module.Tenant
import kotlinx.coroutines.flow.Flow

interface TenantRepository {

    suspend fun upsertTenant(tenant: Tenant)

    suspend fun upsertTenants(tenants: List<Tenant>)

    suspend fun deleteTenant(tenant: Tenant)

    fun getTenantsOrderedByRoomNumber(): Flow<List<Tenant>>

    fun getTenantsOrderedByTenantName(): Flow<List<Tenant>>
}