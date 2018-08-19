package br.com.alvaro.downloader;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

    private final String DOWNLOAD_ERROR = "Download Error";

    private final URL url;

    public Downloader(URL url) {
        this.url = url;
    }

    public InputStream getInputStreamfromURL() {
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) this.url.openConnection();
            connection.connect();
            return connection.getInputStream();
        } catch (IOException e) {
            Log.e(DOWNLOAD_ERROR, this.url.toString());
            return null;
        } finally {
            if(connection != null)
            connection.disconnect();
        }
    }
}
