package com.ppai.timemgr.tasklist.main

import org.reactivestreams.Publisher
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class PersonController(private val repository: TaskRepository) {

    @PostMapping("/task")
    internal fun create(@RequestBody personStream: Publisher<Task>): Mono<Void> {
        return this.repository.save(personStream).then()
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