package com.mauricionaula.consultaapi.service

import com.mauricionaula.consultaapi.model.tratamientoTabla
import com.mauricionaula.consultaapi.repository.tratamientoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class tratamientoService {
    @Autowired
    lateinit var tratamientoRepository: tratamientoRepository


    fun list(): List<tratamientoTabla> {

        return tratamientoRepository.findAll()
    }
    fun save(tratamientoTabla: tratamientoTabla):tratamientoTabla{
        return tratamientoRepository.save(tratamientoTabla)
    }

    fun update(tratamientoTabla: tratamientoTabla):tratamientoTabla{
        return tratamientoRepository.save(tratamientoTabla)
    }

    fun delete (id:Long): Boolean{
        tratamientoRepository.deleteById(id)
        return true
    }
}