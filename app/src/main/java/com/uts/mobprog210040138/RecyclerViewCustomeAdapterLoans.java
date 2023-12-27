package com.uts.mobprog210040138;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uts.mobprog210040138.models.ModelLoans;


public class RecyclerViewCustomeAdapterLoans extends RecyclerView.Adapter<RecyclerViewCustomeAdapterLoans.ViewHolder> {
    Context ctx;

    private static ClickListener clickListener;

    List<ModelLoans> data;

    public RecyclerViewCustomeAdapterLoans(Context context, List<ModelLoans> dataLoans) {
        ctx = context;
        data = dataLoans;
    }

    public void setOnItemCLickListener(ClickListener clickListener){
        RecyclerViewCustomeAdapterLoans.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtTitle, txtUsername, txtBorrowerAt;
        public Button btnReturn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitleBook);
            txtUsername = itemView.findViewById(R.id.txtUsernameBorrower);
            txtBorrowerAt = itemView.findViewById(R.id.txtBorrowedAt);
            btnReturn = itemView.findViewById(R.id.btnReturn);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) { clickListener.onItemClick(getAdapterPosition(), view); }
    }

    @NonNull
    @Override
    public RecyclerViewCustomeAdapterLoans.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_data_loans, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCustomeAdapterLoans.ViewHolder holder, int position) {
        ModelLoans loans = data.get(position);
        holder.txtTitle.setText(loans.getBook().getTitle());
        holder.txtUsername.setText(loans.getBorrower().getUsername());
        holder.txtBorrowerAt.setText(loans.getBorrowedAt());
        if(!loans.getReturnStatus().equals("NOT_YET_RETURNED")) {
            holder.btnReturn.setText("Return");
        } else {
            if(loans.getReturnStatus().equals("RETURNED")) {
                holder.btnReturn.setText("✓ Returned");
            } else {
                holder.btnReturn.setText("✓ Returned late");
            }
            holder.btnReturn.setEnabled(false);
            holder.btnReturn.setBackgroundTintList(ContextCompat.getColorStateList(ctx, R.color.white));
        }
    }
    @Override
    public int getItemCount() { return data.size(); }

}
