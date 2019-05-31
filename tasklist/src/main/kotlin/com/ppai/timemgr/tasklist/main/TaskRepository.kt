package com.ppai.timemgr.tasklist.main

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import java.util.*

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
        return taskRepo!!.findAll().toFlux()

    }

    fun findOne(id: Long): Mono<Optional<Task>> {
        System.out.println("findOne")
        return (taskRepo!!.findById(id)).toMono()
    }
}
