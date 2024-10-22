package com.mohammed.mosa.eg.mybusiness.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.mohammed.mosa.eg.mybusiness.data.module.BusinessExpense
import com.mohammed.mosa.eg.mybusiness.data.module.QuarterlyExpense
import kotlinx.coroutines.flow.Flow

@Dao
interface BusinessExpenseDao {
    @Upsert
    suspend fun upsertBusinessExpense(businessExpense: BusinessExpense)

    @Upsert
    suspend fun upsertBusinessExpenses(businessExpenses: List<BusinessExpense>)

    @Delete
    suspend fun deleteBusinessExpense(businessExpense: BusinessExpense)

    @Delete
    suspend fun deleteBusinessExpenses(businessExpenses: List<BusinessExpense>)

    @Query("SELECT * FROM business_expenses ORDER BY id ASC")
    fun getBusinessExpensesOrderedById(): Flow<List<BusinessExpense>>

    @Query("SELECT * FROM business_expenses ORDER BY date ASC")
    fun getBusinessExpensesOrderedByDate(): Flow<List<BusinessExpense>>

    @Query("SELECT * FROM business_expenses ORDER BY category ASC")
    fun getBusinessExpensesOrderedByCategory(): Flow<List<BusinessExpense>>

    @Query("SELECT * FROM business_expenses ORDER BY department ASC")
    fun getBusinessExpensesOrderedByDepartment(): Flow<List<BusinessExpense>>

    @Query("SELECT * FROM business_expenses WHERE department = :department")
    fun getBusinessExpensesByDepartment(department: String): Flow<List<BusinessExpense>>

    @Query("SELECT * FROM business_expenses WHERE category = :category")
    fun getBusinessExpensesByCategory(category: String): Flow<List<BusinessExpense>>

    @Query("SELECT * FROM business_expenses WHERE date = :date")
    fun getBusinessExpensesByDate(date: String): Flow<List<BusinessExpense>>

    @Query("SELECT * FROM business_expenses WHERE date BETWEEN :startDate AND :endDate")
    fun getBusinessExpensesInRange(startDate: String, endDate: String): Flow<List<BusinessExpense>>

    // group by month
    @Query("SELECT * FROM business_expenses WHERE date BETWEEN :startDate AND :endDate GROUP BY strftime('%y-%m', date)")
    fun getBusinessExpensesByMonth(startDate: String, endDate: String): Flow<List<BusinessExpense>>

    // group by year
    @Query("SELECT * FROM business_expenses WHERE date BETWEEN :startDate AND :endDate GROUP BY strftime('%y', date)")
    fun getBusinessExpensesByYear(startDate: String, endDate: String): Flow<List<BusinessExpense>>


    @Query("""
        SELECT strftime('%Y-Q%q', date/1000, 'unixepoch') AS quarter, SUM(amount) AS total
        FROM business_expenses
        GROUP BY quarter
    """)
    fun getQuarterlyExpenses(): Flow<List<QuarterlyExpense>>






}