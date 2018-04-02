package com.global.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 *
 * @author troy
 * @date 2018/03/31
 */
public class DateUtil {

    private static final int MAGICVALUE_ZERO = 0;
    private static final int MAGICVALUE_ONE = 1;
    private static final int MAGICVALUE_TWO = 2;
    private static final int MAGICVALUE_THREE = 3;
    private static final int MAGICVALUE_FOUR = 4;
    private static final long MAGICVALUE_1000MILLSECONDS = 1000L;
    private static final long MAGICVALUE_60SECONDS = 60L;
    private static final long MAGICVALUE_12HOURS = 12L;
    private static final long MAGICVALUE_ONEDAY = 1L;

    public static final String DATEFORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    public static final String DATEFORMAT_YMD = "yyyy-MM-dd";

    public static final String DATEFORMAT_YM = "yyyy-MM";

    public static final String DATEFORMAT_YMDHM = "yyyy-MM-dd HH:mm";

    public static final String DATEFORMAT_MD = "MM/dd";

    public static final String DATEFORMAT_HMS = "HH:mm:ss";

    public static final String DATEFORMAT_HM = "HH:mm";

    public static final String DATEFORMAT_AM = "AM";

    public static final String DATEFORMAT_PM = "PM";

    public DateUtil() {
    }

    public static Date getDateByFormat(String strDate, String format) {

        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);

        Date date = null;

        try {

            date = mSimpleDateFormat.parse(strDate);

        } catch (ParseException var5) {

            var5.printStackTrace();

        }


