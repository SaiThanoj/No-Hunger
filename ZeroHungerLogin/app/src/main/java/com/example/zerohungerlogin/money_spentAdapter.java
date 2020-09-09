package com.example.zerohungerlogin;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class money_spentAdapter extends FirebaseRecyclerAdapter<money_spent, money_spentAdapter.money_spentViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public money_spentAdapter(@NonNull FirebaseRecyclerOptions<money_spent> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull money_spentViewHolder holder_money_spent, int position, @NonNull money_spent model_money_spent) {

        holder_money_spent.amount.setText(model_money_spent.getAmount());
        holder_money_spent.reason.setText(model_money_spent.getReason());

    }

    @NonNull
    @Override
    public money_spentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.money_spent_layout, parent, false);

        return new money_spentViewHolder(view);
    }

    class money_spentViewHolder extends RecyclerView.ViewHolder{

        TextView amount,reason;


        public money_spentViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.amount_money_spent);
            reason = itemView.findViewById(R.id.reason_money_spent);
        }
    }
}
