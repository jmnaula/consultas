package com.mauricionaula.consultaapi.model

import javax.persistence.*

@Entity
@Table(name = "medico")
class medicoTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var nombres: Long? = null
    var especialidad: String? = null

}