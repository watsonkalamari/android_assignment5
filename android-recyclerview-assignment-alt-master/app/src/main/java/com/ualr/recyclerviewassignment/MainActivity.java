package com.ualr.recyclerviewassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ualr.recyclerviewassignment.Adapter.AdapterListClass;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;
import com.ualr.recyclerviewassignment.Utils.Tools;
import com.ualr.recyclerviewassignment.fragments.InboxListFragment;
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
    private TextView thumbnail;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListMultiSelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
       ft.replace(R.id.fragment_placeholder, new InboxListFragment());
        ft.commit();
        /*initComponent();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.delete_action:
                return true;
            case R.id.forward_action:
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void initComponent() {
        mFAB = findViewById(R.id.fab);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 10. Invoke the method created to a new item to the top of the list so it's
                //  triggered when the user taps the Floating Action Button

               /* adapter.addItem(DEFAULT_POS, DataSource.get(Tools.getRandomNum(DataSource.size() - 1)));
                binding.recyclerView.scrollToPosition(DEFAULT_POS);*/


            }
        })
    ;}

    /*CoordinatorLayout parentView = findViewById(R.id.lyt_parent);
    String msg = getResources().getString(R.string.snackbar_message);
    int duration = Snackbar.LENGTH_LONG;
    Snackbar snackbar = Snackbar.make(parentView, msg, duration);

    public class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick (View v){

        }
    }
*/
}
