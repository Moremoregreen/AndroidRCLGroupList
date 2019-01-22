package com.moremoregreen.androidrclgrouplist.Adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.moremoregreen.androidrclgrouplist.Common.Common;
import com.moremoregreen.androidrclgrouplist.Interface.IOnAlphabetClickListener;
import com.moremoregreen.androidrclgrouplist.R;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.MyViewHolder> {

    List<String> alphabetList;
    IOnAlphabetClickListener iOnAlphabetClickListener;
    public AlphabetAdapter() {
        alphabetList = Common.genAlphabet();
    }

    public void setiOnAlphabetClickListener(IOnAlphabetClickListener iOnAlphabetClickListener) {
        this.iOnAlphabetClickListener = iOnAlphabetClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alphabet_item,viewGroup,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        TextDrawable drawable;
        //Get available position of character
        final int available_position = Common.alphabet_available.indexOf(alphabetList.get(i));
        if (available_position != -1){
            drawable = TextDrawable.builder().buildRound(alphabetList.get(i),Color.GREEN);
        }else {
            drawable = TextDrawable.builder().buildRound(alphabetList.get(i),Color.GRAY);
        }
        myViewHolder.alphabet_avatar.setImageDrawable(drawable);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //當使用者點了字母,回到Mainactivity and scroll to position of first character
                iOnAlphabetClickListener.onAlphabetClickListener(alphabetList.get(i),available_position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alphabetList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView alphabet_avatar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            alphabet_avatar = itemView.findViewById(R.id.alphabet_avatar);
        }
    }
}
