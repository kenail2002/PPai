package com.ppai.timemgr.tasklist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication//(exclude = arrayOf(DataSourceAutoConfiguration::class))
class TasklistApplication

fun main(args: Array<String>) {
    val runApplication = runApplication<TasklistApplication>(*args)
    System.out.println("你好啊")
}
