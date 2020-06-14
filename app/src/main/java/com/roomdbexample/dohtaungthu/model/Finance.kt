package com.roomdbexample.dohtaungthu.model

data class FinanceInfo(
    val companyName : String,
    val aboutCompany : String,
    val branchList : List<FinanceBranch>
)

data class FinanceBranch(val branchName : String)