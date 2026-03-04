package br.com.pedro.kotlin_springboot_REST_API_practice.exceptions

import java.util.Date

class ExceptionResponse(
    val timeStamp: Date,
    val message: String?,
    val details: String
)