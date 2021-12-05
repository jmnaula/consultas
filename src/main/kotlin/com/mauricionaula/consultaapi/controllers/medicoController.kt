package com.mauricionaula.consultaapi.controllers

import com.mauricionaula.consultaapi.model.consultaMedicaTabla
import com.mauricionaula.consultaapi.model.medicoTabla
import com.mauricionaula.consultaapi.model.tratamientoTabla
import com.mauricionaula.consultaapi.service.consultaMedicaService
import com.mauricionaula.consultaapi.service.medicoService
import com.mauricionaula.consultaapi.service.tratamientoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/medico")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class medicoController {
    @Autowired
    lateinit var medicoService: medicoService

    @GetMapping
    fun list(): List<medicoTabla>{
        return medicoService.list()
    }
    @PostMapping
    fun save(@RequestBody medicoTabla: medicoTabla):medicoTabla{
        return medicoService.save(medicoTabla)
    }

    @PutMapping
    fun update (@RequestBody medicoTabla: medicoTabla):medicoTabla{
        return medicoService.update(medicoTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return medicoService.delete(id)
    }



}
