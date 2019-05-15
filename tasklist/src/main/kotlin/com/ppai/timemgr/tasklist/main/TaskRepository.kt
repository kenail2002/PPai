package com.ppai.timemgr.tasklist.main

import org.reactivestreams.Publisher
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository("repository")
class TaskRepository {
    fun save(personStream: Publisher<Task>): Any {
        System.out.println("save")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun findAll(): Flux<Task> {
        System.out.println("findAll")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    fun findOne(id: String): Mono<Task> {
        System.out.println("findOne")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }
}