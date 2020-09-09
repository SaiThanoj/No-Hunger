package com.example.zerohungerlogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class money_donorsAdapter extends FirebaseRecyclerAdapter<money_donors, money_donorsAdapter.money_donorsViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public money_donorsAdapter(@NonNull FirebaseRecyclerOptions<money_donors> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull money_donorsViewHolder holder_money_donors, int position, @NonNull money_donors model_money_donors) {

        holder_money_donors.amount.setText(model_money_donors.getAmount());
        holder_money_donors.name.setText(model_money_donors.getName1());


    }

    @NonNull
    @Override
    public money_donorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.money_donors_layout, parent, false);

        return new money_donorsViewHolder(view);
    }

    class money_donorsViewHolder extends RecyclerView.ViewHolder{
        TextView amount, name, phone, uid;
        public money_donorsViewHolder(@NonNull View itemView) {
            super(itemView);

            amount = itemView.findViewById(R.id.amount_money_donors);
            name = itemView.findViewById(R.id.name1_money_donors);

        }
    }
}
