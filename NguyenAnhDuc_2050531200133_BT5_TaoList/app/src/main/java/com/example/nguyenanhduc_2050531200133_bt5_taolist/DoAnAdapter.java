package com.example.nguyenanhduc_2050531200133_bt5_taolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DoAnAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DoAn> doAnList;

    public DoAnAdapter(Context context, int layout, List<DoAn> doAnList) {
        this.context = context;
        this.layout = layout;
        this.doAnList =doAnList;
    }

    @Override
    public int getCount() {
        return doAnList.size();
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
        TextView txtTen, txtMota,txtMoney;
        Button btntang, btngiam;
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
            holder.txtMoney= (TextView) view.findViewById(R.id.tvMoney);
            holder.btngiam= (Button) view.findViewById(R.id.btgiam);
            holder.btntang= (Button )view. findViewById(R.id.bttang);
            view.setTag(holder);
        }
        else{
            holder =(ViewHolder) view.getTag();
        }
        //gan gia tri
        DoAn doAn = doAnList.get(i);

        holder.txtTen.setText(doAn.getTen());
        holder.txtMota.setText(doAn.getMota());
        holder.imgHinh.setImageResource(doAn.getHinh());
        holder.txtMoney.setText( ""+doAn.getMoney());

        return view;
    }
}

