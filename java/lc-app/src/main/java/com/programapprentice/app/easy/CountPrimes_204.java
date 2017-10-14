package com.programapprentice.app.easy;

public class CountPrimes_204 {
    /**
     [204] Count Primes

     https://leetcode.com/problems/count-primes

     Description:
     Count the number of prime numbers less than a non-negative number, n.

    * */
    public Boolean checkPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i*i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        if(n == 0 || n == 1) {
            return 0;
        }
        boolean[] isNotPrime = new boolean[n];

        isNotPrime[0] = true; // 1
        isNotPrime[1] = false; // 2
        int tmp = 0;
        for(int i = 2; i <= n; i++) {
            if(isNotPrime[i-1]) {
                // i is not prime
                continue;
            }
            tmp = 2 * i;
            while(tmp <= n) {
                isNotPrime[tmp - 1] = true;
                tmp += i;
            }
        }
        int counter = 0;
        for(int i = 0; i < n-1; i++) {
            counter += !isNotPrime[i] ? 1 : 0;
        }
        return counter;
    }

    public int countPrimesTimeExceed(int n) {
        if (n <= 2) {
            return 0;
        }
        int[] isPrimes = new int[n];
        isPrimes[1] = 1; // 1 means false, 0 means not checked 2 means true

        for (int i = 2; i < n; i++) {
            if (isPrimes[i] != 0) {
                continue;
            }
            Boolean isPrime =  checkPrime(i);
            if (isPrime) {
                isPrimes[i] = 2;
            } else {
                isPrimes[i] = 1;
            }
            int start = i * 2;
            while(start < n) {
                isPrimes[start] = 1;
                start += i;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (isPrimes[i] == 2) {
                sum++;
            }
        }
        return sum;
    }
}
