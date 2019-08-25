package com.ppai.timemgr.tasklist.main

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.util.*

@Repository("repository")
class TaskRepository(@Autowired private val taskRepo: TaskRepo) {

    fun save(personStream: Task): Any {
        println((personStream))
        taskRepo.save(personStream)

//        personStream.subscribe(TaskSubscriber())
        return true
    }

    fun findAll(): List<Task> {
        return taskRepo.findAll()

    }

    fun findOne(id: Long): Optional<Task> {
        return taskRepo.findById(id)
    }

    fun pageQuery(pageData: Pageable): Page<Task> {
        return taskRepo.findAll(pageData)
    }

    fun deleteById(id: Long) {
        taskRepo.deleteById(id)
    }
}
