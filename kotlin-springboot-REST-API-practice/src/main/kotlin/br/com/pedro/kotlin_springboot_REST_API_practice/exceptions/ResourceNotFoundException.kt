package br.com.pedro.kotlin_springboot_REST_API_practice.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException(exception: String?) : RuntimeException(exception)