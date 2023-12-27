package com.uts.mobprog210040138;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitleBook);
            txtUsername = itemView.findViewById(R.id.txtUsername);
            txtBorrowerAt = itemView.findViewById(R.id.txtBorrowedAt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) { clickListener.onItemClick(getAdapterPosition(), view); }
    }

    @NonNull
    @Override
    public RecyclerViewCustomeAdapterLoans.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fragment_list_data_loans, parent, false);

        return new ViewHolder(v);
    }

    //belummmm
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCustomeAdapterLoans.ViewHolder holder, int position) {
        ModelLoans loans = data.get(position);
        //belum
    }
    @Override
    public int getItemCount() { return data.size(); }

}
