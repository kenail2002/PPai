package com.ppai.timemgr.tasklist.main

import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class TaskRepository {
    fun save(personStream: Publisher<Task>): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun findAll(): Flux<Task> {

    }

    fun findOne(id: String): Mono<Task> {
     }
}