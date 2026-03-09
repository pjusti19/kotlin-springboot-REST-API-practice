package br.com.pedro.kotlin_springboot_REST_API_practice.mapper.custom

import br.com.pedro.kotlin_springboot_REST_API_practice.data.vo.v2.PersonVO as PersonVOV2
import br.com.pedro.kotlin_springboot_REST_API_practice.model.Person
import org.springframework.stereotype.Service
import java.util.Date

@Service
class PersonMapper {

    fun mapEntityToVo(person: Person): PersonVOV2{
        val vo = PersonVOV2()
        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.gender = person.gender
        vo.address = person.address
        vo.birthday = Date() //person.birthday
        return vo
    }

    fun mapVoToEntity(vo: PersonVOV2): Person{
        val entity = Person()
        entity.firstName = vo.firstName
        entity.lastName = vo.lastName
        entity.gender = vo.gender
        entity.address = vo.address
        // entity.birthday = Date()
        return entity
    }
}