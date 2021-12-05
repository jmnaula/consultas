package com.mauricionaula.consultaapi.controllers

import com.mauricionaula.consultaapi.model.consultaMedicaTabla
import com.mauricionaula.consultaapi.service.consultaMedicaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/consulta")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class consultaMedicaController {
    @Autowired
    lateinit var consultaMedicaService: consultaMedicaService

    @GetMapping
    fun list(): List<consultaMedicaTabla>{
        return consultaMedicaService.list()
    }
    @PostMapping
    fun save(@RequestBody consultaMedicaTabla: consultaMedicaTabla):consultaMedicaTabla{
        return consultaMedicaService.save(consultaMedicaTabla)
    }

    @PutMapping
    fun update (@RequestBody consultaMedicaTabla: consultaMedicaTabla):consultaMedicaTabla{
        return consultaMedicaService.update(consultaMedicaTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return consultaMedicaService.delete(id)
    }



}
