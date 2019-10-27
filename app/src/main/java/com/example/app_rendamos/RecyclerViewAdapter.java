package com.example.app_rendamos;

import android.content.Context;
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

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<Pair<String,String>> mNameList = new ArrayList<Pair<String,String>>();
    private Context mContext;

    public RecyclerViewAdapter (Context context, ArrayList<Pair<String,String>> stringPairsList){
        mContext = context;
        mNameList = stringPairsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d("Recycler View Adapter", "onBindViewHolder: called.");
        holder.name.setText(mNameList.get(position).first);
        holder.test.setText(mNameList.get(position).second);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Recycler View Adapter", "onClick: clicked on: " + mNameList.get(position).first);

                Toast.makeText(mContext, mNameList.get(position).first, Toast.LENGTH_SHORT).show();

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

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView test;
        LinearLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView3);
            test = itemView.findViewById(R.id.textView4);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
