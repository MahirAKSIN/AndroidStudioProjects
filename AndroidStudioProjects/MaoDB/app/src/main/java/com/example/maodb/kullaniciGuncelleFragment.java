package com.example.maodb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link kullaniciGuncelleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kullaniciGuncelleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public kullaniciGuncelleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment kullaniciGuncelleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static kullaniciGuncelleFragment newInstance(String param1, String param2) {
        kullaniciGuncelleFragment fragment = new kullaniciGuncelleFragment();
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
FragmentManager fragmentManager;
    EditText txt_id, txt_isim, txt_soyad, txt_tel;
    Button btn_guncelle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kullanici_guncelle, container, false);

        txt_id = (EditText) view.findViewById(R.id.txt_kid);
        txt_isim = (EditText) view.findViewById(R.id.txt_kAd);
        txt_soyad = (EditText) view.findViewById(R.id.txt_kSoyad);
        txt_tel = (EditText) view.findViewById(R.id.txt_kTel);
        btn_guncelle = (Button) view.findViewById(R.id.btn_guncelle);
        btn_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    int id = Integer.parseInt(txt_id.getText().toString());
                    String isim = txt_isim.getText().toString();
                    String soyad = txt_soyad.getText().toString();
                    String tel = txt_tel.getText().toString();
                    Kullanici k = new Kullanici();
                    k.setTel(tel);
                    k.setId(id);
                    k.setName(isim);
                    k.setSoyad(soyad);
                    MainActivity.veritabanApp.mahirDao().kullaniciGuncelle(k);
                    Toast.makeText(getActivity(), "Kullanici guncellendi..", Toast.LENGTH_SHORT).show();
                    Temizle();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
        });

        return view;
    }

    public void Temizle() {

        txt_id.setText("");
        txt_isim.setText("");
        txt_soyad.setText("");
        txt_tel.setText("");
    }
}