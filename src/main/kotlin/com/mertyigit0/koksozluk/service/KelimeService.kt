package com.mertyigit0.koksozluk.service

import com.mertyigit0.koksozluk.dto.KelimeDTO
import com.mertyigit0.koksozluk.model.Kelime
import com.mertyigit0.koksozluk.repository.KelimeRepository
import org.springframework.stereotype.Service

@Service
class KelimeService(private val kelimeRepository: KelimeRepository) {

    // Kelimeyi ID ile bulma
    fun getKelimeById(id: Long): KelimeDTO? {
        val kelime = kelimeRepository.findById(id).orElse(null)
        return kelime?.let { convertToDTO(it) }
    }

    // Tüm kelimeleri listeleme
    fun getAllKelimes(): List<KelimeDTO> {
        val kelimeler = kelimeRepository.findAll()
        return kelimeler.map { convertToDTO(it) }
    }

    // Kelimeyi kaydetme
    fun saveKelime(kelimeDTO: KelimeDTO): KelimeDTO {
        val kelime = convertToEntity(kelimeDTO)
        val savedKelime = kelimeRepository.save(kelime)
        return convertToDTO(savedKelime)
    }

    fun saveKelimes(kelimelerDTO: List<KelimeDTO>): List<KelimeDTO> {
        return kelimelerDTO.map { kelimeDTO ->
            val kelime = convertToEntity(kelimeDTO)
            val savedKelime = kelimeRepository.save(kelime)
            convertToDTO(savedKelime)
        }
    }


    // Kelimeyi DTO'dan Entity'ye dönüştürme
    private fun convertToEntity(kelimeDTO: KelimeDTO): Kelime {
        return Kelime(
            kelime = kelimeDTO.kelime,
            anlam = kelimeDTO.anlam,
            ornek_cumle = kelimeDTO.ornek_cumle,
            alternatif_kelime = kelimeDTO.alternatif_kelime
        )
    }

    // Entity'yi DTO'ya dönüştürme
    private fun convertToDTO(kelime: Kelime): KelimeDTO {
        return KelimeDTO(
            kelime = kelime.kelime,
            anlam = kelime.anlam,
            ornek_cumle = kelime.ornek_cumle,
            alternatif_kelime = kelime.alternatif_kelime
        )
    }


    fun deleteKelime(id: Long) {
        val kelime = kelimeRepository.findById(id).orElseThrow {
            throw IllegalArgumentException("Kelime bulunamadı!")
        }
        kelimeRepository.delete(kelime)
    }

}
