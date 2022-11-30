package com.example.nguyenanhduc_bkt3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TacPhamAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Tacpham> tacphamList ;

    public TacPhamAdapter(Context context, int layout, List<Tacpham> tacphamList) {
        this.context = context;
        this.layout = layout;
        this.tacphamList =tacphamList;
    }

    @Override
    public int getCount() {
        return tacphamList.size();
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
        TacPhamAdapter.ViewHolder holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder= new TacPhamAdapter.ViewHolder();
            //anhxa
            holder.txtTen= (TextView) view.findViewById(R.id.tvTen);
            holder.txtMota= (TextView) view.findViewById(R.id.tvMota);
            holder.imgHinh = (ImageView) view.findViewById(R.id.ivHinh);
            view.setTag(holder);
        }
        else{
            holder =(TacPhamAdapter.ViewHolder) view.getTag();
        }
// hien
        //gan gia tri
        Tacpham tacpham = tacphamList.get(i);

        holder.txtTen.setText(tacpham.getTen());
        holder.txtMota.setText(tacpham.getMota());
        holder.imgHinh.setImageResource(tacpham.getHinh());

        return view;
    }
}
