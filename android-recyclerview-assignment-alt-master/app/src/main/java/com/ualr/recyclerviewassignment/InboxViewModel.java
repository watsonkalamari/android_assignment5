package com.ualr.recyclerviewassignment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ualr.recyclerviewassignment.model.Inbox;

import java.util.List;

public class InboxViewModel extends ViewModel {
    //TODO::set up the ViewModel class to be used to exchange the inbox data between the activity and the fragment

 /*   private final MutableLiveData<Inbox>inbox = new MutableLiveData<Inbox>();
    private final MutableLiveData<Integer>positions = new MutableLiveData<Integer>();
    public void setInboxList(Inbox items){
        inbox.setValue(items);
    }
    public LiveData<Inbox> getInboxList(){
        return inbox;
    }

    public LiveData<Inbox> getSelected(){
        return inbox;
    }

    public void setIndex(int position){
        positions.setValue(position);
    }
    public LiveData<Integer> getIndex(){
        return positions;
    }
*/
 private final MutableLiveData<Inbox>selected = new MutableLiveData<Inbox>();
 public void setInboxList(Inbox items){
     
 }
}
