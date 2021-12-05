package com.mauricionaula.consultaapi.repository

import com.mauricionaula.consultaapi.model.consultaMedicaTabla
import org.springframework.data.jpa.repository.JpaRepository

interface consultaMedicaRepository:JpaRepository<consultaMedicaTabla,Long> {

}