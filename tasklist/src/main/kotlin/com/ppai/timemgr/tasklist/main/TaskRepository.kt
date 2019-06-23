package com.ppai.timemgr.tasklist.main

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import java.util.*

@Repository("repository")
class TaskRepository(@Autowired private val taskRepo: TaskRepo) {

    fun save(personStream: Task): Any {
        System.out.println("save")
        println((personStream))
        taskRepo.save(personStream)

//        personStream.subscribe(TaskSubscriber())
        return true
    }

    fun findAll(): Flux<Task> {
        return taskRepo.findAll().toFlux()

    }

    fun findOne(id: Long): Mono<Optional<Task>> {
        System.out.println("findOne")
        return (taskRepo.findById(id)).toMono()
    }

    fun pageQuery(pageData: Pageable): Flux<Task> {
        return (taskRepo.findAll(pageData)).toFlux()
    }

    fun deleteById(id: Long): Unit {
        taskRepo.deleteById(id)
    }
}
