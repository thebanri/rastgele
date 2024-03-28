import java.util.Random;
public class RastgeleDizi1 {
    public static void main(String[] args) {
        Random random = new Random();

        int[][] dizi  = new int[3][3];

        for (int i = 0; i < 3 ; i++){
            for (int j = 0; j <3 ;j++){
                dizi[i][j]= random.nextInt(25)+2;

            }
        }
        // Dizideki Sütünlardaki verileri sıralar
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k<2-j; k++) { // bu döngüde dizi sütünunu arttırdığımız için ve j taşma yaptığı için yeni bir döngü açıp ondan sonra işleme devam edilir
                    if (dizi[i][k] > dizi[i][k + 1]) {
                        int temp = dizi[i][k];
                        dizi[i][k] = dizi[i][k + 1];
                        dizi[i][k + 1] = temp;

                    }
                }
            }
        }
        // Dizideki Satıralrı sıralar
        int[] diziToplam = new int[dizi.length];
        for (int i = 0; i < dizi.length; i++) {
            int satirToplam = 0;
            for (int j = 0; j < dizi[i].length; j++) {
                satirToplam += dizi[i][j];
            }
            diziToplam[i] = satirToplam;
        }


        for (int i = 0; i < diziToplam.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < diziToplam.length; j++) {
                if (diziToplam[j] < diziToplam[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {

                int bosluk = diziToplam[i];
                diziToplam[i] = diziToplam[minIndex];
                diziToplam[minIndex] = bosluk;

                // Satırların yerini değiştirme
                int[] bosSatir = dizi[i];
                dizi[i] = dizi[minIndex];
                dizi[minIndex] = bosSatir;
            }
        }

        
        System.out.println("Sıralanmış Matris:");
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[i].length; j++) {
                System.out.print(dizi[i][j] + " ");
            }
            System.out.println();
        }
    }
}