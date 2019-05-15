package com.ppai.timemgr.tasklist.main

import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.annotation.Resource

@Resource(name="repository")
class TaskRepository {
    fun save(personStream: Publisher<Task>): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun findAll(): Flux<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    fun findOne(id: String): Mono<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }
}