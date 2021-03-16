package refactoring;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 租赁，表示某个顾客租了一部影片
 * Feng, Ge 2021/3/15 0015 16:45
 */
@Data
@AllArgsConstructor
public class Rental {
    private Movie _movie;
    private int _daysRented;

}
