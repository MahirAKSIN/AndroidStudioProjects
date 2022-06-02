package com.example.maodb;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link kullaniciSilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kullaniciSilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public kullaniciSilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment kullaniciSilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static kullaniciSilFragment newInstance(String param1, String param2) {
        kullaniciSilFragment fragment = new kullaniciSilFragment();
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

    EditText txt_idSil;
    Button btn_silID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kullanici_sil, container, false);

        txt_idSil = (EditText) view.findViewById(R.id.txt_idGir);
        btn_silID = (Button) view.findViewById(R.id.btn_kSil);
        btn_silID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Kullanici kullanici = new Kullanici();
                    int kSil = Integer.parseInt(txt_idSil.getText().toString());
                    kullanici.setId(kSil);
                    MainActivity.veritabanApp.mahirDao().kullaniciSil(kullanici);
                    kullaniciGosterFragment kullaniciGosterFragment = new kullaniciGosterFragment();
                    String veri = kullaniciGosterFragment.veri;
                    Toast.makeText(getActivity(), "Kullanici Silinidi..", Toast.LENGTH_SHORT).show();
                    Log.d("Veri", veri);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });
        txt_idSil.setText("");
        return view;
    }
}