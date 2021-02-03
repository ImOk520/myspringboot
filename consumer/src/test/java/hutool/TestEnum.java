package hutool;

/**
 * Feng, Ge 2021/2/3 0003 20:52
 */
public enum TestEnum{
    TEST1("type1", 01),
    TEST2("type2", 02),
    TEST3("type3", 03);

    private TestEnum(String type, int code) {
        this.type = type;
        this.code = code;
    }

    private String type;

    private int code;

    public String getType() {
        return this.type;
    }

    public int getCode() {
        return this.code;
    }
}
