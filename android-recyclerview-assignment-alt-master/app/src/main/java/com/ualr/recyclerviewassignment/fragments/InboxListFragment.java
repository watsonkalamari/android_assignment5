package com.ualr.recyclerviewassignment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

    //TODO::Get the recyclerview to show up on the screen.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        /* binding = InboxListFragmentBinding.inflate(getLayoutInflater());*/
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Inbox> items = DataGenerator.getInboxData(getActivity());
        DataSource = DataGenerator.getInboxData(getActivity());
        adapter = new AdapterListClass(getActivity(), DataSource);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(getActivity()).get(InboxViewModel.class);


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
}

