package com.mauricionaula.consultaapi.service

import com.mauricionaula.consultaapi.model.pacienteTabla
import com.mauricionaula.consultaapi.repository.pacienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class pacienteService {
    @Autowired
    lateinit var pacienteRepository: pacienteRepository


    fun list(): List<pacienteTabla> {

        return pacienteRepository.findAll()
    }
    fun save(pacienteTabla: pacienteTabla):pacienteTabla{
        return pacienteRepository.save(pacienteTabla)
    }

    fun update(pacienteTabla: pacienteTabla):pacienteTabla{
        return pacienteRepository.save(pacienteTabla)
    }

    fun delete (id:Long): Boolean{
        pacienteRepository.deleteById(id)
        return true
    }
}