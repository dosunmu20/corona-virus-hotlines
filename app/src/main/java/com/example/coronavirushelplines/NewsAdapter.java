package com.example.coronavirushelplines;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

     private List<NewsModel> news;
     private Context context;

     public NewsAdapter(Context context){
         this.context =context;
     }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, final int position) {
        holder.newsPage.setText(news.get(position).getNewsPageTile());

        final String newsUrl = news.get(position).getNewsURL().trim();

        holder.newsPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(newsUrl));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news == null ? 0 : news.size();
    }

    public void setNewsAdapterItems(List<NewsModel> news){
        if (news != null) {
            if(this.news != null) this.news.clear();
            this.news = news;
            notifyDataSetChanged();
        } else return;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView newsPage;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsPage = itemView.findViewById(R.id.newsChannel);
        }
    }
}
