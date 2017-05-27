package com.example.giventrisjeremia.databinding.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giventrisjeremia.databinding.R;
import com.example.giventrisjeremia.databinding.model.QuotesEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Giventris Jeremia on 21/05/2017.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
    private List<QuotesEntity> mQuotesEntity;
    private Context mContext;

    public AdapterMain(Context mContext,List<QuotesEntity> mQuotesEntity){
        this.mQuotesEntity = mQuotesEntity;
        this.mContext = mContext;
    }

    @Override
    public AdapterMain.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(parent.getContext());
        View view = l.inflate(R.layout.item_home_view,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterMain.ViewHolder holder, final int position) {
        QuotesEntity a = mQuotesEntity.get(position);
        holder.textView1.setText(a.getJudul());
        holder.textView2.setText(a.getTentang());
        holder.textView3.setText(a.getIsi());
        //Picasso.with(mContext).load(a.getIsi()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mQuotesEntity.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.tv_name);
            textView2 = (TextView) itemView.findViewById(R.id.tv_tipe);
            textView3 = (TextView) itemView.findViewById(R.id.tv_list);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
