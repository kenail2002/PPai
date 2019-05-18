package com.ppai.timemgr.tasklist.main

import lombok.Data
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Data
@Table
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
class Task {
    @Id //主键z
    private val id: Long? = null
}