package com.mohammed.mosa.eg.mybusiness.data.repoimpl

import com.mohammed.mosa.eg.mybusiness.data.local.dao.BusinessExpenseDao
import com.mohammed.mosa.eg.mybusiness.data.module.BusinessExpense
import com.mohammed.mosa.eg.mybusiness.data.module.QuarterlyExpense
import com.mohammed.mosa.eg.mybusiness.domain.repo.BusinessExpenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BusinessExpenseRepositoryImpl @Inject constructor(private val businessExpenseDao: BusinessExpenseDao) : BusinessExpenseRepository {
    override suspend fun upsertBusinessExpense(businessExpense: BusinessExpense) {
        businessExpenseDao.upsertBusinessExpense(businessExpense)
    }

    override suspend fun upsertBusinessExpenses(businessExpenses: List<BusinessExpense>) {
        businessExpenseDao.upsertBusinessExpenses(businessExpenses)
    }

    override suspend fun deleteBusinessExpense(businessExpense: BusinessExpense) {
        businessExpenseDao.deleteBusinessExpense(businessExpense)
    }

    override suspend fun deleteBusinessExpenses(businessExpenses: List<BusinessExpense>) {
        businessExpenseDao.deleteBusinessExpenses(businessExpenses)
    }

    override fun getBusinessExpensesOrderedById(): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesOrderedById()
    }

    override fun getBusinessExpensesOrderedByDate(): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesOrderedByDate()
    }

    override fun getBusinessExpensesOrderedByCategory(): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesOrderedByCategory()
    }

    override fun getBusinessExpensesOrderedByDepartment(): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesOrderedByDepartment()
    }

    override fun getBusinessExpensesByDepartment(department: String): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesByDepartment(department)
    }

    override fun getBusinessExpensesByCategory(category: String): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesByCategory(category)
    }

    override fun getBusinessExpensesByDate(date: String): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesByDate(date)
    }

    override fun getBusinessExpensesInRange(
        startDate: String,
        endDate: String
    ): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesInRange(startDate, endDate)
    }

    override fun getBusinessExpensesByMonth(
        startDate: String,
        endDate: String
    ): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesByMonth(startDate, endDate)
    }

    override fun getBusinessExpensesByYear(
        startDate: String,
        endDate: String
    ): Flow<List<BusinessExpense>> {
        return businessExpenseDao.getBusinessExpensesByYear(startDate, endDate)
    }

    override fun getQuarterlyExpenses(): Flow<List<QuarterlyExpense>> {
        return businessExpenseDao.getQuarterlyExpenses()
    }
}