package br.com.pedro.kotlin_springboot_REST_API_practice.services

import br.com.pedro.kotlin_springboot_REST_API_practice.data.vo.v1.PersonVO
import br.com.pedro.kotlin_springboot_REST_API_practice.data.vo.v2.PersonVO as PersonVOV2
import br.com.pedro.kotlin_springboot_REST_API_practice.model.Person
import br.com.pedro.kotlin_springboot_REST_API_practice.repository.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import br.com.pedro.kotlin_springboot_REST_API_practice.exceptions.ResourceNotFoundException
import br.com.pedro.kotlin_springboot_REST_API_practice.mapper.DozerMapper
import br.com.pedro.kotlin_springboot_REST_API_practice.mapper.custom.PersonMapper

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = LoggerFactory.getLogger(PersonServices::class.java)

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people!")
        val people = repository.findAll()
        return DozerMapper.parseObjectsList(people, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person!")
        val person = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        return DozerMapper.parseObject(person, PersonVO::class.java)

    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating a new person with name ${person.firstName}!")
        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun createV2(person: PersonVOV2): PersonVOV2 {
        logger.info("Creating a new person with name ${person.firstName}!")
        val entity: Person = mapper.mapVoToEntity(person)
        return mapper.mapEntityToVo(repository.save(entity))
    }

    fun update(person: PersonVO): PersonVO {
        val id = person.id ?: throw ResourceNotFoundException("ID is required for update")
        logger.info("Updating a person with the id $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting a person with the id $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}