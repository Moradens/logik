import java.util.Scanner;
import java.util.Random;

public class logikIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] randomCislo = new int[4];
        int[] hadaneCislo = new int[4];
        boolean jeSpravne = false;


        for (int i = 0; i < 4; i++) {
            int novaCislice;
            do {
                novaCislice = random.nextInt(10);
            } while (obsahujeCislici(randomCislo, novaCislice));
            randomCislo[i] = novaCislice;
        }
        while (!jeSpravne) {
            System.out.println("Zadejte svůj tip (čtyřmístné číslo bez opakování číslic):");
            for (int i = 0; i < 4; i++) {
                int novaCislice;
                do {
                    novaCislice = scanner.nextInt();
                } while (obsahujeCislici(hadaneCislo, novaCislice));
                hadaneCislo[i] = novaCislice;
            }

            int spravneUmisteno = 0;
            int spatneUmisteno = 0;
            for (int i = 0; i < 4; i++) {
                if (randomCislo[i] == hadaneCislo[i]) {
                    spravneUmisteno++;
                } else if (obsahujeCislici(randomCislo, hadaneCislo[i])) {
                    spatneUmisteno++;
                }
            }

            System.out.println("Hodnocení: správně umístěných: " + spravneUmisteno + ", správně, ale špatně umístěných: " + spatneUmisteno);

            if (spravneUmisteno == 4) {
                jeSpravne = true;
                System.out.println("Gratulujeme, uhodli jste tajné číslo!");
                System.out.print("Tajné číslo bylo: ");
                for (int cislo : randomCislo) {
                    System.out.print(cislo);
                }
                System.out.println();
            }
        }

        scanner.close();
    }

    private static boolean obsahujeCislici(int[] cisla, int cislice) {
        for (int cislo : cisla) {
            if (cislo == cislice) {
                return true;
            }
        }
        return false;
    }
}
