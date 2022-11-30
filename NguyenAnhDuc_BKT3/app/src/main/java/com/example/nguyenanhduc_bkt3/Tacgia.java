package com.example.nguyenanhduc_bkt3;

public class Tacgia {
    private String Ten;
    private String Mota;
    private int Hinh;
    private int Sao;

    public Tacgia(String ten, String mota, int hinh, int sao) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
        Sao = sao;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public int getSao() {
        return Sao;
    }

    public void setSao(int sao) {
        Sao = sao;
    }
}
