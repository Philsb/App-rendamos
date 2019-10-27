package com.example.app_rendamos;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_rendamos.data.model.StudentResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<StudentResponse> mNameList = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter (Context context, ArrayList<StudentResponse> stringPairsList){
        mContext = context;
        mNameList = stringPairsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        ViewHolder holder = new ViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d("Recycler View Adapter", "onBindViewHolder: called.");
        holder.name.setText(mNameList.get(position).getFirstName() + " " + mNameList.get(position).getLastName());
        holder.test.setText(mNameList.get(position).getForm().getName());
        holder.position = position;

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Recycler View Adapter", "onClick: clicked on: " + mNameList.get(position).getFirstName() + " " + mNameList.get(position).getLastName());

                Toast.makeText(mContext, mNameList.get(position).getFirstName() + " " + mNameList.get(position).getLastName(), Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(mContext, GalleryActivity.class);
                //intent.putExtra("image_url", mImages.get(position));
                // intent.putExtra("image_name", mImageNames.get(position));
                // mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNameList.size();
    }

    private void goToStudentInfo(Integer position){
        StudentResponse student = mNameList.get(position);
        Intent studentInfo = new Intent(mContext, StudentInfoActivity.class);
        studentInfo.putExtra("serialize_data", new Gson().toJson(mNameList.get(position)));
        mContext.startActivity(studentInfo);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView test;
        LinearLayout parentLayout;
        private final RecyclerViewAdapter adapter;
        public Integer position;
        public ViewHolder(@NonNull View itemView, final RecyclerViewAdapter adapter) {
            super(itemView);
            name = itemView.findViewById(R.id.textView3);
            test = itemView.findViewById(R.id.textView4);
            this.adapter = adapter;
            parentLayout = itemView.findViewById(R.id.parent_layout);
            name.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View view){
                   if(getAdapterPosition() != -1){
                       adapter.goToStudentInfo(getAdapterPosition());
                   }
               }
            });
        }
    }
}
