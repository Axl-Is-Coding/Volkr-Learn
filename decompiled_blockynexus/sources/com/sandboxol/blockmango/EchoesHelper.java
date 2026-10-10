package com.sandboxol.blockmango;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.app.ActivityCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.facebook.internal.ServerProtocol;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.blockmango.entity.GameRoomItem;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.sandboxol.blocky.router.RealmsController;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.center.utils.TimeUtil;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseDataListener;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.game.R;
import com.sandboxol.greendao.entity.BuyDressResponse;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.recharge.entity.BuyRequest;
import com.umeng.analytics.pro.au;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class EchoesHelper {
    private static final String DEFAULT_LIB_NAME = "main";
    private static final String META_DATA_LIB_NAME = "android.app.lib_name";
    private static final String PREFS_NAME = "Cocos2dxPrefsFile";
    private static final int RUNNABLES_PER_FRAME = 5;
    private static b.h.a.b mAudioListener = new b.h.a.b() { // from class: com.sandboxol.blockmango.EchoesHelper.4
        @Override // b.h.a.b
        public void onPlayStart(String str) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onVoiceOperationResult(11, 0, str);
            }
        }

        @Override // b.h.a.b
        public void onPlayStop(String str) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onVoiceOperationResult(12, 0, str);
            }
        }

        @Override // b.h.a.b
        public void onRecordFailure(int i) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onVoiceOperationResult(2, i, "");
            }
        }

        @Override // b.h.a.b
        public void onRecordSuccess(int i, String str) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onVoiceOperationResult(1, i, str);
            }
        }
    };
    private static boolean sAccelerometerEnabled;
    private static Activity sActivity;
    private static EchoesHelperListener sEchoesHelperListener;
    public static EchoesMusic sEchoesMusic;
    public static EchoesSound sEchoesSound;
    private static String sFileDirectory;
    private static b.h.a.c sGameGameRecord;
    private static boolean sInited;
    private static String sPackageName;
    private static b.h.a.d sPlayVoice;

    public interface EchoesHelperListener {
        void onAppActionTrigger(int i, String str);

        void onCloseGame(int i);

        void onEditorDataReport(String str, String str2);

        void onEngine2GetServerInfo();

        void onExpResult(int i, int i2, int i3, int i4, int i5, int i6, int i7);

        void onGameExit();

        void onGameExit(String str);

        void onLoadMapComplete(int i);

        void onLoadingTips(String str, boolean z);

        void onNextGame();

        void onRecharge(int i);

        void onRecharge(int i, String str);

        void onWatchAd(int i);

        void onWatchAd(int i, String str, String str2);

        void runOnGLThread(Runnable runnable);

        void showDialog(String str, String str2);

        void showEditTextDialog(String str, String str2, int i, int i2, int i3, int i4);

        void showEditorDialog(int i);

        void showEditorGallery(String str, int i, int i2);

        void showEditorProgressBar(boolean z, int i, int i2, int i3);

        void showGameVideoAds(int i);

        void showSmallEditTextDialog(String str, String str2, int i, int i2, int i3, int i4);
    }

    static /* synthetic */ void b() {
        sEchoesHelperListener.onGameExit();
        EchoesMusic echoesMusic = sEchoesMusic;
        if (echoesMusic != null) {
            echoesMusic.onDestroy();
        }
    }

    public static void buyAction(final int i) {
        if (sActivity == null || sEchoesHelperListener == null || EchoesGLSurfaceView.getInstance() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ea
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.a(i);
            }
        });
    }

    public static void copyToClipboard(final String str, final String str2) {
        Activity activity = sActivity;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Pa
                @Override // java.lang.Runnable
                public final void run() {
                    EchoesHelper.a(str2, str);
                }
            });
        }
    }

    public static void disableAccelerometer() {
        sAccelerometerEnabled = false;
    }

    public static void enableAccelerometer() {
        sAccelerometerEnabled = true;
    }

    public static void end() {
        sEchoesMusic.end();
        sEchoesSound.end();
    }

    public static Activity getActivity() {
        return sActivity;
    }

    public static float getBackgroundMusicVolume() {
        return sEchoesMusic.getBackgroundVolume();
    }

    public static boolean getBoolForKey(String str, boolean z) {
        return sActivity.getSharedPreferences(PREFS_NAME, 0).getBoolean(str, z);
    }

    public static String getClientInfo() {
        HashMap map = new HashMap();
        map.put("device", Build.MODEL);
        map.put("user_id", Settings.System.getString(sActivity.getContentResolver(), "android_id"));
        map.put(au.x, "android " + Build.VERSION.RELEASE);
        map.put("manufacturer", Build.BRAND);
        map.put("platform", "android");
        map.put("session_num", Integer.valueOf(getIncreaseProgressively()));
        map.put("version_code", Integer.valueOf(BaseApplication.getApp().getMetaDataAppVersion()));
        map.put(au.n, getPackageName(BaseApplication.getContext()));
        return new com.google.gson.j().a(map);
    }

    public static String getCocos2dxPackageName() {
        return sPackageName;
    }

    public static String getCocos2dxWritablePath() {
        return sFileDirectory;
    }

    public static String getCurrentLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getDPI() {
        Display defaultDisplay;
        if (sActivity == null) {
            return -1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = sActivity.getWindowManager();
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return -1;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return (int) (displayMetrics.density * 160.0f);
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static double getDoubleForKey(String str, double d2) {
        return sActivity.getSharedPreferences(PREFS_NAME, 0).getFloat(str, (float) d2);
    }

    public static float getEffectsVolume() {
        return sEchoesSound.getEffectsVolume();
    }

    public static float getFloatForKey(String str, float f2) {
        return sActivity.getSharedPreferences(PREFS_NAME, 0).getFloat(str, f2);
    }

    public static int getGameTimeToday() {
        return -1;
    }

    private static int getIncreaseProgressively() {
        int intSync = MultiProcessSharedUtils.getIntSync(sActivity, GameSharedConstant.BLOCK_MAN_INCREASE_PROGRESSIVELY) + 1;
        MultiProcessSharedUtils.putInt(sActivity, GameSharedConstant.BLOCK_MAN_INCREASE_PROGRESSIVELY, intSync);
        return intSync;
    }

    public static int getIntegerForKey(String str, int i) {
        return sActivity.getSharedPreferences(PREFS_NAME, 0).getInt(str, i);
    }

    public static synchronized String getPackageName(Context context) {
        String packageName;
        packageName = "unknown";
        if (context != null) {
            try {
                packageName = context.getPackageName();
            } catch (Exception e2) {
                e2.printStackTrace();
                return "unknown";
            }
        }
        return packageName.substring(packageName.lastIndexOf(Consts.DOT) + 1);
    }

    public static String getRoomId() {
        return GameRoomItem.roomId;
    }

    public static String getStringForKey(String str, String str2) {
        return sActivity.getSharedPreferences(PREFS_NAME, 0).getString(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void init(Activity activity) {
        if (sInited) {
            return;
        }
        ApplicationInfo applicationInfo = activity.getApplicationInfo();
        sEchoesHelperListener = (EchoesHelperListener) activity;
        sPackageName = applicationInfo.packageName;
        sFileDirectory = activity.getFilesDir().getAbsolutePath();
        sEchoesMusic = new EchoesMusic(activity);
        sEchoesSound = new EchoesSound(activity);
        nativeSetContext(activity);
        nativeSetApkPath(applicationInfo.sourceDir);
        String voicePath = EngineEnv.getInstance(EngineEnv.getCurUseEngineTypeInGame()).getVoicePath();
        HandlerThread handlerThread = new HandlerThread("GameAudioHelper");
        handlerThread.start();
        sGameGameRecord = new b.h.a.c(handlerThread.getLooper(), voicePath, mAudioListener);
        sPlayVoice = new b.h.a.d(handlerThread.getLooper(), mAudioListener);
        sActivity = activity;
        sInited = true;
    }

    public static boolean isBackgroundMusicPlaying() {
        return sEchoesMusic.isBackgroundMusicPlaying();
    }

    private static boolean isTodayClick(Context context, String str) {
        return !DateUtils.timeStamp2Date(System.currentTimeMillis(), TimeUtil.DEFAULT_DAY_NO_SEPRATOR).equals(SharedUtils.getString(context, str));
    }

    public static void killAppProcess() {
        Activity activity = sActivity;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.za
                @Override // java.lang.Runnable
                public final void run() {
                    EchoesHelper.a();
                }
            });
        }
    }

    private static native void nativeSetApkPath(String str);

    private static native void nativeSetContext(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetEditTextDialogResult(byte[] bArr, int i);

    public static void onAppActionTrigger(final int i, final String str) {
        Log.e("onAppActionTrigger", "type = " + i);
        Activity activity = sActivity;
        if (activity != null && sEchoesHelperListener != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ba
                @Override // java.lang.Runnable
                public final void run() {
                    EchoesHelper.sEchoesHelperListener.onAppActionTrigger(i, str);
                }
            });
        }
        if (i == 14) {
            if (str.contains("OpenGL ES 3")) {
                reportOpenGLVersion(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            } else {
                reportOpenGLVersion("false");
                SandboxReportManager.onEvent("user_not_support_gles3", "gles3", "app", AccountCenter.newInstance().userId.get() + "");
            }
            Log.e("jni_reportOpenGL", str);
        }
    }

    private static void onCallPay(String str) throws JSONException {
        try {
            Log.i("tag", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onCloseGame(final int i) {
        Log.e("jni_onCloseGame", "code = " + i);
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ra
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.onCloseGame(i);
            }
        });
    }

    public static void onDataReport(final String str, final String str2) {
        if (sEchoesHelperListener == null || sActivity == null || RealmsController.getMe() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.ra
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.b(str, str2);
            }
        });
    }

    public static void onEditorDataReport(final String str, final String str2) {
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.wa
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.onEditorDataReport(str, str2);
            }
        });
    }

    public static void onError(int i) {
    }

    public static void onErrorReport(final String str) {
        if (sEchoesHelperListener == null || sActivity == null || RealmsController.getMe() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ja
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.a(str);
            }
        });
    }

    public static void onExpResult(final int i, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7) {
        Log.e("jni_onExpResult", "curLv = " + i + " toLv = " + i2 + " addExp = " + i3 + " curExp = " + i + " toExp = " + i5 + " upExp = " + i6 + " status = " + i7);
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.xa
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.onExpResult(i, i2, i3, i4, i5, i6, i7);
            }
        });
    }

    public static void onFollowEnterGame(final long j, final String str) {
        Log.e("jni_onFollowEnterGame", "onFollowEnterGame gameType:" + str + " tid:" + j);
        if (sActivity == null || EchoesGLSurfaceView.getInstance() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Sa
            @Override // java.lang.Runnable
            public final void run() {
                EchoesGLSurfaceView.getInstance().followGame(j, str);
            }
        });
    }

    public static void onFriendOperation(int i, long j) {
        Log.e("jni_onFriendOperation", "operationType = " + i + " userId = " + j);
        if (i == 1) {
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            fVar.b(GameConstant.AGREE_ADD_FRIEND_ID, j);
            MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_AGREE_ADD_FRIEND, fVar);
        } else {
            if (i != 2) {
                return;
            }
            com.sandboxol.messager.a.f fVar2 = new com.sandboxol.messager.a.f();
            fVar2.b(GameConstant.REQUEST_ADD_FRIEND_ID, j);
            MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_REQUEST_ADD_FRIEND, fVar2);
        }
    }

    public static void onGameExit() {
        Activity activity;
        Log.e("GameExit", "================================");
        if (sEchoesHelperListener == null || (activity = sActivity) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ka
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.b();
            }
        });
    }

    public static void onGameSettlement(String str, String str2) {
        Log.e("jni_onGameSettlement", "gameType_" + str + " gameResult_" + str2);
    }

    public static void onGetServerInfo() {
    }

    public static void onLoadMapComplete() {
        sEchoesHelperListener.onLoadMapComplete(1);
    }

    public static void onLoadingTips(String str, boolean z) {
        sEchoesHelperListener.onLoadingTips(str, z);
    }

    public static void onMapDownloadSuccess() {
        Log.e("jni_onMapDownload", "onMapDownloadSuccess");
        if (sActivity == null || EchoesGLSurfaceView.getInstance() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ha
            @Override // java.lang.Runnable
            public final void run() {
                EchoesGLSurfaceView.getInstance().resetGameDispatch();
            }
        });
    }

    public static void onNextGame() {
        Activity activity;
        Log.e("jni_onNextGame", "================================");
        if (sEchoesHelperListener == null || (activity = sActivity) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.EchoesHelper.1
            @Override // java.lang.Runnable
            public void run() {
                EchoesHelper.sEchoesHelperListener.onNextGame();
            }
        });
    }

    public static void onPause() {
        b.h.a.d dVar = sPlayVoice;
        if (dVar != null) {
            dVar.a();
        }
    }

    public static void onRecharge(final int i) {
        Log.e("jni_onRecharge", "type = " + i);
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Oa
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.onRecharge(i);
            }
        });
    }

    public static void onResetGame(String str, String str2, long j) {
        onResetGameAddr(j, str, str2, "");
    }

    public static void onResetGameAddr(final long j, final String str, final String str2, final String str3) {
        Log.e("jni_onResetGameAddr", "targetUserId = " + j + " gameType = " + str + " mapId = " + str2 + " ip = " + str3);
        if (sActivity == null || EchoesGLSurfaceView.getInstance() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Qa
            @Override // java.lang.Runnable
            public final void run() {
                EchoesGLSurfaceView.getInstance().resetGame(str, str2, j, str3, "", "");
            }
        });
    }

    public static void onResetGameByGameId(final String str, final String str2) {
        Log.e("jni_onResetGameAddr", " gameType = " + str + " targetGameId = " + str2);
        if (sActivity == null || EchoesGLSurfaceView.getInstance() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.ya
            @Override // java.lang.Runnable
            public final void run() {
                EchoesGLSurfaceView.getInstance().resetGame(str, "", 0L, "", "", str2);
            }
        });
    }

    public static void onResume() {
        b.h.a.d dVar = sPlayVoice;
        if (dVar != null) {
            dVar.b();
        }
    }

    public static void onUsePropResults(String str, int i) {
        Log.e("jni_onUsePropResults", "=================UsePropResults[" + i + "]===============" + str);
    }

    public static void onUserChange(String str, String str2, long j, int i, boolean z) {
    }

    public static void onUserIn(String str, long j) {
        Log.e("jni_onUserIn", "nickName_" + str + " userId_" + j);
    }

    public static void onUserOut(long j) {
        Log.e("jni_onUserOut", "userId_" + j);
    }

    public static void onVoiceOperation(int i, String str) {
        Activity activity;
        if (sGameGameRecord == null || (activity = sActivity) == null || sPlayVoice == null) {
            return;
        }
        if (androidx.core.content.b.a(activity, "android.permission.RECORD_AUDIO") != 0) {
            runOnGLThread(new Runnable() { // from class: com.sandboxol.blockmango.Ta
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityCompat.a(EchoesHelper.sActivity, new String[]{"android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.RECORD_AUDIO"}, 10086);
                }
            });
        }
        if (i == 1 || i == 2 || i == 3) {
            sGameGameRecord.sendEmptyMessage(i);
            return;
        }
        switch (i) {
            case 11:
            case 12:
            case 13:
            case 14:
                Message message = new Message();
                if (str == null) {
                    str = "";
                }
                message.obj = str;
                message.what = i;
                sPlayVoice.sendMessage(message);
                break;
        }
    }

    public static void onWatchAd(final int i) {
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.ua
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.onWatchAd(i);
            }
        });
    }

    public static void openInviteLink(final String str) {
        if (sActivity == null || str == null || !Patterns.WEB_URL.matcher(str).matches()) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ma
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.c(str);
            }
        });
    }

    public static void pauseAllEffects() {
        sEchoesSound.pauseAllEffects();
    }

    public static void pauseBackgroundMusic() {
        sEchoesMusic.pauseBackgroundMusic();
    }

    public static void pauseEffect(int i) {
        sEchoesSound.pauseEffect(i);
    }

    public static void playAdVideo() {
        Activity activity = sActivity;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.va
                @Override // java.lang.Runnable
                public final void run() {
                    EchoesHelper.e();
                }
            });
        }
    }

    public static void playBackgroundMusic(String str, boolean z, float f2, float f3) {
        sEchoesMusic.playBackgroundMusic(str, z, f2, f3);
    }

    public static int playEffect(String str, boolean z, float f2, float f3, float f4) {
        return sEchoesSound.playEffect(str, z, f2, f3, f4);
    }

    public static void playScreen(final int i) {
        Log.e("jni_showGameVideoAds", "type = " + i);
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.sa
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.showGameVideoAds(i);
            }
        });
    }

    public static void playVideo(final int i, final String str) {
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Na
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.c(i, str);
            }
        });
    }

    public static void preloadBackgroundMusic(String str) {
        sEchoesMusic.preloadBackgroundMusic(str);
    }

    public static void preloadEffect(String str) {
        sEchoesSound.preloadEffect(str);
    }

    public static void reportAdVideoShow() {
        Activity activity = sActivity;
    }

    private static void reportOpenGLVersion(String str) {
        ActivityManager activityManager;
        try {
            if (sActivity == null || (activityManager = (ActivityManager) sActivity.getSystemService("activity")) == null) {
                return;
            }
            ConfigurationInfo deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo();
            onDataReport(EventConstant.OPEN_GL_VERSION, String.valueOf(deviceConfigurationInfo.reqGlEsVersion));
            if (isTodayClick(sActivity, "open_gl_version_daily")) {
                onDataReport("open_gl_version_daily", String.valueOf(deviceConfigurationInfo.reqGlEsVersion));
                SharedUtils.putString(sActivity, "open_gl_version_daily", DateUtils.timeStamp2Date(System.currentTimeMillis(), TimeUtil.DEFAULT_DAY_NO_SEPRATOR));
            }
            if (isTodayClick(BaseApplication.getContext(), SharedConstant.OPEN_GL_3_0_VERSION_DAILY)) {
                onDataReport(EventConstant.OPEN_GL_IS_3_0, str);
                SharedUtils.putString(BaseApplication.getContext(), SharedConstant.OPEN_GL_3_0_VERSION_DAILY, DateUtils.timeStamp2Date(System.currentTimeMillis(), TimeUtil.DEFAULT_DAY_NO_SEPRATOR));
            }
        } catch (Exception unused) {
            onDataReport(EventConstant.OPEN_GL_VERSION, "null");
        }
    }

    public static void resumeAllEffects() {
        sEchoesSound.resumeAllEffects();
    }

    public static void resumeBackgroundMusic() {
        sEchoesMusic.resumeBackgroundMusic();
    }

    public static void resumeEffect(int i) {
        sEchoesSound.resumeEffect(i);
    }

    public static void rewindBackgroundMusic() {
        sEchoesMusic.rewindBackgroundMusic();
    }

    public static void runOnGLThread(Runnable runnable) {
        ((EchoesActivity) sActivity).runOnGLThread(runnable);
    }

    public static void setAccelerometerInterval(float f2) {
    }

    public static void setBackgroundMusicVolume(float f2) {
        sEchoesMusic.setBackgroundVolume(f2);
    }

    public static void setBoolForKey(String str, boolean z) {
        SharedPreferences.Editor editorEdit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static void setDoubleForKey(String str, double d2) {
        SharedPreferences.Editor editorEdit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putFloat(str, (float) d2);
        editorEdit.commit();
    }

    public static void setEditTextDialogResult(String str, final int i) {
        try {
            final byte[] bytes = str.getBytes("UTF8");
            sEchoesHelperListener.runOnGLThread(new Runnable() { // from class: com.sandboxol.blockmango.Fa
                @Override // java.lang.Runnable
                public final void run() {
                    EchoesHelper.nativeSetEditTextDialogResult(bytes, i);
                }
            });
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static void setEffectsVolume(float f2) {
        sEchoesSound.setEffectsVolume(f2);
    }

    public static void setFloatForKey(String str, float f2) {
        SharedPreferences.Editor editorEdit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putFloat(str, f2);
        editorEdit.commit();
    }

    public static void setIntegerForKey(String str, int i) {
        SharedPreferences.Editor editorEdit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static void setStringForKey(String str, String str2) {
        SharedPreferences.Editor editorEdit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    private static void showDialog(String str, String str2) {
        sEchoesHelperListener.showDialog(str, str2);
    }

    private static void showEditTextDialog(String str, String str2, int i, int i2, int i3, int i4) {
        sEchoesHelperListener.showEditTextDialog(str, str2, i, i2, i3, i4);
    }

    public static void showEditorDialog(final int i) {
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ca
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.showEditorDialog(i);
            }
        });
    }

    public static void showEditorGallery(final String str, final int i, final int i2) {
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ga
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.showEditorGallery(str, i, i2);
            }
        });
    }

    public static void showEditorProgressBar(final boolean z, final int i, final int i2, final int i3) {
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.ta
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.showEditorProgressBar(z, i, i2, i3);
            }
        });
    }

    private static void showSmallEditTextDialog(String str, String str2, int i, int i2, int i3, int i4) {
        sEchoesHelperListener.showSmallEditTextDialog(str, str2, i, i2, i3, i4);
    }

    public static void stopAllEffects() {
        sEchoesSound.stopAllEffects();
    }

    public static void stopBackgroundMusic() {
        sEchoesMusic.stopBackgroundMusic();
    }

    public static void stopEffect(int i) {
        sEchoesSound.stopEffect(i);
    }

    public static void terminateProcess() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        Process.killProcess(Process.myPid());
    }

    public static void unloadEffect(String str) {
        sEchoesSound.unloadEffect(str);
    }

    public static void uploadFile(final String str, final String str2, final String str3) {
        if (sActivity == null || sEchoesHelperListener == null || EchoesGLSurfaceView.getInstance() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Da
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.a(str, str2, str3);
            }
        });
    }

    public static void vibratorOnTime(int i) {
        b.h.b.a.o.a(sActivity, i);
    }

    static /* synthetic */ void a(String str) {
        if (RealmsController.getMe() != null) {
            RealmsController.getMe().onErrorReport(str);
        }
    }

    static /* synthetic */ void c(int i, String str) {
        try {
            new GameVideoDialog(sActivity, i, str).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void e() {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.GAME_AD_INFO, 4);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_GAME_SHOW_AD_SUCCESS, fVar);
    }

    public static void onWatchAd(final int i, final String str, final String str2) {
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.qa
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.onWatchAd(i, str, str2);
            }
        });
    }

    static /* synthetic */ void b(String str) {
        sEchoesHelperListener.onGameExit(str);
        EchoesMusic echoesMusic = sEchoesMusic;
        if (echoesMusic != null) {
            echoesMusic.onDestroy();
        }
    }

    public static void onGameExit(final String str) {
        Activity activity;
        Log.e("GameExit", "================================" + str);
        if (sEchoesHelperListener == null || (activity = sActivity) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Aa
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.b(str);
            }
        });
    }

    public static void onRecharge(final int i, final String str) {
        Log.e("jni_onRecharge", "type = " + i);
        Activity activity = sActivity;
        if (activity == null || sEchoesHelperListener == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Ia
            @Override // java.lang.Runnable
            public final void run() {
                EchoesHelper.sEchoesHelperListener.onRecharge(i, str);
            }
        });
    }

    public static void onResetGameAddr(final long j, final String str, final String str2, final String str3, final String str4) {
        Log.e("jni_onResetGameAddr", "targetUserId = " + j + " gameType = " + str + " mapId = " + str2 + " ip = " + str3);
        if (sActivity == null || EchoesGLSurfaceView.getInstance() == null) {
            return;
        }
        sActivity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.La
            @Override // java.lang.Runnable
            public final void run() {
                EchoesGLSurfaceView.getInstance().resetGame(str, str2, j, str3, str4, "");
            }
        });
    }

    static /* synthetic */ void a(String str, String str2, String str3) {
        File file = new File(str);
        if (!file.exists()) {
            Log.e("File status", "No exists!");
        } else if (str2 != null && str3 != null) {
            com.sandboxol.gameblocky.web.q.a(file, str2, str3, new OnResponseListener<String>() { // from class: com.sandboxol.blockmango.EchoesHelper.2
                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onError(int i, String str4) {
                    Log.e("File status", "Upload Failed!");
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onServerError(int i) {
                    Log.e("File status", "Upload Failed!");
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onSuccess(String str4) {
                    Log.e("File status", "Upload Success!");
                }
            });
        } else {
            Log.e("File status", "File name or folder name is null!");
        }
    }

    static /* synthetic */ void b(String str, String str2) {
        if (RealmsController.getMe() != null) {
            RealmsController.getMe().onDataReport(str, str2);
        }
    }

    static /* synthetic */ void c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        sActivity.startActivity(intent);
    }

    static /* synthetic */ void a(final int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BuyRequest.BuyDecorationListBean(0, i));
        com.sandboxol.gameblocky.web.s.a(new BuyRequest(arrayList), new OnResponseDataListener<BuyDressResponse>() { // from class: com.sandboxol.blockmango.EchoesHelper.3
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i2, String str) {
                switch (i2) {
                    case 5002:
                        ToastUtils.showShortToast(EchoesHelper.sActivity, R.string.good_invalid_good_id);
                        break;
                    case 5003:
                    case 5005:
                    default:
                        ToastUtils.showShortToast(EchoesHelper.sActivity, EchoesHelper.sActivity.getString(R.string.connect_error_code, new Object[]{Integer.valueOf(i2)}));
                        break;
                    case 5004:
                        ToastUtils.showShortToast(EchoesHelper.sActivity, R.string.good_is_sell_out);
                        break;
                    case 5006:
                        ToastUtils.showShortToast(EchoesHelper.sActivity, R.string.good_diamonds_not_enough);
                        break;
                    case 5007:
                        ToastUtils.showShortToast(EchoesHelper.sActivity, R.string.gold_not_enough);
                        break;
                    case 5008:
                        ToastUtils.showShortToast(EchoesHelper.sActivity, R.string.good_have_clothes);
                        break;
                }
                EchoesGLSurfaceView.getInstance().buyActionResult(i, i2);
            }

            @Override // com.sandboxol.common.base.web.OnResponseDataListener
            public void onErrorWithData(int i2, String str, BuyDressResponse buyDressResponse) {
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i2) {
                ToastUtils.showShortToast(EchoesHelper.sActivity, HttpUtils.getHttpErrorMsg(EchoesHelper.sActivity, i2));
                EchoesGLSurfaceView.getInstance().buyActionResult(i, i2);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(BuyDressResponse buyDressResponse) {
                ToastUtils.showShortToast(EchoesHelper.sActivity, R.string.good_buy_success);
                EchoesGLSurfaceView.getInstance().buyActionResult(i, 1);
                MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_BUY_ACTION_SUCCESS);
            }
        });
    }

    static /* synthetic */ void a() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) sActivity.getSystemService("activity")).getRunningAppProcesses()) {
            if (!TextUtils.equals(runningAppProcessInfo.processName, sActivity.getPackageName())) {
                if (TextUtils.equals(runningAppProcessInfo.processName, sActivity.getPackageName() + ".EditorServices")) {
                }
            }
            Process.killProcess(runningAppProcessInfo.pid);
        }
        sActivity.finish();
    }

    static /* synthetic */ void a(String str, String str2) {
        ClipboardManager clipboardManager = (ClipboardManager) sActivity.getSystemService("clipboard");
        if (TextUtils.isEmpty(str)) {
            str = "Label";
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(str, str2));
    }
}
