package com.ppai.timemgr.tasklist.main

import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepo : JpaRepository<Task, Long>