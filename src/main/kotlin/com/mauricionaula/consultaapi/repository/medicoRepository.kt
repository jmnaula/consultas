package com.mauricionaula.consultaapi.repository

import com.mauricionaula.consultaapi.model.medicoTabla
import org.springframework.data.jpa.repository.JpaRepository

interface medicoRepository:JpaRepository<medicoTabla,Long> {

}