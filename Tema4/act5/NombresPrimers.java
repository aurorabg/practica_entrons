package Tema4.act5;

public class NombresPrimers {
    public static void main(String[] args) {
        System.out.println(generarNombresPrimers(5));
    }

    public static int[] generarNombresPrimers(int max) {

        int i, j;

        if (max >= 2) {

            int dim = max + 1;
            boolean[] esPrimer = new boolean[dim];

            for (i = 0; i < dim; i++)
                esPrimer[i] = true;

            esPrimer[0] = esPrimer[1] = false;

            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimer[i]) {

                    for (j = 2 * i; j < dim; j += i)
                        esPrimer[j] = false;
                }
            }

            int compt = 0;
            for (i = 0; i < dim; i++) {
                if (esPrimer[i])
                    compt++;
            }

            int[] primers = new int[compt];
            for (i = 0, j = 0; i < dim; i++) {
                if (esPrimer[i])
                    primers[j++] = i;
            }
            return primers;
        } else {
            return new int[0];
        }

    }
}
