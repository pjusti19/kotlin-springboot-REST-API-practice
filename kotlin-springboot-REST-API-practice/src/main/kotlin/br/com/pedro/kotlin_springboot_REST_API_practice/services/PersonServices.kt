package br.com.pedro.kotlin_springboot_REST_API_practice.services

import br.com.pedro.kotlin_springboot_REST_API_practice.model.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class PersonServices {

    private val counter: AtomicLong = AtomicLong(0)

    private val logger = LoggerFactory.getLogger(PersonServices::class.java)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        val people: MutableList<Person> = ArrayList()

        for(i in 0..7){
            val person = mockPerson(i)
            people.add(person)
        }

        return people
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Pedro"
        person.lastName = "Justi"
        person.address = "Zé Gerar Bes"
        person.gender = "Male"

        return person
    }

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) {}

    fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Last name $i"
        person.address = "Algum lugar"
        person.gender = "Male"

        return person
    }

}