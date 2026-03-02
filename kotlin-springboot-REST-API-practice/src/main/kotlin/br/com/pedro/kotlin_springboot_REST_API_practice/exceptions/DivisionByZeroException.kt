package br.com.pedro.kotlin_springboot_REST_API_practice.exceptions

import java.lang.*

class DivisionByZeroException(exception: String?) : RuntimeException(exception)