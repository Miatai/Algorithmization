package com.training.algorithmization;

import java.util.ArrayList;
import java.util.Arrays;

public class Decomposition {
	// 1. Написать метод(методы) для нахождения наибольшего общего делителя и
	// наименьшего общего кратного двух натуральных чисел:
	public static void firstTask(int firstNumber, int secondNumber) {
		System.out.println(
				"НОК(" + firstNumber + "," + secondNumber + "): " + leastCommonMultiplie(firstNumber, secondNumber));
		System.out.println(
				"НОД(" + firstNumber + "," + secondNumber + "): " + greatestCommonDivision(firstNumber, secondNumber));
	}

	// 2. Написать метод(методы) для нахождения наибольшего общего делителя четырех
	// натуральных чисел.
	public static int secondTask(int[] array) {
		int gcd = array[0];
		for (int i = 0; i < array.length; i++) {
			gcd = greatestCommonDivision(gcd, array[i]);
		}
		System.out.println("НОД" + Arrays.toString(array) + ": " + gcd);
		return gcd;
	}

	// 3. Вычислить площадь правильного шестиугольника со стороной а, используя
	// метод вычисления площади треугольника.
	public static double thirdTask(int hexagonSide) {
		return triangleAreaBySides(hexagonSide, hexagonSide, hexagonSide) * 6;
	}

