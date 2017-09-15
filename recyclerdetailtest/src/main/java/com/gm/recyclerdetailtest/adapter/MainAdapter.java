package com.gm.recyclerdetailtest.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gm.recyclerdetailtest.R;
import com.gm.recyclerdetailtest.activity.DetailActivity;
import com.gm.recyclerdetailtest.databinding.AdapterItemBinding;
import com.gm.recyclerdetailtest.model.DataItem;


/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/13/17.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.BindingHolder> {

    private DataItem[] dataItems = new DataItem[50];
    private ClickListener clickListener = new ClickListener();
    private  Context context;

    public MainAdapter(Context context1) {
        this.context = context1;
        int count = dataItems.length;
        for (int i = 0; i < count; ++i) {
            dataItems[i] = new DataItem("Item " + (i + 1));
        }
    }

    @Override
    public int getItemCount() {
        return dataItems.length;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterItemBinding binding = AdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.setListener(clickListener);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        AdapterItemBinding binding = DataBindingUtil.getBinding(holder.itemView);
        if (binding != null) {
            binding.setDataItem(dataItems[position]);
        }
    }


    /* package */ static class BindingHolder extends RecyclerView.ViewHolder {

        BindingHolder(@NonNull AdapterItemBinding binding) {
            super(binding.getRoot());
        }
    }

    public class ClickListener {

        public void onItemClick(View v) {
            AdapterItemBinding binding = DataBindingUtil.findBinding(v);
            if (binding != null) {
                DetailActivity.startActivity(v.getContext(), binding.getDataItem());

            }
        }

        public void onFavoriteClick(View v) {
            AdapterItemBinding binding = DataBindingUtil.findBinding(v);
            if (binding != null) {
                showAlertDialog(binding);

            }
        }
    }

    private void showAlertDialog(final AdapterItemBinding binding) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_message);
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //statusTextView.setText(getString(R.string.cancel));
            }
        });
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //statusTextView.setText(getString(R.string.ok));
                binding.getDataItem().toggleFavorite();
            }
        });
        builder.create().show();
    }
}
