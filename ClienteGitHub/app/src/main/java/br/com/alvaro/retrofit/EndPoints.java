package br.com.alvaro.retrofit;

import java.util.List;

import br.com.alvaro.models.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface EndPoints {

    @GET("users/{username}/repos")
    Call<List<Repo>> getRepoByUser(@Path("username") String username);
}
