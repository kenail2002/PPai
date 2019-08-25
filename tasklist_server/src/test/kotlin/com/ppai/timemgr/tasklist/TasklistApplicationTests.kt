package com.ppai.timemgr.tasklist

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import java.io.File

@RunWith(SpringRunner::class)
@ContextConfiguration(locations = arrayOf("classpath:applicationContext.xml"))
@SpringBootTest
class TasklistApplicationTests {

    @Test
    fun contextLoads() {
        val path = "d:\\test"
        val fileName="a.txt"
        val dest = File("$path\\$fileName")
        if (!dest.parentFile.exists()) { //判断文件父目录是否存在
            dest.parentFile.mkdir()
        }
        dest.writeText("hello")
    }


}
