package delfi.com.vn.tpcreative.common.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utils {


    private static Utils instance ;
    private Context context ;


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }


    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    public static void changeColorStatusBar(Activity activity, int color, boolean on) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = activity.getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(color);
    }



    public static String getYearCard(int year) {
        int last = year % 100;
        if (last < 10)
            return String.format("0%d", last);
        else
            return String.valueOf(last);
    }


    public static float scalePixel(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels / 320;
    }

    public static float scaleDensity(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels / displayMetrics.density / 320;
    }

    public static int pxToSp(final Context context, final float px) {
        return Math.round(px / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static int spToPx(final Context context, final float sp) {
        return Math.round(sp * context.getResources().getDisplayMetrics().scaledDensity);
    }


    public static boolean validateEmail(String data) {
        Pattern emailPattern = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}");
        Matcher emailMatcher = emailPattern.matcher(data);
        return emailMatcher.matches();
    }

    public static boolean validateUsername(String data) {

        Pattern emailPattern = Pattern.compile("(?=^.{3,20}$)^[a-zA-Z][a-zA-Z0-9]*[._-]?[a-zA-Z0-9]+$");
        Matcher emailMatcher = emailPattern.matcher(data);
        return emailMatcher.matches();
    }

    public static long getCurrentTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String datetime = dateformat.format(c.getTime());
        return (c.getTimeInMillis() / 1000);
    }


    /* Convert String to Currency */

    public static HashMap hashToCurrency(String s) {
        try {
            HashMap<String, String> hash = new HashMap<>();
            Locale dutch = new Locale("en", "AU");
            NumberFormat numberFormatDutch = NumberFormat.getCurrencyInstance(dutch);
            String c = numberFormatDutch.format(new BigDecimal(s.replace(",","")));
            hash.put("currency", replaceString(c));
//            System.out.println("Currency Format: " + c);
            Number d = numberFormatDutch.parse(c);
            BigDecimal bd = new BigDecimal(d.toString());
            hash.put("number", bd.toString());
            return hash;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public static String stringToDouble(String s) {
        if (!s.isEmpty()) {
            Log.d("action", "Show value : " + s);
            Locale dutch = new Locale("en", "AU");
            NumberFormat numberFormatDutch = NumberFormat.getCurrencyInstance(dutch);
            try {
                Number d = numberFormatDutch.parse(s);
                BigDecimal bd = new BigDecimal(d.toString());
                Log.d("action", bd.toString());
                return bd.toString();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }


    public static String replaceString(String s) {
        try {
            return s.replace("$", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public void convertToCurrency() {
        String s = "100000";
        Locale dutch = new Locale("nl", "NL");
        NumberFormat numberFormatDutch = NumberFormat.getCurrencyInstance(dutch);

        String c = numberFormatDutch.format(new BigDecimal(s.toString()));
        System.out.println("Currency Format: " + c);
        try {
            Number d = numberFormatDutch.parse(c);
            BigDecimal bd = new BigDecimal(d.toString());
            System.out.println(bd);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
