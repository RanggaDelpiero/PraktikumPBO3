package pinjamanOnline;

import java.util.Scanner;

public class PinjamOnline {

    Scanner userInput = new Scanner(System.in);
    private static double saldoSistem = 5000000.0D;
    private double pinjaman;
    public String nama;
    private int lamaPinjaman;

    //Konstruktor Kelas PinjamOnline
    PinjamOnline(String nama) {
        this.nama = nama;
    }

    //Setter dan Getter saldoSistem
    public static double getSaldoSistem() {
        return saldoSistem;
    }
    public static void setSaldoSistem(double saldoSistem) {
        PinjamOnline.saldoSistem = saldoSistem;
    }

    //Setter dan Getter pinjaman
    public void setPinjaman(double pinjaman) {
        this.pinjaman = pinjaman;
    }
    public double getPinjaman() {
        return this.pinjaman;
    }

    //Setter dan Getter lamaPinjaman
    public void setLamaPinjaman(int lamaPinjaman) {
        this.lamaPinjaman = lamaPinjaman;
    }
    public int getLamaPinjaman() {
        return this.lamaPinjaman;
    }

    //Method pinjam()
    public void pinjam() {

        System.out.printf("Selamat datang, %s\n", this.nama);
        System.out.println("Silahkan masukan nominal uang yang ingin dipinjam : ");
        double pinjam = this.userInput.nextDouble();
        System.out.println("Silahkan masukan lama peminjaman : ");
        int lamaPinjam = this.userInput.nextInt();

        if (this.getPinjaman() != 0.0D) {
            System.out.println("Silahkan lakukan pelunasan pinjaman sebelumnya");
            System.out.println("==============================================");
        } else if (pinjam > saldoSistem) {
            System.out.println("Maaf, nominal yang anda masukan terlalu besar");
            System.out.println("==============================================");
        } else if (pinjam <= saldoSistem) {
            this.setLamaPinjaman(lamaPinjam);
            this.setPinjaman(pinjam);
            setSaldoSistem(getSaldoSistem() - this.getPinjaman());
            System.out.println("Pinjaman anda telah berhasil");
            System.out.println("==============================================");
        }
    }

    public void kembalikan() {

        System.out.printf("Selamat datang, %s\n", this.nama);
        System.out.println("Silahkan masukan nominal uang yang ingin kembalikan : ");
        double kembalikan = this.userInput.nextDouble();
        System.out.println("Silahkan masukan hari pengembalian : ");
        int lamaKembalikan = this.userInput.nextInt();

        if (getPinjaman() == 0) {
            System.out.println("Maaf, anda belum melakukan pinjaman");
        }
        if (lamaKembalikan <= this.getLamaPinjaman() && this.getLamaPinjaman() != 0) {
            if (kembalikan > this.getPinjaman()) {
                System.out.println("Maaf, nominal yang anda masukan terlalu besar");
                System.out.println("==============================================");
            } else if (kembalikan == this.getPinjaman()) {
                System.out.println("Terima kasih telah melunasi peminjaman");
                System.out.println("==============================================");
                setSaldoSistem(getSaldoSistem() + this.getPinjaman());
                this.setPinjaman(0.0D);
                setLamaPinjaman(0);
            } else if (kembalikan < this.getPinjaman()) {
                System.out.println("Terima kasih telah melakukan cicilan");
                System.out.println("==============================================");
                setSaldoSistem(getSaldoSistem() + kembalikan);
                this.setPinjaman(this.getPinjaman() - kembalikan);
            }
        } else if (lamaKembalikan > this.getLamaPinjaman() && getLamaPinjaman() != 0) {

            double denda = (double)((lamaKembalikan - this.getLamaPinjaman()) * 15000);
            this.setPinjaman(this.getPinjaman() + denda);

            if (kembalikan > this.getPinjaman()) {
                System.out.println("Maaf, nominal yang anda masukan terlalu besar");
                System.out.println("==============================================");
            } else if (kembalikan == this.getPinjaman()) {
                System.out.println("Terima kasih telah melunasi peminjaman");
                System.out.println("==============================================");
                setSaldoSistem(getSaldoSistem() + this.getPinjaman());
                setLamaPinjaman(0);
                this.setPinjaman(0.0D);
            } else if (kembalikan < this.getPinjaman()) {
                System.out.println("Terima kasih telah melakukan cicilan");
                System.out.println("==============================================");
                setSaldoSistem(getSaldoSistem() + kembalikan);
                this.setPinjaman(this.getPinjaman() - kembalikan);
            }
        }
    }
}