import java.util.Scanner;

public class UAS1C09 {
    // GARGARINA NANDA ISWATI, 244107060100, 09
    public static int skorTim09[][] = new int[4][100];
    public static int namaTimJumlah09 = 0;
    public static String[][] namaTim09 = new String[4][100];
    
    public static void main(String[] args) {
        Scanner sc09 = new Scanner(System.in);
        boolean loop09 = true;

        while (loop09) {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int pilihmenu09 = sc09.nextInt();

            if (pilihmenu09 < 1 || pilihmenu09 > 4) {
                System.out.println("Tidak ada data yang bisa ditampilkan.");
                continue;
            }
            switch (pilihmenu09) {
                case 1:
                    inputDataSkorTim();
                    break;
                case 2:
                    tampilTabelSkor();
                    break;
                case 3:
                    tentukanJuara();
                    break;
                case 4:
                    System.out.println("Apakah Anda yakin ingin keluar? (y/n)");
                    String konfirm09 = sc09.next();
                    if (konfirm09.equalsIgnoreCase("y")) {
                        loop09 = false;
                        System.out.println("Program Selesai.");
                    } else {
                        System.out.println("Kembali ke Menu Utama.");
                    }
                    break;
            }
        }
    }

    public static void inputDataSkorTim() {
        Scanner sc09 = new Scanner(System.in);
        int jumlahTim09 = 4;

        for (int i = 0; i < jumlahTim09; i++) {
            System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
            namaTim09[i][0] = sc09.nextLine();

            for (int j = 0; j < 2; j++) {
                do {
                    System.out.print("Masukkan skor " + namaTim09[i][0] + " untuk Level " + (j + 1) + ": ");
                    skorTim09[i][j] = sc09.nextInt();
                    if (skorTim09[i][j] < 0) {
                        System.out.println("Skor dilarang angka negatif. Silakan Input ulang!");
                    }
                } while (skorTim09[i][j] < 4);
            }
        }
    }

    public static void tampilTabelSkor() {
        System.out.println("\n=== TABEL SKOR TURNAMEN ===");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");

        for (int i = 0; i < 4; i++) { 
            int totalSkor = skorTim09[i][0] + skorTim09[i][1];
            System.out.printf("%-15s %-10d %-10d %-10d\n", namaTim09[i][0], skorTim09[i][0], skorTim09[i][1], totalSkor);
        }
    }

    public static void tentukanJuara() {
        int indeksJuara = 0;
        int skorTertinggi = 0;

        for (int i = 0; i < 4; i++) { 
            int totalSkorTim = skorTim09[i][0] + skorTim09[i][1];
            if (totalSkorTim > skorTertinggi) {
                skorTertinggi = totalSkorTim;
                indeksJuara = i;
            }
        }

        System.out.println("Selamat kepada tim " + namaTim09[indeksJuara][0] + " yang telah memenangkan kompetisi dengan total skor: " + skorTertinggi);
    }
}
