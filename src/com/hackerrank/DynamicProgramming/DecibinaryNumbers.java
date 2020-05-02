package com.hackerrank.DynamicProgramming;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;

/*
 * PROBLEM not yet resolved fully
 */

public class DecibinaryNumbers {
	// Complete the maximumSum function below.
	static final int LIMIT_D = 19;
	static final int LIMIT_S = 300000;
	static long[][] f;
	static long[] c;
//    static long maximumSum(long[] a, long m) {
//    	
//    } //maximumSum
    
    static BigInteger solve(long x, long m) {
		int s = findS(x);
		long g = x - (s == 0 ? 0 : c[s - 1]);

		StringBuilder result = new StringBuilder();
		for (int d = LIMIT_D; d >= 1; d--) {
			int j = -1;
			long prevNumberCount = -1;
			long numberCount = 0;
			while (numberCount < g) {
				j++;

				prevNumberCount = numberCount;
				numberCount += f[d - 1][s - j * (1 << (d - 1))];
			}

			result.append(j);
			s -= j * (1 << (d - 1));
			g -= prevNumberCount;
		}
		return new BigInteger(result.toString());
	}

	static int findS(long x) {
		int index = Arrays.binarySearch(c, x);
		if (index < 0) {
			index = -1 - index;
		}
		return index;
	} //findS method

	static void buildF() {
		f = new long[LIMIT_D + 1][LIMIT_S + 1];
		for (int d = 0; d <= LIMIT_D; d++) {
			for (int s = 0; s <= LIMIT_S; s++) {
				if (d == 0) {
					if (s == 0) {
						f[d][s] = 1;
					} else {
						f[d][s] = 0;
					}
				} else {
					f[d][s] = 0;
					for (int i = 0; i <= 9; i++) {
						long nextS = s - i * (1L << (d - 1));
						if (nextS >= 0) {
							f[d][s] += f[d - 1][(int) nextS];
						}
					}
				}
			}
		}
	} //buildF method

	static void buildC() {
		c = new long[LIMIT_S + 1];
		long sum = 0;
		for (int i = 0; i < c.length; i++) {
			sum += f[LIMIT_D][i];
			c[i] = sum;
		}
	} //buildC method
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            long m = Long.parseLong(nm[1]);
            long[] a = new long[n];
            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);                
                a[i] = aItem;
                long x = scanner.nextLong();
            }
            //long result = maximumSum(a, m);
            //long result = solve(a, m);
            //bufferedWriter.write(String.valueOf(result));
            //System.out.println(result);
            //bufferedWriter.newLine();
            
            /*
            Scanner sc = new Scanner(System.in);
    		int q = sc.nextInt();
    		for (int tc = 0; tc < q; tc++) {
    			long x = sc.nextLong();

    			System.out.println(solve(x));
    		}
    		sc.close();
            */
        }
        //bufferedWriter.close();
        scanner.close();
    } //main
} //Class
