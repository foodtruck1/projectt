package com.example.chekwon.projectt;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


/**
 * Created by Chekwon on 12/4/2016.
 */

public class MenuAdapter extends ArrayAdapter<Menu> {
    private int mColorResourceId;

    public MenuAdapter(Activity context, ArrayList<Menu> menu, int colorResourceId){
        super(context,0,menu);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        Menu CurrentMenu = getItem(position);

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_item, parent, false);
        }

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.Images_view);
        if (CurrentMenu.hasImage()){
            iconView.setVisibility(View.VISIBLE);
            iconView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iconView.setImageBitmap(
                    decodeSampledBitmapFromResource(iconView.getResources(), R.id.Images_view, 132, 132));
            iconView.setImageResource(CurrentMenu.getImageResourceID());
        }
        else{
            iconView.setVisibility(View.VISIBLE);
            iconView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iconView.setImageResource(R.drawable.noimage);
        }
        TextView MenuTextView = (TextView) listItemView.findViewById(R.id.menu_name);
        MenuTextView.setText(CurrentMenu.getMenuName());

        TextView CategoryTextView = (TextView) listItemView.findViewById(R.id.menu_description);
        CategoryTextView.setText(CurrentMenu.getDescription());

        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;

    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}

