package com.mauricionaula.consultaapi.service

import com.mauricionaula.consultaapi.model.pacienteTabla
import com.mauricionaula.consultaapi.repository.pacienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service

class pacienteService {
    @Autowired
    lateinit var pacienteRepository: pacienteRepository


    fun list(): List<pacienteTabla> {

        return pacienteRepository.findAll()
    }
    fun save(pacienteTabla: pacienteTabla):pacienteTabla{
        try {
            if (pacienteTabla.nombres?.trim()?.isEmpty() == true)
            {
                throw Exception("Falta escribir el nombre para continuar")
            }
            if (pacienteTabla.edad?.trim()?.isEmpty() == true)
            {
                throw Exception("Falta escribir la edad para continuar")
            }
            if (pacienteTabla.talla?.trim()?.isEmpty() == true)
            {
                throw Exception("Falta escribir la talla para continuar")
            }
            if (pacienteTabla.peso?.trim()?.isEmpty() == true)
            {
                throw Exception("Falta escribir el peso para continuar")
            }
            return pacienteRepository.save(pacienteTabla)
        }catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }
    fun update(pacienteTabla:pacienteTabla): pacienteTabla {
        try {
            val response = pacienteTabla.id?.let { pacienteRepository.findById(it) }
                ?: throw Exception("Paciente no existe")
            response.apply {
                var nombres = pacienteTabla.nombres
                var edad = pacienteTabla.edad
                var talla = pacienteTabla.talla
                var peso = pacienteTabla.peso
            }
            return pacienteRepository.save(pacienteTabla)

        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

        fun delete(id: Long): Boolean {
            pacienteRepository.deleteById(id)
            return true
        }

    fun updateWeight(pacienteTabla: pacienteTabla): pacienteTabla {
        try {
            val response = pacienteTabla.id?.let { pacienteRepository.findById(it) }
                ?: throw Exception("Paciente no existe")
            response.apply {
                var nombres = pacienteTabla.nombres
                var edad = pacienteTabla.edad
                var talla = pacienteTabla.talla
                var peso = pacienteTabla.peso
            }
            return pacienteRepository.save(pacienteTabla)

        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }
}