package sort;

import java.util.Arrays;

public class BitSet {
    private int[] bits;

    private final static int ADDRESS_BITS_PER_WORD = 5;
    private final static int BITS_PER_WORD = 1 << ADDRESS_BITS_PER_WORD;

    /**
     * 无参构造器
     * 默认构造容量为32bit的数组，即数组长度为1
     */
    public BitSet() {
        bits = new int[(BITS_PER_WORD - 1) >> ADDRESS_BITS_PER_WORD + 1];
    }

    /**
     * 有参构造器
     * @param nbits 数字的个数
     */
    public BitSet(int nbits) {
        bits = new int[(nbits - 1) >> ADDRESS_BITS_PER_WORD + 1];
    }

    public int[] getBits() {
        return bits;
    }

    /**
     * 把num映射到bits数组中
     * @param num
     */
    public void set(int num) {
        // num在数组中的下标
        int index = num >> ADDRESS_BITS_PER_WORD;
        // TODO：要检查数组是否需要扩容
        bits[index] |= 1 << (num & 0x1F);
    }

    /**
     * 判断bits数组中对应位的值
     * @param bitIndex
     * @return
     */
    public boolean get(int bitIndex) throws Exception {
        if (bitIndex < 0) {
            throw new Exception();
        }
        // 把输入的下标进行转换，对应数组某个值的某个位置
        int index = bitIndex >> ADDRESS_BITS_PER_WORD;
        return (bitIndex < bits.length) && ((bits[index] & (1 << (bitIndex & 0x1F))) != 0);
    }

    public static void main(String[] args) throws Exception {
        // 5亿个数
        BitSet bitSet = new BitSet(1_0000_0000);
        // 目标数组
        int[] arr = {2, 98, 76, 56, 100, 762, 16, 95};
        Arrays.stream(arr).forEach(num -> {
            bitSet.set(num);
        });

        // 判断某个数在数组中是否存在
        System.out.println(bitSet.get(100));  // true
        System.out.println(bitSet.get(200));  // false
        System.out.println(bitSet.get(762));  // true

        // 输出排序后的数组
        int[] res = bitSet.getBits();
        int count = 0;
        for (int i = 0; i < res.length; i++) {
            // 按位输出
            for (int j = 0; j < 32; j++) {
                // 为1表示该数存在
                if (((res[i] >> j) & 1) == 1) {
                    arr[count++] = i * 32 + j;
                }
            }
        }
        // 2 16 56 76 95 98 100 762
        Arrays.stream(arr).forEach(System.out::println);
    }
}
