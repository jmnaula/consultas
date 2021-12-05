package com.mauricionaula.consultaapi.service

import com.mauricionaula.consultaapi.model.medicoTabla
import com.mauricionaula.consultaapi.repository.medicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class medicoService {
    @Autowired
    lateinit var medicoRepository: medicoRepository


    fun list(): List<medicoTabla> {

        return medicoRepository.findAll()
    }
    fun save(medicoTabla: medicoTabla):medicoTabla{
        return medicoRepository.save(medicoTabla)
    }

    fun update(medicoTabla: medicoTabla):medicoTabla{
        return medicoRepository.save(medicoTabla)
    }

    fun delete (id:Long): Boolean{
        medicoRepository.deleteById(id)
        return true
    }
}