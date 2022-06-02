package com.example.sqlite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KullaniciEkleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KullaniciEkleFragment extends Fragment{

    EditText txt_ID, txt_adi, txt_email;
    Button btn_kaydet;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KullaniciEkleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KullaniciEkleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KullaniciEkleFragment newInstance(String param1, String param2) {
        KullaniciEkleFragment fragment = new KullaniciEkleFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kullanici_ekle, container, false);
        txt_ID = (EditText) view.findViewById(R.id.txt_kID);
        txt_adi = (EditText) view.findViewById(R.id.txt_kADI);
        txt_email = (EditText) view.findViewById(R.id.kEmail);

        btn_kaydet = (Button) view.findViewById(R.id.btn_kaydet);
        btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int kullanici_ID = Integer.parseInt(txt_ID.getText().toString());
                    String kullanici_adi = txt_adi.getText().toString();
                    String kullanici_Email = txt_email.getText().toString();
                    kullanici kullanici = new kullanici();
                    kullanici.setKullanici_adi(kullanici_adi);
                    kullanici.setId(kullanici_ID);
                    kullanici.setEmail(kullanici_Email);
                    MainActivity.veritabaniApp.benimDao().kullaniciEkle(kullanici);
                    Toast.makeText(getActivity(),"Yeni kullanici eklendi",Toast.LENGTH_LONG).show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),"Bazi alanlar bos olabilir.Lutfen doldurunuz..",
                            Toast.LENGTH_LONG).show();

                }

            }
        });

        return view;
    }


    }