package com.training.algorithmization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleDimentionalArrays {
	// 1.� ������ A [N] �������� ����������� �����. ����� ����� ��� ���������,
	// ������� ������ ������� �.
	public static int firstTask(int[] array, int k) {
		int result = 0;
		for (int number : array) {
			if (number % k == 0) result += number;
		}
		return result;
	}

	// 2. ���� ������������������ �������������� ����� �1 ,�2 ,..., �n. �������� ���
	// �� �����, ������� ������� Z, ���� ������. ���������� ���������� �����.
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

	// 3. ��� ������ �������������� �����, ����������� �������� N. ����������,
	// ������� � ��� �������������, ������������� � ������� ���������.
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
		System.out.println("������������� �����: " + positive);
		System.out.println("������������� ������: " + negative);
		System.out.println("�����: " + zero);
	}

	// 4. ���� �������������� ����� �1 ,�2 ,..., �n . �������� ������� ���������� �
	// ���������� ��������.
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

	// 5. ���� ����� ����� �1 ,�2 ,..., �n . ������� �� ������ ������ �� �����, ���
	// ������� �i > i.
	public static void fivthTask(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > i) System.out.println(array[i]);
		}
	}

	// 6. ������ ������������������ N ������������ �����. ��������� ����� �����,
	// ���������� ������ ������� �������� �������� �������.
	public static double sixthTask(double[] n) {
		double sum = 0;
		for (int i = 2; i < n.length; i++) {
			if (isSimple(i)) sum += n[i];
		}
		return sum;
	}

	// 7. ���� �������������� ����� a1, a2,..., an. ����� max(a1+a2n,a2+a2n-1,...,an+an+1).
	public static double seventhTask(double[] array) {
		System.out.println("???????????????????????????????");
		return 0;
	}

	// 8. ���� ������������������ ����� ����� a1, a2,..., an. ���������� �����
	// ������������������, �������� ���������� �� �����, ������� ����� (a1,a2,...,an).
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

	// 9. � ������� ����� ����� � ����������� ��������� n ����� �������� �����
	// ������������� �����. ���� ���� ����� ���������, �� ���������� ���������� ��
	// ���.
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
		System.out.println("�������� ����� ������������� �����: " + frequentSet.toString());
		System.out.println("���������� ������: " + maxCounter);
		if (minFromFrequent != firstFrequent)
			System.out.println("����������� �� �������� ����� ������������� �����: " + minFromFrequent);
	}

	// 10. ��� ������������� ������ � ����������� ��������� �. ����� ������,
	// �������� �� ���� ������ ������ ������� (�������������� �������� ���������
	// ������). ����������. �������������� ������ �� ������������.
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
