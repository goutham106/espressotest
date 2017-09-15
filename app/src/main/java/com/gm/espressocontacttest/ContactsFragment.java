package com.gm.espressocontacttest;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gm.espressocontacttest.adapter.ContactsAdapter;
import com.gm.espressocontacttest.model.Contact;
import com.gm.espressocontacttest.util.ContactFetcher;

import java.util.ArrayList;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/13/17.
 */

public class ContactsFragment extends Fragment {

    ArrayList<Contact> listContacts;

    private RecyclerView mContactListView;


    public ContactsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);
        FrameLayout layout = root.findViewById(R.id.container_contact);
        mContactListView = new RecyclerView(getActivity());
        mContactListView.setId(R.id.rv_contact_list);
        layout.addView(mContactListView);
//        mContactListView = root.findViewById(R.id.rv_contact_list);
        mContactListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mContactListView.setItemAnimator(new DefaultItemAnimator());
        requestContacts();
        return root;
    }

    // Request code for READ_CONTACTS. It can be any number > 0.
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    private void requestContacts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getActivity().checkSelfPermission(READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS,},
                    PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            showContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showContacts();
            } else {
                Log.e("Permissions", "Access denied");
            }
        }
    }

    private void showContacts() {

        listContacts = new ContactFetcher(getActivity()).fetchAll();
        ContactsAdapter adapterContacts = new ContactsAdapter(getActivity(), listContacts);
        mContactListView.setAdapter(adapterContacts);
    }

}
