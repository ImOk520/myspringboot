package GOF.composite.concreteDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 非叶子文件夹
 */
public class FolderNonLeaf extends FolderMode {
    private List<FolderMode> list=new ArrayList<>();

    public FolderNonLeaf(String name, String path, String size) {
        super(name, path, size);
    }

    public void addFolder(FolderMode folder){
        this.list.add(folder);
    }

    public List<FolderMode> getList(){
        return this.list;
    }
}
