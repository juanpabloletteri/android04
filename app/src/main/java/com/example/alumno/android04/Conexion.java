package com.example.alumno.android04;

/**
 * Created by alumno on 11/04/2019.
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by alumno on 11/04/2019.
 */

public class Conexion {

    private String url;
    private HttpURLConnection conn;
    public Conexion(String url)
    {
        conn = crearHttpUrlConn(url);
    }


    private HttpURLConnection crearHttpUrlConn(String strUrl)
    {
        URL url = null;

        try {
            url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            return urlConnection;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public byte[] getBytesDataByGET() throws IOException {

        conn.setRequestMethod("GET");
        conn.connect();
        int response = conn.getResponseCode();
        if(response==200) {
            InputStream is = conn.getInputStream();
            return readFully(is);
        }
        else
            throw new IOException();
    }


    private byte[] readFully(InputStream inputStream) throws
            IOException
    {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        inputStream.close();
        return baos.toByteArray();
    }

    public String getStrDataByGET() throws IOException {
        byte[] bytes = getBytesDataByGET();
        return new String(bytes,"UTF-8");
    }

}

