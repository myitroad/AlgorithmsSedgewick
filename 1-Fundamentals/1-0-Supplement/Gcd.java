/**
 * @author nonefly
 * 2015年8月27日
 * 来源：https://www.cnblogs.com/nonefly/p/4767919.html
 */
public class Gcd {
    /**
     * 暴力尝试
     */
    public static int gcd0(int a, int b) {
        if(a < 0 || b < 0)
            return -1;
        for (int i = a > b ? b : a; i > 1; i--) {
            if(a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }
    /** 解法一 
     * 欧几里得算法（辗转相除法）
     * 求两个数(a b,假设a > b)最大公约数,
     * 每次用较大数a除b取余为c,
     * 余数c不为0则让较大数等于较小数，较小数等于余数,即:
     * a = b; b= c;
     */
    public static int gcd1(int a, int b) {
        if(a < 0 || b < 0)
            return -1;
        if(a == b || a == 0)
            return b;
        if(b == 0)
            return a;
        if(a < b)
            return gcd1(a, b % a);
        else
            return gcd1(b, a % b);
    }
    /**
     * 更相减损术 来自《九章算术》
     * ps:我也不知道这算法来头，只是知道算法思想，查后才知它的出处和名字~
     *（如果需要对分数进行约分，那么）可以折半的话，就折半（也就是用2来约分）。
     * 如果不可以折半的话，那么就比较分母和分子的大小，用大数减去小数，互相减来减去，一直到减数与差相等为止，用这个相等的数字来约分。
     */
    public static int gcd2(int a, int b) {
        if(a < 0 || b < 0)
            return -1;
        if(a == b)
            return a;
        //以下判断a和b是否可折半（为偶数）的四种情况
        if((a & 1) > (b & 1))
            return gcd2(a, b >> 1);
        if((a & 1) < (b & 1))
            return gcd2(a >> 1, b);
        if((a & 1) == 0 && (b & 1) == 0)
            return gcd2(a >> 1, b >> 1) << 1;
        return gcd2(Math.abs(a - b), b > a ? a : b);
    }

    public static void main(String[] args) {
        System.out.println(gcd1(99, 66));
    }
}