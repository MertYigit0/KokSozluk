package com.mertyigit0.koksozluk.controller

import com.mertyigit0.koksozluk.dto.KelimeDTO
import com.mertyigit0.koksozluk.service.KelimeService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/kelime")
class KelimeController(private val kelimeService: KelimeService) {

    // Tüm kelimeleri getirme
    @GetMapping
    fun getAllKelimes(): List<KelimeDTO> {
        return kelimeService.getAllKelimes()
    }

    // Kelimeyi ID ile getirme
    @GetMapping("/{id}")
    fun getKelimeById(@PathVariable id: Long): KelimeDTO? {
        return kelimeService.getKelimeById(id)
    }

    // Yeni kelime ekleme
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createKelime(@RequestBody kelimeDTO: KelimeDTO): KelimeDTO {
        return kelimeService.saveKelime(kelimeDTO)
    }

    @PostMapping("/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    fun createKelimes(@RequestBody kelimelerDTO: List<KelimeDTO>): List<KelimeDTO> {
        return kelimelerDTO.map { kelimeService.saveKelime(it) }
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteKelime(@PathVariable id: Long) {
        kelimeService.deleteKelime(id)
    }



}
