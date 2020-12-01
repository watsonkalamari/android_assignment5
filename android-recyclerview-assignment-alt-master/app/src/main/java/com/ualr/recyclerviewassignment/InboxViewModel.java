package com.ualr.recyclerviewassignment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ualr.recyclerviewassignment.Utils.DataGenerator;
import com.ualr.recyclerviewassignment.model.Inbox;

import java.util.List;

public class InboxViewModel extends ViewModel {
    //TODO::set up the ViewModel class to be used to exchange the inbox data between the activity and the fragment

    // TODO irconde 01. We need to keep synchronized the whole list of items
    private MutableLiveData<List<Inbox>>inbox = new MutableLiveData<>();
    private MutableLiveData<Integer>index = new MutableLiveData<>();

    public void setInboxList(List<Inbox> items){
        this.inbox.setValue(items);
    }

    public LiveData<List<Inbox>> getInboxList(){
        return inbox;
    }
    public void setSelectedIndex(int selectedIndex){
        index.setValue(selectedIndex);
    }
    public LiveData<Integer>getSelectedIndex(){
        return index;
    }
    // TODO irconde 07. Define new addItem method
    public void addItem(Inbox item) {
        // We get the current list
        List<Inbox> itemList = inbox.getValue();
        // We add the item to the list
        itemList.add(0, item);
        // we update the MutableLiveData value
        inbox.setValue(itemList);
    }
    public void deleteItem(int position){
        List<Inbox>itemList = inbox.getValue();
        itemList.remove(position);
        inbox.setValue(itemList);
    }

  /*  public void addItem(Inbox item) {

        List<Inbox>itemsList = inbox.getValue();
        itemsList.add(0,item);
        inbox.setValue(itemsList);
        Inbox newEmail = DataGenerator.getRandomInboxItem(getActivity());
        List<Inbox> emails=viewModel.getInboxList().getValue();
        emails.add(0,newEmail);
        viewModel.setInboxList(emails);
    }*/

}
