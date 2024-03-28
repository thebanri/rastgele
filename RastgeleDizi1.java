import java.util.Random;
public class RastgeleDizi1 {
    public static void main(String[] args) {
        Random random = new Random();

        // Rastgele parantez sayılarını belirleme
        int dimension = random.nextInt(3) + 1; // 1 ile 3 arasında bir değer

        // Boyutlar dizisi oluşturma
        int[] sizes = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            sizes[i] = random.nextInt(6); // 0 ile 5 arasında bir değer
        }

        // Dizi oluşturma
        Object array = createArray(sizes, random);

        // Diziyi yazdırma
        printArray(array);
    }

    // Rastgele değerlerle dizi oluşturma
    public static Object createArray(int[] sizes, Random random) {
        if (sizes.length == 0) {
            return random.nextInt(100); // Eğer boyut yoksa bir rastgele sayı döndür
        } else {
            int size = sizes[0];
            int[] remainingSizes = new int[sizes.length - 1];
            System.arraycopy(sizes, 1, remainingSizes, 0, sizes.length - 1);
            Object[] array = new Object[size];
            for (int i = 0; i < size; i++) {
                array[i] = createArray(remainingSizes, random);
            }
            return array;
        }
    }

    // Diziyi yazdırma
    public static void printArray(Object array) {
        if (array instanceof Object[]) {
            System.out.print("[ ");
            Object[] subArray = (Object[]) array;
            for (Object subElement : subArray) {
                printArray(subElement);
            }
            System.out.print("] ");
        } else {
            System.out.print(array + " ");
        }
    }
}