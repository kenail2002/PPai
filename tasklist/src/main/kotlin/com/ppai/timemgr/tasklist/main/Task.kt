package com.ppai.timemgr.tasklist.main

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Data
@Table
data class Task(
        @NotNull
        @Id //主键z
        @JsonProperty("id")
        val id: Long) {
    override fun toString(): String = "id=" + id
}