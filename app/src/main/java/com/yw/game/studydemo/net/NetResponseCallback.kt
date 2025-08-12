package com.yw.game.studydemo.net

import org.json.JSONObject

interface NetResponseCallback {

    fun onSuccess(data:JSONObject)

    fun onFalied(code:Int,error:String)

}