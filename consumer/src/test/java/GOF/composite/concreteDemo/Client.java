package GOF.composite.concreteDemo;

import GOF.composite.concreteDemo.FolderLeaf;
import GOF.composite.concreteDemo.FolderMode;
import GOF.composite.concreteDemo.FolderNonLeaf;
import cn.hutool.core.lang.Console;

public class Client {
    public static void main(String[] args) {
        FolderNonLeaf folderNonLeaf = getFolders();
        showTree(folderNonLeaf);
    }

    private static FolderNonLeaf getFolders() {
        // 第一层根目录
        FolderNonLeaf root = new FolderNonLeaf("文件夹1", "1", "1");
        // 文件夹1的两个子文件夹
        FolderNonLeaf second_A = new FolderNonLeaf("文件夹1-1", "1/1-1", "6");
        FolderNonLeaf second_B = new FolderNonLeaf("文件夹1-2", "1/1-2", "6");
        // second_A的三个子文件夹
        FolderNonLeaf third_second_A_A = new FolderNonLeaf("文件夹1-1-1", "1/1-1/1-1-1", "40");
        FolderNonLeaf third_second_A_B = new FolderNonLeaf("文件夹1-1-2", "1/1-1/1-1-2", "40");
        FolderNonLeaf third_second_A_C = new FolderNonLeaf("文件夹1-1-3", "1/1-1/1-1-3", "30");
        // second_B的两个子文件夹
        FolderNonLeaf third_second_B_A = new FolderNonLeaf("文件夹1-2-1", "1/1-1/1-2-1", "30");
        FolderNonLeaf third_second_B_B = new FolderNonLeaf("文件夹1-2-2", "1/1-1/1-2-2", "30");
        // third_second_A_A子文件夹
        FolderNonLeaf fourth_third_second_A_A_A = new FolderNonLeaf("文件夹1-1-1-1", "1/1-1/1-1-1/1-1-1-1", "60");

        // 开始组装树状族谱
        // 第二层
        root.addFolder(second_A);
        root.addFolder(second_B);
        // 第三层
        second_A.addFolder(third_second_A_A);
        second_A.addFolder(third_second_A_B);
        second_A.addFolder(third_second_A_C);
        second_B.addFolder(third_second_B_A);
        second_B.addFolder(third_second_B_B);
        // 第四层
        third_second_A_A.addFolder(fourth_third_second_A_A_A);
        return root;
    }

    //通过递归遍历树
    private static void showTree(FolderNonLeaf root) {
        System.out.println(root.toString());
        for(FolderMode folder:root.getList()){
            // 叶子节点
            if(folder instanceof FolderLeaf){
                System.out.println(folder.toString());
            }else{
                showTree((FolderNonLeaf) folder);
            }
        }
    }
}
