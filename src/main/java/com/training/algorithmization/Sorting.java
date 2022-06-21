package com.training.algorithmization;

import java.util.Arrays;

public class Sorting {
	// 1. ������ ��� ���������� ������� � ��������� ����������� ��������� �
	// ����������� ����� k. ���������� �� � ���� ������, ������� ������ ������ �����
	// k-� � (k+1) - � ���������� �������, ��� ���� �� ��������� ��������������
	// ������.
	public static void firstTask(int[] firstArray, int[] secondArray, int k) {
		int[] newArray = new int[firstArray.length + secondArray.length];
		for (int i = 0; i < k; i++) {
			newArray[i] = firstArray[i];
		}
		for (int j = k; j < (k + secondArray.length); j++) {
			newArray[j] = secondArray[j - k];
		}
		for (int t = (k + secondArray.length); t < newArray.length; t++) {
			newArray[t] = firstArray[t - secondArray.length];
		}
		System.out.println(Arrays.toString(newArray));
	}

	// 2. ���� ��� ������������������ a1<=a2<=...<=an � b1<=b2<=...<=bm. ����������
	// �� ��� ����� ������������������ ����� ���, ����� ��� ���� ���� �����������.
	// ����������. �������������� ������ �� ������������.
	public static void secondTask(int[] firstArray, int[] secondArray) {
		int[] newArray = new int[firstArray.length + secondArray.length];
		for (int i = 0; i < newArray.length; i++) {
			if (i < firstArray.length) {
				newArray[i] = firstArray[i];
				continue;
			}
			newArray[i] = secondArray[i - firstArray.length];
		}
		System.out.println(Arrays.toString(newArray));
		for (int i = 0; i < newArray.length - 1; i++) {
			for (int j = 0; j < newArray.length - i - 1; j++) {
				if (newArray[j] > newArray[j + 1]) {
					int temp = newArray[j];
					newArray[j] = newArray[j + 1];
					newArray[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(newArray));
	}

	// 3. ���������� �������. ���� ������������������ �����
	// a1<=a2<=...<=an.��������� ����������� �������� ���, ����� ��� ����
	// ����������� �� ��������. ��� ����� � �������, ������� � �������, ����������
	// ���������� ������� � �������� �� ������ �����, � ������ - �� �����
	// �����������. �����, ������� �� �������, ��� ��������� �����������. ��������
	// �������� ���������� �������.
	public static void thirdTask(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int maxIndex = i;
			int maxValue = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > maxValue) {
					maxIndex = j;
					maxValue = array[j];
				}
			}
			array[maxIndex] = array[i];
			array[i] = maxValue;
		}
		System.out.println(Arrays.toString(array));
	}

	// 4. ���������� ��������. ���� ������������������ �����
	// a1<=a2<=...<=an.��������� ����������� ����� � ������� �����������. ��� �����
	// ������������ ��� �������� ����� ai � ai+1 . ���� ai > ai+1, �� ��������
	// ������������. ��� ������������ �� ��� ���, ���� ��� �������� �� ������
	// ����������� � ������� �����������. ��������� �������� ����������, �����������
	// ��� ���� ���������� ������������.
	public static void fourthTask(int[] array) {
		int swapCounter = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapCounter++;
				}
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println(swapCounter);
	}

	// 5. ���������� ���������. ���� ������������������ ����� a1<=a2<=...<=an.
	// ��������� ����������� ����� � ������� �����������. �������� ��� ���������
	// �������. ����� a1, a2,..., ai - ������������� ������������������, �. �.
	// a1<=a2<=...<=an. ������� ��������� ����� ai+1 � ����������� �
	// ������������������ ���, ����� ����� ������������������ ���� ����
	// ������������. ������� ������������ �� ��� ���, ���� ��� �������� �� i +1 �� n
	// �� ����� ���������. ����������. ����� ��������� ���������� �������� �
	// ��������������� ����� ����������� � ������� ��������� ������. �������� �����
	// �������� � ���� ��������� �������.
	public static int[] fivthTask(int[] array) {
		System.out.println(Arrays.toString(array));
		for (int i = 1; i < array.length; i++) {
			int element = array[i];
			int insertIndex = binarySearth(array, element, i);
			for (int j = i; j > insertIndex; j--) {
				array[j] = array[j - 1];
			}
			array[insertIndex] = element;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}

	// 6. ���������� �����. ��� ������ n �������������� �����. ��������� �����������
	// ��� �� �����������. �������� ��� ��������� �������: ������������ ��� ��������
	// �������� ai � ai+1. ���� ai <= ai+1, �� ������������ �� ���� ������� ������.
	// ���� ai > ai+1, �� ������������ ������������ � ���������� �� ���� �������
	// �����. ��������� �������� ���� ����������.
	public static void sixthTask(double[] array) {
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length - 1;) {
			if (array[i] <= array[i + 1]) {
				i++;
				continue;
			}
			if (array[i] > array[i + 1]) {
				double temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
				if (i != 0) i--;
			}
		}
		System.out.println(Arrays.toString(array));
	}

	// 7. ����� ���� ��� ����������� ������������������ �������������� �����
	// a1<=a2<=...<=an � b1<=b2<=...<=bm. ��������� ������� �� �����, �� �������
	// ����� ��������� �������� ������������������ b1<=b2<=...<=bm � ������
	// ������������������ ���, ����� ����� ������������������ ����������
	// ������������.
	public static void seventhTask(int[] firstArray, int[] secondArray) {
		for (int i = 0; i < secondArray.length; i++) {
			boolean isLast = true;
			for (int j = 0; j < firstArray.length; j++) {
				if (secondArray[i] < firstArray[j]) {
					System.out.println("������� " + i + " ������� ������� ���������� �������� ����� " + j
							+ " ��������� ������� �������.");
					isLast = false;
					break;
				}
			}
			if (isLast) {
				System.out.println("������� " + i + " ������� ������� ���������� �������� ����� " + i
						+ " ��������� ������� �������.");
			}

		}

	}

	// 8.���� ����� p1/q1, p2/q2,..., pn/qn (pi, qi, - �����������). ���������
	// ���������, ������� �������� ��� ����� � ������ ����������� � ������������� ��
	// � ������� �����������.
	public static void eighthTask(int[] numerator, int[] denominator) {
		int lcm = denominator[0];
		for (int i = 0; i < denominator.length; i++) {
			lcm = Decomposition.leastCommonMultiplie(lcm, denominator[i]);
		}
		for (int i = 0; i < denominator.length; i++) {
			numerator[i] *= lcm / denominator[i];
			denominator[i] = lcm;
		}
		numerator = fivthTask(numerator);
		System.out.println(Arrays.toString(numerator));
		System.out.println(Arrays.toString(denominator));
	}

	private static int binarySearth(int[] array, int element, int sortedArrayLength) {
		int elementPos = 0;
		int lowIndex = 0;
		int highIndex = sortedArrayLength;
		while (lowIndex <= highIndex) {
			int midIndex = (lowIndex + highIndex) / 2;
			if ((lowIndex + highIndex) == 0) {
				elementPos = 0;
				break;
			}
			if (element == array[midIndex]) {
				elementPos = midIndex;
				break;
			}
			if (element < array[midIndex]) {
				if (midIndex == 0) {
					elementPos = midIndex;
					break;
				}
				if (element > array[midIndex - 1]) {
					elementPos = midIndex;
					break;
				}
				highIndex = midIndex - 1;
			}
			if (element > array[midIndex]) {
				lowIndex = midIndex + 1;
			}
		}
		return elementPos;
	}
}
