package com.mauricionaula.consultaapi.controllers

import com.mauricionaula.consultaapi.model.consultaMedicaTabla
import com.mauricionaula.consultaapi.model.tratamientoTabla
import com.mauricionaula.consultaapi.service.consultaMedicaService
import com.mauricionaula.consultaapi.service.tratamientoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class tratamientoController {
    @Autowired
    lateinit var tratamientoService: tratamientoService

    @GetMapping
    fun list(): List<tratamientoTabla>{
        return tratamientoService.list()
    }
    @PostMapping
    fun save(@RequestBody tratamientoTabla: tratamientoTabla):tratamientoTabla{
        return tratamientoService.save(tratamientoTabla)
    }

    @PutMapping
    fun update (@RequestBody tratamientoTabla: tratamientoTabla):tratamientoTabla{
        return tratamientoService.update(tratamientoTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return tratamientoService.delete(id)
    }



}
