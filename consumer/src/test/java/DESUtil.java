import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * DES加密、解密
 * Feng, Ge
 */
public class DESUtil {

    private final static String DES = "DES";//方式
    private final static String ENCODE = "UTF-8";//编码
    private final static String defaultKey = "cmp_security_key";//8的倍数秘钥


    /**
     * 使用 默认key 加密
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午02:46:43
     */
    public static String encrypt(String data) throws Exception {
        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    /**
     * 使用 默认key 解密
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午02:49:52
     */
    public static String decrypt(String data) throws IOException, Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, defaultKey.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException,
            Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, key.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws Exception {
        decrypt("bS3/DHwdEtNdTFHlnZCWm2Fo52ZYDMcwaf0S2C+6MHrAVm+FvZzwfOr560L+Pep3Zn2YZSHtnO4/ksFxNWQumvcL4Xa0LRdNT8toQXlCrocOqwoIcWWrzHQS6W5CJwAdY1SyMxl8NQOOL9yu/GohggXeXLRo4LjFPiqJGu69wW4MxbLgcnkihZyqnr/1LiHbKaNYrrAC2oOJCHXhvQuBappzMr5GiTmKl20f2PgLNDKqLNevGBlXP4SAKyPwntW2gXfx43fDhW5qzHVRRS7NW+aeG71FFNGvmYuqYv6tsMMHKXBsHYRLYHxh4awlSxGfLtxnWIbpDlwfNf9gBq3j+xuBVrBBr/fO4HpKbqIZq3mnDeiVLuwOoZdtH9j4CzQyqizXrxgZVz8gRBFuRCjuRYF38eN3w4Vuasx1UUUuzVvmnhu9RRTRr5mLqmL+rbDDBylwbB2ES2B8YeGsJUsRn1Ceo/sl+mGyHzX/YAat4/szKW7ju0bdChMjD6yVECzUKgHmPMEkj2c=");
        System.out.println("dwsddsdsd====:" + decrypt("bS3/DHwdEtNdTFHlnZCWm2Fo52ZYDMcwaf0S2C+6MHrAVm+FvZzwfOr560L+Pep3Zn2YZSHtnO4/ksFxNWQumvcL4Xa0LRdNT8toQXlCrocOqwoIcWWrzHQS6W5CJwAdY1SyMxl8NQOOL9yu/GohggXeXLRo4LjFPiqJGu69wW4MxbLgcnkihZyqnr/1LiHbKaNYrrAC2oOJCHXhvQuBappzMr5GiTmKl20f2PgLNDKqLNevGBlXP4SAKyPwntW2gXfx43fDhW5qzHVRRS7NW+aeG71FFNGvmYuqYv6tsMMHKXBsHYRLYHxh4awlSxGfLtxnWIbpDlwfNf9gBq3j+xuBVrBBr/fO4HpKbqIZq3mnDeiVLuwOoZdtH9j4CzQyqizXrxgZVz8gRBFuRCjuRYF38eN3w4Vuasx1UUUuzVvmnhu9RRTRr5mLqmL+rbDDBylwbB2ES2B8YeGsJUsRn1Ceo/sl+mGyHzX/YAat4/szKW7ju0bdChMjD6yVECzUKgHmPMEkj2c="));
    }
}
