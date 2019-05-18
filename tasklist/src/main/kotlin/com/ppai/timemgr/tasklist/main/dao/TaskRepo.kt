package com.ppai.timemgr.tasklist.main.dao

import com.ppai.timemgr.tasklist.main.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories("com.ppai.timemgr.tasklist.main.dao")
interface TaskRepo: JpaRepository<Task, Long>