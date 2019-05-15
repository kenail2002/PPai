package com.ppai.timemgr.tasklist

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.support.ClassPathXmlApplicationContext

//@ImportResource(locations = arrayOf("classpath*:applicationContext.xml"))
class ServletInitializer : SpringBootServletInitializer() {
    companion object {
        init {
            ClassPathXmlApplicationContext("applicationContext.xml")
        }
    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(TasklistApplication::class.java)
    }

}
