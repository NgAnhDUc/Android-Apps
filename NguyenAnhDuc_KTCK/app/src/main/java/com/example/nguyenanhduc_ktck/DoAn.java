package com.example.nguyenanhduc_ktck;

public class DoAn {
    private String Ten;
    private String Mota;
    private int Hinh;
    private int Money;

    public DoAn(String ten, String mota, int hinh, int money) {
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

    public int getMoney() {
        return Money;
    }

}
