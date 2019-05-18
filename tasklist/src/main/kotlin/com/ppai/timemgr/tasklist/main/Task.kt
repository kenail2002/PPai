package com.ppai.timemgr.tasklist.main

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Data
@Table
class Task {
    @Id //主键z
    private val id: Long? = null
}