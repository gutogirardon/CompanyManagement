package br.com.girardon.company.repository

import br.com.girardon.company.model.Employee
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : MongoRepository<Employee, ObjectId> {
    fun findByCompanyId(id: String) :List<Employee>
}