package com.ualr.recyclerviewassignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.fragments.InboxListFragment;
import com.ualr.recyclerviewassignment.model.Inbox;

import java.util.List;


public class AdapterListClass extends RecyclerView.Adapter {

    private List<Inbox> mItems;
    private Context context;
    private InboxListFragment inboxListFragment;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener mListener;

    public AdapterListClass(Context context, List<Inbox> items) {
        this.context = context;
        this.mItems = items;
    }

    // TODO irconde 04. We don't need this method here.
    // The workflow should be: The list in the ViewModel is modified > Since the viewModel's list is monitored
    // by an observer, the list in the AdaptarListClass is automatically updated

    /*

    }*/

    // TODO irconde 05. We need to define a method to update the list within the AdapterListCLass from the InboxListFragment
    public void updateInboxList (List<Inbox> inboxList) {
        this.mItems = inboxList;
        notifyDataSetChanged();
    }


    public void setOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.mOnItemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater lyInflater= LayoutInflater.from(parent.getContext());
        //View itemView = lyInflater.inflate(R.layout.item_layout,parent,false);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        RecyclerView.ViewHolder vh = new InboxViewHolder(itemView);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        final InboxViewHolder inboxViewHolder = (InboxViewHolder) holder;
        Inbox inbox = mItems.get(position);

        inboxViewHolder.name.setText(inbox.getFrom());
        inboxViewHolder.address.setText(inbox.getEmail());
        inboxViewHolder.date.setText(inbox.getDate());
        inboxViewHolder.initial.setText(inbox.getInitial());
        if (inbox.isSelected()) {
            inboxViewHolder.lyt_parent.setBackgroundColor(context.getResources().getColor(R.color.overlay_dark_20));
            /*inboxViewHolder.initial.setText("X");*/
            
            inboxViewHolder.initial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO. You need to ask the InboxListFragment to do so

                    /*
                    toggleItemState(position);
                    removeItem(position);
                     */
                }
            });
        } else {
            inboxViewHolder.lyt_parent.setBackgroundColor(context.getResources().getColor(R.color.overlay_light_90));
        }

    }
    public void toggleItemState(int position) {
        this.mItems.get(position).toggleSelection();
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    public class InboxViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name;
        public TextView address;
        public TextView initial;
        public TextView date;
        public View lyt_parent;

        public InboxViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.eAddress);
            lyt_parent = itemView.findViewById(R.id.lyt_parent);
            date = itemView.findViewById(R.id.date);
            initial = itemView.findViewById(R.id.nameInitial);

            lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // mItems.get(getLayoutPosition()).setSelected(true);
                    //notifyItemChanged(getLayoutPosition());
                    mOnItemClickListener.onItemClick(getLayoutPosition());
                }
            });
        }
    }

}
