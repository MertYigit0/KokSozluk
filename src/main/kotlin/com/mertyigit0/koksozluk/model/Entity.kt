package com.mertyigit0.koksozluk.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Kelime(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val kelime: String,
    val anlam: String,
    val ornek_cumle: String,
    val alternatif_kelime: String?
)
