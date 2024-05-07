package com.example.members.model


data class Geo (
        val lat:String,
        val lng:String
)

data class Adress(
    val street:String,
    val suite:String,
    val city:String,
    val geo:Geo
)

data class Company(
    val name:String,
    val catchPhrase:String,
    val bs:String
)

data class User (
    val id:Int,
    val name: String,
    val username:String,
    val email:String,
    val phonoe:String,
    val website:String,
    val address:Adress,
    val company:Company
)

