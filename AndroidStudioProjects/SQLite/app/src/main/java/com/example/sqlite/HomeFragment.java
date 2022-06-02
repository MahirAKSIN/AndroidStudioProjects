package com.example.sqlite;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
// TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    FragmentManager fragmentManager;

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Button btn_ekle, btn_goster, btn_sil, btn_guncelle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_ekle = (Button) view.findViewById(R.id.btn_kEkle);
        btn_goster = (Button) view.findViewById(R.id.btn_kGoster);
        btn_sil = (Button) view.findViewById(R.id.kSil);
        btn_guncelle = (Button) view.findViewById(R.id.kGuncelle);

        btn_ekle.setOnClickListener(this);
        btn_goster.setOnClickListener(this);
        btn_sil.setOnClickListener(this);
        btn_guncelle.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_kEkle:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.cerceve_kapdayici, new KullaniciEkleFragment()).
                        addToBackStack(null).commit();
                break;
            case R.id.btn_kGoster:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.cerceve_kapdayici, new KullaniciGosterFragment()).
                        addToBackStack(null).commit();
                break;
            case R.id.kSil:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.cerceve_kapdayici, new KullaniciSilFragment()).
                        addToBackStack(null).commit();
                break;
            case R.id.kGuncelle:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.cerceve_kapdayici, new KullaniciGuncelleFragment()).
                        addToBackStack(null).commit();
                break;
        }
    }
}