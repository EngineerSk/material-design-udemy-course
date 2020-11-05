package com.engineersk.recyclerview;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import de.hdodenhof.circleimageview.CircleImageView;

public final class ViewHolder extends RecyclerView.ViewHolder {

    private CircleImageView mCircleImageView;
    private MaterialTextView mMaterialNameTxt, mMaterialDescriptionTxt;
    private ConstraintLayout mConstraintLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mCircleImageView = itemView.findViewById(R.id.image_view_id);
        mMaterialNameTxt = itemView.findViewById(R.id.name_text_view);
        mMaterialDescriptionTxt = itemView.findViewById(R.id.description_text_id);
        mConstraintLayout = itemView.findViewById(R.id.recycler_item_id);
    }

    public ImageView getCircleImageView() {
        return mCircleImageView;
    }

    public MaterialTextView getMaterialNameTxt() {
        return mMaterialNameTxt;
    }

    public MaterialTextView getMaterialDescriptionTxt() {
        return mMaterialDescriptionTxt;
    }

    public ConstraintLayout getConstraintLayout() {
        return mConstraintLayout;
    }
}
