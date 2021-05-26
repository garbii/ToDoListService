package com.modanisa.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 1L;
    lateinit var title: String;
    lateinit var note: String;
}