package com.mohammed.mosa.eg.mybusiness.data.repoimpl

import com.mohammed.mosa.eg.mybusiness.data.local.dao.EmployeeDao
import com.mohammed.mosa.eg.mybusiness.data.module.Employee
import com.mohammed.mosa.eg.mybusiness.domain.repo.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(private val employeeDao: EmployeeDao) : EmployeeRepository {
    override suspend fun upsertEmployee(employee: Employee) {

        employeeDao.upsertEmployee(employee)
    }

    override suspend fun upsertEmployees(employees: List<Employee>) {
        employeeDao.upsertEmployees(employees)
    }

    override suspend fun deleteEmployee(employee: Employee) {
        employeeDao.deleteEmployee(employee)
    }

    override suspend fun deleteEmployees(employees: List<Employee>) {
        employeeDao.deleteEmployees(employees)
    }

    override fun getEmployeesOrderedByName(): Flow<List<Employee>> {
        return employeeDao.getEmployeesOrderedByName()
    }

    override fun getEmployeesOrderedByResidenceNumber(): Flow<List<Employee>> {
        return employeeDao.getEmployeesOrderedByResidenceNumber()
    }

    override fun getEmployeesOrderedByJobNumber(): Flow<List<Employee>> {
        return employeeDao.getEmployeesOrderedByJobNumber()
    }

    override fun getExpiredResidency(date: LocalDateTime): Flow<List<Employee>> {
        return employeeDao.getExpiredResidency(date)
    }

    override fun getExpiredWorkPermit(date: LocalDateTime): Flow<List<Employee>> {
        return employeeDao.getExpiredWorkPermit(date)
    }

    override fun getExpiredContracts(date: LocalDateTime): Flow<List<Employee>> {
        return employeeDao.getExpiredContracts(date)
    }

    override fun getExpiredInsurances(date: LocalDateTime): Flow<List<Employee>> {
        return employeeDao.getExpiredInsurances(date)
    }
}