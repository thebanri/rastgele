import java.util.Random;

public class RastgeleDizi2 {
    public static void main(String[] args) {
        Random random = new Random();


        int boyut1_dizi1 = random.nextInt(5) + 1;
        int boyut2_dizi1 = random.nextInt(5) + 1;
        int boyut3_dizi1 = random.nextInt(5) + 1;


        int boyut1_dizi2 = random.nextInt(5) + 1;
        int boyut2_dizi2 = random.nextInt(5) + 1;
        int boyut3_dizi2 = random.nextInt(5) + 1;


        int[][][] dizi1 = new int[boyut1_dizi1][][];
        for (int i = 0; i < boyut1_dizi1; i++) {
            dizi1[i] = new int[boyut2_dizi1][];
            for (int j = 0; j < boyut2_dizi1; j++) {
                dizi1[i][j] = new int[boyut3_dizi1];
            }
        }


        int[][][] dizi2 = new int[boyut1_dizi2][][];
        for (int i = 0; i < boyut1_dizi2; i++) {
            dizi2[i] = new int[boyut2_dizi2][];
            for (int j = 0; j < boyut2_dizi2; j++) {
                dizi2[i][j] = new int[boyut3_dizi2];
            }
        }

        // Her iki diziyi de rastgele değerlerle doldur
        diziDoldur(dizi1, random);
        diziDoldur(dizi2, random);

        // Her iki dizideki verileri sırala ve yazdır
        siraliDiziYazdir(dizi1, 1);
        siraliDiziYazdir(dizi2, 2);


        carpmaSonucuYazdir(dizi1,dizi2);
        toplamaSonucuYazdir(dizi1, dizi2);
    }

    // Diziyi rastgele değerlerle dolduran fonksiyon
    public static void diziDoldur(int[][][] dizi, Random random) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[i].length; j++) {
                for (int k = 0; k < dizi[i][j].length; k++) {
                    dizi[i][j][k] = random.nextInt(100); // 0 ile 99 arasında rastgele tam sayılar
                }
            }
        }
    }

    // Diziyi sıralayıp yazdıran fonksiyon
    public static void siraliDiziYazdir(int[][][] dizi, int diziNo) {
        System.out.println("-----------DİZİ."+diziNo+"------------");
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[i].length; j++) {
                for (int k = 0; k < dizi[i][j].length; k++) {
                    // Diziyi kabarcık sıralama algoritması ile sırala
                    Siralama(dizi[i][j]);

                    // Sıralanmış elemanları yazdır
                    System.out.print(dizi[i][j][k]+" ");

                }
                System.out.println();

            }

        }
    }

    public static void carpmaSonucuYazdir(int[][][] dizi1, int[][][] dizi2) {
        System.out.println("-----------ÇARPMA----------");
        int boyut1 = (dizi1.length > dizi2.length) ? dizi1.length : dizi2.length;
        int boyut2 = (dizi1.length > dizi2.length) ? dizi1[0].length : dizi2[0].length;
        int boyut3 = (dizi1.length > dizi2.length) ? dizi1[0][0].length : dizi2[0][0].length;

        // Çarpma işlemi
        int[][][] carpim = new int[boyut1][boyut2][boyut3];
        for (int i = 0; i < boyut1; i++) {
            for (int j = 0; j < boyut2; j++) {
                for (int k = 0; k < boyut3; k++) {
                    int deger1 = (i < dizi1.length && j < dizi1[i].length && k < dizi1[i][j].length) ? dizi1[i][j][k] : 1;
                    int deger2 = (i < dizi2.length && j < dizi2[i].length && k < dizi2[i][j].length) ? dizi2[i][j][k] : 1;
                    carpim[i][j][k] = deger1 * deger2;
                }
            }
        }
        for (int i = 0; i < boyut1; i++) {
            for (int j = 0; j < boyut2; j++) {
                for (int k = 0; k < boyut3; k++) {
                    System.out.print(carpim[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    public static void toplamaSonucuYazdir(int[][][] dizi1, int[][][] dizi2) {
        System.out.println("--------------TOPLAMA----------------");
        int boyut1 = dizi1.length > dizi2.length ? dizi1.length : dizi2.length;
        int boyut2 = dizi1.length > dizi2.length ? dizi1[0].length : dizi2[0].length;
        int boyut3 = dizi1.length > dizi2.length ? dizi1[0][0].length : dizi2[0][0].length;

        // Toplama işlemi
        int[][][] toplam = new int[boyut1][boyut2][boyut3];
        for (int i = 0; i < boyut1; i++) {
            for (int j = 0; j < boyut2; j++) {
                for (int k = 0; k < boyut3; k++) {
                    int deger1 = (i < dizi1.length && j < dizi1[0].length && k < dizi1[0][0].length) ? dizi1[i][j][k] : 0;
                    int deger2 = (i < dizi2.length && j < dizi2[0].length && k < dizi2[0][0].length) ? dizi2[i][j][k] : 0;
                    toplam[i][j][k] = deger1 + deger2;
                }
            }
        }

        // Sonucu yazdır
        for (int i = 0; i < boyut1; i++) {
            for (int j = 0; j < boyut2; j++) {
                for (int k = 0; k < boyut3; k++) {
                    System.out.print(toplam[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void Siralama(int[] dizi) {
        int n = dizi.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dizi[j] > dizi[j + 1]) {
                    // Swap
                    int temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;
                }
            }
        }
    }
}
