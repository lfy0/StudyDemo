package com.yw.game.studydemo.net

import java.net.HttpURLConnection

abstract class AbstractNetwork(url: String?, params: String?, isNeedToken: Boolean) : Runnable {

    init {
        if (url == null) {
            throw NullPointerException("url is null")
        }
    }

    fun realPost() {
        //网络请求流的读写
    }

    constructor(url: String?, params: String?) : this(url, params, true)

    override fun run() {
        realPost()
    }

    abstract fun success(result: String);

    abstract fun error(code: Int, error: String);

    abstract fun setRequestProperty(httpURLConnection: HttpURLConnection): HttpURLConnection?

    abstract fun connTimeOut():Int

    abstract fun readTimeOut():Int

}