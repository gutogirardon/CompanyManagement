package br.com.girardon.company.service

import br.com.girardon.company.exception.NotFoundException
import br.com.girardon.company.model.Company
import br.com.girardon.company.repository.CompanyRepository
import br.com.girardon.company.repository.EmployeeRepository
import br.com.girardon.company.request.CompanyRequest
import org.springframework.stereotype.Service

@Service
class CompanyService(
    private val companyRepository: CompanyRepository,
    private val employeeRepository: EmployeeRepository
) {
    fun createCompany(request: CompanyRequest) : Company =
        companyRepository.save(
            Company(
                name = request.name,
                address = request.address
            )
        )

    fun findAll(): List<Company> = companyRepository.findAll()

    fun findById(id: String): Company =
        companyRepository.findById(id)
            .orElseThrow { NotFoundException("Company with id $id not found") }

    fun updateCompany(id: String, request: CompanyRequest) : Company {
        val companyToUpdate = findById(id)

        val updatedCompany = companyRepository.save(
            companyToUpdate.apply {
                name = request.name
                address = request.address
            }
        )
        updateCompanyEmployees(updatedCompany)
        return updatedCompany
    }

    fun deleteById(id: String) {
        val companyToDelete = findById(id)

        companyRepository.deleteById(id)
    }

    private fun updateCompanyEmployees(updatedCompany: Company) {
        employeeRepository.saveAll(
            employeeRepository.findByCompanyId(updatedCompany.id!!)
                .map { it.apply { company = updatedCompany } }
        )
    }
}