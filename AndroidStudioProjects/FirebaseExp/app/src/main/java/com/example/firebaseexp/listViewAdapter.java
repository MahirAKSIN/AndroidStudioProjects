package com.example.firebaseexp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class listViewAdapter extends BaseAdapter {

    TextView txt_name, txt_email;
    Activity activity;
    List<kullanici> kullaniciList;
    LayoutInflater inflater;

    public listViewAdapter(Activity activity, List<kullanici> kullaniciList) {
        this.activity = activity;
        this.kullaniciList = kullaniciList;
    }

    @Override
    public int getCount() {
        return kullaniciList.size();
    }

    @Override
    public Object getItem(int position) {
        return kullaniciList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View iteView = inflater.inflate(R.layout.listview_item, null);

        txt_name = iteView.findViewById(R.id.txt_listAd);
        txt_email = iteView.findViewById(R.id.txt_listEmail);

        txt_name.setText(kullaniciList.get(position).getName());
        txt_email.setText(kullaniciList.get(position).getEmail());

        return iteView;
    }
}
