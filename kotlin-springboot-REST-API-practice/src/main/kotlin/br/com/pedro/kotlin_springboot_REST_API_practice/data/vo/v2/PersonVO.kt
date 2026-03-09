package br.com.pedro.kotlin_springboot_REST_API_practice.data.vo.v2

import java.util.Date

data class PersonVO(

    var id: Long? = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
    var birthday: Date? = null
)