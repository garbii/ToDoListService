package com.modanisa.repository

import com.modanisa.model.entity.TaskEntity
import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<TaskEntity, Long> {
}