package com.mauricionaula.consultaapi.service

import com.mauricionaula.consultaapi.model.consultaMedicaTabla
import com.mauricionaula.consultaapi.model.medicoTabla
import com.mauricionaula.consultaapi.repository.medicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class medicoService {
    @Autowired
    lateinit var medicoRepository: medicoRepository


    fun list(): List<medicoTabla> {

        return medicoRepository.findAll()
    }
    fun save(medicoTabla: medicoTabla):medicoTabla{
        try {
            if (medicoTabla.nombres?.trim()?.isEmpty() == true)
            {
                throw Exception("Falta escribir el nombre para continuar")
            }
            if (medicoTabla.especialidad?.trim()?.isEmpty() == true)
            {
                throw Exception("Falta escribir la especialidad para continuar")
            }
            return medicoRepository.save(medicoTabla)
        }catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }

    fun update(medicoTabla: medicoTabla):medicoTabla{
        try {
            val response = medicoTabla.id?.let { medicoRepository.findById(it) }
                ?: throw Exception("Paciente no existe")
            response.apply {
                var nombres = medicoTabla.nombres
                var especialidad = medicoTabla.especialidad
            }
            return medicoRepository.save(medicoTabla)

        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun updateWeight(medicoTabla: medicoTabla): medicoTabla {
        try {
            val response = medicoTabla.id?.let { medicoRepository.findById(it) }
                ?: throw Exception("Medico no Existe")
            response.apply {
                var nombres = medicoTabla.nombres;
                var especialidad = medicoTabla.especialidad;
            }
            return medicoRepository.save(medicoTabla)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )

        }
    }

    fun delete (id:Long): Boolean{
        medicoRepository.deleteById(id)
        return true
    }
}