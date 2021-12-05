package com.mauricionaula.consultaapi.model

import javax.persistence.*

@Entity
@Table(name = "consultamedica")
class consultaMedicaTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var sintomas: Long? = null
    var antecedentesMedicos: String? = null

}