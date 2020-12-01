package com.ualr.recyclerviewassignment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.Adapter.AdapterListClass;
import com.ualr.recyclerviewassignment.InboxViewModel;
import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;
import com.ualr.recyclerviewassignment.model.Inbox;
import com.ualr.recyclerviewassignment.databinding.InboxListFragmentBinding;

import java.util.List;


public class InboxListFragment extends Fragment {

    private InboxListFragmentBinding binding;
    private AdapterListClass adapter;
    private List<Inbox> DataSource;
    private InboxViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.inbox_list_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        DataSource = DataGenerator.getInboxData(getActivity());
        // TODO irconde 02. We get a reference of the ViewModel
        viewModel = new ViewModelProvider(getActivity()).get(InboxViewModel.class);
        adapter = new AdapterListClass(getActivity(), DataSource);
        // TODO irconde 03. We start monitoring the list in the viewModel, so whenever there's a
        //  change in that list, the list in the adapter is automatically updated. In that way we keep both lists synchronized
        viewModel.getInboxList().observe(this, new Observer<List<Inbox>>() {
            @Override
            public void onChanged(List<Inbox> inbox) {
                // TODO irconde 06. Update the list in AdapterClass when received the updated list from the ViewModel
                adapter.updateInboxList(inbox);
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AdapterListClass.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                adapter.toggleItemState(position);
            }


            /* items.addAll(DataGenerator.getInboxData(getActivity()));*/
            /*items.addAll(DataGenerator.getInboxData(getActivity()));*/


            /* adapter.setOnItemClickListener(this);
             */

       /* items.addAll(DataGenerator.getInboxData(getActivity()));
        items.addAll(DataGenerator.getInboxData(getActivity()));*/

        });

    }
    // TODO irconde 09. We add the new item to the list in the viewmodel. Since the list is being observed
    // by the observer we defined with "TODO irconde 03", the list in the adapter is automatically updated

  /*  public void removeItem(int position) {
       *//* if (position >= mItems.size()) {
            return;
        }*//*
        int selectedIndex = viewModel.getSelectedIndex().getValue();
        List<Inbox>emails=viewModel.getInboxList().getValue();

    }*/

    public void addItem(){
        Inbox newEmail = DataGenerator.getRandomInboxItem(getActivity());
        viewModel.addItem(newEmail);
    }
    public void deleteEmail(){
        List<Inbox> emails =viewModel.getInboxList().getValue();
        int selection = viewModel.getSelectedIndex().getValue();

        emails.remove(selection);
        viewModel.setInboxList(emails);
        viewModel.setSelectedIndex(-1);
    }



}

