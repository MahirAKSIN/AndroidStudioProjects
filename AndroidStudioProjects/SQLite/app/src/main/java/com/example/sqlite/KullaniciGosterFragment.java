package com.example.sqlite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KullaniciGosterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KullaniciGosterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KullaniciGosterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KullaniciGosterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KullaniciGosterFragment newInstance(String param1, String param2) {
        KullaniciGosterFragment fragment = new KullaniciGosterFragment();
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

    TextView txt_getKullanici;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kullanici_goster, container, false);
        txt_getKullanici = (TextView) view.findViewById(R.id.txt_verOku);
        List<kullanici> getkullaniciList = MainActivity.veritabaniApp.benimDao().kullaniciGoster();
        String veri = "";
        for (kullanici kInc : getkullaniciList) {
            int id = kInc.getId();
            String ad = kInc.getKullanici_adi();
            String email = kInc.getEmail();
            veri = veri + "\nID : " + id + "\nIsim :" + ad + "\nEmail : " + email+"\n"+"-----------------------------------";

        }
        Log.d("VERi : ",veri);
        txt_getKullanici.setText(veri);
        return view;
    }

   }