package com.umeng.umcrash;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.CustomLogInfo;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class UMCrash {
    public static final String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final String KEY_CALLBACK_UMID = "um_umid";
    public static final String KEY_HEADER_APPKEY = "um_app_key";
    public static final String KEY_HEADER_CHANNEL = "um_app_channel";
    public static final String KEY_HEADER_CRASH_VERSION = "um_crash_sdk_version";
    public static final String KEY_HEADER_OS = "um_os";
    public static final String KEY_HEADER_UMID = "um_umid_header";
    private static final String TAG = "UMCrash";
    private static String crashSdkVersion = "v0.0.5";
    private static boolean isDebug = true;
    private static boolean isEncrypt = false;
    private static boolean isZip = true;
    private static Context mContext;
    private static Object pageArrayLock = new Object();
    private static ArrayList<String> mArrayList = new ArrayList<>(10);

    private static class CrashClientImpl implements ICrashClient {
        private CrashClientImpl() {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onAddCrashStats(String str, int i, int i2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public File onBeforeUploadLog(File file) {
            return file;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onClientProcessLogGenerated(String str, File file, String str2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onCrashRestarting(boolean z) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public String onGetCallbackInfo(String str, boolean z) {
            String string = null;
            if (!UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                if (UMCrash.KEY_CALLBACK_UMID.equals(str)) {
                    return UMCrash.getUMID(UMCrash.mContext);
                }
                return null;
            }
            try {
                synchronized (UMCrash.pageArrayLock) {
                    if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("source", 0);
                        jSONObject.put("action_name", "page_view");
                        JSONArray jSONArray = new JSONArray();
                        for (int i = 0; i < UMCrash.mArrayList.size(); i++) {
                            String str2 = (String) UMCrash.mArrayList.get(i);
                            if (str2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("name", str2);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("action_parameter", jSONArray);
                        string = jSONObject.toString();
                        if (UMCrash.isDebug) {
                            Log.i(UMCrash.TAG, "page json is " + string);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return string;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onLogGenerated(File file, String str) {
        }
    }

    public static void generateCustomLog(Throwable th, String str) {
        if (th == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty");
            return;
        }
        try {
            CustomLogInfo customLogInfoBuild = new UMCustomLogInfoBuilder(str).stack(th).build();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(KEY_CALLBACK_UMID);
            arrayList.add(KEY_CALLBACK_PAGE_ACTION);
            customLogInfoBuild.mCallbacks = arrayList;
            CrashApi crashApi = CrashApi.getInstance();
            if (crashApi == null) {
                Log.e(TAG, "CrashApi is null, not init .");
            } else {
                crashApi.generateCustomLog(customLogInfoBuild);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized String getUMID(Context context) {
        Class<?> cls;
        Method method;
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.UMConfigure");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                method = cls.getMethod("getUMIDString", Context.class);
            } catch (NoSuchMethodException unused2) {
                method = null;
            }
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, context);
                    if (objInvoke != null) {
                        string = objInvoke.toString();
                    }
                } catch (IllegalAccessException | InvocationTargetException unused3) {
                }
            }
        }
        return string;
    }

    public static void init(Context context, String str, String str2) {
        if (context == null || str == null) {
            Log.e(TAG, "context is null or appkey is null, init failed.");
            return;
        }
        mContext = context;
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("mDebug", isDebug);
            bundle.putBoolean("mEncryptLog", isEncrypt);
            bundle.putBoolean("mZipLog", isZip);
            bundle.putBoolean("enableUnexpLog", false);
            CrashApi crashApiCreateInstanceEx = CrashApi.createInstanceEx(context, str, isDebug, bundle, new CrashClientImpl());
            if (crashApiCreateInstanceEx != null) {
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_APPKEY, str);
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CHANNEL, str2);
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_OS, "android");
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_UMID, getUMID(context));
                if (context instanceof Application) {
                    ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.umcrash.UMCrash.1
                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityCreated(Activity activity, Bundle bundle2) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityDestroyed(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityPaused(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityResumed(Activity activity) {
                            synchronized (UMCrash.pageArrayLock) {
                                if (UMCrash.mArrayList != null) {
                                    if (UMCrash.mArrayList.size() >= 10) {
                                        UMCrash.mArrayList.remove(0);
                                    }
                                    UMCrash.mArrayList.add(activity.getLocalClassName() + "-" + System.currentTimeMillis());
                                }
                            }
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStarted(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStopped(Activity activity) {
                        }
                    });
                    crashApiCreateInstanceEx.registerInfoCallback(KEY_CALLBACK_UMID, 1048593);
                    crashApiCreateInstanceEx.registerInfoCallback(KEY_CALLBACK_PAGE_ACTION, 1048593);
                } else {
                    Log.e(TAG, "context not instanceof application.");
                }
            } else {
                Log.e(TAG, "create CrashAPI is null.");
            }
        } catch (Throwable unused) {
        }
    }

    public static void setDebug(boolean z) {
        isDebug = z;
    }

    public static void generateCustomLog(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                CustomLogInfo customLogInfo = new CustomLogInfo(null, "exception");
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(KEY_CALLBACK_UMID);
                arrayList.add(KEY_CALLBACK_PAGE_ACTION);
                customLogInfo.mCallbacks = arrayList;
                HashMap map = new HashMap(20);
                map.put(UMCustomLogInfoBuilder.LOG_KEY_CT, "exception");
                map.put(UMCustomLogInfoBuilder.LOG_KEY_AC, str2);
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry entry : map.entrySet()) {
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append(":");
                    stringBuffer.append((String) entry.getValue());
                    stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
                String str3 = "Exception message:\nBack traces starts.\n" + str + UMCustomLogInfoBuilder.LINE_SEP + "Back traces ends.";
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append(str3);
                    stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
                customLogInfo.mData = stringBuffer;
                CrashApi crashApi = CrashApi.getInstance();
                if (crashApi == null) {
                    Log.e(TAG, "CrashApi is null, not init .");
                    return;
                } else {
                    crashApi.generateCustomLog(customLogInfo);
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        Log.e(TAG, "generate custom log failed ! e is null or type is empty");
    }
}
