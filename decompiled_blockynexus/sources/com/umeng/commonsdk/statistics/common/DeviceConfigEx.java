package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.map.geolocation.TencentLocationListener;
import com.umeng.commonsdk.config.FieldManagerEx;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.idtracking.n;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceConfigEx {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    protected static final String LOG_TAG = DeviceConfig.class.getName();
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static String getAndroidId(Context context) throws Throwable {
        if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.t) && context != null) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception unused) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w("can't read android id");
                }
            }
        }
        return null;
    }

    public static String getAppHashKey(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures;
            if (signatureArr.length <= 0) {
                return null;
            }
            Signature signature = signatureArr[0];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(signature.toByteArray());
            return Base64.encodeToString(messageDigest.digest(), 0).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return byte2HexFormatted(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppName(Context context) throws Throwable {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i(LOG_TAG, th);
            return null;
        }
    }

    public static String getAppSHA1Key(Context context) {
        try {
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String getApplicationLable(Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    private static Properties getBuildProp() throws Throwable {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Throwable th) {
            th = th;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Throwable unused3) {
                }
            }
            throw th;
        }
        return properties;
    }

    public static String getCPU() throws Throwable {
        if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.f21331b)) {
            return "";
        }
        String line = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                line = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                MLog.e(DeviceConfig.LOG_TAG, "Could not read from file /proc/cpuinfo", th);
            }
        } catch (FileNotFoundException e2) {
            MLog.e(DeviceConfig.LOG_TAG, "Could not open file /proc/cpuinfo", e2);
        }
        return line != null ? line.substring(line.indexOf(58) + 1).trim() : "";
    }

    public static String getDBencryptID(Context context) {
        String deviceId = null;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                deviceId = telephonyManager.getDeviceId();
            }
            if (!TextUtils.isEmpty(deviceId)) {
                return deviceId;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string) || Build.VERSION.SDK_INT < 9) {
                return string;
            }
            if (Build.VERSION.SDK_INT < 26) {
                return Build.SERIAL;
            }
            Class<?> cls = Class.forName("android.os.Build");
            return (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDeviceId(Context context) {
        return AnalyticsConstants.getDeviceType() == 2 ? getDeviceIdForBox(context) : getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdForBox(Context context) {
        String string = "";
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.i)) {
                    string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + string);
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                String macBySystemInterface = getMacBySystemInterface(context);
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface);
                }
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                String serialNo = getSerialNo();
                return TextUtils.isEmpty(serialNo) ? getIMEI(context) : serialNo;
            }
            if (Build.VERSION.SDK_INT == 23) {
                if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.i)) {
                    string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + string);
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                String macByJavaAPI = getMacByJavaAPI();
                if (TextUtils.isEmpty(macByJavaAPI)) {
                    macByJavaAPI = AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context);
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                String serialNo2 = getSerialNo();
                return TextUtils.isEmpty(serialNo2) ? getIMEI(context) : serialNo2;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                String oaid = getOaid(context);
                Log.e("test_oaid", "+++++++" + oaid);
                if (!TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                String idfa = getIdfa(context);
                if (!TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                String androidId = getAndroidId(context);
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                String serialNo3 = getSerialNo();
                if (!TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                String macByJavaAPI2 = getMacByJavaAPI();
                return TextUtils.isEmpty(macByJavaAPI2) ? getMacBySystemInterface(context) : macByJavaAPI2;
            }
            if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.i)) {
                string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId: ANDROID_ID: " + string);
                }
            }
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String serialNo4 = getSerialNo();
            if (!TextUtils.isEmpty(serialNo4)) {
                return serialNo4;
            }
            String imei = getIMEI(context);
            if (!TextUtils.isEmpty(imei)) {
                return imei;
            }
            String macByJavaAPI3 = getMacByJavaAPI();
            if (!TextUtils.isEmpty(macByJavaAPI3)) {
                return macByJavaAPI3;
            }
            String macBySystemInterface2 = getMacBySystemInterface(context);
            if (!AnalyticsConstants.UM_DEBUG) {
                return macBySystemInterface2;
            }
            MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface2);
            return macBySystemInterface2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceIdForGeneral(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                String imei = getIMEI(context);
                if (!TextUtils.isEmpty(imei)) {
                    return imei;
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "No IMEI.");
                }
                String macBySystemInterface = getMacBySystemInterface(context);
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.i)) {
                    macBySystemInterface = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + macBySystemInterface);
                    }
                }
                return TextUtils.isEmpty(macBySystemInterface) ? getSerialNo() : macBySystemInterface;
            }
            if (Build.VERSION.SDK_INT == 23) {
                String imei2 = getIMEI(context);
                if (!TextUtils.isEmpty(imei2)) {
                    return imei2;
                }
                String macByJavaAPI = getMacByJavaAPI();
                if (TextUtils.isEmpty(macByJavaAPI)) {
                    macByJavaAPI = AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context);
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.i)) {
                    macByJavaAPI = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + macByJavaAPI);
                    }
                }
                return TextUtils.isEmpty(macByJavaAPI) ? getSerialNo() : macByJavaAPI;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                String oaid = getOaid(context);
                if (!TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                String idfa = getIdfa(context);
                if (!TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                String androidId = getAndroidId(context);
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                String serialNo = getSerialNo();
                if (!TextUtils.isEmpty(serialNo)) {
                    return serialNo;
                }
                String macByJavaAPI2 = getMacByJavaAPI();
                return TextUtils.isEmpty(macByJavaAPI2) ? getMacBySystemInterface(context) : macByJavaAPI2;
            }
            String imei3 = getIMEI(context);
            if (!TextUtils.isEmpty(imei3)) {
                return imei3;
            }
            String serialNo2 = getSerialNo();
            if (!TextUtils.isEmpty(serialNo2)) {
                return serialNo2;
            }
            if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.i)) {
                serialNo2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + serialNo2);
                }
            }
            if (!TextUtils.isEmpty(serialNo2)) {
                return serialNo2;
            }
            String macByJavaAPI3 = getMacByJavaAPI();
            if (!TextUtils.isEmpty(macByJavaAPI3)) {
                return macByJavaAPI3;
            }
            String macBySystemInterface2 = getMacBySystemInterface(context);
            if (!AnalyticsConstants.UM_DEBUG) {
                return macBySystemInterface2;
            }
            MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface2);
            return macBySystemInterface2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getDeviceType(Context context) {
        if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.f21335f) || context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Throwable unused) {
            return "Phone";
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) throws Throwable {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(DeviceConfig.LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    private static String getIMEI(Context context) throws Throwable {
        TelephonyManager telephonyManager;
        String str = "";
        if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.g) || context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return "";
        }
        try {
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            String deviceId = telephonyManager.getDeviceId();
            try {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, IMEI: " + deviceId);
                }
                return deviceId;
            } catch (Throwable th) {
                th = th;
                str = deviceId;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return str;
        }
        MLog.w(LOG_TAG, "No IMEI.", th);
        return str;
    }

    public static String getIPAddress(Context context) {
        String hostAddress;
        String hostAddress2 = null;
        try {
            hostAddress = null;
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                try {
                    for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address) && !networkInterface.getDisplayName().contains("dummy") && hostAddress2 == null) {
                            hostAddress2 = inetAddress.getHostAddress();
                        }
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address) && !networkInterface.getDisplayName().contains("dummy") && hostAddress == null) {
                            hostAddress = inetAddress.getHostAddress();
                        }
                    }
                } catch (SocketException unused) {
                    hostAddress2 = "SocketException";
                }
            }
        } catch (SocketException unused2) {
            hostAddress = null;
        }
        return hostAddress2 != null ? hostAddress2 : hostAddress == null ? "null" : hostAddress;
    }

    private static String getIdfa(Context context) {
        try {
            return FieldManagerEx.allow(com.umeng.commonsdk.utils.b.w) ? a.a(context) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getImei(Context context) throws Throwable {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || !DeviceConfig.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            return telephonyManager.getDeviceId();
        } catch (Exception e2) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.w("No IMEI.", e2);
            return null;
        }
    }

    public static String getImeiNew(Context context) throws Throwable {
        TelephonyManager telephonyManager;
        String deviceId = null;
        try {
            if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.s) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && DeviceConfig.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                        method.setAccessible(true);
                        deviceId = (String) method.invoke(telephonyManager, new Object[0]);
                    } catch (Exception unused) {
                    }
                    if (TextUtils.isEmpty(deviceId)) {
                        deviceId = telephonyManager.getDeviceId();
                    }
                } else {
                    deviceId = telephonyManager.getDeviceId();
                }
            }
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.w("No IMEI.", e2);
            }
        }
        return deviceId;
    }

    public static String getImsi(Context context) {
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) {
                return null;
            }
            return telephonyManager.getSubscriberId();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Locale getLocale(Context context) throws Throwable {
        Locale locale;
        if (context == null) {
            return Locale.getDefault();
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable unused) {
            MLog.e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String[] getLocaleInfo(Context context) throws Throwable {
        String[] strArr = {AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN};
        if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.p) || context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            return strArr;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    public static String getMCCMNC(Context context) {
        try {
            if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.f21332c) || context == null || getImsi(context) == null) {
                return null;
            }
            int i = context.getResources().getConfiguration().mcc;
            int i2 = context.getResources().getConfiguration().mnc;
            if (i != 0) {
                String strValueOf = String.valueOf(i2);
                if (i2 < 10) {
                    strValueOf = String.format("%02d", Integer.valueOf(i2));
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(String.valueOf(i));
                stringBuffer.append(strValueOf);
                return stringBuffer.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getMac(Context context) {
        if ((!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.n) && !FieldManagerEx.allow(com.umeng.commonsdk.utils.b.x)) || context == null) {
            return "";
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            return getMacBySystemInterface(context);
        }
        if (i == 23) {
            String macByJavaAPI = getMacByJavaAPI();
            return TextUtils.isEmpty(macByJavaAPI) ? AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context) : macByJavaAPI;
        }
        String macByJavaAPI2 = getMacByJavaAPI();
        return TextUtils.isEmpty(macByJavaAPI2) ? getMacBySystemInterface(context) : macByJavaAPI2;
    }

    private static String getMacByJavaAPI() {
        try {
            if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.h)) {
                return null;
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterfaceNextElement.getName()) || "eth0".equals(networkInterfaceNextElement.getName())) {
                    byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b2)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase(Locale.getDefault());
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getMacBySystemInterface(Context context) throws Throwable {
        if (context == null) {
            return "";
        }
        try {
            if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.h)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(TencentLocationListener.WIFI);
                if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    return wifiManager != null ? wifiManager.getConnectionInfo().getMacAddress() : "";
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                }
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.w(LOG_TAG, "Could not get mac address." + th.toString());
            }
            return "";
        }
    }

    private static String getMacShell() {
        String strReaMac;
        try {
            if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.h)) {
                return null;
            }
            for (String str : new String[]{"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"}) {
                try {
                    strReaMac = reaMac(str);
                } catch (Throwable th) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.e(DeviceConfig.LOG_TAG, "open file  Failed", th);
                    }
                }
                if (strReaMac != null) {
                    return strReaMac;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context != null && FieldManagerEx.allow(com.umeng.commonsdk.utils.b.r)) {
            try {
                if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    strArr[0] = "";
                    return strArr;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    strArr[0] = "";
                    return strArr;
                }
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "Wi-Fi";
                    return strArr;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo2.getSubtypeName();
                }
            } catch (Throwable unused) {
            }
        }
        return strArr;
    }

    public static String getNetworkOperatorName(Context context) {
        if (context != null && FieldManagerEx.allow(com.umeng.commonsdk.utils.b.q)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                    return telephonyManager.getNetworkOperatorName();
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (DeviceConfig.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return -100;
        }
    }

    private static String getOaid(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(n.f21219a, 0);
            return sharedPreferences != null ? sharedPreferences.getString(n.f21220b, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getPackageName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageName();
    }

    public static String getRegisteredOperator(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) {
                return null;
            }
            return telephonyManager.getNetworkOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int[] getResolutionArray(Context context) throws Throwable {
        int iReflectMetrics;
        int iReflectMetrics2;
        if (context != null && FieldManagerEx.allow(com.umeng.commonsdk.utils.b.m)) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                if (windowManager == null) {
                    return null;
                }
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                if ((context.getApplicationInfo().flags & 8192) == 0) {
                    iReflectMetrics = reflectMetrics(displayMetrics, "noncompatWidthPixels");
                    iReflectMetrics2 = reflectMetrics(displayMetrics, "noncompatHeightPixels");
                } else {
                    iReflectMetrics = -1;
                    iReflectMetrics2 = -1;
                }
                if (iReflectMetrics == -1 || iReflectMetrics2 == -1) {
                    iReflectMetrics = displayMetrics.widthPixels;
                    iReflectMetrics2 = displayMetrics.heightPixels;
                }
                int[] iArr = new int[2];
                if (iReflectMetrics > iReflectMetrics2) {
                    iArr[0] = iReflectMetrics2;
                    iArr[1] = iReflectMetrics;
                } else {
                    iArr[0] = iReflectMetrics;
                    iArr[1] = iReflectMetrics2;
                }
                return iArr;
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.e(LOG_TAG, "read resolution fail", th);
                }
            }
        }
        return null;
    }

    public static String getSerial() {
        int i;
        if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.y) || (i = Build.VERSION.SDK_INT) < 9) {
            return null;
        }
        if (i < 26) {
            return Build.SERIAL;
        }
        try {
            Class<?> cls = Class.forName("android.os.Build");
            return (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getSerialNo() throws Throwable {
        String str;
        int i;
        if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.j) || (i = Build.VERSION.SDK_INT) < 9) {
            str = "";
        } else if (i >= 26) {
            try {
                Class<?> cls = Class.forName("android.os.Build");
                str = (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
            } catch (Throwable unused) {
                str = "";
            }
        } else {
            str = Build.SERIAL;
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.i(LOG_TAG, "getDeviceId, serial no: " + str);
        }
        return str;
    }

    public static String getSubOSName(Context context) throws Throwable {
        String str;
        if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.f21333d)) {
            return null;
        }
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (!TextUtils.isEmpty(property)) {
                str = "MIUI";
            } else if (isFlyMe()) {
                str = "Flyme";
            } else if (isEmui(buildProp)) {
                str = "Emui";
            } else {
                if (TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                    return property;
                }
                str = "YunOS";
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) throws Throwable {
        if (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.f21334e)) {
            return null;
        }
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (TextUtils.isEmpty(property)) {
                try {
                    return isFlyMe() ? getFlymeVersion(buildProp) : isEmui(buildProp) ? getEmuiVersion(buildProp) : getYunOSVersion(buildProp);
                } catch (Throwable unused) {
                }
            }
            return property;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int getTimeZone(Context context) throws Throwable {
        if (context != null && FieldManagerEx.allow(com.umeng.commonsdk.utils.b.o)) {
            try {
                Calendar calendar = Calendar.getInstance(getLocale(context));
                if (calendar != null) {
                    return calendar.getTimeZone().getRawOffset() / 3600000;
                }
            } catch (Throwable th) {
                MLog.i(LOG_TAG, "error in getTimeZone", th);
            }
        }
        return 8;
    }

    private static String getYunOSVersion(Properties properties) {
        String property = properties.getProperty("ro.yunos.version");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return property;
    }

    public static boolean isChineseAera(Context context) {
        if (context == null) {
            return false;
        }
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "country", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            return strImprintProperty.equals("cn");
        }
        if (getImsi(context) == null) {
            String str = getLocaleInfo(context)[0];
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("cn")) {
                return true;
            }
        } else {
            int i = context.getResources().getConfiguration().mcc;
            if (i == 460 || i == 461) {
                return true;
            }
            if (i == 0) {
                String str2 = getLocaleInfo(context)[0];
                if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("cn")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isEmui(Properties properties) {
        return properties.getProperty(KEY_EMUI_VERSION_CODE, null) != null;
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(DeviceConfig.getNetworkAccessMode(context)[0]);
    }

    private static String reaMac(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            FileReader fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader, 1024);
                try {
                    line = bufferedReader.readLine();
                    try {
                        fileReader.close();
                    } catch (Throwable unused) {
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileReader.close();
                    } catch (Throwable unused2) {
                    }
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (Throwable unused3) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable unused4) {
        }
        return line;
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
