package dateUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

@Slf4j
public class DateTest {

    @Test
    public void test1() throws ParseException {
        String nowStr = DateUtil.getNowStr(DateUtil.STANDARD_FORMAT);
        String starter = "2020-01-01 00:00:01";
        List<String> yearMonths = DateUtil.getMonthBetween(starter, "2022-05-01 00:00:01", DateUtil.SHORTER_FORMAT);
        log.info("【从{}开始到现在包含的所有月份：{}】", starter, yearMonths);
        yearMonths.stream().forEach(yearMonth -> {
            try {
                log.info(yearMonth);
                int year = DateUtil.getYear(yearMonth, DateUtil.SHORTER_FORMAT);
                int monthOfYear = DateUtil.getMonthOfYear(yearMonth, DateUtil.SHORTER_FORMAT);
                log.info("年份{},月份{}", year, monthOfYear);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        String lastDayOfMonth = DateUtil.getLastDayOfMonth(2020, 2);
        System.out.println("lastDayOfMonth:" + lastDayOfMonth);

        String yesterdayDate = DateUtil.getYesterdayDate();
        log.info("【昨天：】{}", yesterdayDate);
        String todayDate = DateUtil.getTodayDate();
        log.info("【今天：】{}", todayDate);
    }


}
