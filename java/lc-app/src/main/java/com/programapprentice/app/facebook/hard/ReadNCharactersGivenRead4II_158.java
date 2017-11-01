package com.programapprentice.app.facebook.hard;

public class ReadNCharactersGivenRead4II_158 {
    public int read4(char[] buf) {
        return 4;
    }

    char[] remains = new char[4];
    int sizeOfRemains = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n <= 0) {
            return 0;
        }
        char[] tmp = new char[4];
        boolean endOfLine = false;
        int count = 0;
        if (sizeOfRemains != 0) {
            if(sizeOfRemains <= n) {
                System.arraycopy(remains, 0, buf, count, sizeOfRemains);
                count += sizeOfRemains;
                sizeOfRemains = 0;
            } else {
                System.arraycopy(remains, 0, buf, count, n);
                System.arraycopy(remains, n, remains, 0, sizeOfRemains-n);
                sizeOfRemains -= n;
                return n;
            }
        }

        while(count <= n) {
            int actualRead = read4(tmp);
            if (actualRead < 4) {
                endOfLine = true;
            }
            int bytes = Math.min(n-count, actualRead);
            System.arraycopy(tmp, 0, buf, count, bytes);
            if (n-count < actualRead) {
                System.arraycopy(tmp, n - count, remains, 0, actualRead-(n-count) );
                sizeOfRemains = actualRead - (n - count);
            }
            count+= bytes;
            if (count == n) {
                break;
            }
            if (endOfLine) {
                break;
            }
        }
        return count;
    }
}
