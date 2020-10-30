package com.ualr.recyclerviewassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.model.Inbox;

import org.w3c.dom.Text;

import java.util.List;


// TODO 05. Create a new Adapter class and the corresponding ViewHolder class in a different file. The adapter will be used to populate
//  the recyclerView and manage the interaction with the items in the list
public class AdapterListClass extends RecyclerView.Adapter {
    private List<Inbox> mItems;

    public AdapterListClass(List<Inbox> items){
        this.mItems=items;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lyInflater= LayoutInflater.from(parent.getContext());
        View itemView = lyInflater.inflate(R.layout.item_layout,parent,false);
        RecyclerView.ViewHolder vh = new InboxViewHolder(itemView);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        InboxViewHolder inboxViewHolder = (InboxViewHolder) holder;
        Inbox inbox = mItems.get(position);

        inboxViewHolder.name.setText(inbox.getFrom());
        inboxViewHolder.address.setText(inbox.getEmail());
        inboxViewHolder.date.setText(inbox.getDate());
        //

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    private class InboxViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView name;
        public TextView address;
        public TextView date;
        public View lyt_parent;

        public InboxViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name =  itemView.findViewById(R.id.name);
            lyt_parent=itemView.findViewById(R.id.lyt_parent);
            address=itemView.findViewById(R.id.eAddress);
            date=itemView.findViewById(R.id.date);
        }
    }
}
