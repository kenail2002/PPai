package com.ppai.timemgr.tasklist.main

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository("repository")
class TaskRepository(@Autowired private val taskRepo: TaskRepo) {

    fun save(personStream: List<Task>): Any {
        System.out.println("save")
        println((personStream))
        personStream.forEach { taskRepo!!.save(it) }

//        personStream.subscribe(TaskSubscriber())
        return true
    }

    fun findAll(): Flux<Task> {

        TODO("")
    }

    fun findOne(id: String): Mono<Task> {
        System.out.println("findOne")
        TODO("")


    }
}
