package com.mauricionaula.consultaapi.model

import javax.persistence.*

@Entity
@Table(name = "tratamiento")
class tratamientoTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var medicina: String? = null
    var controles: String? = null
    var reposo: String? = null

}