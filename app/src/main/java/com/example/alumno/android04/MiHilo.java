package com.example.alumno.android04;

import android.app.Notification;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

/**
 * Created by alumno on 11/04/2019.
 */

public class MiHilo extends Thread {

    private Handler h;

    public MiHilo(Handler h){
        this.h = h;
    }

    @Override
    public void run(){
        Message m = new Message();

        String datos="";
        Conexion conn = new Conexion("http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml");
        try {
            datos = conn.getStrDataByGET();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("mensaje servidor", datos );
        m.obj = datos;
        h.sendMessage(m);


    }
}
