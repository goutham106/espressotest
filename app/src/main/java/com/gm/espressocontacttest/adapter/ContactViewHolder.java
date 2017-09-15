package com.gm.espressocontacttest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gm.espressocontacttest.R;
import com.gm.espressocontacttest.model.Contact;
import com.gm.espressocontacttest.widgets.RoundedImageView;
import com.squareup.picasso.Picasso;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/13/17.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private RoundedImageView mImage;
    private TextView mLabel,mPhno;
    private Contact mBoundContact; // Can be null

    public ContactViewHolder(final View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.rounded_iv_profile);
        mLabel = itemView.findViewById(R.id.tv_label);
        mPhno = itemView.findViewById(R.id.tv_phno);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBoundContact != null) {
                    Toast.makeText(
                            itemView.getContext(),
                            //"Hi, I'm " + mBoundContact.name,
                            mBoundContact.name,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void bind(Contact contact) {
        mBoundContact = contact;
//        mLabel.setText(contact.name);
//        mPhno.setText(contact.phno);
        Picasso.with(itemView.getContext())
                .load(contact.profilePic)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(mImage);


        mLabel.setText(contact.name);
//        tvEmail.setText("");
        mPhno.setText("");
//        if (contact.emails.size() > 0 && contact.emails.get(0) != null) {
//            tvEmail.setText(contact.emails.get(0).address);
//        }
        if (contact.numbers.size() > 0 && contact.numbers.get(0) != null) {
            mPhno.setText(contact.numbers.get(0).number);
        }

    }
}
