package com.example.chekwon.projectt;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Chekwon on 12/9/2016.
 */

public class DetaliedActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle v) {
        super.onCreate(v);
        setContentView(R.layout.detail_layout);
        //   Bundle data = getIntent().getExtras();
        Truck thisTruck = getIntent().getParcelableExtra("This Truck");
        //      Log.v("Image", "" + thisTruck.getImageResourceID() );

        final ArrayList<Menu> menu = new ArrayList<Menu>();

        menu.add(new Menu("Burrito Maravilla", "Burrito", R.drawable.burritomaravilla));
        menu.add(new Menu("Carne Asada","Taco",R.drawable.carneasada));
        menu.add(new Menu("Cheese Quesadilla","Quesadilla",R.drawable.cheesequesadilla));
        menu.add(new Menu("Chicken Quesadilla","Quesadilla",R.drawable.chickenquesadilla));

        final MenuAdapter itemsAdapter =
                new MenuAdapter(this, menu, R.color.category_following);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        GridView gridView = (GridView) findViewById(R.id.menu_list);
        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.

        gridView.setAdapter(itemsAdapter);

        int truckImg = thisTruck.getImageResourceID();
        String truckNm = thisTruck.getTruckName();
        String truckCat = thisTruck.getCategory();

        ImageView tImg = (ImageView) findViewById(R.id.Images_view_indetail);
        tImg.setImageResource(truckImg);

        TextView tName = (TextView) findViewById(R.id.truck_name_indetail);
        tName.setText(truckNm);

        TextView tCat = (TextView) findViewById(R.id.truck_category_indetail);
        tCat.setText(truckCat);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Detalied Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}