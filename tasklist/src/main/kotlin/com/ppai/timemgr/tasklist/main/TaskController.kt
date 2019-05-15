package com.ppai.timemgr.tasklist.main

import org.reactivestreams.Publisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class PersonController(@Autowired private val repository: TaskRepository) {

    @PostMapping("/task")
    internal fun create(@RequestBody personStream: Publisher<Task>): Any{
        return this.repository.save(personStream)
    }

    @GetMapping("/tasklist")
    internal fun list(): Flux<Task> {
        return this.repository.findAll()
    }

    @GetMapping("/task/{id}")
    internal fun findById(@PathVariable id: String): Mono<Task> {
        return this.repository.findOne(id)
    }
}