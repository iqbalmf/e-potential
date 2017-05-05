package com.example.iqbalmfauzan.e_potential;

/**
 * Created by Iqbal M Fauzan on 3/7/2016.
 */
public class DataProvider {

//    private String Category;
    private String nomer;
    private String Soal;
    private String Jawaban_1;
    private String Jawaban_2;
    private String Jawaban_3;
    private String Jawaban_4;

    public DataProvider(String nomer, String Soal, String Jawaban_1, String Jawaban_2, String Jawaban_3, String Jawaban_4)
    {
        this.setNomer(nomer);
        this.setSoal(Soal);
        this.setJawaban_1(Jawaban_1);
        this.setJawaban_2(Jawaban_2);
        this.setJawaban_3(Jawaban_3);
        this.setJawaban_4(Jawaban_4);
    }

//    public String getCategory() {
//        return Category;
//    }
//
//    public void setCategory(String category) {
//        Category = category;
//    }

    public String getSoal() {
        return Soal;
    }

    public void setSoal(String soal) {
        this.Soal = soal;
    }

    public String getJawaban_1() {
        return Jawaban_1;
    }

    public void setJawaban_1(String jawaban_1) {
        this.Jawaban_1 = jawaban_1;
    }

    public String getJawaban_2() {
        return Jawaban_2;
    }

    public void setJawaban_2(String jawaban_2) {
        this.Jawaban_2 = jawaban_2;
    }

    public String getJawaban_3() {
        return Jawaban_3;
    }

    public void setJawaban_3(String jawaban_3) {
        this.Jawaban_3 = jawaban_3;
    }

    public String getJawaban_4() {
        return Jawaban_4;
    }

    public void setJawaban_4(String jawaban_4) {
        this.Jawaban_4 = jawaban_4;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }
}
