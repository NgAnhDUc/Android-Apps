package com.example.nguyenanhduc_2050531200133_bt5_taolist;

public class DoAn {
    private String Ten;
    private String Mota;
    private int Hinh;
    private String Money;

    public DoAn(String ten, String mota, int hinh, String money) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
        Money = money;
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

    public String getMoney() {
        return Money;
    }
}
