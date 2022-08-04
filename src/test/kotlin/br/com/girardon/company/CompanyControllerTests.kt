package br.com.girardon.company

import br.com.girardon.company.model.Company
import br.com.girardon.company.service.CompanyService
import br.com.girardon.company.service.EmployeeService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.http.MediaType

@WebMvcTest
class CompanyControllerTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var companyService: CompanyService
    @MockkBean
    lateinit var employeeService: EmployeeService

    val company = Company(
        "62eb254e1c96d949a2ba744b",
        "Company Name",
        "Company Address")

    @Test
    fun givenExistingCompany_whenGetRequest_thenReturnStatus200Successfully() {
        every { companyService.findById("62eb254e1c96d949a2ba744b") } returns company

        mockMvc.perform(get("/api/company/62eb254e1c96d949a2ba744b"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("Company Name"))
    }
}