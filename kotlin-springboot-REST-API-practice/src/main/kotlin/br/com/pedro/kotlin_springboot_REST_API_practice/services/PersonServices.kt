package br.com.pedro.kotlin_springboot_REST_API_practice.services

import br.com.pedro.kotlin_springboot_REST_API_practice.model.Person
import br.com.pedro.kotlin_springboot_REST_API_practice.repository.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import br.com.pedro.kotlin_springboot_REST_API_practice.exceptions.ResourceNotFoundException

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = LoggerFactory.getLogger(PersonServices::class.java)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
    }

    fun create(person: Person): Person {
        logger.info("Creating a new person with name ${person.firstName}!")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        val id = person.id ?: throw ResourceNotFoundException("ID is required for update")
        logger.info("Updating a person with the id $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting a person with the id $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}