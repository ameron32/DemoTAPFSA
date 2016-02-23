package com.ameron32.tap.fsa.demotapfsa.alpha.ui.addterritory;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ameron32.tap.fsa.demotapfsa.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddTerritoryFragment extends Fragment {

  private static final int REQUEST_IMAGE_CAPTURE = 771;

  private String[] dummyDNCs = new String[] { "Do Not Call List",
      "1202 Twombly Dr", "3405 Ranchero Rd", "3400 Ranchero Rd" };

  ImageView territoryImage;
  boolean imageApplied = false;
  PhotoViewAttacher attacher;

  public AddTerritoryFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_add_territory_alpha, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
//    EditText description = (EditText) view.findViewById(R.id.description);
//    EditText number = (EditText) view.findViewById(R.id.number);
    TextView dncText = (TextView) view.findViewById(R.id.dnc);

    // generate dummy string
    StringBuilder sb = new StringBuilder();
    for (String string : dummyDNCs) {
      sb.append(string);
      sb.append('\n');
    }
    dncText.setText(sb.toString());
    territoryImage = (ImageView) view.findViewById(R.id.territoryImage);
    view.findViewById(R.id.takeAPictureButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
          startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
      }
    });
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
      Bundle extras = data.getExtras();
      Bitmap imageBitmap = (Bitmap) extras.get("data");
      territoryImage.setImageBitmap(imageBitmap);
      setImageReady();
    }
  }

  private void setImageReady() {
    imageApplied = true;
    territoryImage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        clickTerritoryImage();
      }
    });
  }

  private void clickTerritoryImage() {
//    Snackbar.make(getView(), "Zoom on Image", Snackbar.LENGTH_LONG)
//        .setAction("OK", null)
//        .show();

    getFragmentManager().beginTransaction()
        .add(new ZoomDialogFragment(), "zoom").commit();
  }
}
