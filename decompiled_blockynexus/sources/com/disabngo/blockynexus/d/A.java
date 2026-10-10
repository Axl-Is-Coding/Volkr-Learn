package com.disabngo.blockynexus.d;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.just.agentweb.DefaultWebClient;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.luban.Luban;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes2.dex */
public class A {
    public static float a(String str) {
        return Float.parseFloat(str) / 255.0f;
    }

    public static boolean b(Context context) {
        return ChannelManager.isHasGoogleService(context);
    }

    public static String c(String str) {
        return str.replace("</p><p>", "<br />").replace("<p>", "").replace("</p>", "");
    }

    public static void a(Context context, EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 2);
        }
    }

    public static boolean b(String str) {
        return Pattern.compile("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]").matcher(str).find();
    }

    @SuppressLint({"WrongConstant"})
    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(DefaultWebClient.HTTP_SCHEME));
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 32);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static boolean b(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().processName)) {
                return true;
            }
        }
        return false;
    }

    private static String b() {
        String str = Environment.getExternalStorageDirectory() + "/" + BaseApplication.getApp().getMetaDataRootPath() + "/BlockMan/image/";
        if (new File(str).mkdirs()) {
        }
        return str;
    }

    public static boolean a(Context context, String str) {
        try {
            Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10).iterator();
            while (it.hasNext()) {
                if (it.next().baseActivity.getClassName().contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void a(Context context, List<String> list, ArrayList<File> arrayList) {
        Luban.with(context).load(list).ignoreBy(100).setTargetDir(b()).setCompressListener(new z(arrayList)).launch();
    }

    public static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT <= 19;
    }

    public static boolean a(boolean z) {
        return Build.VERSION.SDK_INT <= 19 && z;
    }
}
