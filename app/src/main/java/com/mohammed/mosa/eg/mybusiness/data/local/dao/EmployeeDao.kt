package com.mohammed.mosa.eg.mybusiness.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.mohammed.mosa.eg.mybusiness.data.module.Employee
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface  EmployeeDao {

    @Upsert
    suspend fun upsertEmployee(employee: Employee)

    @Upsert
    suspend fun upsertEmployees(employees: List<Employee>)

    @Delete
    suspend fun deleteEmployee(employee: Employee)

    @Delete
    suspend fun deleteEmployees(employees: List<Employee>)

    @Query("SELECT * FROM employees ORDER BY name ASC")
    fun getEmployeesOrderedByName(): Flow<List<Employee>>

    @Query("SELECT * FROM employees ORDER BY residenceNumber ASC")
    fun getEmployeesOrderedByResidenceNumber(): Flow<List<Employee>>

    @Query("SELECT * FROM employees ORDER BY birthDate ASC")
    fun getEmployeesOrderedByJobNumber(): Flow<List<Employee>>

    @Query("SELECT * FROM employees WHERE residenceExpiry <= :date")
    fun getExpiredResidency(date: LocalDateTime): Flow<List<Employee>>

    @Query("SELECT * FROM employees WHERE workPermitExpiry <= :date")
    fun getExpiredWorkPermit(date: LocalDateTime): Flow<List<Employee>>

    @Query("SELECT * FROM employees WHERE contractExpiry <= :date")
    fun getExpiredContracts(date: LocalDateTime): Flow<List<Employee>>

    @Query("SELECT * FROM employees WHERE insuranceExpiry <= :date")
    fun getExpiredInsurances(date: LocalDateTime): Flow<List<Employee>>








}