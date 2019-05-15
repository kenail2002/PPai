package com.ppai.timemgr.tasklist

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ContextConfiguration(locations=arrayOf("classpath:applicationContext.xml"))
@SpringBootTest
class TasklistApplicationTests {

	@Test
	fun contextLoads() {
	}

}
