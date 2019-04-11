package com.example.alumno.android04;

import android.util.Log;

import java.io.IOException;

/**
 * Created by alumno on 11/04/2019.
 */

public class MiHilo extends Thread {

    @Override
    public void run(){
        String datos="";
        Conexion conn = new Conexion("http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml");
        try {
            datos = conn.getStrDataByGET();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("mens", datos );
    }
}
