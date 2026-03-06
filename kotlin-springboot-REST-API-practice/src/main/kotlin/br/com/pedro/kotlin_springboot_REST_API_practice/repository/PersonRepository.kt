package br.com.pedro.kotlin_springboot_REST_API_practice.repository

import br.com.pedro.kotlin_springboot_REST_API_practice.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {
}