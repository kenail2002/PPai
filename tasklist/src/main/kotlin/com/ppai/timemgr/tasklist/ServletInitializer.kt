package com.ppai.timemgr.tasklist

import com.ppai.timemgr.tasklist.main.TaskRepo
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackageClasses = arrayOf(TaskRepo::class))
@EntityScan(basePackages = arrayOf("com.ppai.timemgr.tasklist.main"))

class ServletInitializer : SpringBootServletInitializer() {
    companion object {
        init {
            println("系统启动")
            ClassPathXmlApplicationContext("applicationContext.xml")
        }
    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(TasklistApplication::class.java)
    }

}
