package br.com.pedro.kotlin_springboot_REST_API_practice.exceptions

import java.lang.*

class UnsupportedMathOperationException(exception: String?) : RuntimeException(exception)