        return date;

    }


    public Date getDateByOffset(Date date, int calendarField, int offset) {

        GregorianCalendar c = new GregorianCalendar();


        try {

            c.setTime(date);

            c.add(calendarField, offset);

        } catch (Exception var6) {

            var6.printStackTrace();

        }


        return c.getTime();

    }


    public static String getStringByOffset(String strDate, String format, int calendarField, int offset) throws ParseException {

        String mDateTime = null;

        GregorianCalendar e = new GregorianCalendar();

        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);

        e.setTime(mSimpleDateFormat.parse(strDate));

        e.add(calendarField, offset);

        mDateTime = mSimpleDateFormat.format(e.getTime());

        return mDateTime;

    }


    public static String getStringByOffset(Date date, String format, int calendarField, int offset) {

        String strDate = null;

        GregorianCalendar e = new GregorianCalendar();

        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);

        e.setTime(date);

        e.add(calendarField, offset);

        strDate = mSimpleDateFormat.format(e.getTime());

        return strDate;

    }


    public static String getStringByFormat(Date date, String format) {

        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);

        String strDate = null;


        try {

            strDate = mSimpleDateFormat.format(date);

        } catch (Exception var5) {

            var5.printStackTrace();

        }


        return strDate;

    }


    public static String getStringByFormat(String strDate, String format) {

        String mDateTime = null;


        try {

            GregorianCalendar e = new GregorianCalendar();

            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            e.setTime(mSimpleDateFormat.parse(strDate));

            SimpleDateFormat mSimpleDateFormat2 = new SimpleDateFormat(format);

            mDateTime = mSimpleDateFormat2.format(e.getTime());

        } catch (Exception var6) {

            var6.printStackTrace();

        }


        return mDateTime;

    }


    public static String getStringByFormat(long milliseconds, String format) {

        String thisDateTime = null;


        try {

            SimpleDateFormat e = new SimpleDateFormat(format);

            thisDateTime = e.format(Long.valueOf(milliseconds));

        } catch (Exception var5) {

            var5.printStackTrace();

        }


        return thisDateTime;

    }


    public static String getCurrentDate(String format) {
        String curDateTime = null;
        try {

            SimpleDateFormat e = new SimpleDateFormat(format);

            GregorianCalendar c = new GregorianCalendar();

            curDateTime = e.format(c.getTime());

        } catch (Exception var4) {

            var4.printStackTrace();

        }


        return curDateTime;

    }


    public static String getCurrentDateByOffset(String format, int calendarField, int offset) {

        String mDateTime = null;


        try {

            SimpleDateFormat e = new SimpleDateFormat(format);

            GregorianCalendar c = new GregorianCalendar();

            c.add(calendarField, offset);

            mDateTime = e.format(c.getTime());

        } catch (Exception var6) {

            var6.printStackTrace();

        }


        return mDateTime;

    }


    public static int getOffectDay(long milliseconds1, long milliseconds2) {

        Calendar calendar1 = Calendar.getInstance();

        calendar1.setTimeInMillis(milliseconds1);

        Calendar calendar2 = Calendar.getInstance();

        calendar2.setTimeInMillis(milliseconds2);

        int y1 = calendar1.get(Calendar.YEAR);

        int y2 = calendar2.get(Calendar.YEAR);

        int d1 = calendar1.get(Calendar.DAY_OF_YEAR);

        int d2 = calendar2.get(Calendar.DAY_OF_YEAR);

        boolean maxDays = false;

        boolean day = false;

        int maxDays1;

        int day1;

        if (y1 - y2 > 0) {

            maxDays1 = calendar2.getActualMaximum(Calendar.DAY_OF_YEAR);

            day1 = d1 - d2 + maxDays1;

        } else if (y1 - y2 < 0) {

            maxDays1 = calendar1.getActualMaximum(Calendar.DAY_OF_YEAR);

            day1 = d1 - d2 - maxDays1;

        } else {

            day1 = d1 - d2;

        }


        return day1;

    }


    public static int getOffectHour(long date1, long date2) {

        Calendar calendar1 = Calendar.getInstance();

        calendar1.setTimeInMillis(date1);

        Calendar calendar2 = Calendar.getInstance();

        calendar2.setTimeInMillis(date2);

        int h1 = calendar1.get(Calendar.HOUR_OF_DAY);

        int h2 = calendar2.get(Calendar.HOUR_OF_DAY);

        boolean h = false;

        int day = getOffectDay(date1, date2);

        h1 = h1 - h2 + day * 24;

        return h1;

    }


    public static int getOffectMinutes(long date1, long date2) {

        Calendar calendar1 = Calendar.getInstance();

        calendar1.setTimeInMillis(date1);

        Calendar calendar2 = Calendar.getInstance();

        calendar2.setTimeInMillis(date2);

        int m1 = calendar1.get(Calendar.MINUTE);

        int m2 = calendar2.get(Calendar.MINUTE);

        int h = getOffectHour(date1, date2);

        boolean m = false;

        m1 = m1 - m2 + h * 60;

        return m1;

    }


    public static String getFirstDayOfWeek(String format) {

        return getDayOfWeek(format, 2);

    }


    public static String getLastDayOfWeek(String format) {

        return getDayOfWeek(format, 1);

    }


    private static String getDayOfWeek(String format, int calendarField) {

        String strDate = null;


        try {

            GregorianCalendar e = new GregorianCalendar();

            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);

            int week = e.get(Calendar.DAY_OF_WEEK);

            if (week == calendarField) {

                strDate = mSimpleDateFormat.format(e.getTime());

            } else {

                int offectDay = calendarField - week;

                if (calendarField == 1) {

                    offectDay = 7 - Math.abs(offectDay);

                }


                e.add(Calendar.DAY_OF_MONTH, offectDay);

                strDate = mSimpleDateFormat.format(e.getTime());

            }

        } catch (Exception var7) {

            var7.printStackTrace();

        }


        return strDate;

    }


    public static String getFirstDayOfMonth(String format) {

        String strDate = null;


        try {

            GregorianCalendar e = new GregorianCalendar();

            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);

            e.set(Calendar.DAY_OF_MONTH, 1);

            strDate = mSimpleDateFormat.format(e.getTime());

        } catch (Exception var4) {

            var4.printStackTrace();

        }


        return strDate;

    }


    public static String getLastDayOfMonth(String format) {

        String strDate = null;


        try {

            GregorianCalendar e = new GregorianCalendar();

            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);

            e.set(Calendar.DAY_OF_MONTH, 1);

            e.roll(Calendar.DAY_OF_MONTH, -1);

            strDate = mSimpleDateFormat.format(e.getTime());

        } catch (Exception var4) {

            var4.printStackTrace();

        }


        return strDate;

    }


    public static long getFirstTimeOfDay() {

        Date date = null;


        try {

            String e = getCurrentDate("yyyy-MM-dd");

            date = getDateByFormat(e + " 00:00:00", "yyyy-MM-dd HH:mm:ss");

            return date.getTime();

        } catch (Exception var2) {

            return -1L;

        }

    }


    public static long getLastTimeOfDay() {

        Date date = null;


        try {

            String e = getCurrentDate("yyyy-MM-dd");

            date = getDateByFormat(e + " 24:00:00", "yyyy-MM-dd HH:mm:ss");

            return date.getTime();

        } catch (Exception var2) {

            return -1L;

        }

    }


    public static boolean isLeapYear(int year) {

        return year % 4 == 0 && year % 400 != 0 || year % 400 == 0;

    }


    public static String formatDateStr2Desc(String strDate, String outFormat) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c1 = Calendar.getInstance();

        Calendar c2 = Calendar.getInstance();


        c2.setTime(df.parse(strDate));

        c1.setTime(new Date());

        int e = getOffectDay(c1.getTimeInMillis(), c2.getTimeInMillis());

        if (e == MAGICVALUE_ZERO) {

            int out = getOffectHour(c1.getTimeInMillis(), c2.getTimeInMillis());

            if (out > MAGICVALUE_ZERO) {

                return "今天" + getStringByFormat(strDate, "HH:mm");

            }


            if (out >= MAGICVALUE_ZERO && out == MAGICVALUE_ZERO) {

                int m = getOffectMinutes(c1.getTimeInMillis(), c2.getTimeInMillis());

                if (m > MAGICVALUE_ZERO) {

                    return m + "分钟前";

                }


                if (m >= MAGICVALUE_ZERO) {

                    return "刚刚";

                }

            }

        }


        String out1 = getStringByFormat(strDate, outFormat);

        if (null == out1 || out1.length() == MAGICVALUE_ZERO) {

            return out1;

        }


        return strDate;

    }


    public static String getWeek() {

        Date date = new Date();

        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");

        return dateFm.format(date);

    }


    public static String getWeekNumber(String strDate, String inFormat) {

        String week = "星期日";

        GregorianCalendar calendar = new GregorianCalendar();

        SimpleDateFormat df = new SimpleDateFormat(inFormat);


        try {

            calendar.setTime(df.parse(strDate));

        } catch (Exception var6) {

            return "错误";

        }


        int intTemp = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        switch (intTemp) {

            case 0:

                week = "星期日";

                break;

            case 1:

                week = "星期一";

                break;

            case 2:

                week = "星期二";

                break;

            case 3:

                week = "星期三";

                break;

            case 4:

                week = "星期四";

                break;

            case 5:

                week = "星期五";

                break;

            case 6:

                week = "星期六";
                break;
            default:
                week = "错误";
                break;
        }
        return week;

    }

    public static String getTimeQuantum(String strDate, String format) {
        Date mDate = getDateByFormat(strDate, format);
        int hour = mDate.getHours();
        return hour >= MAGICVALUE_12HOURS ? "PM" : "AM";
    }

    public static String getTimeDescription(long milliseconds) {

        if (milliseconds > MAGICVALUE_1000MILLSECONDS) {

            if (milliseconds / MAGICVALUE_1000MILLSECONDS / MAGICVALUE_60SECONDS > MAGICVALUE_ONEDAY) {

                long minute = milliseconds / MAGICVALUE_1000MILLSECONDS / MAGICVALUE_60SECONDS;

                long second = milliseconds / MAGICVALUE_1000MILLSECONDS % MAGICVALUE_60SECONDS;

                return minute + "分" + second + "秒";

            } else {

                return milliseconds / MAGICVALUE_1000MILLSECONDS + "秒";

            }

        } else {

            return milliseconds + "毫秒";

        }

    }
}
