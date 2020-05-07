package com.mindorks.ridesharing.ui.maps

import android.util.Log
import com.mindorks.ridesharing.data.network.NetworkService
import com.mindorks.ridesharing.simulator.WebSocket
import com.mindorks.ridesharing.simulator.WebSocketListener

class MapsPresenter (private val networkService: NetworkService): WebSocketListener {

    companion object {
        private const val TAG = "MapsPresenter"
    }

    private var view: MapsView? = null
    private lateinit var webSocket: WebSocket

    fun onAttach(view: MapsView){
        this.view = view
        webSocket = networkService.createWebSocketListener(this)
        webSocket.connect()
    }

    fun onDetach(){
        webSocket.disconnect()
        view = null
    }

    override fun onConnect() {
        Log.d(TAG,"onConnect" )
    }

    override fun onMessage(data: String) {
        Log.d(TAG,"onMessage: $data" )
    }

    override fun onDisconnect() {
        Log.d(TAG,"onDisconnect" )
    }

    override fun onError(error: String) {
        Log.d(TAG,"onError: $error" )
    }


}