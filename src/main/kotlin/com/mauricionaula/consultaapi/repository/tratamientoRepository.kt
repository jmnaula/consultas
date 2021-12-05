package com.mauricionaula.consultaapi.repository

import com.mauricionaula.consultaapi.model.tratamientoTabla
import org.springframework.data.jpa.repository.JpaRepository

interface tratamientoRepository:JpaRepository<tratamientoTabla,Long> {

}