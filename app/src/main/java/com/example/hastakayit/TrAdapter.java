package com.example.hastakayit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class TrAdapter extends RecyclerView.Adapter<TrAdapter.TrViewHolder>{

    private Context mCtx;
    private List<Bilgi> bilgiList;


    public TrAdapter(Context mCtx, List<Bilgi> bilgiList){
        this.mCtx = mCtx;
        this.bilgiList = bilgiList;
    }

    @NonNull
    @Override
    public TrViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item, null);
        return new TrViewHolder(view);
    }

    public void onBindViewHolder(@NonNull TrViewHolder holder,int i){
        Bilgi bilgi = bilgiList.get(i);

        holder.tvTc.setText("Tc No: "+bilgi.getTc_no());
        holder.tvHasta_Ad.setText("Hasta Adı: "+bilgi.getHasta_ad());
        holder.tvHasta_Soyad.setText("Hasta Soyadı: "+bilgi.getHasta_soyad());
        holder.tvYas.setText("Yaş: "+bilgi.getYas());
        holder.tvAdres.setText("Adres: "+bilgi.getAdres());
        holder.tvTel.setText("Tel: "+bilgi.getTel_no());
        holder.tvCinsiyet.setText("Cinsiyeti: "+bilgi.getCinsiyet());
        holder.tvDoktor_Ad.setText("Doktoru: "+bilgi.getDoktor_ad());

    }

    @Override
    public int getItemCount(){
        return bilgiList.size();
    }

    class TrViewHolder extends RecyclerView.ViewHolder{
        TextView tvTc, tvHasta_Ad, tvHasta_Soyad, tvYas;
        TextView tvAdres, tvTel, tvCinsiyet, tvDoktor_Ad;
        public TrViewHolder(@NonNull View itemView){
            super(itemView);

            tvTc = itemView.findViewById(R.id.tcId);
            tvHasta_Ad = itemView.findViewById(R.id.hasta_adId);
            tvHasta_Soyad = itemView.findViewById(R.id.hasta_soyadId);
            tvYas = itemView.findViewById(R.id.yasId);
            tvAdres = itemView.findViewById(R.id.adresId);
            tvTel = itemView.findViewById(R.id.telId);
            tvCinsiyet = itemView.findViewById(R.id.cinsiyetId);
            tvDoktor_Ad = itemView.findViewById(R.id.doktor_adId);
        }

    }
}

