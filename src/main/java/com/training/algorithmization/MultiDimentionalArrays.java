package com.training.algorithmization;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiDimentionalArrays {
	// 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый
	// элемент больше последнего.
	public static void firstTask(double[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			if ((i + 1) % 2 != 0) {
				if (matrix[0][i] > matrix[matrix.length - 1][i]) {
					for (int j = 0; j < matrix.length; j++) {
						System.out.println(matrix[j][i]);
					}
					System.out.println("---");
				}
			}
		}
	}

	// 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
	public static void secondTask(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(matrix[i][i]);
		}
	}

	// 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
	public static void thirdTask(double[][] matrix, int k, int p) {
		System.out.println("строка k(" + k + "): " + Arrays.toString(matrix[k]));
		System.out.println("столбец p(" + p + "): ");
		for (int i = 0; i < matrix[0].length; i++) {
			System.out.println(matrix[i][p]);
		}
	}

	// 4. Сформировать квадратную матрицу порядка n по заданному образцу(n -
	// четное):
	public static void fourthTask(int n) {
		for (int i = 0; i < n; i++) {
			if ((i + 1) % 2 == 0) {
				for (int j = 0; j < n; j++) {
					System.out.print((n - j) + "|");
				}
			} else {
				for (int j = 0; j < n; j++) {
					System.out.print((j + 1) + "|");
				}
			}
			System.out.println();
		}
	}

	// 5. Сформировать квадратную матрицу порядка n по заданному образцу(n -
	// четное):
	public static void fivthTask(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j >= (n - i)) {
					System.out.print(0 + "|");
					continue;
				}
				System.out.print((i + 1) + "|");

			}
			System.out.println();
		}
	}

	// 6. Сформировать квадратную матрицу порядка n по заданному образцу(n -
	// четное):
	public static void sixthTask(int n) {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				if (j <= i - 1) {
					System.out.print(0 + "|");
					continue;
				}
				if (j >= n - i) {
					System.out.print(0 + "|");
					continue;
				}
				System.out.print(1 + "|");
			}
			System.out.println();
		}
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((j + 1) >= (i + 2)) {
					System.out.print(0 + "|");
					continue;
				}
				if (j + 1 >= n - i) {
					System.out.print(1 + "|");
					continue;
				}
				System.out.print(0 + "|");
			}
			System.out.println();
		}
	}

	// 7. Сформировать квадратную матрицу порядка N по правилу: и подсчитать
	// количество положительных элементов в ней.
	public static void seventhTask(int n) {
		int counter = 0;
		double element = 0;
		String strFormatter = null;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				element = Math.sin(((i * i) - (j * j)) / n);
				if (element > 0) counter++;
				strFormatter = new DecimalFormat("#0.000").format(element);
				System.out.print(strFormatter + "|");
			}
			System.out.println();
		}
		System.out.println("количество положительных элементов: " + counter);
	}

	// 8. В числовой матрице поменять местами два столбца любых столбца, т. е. все
	// элементы одного столбца поставить на соответствующие им позиции другого, а
	// его элементы второго переместить в первый. Номера столбцов вводит
	// пользователь с клавиатуры.
	public static void eighthTask(double[][] matrix) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Введите номер первого столбца (размер матрицы: " + matrix.length + "):");
			int firstColumn = in.nextInt() - 1;
			System.out.println("Введите номер второго столбца (размер матрицы: " + matrix.length + "):");
			int secondColumn = in.nextInt() - 1;
			in.close();
			if (firstColumn >= matrix.length || firstColumn < 0 || secondColumn >= matrix.length || secondColumn < 0)
				throw new ArrayIndexOutOfBoundsException(
						"Одно или оба из значений столбцов, введеных вами, больше размера матрицы или меньше либо равны нуля!");
			double temp = 0;
			printMatrix(matrix);
			for (int i = 0; i < matrix.length; i++) {
				temp = matrix[i][firstColumn];
				matrix[i][firstColumn] = matrix[i][secondColumn];
				matrix[i][secondColumn] = temp;
			}
			printMatrix(matrix);
		} catch (InputMismatchException e) {
			System.err.println("Вы ввели неправильный тип переменной! Тип вводимой переменной должен быть int.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}

	// 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом
	// столбце. Определить, какой столбец содержит максимальную сумму.
	public static void ninthTask(double[][] matrix) {
		double[] sumArray = new double[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				sumArray[i] += matrix[j][i];
			}
		}
		System.out.println(Arrays.toString(sumArray));
		int maxSumColumnIndex = 0;
		for (int i = 0; i < sumArray.length - 1; i++) {
			if (sumArray[i] < sumArray[i + 1]) maxSumColumnIndex = i + 1;
		}
		System.out.println("Номер столбца, содержащего максимальную сумму элементов: " + maxSumColumnIndex + 1);
	}

	// 10. Найти положительные элементы главной диагонали квадратной матрицы.
	public static void tenthTask(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][i] > 0) System.out.println(matrix[i][i]);
		}
	}

	// 11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран
	// саму матрицу и номера строк, в которых число 5 встречается три и более раз.
	public static void eleventhTask() {
		int[][] matrix = new int[10][20];
		int counter = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = (int) (Math.random() * 15);
				if (matrix[i][j] == 5) counter++;
			}
			if (counter >= 5) System.out.println("В строке " + (i + 1) + " число 5 встречается " + counter + " раз");
			counter = 0;

		}
		printMatrix(matrix);

	}

	// 12. Отсортировать строки матрицы по возрастанию и убыванию значений
	// элементов.
	public static void twelfthTask(double[][] matrix) {
		double tmp = 0;
		for (int k = 0; k < matrix.length; k++) {
			for (int i = matrix[k].length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (matrix[k][j] > matrix[k][j + 1]) {
						tmp = matrix[k][j];
						matrix[k][j] = matrix[k][j + 1];
						matrix[k][j + 1] = tmp;
					}
				}
			}
		}
		System.out.println("Матрица с отсортироваными значениями в рядах по возрастанию:");
		printMatrix(matrix);
		for (int k = 0; k < matrix.length; k++) {
			for (int i = matrix[k].length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (matrix[k][j] < matrix[k][j + 1]) {
						tmp = matrix[k][j];
						matrix[k][j] = matrix[k][j + 1];
						matrix[k][j + 1] = tmp;
					}
				}
			}
		}
		System.out.println("Матрица с отсортироваными значениями в рядах по убыванию:");
		printMatrix(matrix);
	}

	// 13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
	public static void thirteenthTask(double[][] matrix) {
		double tmp = 0;
		for (int k = 0; k < matrix.length; k++) {
			for (int i = matrix.length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (matrix[j][k] > matrix[j + 1][k]) {
						tmp = matrix[j][k];
						matrix[j][k] = matrix[j + 1][k];
						matrix[j + 1][k] = tmp;
					}
				}
			}
		}
		System.out.println("Матрица с отсортироваными значениями в столбцах по возрастанию:");
		printMatrix(matrix);
		for (int k = 0; k < matrix.length; k++) {
			for (int i = matrix.length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (matrix[j][k] < matrix[j + 1][k]) {
						tmp = matrix[j][k];
						matrix[j][k] = matrix[j + 1][k];
						matrix[j + 1][k] = tmp;
					}
				}
			}
		}
		System.out.println("Матрица с отсортироваными значениями в столбцах по убыванию:");
		printMatrix(matrix);
	}

	// 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем
	// в каждом столбце число единиц равно номеру столбца.
	public static void fourteenthTask(int m, int n) {
		int[][] matrix = new int[m][n];
		StringBuilder tmp = new StringBuilder("");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() + 0.5);
				tmp.append(1);
				if (matrix[i][j] == 1) matrix[i][j] = Integer.parseInt(tmp.toString());
			}
			tmp.setLength(0);
		}
		printMatrix(matrix);
	}

	// 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на
	// него.
	public static void fivteenthTask(double[][] matrix) {
		double maxElement = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > maxElement) maxElement = matrix[i][j];
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] % 2 != 0) matrix[i][j] = maxElement;
			}
		}
		printMatrix(matrix);
	}

	// 16. Магическим квадратом порядка n называется квадратная матрица размера nxn,
	// составленная из чисел 1, 2, 3,...,n^2 так, что суммы по каждому столбцу,
	// каждой строке и каждой из двух больших диагоналей равны между собой.
	// Построить такой квадрат. Пример магического квадрата порядка 3:
	public static void sixteenthTask(int n) {
		if (n % 2 == 0) {
			System.out.println("Размерность матрицы должна быть нечетной!");
			return;
		}
		int[][] matrix = new int[n][n];
		int column = n / 2;
		int row = 0;
		for (int i = 1; i <= n * n;) {
			if (row < 0 && column >= n) {
				column--;
				row += 2;
				continue;
			}
			if (row < 0) {
				row = n - 1;
				continue;
			}
			if (column >= n) {
				column = 0;
				continue;
			}
			if (matrix[row][column] != 0) {
				column--;
				row += 2;
				continue;
			}
			matrix[row][column] = i;
			column++;
			row--;
			i++;
		}
		printMatrix(matrix);
	}

	private static void printMatrix(double[][] matrix) {
		System.out.println("_________________________");
		for (int i = 0; i < matrix.length; i++) System.out.println(Arrays.toString(matrix[i]));
		System.out.println("_________________________");
	}

	private static void printMatrix(int[][] matrix) {
		System.out.println("_________________________");
		for (int i = 0; i < matrix.length; i++) System.out.println(Arrays.toString(matrix[i]));
		System.out.println("_________________________");
	}

}
