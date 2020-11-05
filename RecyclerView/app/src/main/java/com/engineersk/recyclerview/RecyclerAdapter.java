package com.engineersk.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<User> mUsers;
    private final Context mContext;

    public RecyclerAdapter(Context context, List<User> users) {
        mUsers = users;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User sampleUser = mUsers.get(position);
        holder.getMaterialNameTxt().setText(sampleUser.getUsername());
        holder.getMaterialDescriptionTxt().setText(sampleUser.getUserDescription());
        Glide.with(mContext).load(sampleUser.getUserImageId()).into(holder.getCircleImageView());
        holder.getConstraintLayout().setOnClickListener(
                view -> Toast.makeText(mContext, sampleUser.getUsername()+" is clicked",
                        Toast.LENGTH_LONG).show()
        );
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
