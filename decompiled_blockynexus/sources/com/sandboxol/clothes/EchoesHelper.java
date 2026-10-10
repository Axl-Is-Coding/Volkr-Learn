package com.sandboxol.clothes;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.Log;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.party.PartyMessageToken;
import com.sandboxol.center.router.moduleInfo.party.PartyStringConstant;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.messager.MessagerClient;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class EchoesHelper {
    private static final String PREFS_NAME = "Cocos2dxPrefsFile";
    private static Context sContext;
    private static boolean sInited;

    public static void checkResourceResult(int i, boolean z, String str, String str2) {
        String strA;
        if (i == 1) {
            strA = com.sandboxol.decorate.manager.q.a(str, str2);
        } else if (i == 2) {
            strA = com.sandboxol.decorate.manager.q.a(str);
        } else if (i == 3) {
            strA = com.sandboxol.decorate.manager.q.b(str);
        } else {
            if (i == 4) {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DRESS_OR_SHOP_LIST_DATA);
                return;
            }
            strA = "";
        }
        if (!z) {
            com.apkfuns.logutils.c.a("checkResourceResult").c(strA + " is can not use");
        }
        com.sandboxol.decorate.manager.q.a(strA, z);
    }

    public static void clickKick(String str) {
        System.out.println("clickPlayer：" + str);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(PartyStringConstant.PARTY_CLICK_PLAYER_NAME, str);
        MessagerClient.getIns().sendMsg1(PartyMessageToken.PARTY_KICK_PLAYER, fVar);
    }

    public static void clickPlayer(String str) {
        System.out.println("clickPlayer：" + str);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(PartyStringConstant.PARTY_CLICK_PLAYER_NAME, str);
        MessagerClient.getIns().sendMsg1(PartyMessageToken.PARTY_CLICK_PLAYER, fVar);
    }

    public static void clickWaiting() {
        MessagerClient.getIns().sendMsg0(PartyMessageToken.PARTY_ADD_PLAYER);
    }

    public static void disableAccelerometer() {
    }

    public static void enableAccelerometer() {
    }

    public static boolean getBoolForKey(String str, boolean z) {
        return sContext.getSharedPreferences(PREFS_NAME, 0).getBoolean(str, z);
    }

    public static String getCurrentLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static double getDoubleForKey(String str, double d2) {
        return sContext.getSharedPreferences(PREFS_NAME, 0).getFloat(str, (float) d2);
    }

    public static float getFloatForKey(String str, float f2) {
        return sContext.getSharedPreferences(PREFS_NAME, 0).getFloat(str, f2);
    }

    public static int getIntegerForKey(String str, int i) {
        return sContext.getSharedPreferences(PREFS_NAME, 0).getInt(str, i);
    }

    public static String getStringForKey(String str, String str2) {
        return sContext.getSharedPreferences(PREFS_NAME, 0).getString(str, str2);
    }

    public static void init(Context context) {
        if (sInited) {
            return;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        nativeSetContext(context);
        nativeSetApkPath(applicationInfo.sourceDir);
        sContext = context;
        sInited = true;
    }

    private static native void nativeSetApkPath(String str);

    private static native void nativeSetContext(Object obj);

    private static native void nativeSetEditTextDialogResult(byte[] bArr);

    private static void onCallPay(String str) throws JSONException {
        try {
            Log.i("tag", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setAccelerometerInterval(float f2) {
    }

    public static void setBoolForKey(String str, boolean z) {
        SharedPreferences.Editor editorEdit = sContext.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static void setDoubleForKey(String str, double d2) {
        SharedPreferences.Editor editorEdit = sContext.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putFloat(str, (float) d2);
        editorEdit.commit();
    }

    public static void setEditTextDialogResult(String str) {
    }

    public static void setFloatForKey(String str, float f2) {
        SharedPreferences.Editor editorEdit = sContext.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putFloat(str, f2);
        editorEdit.commit();
    }

    public static void setIntegerForKey(String str, int i) {
        SharedPreferences.Editor editorEdit = sContext.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static void setStringForKey(String str, String str2) {
        SharedPreferences.Editor editorEdit = sContext.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    private static void showDialog(String str, String str2) {
    }

    private static void showEditTextDialog(String str, String str2, int i, int i2, int i3, int i4) {
    }

    public static void terminateProcess() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        Process.killProcess(Process.myPid());
    }
}
