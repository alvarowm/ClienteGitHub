package br.com.alvaro.testeagilecontent;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.alvaro.retrofit.Builder;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class RetroFitBuilderTest {

    @Test
    public void testeBuilder (){
        Builder builder = new Builder();
        assertTrue(builder.build() != null);

    }

}
