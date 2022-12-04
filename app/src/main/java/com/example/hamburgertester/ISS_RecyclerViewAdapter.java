
package com.example.hamburgertester;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ISS_RecyclerViewAdapter extends RecyclerView.Adapter<ISS_RecyclerViewAdapter.issViewHolder> {
    private final AppInterface issInterface;
    Context context;
    ArrayList<IssReportsObj> reportsObjArrayList;

    public ISS_RecyclerViewAdapter(Context context, ArrayList<IssReportsObj> reportsObjArrayList,  AppInterface issInterface) {
        this.context = context;
        this.reportsObjArrayList = reportsObjArrayList;
        this.issInterface = issInterface;
    }

    @NonNull
    @Override
    public ISS_RecyclerViewAdapter.issViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.iss_row,parent,false);

        return new ISS_RecyclerViewAdapter.issViewHolder(view, issInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ISS_RecyclerViewAdapter.issViewHolder holder, int position) {
        holder.issTitle.setText(reportsObjArrayList.get(position).getReportTitle());
        holder.summary.setText(reportsObjArrayList.get(position).getSummary());
    }

    @Override
    public int getItemCount() {
        return reportsObjArrayList.size();
    }



    public static class issViewHolder extends RecyclerView.ViewHolder{
        TextView issTitle, summary;

        public issViewHolder(@NonNull View itemView, AppInterface appInterface) {
            super(itemView);

            issTitle = itemView.findViewById(R.id.issTitle);
            summary = itemView.findViewById(R.id.issDesc);


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

