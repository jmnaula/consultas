package com.mauricionaula.consultaapi.model

import javax.persistence.*

@Entity
@Table(name = "medico")
class medicoTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombres: String? = null
    var especialidad: String? = null

}