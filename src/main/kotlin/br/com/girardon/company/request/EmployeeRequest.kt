package br.com.girardon.company.request

class EmployeeRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val companyId: String?
)