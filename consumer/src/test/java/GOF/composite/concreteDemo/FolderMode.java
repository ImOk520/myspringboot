package GOF.composite.concreteDemo;

import lombok.ToString;

@ToString
public abstract class FolderMode {
    private String name;
    private String path;
    private String size;

    public FolderMode(String name, String path, String size) {
        this.name = name;
        this.path = path;
        this.size = size;
    }
}
