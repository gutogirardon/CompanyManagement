package br.com.girardon.company.response

import br.com.girardon.company.model.Employee

class EmployeeResponse(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val company: CompanyResponse?
) {
    companion object {
        fun fromEntity(employee: Employee): EmployeeResponse =
            EmployeeResponse(
                id = employee.id!!.toHexString(),
                firstName = employee.firstName,
                lastName = employee.lastName,
                email = employee.email,
                company = employee.company?.let { CompanyResponse.fromEntity(it) }
            )
    }
}