package com.mohammed.mosa.eg.mybusiness.data.repoimpl

import com.mohammed.mosa.eg.mybusiness.data.local.dao.TenantDao
import com.mohammed.mosa.eg.mybusiness.data.module.Tenant
import com.mohammed.mosa.eg.mybusiness.domain.repo.TenantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TenantRepositoryImpl @Inject constructor(private val tenantDao: TenantDao) : TenantRepository {
    override suspend fun upsertTenant(tenant: Tenant) {
        tenantDao.upsertTenant(tenant)
    }

    override suspend fun upsertTenants(tenants: List<Tenant>) {
        tenantDao.upsertTenants(tenants)
    }

    override suspend fun deleteTenant(tenant: Tenant) {
        tenantDao.deleteTenant(tenant)
    }

    override fun getTenantsOrderedByRoomNumber(): Flow<List<Tenant>> {
        return tenantDao.getTenantsOrderedByRoomNumber()
    }

    override fun getTenantsOrderedByTenantName(): Flow<List<Tenant>> {
        return tenantDao.getTenantsOrderedByTenantName()
    }
}