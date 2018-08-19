package br.com.alvaro.testeagilecontent;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;

import java.io.InputStream;

import br.com.alvaro.downloader.Downloader;
import br.com.alvaro.strutils.StringUtils;
import static  org.junit.Assert.*;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class DownloaderTest {

    @Test
    public void testDownload (){
        Downloader downloader = new Downloader(StringUtils.toURL("http://www.w3schools.com/w3css/img_lights.jpg"));
        InputStream is = downloader.getInputStreamfromURL();
        assertFalse(is ==null);
    }
}
