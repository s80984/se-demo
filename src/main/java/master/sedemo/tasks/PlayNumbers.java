package master.sedemo.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;


public class PlayNumbers {
	private final int[] numbers =	{-2, 4, 9, 4, -3, 4, 9, 5};
	private final int[] numbers_2 =	{8, 10, 2, 14, 4};


	public static void main(String[] args) {
		var appInstance = new PlayNumbers();
		appInstance.run();
	}

	void run() {
		//
		System.out.println("numbers: " + Arrays.toString(numbers));

		// Tests für Aufgaben 1.) und 2.)
		int result = sum(numbers);
//		System.out.println(String.format(" - sum(numbers) -> %d", result));
		//
		test0("sum", () -> sum(numbers));	// Aufruf von sum() über test-Methode
		test0("sumPositiveEvenNumbers", () -> sumPositiveEvenNumbers(numbers));

		// Tests für Aufgabe 3.)
		List.of(4, -3, 1).stream()
			.filter(x -> false)		// auf true setzen für Ausgaben
			.forEach(x -> {
				System.out.println(String.format("\ntesting: x=%d", x));
				test1("findFirst", x, (x1) -> findFirst(x1, numbers));
				test1("findLast", x, (x1) -> findLast(x1, numbers));
				test2("findAll", x, (x1) -> findAll(x1, numbers));
		});

		// Tests für Aufgabe 4.)
		Arrays.stream(new int[][] {
			{4, 9}, {9, 4}, {2, 3}
		})
			.filter(x -> false)		// auf true setzen für Ausgaben
			.forEach(t -> {
				int x = t[0];
				int y = t[1];
				System.out.println(String.format("\ntesting: (x=%d, y=%d)", x, y));
				test3("findAllAdjacent", x, y, (x1, y1) -> findAllAdjacent(x1, y1, numbers));
		});

		// Tests für Aufgabe 5.)
		int[][] results = findSums(10, numbers_2);
//		System.out.println(String.format("\nfindSums(%d, %s)", 10, Arrays.toString(numbers_2)));
//		for(int i=0; i < results.length; i++) {
//			System.out.println(String.format(" - %s", Arrays.toString(results[i])));
//		}
		//
		List.of(10, 12, 15, 18, 36).stream()
			.filter(sum -> false)	// auf true setzen für Ausgaben
			.forEach(sum -> {
				test4("findSums", sum, numbers_2, (s, nbs) -> findSums(s, nbs));
		});

		// Tests für Aufgabe 6.)
		List.of(14, 15, 20, 32).stream()
			.filter(sum -> false)	// auf true setzen f�r Ausgaben
			.forEach(sum -> {
				test4("findAllSums", sum, numbers_2, (s, nbs) -> findAllSums(s, nbs));
		});
	}


	/*
	 * Bitte implementieren Sie die Methoden aus der Aufgabe.
	 * 
	 * Aufgaben 1.) und 2.)
	 */
	public int sum(int[] numbers) {
		int result = 0;
		for (int i = 0; i < numbers.length; i++) {
			result+=numbers[i];
		}
		return result;
	}

	int sumPositiveEvenNumbers(int[] numbers) {
		int result = 0;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]%2 == 0 && numbers[i] > 0) result+=numbers[i];
			else continue;
		}
		return result;
	}


	/*
	 * Aufgabe 3.)
	 */
	int findFirst(int x, int[] numbers) {
		int result = -1;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == x ){
				result=i;
				break;
			}
		}
		return result;
	}

	int findLast(int x, int[] numbers) {
		int result = -1;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == x ){
				result=i;
			}
		}
		return result;
	}

	int[] findAll(int x, int[] numbers) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == x ){
				result.add(i);
			}
		}
		// convert List<Integer> to int[]
		return result.stream().mapToInt(Integer::intValue).toArray();
	}


	/*
	 * Aufgabe 4.)
	 */
	int[][] findAllAdjacent(int x, int y, int[] numbers) {
		int[][] results = {{0, 0}};
//		List<Integer> list = Arrays.asList(results);
//		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
//
//
//		for (int i = 0; i < array.length; i++) {
//			for (int d = 0; d < numbers.length; d++) {
//				if(numbers[i] == x && numbers[i+1] == y ){
//					array.add (i,i+1);
//				}
//			}
//		}
//
//		int[] primitive = list.stream()
//		.mapToInt(Integer::intValue)
//		.toArray();
//		for(int i=0; i < results.length; i++) {
//			System.out.println(String.format(" ‐ %s", Arrays.toString(results[i])));
//		}

		return results;
	}

	/*
	 * Aufgabe 5.)
	 */
	int[][] findSums(int sum, int[] numbers) {
		List<int[]> result = new ArrayList<int[]>();	// list of tuples (int[])

		return result.stream()	// convert List<int[]> to int[][]
				.map(t -> new int[] {t[0], t[1]})
				.toArray(int[][]::new);
	}


	/*
	 * Aufgabe 6.)
	 */
	int[][] findAllSums(int sum, int[] numbers) {
		int[][] result = {{0, 0}};

		return result;
	}


	/*
	 * Test methods that wrap functions, run them and print results.
	 * No need to change.
	 */
	void test0(String funcName, Supplier<Integer> func) {
		int i = func.get();			// invoke function
		System.out.println(String.format(" - %s(numbers) -> %d", funcName, i));
	}

	void test1(String funcName, int x, Function<Integer, Integer> func) {
		int i = func.apply(x);		// invoke function
		System.out.println(String.format(" - %s(%d, numbers) -> %d", funcName, x, i));
	}

	void test2(String funcName, int x, Function<Integer, int[]> func) {
		int[] all = func.apply(x);	// invoke function
		System.out.println(String.format(" - %s(%d, numbers) -> %s", funcName, x, Arrays.toString(all)));
	}

	void test3(String funcName, int x, int y, BiFunction<Integer, Integer, int[][]> func) {
		StringBuffer sb = new StringBuffer("[");
		int[][] all = func.apply(x, y);				// invoke function
		Arrays.stream(all).map(t -> Arrays.toString(t)/*.replace("[", "(").replace("]", ")")*/)
			.forEach(t -> sb.append(sb.length() > 1? ", " + t : t));
		sb.append("]");
		System.out.println(String.format(" - %s(%d, %d, numbers) -> %s", funcName, x, y, sb.toString()));
	}

	void test4(String funcName, int sum, int[] numbers, BiFunction<Integer, int[], int[][]> func) {
		int[][] results = func.apply(sum, numbers);	// invoke function
		System.out.println(String.format("\n%s(%d, %s)", funcName, sum, Arrays.toString(numbers)));
		for(int i=0; i < results.length; i++) {
			System.out.println(String.format(" - %s", Arrays.toString(results[i])));
		}
		if(results.length == 0) {
			System.out.println(" - []");
		}
	}
}
