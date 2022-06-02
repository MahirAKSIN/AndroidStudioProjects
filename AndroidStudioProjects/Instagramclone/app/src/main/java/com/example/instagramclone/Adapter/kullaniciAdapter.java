package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.instagramclone.R;
import com.example.instagramclone.model1.kullanicilar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class kullaniciAdapter extends RecyclerView.Adapter<kullaniciAdapter.ViewHolder> {
    kullanicilar kullanici;

    private Context mContext;
    private List<kullanicilar> mkullanicilar;
    private FirebaseUser firebaseUser;

    public kullaniciAdapter(Context mContext, List<kullanicilar> mkullanicilar) {
        this.mContext = mContext;
        this.mkullanicilar = mkullanicilar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.kullanici_ogesi, viewGroup, false);


        return new kullaniciAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        final kullanicilar kullanici = mkullanicilar.get(i);

        viewHolder.kullaniciAdi.setText(kullanici.getKullaniciAd());
        viewHolder.ad.setText(kullanici.getAd());
        Glide.with(mContext).load(kullanici.getResimUrl()).into(viewHolder.profilResmi);
        if (kullanici.getId().equals(firebaseUser.getUid())) {
            viewHolder.btn_takipEt.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mkullanicilar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView kullaniciAdi, ad;
        public CircleImageView profilResmi;
        public Button btn_takipEt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kullaniciAdi = (TextView) itemView.findViewById(R.id.txt_kad_oge);
            ad = (TextView) itemView.findViewById(R.id.txt_ad_oge);
            btn_takipEt = (Button) itemView.findViewById(R.id.btn_takipET_oge);
            profilResmi = (CircleImageView) itemView.findViewById(R.id.profil_resmi);


        }
    }

}
