package br.com.alvaro.testeagilecontent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import br.com.alvaro.downloader.Downloader;
import br.com.alvaro.models.Repo;
import br.com.alvaro.strutils.StringUtils;
import br.com.alvaro.uisutils.LineAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class ListActivity extends AppCompatActivity {

    private static ProgressDialog progressDialog;
    private static CircleImageView imageView;

    private final String LOADING = "Loading user details...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(LOADING);

        imageView = (CircleImageView) findViewById(R.id.imageView1);
        RecyclerView recyclerView =  findViewById(R.id.recycler_view);

        Intent i = getIntent();
        @SuppressWarnings("unchecked")
        List<Repo> listRepos = (List<Repo>) i.getSerializableExtra("repos");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        LineAdapter adapter = new LineAdapter(listRepos);

        recyclerView.setAdapter(adapter);

        TextView textCenter = findViewById(R.id.textViewCenter);
        textCenter.setText(listRepos.get(0).getOwner().getLogin());

        new DownloadTask().execute(StringUtils.toURL(listRepos.get(0).getOwner().getAvatarUrl()));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private static class DownloadTask extends AsyncTask<URL, Void, Bitmap> {

        protected void onPreExecute() {
            progressDialog.show();
        }

        protected Bitmap doInBackground(URL... urls) {
            InputStream is = new Downloader(urls[0]).getInputStreamfromURL();

            BufferedInputStream stream = new BufferedInputStream(is);
            return BitmapFactory.decodeStream(stream);

        }

        protected void onPostExecute(Bitmap bitmap) {
            progressDialog.dismiss();

            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }


}
