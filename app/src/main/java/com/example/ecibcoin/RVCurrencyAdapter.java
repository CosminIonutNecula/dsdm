package com.example.ecibcoin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class RVCurrencyAdapter extends RecyclerView.Adapter<RVCurrencyAdapter.CurrencyViewholder> {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private ArrayList<ModalCurrency> currencyModals;
    private Context context;

    public RVCurrencyAdapter(ArrayList<ModalCurrency> currencyModals, Context context) {
        this.currencyModals = currencyModals;
        this.context = context;
    }

    public void filterList(ArrayList<ModalCurrency> filterllist) {

        currencyModals = filterllist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RVCurrencyAdapter.CurrencyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_currency_item, parent, false);
        return new RVCurrencyAdapter.CurrencyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVCurrencyAdapter.CurrencyViewholder holder, int position) {

        ModalCurrency modal = currencyModals.get(position);
        holder.nameTV.setText(modal.getName());
        holder.rateTV.setText("$ " + df2.format(modal.getPrice()));
        holder.symbolTV.setText(modal.getSymbol());
    }

    @Override
    public int getItemCount() {

        return currencyModals.size();
    }


    public class CurrencyViewholder extends RecyclerView.ViewHolder {
        private TextView symbolTV, rateTV, nameTV;

        public CurrencyViewholder(@NonNull View itemView) {
            super(itemView);

            symbolTV = itemView.findViewById(R.id.idTVSymbol);
            rateTV = itemView.findViewById(R.id.idTVRate);
            nameTV = itemView.findViewById(R.id.idTVName);
        }
    }
}