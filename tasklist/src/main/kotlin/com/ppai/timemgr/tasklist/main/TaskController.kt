package com.ppai.timemgr.tasklist.main

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
class TaskController(@Autowired private val repository: TaskRepository) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/task", consumes = arrayOf(APPLICATION_STREAM_JSON_VALUE, APPLICATION_JSON_VALUE))
    internal fun create(@RequestBody personStream: List<Task>): Any {
        return this.repository.save(personStream)
    }

    @GetMapping("/tasklist")
    internal fun list(): Flux<Task> {
        return this.repository.findAll()
    }

    @GetMapping("/task/{id}")
    internal fun findById(@PathVariable id: Long): Mono<Optional<Task>> {
        return this.repository.findOne(id)
    }
}