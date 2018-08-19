package br.com.alvaro.strutils;

import android.util.Log;

import java.net.URL;

public class StringUtils {

    public static URL toURL(String str) {
        try {
            return new URL(str);
        } catch (Exception e) {
            Log.e("MalformedURLException:", str);
        }
        return null;
    }
}
