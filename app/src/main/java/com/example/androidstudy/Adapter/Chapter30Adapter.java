package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.R;
import com.example.androidstudy.chapter28.AsyncDownHtml;
import com.example.androidstudy.chapter28.DownImage;
import com.example.androidstudy.chapter28.Downlmage2;
import com.example.androidstudy.chapter28.DownloadManagerActivity;
import com.example.androidstudy.chapter28.JSONArrayActivity;
import com.example.androidstudy.chapter29.DetectFreeActivity;
import com.example.androidstudy.chapter29.NapAlarm;
import com.example.androidstudy.chapter30.CalcClientActivity;
import com.example.androidstudy.chapter30.NewsController;
import com.example.androidstudy.chapter30.NewsController2;
import com.example.androidstudy.chapter30.NewsService;

import java.util.ArrayList;

public class Chapter30Adapter extends RecyclerView.Adapter<com.example.androidstudy.Adapter.MyHolder30> {
    private ArrayList<String> list;

    public Chapter30Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public com.example.androidstudy.Adapter.MyHolder30 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new com.example.androidstudy.Adapter.MyHolder30(view);
    }

    @Override
    public void onBindViewHolder(com.example.androidstudy.Adapter.MyHolder30 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), NewsController.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), NewsController2.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), CalcClientActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), DownImage.class);
                    v.getContext().startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(v.getContext(), Downlmage2.class);
                    v.getContext().startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(v.getContext(), DownloadManagerActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(v.getContext(), JSONArrayActivity.class);
                    v.getContext().startActivity(intent);
                    break;
            }

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyHolder30 extends RecyclerView.ViewHolder {
    TextView tv;

    public MyHolder30(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}