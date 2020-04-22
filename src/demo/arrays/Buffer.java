package demo.arrays;

/**
 * @auther
 */

public class Buffer {
    int num;
    char[] buffer = null;
    int i;
    int j;
    public Buffer(int capacity) {
        this.num = 0;
        this.i = 0;
        this.j = 0;
        this.buffer = new char[capacity];
    }

    public int write(char[] c) {
        int count = 0;
        while (num < buffer.length && count < c.length) {
            buffer[j++] = c[count++];
            j %= buffer.length;
            num++;
        }
        return count;
    }

    public char[] read(int n) {
        char[] res = new char[n <= num ? n : num];
        int i = 0;
        while (i < res.length) {
            res[i++] = buffer[this.i++];
            i %= buffer.length;
        }
        num -= res.length;
        return res;
    }

    public static void main(String[] args) {
        Buffer b = new Buffer(5);
        b.write(new char[]{'a', 'b', 'c'});
        b.write(new char[]{'d', 'e', 'f'});
        b.read(3);
        b.read(5);
        b.write(new char[]{'d', 'e', 'f'});
    }
}
