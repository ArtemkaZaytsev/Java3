package Lesson_6;

import java.util.Arrays;

public class HW_6 {

    public static void main(String[] args) {
       int f [] = new int []{6, 7, 8, 4, 5, 3, 2};

        System.out.println(Arrays.toString (checkArray1(f)));
        System.out.println(checkArray2(f)); ;

    }
//1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен вернуть новый массив,
// который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки. Входной массив должен содержать хотя
// бы одну четверку, иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).

    public static int[] checkArray1 (int[] arr) throws RuntimeException {
        if (arr.length == 0) {
            throw new NullPointerException();
        }
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) temp = i + 1;
        }
            if (temp == -1) throw new RuntimeException();
            else return Arrays.copyOfRange(arr, temp, arr.length);
        }

//2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false;
// Написать набор тестов для этого метода (по 3-4 варианта входных данных).

    public static boolean checkArray2 (int[] arr) {
        int check = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i == 1 || i == 4){
                check++;
            }
        }
        return (check > 0);
    }

}






