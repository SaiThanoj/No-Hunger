package com.example.zerohungerlogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class donorAdapter extends FirebaseRecyclerAdapter<food_donor_list, donorAdapter.donorViewfolder> {

    public donorAdapter(@NonNull FirebaseRecyclerOptions<food_donor_list> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull donorViewfolder holder, int position, @NonNull food_donor_list model) {
        holder.name.setText(model.getName());
        holder.address.setText(model.getAddress());
        holder.pin.setText(model.getPin());
        holder.ph.setText(model.getPh());
        holder.rice.setText(model.getRice());
        holder.curry.setText(model.getCurry());

    }

    @NonNull
    @Override
    public donorViewfolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_donor_list, parent, false);

        return new donorViewfolder(view);
    }

    class donorViewfolder extends RecyclerView.ViewHolder {

        TextView name,address,pin,ph,rice,curry;

        public donorViewfolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            pin = itemView.findViewById(R.id.pin);
            ph = itemView.findViewById(R.id.ph);
            rice = itemView.findViewById(R.id.rice);
            curry = itemView.findViewById(R.id.curry);
        }
    }
}
