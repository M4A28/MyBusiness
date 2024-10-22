package com.mohammed.mosa.eg.mybusiness.domain.repo


import com.mohammed.mosa.eg.mybusiness.data.module.Employee
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface EmployeeRepository {
    suspend fun upsertEmployee(employee: Employee)

    suspend fun upsertEmployees(employees: List<Employee>)

    suspend fun deleteEmployee(employee: Employee)

    suspend fun deleteEmployees(employees: List<Employee>)

    fun getEmployeesOrderedByName(): Flow<List<Employee>>

    fun getEmployeesOrderedByResidenceNumber(): Flow<List<Employee>>

    fun getEmployeesOrderedByJobNumber(): Flow<List<Employee>>

    fun getExpiredResidency(date: LocalDateTime): Flow<List<Employee>>

    fun getExpiredWorkPermit(date: LocalDateTime): Flow<List<Employee>>

    fun getExpiredContracts(date: LocalDateTime): Flow<List<Employee>>

    fun getExpiredInsurances(date: LocalDateTime): Flow<List<Employee>>

}