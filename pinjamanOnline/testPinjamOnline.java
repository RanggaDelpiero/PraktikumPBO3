package pinjamanOnline;

public class testPinjamOnline {

    public static void main(String[] args) {

        PinjamOnline akun1 = new PinjamOnline("Ana");
        PinjamOnline akun2 = new PinjamOnline("Doni");
        PinjamOnline akun3 = new PinjamOnline("Ikhsan");
        PinjamOnline akun4 = new PinjamOnline("Adi");

        akun1.pinjam();
        akun2.pinjam();
        System.out.println(akun2.getPinjaman());
        akun3.pinjam();
        akun3.kembalikan();
        akun1.kembalikan();
        akun4.pinjam();
        akun4.kembalikan();
        akun3.pinjam();
        akun2.pinjam();
        System.out.println(akun2.getPinjaman());
        akun2.kembalikan();
        System.out.println(akun2.getPinjaman());
        akun3.kembalikan();
        akun2.pinjam();
        System.out.println(akun2.getPinjaman());

        System.out.println("Data Akun 1");
        System.out.printf("Nama : %s\n", akun1.nama);
        System.out.printf("Nominal Peminjaman : %f\n", akun1.getPinjaman());
        System.out.printf("Lama Peminjaman : %d\n", akun1.getLamaPinjaman());

        System.out.println("Data Akun 2");
        System.out.printf("Nama : %s\n", akun2.nama);
        System.out.printf("Nominal Peminjaman : %f\n", akun2.getPinjaman());
        System.out.printf("Lama Peminjaman : %d\n", akun2.getLamaPinjaman());

        System.out.println("Data Akun 3");
        System.out.printf("Nama : %s\n", akun3.nama);
        System.out.printf("Nominal Peminjaman : %f\n", akun3.getPinjaman());
        System.out.printf("Lama Peminjaman : %d\n", akun3.getLamaPinjaman());

        System.out.println("Data Akun 4");
        System.out.printf("Nama : %s\n", akun4.nama);
        System.out.printf("Nominal Peminjaman : %f\n", akun4.getPinjaman());
        System.out.printf("Lama Peminjaman : %d\n", akun4.getLamaPinjaman());

        System.out.printf("Sisa saldo sistem : %f\n", PinjamOnline.getSaldoSistem());
    }
}
