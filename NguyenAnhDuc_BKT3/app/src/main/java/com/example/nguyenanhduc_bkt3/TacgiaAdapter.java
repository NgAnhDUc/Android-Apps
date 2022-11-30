package com.example.nguyenanhduc_bkt3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TacgiaAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Tacgia> tacgiaList;

    public TacgiaAdapter(Context context, int layout, List<Tacgia> tacgiaList) {
        this.context = context;
        this.layout = layout;
        this.tacgiaList =tacgiaList;
    }

    @Override
    public int getCount() {
        return tacgiaList.size();
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
        Tacgia tacgia = tacgiaList.get(i);

        holder.txtTen.setText(tacgia.getTen());
        holder.txtMota.setText(tacgia.getMota());
        holder.imgHinh.setImageResource(tacgia.getHinh());

        return view;
    }
}
