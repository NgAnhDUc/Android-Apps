package com.example.nguyenanhduc_listview2;

public class TraiCay {
    private String Ten;
    private String Mota;
    private int Hinh;

    public TraiCay(String ten, String mota, int hinh) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public String getMota() {
        return Mota;
    }

    public int getHinh() {
        return Hinh;
    }
}
