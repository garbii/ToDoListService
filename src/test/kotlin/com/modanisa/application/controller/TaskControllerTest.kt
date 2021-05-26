package com.modanisa.application.controller

import com.modanisa.model.dto.TaskDto
import com.modanisa.model.dto.TaskToAdd
import com.modanisa.repository.TaskRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @MockBean
    private lateinit var taskRepository: TaskRepository

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `getAllTask method should return 200`() {
        class TaskDtoList : MutableList<TaskDto> by ArrayList()
        val entity  = restTemplate.getForEntity("/", TaskDtoList::class.java)
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun `addTask method should return 200`() {
        restTemplate.postForObject("/add", TaskToAdd("Test","Test") , TaskToAdd::class.java)
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }

}