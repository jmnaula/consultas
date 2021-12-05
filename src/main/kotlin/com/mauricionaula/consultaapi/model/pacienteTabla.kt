package com.mauricionaula.consultaapi.model

import javax.persistence.*

@Entity
@Table(name = "paciente")
class pacienteTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombres: String? = null
    var edad: String? = null
    var talla: String? = null
    var peso: String? = null


}