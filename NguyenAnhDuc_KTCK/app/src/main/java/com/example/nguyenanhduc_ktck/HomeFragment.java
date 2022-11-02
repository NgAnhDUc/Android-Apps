package com.example.nguyenanhduc_ktck;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class HomeFragment extends ListFragment {

    ArrayList<DoAn> arrayDoAn;
    DoAnAdapter adapter;

    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,container,false);
        AddArray();
        adapter = new DoAnAdapter(getActivity(), R.layout.dong_item, arrayDoAn);
        setListAdapter(adapter);
        return view;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent myIntent=new Intent(getActivity(), DetailActivity.class);
        myIntent.putExtra("name",arrayDoAn.get(position).getTen());
        myIntent.putExtra("detail",arrayDoAn.get(position).getMota());
        myIntent.putExtra("Img",arrayDoAn.get(position).getHinh());
        myIntent.putExtra("Money",arrayDoAn.get(position).getMoney());
        startActivity(myIntent);
    }

    private void AddArray() {
        arrayDoAn = new ArrayList<>();

        arrayDoAn.add(new DoAn("Phở bò", "Phở bò Hà Nội", R.drawable.pho, 6));
        arrayDoAn.add(new DoAn("Nem rán", "Nem rán Hà Nội", R.drawable.nemran, 3));
        arrayDoAn.add(new DoAn("Mực hấp", "Mực ống hấp rau củ", R.drawable.muchap, 5));
        arrayDoAn.add(new DoAn("Gỏi cuốn", "Gỏi cuốn tôm thịt", R.drawable.goicuon, 4));
        arrayDoAn.add(new DoAn("Bánh xèo", "Bánh xèo miền trung", R.drawable.banhxeo, 2));
        arrayDoAn.add(new DoAn("Phở bò", "Phở bò Hà Nội", R.drawable.pho, 6));
        arrayDoAn.add(new DoAn("Nem rán", "Nem rán Hà Nội", R.drawable.nemran, 3));
        arrayDoAn.add(new DoAn("Mực hấp", "Mực ống hấp rau củ", R.drawable.muchap, 5));
        arrayDoAn.add(new DoAn("Gỏi cuốn", "Gỏi cuốn tôm thịt", R.drawable.goicuon, 4));
        arrayDoAn.add(new DoAn("Bánh xèo", "Bánh xèo miền trung", R.drawable.banhxeo, 2));

    }


}
