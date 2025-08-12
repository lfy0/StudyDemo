package com.yw.game.studydemo.net
import java.net.HttpURLConnection
class PostTask(
    url: String?,
    params: String?,
    isNeedToken: Boolean,
    methodId: String,
    observerId: String,
    networkCallback: NetResponseCallback
) :
    AbstractNetwork(url, params) {
    var networkCallback: NetResponseCallback;

    init {
        this.networkCallback = networkCallback;
    }

    override fun success(result: String) {
        //解析json
    }

    override fun error(code: Int, error: String) {
        networkCallback.onFalied(code, error)
    }

    override fun setRequestProperty(httpURLConnection: HttpURLConnection): HttpURLConnection {
        return httpURLConnection
    }

    override fun connTimeOut(): Int {
        return 3000
    }

    override fun readTimeOut(): Int {
        return 3000
    }


}