package br.com.alvaro.retrofit;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import br.com.alvaro.models.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RetroFitCaller implements Callback<List<Repo>> {

    private final Retrofit retrofit;
    private final EndPoints endPoints;

    public RetroFitCaller() {

        retrofit = new Builder().build();

        endPoints = retrofit.create(EndPoints.class);
    }

    public Response<List<Repo>> chamarGetRepoByUser(String user) throws IOException {
        Call<List<Repo>> call = endPoints.getRepoByUser(user);
        return call.execute();
    }

    @Override
    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
        Log.i("Response is ok: ", String.valueOf(response.code()));
    }

    @Override
    public void onFailure(Call<List<Repo>> call, Throwable t) {
        Log.e("Error:calling Retrofit:", t.getMessage());
    }
}
