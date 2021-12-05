package com.mauricionaula.consultaapi.repository

import com.mauricionaula.consultaapi.model.pacienteTabla
import org.springframework.data.jpa.repository.JpaRepository

interface pacienteRepository:JpaRepository<pacienteTabla,Long> {

}