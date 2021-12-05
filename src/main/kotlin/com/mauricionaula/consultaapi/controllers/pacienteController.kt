package com.mauricionaula.consultaapi.controllers

import com.mauricionaula.consultaapi.model.pacienteTabla
import com.mauricionaula.consultaapi.service.pacienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/paciente")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class pacienteController {
    @Autowired
    lateinit var pacienteService: pacienteService

    @GetMapping
    fun list(): List<pacienteTabla>{
        return pacienteService.list()
    }
    @PostMapping
    fun save(@RequestBody pacienteTabla: pacienteTabla):pacienteTabla{
        return pacienteService.save(pacienteTabla)
    }

    @PutMapping
    fun update (@RequestBody pacienteTabla: pacienteTabla):pacienteTabla{
        return pacienteService.update(pacienteTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return pacienteService.delete(id)
    }



}
