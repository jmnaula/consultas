package com.mauricionaula.consultaapi.service

import com.mauricionaula.consultaapi.model.tratamientoTabla
import com.mauricionaula.consultaapi.repository.tratamientoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class tratamientoService {
    @Autowired
    lateinit var tratamientoRepository: tratamientoRepository


    fun list(): List<tratamientoTabla> {

        return tratamientoRepository.findAll()
    }

    fun save(tratamientoTabla: tratamientoTabla): tratamientoTabla {
        try {
            if (tratamientoTabla.medicina?.trim()?.isEmpty() == true) {
                throw Exception("Falta escribir la medicina para continuar")
            }
            if (tratamientoTabla.controles?.trim()?.isEmpty() == true) {
                throw Exception("Falta escribir los controles para continuar")
            }
            if (tratamientoTabla.reposo?.trim()?.isEmpty() == true) {
                throw Exception("Falta escribir el reposo para continuar")
            }
            return tratamientoRepository.save(tratamientoTabla)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(tratamientoTabla: tratamientoTabla): tratamientoTabla {
        try {
            val response = tratamientoTabla.id?.let { tratamientoRepository.findById(it) }
                ?: throw Exception("tratamiento no existe")
            response.apply {
                var medicina = tratamientoTabla.medicina
                var controles = tratamientoTabla.controles
                var reposo = tratamientoTabla.reposo
            }
            return tratamientoRepository.save(tratamientoTabla)

        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun delete(id: Long): Boolean {
        tratamientoRepository.deleteById(id)
        return true
    }


    fun updateWeight(tratamientoTabla: tratamientoTabla): tratamientoTabla {
        try {
            val response = tratamientoTabla.id?.let { tratamientoRepository.findById(it) }
                ?: throw Exception("tratamiento no existe")
            response.apply {
                var medicina = tratamientoTabla.medicina
                var controles = tratamientoTabla.controles
                var reposo = tratamientoTabla.reposo
            }
            return tratamientoRepository.save(tratamientoTabla)

        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }
}




