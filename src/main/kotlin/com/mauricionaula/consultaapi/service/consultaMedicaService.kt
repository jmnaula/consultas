package com.mauricionaula.consultaapi.service

import com.mauricionaula.consultaapi.model.consultaMedicaTabla
import com.mauricionaula.consultaapi.repository.consultaMedicaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class consultaMedicaService {
    @Autowired
    lateinit var consultaMedicaRepository: consultaMedicaRepository


    fun list(): List<consultaMedicaTabla> {

        return consultaMedicaRepository.findAll()
    }

    fun save(consultaMedicaTabla: consultaMedicaTabla): consultaMedicaTabla {
        try {
            if (consultaMedicaTabla.sintomas?.trim()?.isEmpty() == true) {
                throw Exception("Falta escribir los sintomas para continuar")
            }
            if (consultaMedicaTabla.antecedentesMedicos?.trim()?.isEmpty() == true) {
                throw Exception("Falta escribir los antecedentes medicos para continuar")
            }
            return consultaMedicaRepository.save(consultaMedicaTabla)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun update(consultaMedicaTabla: consultaMedicaTabla): consultaMedicaTabla {
        try {
            val response = consultaMedicaTabla.id?.let { consultaMedicaRepository.findById(it) }
                ?: throw Exception("Paciente no existe")
            response.apply {
                var sintomas = consultaMedicaTabla.sintomas
                var antecedentesMedicos = consultaMedicaTabla.antecedentesMedicos
            }
            return consultaMedicaRepository.save(consultaMedicaTabla)

        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun updateWeight(consultaMedicaTabla: consultaMedicaTabla): consultaMedicaTabla {
        try {
            val response = consultaMedicaTabla.id?.let { consultaMedicaRepository.findById(it) }
                ?: throw Exception("Consulta no existe")
            response.apply {
                var sintomas = consultaMedicaTabla.sintomas;
                var antecedentesMedicos = consultaMedicaTabla.antecedentesMedicos;
            }
            return consultaMedicaRepository.save(consultaMedicaTabla)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )

        }
    }


        fun delete(id: Long): Boolean {
            consultaMedicaRepository.deleteById(id)
            return true
        }
    }




