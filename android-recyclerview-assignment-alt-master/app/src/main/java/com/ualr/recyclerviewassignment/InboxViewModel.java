package com.ualr.recyclerviewassignment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ualr.recyclerviewassignment.model.Inbox;

import java.util.List;

public class InboxViewModel extends ViewModel {
    //TODO::set up the ViewModel class to be used to exchange the inbox data between the activity and the fragment

    // TODO irconde 01. We need to keep synchronized the whole list of items
    private MutableLiveData<List<Inbox>>inbox = new MutableLiveData<>();
    private MutableLiveData<Integer>positions = new MutableLiveData<>();

    public void setInboxList(List<Inbox> items){
        this.inbox.setValue(items);
    }

    public LiveData<List<Inbox>> getInboxList(){
        return inbox;
    }

}
