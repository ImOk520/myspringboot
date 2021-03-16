package refactoring;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 影片
 * Feng, Ge 2021/3/15 0015 16:45
 */
@Data
@AllArgsConstructor
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;
}
