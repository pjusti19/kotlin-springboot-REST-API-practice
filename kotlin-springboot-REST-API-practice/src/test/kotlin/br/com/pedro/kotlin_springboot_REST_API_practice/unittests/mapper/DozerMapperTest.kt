package br.com.pedro.kotlin_springboot_REST_API_practice.unittests.mapper

import br.com.pedro.kotlin_springboot_REST_API_practice.data.vo.v1.PersonVO
import br.com.pedro.kotlin_springboot_REST_API_practice.mapper.DozerMapper
import br.com.pedro.kotlin_springboot_REST_API_practice.model.Person
import br.com.pedro.kotlin_springboot_REST_API_practice.unittests.mapper.mocks.MockPerson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DozerMapperTest {

    var inputObject: MockPerson? = null

    @BeforeEach
    fun setUp() {
        inputObject = MockPerson()
    }

    @Test
    fun parseEntityToVOTest() {
        val output: PersonVO = DozerMapper.parseObject(inputObject!!.mockEntity(), PersonVO::class.java)
        Assertions.assertEquals(0, output.id)
        Assertions.assertEquals("First Name Test0", output.firstName)
        Assertions.assertEquals("Last Name Test0", output.lastName)
        Assertions.assertEquals("Address Test0", output.address)
        Assertions.assertEquals("Male", output.gender)
    }

    @Test
    fun parseEntityListToVOListTest() {
        val outputList: ArrayList<PersonVO> =
            DozerMapper.parseObjectsList(inputObject!!.mockEntityList(), PersonVO::class.java)

        val outputZero: PersonVO = outputList[0]

        Assertions.assertEquals(0, outputZero.id)
        Assertions.assertEquals("First Name Test0", outputZero.firstName)
        Assertions.assertEquals("Last Name Test0", outputZero.lastName)
        Assertions.assertEquals("Address Test0", outputZero.address)
        Assertions.assertEquals("Male", outputZero.gender)

        val outputSeven: PersonVO = outputList[7]
        Assertions.assertEquals(7.toLong(), outputSeven.id)
        Assertions.assertEquals("First Name Test7", outputSeven.firstName)
        Assertions.assertEquals("Last Name Test7", outputSeven.lastName)
        Assertions.assertEquals("Address Test7", outputSeven.address)
        Assertions.assertEquals("Female", outputSeven.gender)

        val outputTwelve: PersonVO = outputList[12]
        Assertions.assertEquals(12.toLong(), outputTwelve.id)
        Assertions.assertEquals("First Name Test12", outputTwelve.firstName)
        Assertions.assertEquals("Last Name Test12", outputTwelve.lastName)
        Assertions.assertEquals("Address Test12", outputTwelve.address)
        Assertions.assertEquals("Male", outputTwelve.gender)
    }

    @Test
    fun parseVOToEntityTest() {

        val output: Person = DozerMapper.parseObject(inputObject!!.mockVO(), Person::class.java)

        Assertions.assertEquals(0, output.id)
        Assertions.assertEquals("First Name Test0", output.firstName)
        Assertions.assertEquals("Last Name Test0", output.lastName)
        Assertions.assertEquals("Address Test0", output.address)
        Assertions.assertEquals("Male", output.gender)
    }

    @Test
    fun parserVOListToEntityListTest() {

        val outputList: ArrayList<Person> = DozerMapper.parseObjectsList(inputObject!!.mockVOList(), Person::class.java)

        val outputZero: Person = outputList[0]
        Assertions.assertEquals(0, outputZero.id)
        Assertions.assertEquals("First Name Test0", outputZero.firstName)
        Assertions.assertEquals("Last Name Test0", outputZero.lastName)
        Assertions.assertEquals("Address Test0", outputZero.address)
        Assertions.assertEquals("Male", outputZero.gender)

        val outputSeven: Person = outputList[7]
        Assertions.assertEquals(7, outputSeven.id)
        Assertions.assertEquals("First Name Test7", outputSeven.firstName)
        Assertions.assertEquals("Last Name Test7", outputSeven.lastName)
        Assertions.assertEquals("Address Test7", outputSeven.address)
        Assertions.assertEquals("Female", outputSeven.gender)

        val outputTwelve: Person = outputList[12]
        Assertions.assertEquals(12, outputTwelve.id)
        Assertions.assertEquals("First Name Test12", outputTwelve.firstName)
        Assertions.assertEquals("Last Name Test12", outputTwelve.lastName)
        Assertions.assertEquals("Address Test12", outputTwelve.address)
        Assertions.assertEquals("Male", outputTwelve.gender)
    }
}