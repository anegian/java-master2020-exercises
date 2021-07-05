package Exercise3.thema3;

public class Algorithm {

    public static void main(String[] args) {

        int[] array = {-2, 5, 8, 4, 0, -100, 50, 29, 3, 27, -59};  // n = 11  -100,-59,-2,0,3,  4  ,5,8,27,29,50

        int n = array.length;
        int greater;
        int less;
        int medianPosition = n / 2;
        int median = array[medianPosition];

        System.out.println("The length of the array is: " + array.length);
        System.out.println("The median if the array was sorted should be in index:" + medianPosition);

        //iterate array
        for (int i = 0; i < n; i++) {
            greater = 0;
            less = 0;
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                if (array[j] > array[i]) {
                    greater++;
                } else {
                    less++;
                }
            }
            if (greater == less) {
                median = array[i];
            }
        }
        System.out.println("the median is: " + median);
    }
}
