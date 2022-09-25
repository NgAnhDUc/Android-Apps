package com.example.nguyenanhduc_2050531200133_bt5_taolist;

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

    public int upMoney(){
        return Money++;
    }
    public int downMoney(){
        return Money--;
    }
}
