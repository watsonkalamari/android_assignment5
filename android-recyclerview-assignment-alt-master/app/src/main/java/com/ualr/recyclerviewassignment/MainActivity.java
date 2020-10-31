package com.ualr.recyclerviewassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ualr.recyclerviewassignment.Adapter.AdapterListClass;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;
import com.ualr.recyclerviewassignment.Utils.Tools;
import com.ualr.recyclerviewassignment.model.Inbox;
import com.ualr.recyclerviewassignment.databinding.ActivityListMultiSelectionBinding;
import java.util.List;
import java.util.Random;


// TODO 06. Detect click events on the list items. Implement a new method to toggle items' selection in response to click events
// TODO 07. Detect click events on the thumbnail located on the left of every list row when the corresponding item is selected.
//  Implement a new method to delete the corresponding item in the list
// TODO 08. Create a new method to add a new item on the top of the list. Use the DataGenerator class to create the new item to be added.

public class MainActivity extends AppCompatActivity{


    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int DEFAULT_POS =0;

    private ActivityListMultiSelectionBinding binding;
    private AdapterListClass adapter;
    private List<Inbox> DataSource;
    private FloatingActionButton mFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListMultiSelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initComponent();
    }

    private void initComponent() {
        // TODO 01. Generate the item list to be displayed using the DataGenerator class
       /* List<Inbox> items = DataGenerator.getInboxData(this);
        items.addAll(DataGenerator.getInboxData(this));
        items.addAll(DataGenerator.getInboxData(this));*/
       DataSource=DataGenerator.getInboxData(this);

       adapter= new AdapterListClass(this,DataSource);
       binding.recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

       // adapter.setOnItemClickListener(this);
        adapter.setOnItemClickListener(new AdapterListClass.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //adapter.removeItem(position)
                adapter.toggleItemState(position);
            }
        });


       /*items.addAll(DataGenerator.getInboxData(this));
        //items.addAll(DataGenerator.getInboxData(this));*/


        // TODO 03. Do the setup of a new RecyclerView instance to display the item list properly


        // TODO 04. Define the layout of each item in the list
        // TODO 09. Create a new instance of the created Adapter class and bind it to the RecyclerView instance created in step 03


        mFAB = findViewById(R.id.fab);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 10. Invoke the method created to a new item to the top of the list so it's
                //  triggered when the user taps the Floating Action Button

                adapter.addItem(DEFAULT_POS,DataSource.get(Tools.getRandomNum(DataSource.size()-1)));
                binding.recyclerView.scrollToPosition(DEFAULT_POS);

            }
        });
    }


}