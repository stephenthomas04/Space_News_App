package com.example.hamburgertester;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class news_RecyclerViewAdapter extends RecyclerView.Adapter<news_RecyclerViewAdapter.MyViewHolder> {
    private final AppInterface appInterface;

    Context context;
    ArrayList<NewsObj> newsArrayList;

    public news_RecyclerViewAdapter(Context context, ArrayList<NewsObj> newsArrayList,  AppInterface appInterface){
        this.context = context;
        this.newsArrayList = newsArrayList;
        this.appInterface = appInterface;
    }

    @NonNull
    @Override
    public news_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news_row,parent,false);
        return new news_RecyclerViewAdapter.MyViewHolder(view, appInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull news_RecyclerViewAdapter.MyViewHolder holder, int position) {
        String imageUrl = newsArrayList.get(position).imageUrl;

        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_baseline_downloading_24)
                .error(R.drawable.galaxy)
                .override(320, 133)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(holder.image);

        SpannableString content = new SpannableString(newsArrayList.get(position).getNewsSite());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        holder.article.setText(content);
        holder.title.setText(newsArrayList.get(position).getTitle());
        holder.desc.setText(newsArrayList.get(position).getSummary());
        holder.date.setText(newsArrayList.get(position).getPublishedAt());

    }

    @Override
    public int getItemCount() {
        String num = String.valueOf(newsArrayList.size());

        Log.d("ArraySize", num);
        return newsArrayList.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView article, title, desc, date;

        public MyViewHolder(@NonNull View itemView, AppInterface appInterface) {
            super(itemView);

            image = itemView.findViewById(R.id.planetImage);
            article = itemView.findViewById(R.id.planetName);
            title = itemView.findViewById(R.id.newsHeadline);
            desc = itemView.findViewById(R.id.planetInfo);
            date = itemView.findViewById(R.id.publishDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(appInterface != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            appInterface.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
