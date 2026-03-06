package br.com.pedro.kotlin_springboot_REST_API_practice.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

private const val TABLE_NAME = "person"
private const val COLUMN_FIRST_NAME = "first_name"
private const val COLUMN_LAST_NAME = "last_name"

@Entity
@Table(name = TABLE_NAME)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @Column(name = COLUMN_FIRST_NAME, nullable = false, length = 80)
    var firstName: String = "",

    @Column(name = COLUMN_LAST_NAME, nullable = false, length = 80)
    var lastName: String = "",

    @Column(nullable = false, length = 100)
    var address: String = "",

    @Column(nullable = false, length = 10)
    var gender: String = ""
)