	// 4. На плоскости заданы своими координатами n точек. Написать метод(методы),
	// определяющие, между какими из пар точек самое большое расстояние. Указание.
	// Координаты точек занести в массив.
	public static void fourthTask(double[][] points) {
		double[][] maxDistanceIndices = new double[1][1];
		double maxDisctance = 0;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double currentDistance = pointsDistance(points[i], points[j]);
				if (maxDisctance < currentDistance) {
					maxDisctance = currentDistance;
					maxDistanceIndices = new double[][] { points[i], points[j] };
				}
			}
		}
		System.out.println("Максимальная дистанция: " + maxDisctance);
		System.out.println("Координаты точек: " + Arrays.deepToString(maxDistanceIndices));
	}

	// 5. Составить программу, которая в массиве A[N] находит второе по величине
	// число (вывести на печать число, которое меньше максимального элемента
	// массива, но больше всех других элементов).
	public static void fivthTask(double[] array) {
		double secondMax = 0;
		double max = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			if (max < array[i + 1]) {
				secondMax = max;
				max = array[i + 1];
			}
			if (secondMax < array[i + 1] && max > array[i + 1]) {
				secondMax = array[i + 1];
			}
		}
		System.out.println("Второе по величине число: " + secondMax);
	}

	// 6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно
	// простыми.
	public static boolean sixthTask(int[] array) {
		return secondTask(array) == 1 ? true : false;
	}

	// 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных
	// чисел от 1 до 9.
	public static int seventhTask(int lastNumber) {
		int sum = 0;
		for (int i = 1; i <= lastNumber; i += 2) {
			sum += factorial(i);
		}
		return sum;
	}

	// 8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] +
	// D[4] + D[5]; D[4] +D[5] +D[6]. Пояснение. Составить метод(методы) для
	// вычисления суммы трех последовательно расположенных элементов массива с
	// номерами от k до m.
	public static void eighthTask(int[] array) {
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i += 3) {
			int lastIndex;
			if (i + 2 >= array.length) {
				if (i + 1 >= array.length) {
					lastIndex = i;
				} else {
					lastIndex = i + 1;
				}
			} else {
				lastIndex = i + 2;
			}
			int sum = sumBetweenIndices(array, i, lastIndex);
			System.out.println(
					"сумма элементов " + Arrays.toString(Arrays.copyOfRange(array, i, lastIndex + 1)) + ":" + sum);
		}
	}

	// 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать
	// метод(методы) вычисления его площади, если угол между сторонами длиной X и Y—
	// прямой.
	public static void ninthTask(double x, double y, double z, double t) {
		if (x == z && y == t) {
			System.out.println("Площадь четырехугольника: " + quadrilateralAreaBySides(x, y, z, t));
		} else {
			System.out.println("Угол между сторонами X и Y не равен 90 градусов.");
		}
	}

	// 10. Дано натуральное число N. Написать метод(методы) для формирования
	// массива, элементами которого являются цифры числа N.
	public static long[] tenthTask(long n) {
		int digits = digitsCounter(n);
		long[] result = new long[digits];
		int index = 0;
		for (int i = (int) Math.pow(10, digits - 1); i != 0; i /= 10) {
			result[index] = n / i;
			n = n - ((n / i) * i);
			index++;
		}
		return result;
	}

	// 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше
	// цифр.
	public static void eleventhTask(int fisrtNumber, int secondNumber) {
		if (digitsCounter(fisrtNumber) > digitsCounter(secondNumber)) {
			System.out.println("В числе " + fisrtNumber + " больше цифр чем в числе " + secondNumber + ".");
		} else {
			if (digitsCounter(fisrtNumber) == digitsCounter(secondNumber)) {
				System.out.println("В числе " + fisrtNumber + " и " + secondNumber + " одинаковое количество цифр.");
			} else {
				System.out.println("В числе " + secondNumber + " больше цифр чем в числе " + fisrtNumber + ".");
			}
		}
	}

	// 12. Даны натуральные числа К и N. Написать метод(методы) формирования массива
	// А, элементами которого являются числа, сумма цифр которых равна К и которые
	// не большее N.
	public static void twelfthTask(int k, int n) {
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = k + 1; i <= n; i++) {
			if (digitsSum(i) == k) array.add(i);
		}
		System.out.println(array.toString());
	}

	// 13. Два простых числа называются «близнецами», если они отличаются друг от
	// друга на 2 (например, 41 и 43). Найти и напечатать все пары «близнецов» из
	// отрезка [n,2n], где n - заданное натуральное число больше 2. Для решения
	// задачи использовать декомпозицию.
	public static void thirteenthTask(int n) {
		for (int i = n; i <= (2 * n) - 2; i++) {
			System.out.println(i + " и " + twinNumber(i));
		}

	}

	// 14. Натуральное число, в записи которого n цифр, называется числом
	// Армстронга, если сумма его цифр, возведенная в степень n, равна самому числу.
	// Найти все числа Армстронга от 1 до k. Для решения задачи использовать
	// декомпозицию.
	public static void fourteenthTask(int k) {
		for (int i = 1; i <= k; i++) {
			if (i == powerDigitSum(i)) {
				System.out.println(i);
			}
		}
	}

	// 15. Найти все натуральные n-значные числа, цифры в которых образуют строго
	// возрастающую последовательность (например, 1234, 5789). Для решения задачи
	// использовать декомпозицию.
	public static void fifteenthTask(int n) {
		for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
			long[] digits = tenthTask(i);
			if (isStricktlyAscendingSequence(digits)) System.out.println(i);
		}
	}

	// 16. Написать программу, определяющую сумму n - значных чисел, содержащих
	// только нечетные цифры. Определить также, сколько четных цифр в найденной
	// сумме. Для решения задачи использовать декомпозицию.
	public static void sixteenthTask(int n) {
		long sum = 0;
		for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
			long[] digits = tenthTask(i);
			if (isOnlyOddDigitsInSequence(digits)) sum = sum + i;
		}
		System.out.println("сумма чисел, содержащих только нечетные цифры:" + sum);
		long[] sumDigits = tenthTask(sum);
		System.out.println("четных числе в найденой сумме: " + evenDigitsInSequenceCounter(sumDigits));

	}

	// 17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму
	// его цифр и т.д. Сколько таких действий надо произвести, чтобы получился нуль?
	// Для решения задачи использовать декомпозицию.
	public static int seventeenthTask(int n) {
		int counter = 0;
		while (true) {
			int sum = digitsSum(n);
			n = n - sum;
			counter++;
			if (n == 0) break;
		}
		return counter;
	}

	public static int evenDigitsInSequenceCounter(long[] sequence) {
		int counter = 0;
		for (int i = 0; i < sequence.length; i++) {
			if (!isOddNumber(sequence[i])) counter++;
		}
		return counter;
	}

	public static boolean isOnlyOddDigitsInSequence(long[] sequence) {
		boolean isTrue = true;
		for (int i = 0; i < sequence.length; i++) {
			if (!isOddNumber(sequence[i])) isTrue = false;
		}
		return isTrue;
	}

	public static boolean isOddNumber(long number) {
		return number % 2 == 0 ? false : true;
	}

	public static boolean isStricktlyAscendingSequence(long[] sequence) {
		boolean isTrue = true;
		for (int i = 0; i < sequence.length - 1; i++) {
			if (sequence[i] >= sequence[i + 1]) isTrue = false;
		}
		return isTrue;
	}

	public static int powerDigitSum(int number) {
		int amountOfDigits = digitsCounter(number);
		int result = 0;
		while (number != 0) {
			result += Math.pow(number % 10, amountOfDigits);
			number /= 10;
		}

		return result;
	}

	public static int twinNumber(int number) {
		return number + 2;
	}

	public static int digitsSum(int number) {
		int result = 0;
		while (number != 0) {
			result += number % 10;
			number /= 10;
		}
		return result;
	}

	public static int digitsCounter(long number) {
		int counter = 0;
		int div = 10;
		while (number != 0) {
			number /= div;
			counter++;
		}
		return counter;
	}

	public static double quadrilateralAreaBySides(double x, double y, double z, double t) {
		return Math.sqrt((((x + y + z + t) / 2) - x) * (((x + y + z + t) / 2) - y) * (((x + y + z + t) / 2) - z)
				* (((x + y + z + t) / 2) - t));
	}

	public static int sumBetweenIndices(int[] array, int firstIndex, int lastIndex) {
		int sum = 0;
		for (int i = firstIndex; i <= lastIndex; i++) {
			sum += array[i];
		}
		return sum;
	}

	public static int factorial(int number) {
		int factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static double pointsDistance(double[] firstPoint, double[] secondPoint) {
		return Math.sqrt(Math.pow(secondPoint[0] - firstPoint[0], 2) + Math.pow(secondPoint[1] - firstPoint[1], 2));
	}

	public static double triangleAreaBySides(double firstSide, double secindSide, double thirdSide) {
		return Math.sqrt(
				((firstSide + secindSide + thirdSide) / 2) * (((firstSide + secindSide + thirdSide) / 2) - firstSide)
						* (((firstSide + secindSide + thirdSide) / 2) - secindSide)
						* (((firstSide + secindSide + thirdSide) / 2) - thirdSide));
	}

	public static int leastCommonMultiplie(int firstNumber, int secondNumber) {
		return Math.abs(firstNumber * secondNumber) / greatestCommonDivision(firstNumber, secondNumber);
	}

	public static int greatestCommonDivision(int firstNumber, int secondNumber) {
		int k = 1;
		while (firstNumber != 0 && secondNumber != 0) {
			while (firstNumber % 2 == 0 && secondNumber % 2 == 0) {
				firstNumber /= 2;
				secondNumber /= 2;
				k *= 2;
			}

			while (firstNumber % 2 == 0) firstNumber /= 2;
			while (secondNumber % 2 == 0) secondNumber /= 2;
			if (firstNumber >= secondNumber) firstNumber -= secondNumber;
			else secondNumber -= firstNumber;
		}
		return secondNumber * k;
	}
}
