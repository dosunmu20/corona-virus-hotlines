package com.example.coronavirushelplines;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsPage extends AppCompatActivity implements View.OnClickListener {

   @BindView(R.id.newsBackArrow)
    AppCompatImageView newsBackArrow;

   @BindView(R.id.newsRV)
    RecyclerView newsRV;
   
   private List<NewsModel> news;
   private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_page);
        ButterKnife.bind(this);
        buildNewsRV();
        newsBackArrow.setOnClickListener(this);
    }
    
    public void fetchNewsItems(){
        news = new ArrayList<>();

        news.add(new NewsModel("GIS Live Update","https://gisanddata.maps.arcgis.com/apps/opsdashboard/index.html#/bda7594740fd40299423467b48e9ecf6"));
        news.add(new NewsModel("Aljazeera News","https://www.aljazeera.com/news/2020/03/toll-rises-coronavirus-tightens-global-grip-live-updates-200315231500487.html"));
        news.add(new NewsModel("BBC News ","https://www.bbc.com/news/coronavirus"));
        news.add(new NewsModel("CNN News","https://edition.cnn.com/specials/world/coronavirus-outbreak-intl-hnk"));
        news.add(new NewsModel("itv News","https://www.itv.com/news/channel/topic/coronavirus/"));
        news.add(new NewsModel("WHO News","https://www.who.int/emergencies/diseases/novel-coronavirus-2019"));
        news.add(new NewsModel("Channels TV News", "https://www.channelstv.com/category/health/coronavirus/"));
        news.add(new NewsModel("NCDC News/Media", "https://ncdc.gov.ng/news/weeks"));

        newsAdapter.setNewsAdapterItems(news);

    }

    public void buildNewsRV(){
        newsAdapter = new NewsAdapter(this);
        fetchNewsItems();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        newsRV.setAdapter(newsAdapter);
        newsRV.setLayoutManager(linearLayoutManager);
        newsRV.setNestedScrollingEnabled(false);
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
