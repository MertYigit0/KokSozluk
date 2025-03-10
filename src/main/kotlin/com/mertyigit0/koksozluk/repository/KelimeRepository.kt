package com.mertyigit0.koksozluk.repository

import com.mertyigit0.koksozluk.model.Kelime
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KelimeRepository : JpaRepository<Kelime, Long> {
    // İhtiyaca göre özelleştirilmiş sorgular ekleyebilirsiniz
    fun findByKelime(kelime: String): Kelime?



}
