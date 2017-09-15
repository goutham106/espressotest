package com.gm.espressocontacttest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gm.espressocontacttest.R;
import com.gm.espressocontacttest.model.Contact;

import java.util.ArrayList;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/13/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {


    private ArrayList<Contact> contactList;
    private Context mContext;

    public ContactsAdapter(Context mContext, ArrayList<Contact> contacts) {
        this.contactList = contacts;
        this.mContext = mContext;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int pos) {
        View listItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contacts_list_item, parent, false);

        return new ContactViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int pos) {
        Contact c = contactList.get(pos);

        contactViewHolder.bind(c);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
