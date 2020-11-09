

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSA {
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥
    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "{\n" +
                "    \"outpatientId\": \"998a98fe-6047-4428-864e-17445bcbdcdb\",\n" +
                "    \"orgCode\": \"2201042B100002\",\n" +
                "    \"doctorId\": \"93172e09-ad55-4e27-9390-5a00887d61ed\",\n" +
                "    \"doctorName\": \"高岩\",\n" +
                "    \"diagList\": [\n" +
                "        {\n" +
                "            \"diagnosticMainSign\": \"1\",\n" +
                "            \"diagTypeCode\": \"2\",\n" +
                "            \"diagnosticCode\": \"CYZD2009160006\",\n" +
                "            \"diagnosticName\": \"心律不齐\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"diagnosticMainSign\": \"0\",\n" +
                "            \"diagTypeCode\": \"2\",\n" +
                "            \"diagnosticCode\": \"CYZD2009160004\",\n" +
                "            \"diagnosticName\": \"拔牙术后\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"time\": \"2020-11-04 09:22\"\n" +
                "  }";
        System.out.println("加密内容长度：" + message.length());
        System.out.println("随机生成的公钥为:" + keyMap.get(0));
        System.out.println("随机生成的私钥为:" + keyMap.get(1));
//        String messageEn = encrypt(message,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAizGyk6PZILogQeR/wGcPW56FavfUys0onfrk6NNZCMjwa1xu+oh99JbQDXE1lnsv9HVoFquNzKxYbBfTQwj8mDUdI5nUhAD7HbX8SE0l3cRrKctxjQz+cV5669s10uvMXkll5D1Gg+PSn8EY9cNhrLrENYRMsv7dJw6BINcI4HFq7wP6KdqYfnG9zv3w+rQKAfakd1ctbomjGGHo0Tl9jbJx9KL+wu7IbsKoh5ZHBIJu/6DKohUvly4A6qDY8sDfPNfoLJCEldibBpf59PBPjt+GJKTdSYL/9xQ09aUBMIVtzoNavAO1A3TGiLvQ6Yeo9JggTumpCyxEBlIx4wYz8wIDAQAB");
//        System.out.println(message + "\t加密后的字符串为:" + messageEn);
//        String messageDe = decrypt("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");
        String messageEn = encrypt(message, keyMap.get(0));
        String messageDe = decrypt(messageEn, keyMap.get(1));
        System.out.println("还原后的字符串为:" + messageDe);
    }

    /**
     * 随机生成密钥对
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为>1024位
        keyPairGen.initialize(2048,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(0,publicKeyString);  //0表示公钥
        keyMap.put(1,privateKeyString);  //1表示私钥
    }
    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @param privateKey
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

}

