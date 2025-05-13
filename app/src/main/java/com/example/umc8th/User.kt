package com.example.umc8th

data class User(
    var userKey: String,
    var userName: String,
    var userAge: String
){
    constructor(): this("", "", "")
}
