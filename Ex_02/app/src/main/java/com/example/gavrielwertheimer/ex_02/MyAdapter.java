package com.example.gavrielwertheimer.ex_02;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Family> mDataSet;




    public MyAdapter(List<Family> data){

        mDataSet= data;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private ImageView mImageView;

        public MyViewHolder(View view){
            super(view);
            mTextView = view.findViewById(R.id.fullname);
            mImageView = view.findViewById(R.id.photo);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View familymember = inflater.inflate(R.layout.mylayout, viewGroup,false);

        MyViewHolder holder = new MyViewHolder(familymember);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        Family familyMember = mDataSet.get(i);
        TextView textView = viewHolder.mTextView;
        textView.setText(familyMember.name);
        ImageView imageView = viewHolder.mImageView;
        imageView.setImageDrawable(familyMember.photo);

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
