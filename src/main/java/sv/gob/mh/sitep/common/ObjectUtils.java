package sv.gob.mh.sitep.common;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ObjectUtils {

    public static String getFormattedNumber(Number value, String pattern) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        DecimalFormat formatter = (DecimalFormat) format;
        formatter.applyPattern(pattern);
        return formatter.format(value);
    }

    public static Date getFormattedDate(String strdate) {
        Date c = null;
        if (strdate != null && !strdate.equals("") ) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            try {
                Date date = formatter.parse(strdate);
               c=date;
            } catch (ParseException e) {
                System.out.println("date not parse for string -->" + strdate);
            }
        }
        return c;
    }

    public static BigDecimal getFormattedBigDecimal(String text) {

        try {
            if (text != null && !text.equals("") ) {
                BigDecimal bg;
                MathContext mc = new MathContext(2);
                bg = new BigDecimal(text, mc);
                return bg;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("BigDecimal not parse for string -->" + text);
            return null;
        }
    }

    public static Integer getFormattedInteger(String text) {
                try {
                    if (text != null && !text.equals("")) {
                        
                        return Integer.valueOf(text);
                    } else {
                        return null;
                    }

                } catch (Exception e) {
                    System.out.println("BigDecimal not parse for string -->" + text);
                    return null;
                }
    }

    public static java.sql.Date getFormattedSqlDate(String strdate) {
        java.sql.Date c = null;
        if (strdate != null && !strdate.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
            try {
                java.util.Date date = sdf.parse(strdate);
                c = new java.sql.Date(date.getTime());
            } catch (ParseException e) {
                System.out.println("date not parse for string -->" + strdate);
            }
        }
        return c;
    }

}

