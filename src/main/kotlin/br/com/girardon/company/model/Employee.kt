package br.com.girardon.company.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Employee(
    @Id
    val id: ObjectId? = null,
    var firstName: String,
    var lastName: String,
    var email: String,
    var company: Company?
)