package util.corn;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class CornUtil {

    public static void main(String[] args) throws ParseException, InterruptedException {
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator("0 0 */2 * * ?");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> list = new ArrayList<>(20);
        Date nextTimePoint = new Date();
        for (int i = 0; i < 20; i++) {
            // 计算下次时间点的开始时间
            nextTimePoint = cronSequenceGenerator.next(nextTimePoint);
            list.add(sdf.format(nextTimePoint));
        }
        for (String string : list) {
            System.out.println(string);
        }
    }
}
