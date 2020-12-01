package com.ualr.recyclerviewassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
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
import com.ualr.recyclerviewassignment.fragments.ForwardDialogFragment;
import com.ualr.recyclerviewassignment.fragments.InboxListFragment;
import com.ualr.recyclerviewassignment.model.Inbox;
import com.ualr.recyclerviewassignment.databinding.ActivityListMultiSelectionBinding;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity{


    private static final String DIALOG_FRAGMENT_TAG ="DialogFragment";
    private static final String INBOX_LIST_FRAGMENT_TAG = "InboxListFragment";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int DEFAULT_POS =0;

    private ActivityListMultiSelectionBinding binding;
    private AdapterListClass adapter;
    private List<Inbox> DataSource;
    private FloatingActionButton mFAB;
    private TextView thumbnail;
    private Toolbar toolbar;
    private InboxViewModel viewModel;
    private InboxListFragment inboxListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListMultiSelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_placeholder, new InboxListFragment());
        ft.commit();

        viewModel = new ViewModelProvider(this).get(InboxViewModel.class);
        mFAB = findViewById(R.id.fab);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inboxListFragment = (InboxListFragment)getSupportFragmentManager().findFragmentByTag(INBOX_LIST_FRAGMENT_TAG);
                inboxListFragment.addItem();
            }
        });
       /* initComponent();*/
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
                //inboxListFragment.deleteEmail();
                showSnackbar();
                return true;
            case R.id.forward_action:
                ForwardDialogFragment dialog = new ForwardDialogFragment();
                dialog.show(getSupportFragmentManager(),DIALOG_FRAGMENT_TAG);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

   /* private void initComponent() {

    ;}*/
    public void showSnackbar(){
        CoordinatorLayout parentView = findViewById(R.id.lyt_parent);
        String msg = getResources().getString(R.string.snackbar_message);
        int duration = Snackbar.LENGTH_LONG;
        Snackbar snackbar = Snackbar.make(parentView, msg, duration);
        snackbar.show();
    }


}
