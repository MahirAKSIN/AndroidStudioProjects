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
 * Use the {@link KullaniciSilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KullaniciSilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KullaniciSilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KullaniciSilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KullaniciSilFragment newInstance(String param1, String param2) {
        KullaniciSilFragment fragment = new KullaniciSilFragment();
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

    EditText txt_silme;
    Button btn_silme;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kullanici_sil, container, false);

        txt_silme = (EditText) view.findViewById(R.id.txt_silme);
        btn_silme = (Button) view.findViewById(R.id.btn_silme);
        btn_silme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int id = Integer.parseInt(txt_silme.getText().toString());
                    kullanici kullanici = new kullanici();
                    kullanici.setId(id);
                    MainActivity.veritabaniApp.benimDao().kullaniciSil(kullanici);
                    Toast.makeText(getActivity(), "Kullanici Silindi...", Toast.LENGTH_SHORT).show();
                    txt_silme.setText("");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),"Kullanici silinemdi ID kontrol ediniz..",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}