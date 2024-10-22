package com.mohammed.mosa.eg.mybusiness.domain.repo


import com.mohammed.mosa.eg.mybusiness.data.module.BusinessExpense
import com.mohammed.mosa.eg.mybusiness.data.module.QuarterlyExpense
import kotlinx.coroutines.flow.Flow

interface BusinessExpenseRepository {

    suspend fun upsertBusinessExpense(businessExpense: BusinessExpense)

    suspend fun upsertBusinessExpenses(businessExpenses: List<BusinessExpense>)

    suspend fun deleteBusinessExpense(businessExpense: BusinessExpense)

    suspend fun deleteBusinessExpenses(businessExpenses: List<BusinessExpense>)

    fun getBusinessExpensesOrderedById(): Flow<List<BusinessExpense>>

    fun getBusinessExpensesOrderedByDate(): Flow<List<BusinessExpense>>

    fun getBusinessExpensesOrderedByCategory(): Flow<List<BusinessExpense>>

    fun getBusinessExpensesOrderedByDepartment(): Flow<List<BusinessExpense>>

    fun getBusinessExpensesByDepartment(department: String): Flow<List<BusinessExpense>>

    fun getBusinessExpensesByCategory(category: String): Flow<List<BusinessExpense>>

    fun getBusinessExpensesByDate(date: String): Flow<List<BusinessExpense>>

    fun getBusinessExpensesInRange(startDate: String, endDate: String): Flow<List<BusinessExpense>>

    fun getBusinessExpensesByMonth(startDate: String, endDate: String): Flow<List<BusinessExpense>>

    fun getBusinessExpensesByYear(startDate: String, endDate: String): Flow<List<BusinessExpense>>

    fun getQuarterlyExpenses(): Flow<List<QuarterlyExpense>>

}