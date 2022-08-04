package br.com.girardon.company.controller

import br.com.girardon.company.request.CompanyRequest
import br.com.girardon.company.response.CompanyResponse
import br.com.girardon.company.service.CompanyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/company")
class CompanyController(
    private val companyService: CompanyService
) {

    @PostMapping
    fun createCompany(@RequestBody request: CompanyRequest) : ResponseEntity<CompanyResponse> {
        val createdCompany = companyService.createCompany(request)

        return ResponseEntity.ok(
            CompanyResponse.fromEntity(createdCompany)
        )
    }

    @GetMapping
    fun findAllCompanies(): ResponseEntity<List<CompanyResponse>> {
        val companies = companyService.findAll()

        return ResponseEntity.ok(
            companies.map { CompanyResponse.fromEntity(it) }
        )
    }

    @GetMapping("/{id}")
    fun findCompanyById(@PathVariable id: String) : ResponseEntity<CompanyResponse> {
        val company = companyService.findById(id)

        return ResponseEntity.ok(
            CompanyResponse.fromEntity(company)
        )
    }

    @PutMapping("/{id}")
    fun updateCompany(
        @PathVariable id: String,
        @RequestBody request: CompanyRequest
    ): ResponseEntity<CompanyResponse> {
        val updatedCompany = companyService.updateCompany(id, request)
        return ResponseEntity
            .ok(
                CompanyResponse.fromEntity(updatedCompany)
            )
    }

    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id: String): ResponseEntity<Void> {
        companyService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}