package com.example.ecibcoin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.jacksonandroidnetworking.JacksonParserFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Stiri extends AppCompatActivity {
    // TODO : set the API_KEY variable to your api key
    private static  String API_KEY="2a37b99812ee4111bad4fa50af7fb74a";


    private static String TAG="Stiri";


    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;


    private ArrayList<NewsArticle> mArticleList;

    private ArticleAdapter mArticleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiri);

        AndroidNetworking.initialize(getApplicationContext());
        Objects.requireNonNull(getSupportActionBar()).hide();

        AndroidNetworking.setParserFactory(new JacksonParserFactory());


        mProgressBar=(ProgressBar)findViewById(R.id.progressbar_id);
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerview_id);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mArticleList=new ArrayList<>();


        get_news_from_api();
    }

    public void get_news_from_api(){

        mArticleList.clear();


        AndroidNetworking.get("https://newsapi.org/v2/everything?q=bitcoin")
                //.addQueryParameter("country", "ro")
                //.addQueryParameter("category" , "technology")
                .addQueryParameter("apiKey",API_KEY)
                .addHeaders("token", "1234")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener(){
                    @Override
                    public void onResponse(JSONObject response) {

                        mProgressBar.setVisibility(View.GONE);


                        try {


                            JSONArray articles=response.getJSONArray("articles");

                            for (int j=0;j<articles.length();j++)
                            {

                                JSONObject article=articles.getJSONObject(j);


                                NewsArticle currentArticle=new NewsArticle();


                                String author=article.getString("author");
                                String title=article.getString("title");
                                String description=article.getString("description");
                                String url=article.getString("url");
                                String urlToImage=article.getString("urlToImage");
                                String publishedAt=article.getString("publishedAt");
                                String content=article.getString("content");


                                currentArticle.setAuthor(author);
                                currentArticle.setTitle(title);
                                currentArticle.setDescription(description);
                                currentArticle.setUrl(url);
                                currentArticle.setUrlToImage(urlToImage);
                                currentArticle.setPublishedAt(publishedAt);
                                currentArticle.setContent(content);

                                mArticleList.add(currentArticle);
                            }

                            mArticleAdapter=new ArticleAdapter(getApplicationContext(),mArticleList);
                            mRecyclerView.setAdapter(mArticleAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();

                            Log.d(TAG,"Error : "+e.getMessage());
                        }

                    }
                    @Override
                    public void onError(ANError error) {

                        Log.d(TAG,"Error detail : "+error.getErrorDetail());
                        Log.d(TAG,"Error response : "+error.getResponse());
                    }
                });
    }
}