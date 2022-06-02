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
 * Use the {@link KullaniciGuncelleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KullaniciGuncelleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KullaniciGuncelleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KullaniciGuncelleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KullaniciGuncelleFragment newInstance(String param1, String param2) {
        KullaniciGuncelleFragment fragment = new KullaniciGuncelleFragment();
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

    EditText txt_id, txt_isim, txt_email;
    Button btn_guncelle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_kullanici_guncelle, container, false);

        txt_id = (EditText) view.findViewById(R.id.txt_ID);
        txt_isim = (EditText) view.findViewById(R.id.txt_ADI);
        txt_email = (EditText) view.findViewById(R.id.Email);

        btn_guncelle = (Button) view.findViewById(R.id.btn_guncelle);
        btn_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    kullanici kullanici = new kullanici();
                    int id = Integer.parseInt(txt_id.getText().toString());
                    String isim = txt_isim.getText().toString();
                    String email = txt_email.getText().toString();
                    kullanici.setId(id);
                    kullanici.setKullanici_adi(isim);
                    kullanici.setEmail(email);
                    MainActivity.veritabaniApp.benimDao().kullaniciGuncelle(kullanici);
                    Toast.makeText(getActivity(),"Kullanici guncellendi",Toast.LENGTH_LONG).show();

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Bazi alanlar bos olabilir.Lutfen doldurunuz..",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}