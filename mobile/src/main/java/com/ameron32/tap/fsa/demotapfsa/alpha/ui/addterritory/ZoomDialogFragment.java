package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addterritory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ameron32.tap.fsa.demotapfsa.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by klemeilleur on 2/23/2016.
 */
public class ZoomDialogFragment extends AppCompatDialogFragment implements Callback {

  private static final String URL = "https://i.imgur.com/amZP9kz.jpg";

  PhotoViewAttacher attacher;
  ImageView imageView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    getDialog().setTitle("Territory");
    return inflater.inflate(R.layout.dialog_imageview_zoomable_alpha, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    imageView = (ImageView) view.findViewById(R.id.territoryImage);
    Picasso.with(getActivity()).load(URL).into(imageView, this);
  }

  @Override
  public void onSuccess() {
    attacher = new PhotoViewAttacher(imageView);
  }

  @Override
  public void onError() {
    Snackbar.make(getView(), "Failed to load image from URL", Snackbar.LENGTH_LONG).show();
  }
}
