package com.modanisa.controller

import com.modanisa.model.entity.TaskEntity
import com.modanisa.model.dto.TaskToAdd
import com.modanisa.model.dto.TaskDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.modanisa.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import java.net.URI

@Tag(name = "ToDoList Controller", description = "Provide services for getting all task and adding new task to ToDoList")
@CrossOrigin("*")
@RestController
class TaskController(private val taskRepository: TaskRepository) {

    @Operation(summary = "Getting all tasks")
    @GetMapping("/")
    fun getAllTasks(): ResponseEntity<List<TaskDto>> {
        var taskDtoList = ArrayList<TaskDto>()
        var taskEntityList = taskRepository.findAll()
        taskEntityList.forEach {
            taskDtoList.add(TaskDto(it.id, it.title, it.note))
        };
        return ResponseEntity.ok(taskDtoList)
    }

    @Operation(summary = "Creating new task")
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun addTask(@RequestBody taskToAdd: TaskToAdd) {
        var taskEntity = TaskEntity()
        taskEntity.note = taskToAdd.note
        taskEntity.title = taskToAdd.title
        taskRepository.save(taskEntity)
    }

}