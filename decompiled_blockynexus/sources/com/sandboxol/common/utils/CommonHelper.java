package com.sandboxol.common.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.app.ActivityCompat;
import androidx.core.content.b;
import com.google.gson.j;
import com.sandboxol.common.R;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.config.CommonEventConstant;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.config.CommonSharedConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.tendcloud.tenddata.ab;
import com.umeng.analytics.pro.ci;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class CommonHelper {

    /* JADX INFO: loaded from: classes3.dex */
    public interface SaveCallback {
        void onSucceed(String str);
    }

    public static String SHA1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            Log.e("SHA1 error, str:{}", str, e2);
            return "";
        }
    }

    public static boolean checkApkExist(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (str != null && !"".equals(str)) {
            try {
                applicationContext.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException | Exception unused) {
            }
        }
        return false;
    }

    public static int checkProcessIsRunning(Context context, String str) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo.pid;
                }
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int countString(String str) {
        String strReplaceAll = str.replaceAll(" ", "");
        int i = 0;
        int i2 = 0;
        while (i < strReplaceAll.length()) {
            int i3 = i + 1;
            i2 = strReplaceAll.substring(i, i3).matches("[一-龥]") ? i2 + 2 : i2 + 1;
            i = i3;
        }
        return i2;
    }

    public static String createUUId(Context context) {
        String string;
        if (SharedUtils.getString(context, CommonSharedConstant.APP_VISITOR_UUID) == null) {
            string = UUID.randomUUID().toString();
            SharedUtils.putString(context, CommonSharedConstant.APP_VISITOR_UUID, string);
            ReportDataAdapter.onEvent(context, CommonEventConstant.ANDROID_ID_RENEW, string);
        } else {
            string = SharedUtils.getString(context, CommonSharedConstant.APP_VISITOR_UUID);
        }
        try {
            File file = new File(getSDCardPath(context) + "/uuId.txt");
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(string.getBytes());
            fileOutputStream.close();
            Messenger.getDefault().send("uuId", CommonMessageToken.TOKEN_ANDROID_DEVICE_ID_TYPE);
        } catch (Exception e2) {
            e2.printStackTrace();
            Messenger.getDefault().send("uuId_cache", CommonMessageToken.TOKEN_ANDROID_DEVICE_ID_TYPE);
        }
        return string;
    }

    public static boolean deleteDir(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static <T> T formatObject(String str, Class<T> cls) {
        return (T) new j().a(str, (Class) cls);
    }

    public static Activity getActivityByView(View view) {
        if (view == null) {
            return null;
        }
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && (context instanceof Activity)) {
            return (Activity) context;
        }
        return null;
    }

    public static String getAndroidId(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        if (string == null || "".equals(string)) {
            return getUUId(context);
        }
        String string2 = SharedUtils.getString(context, CommonSharedConstant.ANDROID_ID);
        if (string2 == null || string.equals(string2)) {
            SharedUtils.putString(context, CommonSharedConstant.ANDROID_ID, string);
        } else {
            ReportDataAdapter.onEvent(context, CommonEventConstant.ANDROID_ID_DIFFERENT, string + "," + string2);
        }
        Messenger.getDefault().send("android_id", CommonMessageToken.TOKEN_ANDROID_DEVICE_ID_TYPE);
        return string;
    }

    public static String getApkOrSoDownloadPath(Context context) {
        return context.getApplicationContext().getDir("download", 0).getPath();
    }

    public static String getCountByK(int i) {
        float f2 = i;
        int i2 = 0;
        while (f2 >= 1000.0f) {
            i2++;
            f2 /= 1000.0f;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        if (i2 == 0) {
            return decimalFormat.format(f2);
        }
        if (i2 == 1) {
            return decimalFormat.format(f2) + "K";
        }
        if (i2 != 2) {
            return decimalFormat.format(f2) + "B";
        }
        return decimalFormat.format(f2) + "M";
    }

    public static String getCountry() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? BaseApplication.getContext().getResources().getConfiguration().getLocales().get(0) : BaseApplication.getContext().getResources().getConfiguration().locale;
        return (locale == null || TextUtils.isEmpty(locale.getCountry())) ? "US" : locale.getCountry();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String getCountryDetail(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte b2 = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != 2091) {
            if (iHashCode != 2092) {
                if (iHashCode != 2099) {
                    if (iHashCode != 2100) {
                        if (iHashCode != 2128) {
                            if (iHashCode != 2129) {
                                if (iHashCode != 2135) {
                                    if (iHashCode != 2136) {
                                        if (iHashCode != 2159) {
                                            if (iHashCode != 2160) {
                                                switch (iHashCode) {
                                                    case 2083:
                                                        if (str.equals("AD")) {
                                                            b2 = 0;
                                                        }
                                                        break;
                                                    case 2084:
                                                        if (str.equals("AE")) {
                                                            b2 = 1;
                                                        }
                                                        break;
                                                    case 2085:
                                                        if (str.equals("AF")) {
                                                            b2 = 2;
                                                        }
                                                        break;
                                                    case 2086:
                                                        if (str.equals("AG")) {
                                                            b2 = 3;
                                                        }
                                                        break;
                                                    default:
                                                        switch (iHashCode) {
                                                            case 2088:
                                                                if (str.equals("AI")) {
                                                                    b2 = 4;
                                                                }
                                                                break;
                                                            case 2094:
                                                                if (str.equals("AO")) {
                                                                    b2 = 7;
                                                                }
                                                                break;
                                                            case 2097:
                                                                if (str.equals("AR")) {
                                                                    b2 = 8;
                                                                }
                                                                break;
                                                            case 2105:
                                                                if (str.equals("AZ")) {
                                                                    b2 = 11;
                                                                }
                                                                break;
                                                            case 2112:
                                                                if (str.equals("BB")) {
                                                                    b2 = 12;
                                                                }
                                                                break;
                                                            case 2114:
                                                                if (str.equals("BD")) {
                                                                    b2 = ci.k;
                                                                }
                                                                break;
                                                            case 2115:
                                                                if (str.equals("BE")) {
                                                                    b2 = ci.l;
                                                                }
                                                                break;
                                                            case 2116:
                                                                if (str.equals("BF")) {
                                                                    b2 = ci.m;
                                                                }
                                                                break;
                                                            case 2117:
                                                                if (str.equals("BG")) {
                                                                    b2 = ci.n;
                                                                }
                                                                break;
                                                            case 2118:
                                                                if (str.equals("BH")) {
                                                                    b2 = 17;
                                                                }
                                                                break;
                                                            case 2119:
                                                                if (str.equals("BI")) {
                                                                    b2 = 18;
                                                                }
                                                                break;
                                                            case 2120:
                                                                if (str.equals("BJ")) {
                                                                    b2 = 19;
                                                                }
                                                                break;
                                                            case 2133:
                                                                if (str.equals("BW")) {
                                                                    b2 = 26;
                                                                }
                                                                break;
                                                            case 2142:
                                                                if (str.equals("CA")) {
                                                                    b2 = 29;
                                                                }
                                                                break;
                                                            case 2162:
                                                                if (str.equals("CU")) {
                                                                    b2 = 40;
                                                                }
                                                                break;
                                                            case 2166:
                                                                if (str.equals("CY")) {
                                                                    b2 = 41;
                                                                }
                                                                break;
                                                            case 2167:
                                                                if (str.equals("CZ")) {
                                                                    b2 = 42;
                                                                }
                                                                break;
                                                            case 2177:
                                                                if (str.equals("DE")) {
                                                                    b2 = 43;
                                                                }
                                                                break;
                                                            case 2182:
                                                                if (str.equals("DJ")) {
                                                                    b2 = 44;
                                                                }
                                                                break;
                                                            case 2183:
                                                                if (str.equals("DK")) {
                                                                    b2 = 45;
                                                                }
                                                                break;
                                                            case 2187:
                                                                if (str.equals("DO")) {
                                                                    b2 = 46;
                                                                }
                                                                break;
                                                            case 2198:
                                                                if (str.equals("DZ")) {
                                                                    b2 = 47;
                                                                }
                                                                break;
                                                            case 2206:
                                                                if (str.equals("EC")) {
                                                                    b2 = 48;
                                                                }
                                                                break;
                                                            case 2208:
                                                                if (str.equals("EE")) {
                                                                    b2 = 49;
                                                                }
                                                                break;
                                                            case 2210:
                                                                if (str.equals("EG")) {
                                                                    b2 = 50;
                                                                }
                                                                break;
                                                            case 2222:
                                                                if (str.equals("ES")) {
                                                                    b2 = 51;
                                                                }
                                                                break;
                                                            case 2223:
                                                                if (str.equals("ET")) {
                                                                    b2 = 52;
                                                                }
                                                                break;
                                                            case 2243:
                                                                if (str.equals("FI")) {
                                                                    b2 = 53;
                                                                }
                                                                break;
                                                            case 2244:
                                                                if (str.equals("FJ")) {
                                                                    b2 = 54;
                                                                }
                                                                break;
                                                            case 2252:
                                                                if (str.equals("FR")) {
                                                                    b2 = 55;
                                                                }
                                                                break;
                                                            case 2266:
                                                                if (str.equals("GA")) {
                                                                    b2 = 56;
                                                                }
                                                                break;
                                                            case 2267:
                                                                if (str.equals("GB")) {
                                                                    b2 = 57;
                                                                }
                                                                break;
                                                            case 2269:
                                                                if (str.equals("GD")) {
                                                                    b2 = 58;
                                                                }
                                                                break;
                                                            case 2270:
                                                                if (str.equals("GE")) {
                                                                    b2 = 59;
                                                                }
                                                                break;
                                                            case 2271:
                                                                if (str.equals("GF")) {
                                                                    b2 = 60;
                                                                }
                                                                break;
                                                            case 2273:
                                                                if (str.equals("GH")) {
                                                                    b2 = 61;
                                                                }
                                                                break;
                                                            case 2274:
                                                                if (str.equals("GI")) {
                                                                    b2 = 62;
                                                                }
                                                                break;
                                                            case 2278:
                                                                if (str.equals("GM")) {
                                                                    b2 = Utf8.REPLACEMENT_BYTE;
                                                                }
                                                                break;
                                                            case 2279:
                                                                if (str.equals("GN")) {
                                                                    b2 = 64;
                                                                }
                                                                break;
                                                            case 2283:
                                                                if (str.equals("GR")) {
                                                                    b2 = 65;
                                                                }
                                                                break;
                                                            case 2285:
                                                                if (str.equals("GT")) {
                                                                    b2 = 66;
                                                                }
                                                                break;
                                                            case 2286:
                                                                if (str.equals("GU")) {
                                                                    b2 = 67;
                                                                }
                                                                break;
                                                            case 2290:
                                                                if (str.equals("GY")) {
                                                                    b2 = 68;
                                                                }
                                                                break;
                                                            case 2307:
                                                                if (str.equals("HK")) {
                                                                    b2 = 69;
                                                                }
                                                                break;
                                                            case 2310:
                                                                if (str.equals("HN")) {
                                                                    b2 = 70;
                                                                }
                                                                break;
                                                            case 2316:
                                                                if (str.equals("HT")) {
                                                                    b2 = 71;
                                                                }
                                                                break;
                                                            case 2317:
                                                                if (str.equals("HU")) {
                                                                    b2 = 72;
                                                                }
                                                                break;
                                                            case 2331:
                                                                if (str.equals("ID")) {
                                                                    b2 = 73;
                                                                }
                                                                break;
                                                            case 2332:
                                                                if (str.equals("IE")) {
                                                                    b2 = 74;
                                                                }
                                                                break;
                                                            case 2339:
                                                                if (str.equals("IL")) {
                                                                    b2 = 75;
                                                                }
                                                                break;
                                                            case 2341:
                                                                if (str.equals("IN")) {
                                                                    b2 = 76;
                                                                }
                                                                break;
                                                            case 2344:
                                                                if (str.equals("IQ")) {
                                                                    b2 = 77;
                                                                }
                                                                break;
                                                            case 2345:
                                                                if (str.equals("IR")) {
                                                                    b2 = 78;
                                                                }
                                                                break;
                                                            case 2346:
                                                                if (str.equals("IS")) {
                                                                    b2 = 79;
                                                                }
                                                                break;
                                                            case 2347:
                                                                if (str.equals("IT")) {
                                                                    b2 = 80;
                                                                }
                                                                break;
                                                            case 2371:
                                                                if (str.equals("JM")) {
                                                                    b2 = 81;
                                                                }
                                                                break;
                                                            case 2373:
                                                                if (str.equals("JO")) {
                                                                    b2 = 82;
                                                                }
                                                                break;
                                                            case 2374:
                                                                if (str.equals("JP")) {
                                                                    b2 = 83;
                                                                }
                                                                break;
                                                            case 2394:
                                                                if (str.equals("KE")) {
                                                                    b2 = 84;
                                                                }
                                                                break;
                                                            case 2396:
                                                                if (str.equals("KG")) {
                                                                    b2 = 85;
                                                                }
                                                                break;
                                                            case 2397:
                                                                if (str.equals("KH")) {
                                                                    b2 = 86;
                                                                }
                                                                break;
                                                            case 2405:
                                                                if (str.equals("KP")) {
                                                                    b2 = 87;
                                                                }
                                                                break;
                                                            case 2407:
                                                                if (str.equals("KR")) {
                                                                    b2 = 88;
                                                                }
                                                                break;
                                                            case 2409:
                                                                if (str.equals("KT")) {
                                                                    b2 = 89;
                                                                }
                                                                break;
                                                            case 2412:
                                                                if (str.equals("KW")) {
                                                                    b2 = 90;
                                                                }
                                                                break;
                                                            case 2415:
                                                                if (str.equals("KZ")) {
                                                                    b2 = 91;
                                                                }
                                                                break;
                                                            case 2421:
                                                                if (str.equals("LA")) {
                                                                    b2 = 92;
                                                                }
                                                                break;
                                                            case 2422:
                                                                if (str.equals("LB")) {
                                                                    b2 = 93;
                                                                }
                                                                break;
                                                            case 2423:
                                                                if (str.equals("LC")) {
                                                                    b2 = 94;
                                                                }
                                                                break;
                                                            case 2429:
                                                                if (str.equals("LI")) {
                                                                    b2 = 95;
                                                                }
                                                                break;
                                                            case 2431:
                                                                if (str.equals("LK")) {
                                                                    b2 = 96;
                                                                }
                                                                break;
                                                            case 2438:
                                                                if (str.equals("LR")) {
                                                                    b2 = 97;
                                                                }
                                                                break;
                                                            case 2439:
                                                                if (str.equals("LS")) {
                                                                    b2 = 98;
                                                                }
                                                                break;
                                                            case 2440:
                                                                if (str.equals("LT")) {
                                                                    b2 = 99;
                                                                }
                                                                break;
                                                            case 2441:
                                                                if (str.equals("LU")) {
                                                                    b2 = 100;
                                                                }
                                                                break;
                                                            case 2442:
                                                                if (str.equals("LV")) {
                                                                    b2 = 101;
                                                                }
                                                                break;
                                                            case 2445:
                                                                if (str.equals("LY")) {
                                                                    b2 = 102;
                                                                }
                                                                break;
                                                            case 2452:
                                                                if (str.equals("MA")) {
                                                                    b2 = 103;
                                                                }
                                                                break;
                                                            case 2454:
                                                                if (str.equals("MC")) {
                                                                    b2 = 104;
                                                                }
                                                                break;
                                                            case 2455:
                                                                if (str.equals("MD")) {
                                                                    b2 = 105;
                                                                }
                                                                break;
                                                            case 2458:
                                                                if (str.equals("MG")) {
                                                                    b2 = 106;
                                                                }
                                                                break;
                                                            case 2463:
                                                                if (str.equals("ML")) {
                                                                    b2 = 107;
                                                                }
                                                                break;
                                                            case 2464:
                                                                if (str.equals("MM")) {
                                                                    b2 = 108;
                                                                }
                                                                break;
                                                            case 2465:
                                                                if (str.equals("MN")) {
                                                                    b2 = 109;
                                                                }
                                                                break;
                                                            case 2466:
                                                                if (str.equals("MO")) {
                                                                    b2 = 110;
                                                                }
                                                                break;
                                                            case 2470:
                                                                if (str.equals("MS")) {
                                                                    b2 = 111;
                                                                }
                                                                break;
                                                            case 2471:
                                                                if (str.equals("MT")) {
                                                                    b2 = 112;
                                                                }
                                                                break;
                                                            case 2472:
                                                                if (str.equals("MU")) {
                                                                    b2 = 113;
                                                                }
                                                                break;
                                                            case 2473:
                                                                if (str.equals("MV")) {
                                                                    b2 = 114;
                                                                }
                                                                break;
                                                            case 2474:
                                                                if (str.equals("MW")) {
                                                                    b2 = 115;
                                                                }
                                                                break;
                                                            case 2475:
                                                                if (str.equals("MX")) {
                                                                    b2 = 116;
                                                                }
                                                                break;
                                                            case 2476:
                                                                if (str.equals("MY")) {
                                                                    b2 = 117;
                                                                }
                                                                break;
                                                            case 2477:
                                                                if (str.equals("MZ")) {
                                                                    b2 = 118;
                                                                }
                                                                break;
                                                            case 2483:
                                                                if (str.equals("NA")) {
                                                                    b2 = 119;
                                                                }
                                                                break;
                                                            case 2487:
                                                                if (str.equals("NE")) {
                                                                    b2 = 120;
                                                                }
                                                                break;
                                                            case 2489:
                                                                if (str.equals("NG")) {
                                                                    b2 = 121;
                                                                }
                                                                break;
                                                            case 2491:
                                                                if (str.equals("NI")) {
                                                                    b2 = 122;
                                                                }
                                                                break;
                                                            case 2494:
                                                                if (str.equals("NL")) {
                                                                    b2 = 123;
                                                                }
                                                                break;
                                                            case 2497:
                                                                if (str.equals("NO")) {
                                                                    b2 = 124;
                                                                }
                                                                break;
                                                            case 2498:
                                                                if (str.equals("NP")) {
                                                                    b2 = 125;
                                                                }
                                                                break;
                                                            case 2500:
                                                                if (str.equals("NR")) {
                                                                    b2 = 126;
                                                                }
                                                                break;
                                                            case 2508:
                                                                if (str.equals("NZ")) {
                                                                    b2 = 127;
                                                                }
                                                                break;
                                                            case 2526:
                                                                if (str.equals("OM")) {
                                                                    b2 = 128;
                                                                }
                                                                break;
                                                            case 2545:
                                                                if (str.equals("PA")) {
                                                                    b2 = 129;
                                                                }
                                                                break;
                                                            case 2549:
                                                                if (str.equals("PE")) {
                                                                    b2 = 130;
                                                                }
                                                                break;
                                                            case 2550:
                                                                if (str.equals("PF")) {
                                                                    b2 = 131;
                                                                }
                                                                break;
                                                            case 2551:
                                                                if (str.equals("PG")) {
                                                                    b2 = 132;
                                                                }
                                                                break;
                                                            case 2552:
                                                                if (str.equals("PH")) {
                                                                    b2 = 133;
                                                                }
                                                                break;
                                                            case 2555:
                                                                if (str.equals("PK")) {
                                                                    b2 = 134;
                                                                }
                                                                break;
                                                            case 2556:
                                                                if (str.equals("PL")) {
                                                                    b2 = 135;
                                                                }
                                                                break;
                                                            case 2562:
                                                                if (str.equals("PR")) {
                                                                    b2 = 136;
                                                                }
                                                                break;
                                                            case 2564:
                                                                if (str.equals("PT")) {
                                                                    b2 = 137;
                                                                }
                                                                break;
                                                            case 2569:
                                                                if (str.equals("PY")) {
                                                                    b2 = 138;
                                                                }
                                                                break;
                                                            case 2576:
                                                                if (str.equals("QA")) {
                                                                    b2 = 139;
                                                                }
                                                                break;
                                                            case 2621:
                                                                if (str.equals("RO")) {
                                                                    b2 = 140;
                                                                }
                                                                break;
                                                            case 2627:
                                                                if (str.equals("RU")) {
                                                                    b2 = 141;
                                                                }
                                                                break;
                                                            case 2638:
                                                                if (str.equals("SA")) {
                                                                    b2 = 142;
                                                                }
                                                                break;
                                                            case 2639:
                                                                if (str.equals("SB")) {
                                                                    b2 = 143;
                                                                }
                                                                break;
                                                            case 2640:
                                                                if (str.equals("SC")) {
                                                                    b2 = 144;
                                                                }
                                                                break;
                                                            case 2641:
                                                                if (str.equals("SD")) {
                                                                    b2 = 145;
                                                                }
                                                                break;
                                                            case 2642:
                                                                if (str.equals("SE")) {
                                                                    b2 = 146;
                                                                }
                                                                break;
                                                            case 2644:
                                                                if (str.equals("SG")) {
                                                                    b2 = 147;
                                                                }
                                                                break;
                                                            case 2646:
                                                                if (str.equals("SI")) {
                                                                    b2 = 148;
                                                                }
                                                                break;
                                                            case 2648:
                                                                if (str.equals("SK")) {
                                                                    b2 = 149;
                                                                }
                                                                break;
                                                            case 2649:
                                                                if (str.equals("SL")) {
                                                                    b2 = 150;
                                                                }
                                                                break;
                                                            case 2650:
                                                                if (str.equals("SM")) {
                                                                    b2 = 151;
                                                                }
                                                                break;
                                                            case 2651:
                                                                if (str.equals("SN")) {
                                                                    b2 = 152;
                                                                }
                                                                break;
                                                            case 2652:
                                                                if (str.equals("SO")) {
                                                                    b2 = 153;
                                                                }
                                                                break;
                                                            case 2655:
                                                                if (str.equals("SR")) {
                                                                    b2 = 154;
                                                                }
                                                                break;
                                                            case 2657:
                                                                if (str.equals("ST")) {
                                                                    b2 = 155;
                                                                }
                                                                break;
                                                            case 2659:
                                                                if (str.equals("SV")) {
                                                                    b2 = 156;
                                                                }
                                                                break;
                                                            case 2662:
                                                                if (str.equals("SY")) {
                                                                    b2 = 157;
                                                                }
                                                                break;
                                                            case 2663:
                                                                if (str.equals("SZ")) {
                                                                    b2 = 158;
                                                                }
                                                                break;
                                                            case 2672:
                                                                if (str.equals(ab.t)) {
                                                                    b2 = 159;
                                                                }
                                                                break;
                                                            case 2675:
                                                                if (str.equals("TG")) {
                                                                    b2 = 160;
                                                                }
                                                                break;
                                                            case 2676:
                                                                if (str.equals("TH")) {
                                                                    b2 = 161;
                                                                }
                                                                break;
                                                            case 2678:
                                                                if (str.equals("TJ")) {
                                                                    b2 = 162;
                                                                }
                                                                break;
                                                            case 2681:
                                                                if (str.equals("TM")) {
                                                                    b2 = 163;
                                                                }
                                                                break;
                                                            case 2682:
                                                                if (str.equals("TN")) {
                                                                    b2 = 164;
                                                                }
                                                                break;
                                                            case 2683:
                                                                if (str.equals("TO")) {
                                                                    b2 = 165;
                                                                }
                                                                break;
                                                            case 2686:
                                                                if (str.equals("TR")) {
                                                                    b2 = 166;
                                                                }
                                                                break;
                                                            case 2688:
                                                                if (str.equals("TT")) {
                                                                    b2 = 167;
                                                                }
                                                                break;
                                                            case 2691:
                                                                if (str.equals("TW")) {
                                                                    b2 = 168;
                                                                }
                                                                break;
                                                            case 2694:
                                                                if (str.equals("TZ")) {
                                                                    b2 = 169;
                                                                }
                                                                break;
                                                            case 2700:
                                                                if (str.equals("UA")) {
                                                                    b2 = 170;
                                                                }
                                                                break;
                                                            case 2706:
                                                                if (str.equals("UG")) {
                                                                    b2 = 171;
                                                                }
                                                                break;
                                                            case 2718:
                                                                if (str.equals("US")) {
                                                                    b2 = 172;
                                                                }
                                                                break;
                                                            case 2724:
                                                                if (str.equals("UY")) {
                                                                    b2 = 173;
                                                                }
                                                                break;
                                                            case 2725:
                                                                if (str.equals("UZ")) {
                                                                    b2 = 174;
                                                                }
                                                                break;
                                                            case 2733:
                                                                if (str.equals("VC")) {
                                                                    b2 = 175;
                                                                }
                                                                break;
                                                            case 2735:
                                                                if (str.equals("VE")) {
                                                                    b2 = 176;
                                                                }
                                                                break;
                                                            case 2744:
                                                                if (str.equals("VN")) {
                                                                    b2 = 177;
                                                                }
                                                                break;
                                                            case 2828:
                                                                if (str.equals("YE")) {
                                                                    b2 = 178;
                                                                }
                                                                break;
                                                            case 2844:
                                                                if (str.equals("YU")) {
                                                                    b2 = 179;
                                                                }
                                                                break;
                                                            case 2855:
                                                                if (str.equals("ZA")) {
                                                                    b2 = 180;
                                                                }
                                                                break;
                                                            case 2867:
                                                                if (str.equals("ZM")) {
                                                                    b2 = 181;
                                                                }
                                                                break;
                                                            case 2872:
                                                                if (str.equals("ZR")) {
                                                                    b2 = 182;
                                                                }
                                                                break;
                                                            case 2877:
                                                                if (str.equals("ZW")) {
                                                                    b2 = 183;
                                                                }
                                                                break;
                                                            default:
                                                                switch (iHashCode) {
                                                                    case 2122:
                                                                        if (str.equals("BL")) {
                                                                            b2 = 20;
                                                                        }
                                                                        break;
                                                                    case 2123:
                                                                        if (str.equals("BM")) {
                                                                            b2 = 21;
                                                                        }
                                                                        break;
                                                                    case 2124:
                                                                        if (str.equals("BN")) {
                                                                            b2 = 22;
                                                                        }
                                                                        break;
                                                                    case 2125:
                                                                        if (str.equals("BO")) {
                                                                            b2 = 23;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        switch (iHashCode) {
                                                                            case 2147:
                                                                                if (str.equals("CF")) {
                                                                                    b2 = 30;
                                                                                }
                                                                                break;
                                                                            case 2148:
                                                                                if (str.equals("CG")) {
                                                                                    b2 = 31;
                                                                                }
                                                                                break;
                                                                            case 2149:
                                                                                if (str.equals("CH")) {
                                                                                    b2 = 32;
                                                                                }
                                                                                break;
                                                                            default:
                                                                                switch (iHashCode) {
                                                                                    case 2152:
                                                                                        if (str.equals("CK")) {
                                                                                            b2 = 33;
                                                                                        }
                                                                                        break;
                                                                                    case 2153:
                                                                                        if (str.equals("CL")) {
                                                                                            b2 = 34;
                                                                                        }
                                                                                        break;
                                                                                    case 2154:
                                                                                        if (str.equals("CM")) {
                                                                                            b2 = 35;
                                                                                        }
                                                                                        break;
                                                                                    case 2155:
                                                                                        if (str.equals("CN")) {
                                                                                            b2 = 36;
                                                                                        }
                                                                                        break;
                                                                                    case 2156:
                                                                                        if (str.equals("CO")) {
                                                                                            b2 = 37;
                                                                                        }
                                                                                        break;
                                                                                }
                                                                                break;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                            } else if (str.equals("CS")) {
                                                b2 = 39;
                                            }
                                        } else if (str.equals("CR")) {
                                            b2 = 38;
                                        }
                                    } else if (str.equals("BZ")) {
                                        b2 = 28;
                                    }
                                } else if (str.equals("BY")) {
                                    b2 = 27;
                                }
                            } else if (str.equals("BS")) {
                                b2 = 25;
                            }
                        } else if (str.equals("BR")) {
                            b2 = 24;
                        }
                    } else if (str.equals("AU")) {
                        b2 = 10;
                    }
                } else if (str.equals("AT")) {
                    b2 = 9;
                }
            } else if (str.equals("AM")) {
                b2 = 6;
            }
        } else if (str.equals("AL")) {
            b2 = 5;
        }
        switch (b2) {
            case 0:
                return BaseApplication.getContext().getString(R.string.country_andorra);
            case 1:
                return BaseApplication.getContext().getString(R.string.country_united_arab_emirates);
            case 2:
                return BaseApplication.getContext().getString(R.string.country_afghanistan);
            case 3:
                return BaseApplication.getContext().getString(R.string.country_antigua_and_barbuda);
            case 4:
                return BaseApplication.getContext().getString(R.string.country_anguilla);
            case 5:
                return BaseApplication.getContext().getString(R.string.country_albania);
            case 6:
                return BaseApplication.getContext().getString(R.string.country_armenia);
            case 7:
                return BaseApplication.getContext().getString(R.string.country_angola);
            case 8:
                return BaseApplication.getContext().getString(R.string.country_argentina);
            case 9:
                return BaseApplication.getContext().getString(R.string.country_austria);
            case 10:
                return BaseApplication.getContext().getString(R.string.country_australia);
            case 11:
                return BaseApplication.getContext().getString(R.string.country_azerbaijan);
            case 12:
                return BaseApplication.getContext().getString(R.string.country_barbados);
            case 13:
                return BaseApplication.getContext().getString(R.string.country_bangladesh);
            case 14:
                return BaseApplication.getContext().getString(R.string.country_belgium);
            case 15:
                return BaseApplication.getContext().getString(R.string.country_burkina_faso);
            case 16:
                return BaseApplication.getContext().getString(R.string.country_bulgaria);
            case 17:
                return BaseApplication.getContext().getString(R.string.country_bahrain);
            case 18:
                return BaseApplication.getContext().getString(R.string.country_burundi);
            case 19:
                return BaseApplication.getContext().getString(R.string.country_benin);
            case 20:
                return BaseApplication.getContext().getString(R.string.country_palestine);
            case 21:
                return BaseApplication.getContext().getString(R.string.country_bermuda_is);
            case 22:
                return BaseApplication.getContext().getString(R.string.country_brunei);
            case 23:
                return BaseApplication.getContext().getString(R.string.country_bolivia);
            case 24:
                return BaseApplication.getContext().getString(R.string.country_brazil);
            case 25:
                return BaseApplication.getContext().getString(R.string.country_bahamas);
            case 26:
                return BaseApplication.getContext().getString(R.string.country_botswana);
            case 27:
                return BaseApplication.getContext().getString(R.string.country_belarus);
            case 28:
                return BaseApplication.getContext().getString(R.string.country_belize);
            case 29:
                return BaseApplication.getContext().getString(R.string.country_canada);
            case 30:
                return BaseApplication.getContext().getString(R.string.country_central_african_republic);
            case 31:
                return BaseApplication.getContext().getString(R.string.country_congo);
            case 32:
                return BaseApplication.getContext().getString(R.string.country_switzerland);
            case 33:
                return BaseApplication.getContext().getString(R.string.country_cook_is);
            case 34:
                return BaseApplication.getContext().getString(R.string.country_chile);
            case 35:
                return BaseApplication.getContext().getString(R.string.country_cameroon);
            case 36:
                return BaseApplication.getContext().getString(R.string.country_china);
            case 37:
                return BaseApplication.getContext().getString(R.string.country_colombia);
            case 38:
                return BaseApplication.getContext().getString(R.string.country_costa_rica);
            case 39:
                return BaseApplication.getContext().getString(R.string.country_czech);
            case 40:
                return BaseApplication.getContext().getString(R.string.country_cuba);
            case 41:
                return BaseApplication.getContext().getString(R.string.country_cyprus);
            case 42:
                return BaseApplication.getContext().getString(R.string.country_czech_republic);
            case 43:
                return BaseApplication.getContext().getString(R.string.country_germany);
            case 44:
                return BaseApplication.getContext().getString(R.string.country_djibouti);
            case 45:
                return BaseApplication.getContext().getString(R.string.country_denmark);
            case 46:
                return BaseApplication.getContext().getString(R.string.country_dominica_rep);
            case 47:
                return BaseApplication.getContext().getString(R.string.country_algeria);
            case 48:
                return BaseApplication.getContext().getString(R.string.country_ecuador);
            case 49:
                return BaseApplication.getContext().getString(R.string.country_estonia);
            case 50:
                return BaseApplication.getContext().getString(R.string.country_egypt);
            case 51:
                return BaseApplication.getContext().getString(R.string.country_spain);
            case 52:
                return BaseApplication.getContext().getString(R.string.country_ethiopia);
            case 53:
                return BaseApplication.getContext().getString(R.string.country_finland);
            case 54:
                return BaseApplication.getContext().getString(R.string.country_fiji);
            case 55:
                return BaseApplication.getContext().getString(R.string.country_france);
            case 56:
                return BaseApplication.getContext().getString(R.string.country_gabon);
            case 57:
                return BaseApplication.getContext().getString(R.string.country_united_kiongdom);
            case 58:
                return BaseApplication.getContext().getString(R.string.country_grenada);
            case 59:
                return BaseApplication.getContext().getString(R.string.country_georgia);
            case 60:
                return BaseApplication.getContext().getString(R.string.country_french_guiana);
            case 61:
                return BaseApplication.getContext().getString(R.string.country_ghana);
            case 62:
                return BaseApplication.getContext().getString(R.string.country_gibraltar);
            case 63:
                return BaseApplication.getContext().getString(R.string.country_gambia);
            case 64:
                return BaseApplication.getContext().getString(R.string.country_guinea);
            case 65:
                return BaseApplication.getContext().getString(R.string.country_greece);
            case 66:
                return BaseApplication.getContext().getString(R.string.country_guatemala);
            case 67:
                return BaseApplication.getContext().getString(R.string.country_guam);
            case 68:
                return BaseApplication.getContext().getString(R.string.country_guyana);
            case 69:
                return BaseApplication.getContext().getString(R.string.country_hongkong);
            case 70:
                return BaseApplication.getContext().getString(R.string.country_honduras);
            case 71:
                return BaseApplication.getContext().getString(R.string.country_haiti);
            case 72:
                return BaseApplication.getContext().getString(R.string.country_hungary);
            case 73:
                return BaseApplication.getContext().getString(R.string.country_indonesia);
            case 74:
                return BaseApplication.getContext().getString(R.string.country_ireland);
            case 75:
                return BaseApplication.getContext().getString(R.string.country_israel);
            case 76:
                return BaseApplication.getContext().getString(R.string.country_india);
            case 77:
                return BaseApplication.getContext().getString(R.string.country_iraq);
            case 78:
                return BaseApplication.getContext().getString(R.string.country_iran);
            case 79:
                return BaseApplication.getContext().getString(R.string.country_iceland);
            case 80:
                return BaseApplication.getContext().getString(R.string.country_italy);
            case 81:
                return BaseApplication.getContext().getString(R.string.country_jamaica);
            case 82:
                return BaseApplication.getContext().getString(R.string.country_jordan);
            case 83:
                return BaseApplication.getContext().getString(R.string.country_japan);
            case 84:
                return BaseApplication.getContext().getString(R.string.country_kenya);
            case 85:
                return BaseApplication.getContext().getString(R.string.country_kyrgyzstan);
            case 86:
                return BaseApplication.getContext().getString(R.string.country_kampuchea_cambodia);
            case 87:
                return BaseApplication.getContext().getString(R.string.country_north_korea);
            case 88:
                return BaseApplication.getContext().getString(R.string.country_korea);
            case 89:
                return BaseApplication.getContext().getString(R.string.country_republic_of_ivory_coast);
            case 90:
                return BaseApplication.getContext().getString(R.string.country_kuwait);
            case 91:
                return BaseApplication.getContext().getString(R.string.country_kazakstan);
            case 92:
                return BaseApplication.getContext().getString(R.string.country_laos);
            case 93:
                return BaseApplication.getContext().getString(R.string.country_lebanon);
            case 94:
                return BaseApplication.getContext().getString(R.string.country_stlucia);
            case 95:
                return BaseApplication.getContext().getString(R.string.country_liechtenstein);
            case 96:
                return BaseApplication.getContext().getString(R.string.country_sri_lanka);
            case 97:
                return BaseApplication.getContext().getString(R.string.country_liberia);
            case 98:
                return BaseApplication.getContext().getString(R.string.country_lesotho);
            case 99:
                return BaseApplication.getContext().getString(R.string.country_lithuania);
            case 100:
                return BaseApplication.getContext().getString(R.string.country_luxembourg);
            case 101:
                return BaseApplication.getContext().getString(R.string.country_latvia);
            case 102:
                return BaseApplication.getContext().getString(R.string.country_libya);
            case 103:
                return BaseApplication.getContext().getString(R.string.country_morocco);
            case 104:
                return BaseApplication.getContext().getString(R.string.country_monaco);
            case 105:
                return BaseApplication.getContext().getString(R.string.country_moldova_republic_of);
            case 106:
                return BaseApplication.getContext().getString(R.string.country_madagascar);
            case 107:
                return BaseApplication.getContext().getString(R.string.country_mali);
            case 108:
                return BaseApplication.getContext().getString(R.string.country_burma);
            case 109:
                return BaseApplication.getContext().getString(R.string.country_mongolia);
            case 110:
                return BaseApplication.getContext().getString(R.string.country_macao);
            case 111:
                return BaseApplication.getContext().getString(R.string.country_montserrat_is);
            case 112:
                return BaseApplication.getContext().getString(R.string.country_malta);
            case 113:
                return BaseApplication.getContext().getString(R.string.country_mauritius);
            case 114:
                return BaseApplication.getContext().getString(R.string.country_maldives);
            case 115:
                return BaseApplication.getContext().getString(R.string.country_malawi);
            case 116:
                return BaseApplication.getContext().getString(R.string.country_mexico);
            case 117:
                return BaseApplication.getContext().getString(R.string.country_malaysia);
            case 118:
                return BaseApplication.getContext().getString(R.string.country_mozambique);
            case 119:
                return BaseApplication.getContext().getString(R.string.country_namibia);
            case 120:
                return BaseApplication.getContext().getString(R.string.country_niger);
            case 121:
                return BaseApplication.getContext().getString(R.string.country_nigeria);
            case 122:
                return BaseApplication.getContext().getString(R.string.country_nicaragua);
            case 123:
                return BaseApplication.getContext().getString(R.string.country_netherlands);
            case 124:
                return BaseApplication.getContext().getString(R.string.country_norway);
            case 125:
                return BaseApplication.getContext().getString(R.string.country_nepal);
            case 126:
                return BaseApplication.getContext().getString(R.string.country_nauru);
            case 127:
                return BaseApplication.getContext().getString(R.string.country_new_zealand);
            case 128:
                return BaseApplication.getContext().getString(R.string.country_oman);
            case 129:
                return BaseApplication.getContext().getString(R.string.country_panama);
            case 130:
                return BaseApplication.getContext().getString(R.string.country_peru);
            case 131:
                return BaseApplication.getContext().getString(R.string.country_french_polynesia);
            case 132:
                return BaseApplication.getContext().getString(R.string.country_papua_new_cuinea);
            case 133:
                return BaseApplication.getContext().getString(R.string.country_philippines);
            case 134:
                return BaseApplication.getContext().getString(R.string.country_pakistan);
            case 135:
                return BaseApplication.getContext().getString(R.string.country_poland);
            case 136:
                return BaseApplication.getContext().getString(R.string.country_puerto_rico);
            case 137:
                return BaseApplication.getContext().getString(R.string.country_portugal);
            case 138:
                return BaseApplication.getContext().getString(R.string.country_paraguay);
            case 139:
                return BaseApplication.getContext().getString(R.string.country_qatar);
            case 140:
                return BaseApplication.getContext().getString(R.string.country_romania);
            case 141:
                return BaseApplication.getContext().getString(R.string.country_russia);
            case 142:
                return BaseApplication.getContext().getString(R.string.country_saudi_arabia);
            case 143:
                return BaseApplication.getContext().getString(R.string.country_solomon_is);
            case 144:
                return BaseApplication.getContext().getString(R.string.country_seychelles);
            case 145:
                return BaseApplication.getContext().getString(R.string.country_sudan);
            case 146:
                return BaseApplication.getContext().getString(R.string.country_sweden);
            case 147:
                return BaseApplication.getContext().getString(R.string.country_singapore);
            case 148:
                return BaseApplication.getContext().getString(R.string.country_slovenia);
            case 149:
                return BaseApplication.getContext().getString(R.string.country_slovakia);
            case 150:
                return BaseApplication.getContext().getString(R.string.country_sierra_leone);
            case 151:
                return BaseApplication.getContext().getString(R.string.country_san_marino);
            case 152:
                return BaseApplication.getContext().getString(R.string.country_senegal);
            case 153:
                return BaseApplication.getContext().getString(R.string.country_somali);
            case 154:
                return BaseApplication.getContext().getString(R.string.country_suriname);
            case 155:
                return BaseApplication.getContext().getString(R.string.country_sao_tome_and_principe);
            case 156:
                return BaseApplication.getContext().getString(R.string.country_ei_salvador);
            case 157:
                return BaseApplication.getContext().getString(R.string.country_syria);
            case 158:
                return BaseApplication.getContext().getString(R.string.country_swaziland);
            case 159:
                return BaseApplication.getContext().getString(R.string.country_chad);
            case 160:
                return BaseApplication.getContext().getString(R.string.country_togo);
            case 161:
                return BaseApplication.getContext().getString(R.string.country_thailand);
            case 162:
                return BaseApplication.getContext().getString(R.string.country_tajikstan);
            case 163:
                return BaseApplication.getContext().getString(R.string.country_turkmenistan);
            case 164:
                return BaseApplication.getContext().getString(R.string.country_tunisia);
            case 165:
                return BaseApplication.getContext().getString(R.string.country_tonga);
            case 166:
                return BaseApplication.getContext().getString(R.string.country_turkey);
            case 167:
                return BaseApplication.getContext().getString(R.string.country_trinidad_and_tobago);
            case 168:
                return BaseApplication.getContext().getString(R.string.country_taiwan);
            case 169:
                return BaseApplication.getContext().getString(R.string.country_tanzania);
            case 170:
                return BaseApplication.getContext().getString(R.string.country_ukraine);
            case 171:
                return BaseApplication.getContext().getString(R.string.country_uganda);
            case 172:
                return BaseApplication.getContext().getString(R.string.country_united_states_of_america);
            case 173:
                return BaseApplication.getContext().getString(R.string.country_uruguay);
            case 174:
                return BaseApplication.getContext().getString(R.string.country_uzbekistan);
            case 175:
                return BaseApplication.getContext().getString(R.string.country_saint_vincent);
            case 176:
                return BaseApplication.getContext().getString(R.string.country_venezuela);
            case 177:
                return BaseApplication.getContext().getString(R.string.country_vietnam);
            case 178:
                return BaseApplication.getContext().getString(R.string.country_yemen);
            case 179:
                return BaseApplication.getContext().getString(R.string.country_yugoslavia);
            case 180:
                return BaseApplication.getContext().getString(R.string.country_south_africa);
            case 181:
                return BaseApplication.getContext().getString(R.string.country_zambia);
            case 182:
                return BaseApplication.getContext().getString(R.string.country_zaire);
            case 183:
                return BaseApplication.getContext().getString(R.string.country_zimbabwe);
            default:
                return str;
        }
    }

    public static String getDeviceId(Context context) {
        String string = UUID.randomUUID().toString();
        return string == null ? Settings.System.getString(context.getContentResolver(), "android_id") : string;
    }

    public static String getDiskCacheDir(Context context) {
        return "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath();
    }

    public static String getGameLanguage() {
        String language = getLanguage();
        return language.equals("uk_UA") ? "ru_RU" : language;
    }

    public static String getLanguage() {
        try {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? BaseApplication.getContext().getResources().getConfiguration().getLocales().get(0) : BaseApplication.getContext().getResources().getConfiguration().locale;
            if (locale != null && !TextUtils.isEmpty(locale.getLanguage()) && !TextUtils.isEmpty(locale.getCountry())) {
                return String.format("%s_%s", locale.getLanguage(), locale.getCountry());
            }
            return "en_US";
        } catch (Exception unused) {
            return "en_US";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String getLanguageDetail(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte b2 = -1;
        switch (str.hashCode()) {
            case 3121:
                if (str.equals("ar")) {
                    b2 = 7;
                }
                break;
            case 3166:
                if (str.equals("ca")) {
                    b2 = 8;
                }
                break;
            case 3184:
                if (str.equals("cs")) {
                    b2 = 10;
                }
                break;
            case 3190:
                if (str.equals("cy")) {
                    b2 = 11;
                }
                break;
            case 3197:
                if (str.equals("da")) {
                    b2 = 12;
                }
                break;
            case 3201:
                if (str.equals("de")) {
                    b2 = 2;
                }
                break;
            case 3239:
                if (str.equals("el")) {
                    b2 = ci.k;
                }
                break;
            case 3241:
                if (str.equals("en")) {
                    b2 = 0;
                }
                break;
            case 3242:
                if (str.equals("eo")) {
                    b2 = ci.l;
                }
                break;
            case 3246:
                if (str.equals("es")) {
                    b2 = ci.m;
                }
                break;
            case 3248:
                if (str.equals("eu")) {
                    b2 = ci.n;
                }
                break;
            case 3259:
                if (str.equals("fa")) {
                    b2 = 17;
                }
                break;
            case 3267:
                if (str.equals("fi")) {
                    b2 = 18;
                }
                break;
            case 3276:
                if (str.equals("fr")) {
                    b2 = 1;
                }
                break;
            case 3325:
                if (str.equals("he")) {
                    b2 = 19;
                }
                break;
            case 3338:
                if (str.equals("hr")) {
                    b2 = 20;
                }
                break;
            case 3341:
                if (str.equals("hu")) {
                    b2 = 21;
                }
                break;
            case 3365:
                if (str.equals("in")) {
                    b2 = 41;
                }
                break;
            case 3371:
                if (str.equals("it")) {
                    b2 = 3;
                }
                break;
            case 3383:
                if (str.equals("ja")) {
                    b2 = 4;
                }
                break;
            case 3428:
                if (str.equals("ko")) {
                    b2 = 5;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    b2 = 22;
                }
                break;
            case 3486:
                if (str.equals("mk")) {
                    b2 = 23;
                }
                break;
            case 3487:
                if (str.equals("ml")) {
                    b2 = 24;
                }
                break;
            case 3494:
                if (str.equals("ms")) {
                    b2 = 25;
                }
                break;
            case 3518:
                if (str.equals("nl")) {
                    b2 = 26;
                }
                break;
            case 3521:
                if (str.equals("no")) {
                    b2 = 27;
                }
                break;
            case 3580:
                if (str.equals("pl")) {
                    b2 = 28;
                }
                break;
            case 3588:
                if (str.equals("pt")) {
                    b2 = 29;
                }
                break;
            case 3645:
                if (str.equals("ro")) {
                    b2 = 30;
                }
                break;
            case 3651:
                if (str.equals("ru")) {
                    b2 = 31;
                }
                break;
            case 3673:
                if (str.equals("sl")) {
                    b2 = 32;
                }
                break;
            case 3683:
                if (str.equals("sv")) {
                    b2 = 33;
                }
                break;
            case 3693:
                if (str.equals("ta")) {
                    b2 = 34;
                }
                break;
            case 3700:
                if (str.equals("th")) {
                    b2 = 35;
                }
                break;
            case 3704:
                if (str.equals("tl")) {
                    b2 = 36;
                }
                break;
            case 3710:
                if (str.equals("tr")) {
                    b2 = 37;
                }
                break;
            case 3734:
                if (str.equals("uk")) {
                    b2 = 38;
                }
                break;
            case 3763:
                if (str.equals("vi")) {
                    b2 = 39;
                }
                break;
            case 3879:
                if (str.equals("za")) {
                    b2 = 40;
                }
                break;
            case 3886:
                if (str.equals("zh")) {
                    b2 = 6;
                }
                break;
            case 98350:
                if (str.equals("cdo")) {
                    b2 = 9;
                }
                break;
        }
        switch (b2) {
            case 0:
                return BaseApplication.getContext().getString(R.string.english);
            case 1:
                return BaseApplication.getContext().getString(R.string.french);
            case 2:
                return BaseApplication.getContext().getString(R.string.german);
            case 3:
                return BaseApplication.getContext().getString(R.string.italian);
            case 4:
                return BaseApplication.getContext().getString(R.string.japanese);
            case 5:
                return BaseApplication.getContext().getString(R.string.korean);
            case 6:
                return BaseApplication.getContext().getString(R.string.chinese);
            case 7:
                return BaseApplication.getContext().getString(R.string.arabic);
            case 8:
                return BaseApplication.getContext().getString(R.string.catalan);
            case 9:
                return BaseApplication.getContext().getString(R.string.min_dong);
            case 10:
                return BaseApplication.getContext().getString(R.string.czech);
            case 11:
                return BaseApplication.getContext().getString(R.string.cyprus);
            case 12:
                return BaseApplication.getContext().getString(R.string.danish);
            case 13:
                return BaseApplication.getContext().getString(R.string.greek);
            case 14:
                return BaseApplication.getContext().getString(R.string.esperanto);
            case 15:
                return BaseApplication.getContext().getString(R.string.spanish);
            case 16:
                return BaseApplication.getContext().getString(R.string.basque);
            case 17:
                return BaseApplication.getContext().getString(R.string.farsi);
            case 18:
                return BaseApplication.getContext().getString(R.string.finnish);
            case 19:
                return BaseApplication.getContext().getString(R.string.hebrew);
            case 20:
                return BaseApplication.getContext().getString(R.string.croatian);
            case 21:
                return BaseApplication.getContext().getString(R.string.hungarian);
            case 22:
                return BaseApplication.getContext().getString(R.string.lithuanian);
            case 23:
                return BaseApplication.getContext().getString(R.string.macedonian);
            case 24:
                return BaseApplication.getContext().getString(R.string.aramaic);
            case 25:
                return BaseApplication.getContext().getString(R.string.malaysia);
            case 26:
                return BaseApplication.getContext().getString(R.string.dutch);
            case 27:
                return BaseApplication.getContext().getString(R.string.norwegian);
            case 28:
                return BaseApplication.getContext().getString(R.string.polish);
            case 29:
                return BaseApplication.getContext().getString(R.string.portugal);
            case 30:
                return BaseApplication.getContext().getString(R.string.romanian);
            case 31:
                return BaseApplication.getContext().getString(R.string.russian);
            case 32:
                return BaseApplication.getContext().getString(R.string.slovenian);
            case 33:
                return BaseApplication.getContext().getString(R.string.swedish);
            case 34:
                return BaseApplication.getContext().getString(R.string.tamil);
            case 35:
                return BaseApplication.getContext().getString(R.string.thai);
            case 36:
                return BaseApplication.getContext().getString(R.string.tagalog);
            case 37:
                return BaseApplication.getContext().getString(R.string.turkish);
            case 38:
                return BaseApplication.getContext().getString(R.string.ukrainian);
            case 39:
                return BaseApplication.getContext().getString(R.string.vietnamese);
            case 40:
                return BaseApplication.getContext().getString(R.string.zhuang);
            case 41:
                return BaseApplication.getContext().getString(R.string.hindi);
            default:
                return str;
        }
    }

    public static long getLessMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static String getLimitString(String str, int i) {
        String strReplaceAll = str.replaceAll(" ", "");
        if (countString(strReplaceAll) <= i) {
            return strReplaceAll;
        }
        return strReplaceAll.substring(0, i) + TextEllipsizeUtil.SignLib.END_POINT;
    }

    public static int getResourcesById(Context context, String str, String str2, String str3) {
        return context.getResources().getIdentifier(str + str2, str3, context.getPackageName());
    }

    private static String getSDCardPath(Context context) {
        File dir;
        if (Environment.getExternalStorageState().equals("mounted")) {
            dir = new File(Environment.getExternalStorageDirectory(), BaseApplication.getApp().getMetaDataRootPath() + "/BlockMan");
        } else {
            dir = context.getDir("BlockMan", 0);
        }
        return dir.getPath();
    }

    public static String getSignature(Context context) {
        return SHA1(getAndroidId(context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0046 -> B:35:0x005c). Please report as a decompilation issue!!! */
    public static String getUUId(Context context) throws Throwable {
        BufferedReader bufferedReader;
        String line;
        File file = new File(getSDCardPath(context) + "/uuId.txt");
        if (!file.exists()) {
            return createUUId(context);
        }
        ?? r0 = 0;
        BufferedReader bufferedReader2 = null;
        String string = SharedUtils.getString(context, CommonSharedConstant.APP_VISITOR_UUID);
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    string = string;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            r0 = e3;
            string = string;
        }
        while (true) {
            try {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                string = line;
            } catch (IOException e4) {
                e = e4;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                r0 = bufferedReader2;
                string = string;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                    r0 = bufferedReader2;
                    string = string;
                }
            } catch (Throwable th2) {
                th = th2;
                r0 = bufferedReader;
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return string;
        }
        bufferedReader.close();
        bufferedReader.close();
        r0 = line;
        string = string;
        return string;
    }

    public static String getUserLanguage() {
        try {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? BaseApplication.getContext().getResources().getConfiguration().getLocales().get(0) : BaseApplication.getContext().getResources().getConfiguration().locale;
            if (locale != null && !TextUtils.isEmpty(locale.getLanguage())) {
                return locale.getLanguage();
            }
            return "en";
        } catch (Exception unused) {
            return "en";
        }
    }

    public static String getUtcTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("gmt"));
        return simpleDateFormat.format(new Date());
    }

    public static Bitmap getViewBitmap(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static boolean hasWriteExternalStorage(Context context) {
        return b.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static void hideSoftInputFromWindow(Context context) {
        Activity activity = (Activity) context;
        if (activity.getCurrentFocus() == null || activity.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static String inputStream2String(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(i);
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        List<PackageInfo> installedPackages;
        if (str != null && !str.isEmpty() && (installedPackages = context.getPackageManager().getInstalledPackages(0)) != null && !installedPackages.isEmpty()) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (str.equals(installedPackages.get(i).packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isAvilible(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                arrayList.add(installedPackages.get(i).packageName);
            }
        }
        return arrayList.contains(str);
    }

    public static boolean isEmail(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?").matcher(str).matches();
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean isTablet(Context context) {
        try {
            return (context.getApplicationContext().getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void renameFile(String str, String str2, String str3) {
        if (str2.equals(str3)) {
            System.out.println("新文件名和旧文件名相同...");
            return;
        }
        File file = new File(str + "/" + str2);
        File file2 = new File(str + "/" + str3);
        if (file.exists()) {
            if (!file2.exists()) {
                file.renameTo(file2);
                return;
            }
            System.out.println(str3 + "已经存在！");
        }
    }

    public static void requestWriteStorage(Activity activity) {
        if (b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    public static void saveBitmap(Context context, Bitmap bitmap, String str, SaveCallback saveCallback) {
        if (!Environment.getExternalStorageState().equals("mounted") || bitmap.isRecycled()) {
            Log.d("xxx", "saveBitmap: 1return");
            return;
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "DCIM/" + str + ".png");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (saveCallback != null) {
                saveCallback.onSucceed(file.getPath());
            }
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            Log.d("xxx", "saveBitmap: " + file.getAbsolutePath());
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("xxx", "saveBitmap: 2return");
        }
    }

    public static void screenPic(Context context, String str, View view) {
        Bitmap viewBitmap = getViewBitmap(view);
        if (viewBitmap != null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                MediaStore.Images.Media.insertImage(context.getContentResolver(), viewBitmap, str, context.getResources().getString(R.string.app_name));
            } else {
                ToastUtils.showShortToast(context, R.string.no_sdcard);
            }
        }
    }

    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(editText, 2);
    }

    public static String stringFilter2(String str) throws PatternSyntaxException {
        return Pattern.compile("[^0-9一-龥]").matcher(str).replaceAll("").trim();
    }
}
