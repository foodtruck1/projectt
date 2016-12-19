package com.example.chekwon.projectt;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Chekwon on 12/4/2016.
 */

public class FollowingActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.follow_activity);
            final ArrayList<Truck> trucks = new ArrayList<Truck>();

            trucks.add(new Truck("Sweet Street","American",R.drawable.sweetstreets));
            trucks.add(new Truck("Kal & Mooy","Mediterranean",R.drawable.kalnmooy));
            trucks.add(new Truck("Taco Truck","Mexican",R.drawable.tacotruck));
            trucks.add(new Truck("Mutton Honey","American",R.drawable.muttonhoney));
            trucks.add(new Truck("Waffle Wagon","American",R.drawable.wafflewagon));
            trucks.add(new Truck("Westport","American",R.drawable.westport));
            trucks.add(new Truck("Good 2 Go","American",R.drawable.goodtogo));
            trucks.add(new Truck("Ziggy's","American",R.drawable.ziggys));
            trucks.add(new Truck("Retro Snow","American",R.drawable.retrosno));
            trucks.add(new Truck("Reverse","American",R.drawable.reverse));
            trucks.add(new Truck("Vertex Chicken","Chinese"));
            // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
            // adapter knows how to create layouts for each item in the list, using the
            // simple_list_item_1.xml layout resource defined in the Android framework.
            // This list item layout contains a single {@link TextView}, which the adapter will set to
            // display a single word.
            final TruckAdapter itemsAdapter =
                    new TruckAdapter (this, trucks, R.color.category_following);
            // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
            // There should be a {@link ListView} with the view ID called list, which is declared in the
            // activity_numbers.xml layout file.
            ListView listView = (ListView) findViewById(R.id.list);
            // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
            // {@link ListView} will display list items for each word in the list of words.
            // Do this by calling the setAdapter method on the {@link ListView} object and pass in
            // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
            listView.setAdapter(itemsAdapter);
        }
    };


