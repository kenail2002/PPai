package com.ppai.timemgr.tasklist.main

import com.ppai.timemgr.tasklist.TaskSubscriber
import com.ppai.timemgr.tasklist.main.dao.TaskRepo
import org.reactivestreams.Publisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository("repository")
class TaskRepository {
    @Autowired
    private val taskRepo: TaskRepo? = null

    fun save(personStream: Publisher<Task>): Any {
        System.out.println("save")
        personStream.subscribe(TaskSubscriber())
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
