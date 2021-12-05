package com.mauricionaula.consultaapi.service

import com.mauricionaula.consultaapi.model.consultaMedicaTabla
import com.mauricionaula.consultaapi.repository.consultaMedicaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class consultaMedicaService {
    @Autowired
    lateinit var consultaMedicaRepository: consultaMedicaRepository


    fun list(): List<consultaMedicaTabla> {

        return consultaMedicaRepository.findAll()
    }
    fun save(consultaMedicaTabla: consultaMedicaTabla):consultaMedicaTabla{
        return consultaMedicaRepository.save(consultaMedicaTabla)
    }

    fun update(consultaMedicaTabla: consultaMedicaTabla):consultaMedicaTabla{
        return consultaMedicaRepository.save(consultaMedicaTabla)
    }

    fun delete (id:Long): Boolean{
        consultaMedicaRepository.deleteById(id)
        return true
    }
}