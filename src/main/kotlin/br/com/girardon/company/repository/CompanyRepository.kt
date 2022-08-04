package br.com.girardon.company.repository

import br.com.girardon.company.model.Company
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : MongoRepository<Company, String>