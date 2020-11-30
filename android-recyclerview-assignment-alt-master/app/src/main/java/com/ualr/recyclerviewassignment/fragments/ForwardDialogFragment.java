package com.ualr.recyclerviewassignment.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.ualr.recyclerviewassignment.InboxViewModel;
import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.model.Inbox;

public class ForwardDialogFragment extends DialogFragment {
    //TODO::create the layout for then Forward dialog
    private Inbox inbox;

 /*   public void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        InboxViewModel model = ViewModelProvider(getActivity()).get(InboxViewModel.class);
        model.getSelected().observe(this,{item->);
    }*/

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.forward_dialog_fragment, null));


        builder.setPositiveButton(R.string.send_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }

   /* @Override
    public Dialog onCreateDialog (@Nullable Bundle savedInstaceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
    }*/

}
