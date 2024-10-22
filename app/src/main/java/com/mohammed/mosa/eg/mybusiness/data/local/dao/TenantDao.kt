package com.mohammed.mosa.eg.mybusiness.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.mohammed.mosa.eg.mybusiness.data.module.Tenant
import kotlinx.coroutines.flow.Flow

@Dao
interface TenantDao {
    @Upsert
    suspend fun upsertTenant(tenant: Tenant)

    @Upsert
    suspend fun upsertTenants(tenants: List<Tenant>)

    @Delete
    suspend fun deleteTenant(tenant: Tenant)

    @Query("SELECT * FROM tenants ORDER BY roomNumber ASC")
    fun getTenantsOrderedByRoomNumber(): Flow<List<Tenant>>

    @Query("SELECT * FROM tenants ORDER BY tenantName ASC")
    fun getTenantsOrderedByTenantName(): Flow<List<Tenant>>


}