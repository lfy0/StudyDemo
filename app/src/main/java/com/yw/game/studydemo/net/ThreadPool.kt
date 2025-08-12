package com.yw.game.studydemo.net

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * 线程池管理
 */
class ThreadPool private constructor(var tag: Int) {


    var hieExecutor: ExecutorService? = null;

    var midedExecutor: ExecutorService? = null;

    var lowExecutor: ExecutorService? = null;

    companion object {

        const val High_Exec = 0
        const val Mede_Exec = 1
        const val Low_Exec = 3

        private var instance: ThreadPool? = null

        fun getInstance(tag: Int): ThreadPool {

            var commpaninInstance = instance;
            if (commpaninInstance != null) {
                return commpaninInstance
            }
            return synchronized(this) {
                var synchronizedInstance = instance
                if (synchronizedInstance != null) {
                    synchronizedInstance
                } else {
                    val newInstance = ThreadPool(tag);
                    instance = newInstance
                    newInstance
                }
            }
        }
    }

    fun getExecutor(): ExecutorService? {
        var exector: ExecutorService? = hieExecutor;
        when (tag) {
            High_Exec -> {
                hieExecutor = Executors.newSingleThreadExecutor()
                exector = hieExecutor;
            }

            Mede_Exec -> {
                midedExecutor = Executors.newCachedThreadPool()
                exector = midedExecutor
            }

            Low_Exec -> {
                lowExecutor = Executors.newFixedThreadPool(3)
                exector = lowExecutor
            }
        }
        return exector;
    }


    fun downExecutor() {
        hieExecutor?.shutdown()
        midedExecutor?.shutdown()
        lowExecutor?.shutdown()
    }


}