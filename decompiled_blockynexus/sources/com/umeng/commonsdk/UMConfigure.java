package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.facebook.internal.AnalyticsEvents;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.j;
import com.umeng.cconfig.UMRemoteConfig;
import com.umeng.commonsdk.config.FieldManagerEx;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.n;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog;
    private static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    private static boolean preInitComplete = false;
    private static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    public static boolean sShouldCollectZData = false;
    public static String VALUE_REC_VERSION_NAME = "";
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> declaredConstructor;
        if (cls == null) {
            return null;
        }
        try {
            declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException unused) {
            declaredConstructor = null;
        }
        if (declaredConstructor == null) {
            return null;
        }
        declaredConstructor.setAccessible(true);
        try {
            return declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
            return null;
        }
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = null;
        if (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
        }
        return declaredMethod;
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    private Object getInstanceObject(Class<?> cls) {
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
            }
        }
        return null;
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static String getUmengToken(Context context) {
        if (context != null) {
            return UMUtils.getUmengToken(context.getApplicationContext());
        }
        return null;
    }

    public static void init(Context context, int i, String str) {
        init(context, null, null, i, str);
    }

    private static void initOaid(final Context context) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(n.f21219a, 0);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strA = am.a(context);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(strA) && sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(n.f21221c, (jCurrentTimeMillis2 - jCurrentTimeMillis) + "");
                        editorEdit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                        editorEdit2.putString(n.f21220b, strA);
                        editorEdit2.commit();
                    }
                    if (Build.VERSION.SDK_INT > 28) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static boolean isPreInit() {
        boolean z;
        synchronized (PreInitLock) {
            z = preInitComplete;
        }
        return z;
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(ay.l);
        return !new File(sb.toString()).exists();
    }

    public static void preInit(Context context, String str, String str2) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "preInit: context is null, pls check!");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            str = UMUtils.getAppkeyByXML(applicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UMUtils.getChannelByXML(applicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        UMGlobalContext.getInstance(applicationContext);
        j.a(applicationContext);
        if (!needSendZcfgEnv(applicationContext)) {
            FieldManagerEx.a().a(applicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
    }

    private static void readZData(Context context) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.n, b.a(context).a(), null);
    }

    private static void saveSDKComponent() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(au.at);
        if (isDebugLog()) {
            UMLog.mutlInfo(2, "统计SDK版本号: 9.1.6+000");
        }
        Class<?> cls4 = getClass("com.umeng.analytics.game.GameSdkVersion");
        if (cls4 != null) {
            stringBuffer.append("g");
            if (isDebugLog()) {
                try {
                    String str = (String) cls4.getDeclaredField("SDK_VERSION").get(cls4);
                    if (!TextUtils.isEmpty(str)) {
                        UMLog.mutlInfo(2, "游戏统计SDK版本号: " + str);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        Class<?> cls5 = getClass("com.umeng.vt.V");
        if (cls5 != null) {
            stringBuffer.append("v");
            if (isDebugLog()) {
                try {
                    String str2 = (String) cls5.getDeclaredField("VERSION").get(cls5);
                    if (!TextUtils.isEmpty(str2)) {
                        UMLog.mutlInfo(2, "可视化埋点SDK版本号: " + str2);
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append(au.aw);
            if (isDebugLog() && (cls3 = getClass("com.umeng.message.MsgConstant")) != null) {
                try {
                    String str3 = (String) cls3.getDeclaredField("SDK_VERSION").get(cls3);
                    if (!TextUtils.isEmpty(str3)) {
                        UMLog.mutlInfo(2, "推送SDK版本号: " + str3);
                    }
                } catch (Throwable unused3) {
                }
            }
        }
        if (getClass("com.umeng.socialize.UMShareAPI") != null) {
            stringBuffer.append(au.ax);
            if (isDebugLog() && (cls2 = getClass("com.umeng.a")) != null) {
                try {
                    String str4 = (String) cls2.getDeclaredField("g").get(cls2);
                    if (!TextUtils.isEmpty(str4)) {
                        UMLog.mutlInfo(2, "分享SDK版本号: " + str4);
                    }
                } catch (Throwable unused4) {
                }
            }
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.umzid.Spy") != null) {
            stringBuffer.append("z");
        }
        stringBuffer.append(au.ay);
        if (SdkVersion.SDK_TYPE != 1 && getClass("com.umeng.commonsdk.internal.UMOplus") != null) {
            stringBuffer.append("o");
        }
        if (getClass("com.umeng.airec.RecAgent") != null) {
            stringBuffer.append("u");
            if (isDebugLog() && (cls = getClass("com.umeng.airec.BuildConfig")) != null) {
                try {
                    String str5 = (String) cls.getDeclaredField("VERSION_NAME").get(cls);
                    if (!TextUtils.isEmpty(str5)) {
                        UMLog.mutlInfo(2, "智能推荐SDK版本号: " + str5);
                    }
                } catch (Throwable unused5) {
                }
            }
        }
        Class<?> cls6 = getClass("com.umeng.umverify.utils.f");
        if (cls6 != null) {
            stringBuffer.append("n");
            if (isDebugLog()) {
                try {
                    String str6 = (String) cls6.getDeclaredField("f").get(cls6);
                    if (!TextUtils.isEmpty(str6)) {
                        UMLog.mutlInfo(2, "智能登录SDK版本号: " + str6);
                    }
                } catch (Throwable unused6) {
                }
            }
        }
        try {
            if (getClass("com.umeng.umcrash.UMCrash") != null) {
                stringBuffer.append("c");
            }
        } catch (Throwable unused7) {
        }
        if (TextUtils.isEmpty(stringBuffer)) {
            return;
        }
        com.umeng.commonsdk.statistics.b.f21142a = stringBuffer.toString();
        Log.i(AnalyticsConstants.LOG_TAG, "module init:" + com.umeng.commonsdk.statistics.b.f21142a);
        UMSLEnvelopeBuild.module = stringBuffer.toString();
    }

    private static void setCheckDevice(boolean z) {
        AnalyticsConstants.CHECK_DEVICE = z;
    }

    public static void setEncryptEnabled(boolean z) {
        com.umeng.commonsdk.statistics.b.a(z);
        UMSLEnvelopeBuild.setEncryptEnabled(z);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j) {
        com.umeng.commonsdk.statistics.a.f21141c = ((int) j) * 1000;
    }

    public static void setLogEnabled(boolean z) {
        try {
            debugLog = z;
            MLog.DEBUG = z;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{Boolean.TYPE}), getDecInstanceObject(cls), new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{Boolean.TYPE}), new Object[]{Boolean.valueOf(z)});
        } catch (Exception e2) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + e2);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + th);
            }
        }
    }

    public static void setProcessEvent(boolean z) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("native")) {
                com.umeng.commonsdk.stateless.a.f21102a = "native";
                com.umeng.commonsdk.statistics.a.f21139a = "native";
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.f21102a = WRAPER_TYPE_COCOS2DX_X;
                com.umeng.commonsdk.statistics.a.f21139a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.f21102a = WRAPER_TYPE_COCOS2DX_XLUA;
                com.umeng.commonsdk.statistics.a.f21139a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals("Unity")) {
                com.umeng.commonsdk.stateless.a.f21102a = "Unity";
                com.umeng.commonsdk.statistics.a.f21139a = "Unity";
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.f21102a = WRAPER_TYPE_REACTNATIVE;
                com.umeng.commonsdk.statistics.a.f21139a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.f21102a = WRAPER_TYPE_PHONEGAP;
                com.umeng.commonsdk.statistics.a.f21139a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.f21102a = WRAPER_TYPE_WEEX;
                com.umeng.commonsdk.statistics.a.f21139a = WRAPER_TYPE_WEEX;
            } else if (str.equals(WRAPER_TYPE_HYBRID)) {
                com.umeng.commonsdk.stateless.a.f21102a = WRAPER_TYPE_HYBRID;
                com.umeng.commonsdk.statistics.a.f21139a = WRAPER_TYPE_HYBRID;
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.f21102a = WRAPER_TYPE_FLUTTER;
                com.umeng.commonsdk.statistics.a.f21139a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.f21103b = str2;
        com.umeng.commonsdk.statistics.a.f21140b = str2;
    }

    public static void init(Context context, String str, String str2, int i, String str3) {
        boolean z;
        Method declaredMethod;
        Method declaredMethod2;
        Method declaredMethod3;
        Method declaredMethod4;
        Object objInvoke;
        Class<?> cls;
        Method declaredMethod5;
        Method declaredMethod6;
        try {
            try {
                if (debugLog) {
                    Log.i(TAG, "common version is 9.1.6+000");
                    Log.i(TAG, "common type is " + SdkVersion.SDK_TYPE);
                }
            } catch (Exception e2) {
                if (debugLog) {
                    Log.e(TAG, "init e is " + e2);
                }
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "init e is " + th);
            }
        }
        if (context != null && !isInit) {
            final Context applicationContext = context.getApplicationContext();
            try {
                if (getClass("com.umeng.umzid.Spy") == null) {
                    Log.e(TAG, "--->>> SDK 初始化失败，请检查是否集成umeng-asms-x.x.x.aar库。<<<--- ");
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(applicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-x.x.X.aar库。", 1).show();
                                Looper.loop();
                            } catch (Throwable unused) {
                            }
                        }
                    }.start();
                    return;
                }
            } catch (Throwable unused) {
            }
            try {
                if (getClass("com.umeng.umcrash.UMCrash") == null) {
                    Log.e(TAG, "--->>> SDK 初始化失败，请检查是否集成umeng-crash-x.x.x.aar库。<<<--- ");
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(applicationContext, "SDK 初始化失败，请检查是否集成umeng-crash-x.x.X.aar库。", 1).show();
                                Looper.loop();
                            } catch (Throwable unused2) {
                            }
                        }
                    }.start();
                    return;
                }
            } catch (Throwable unused2) {
            }
            if (!isPreInit()) {
                preInit(applicationContext, str, str2);
                if (!isPreInit()) {
                    return;
                }
            }
            UMUtils.setAppkey(applicationContext, sAppkey);
            String lastAppkey = UMUtils.getLastAppkey(applicationContext);
            if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
                if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
                }
                UMUtils.setLastAppkey(applicationContext, sAppkey);
            }
            if (debugLog) {
                Log.i(TAG, "current appkey is " + sAppkey + ", last appkey is " + lastAppkey);
            }
            if (debugLog) {
                String appkeyByXML = UMUtils.getAppkeyByXML(applicationContext);
                if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                    UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
                }
            }
            UMUtils.setChannel(applicationContext, sChannel);
            if (debugLog) {
                Log.i(TAG, "channel is " + sChannel);
            }
            if (UMUtils.isMainProgress(applicationContext)) {
                saveSDKComponent();
            }
            sShouldCollectZData = true;
            if (Build.VERSION.SDK_INT > 28) {
                UMConfigureImpl.registerInterruptFlag();
                z = true;
            } else {
                z = false;
            }
            if (sShouldCollectZData) {
                UMConfigureImpl.registerInterruptFlag();
                z = true;
            }
            UMConfigureImpl.init(applicationContext);
            initOaid(context);
            if (sShouldCollectZData) {
                readZData(applicationContext);
            }
            if (z) {
                UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.r, b.a(applicationContext).a(), null);
            }
            try {
                Class<?> cls2 = Class.forName("com.umeng.analytics.MobclickAgent");
                if (cls2 != null) {
                    Method declaredMethod7 = cls2.getDeclaredMethod("init", Context.class);
                    if (declaredMethod7 != null) {
                        declaredMethod7.setAccessible(true);
                        declaredMethod7.invoke(cls2, applicationContext);
                        if (z) {
                            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.UMConfigure.3
                                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                                public void onMessageSend() {
                                    Context context2 = applicationContext;
                                    if (context2 != null) {
                                        UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.q, b.a(context2).a(), null);
                                    }
                                    UMConfigureImpl.removeMessageSendListener(this);
                                }
                            });
                        }
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                        }
                    }
                    if (Class.forName("com.umeng.analytics.game.UMGameAgent") != null && (declaredMethod6 = cls2.getDeclaredMethod("setGameScenarioType", Context.class)) != null) {
                        declaredMethod6.setAccessible(true);
                        declaredMethod6.invoke(cls2, applicationContext);
                    }
                }
                if (com.umeng.commonsdk.statistics.b.f21142a.indexOf("e") >= 0 && (cls = Class.forName("com.umeng.analytics.MobclickAgent")) != null && (declaredMethod5 = cls.getDeclaredMethod("disableExceptionCatch", new Class[0])) != null) {
                    declaredMethod5.setAccessible(true);
                    declaredMethod5.invoke(cls, new Object[0]);
                }
            } catch (Throwable unused3) {
            }
            try {
                Class<?> cls3 = Class.forName("com.umeng.message.MessageSharedPrefs");
                if (cls3 != null && (declaredMethod4 = cls3.getDeclaredMethod("getInstance", Context.class)) != null && (objInvoke = declaredMethod4.invoke(cls3, applicationContext)) != null) {
                    Method declaredMethod8 = cls3.getDeclaredMethod("setMessageAppKey", String.class);
                    if (declaredMethod8 != null) {
                        declaredMethod8.setAccessible(true);
                        declaredMethod8.invoke(objInvoke, sAppkey);
                        if (debugLog) {
                            UMLog uMLog = umDebugLog;
                            UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                        }
                    }
                    Method declaredMethod9 = cls3.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                    if (declaredMethod9 != null) {
                        declaredMethod9.setAccessible(true);
                        declaredMethod9.invoke(objInvoke, sChannel);
                        if (debugLog) {
                            UMLog uMLog2 = umDebugLog;
                            UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        boolean z2 = debugLog;
                    } else {
                        if (debugLog) {
                            Log.i(TAG, "push secret is " + str3);
                        }
                        Method declaredMethod10 = cls3.getDeclaredMethod("setMessageAppSecret", String.class);
                        if (declaredMethod10 != null) {
                            declaredMethod10.setAccessible(true);
                            declaredMethod10.invoke(objInvoke, str3);
                            if (debugLog) {
                                UMLog uMLog3 = umDebugLog;
                                UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                            }
                        }
                    }
                }
            } catch (Exception unused4) {
            }
            try {
                Class<?> cls4 = getClass("com.umeng.socialize.UMShareAPI");
                setFile(cls4, KEY_FILE_NAME_APPKEY, sAppkey);
                if (cls4 != null && (declaredMethod3 = cls4.getDeclaredMethod("init", Context.class, String.class)) != null) {
                    declaredMethod3.setAccessible(true);
                    declaredMethod3.invoke(cls4, applicationContext, sAppkey);
                    UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.UMConfigure.4
                        @Override // com.umeng.commonsdk.utils.onMessageSendListener
                        public void onMessageSend() {
                            UMLogDataProtocol callbackFromModuleName;
                            if (applicationContext != null && (callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName("share")) != null) {
                                UMWorkDispatch.sendEvent(applicationContext, 24587, callbackFromModuleName, null);
                            }
                            UMConfigureImpl.removeMessageSendListener(this);
                        }
                    });
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                    }
                }
            } catch (Throwable unused5) {
            }
            AnalyticsConstants.setDeviceType(i);
            try {
                Class<?> cls5 = Class.forName("com.umeng.error.UMError");
                if (cls5 != null && (declaredMethod2 = cls5.getDeclaredMethod("init", Context.class)) != null) {
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(cls5, applicationContext);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                    }
                }
            } catch (Throwable unused6) {
            }
            try {
                Class<?> cls6 = Class.forName("com.umeng.umcrash.UMCrash");
                if (cls6 != null && (declaredMethod = cls6.getDeclaredMethod("init", Context.class, String.class, String.class)) != null) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(cls6, applicationContext, sAppkey, sChannel);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                    }
                }
            } catch (Throwable unused7) {
            }
            try {
                Method declaredMethod11 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
                if (declaredMethod11 != null) {
                    declaredMethod11.invoke(null, applicationContext, sAppkey, sChannel, Integer.valueOf(i), str3);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
                }
            } catch (Throwable unused8) {
            }
            try {
                Method declaredMethod12 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
                if (declaredMethod12 != null) {
                    declaredMethod12.invoke(null, applicationContext, sAppkey);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
                }
            } catch (Throwable unused9) {
            }
            synchronized (lockObject) {
                isFinish = true;
            }
            if (needSendZcfgEnv(applicationContext)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
                UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.p, b.a(applicationContext).a(), null);
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
                a.a(applicationContext);
            }
            if (isDebugLog()) {
                UMConfigureInternation.doSelfCheck(applicationContext);
            }
            try {
                Class<?> cls7 = Class.forName("com.umeng.airec.BuildConfig");
                VALUE_REC_VERSION_NAME = String.valueOf(cls7.getField("VERSION_NAME").get(cls7));
            } catch (Exception unused10) {
                VALUE_REC_VERSION_NAME = "";
            }
            try {
                UMRemoteConfig.getInstance().init(context);
            } catch (Exception unused11) {
            }
            if (isInit) {
                return;
            }
            isInit = true;
            return;
        }
        if (debugLog) {
            Log.e(TAG, "context is null !!!");
        }
        if (isInit) {
            Log.e(TAG, "has inited !!!");
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z));
            } catch (Exception unused) {
            }
        }
    }
}
