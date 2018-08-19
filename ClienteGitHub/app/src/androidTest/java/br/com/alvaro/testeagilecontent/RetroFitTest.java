package br.com.alvaro.testeagilecontent;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import br.com.alvaro.models.Repo;
import br.com.alvaro.retrofit.RetroFitCaller;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class RetroFitTest {

    @Test
    public void testCall (){
        RetroFitCaller caller = new RetroFitCaller();
        try {
            List<Repo> repos = caller.chamarGetRepoByUser("alvarowm").body();
            if (repos == null)
                assertTrue(false);
            assertTrue(repos.size() == 8);
        } catch (IOException e) {
            assertTrue(false);
        }
    }
}
