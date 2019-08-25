package com.ppai.timemgr.tasklist

import com.ppai.timemgr.tasklist.main.Task
import com.ppai.timemgr.tasklist.main.TaskRepo
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import org.springframework.beans.factory.annotation.Autowired

class TaskSubscriber : Subscriber<Task> {
    @Autowired
    private val taskRepo: TaskRepo? = null

    override fun onSubscribe(subscription: Subscription) {
    }

    override fun onNext(o: Task) {
        taskRepo!!.save(o)
    }

    override fun onError(throwable: Throwable) {

    }

    override fun onComplete() {

    }
}
