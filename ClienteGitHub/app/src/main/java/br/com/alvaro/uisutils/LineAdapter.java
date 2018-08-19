package br.com.alvaro.uisutils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.alvaro.models.Repo;
import br.com.alvaro.testeagilecontent.R;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<Repo> repos;

    public LineAdapter(List<Repo> repos) {
        this.repos = repos;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        if (position <= repos.size()){
            holder.getTitle().setText(repos.get(position) != null && repos.get(position).getName() != null ? repos.get(position).getName() : "");
            holder.getLanguage().setText(repos.get(position) != null && repos.get(position).getLanguage() != null ? repos.get(position).getLanguage() : "");
        }
    }

    @Override
    public int getItemCount() {
        return repos != null ? repos.size() : 0;
    }

}
