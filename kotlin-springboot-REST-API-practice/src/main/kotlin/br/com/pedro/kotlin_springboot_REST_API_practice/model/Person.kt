package br.com.pedro.kotlin_springboot_REST_API_practice.model

data class Person(
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
)