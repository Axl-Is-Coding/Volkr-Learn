package io.rong.imlib.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceUtils {

    private static class Worker extends Thread {
        BufferedReader input;
        String line;
        Process process;
        String propName;
        Runtime runtime;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process process;
            try {
                try {
                    this.process = this.runtime.exec("getprop " + this.propName);
                    this.input = new BufferedReader(new InputStreamReader(this.process.getInputStream()), 1024);
                    this.line = this.input.readLine();
                    this.input.close();
                    BufferedReader bufferedReader = this.input;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    process = this.process;
                    if (process == null) {
                        return;
                    }
                } catch (IOException unused) {
                    Log.e("DeviceUtils", "Unable to read sysprop ");
                    BufferedReader bufferedReader2 = this.input;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    process = this.process;
                    if (process == null) {
                        return;
                    }
                }
                process.destroy();
            } finally {
            }
        }

        private Worker(Runtime runtime) {
            this.propName = "ro.miui.ui.version.name";
            this.input = null;
            this.runtime = runtime;
        }
    }

    @Deprecated
    public static String ShortMD5(String... strArr) {
        return ShortMD5(0, strArr);
    }

    public static String getDeviceBandModelVersion() {
        return Build.BRAND + "|" + Build.MODEL + "|" + Build.VERSION.RELEASE;
    }

    public static String getDeviceIMEI(Context context) {
        return getDeviceId(context);
    }

    public static synchronized String getDeviceId(Context context, String str) {
        String string;
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "Statistics", 0);
        string = sharedPreferences.getString("deviceId", "");
        if (TextUtils.isEmpty(string)) {
            string = ShortMD5(0, getDeviceId(context), str, context.getPackageName());
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("deviceId", string);
            editorEdit.commit();
        }
        return string;
    }

    public static String getDeviceManufacturer() {
        String str;
        String strReplace = Build.MANUFACTURER.replace("-", "_");
        if (!TextUtils.isEmpty(strReplace)) {
            return "vivo".equals(strReplace) ? strReplace.toUpperCase() : strReplace;
        }
        Worker worker = new Worker(Runtime.getRuntime());
        long jCurrentTimeMillis = System.currentTimeMillis();
        worker.start();
        try {
            worker.join(3000L);
            str = worker.line;
        } catch (InterruptedException unused) {
            worker.interrupt();
            str = "";
        } finally {
            worker.interrupt();
        }
        if (System.currentTimeMillis() - jCurrentTimeMillis >= 3000) {
            Log.e("DeviceUtils", "getDeviceManufacturer====OutTime");
        }
        return !TextUtils.isEmpty(str) ? "Xiaomi" : "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getNetworkType(Context context) {
        if (context == null) {
            return "null";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
            return "none";
        }
        try {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return "none";
            }
            String subtypeName = activeNetworkInfo.getSubtypeName();
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                        if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return subtypeName;
                        }
                    }
                    return "3G";
            }
        } catch (Exception e2) {
            Log.e("DeviceUtils", e2.getMessage());
            return "none";
        }
    }

    public static String getPhoneInformation(Context context) {
        String networkOperator;
        try {
            networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (SecurityException unused) {
            Log.e("DeviceUtils", "SecurityException!!!");
            networkOperator = "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused2) {
                Log.e("DeviceUtils", "getPhoneInformation securityException!!!");
            }
        }
        String typeName = activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "";
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str == null) {
            str = "";
        }
        String str3 = str2 != null ? str2 : "";
        String strReplace = ((((((((((str + "|") + str3) + "|") + String.valueOf(Build.VERSION.SDK_INT)) + "|") + typeName) + "|") + networkOperator) + "|") + context.getPackageName()).replace("-", "_");
        Log.i("DeviceUtils", "getPhoneInformation.the phone information is: " + strReplace);
        return strReplace;
    }

    public static boolean isEMUI() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI");
    }

    public static String ShortMD5(int i, String... strArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(sb.toString().getBytes());
            return new String(Base64.encode(messageDigest.digest(), i)).replace("=", "").replace("+", "-").replace("/", "_").replace(UMCustomLogInfoBuilder.LINE_SEP, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getDeviceId(Context context) {
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "Statistics", 0);
        String string = sharedPreferences.getString("ANDROID_ID", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string2)) {
            string2 = new BigInteger(64, new SecureRandom()).toString(16);
        }
        String str = string2;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("ANDROID_ID", str);
        editorEdit.commit();
        return str;
    }
}
