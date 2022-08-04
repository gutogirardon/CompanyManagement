package br.com.girardon.company.service

import br.com.girardon.company.exception.NotFoundException
import br.com.girardon.company.model.Employee
import br.com.girardon.company.repository.EmployeeRepository
import br.com.girardon.company.request.EmployeeRequest
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val companyService: CompanyService,
    private val employeeRepository: EmployeeRepository) {

    fun createEmployee(request: EmployeeRequest) : Employee {
        val company = request.companyId?.let { companyService.findById(it) }

        return employeeRepository.save(
            Employee(
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email,
                company = company
            )
        )
    }

    fun findAll(): List<Employee> =
        employeeRepository.findAll()

    fun findAllByCompanyId(id: String) : List<Employee> =
        employeeRepository.findByCompanyId(id)

    fun findById(id: ObjectId) : Employee =
        employeeRepository.findById(id)
            .orElseThrow { NotFoundException("Employee with $id not found") }

    fun updateEmployee(id: ObjectId, request: EmployeeRequest) : Employee {
        val employeeToUpdate = findById(id)
        val foundCompany = request.companyId?.let { companyService.findById(it) }

        return employeeRepository.save(
            employeeToUpdate.apply {
                firstName = request.firstName
                lastName = request.lastName
                email = request.email
                company = foundCompany
            }
        )
    }

    fun deleteById(id: ObjectId) {
        val employeeToDelete = findById(id)

        employeeRepository.delete(employeeToDelete)
    }
}