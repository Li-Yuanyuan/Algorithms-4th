package c1;

import java.util.Arrays;

public class BinarySearch {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int rankRecursive(int key, int[] a, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}

		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) {
			return rankRecursive(key, a, lo, mid - 1);
		} else if (key > a[mid]) {
			return rankRecursive(key, a, mid + 1, hi);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		int[] whitelist = new int[] { 84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 48, 33, 16, 77, 11, 29 };
		Arrays.sort(whitelist);
		int[] keyInt = new int[] { 23, 50, 10, 99, 18, 23, 98, 84, 11, 10, 48, 77, 13, 54, 98, 77, 77, 68 };
		for (int key : keyInt) {
			if (rank(key, whitelist) < 0) {
				System.out.println(key);
			}
		}
	}
}
