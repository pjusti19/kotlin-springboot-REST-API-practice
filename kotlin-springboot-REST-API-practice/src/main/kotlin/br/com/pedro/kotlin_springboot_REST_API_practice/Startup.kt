package br.com.pedro.kotlin_springboot_REST_API_practice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Startup

fun main(args: Array<String>) {
	runApplication<Startup>(*args)
}
