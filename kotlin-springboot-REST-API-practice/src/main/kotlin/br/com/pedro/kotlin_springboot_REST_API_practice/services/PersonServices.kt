package br.com.pedro.kotlin_springboot_REST_API_practice.services

import br.com.pedro.kotlin_springboot_REST_API_practice.controllers.PersonController
import br.com.pedro.kotlin_springboot_REST_API_practice.data.vo.v1.PersonVO
import br.com.pedro.kotlin_springboot_REST_API_practice.model.Person
import br.com.pedro.kotlin_springboot_REST_API_practice.repository.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import br.com.pedro.kotlin_springboot_REST_API_practice.exceptions.ResourceNotFoundException
import br.com.pedro.kotlin_springboot_REST_API_practice.mapper.DozerMapper
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = LoggerFactory.getLogger(PersonServices::class.java)

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people!")
        val people = repository.findAll()
        val vos = DozerMapper.parseObjectsList(people, PersonVO::class.java)
        for(person in vos){
            val withSelfRel = linkTo(PersonController::class.java).slash(person.key).withSelfRel()
            person.add(withSelfRel)
        }
        return vos
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person with id: $id!")
        val person = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        val personVO : PersonVO = DozerMapper.parseObject(person, PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating a new person with name ${person.firstName}!")
        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
        val personVO : PersonVO =  DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun update(person: PersonVO): PersonVO {
        val id = person.key ?: throw ResourceNotFoundException("ID is required for update")
        logger.info("Updating a person with the id $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        val personVO : PersonVO =  DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun delete(id: Long) {
        logger.info("Deleting a person with the id $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}