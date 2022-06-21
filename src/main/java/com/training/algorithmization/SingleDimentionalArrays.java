package com.training.algorithmization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleDimentionalArrays {
	// 1.В массив A [N] занесены натуральные числа. Найти сумму тех элементов,
	// которые кратны данному К.
	public static int firstTask(int[] array, int k) {
		int result = 0;
		for (int number : array) {
			if (number % k == 0) result += number;
		}
		return result;
	}

	// 2. Дана последовательность действительных чисел а1 ,а2 ,..., аn. Заменить все
	// ее члены, большие данного Z, этим числом. Подсчитать количество замен.
	public static int secondTask(double[] array, int z) {
		int replaismentCounter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > z) {
				array[i] = z;
				replaismentCounter++;
			}
		}
		return replaismentCounter;
	}

	// 3. Дан массив действительных чисел, размерность которого N. Подсчитать,
	// сколько в нем отрицательных, положительных и нулевых элементов.
	public static void thirdTask(double[] array) {
		int negative = 0;
		int positive = 0;
		int zero = 0;
		for (double number : array) {
			if (number > 0) {
				positive++;
				continue;
			}
			if (number < 0) {
				negative++;
				continue;
			}
			zero++;
		}
		System.out.println("положительных чисел: " + positive);
		System.out.println("отрицательных числел: " + negative);
		System.out.println("нулей: " + zero);
	}

	// 4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и
	// наименьший элементы.
	public static void fourthTask(double[] array) {
		int maxIndex = 0;
		int minIndex = 0;
		double temp = 0;
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			if (array[i] > array[maxIndex]) maxIndex = i;
			if (array[i] < array[minIndex]) minIndex = i;
		}
		temp = array[maxIndex];
		array[maxIndex] = array[minIndex];
		array[minIndex] = temp;
		System.out.println(Arrays.toString(array));

	}

	// 5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для
	// которых аi > i.
	public static void fivthTask(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > i) System.out.println(array[i]);
		}
	}

	// 6. Задана последовательность N вещественных чисел. Вычислить сумму чисел,
	// порядковые номера которых являются простыми числами.
	public static double sixthTask(double[] n) {
		double sum = 0;
		for (int i = 2; i < n.length; i++) {
			if (isSimple(i)) sum += n[i];
		}
		return sum;
	}

	// 7. Даны действительные числа a1, a2,..., an. Найти max(a1+a2n,a2+a2n-1,...,an+an+1).
	public static double seventhTask(double[] array) {
		System.out.println("???????????????????????????????");
		return 0;
	}

	// 8. Дана последовательность целых чисел a1, a2,..., an. Образовать новую
	// последовательность, выбросив изисходной те члены, которые равны (a1,a2,...,an).
	public static double[] eighthTask(double[] array) {
		double min = array[0];
		int counterForNewLenght = 0;
		int counterForNewArrayIdenx = 0;
		for (double number : array) {
			if (min > number) min = number;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == min) counterForNewLenght++;
		}
		double[] newArray = new double[array.length - counterForNewLenght];
		for (int j = 0; j < array.length; j++) {
			if (array[j] != min) {
				newArray[counterForNewArrayIdenx] = array[j];
				counterForNewArrayIdenx++;
			}
		}
		return newArray;
	}

	// 9. В массиве целых чисел с количеством элементов n найти наиболее часто
	// встречающееся число. Если таки чисел несколько, то определить наименьшее из
	// них.
	public static void ninthTask(int[] array) {
		int[] countArray = new int[array.length];
		int counter = 0;
		int maxCounter = 0;
		Integer minFromFrequent = null;
		int firstFrequent = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) counter++;
			}
			countArray[i] = counter;
			if (maxCounter < counter) maxCounter = counter;
			counter = 0;
		}
		Set<Integer> frequentSet = new HashSet<>();
		for (int k = 0; k < array.length; k++) {
			if (countArray[k] == maxCounter) {
				frequentSet.add(array[k]);
				if (minFromFrequent == null) {
					minFromFrequent = array[k];
					firstFrequent = array[k];
					continue;
				}
				if (minFromFrequent > array[k]) minFromFrequent = array[k];
			}

		}
		System.out.println("наиболее часто встречающиеся числа: " + frequentSet.toString());
		System.out.println("количество встреч: " + maxCounter);
		if (minFromFrequent != firstFrequent)
			System.out.println("минимальное из наиболее часто встречающихся чисел: " + minFromFrequent);
	}

	// 10. Дан целочисленный массив с количеством элементов п. Сжать массив,
	// выбросив из него каждый второй элемент (освободившиеся элементы заполнить
	// нулями). Примечание. Дополнительный массив не использовать.
	public static void tenthTask(int[] array) {
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			if ((i + 1) % 2 == 0) array[i] = 0;
		}
		System.out.println(Arrays.toString(array));
	}

	private static boolean isSimple(int number) {
		if (number < 2) return false;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) return false;
		}
		return true;
	}
}
