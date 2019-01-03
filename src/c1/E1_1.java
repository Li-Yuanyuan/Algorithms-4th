package c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E1_1 {
	public static double e1_1_20_ln(int n) {
		if (n <= 1) {
			return 0;
		} else {
			return (Math.log(n) + e1_1_20_ln(n - 1));
		}
	}

	public static int e1_1_22_rank(int key, int[] a, int lo, int hi, int depth) {
		if (lo > hi) {
			return -1;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < depth; ++i) {
			sb.append("\t");
		}
		sb.append("lo:");
		sb.append(lo);
		sb.append(" hi:");
		sb.append(hi);

		System.out.println(sb);
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) {
			return e1_1_22_rank(key, a, lo, mid - 1, ++depth);
		} else if (key > a[mid]) {
			return e1_1_22_rank(key, a, mid + 1, hi, ++depth);
		} else {
			return mid;
		}
	}
	
	public static void e1_1_28() {
	  Integer[] whitelist = new Integer[] { 84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 48, 33, 16, 77, 11, 29 };
	    Arrays.sort(whitelist);
	    List<Integer> list = new ArrayList<Integer>(Arrays.asList(whitelist));

	    for (int i = 0; i < list.size() - 1; ++i) {
	      int j = i + 1;
	      while (j < list.size() && list.get(i) == list.get(j)) {
	        list.remove(j++);
	      }
	    }
	    
	    list.forEach(item -> System.out.print(item + " "));
	}
	
	public static int e1_1_38_bruteForceSearch(int key, int[] a) {
	  for (int i = 0; i < a.length; ++i) {
	    if (a[i] == key) {
	      return i;
	    }
	  }
	  return -1;
	}

	public static void main(String[] args) {
		// e1_1_20
		System.out.println(e1_1_20_ln(6) + " " + Math.log(720));

		// e1_1_21
		int[] whitelist = new int[] { 84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 48, 33, 16, 77, 11, 29 };
		Arrays.sort(whitelist);
		int[] keyInt = new int[] { 23, 50, 10, 99, 18, 23, 98, 84, 11, 10, 48, 77, 13, 54, 98, 77, 77, 68 };
		for (int key : keyInt) {
			if (e1_1_22_rank(key, whitelist, 0, whitelist.length - 1, 0) < 0) {
				System.out.println(key);
			}
		}
		
		// e1_1_28
		e1_1_28();
	}

}
