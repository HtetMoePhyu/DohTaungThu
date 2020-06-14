package com.roomdbexample.dohtaungthu.model

data class SeedInfo(
    val id : Int,
    val avaRegion : String,
    val seedList : List<Seeds>)

data class Seeds(
    val companyName : String,
    val personName : String,
    val seedName : String,
    val productionRegion : String,
    val phoneNumber : String)
