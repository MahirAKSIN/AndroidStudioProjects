package com.example.tryacces;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KullaniciAdaptor extends RecyclerView.Adapter<KullaniciAdaptor.MyViewHolder> {

    Context mcontext;
    ArrayList<Kullanici> kullaniciList;

    public KullaniciAdaptor(Context c, ArrayList<Kullanici> p) {
        this.mcontext = c;
        this.kullaniciList = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (LayoutInflater.from(mcontext).inflate(R.layout.item, parent, false));

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Kullanici kullanici = kullaniciList.get(position);

        holder.name.setText(kullanici.getName());
        holder.email.setText(kullanici.getEmail());
    }

    @Override
    public int getItemCount() {
        return kullaniciList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email = (TextView) itemView.findViewById(R.id.txt_firstName);
            name = (TextView) itemView.findViewById(R.id.txt_iemail);
        }
    }
}
