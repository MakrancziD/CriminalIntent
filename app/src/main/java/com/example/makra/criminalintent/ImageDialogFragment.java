package com.example.makra.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageDialogFragment extends DialogFragment {

    private static final String ARG_PHOTO_PATH = "com.example.makra.criminalintent.photopath";

    private ImageView mImageView;

    public static ImageDialogFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putString(ARG_PHOTO_PATH, path);

        ImageDialogFragment fragment = new ImageDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String path = getArguments().getString(ARG_PHOTO_PATH);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_image_dialog, null);

        mImageView = (ImageView) v.findViewById(R.id.img_dialog);

        Bitmap bitmap = PictureUtils.getScaledBitmap(path, getActivity());
        mImageView.setImageBitmap(bitmap);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
