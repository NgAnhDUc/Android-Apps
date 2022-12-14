package com.example.nguyenanhduc_listview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCaylist;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCaylist) {
        this.context = context;
        this.layout = layout;
        this.traiCaylist =traiCaylist;
    }

    @Override
    public int getCount() {
        return traiCaylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMota;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder= new ViewHolder();
            //anhxa
            holder.txtTen= (TextView) view.findViewById(R.id.tvTen);
            holder.txtMota= (TextView) view.findViewById(R.id.tvMota);
            holder.imgHinh = (ImageView) view.findViewById(R.id.ivHinh);
            view.setTag(holder);
        }
        else{
            holder =(ViewHolder) view.getTag();
        }
// hien
        //gan gia tri
        TraiCay traiCay = traiCaylist.get(i);

        holder.txtTen.setText(traiCay.getTen());
        holder.txtMota.setText(traiCay.getMota());
        holder.imgHinh.setImageResource(traiCay.getHinh());

        return view;
    }
}
