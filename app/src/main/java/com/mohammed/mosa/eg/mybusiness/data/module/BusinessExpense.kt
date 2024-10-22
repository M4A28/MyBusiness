package com.mohammed.mosa.eg.mybusiness.data.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "business_expenses")
data class BusinessExpense(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val description: String,
    val amount: Double,
    val date: LocalDateTime = LocalDateTime.now(),
    val category: String,
    val department: String,
    val isPaid: Boolean = false
)


enum class BusinessExpenseCategory {
    OPERATING_COSTS,
    PAYROLL,
    BILLS,
    SUPPLIES,
    MAINTENANCE,
    UTILITIES,
    RENT,
    OTHER
}


data class QuarterlyExpense(
    val quarter: String,
    val total: Double
)