package com.alibaba.sdk.android.feedback.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.alibaba.sdk.android.feedback.util.ErrorCode;
import com.alibaba.sdk.android.feedback.util.FeedbackErrorCallback;
import com.alibaba.sdk.android.feedback.util.IUnreadCountCallback;
import com.alibaba.sdk.android.feedback.util.i;
import com.alibaba.sdk.android.feedback.util.n;
import com.alibaba.sdk.android.feedback.util.o;
import com.alibaba.sdk.android.feedback.windvane.d;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.alibaba.sdk.android.utils.AMSConfigUtils;
import com.alibaba.sdk.android.utils.AMSDevReporter;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FeedbackAPI {
    public static final int APP_MONITOR = 1;
    public static final int ENV_DAILY = 3;
    public static final int ENV_ONLINE = 1;
    public static final int ENV_PRE = 2;
    private static final String TAG = "FeedbackAPI";
    public static final int UT_ANALYTICS = 2;
    public static Activity activity;
    public static d customWebviewFragment;
    private static IActivityCallback mCallback;
    private static String mConfig;
    private static Object lock = new Object();
    private static boolean isUTInit = false;
    public static a mErrorManager = new a();
    public static JSONObject mExtInfo = new JSONObject();
    public static Callable leaveCallback = null;
    public static int type = 1;

    public static void addErrorCallback(FeedbackErrorCallback feedbackErrorCallback) {
        mErrorManager.a(feedbackErrorCallback);
    }

    public static void addLeaveCallback(Callable callable) {
        leaveCallback = callable;
    }

    public static void cleanActivity() {
        if (activity != null) {
            activity = null;
        }
    }

    public static void cleanFeedbackFragment() {
        if (customWebviewFragment != null) {
            customWebviewFragment = null;
        }
    }

    private static void commitDAU(Context context) {
        n.b();
        isUTInit = true;
        setLogEnabled(n.a(context));
        HashMap map = new HashMap();
        map.put(AMSDevReporter.AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_VERSION.toString(), "3.1.8");
        AMSDevReporter.asyncReport(context.getApplicationContext(), AMSDevReporter.AMSSdkTypeEnum.AMS_FEEDBACK, map);
    }

    public static IActivityCallback getActivityCallback() {
        return mCallback;
    }

    protected static void getFeedbackConf(Callable callable, Callable callable2) {
        new com.alibaba.sdk.android.feedback.a.c().a(callable, callable2);
    }

    public static Fragment getFeedbackFragment() {
        customWebviewFragment = new d();
        Bundle bundle = new Bundle();
        bundle.putString("URL", com.alibaba.sdk.android.feedback.a.b.k());
        customWebviewFragment.setArguments(bundle);
        return customWebviewFragment;
    }

    public static void getFeedbackUnreadCount(IUnreadCountCallback iUnreadCountCallback) {
        if (isUTInit) {
            new com.alibaba.sdk.android.feedback.a.c().a(iUnreadCountCallback);
        } else {
            mErrorManager.a(com.alibaba.sdk.android.feedback.a.b.n(), "反馈组件初始化失败, 空指针", ErrorCode.NULL_ERROR);
        }
    }

    public static void init(Application application) {
        init(application, AMSConfigUtils.getAppKey(application), AMSConfigUtils.getAppSecret(application));
    }

    public static void init(Application application, String str, String str2) {
        synchronized (lock) {
            String strTrim = str.trim();
            String strTrim2 = str2.trim();
            if (application != null && !TextUtils.isEmpty(strTrim) && !TextUtils.isEmpty(strTrim2)) {
                utAndSecurityInit(strTrim, strTrim2, application, type);
                String strB = i.b(application);
                if (TextUtils.isEmpty(strB)) {
                    g.b(TAG, "deviceID is null, fail to init");
                    return;
                }
                g.a(TAG, "init appkey:" + strTrim);
                com.alibaba.sdk.android.feedback.a.b.a(application.getApplicationContext());
                com.alibaba.sdk.android.feedback.a.b.a(strTrim);
                com.alibaba.sdk.android.feedback.a.b.b(strTrim2);
                com.alibaba.sdk.android.feedback.a.b.d(strB);
                com.alibaba.sdk.android.feedback.a.b.e("3.1.8");
                com.alibaba.sdk.android.feedback.a.b.c("0");
                commitDAU(application);
                com.alibaba.sdk.android.feedback.a.f3672a = application.getApplicationInfo().targetSdkVersion;
                return;
            }
            g.b(TAG, "context or appkey or appSecret is null, fail to init");
        }
    }

    public static void init(Application application, String str, String str2, int i) {
        type = i;
        init(application, str, str2);
    }

    public static void openFeedbackActivity() {
        openFeedbackActivity(null, null);
    }

    public static void openFeedbackActivity(Callable callable, Callable callable2) {
        if (!isUTInit) {
            mErrorManager.a(com.alibaba.sdk.android.feedback.a.b.n(), "反馈组件初始化失败, 空指针异常", ErrorCode.NULL_ERROR);
            n.a("openFeedbackFaild", "appkey or context is null");
            return;
        }
        cleanFeedbackFragment();
        mConfig = com.alibaba.sdk.android.feedback.a.a.a();
        if (!TextUtils.isEmpty(mConfig)) {
            g.a(TAG, "use local config:" + mConfig);
            com.alibaba.sdk.android.feedback.a.a.b(mConfig);
            o.a(com.alibaba.sdk.android.feedback.a.b.n(), com.alibaba.sdk.android.feedback.a.b.l());
            if (callable != null) {
                try {
                    callable.call();
                } catch (Exception unused) {
                }
            }
        }
        g.a(TAG, "config is empty,get it from network");
        getFeedbackConf(new c(callable), callable2);
    }

    public static void setActivityCallback(IActivityCallback iActivityCallback) {
        mCallback = iActivityCallback;
    }

    public static void setAppExtInfo(JSONObject jSONObject) {
        mExtInfo = jSONObject;
    }

    public static void setBackIcon(int i) {
        com.alibaba.sdk.android.feedback.a.b.a(i);
    }

    public static void setDefaultUserContactInfo(String str) {
        com.alibaba.sdk.android.feedback.a.b.f(str);
    }

    public static void setEnv(int i) {
        com.alibaba.sdk.android.feedback.a.b.b(i);
    }

    public static void setFeedbackFragment(Callable callable, Callable callable2) {
        getFeedbackConf(callable, callable2);
    }

    public static void setHistoryTextSize(float f2) {
        com.alibaba.sdk.android.feedback.a.b.a(f2);
    }

    public static void setLogEnabled(boolean z) {
        g.a(z);
        AMSDevReporter.setLogEnabled(z);
    }

    public static void setTitleBarHeight(int i) {
        com.alibaba.sdk.android.feedback.a.b.c(i);
    }

    public static void setTranslucent(boolean z) {
        com.alibaba.sdk.android.feedback.a.b.a(z);
    }

    public static void setUserNick(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        com.alibaba.sdk.android.feedback.a.b.h(str);
    }

    public static void setWebViewUrl(String str) {
        com.alibaba.sdk.android.feedback.a.b.g(str);
    }

    private static void utAndSecurityInit(String str, String str2, Application application, int i) {
        if (isUTInit) {
            return;
        }
        isUTInit = true;
        n.a(str, str2, application, i);
    }
}
