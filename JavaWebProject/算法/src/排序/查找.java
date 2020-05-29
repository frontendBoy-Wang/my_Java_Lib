package 排序;

public class 查找 {

    public static void NearestSmallerValues() {
        // code goes here
        int[] arrayA = {5, 3, 1, 9, 7, 3, 4, 1};
        int[] arrayB = new int[]{};

        for (int i = 1; i < arrayA.length; i++) {
            for (int j = arrayA.length; j < i; j--) {
                if (arrayA[i] < arrayA[i + 1]) {
                    int array = arrayA[i];
                } else if (arrayA[i + 1] < arrayA[i - j]) {
                    int array = arrayA[i - j];
                } else {
                    int array = -1;
                }
            }
        }
        for (int i : arrayB) {
            System.out.println(i + ",");
        }
    }

    public static void main(String[] args) {
        NearestSmallerValues();
    }

}


