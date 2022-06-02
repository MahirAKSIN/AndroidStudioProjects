package com.example.gsdb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    FragmentManager fragmentManager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
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

    EditText txt_isim, txt_sifre;
    Button btn_giris;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        txt_isim = (EditText) view.findViewById(R.id.txt_isim);
        txt_sifre = (EditText) view.findViewById(R.id.txt_sifre);
        btn_giris = (Button) view.findViewById(R.id.btn_giris);
        btn_giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isim = txt_isim.getText().toString();
                String sifre = txt_sifre.getText().toString();
                if (isim.equals(R.string.com_example_gsdb_kullanici_Adi)||(sifre.equals(R.string.com_example_gsdb_kullanici_Adi))) {
                    MainActivity mainActivity = new MainActivity();
                    mainActivity.fragmentManager.beginTransaction().replace(R.id.cerceve_frame, new WelcomeFragment())
                            .addToBackStack(null).commit();
                } else {
                    Toast.makeText(getActivity(), "Kullanici adi veya sifre hatali olabilir..", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}