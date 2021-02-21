package textUtil;

import cn.hutool.json.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class TextTest {

    private final String sourceFilePath = "C:/Users/fengge3/Desktop/exportLog (4).txt";
    private final static String destFilePath = "C:/Users/fengge3/Desktop/dealtExportLog.txt";

    @ApiOperation("转换为字符串")
    @Test
    public void test1() {
        File file = new File(sourceFilePath);
        System.out.println(txt2JSON2Write(file));
    }

    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            // 使用readLine方法，一次读一行
            while((s = br.readLine())!=null){
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 读取txt文件的内容 转换成 JSON对象 提取想要的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2JSON(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            // 使用readLine方法，一次读一行
            while((s = br.readLine())!=null){
                JSONObject jsonObject = new JSONObject(s);
                System.out.println(jsonObject.get("message"));
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 读取txt文件的内容 转换成 JSON对象 提取想要的内容 最后写入新的文档
     * @param file 想要读取的文件对象
     * @return 返回新文档
     */
    public static String txt2JSON2Write(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            // 使用readLine方法，一次读一行
            while((s = br.readLine())!=null){
                JSONObject jsonObject = new JSONObject(s);
                System.out.println(jsonObject.get("message"));
                String toWriteStr = jsonObject.get("message").toString();
                writeToTXT(System.lineSeparator() + toWriteStr, destFilePath);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writeToTXT(String str, String filePath){
        FileOutputStream o = null;
        byte[] buff = new byte[]{};
        try{
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }
            buff=str.getBytes();
            o=new FileOutputStream(file,true);
            o.write(buff);
            o.flush();
            o.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
