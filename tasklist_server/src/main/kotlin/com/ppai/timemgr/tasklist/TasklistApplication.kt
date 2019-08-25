package com.ppai.timemgr.tasklist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication

class TasklistApplication

fun main(args: Array<String>) {
    runApplication<TasklistApplication>(*args)
}