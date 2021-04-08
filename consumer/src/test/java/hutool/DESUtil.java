package hutool;

import com.sun.crypto.provider.SunJCE;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * Feng, Ge 2021/4/1 0001 10:07
 */
public class DESUtil {
    public DESUtil() {
    }

    public static String encrypt(String keyData, String str) throws Exception {
        if (StringUtils.isNotBlank(str)) {
            Security.addProvider(new SunJCE());
            Key key = getKey(keyData.getBytes("utf-8"));
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, key);
            return byteArr2HexStr(cipher.doFinal(str.getBytes("utf-8")));
        } else {
            return str;
        }
    }

    public static String decrypt(String keyData, String str) throws Exception {
        if (!StringUtils.isBlank(str)) {
            Security.addProvider(new SunJCE());
            Key key = getKey(keyData.getBytes("utf-8"));
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, key);
            return new String(cipher.doFinal(hexStr2ByteArr(str)), "utf-8");
        } else {
            return str;
        }
    }

    private static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        StringBuffer sb = new StringBuffer(iLen * 2);

        for(int i = 0; i < iLen; ++i) {
            int intTmp;
            for(intTmp = arrB[i]; intTmp < 0; intTmp += 256) {
            }

            if (intTmp < 16) {
                sb.append(0);
            }

            sb.append(Integer.toString(intTmp, 16));
        }

        return sb.toString();
    }

    private static byte[] hexStr2ByteArr(String strln) throws Exception {
        byte[] arrB = strln.getBytes();
        int iLen = arrB.length;
        byte[] arrOut = new byte[iLen / 2];

        for(int i = 0; i < iLen; i += 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte)Integer.parseInt(strTmp, 16);
        }

        return arrOut;
    }

    private static Key getKey(byte[] arrBTmp) throws Exception {
        byte[] arrB = new byte[8];

        for(int i = 0; i < arrBTmp.length && i < arrB.length; ++i) {
            arrB[i] = arrBTmp[i];
        }

        Key key = new SecretKeySpec(arrB, "DES");
        return key;
    }

    public static void main(String[] args) {
        String username = "xxxx@qq.com";
        String password = "sigangjun";

        try {
            System.out.println("加密之前的字符串为：" + username);
            System.out.println("密钥为：" + password);
            String b = encrypt(username, password);
            System.out.println("加密之后的字符串为：" + b);
            System.out.println("加密之后的字符串长度为：" + b.length());
            password = decrypt(username, "6b98381edf03b91cbb5f176bd163f7ba");
            System.out.println("解密之后的字符串为：" + password);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}

