package Exercise3.thema4;

import java.util.Arrays;

public class AlgorithmConvolution {

    public static void main(String[] args) {

        double[][] A = {{6, 27, 14, 8, 19}, {30, 19, 29, 5, 4}, {5, 4, 2, 27, 20}, {9, 12, 26, 11, 1}, {10, 25, 25, 8, 29}};
        double[][] B = {{-0.6, -0.9}, {0.7, 0.9}};
        double[][] C = new double[A.length - B.length + 1][A.length - B.length + 1];  //  C.length = A.length - B.length +1 ;

        System.out.println(C.length);
        System.out.println(A[4][0]);

        for (int i = 0; i < C.length; i++) {     //in algorithm i=1 ; i< C.length

            for (int j = 0; j < C.length; j++) {

                C[i][j] = 0;

                for (int k = 0; k < B.length; k++) {

                    for (int d = 0; d< B.length; d++){

                        C[i][j] += A[i+k][j+d] * B[k][d];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(C).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }
}