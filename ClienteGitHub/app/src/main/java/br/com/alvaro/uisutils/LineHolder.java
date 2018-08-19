package br.com.alvaro.uisutils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.alvaro.testeagilecontent.R;

public class LineHolder extends RecyclerView.ViewHolder{

    private TextView title;
    private TextView language;

    public LineHolder(View itemView)  {
        super(itemView);
        title = itemView.findViewById(R.id.texttitle);
        language = itemView.findViewById(R.id.textlanguage);

    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getLanguage() {
        return language;
    }

    public void setLanguage(TextView language) {
        this.language = language;
    }
}
