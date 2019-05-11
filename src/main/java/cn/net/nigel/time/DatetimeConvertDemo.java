package cn.net.nigel.time;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.TimeZone;

public class DatetimeConvertDemo {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSX");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        long timeStamp = 1515730332000L;
        Date date = new Date(timeStamp);
//        2018-01-12T12:12:12.000000+08
        System.out.println(sdf1.format(date));
//        2018-01-12T12:12:12.000000
        System.out.println(sdf2.format(date));
//        2018-01-01T12:12:12.999750909
        System.out.println(LocalDateTime.parse("2018-01-01T12:12:12.999750909"));
//        System.out.println(LocalDateTime.parse("2018-07-19T02:41:06.990395202Z"));
//        1970-01-01T02:46:40Z
        System.out.println(Instant.ofEpochSecond(10000));
//        999000000
        System.out.println(Instant.parse("2018-01-01T12:12:12.999Z").getNano());
//        1514808732
        System.out.println(Instant.parse("2018-01-01T12:12:12.999Z").getEpochSecond());
//                +1000000000-12-31T23:59:59.999999999Z
        System.out.println(Instant.MAX);
//        1970-01-01T00:16:40.001Z
        System.out.println(Instant.ofEpochSecond(1000, 1000000));
//        1970-01-01T00:16:40.001Z
        System.out.println(Instant.ofEpochSecond(1000, 1000_000));
//                +485463324-10-03T15:05:52Z
        System.out.println(Instant.ofEpochSecond(15319680669903952L));
//        1970-06-27T07:28:00.669903952Z
        System.out.println(Instant.ofEpochSecond(0, 15319680669903952L));
//        2018-07-19T02:41:06.990395202Z
        System.out.println(Instant.ofEpochSecond(0, 1531968066990395202L));
//        2018-01-12T04:12:12.003952
        System.out.println(LocalDateTime.ofEpochSecond(1515730332, 3952000, ZoneOffset.UTC));
//        22:12:24.999999999
        System.out.println(LocalTime.now().withNano(999999999));
//        669903952
        System.out.println(Duration.ofNanos(15319680669903952L).getNano());
        LocalDateTime localDateTime = LocalDateTime.now();
//        2019-05-11T22:12:24.003952
        System.out.println(localDateTime.withNano(3952000));
//        1557583944064
        System.out.println(Instant.now().toEpochMilli());
//        64000000
        System.out.println(Instant.now().getNano());
//                +51325-02-22T22:14:33.333Z
        System.out.println(Instant.ofEpochMilli(1557497974473333L));
//        9223372036854775807
        System.out.println(Long.MAX_VALUE);
//        2019-05-11T22:12:24.064
        System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
//        2018-01-12T12:12:12
        System.out.println(date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
//        Z
        System.out.println(ZoneOffset.UTC);
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        df1.setTimeZone(TimeZone.getTimeZone("UTC"));
//        Sat Aug 23 17:20:05 CST 2014
        System.out.println(df1.parse("2014-08-23T09:20:05Z").toString());
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
//        Sat Aug 23 09:20:05 CST 2014
        System.out.println(df2.parse("2014-08-23T09:20:05+08:00").toString());
    }
}
