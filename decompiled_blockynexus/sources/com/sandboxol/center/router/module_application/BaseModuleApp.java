package com.sandboxol.center.router.module_application;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.os.Process;
import android.util.Log;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.ClassUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.android.arouter.utils.PackageUtils;
import com.alibaba.android.arouter.utils.TextUtils;
import com.sandboxol.adsoversea.config.AdsSourcesType;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BaseModuleApp implements IModuleInit {
    private static BaseModuleApp baseModuleApp;
    private String UmKey;
    private String activityId;
    private String admobInterstitialKey;
    private String admobKey;
    private String admobVideoKey;
    private String adsSources;
    private Application application;
    private String applicationId;
    private String blockmanOrganizeTeam;
    private String broadcastType;
    private String channelId;
    private String downloadSdk;
    private String eventType;
    private String googleKey;
    private String ironsourceKey;
    private boolean isPackNewEngineRes;
    private String packageName;
    private String packageType;
    private String payUrl;
    private String talkingDataKey;
    private String thirdPartPayUrl;
    private boolean isBeta = false;
    private boolean isCopyV1ToV2 = false;
    private boolean isChina = false;
    private boolean isOpenMtp = true;

    public static BaseModuleApp getBaseModuleApp() {
        return baseModuleApp;
    }

    private Field getDeclaredFieldRecursive(Class<?> cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            return getDeclaredFieldRecursive(cls.getSuperclass(), str);
        }
    }

    private Set<String> getFileNameByPackageName(Context context) throws Exception {
        HashSet hashSet = new HashSet();
        ClassLoader classLoader = context.getClassLoader();
        Field declaredFieldRecursive = getDeclaredFieldRecursive(classLoader.getClass(), "pathList");
        declaredFieldRecursive.setAccessible(true);
        Object obj = declaredFieldRecursive.get(classLoader);
        Field declaredFieldRecursive2 = getDeclaredFieldRecursive(obj.getClass(), "dexElements");
        declaredFieldRecursive2.setAccessible(true);
        for (Object obj2 : (Object[]) declaredFieldRecursive2.get(obj)) {
            Field declaredFieldRecursive3 = getDeclaredFieldRecursive(obj2.getClass(), "dexFile");
            declaredFieldRecursive3.setAccessible(true);
            Enumeration<String> enumerationEntries = ((DexFile) declaredFieldRecursive3.get(obj2)).entries();
            while (enumerationEntries.hasMoreElements()) {
                String strNextElement = enumerationEntries.nextElement();
                if (strNextElement.startsWith(Consts.ROUTE_ROOT_PAKCAGE)) {
                    hashSet.add(strNextElement);
                }
            }
        }
        return hashSet;
    }

    private void killApp() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        int i = SharedUtils.getInt(this.application, "ARouter map error times", 0);
        if (i > 1) {
            AppToastUtils.showLongNegativeTipToast(this.application, "Sorry, some unexpected errors occurred, please uninstall the app and go to the store to download the latest version.");
            new CountDownTimer(3000L, 1000L) { // from class: com.sandboxol.center.router.module_application.BaseModuleApp.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
                    Process.killProcess(Process.myPid());
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                }
            }.start();
        } else {
            SharedUtils.putInt(this.application, "ARouter map error times", i + 1);
            Process.killProcess(Process.myPid());
        }
    }

    private void makeNewARouterMap() {
        Set<String> fileNameByPackageName;
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        try {
            fileNameByPackageName = ClassUtils.getFileNameByPackageName(this.application, Consts.ROUTE_ROOT_PAKCAGE);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            fileNameByPackageName = null;
        } catch (IOException e3) {
            e3.printStackTrace();
            fileNameByPackageName = null;
        } catch (InterruptedException e4) {
            e4.printStackTrace();
            fileNameByPackageName = null;
        } catch (NullPointerException e5) {
            e5.printStackTrace();
            if (this.application == null) {
                Process.killProcess(Process.myPid());
            }
            fileNameByPackageName = null;
        }
        if (fileNameByPackageName == null || fileNameByPackageName.isEmpty()) {
            resetARouterMap();
            return;
        }
        this.application.getSharedPreferences(Consts.AROUTER_SP_CACHE_KEY, 0).edit().putStringSet(Consts.AROUTER_SP_KEY_MAP, fileNameByPackageName).apply();
        PackageUtils.updateVersion(this.application);
        try {
            ARouter.init(this.application);
        } catch (Exception e6) {
            e6.printStackTrace();
            resetARouterMap();
        }
    }

    private void resetARouterMap() {
        String path = this.application.getDir("", 0).getPath();
        if (!TextUtils.isEmpty(path) && path.endsWith("app_")) {
            path = path.replace("app_", "shared_prefs");
        }
        File file = new File(path, "SP_AROUTER_CACHE.xml");
        if (file.exists()) {
            file.delete();
        }
        killApp();
    }

    private void updateRouterClass(Context context) {
        if (PackageUtils.isNewVersion(context)) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Set<String> fileNameByPackageName = getFileNameByPackageName(context);
                if (!fileNameByPackageName.isEmpty()) {
                    context.getSharedPreferences(Consts.AROUTER_SP_CACHE_KEY, 0).edit().putStringSet(Consts.AROUTER_SP_KEY_MAP, fileNameByPackageName).apply();
                }
                PackageUtils.updateVersion(context);
                Log.i("ARouter::", "Find router map save finished, map size = " + fileNameByPackageName.size() + ", cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String getApplicationId() {
        return TextUtils.isEmpty(this.applicationId) ? "" : this.applicationId;
    }

    public String getBlockmanOrganizeTeam() {
        return TextUtils.isEmpty(this.blockmanOrganizeTeam) ? "" : this.blockmanOrganizeTeam;
    }

    public boolean getIsBeta() {
        return this.isBeta;
    }

    public Boolean getIsCopyV1ToV2() {
        return Boolean.valueOf(this.isCopyV1ToV2);
    }

    public String getMetaDataActivityId() {
        return TextUtils.isEmpty(this.activityId) ? "" : this.activityId;
    }

    public String getMetaDataAdmobInterstitialKey() {
        return TextUtils.isEmpty(this.admobInterstitialKey) ? "" : this.admobInterstitialKey;
    }

    public String getMetaDataAdmobKey() {
        return TextUtils.isEmpty(this.admobKey) ? "" : this.admobKey;
    }

    public String getMetaDataAdmobVideoKey() {
        return TextUtils.isEmpty(this.admobVideoKey) ? "" : this.admobVideoKey;
    }

    public String getMetaDataAdsSources() {
        return TextUtils.isEmpty(this.adsSources) ? AdsSourcesType.IRONSOURCE : this.adsSources;
    }

    public String getMetaDataBroadcastType() {
        return TextUtils.isEmpty(this.broadcastType) ? "com.disabngo.blockynexus" : this.broadcastType;
    }

    public String getMetaDataChannelId() {
        return TextUtils.isEmpty(this.channelId) ? "" : this.channelId;
    }

    public String getMetaDataDownloadSdk() {
        return TextUtils.isEmpty(this.downloadSdk) ? "RxDownload4" : this.downloadSdk;
    }

    public String getMetaDataEventType() {
        return TextUtils.isEmpty(this.eventType) ? "umeng" : this.eventType;
    }

    public String getMetaDataGoogleKey() {
        return TextUtils.isEmpty(this.googleKey) ? "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArZ1Y9l2zkLi6NlDlj89wU/zKhqo30+4Rv+JbKL878c3Oe+ZgvtE9+njdD8Yx3b5mZ91G8ZEDcgOB9WztUDPd/PoqDZmY7dH97IyLM5UpZYMbtFG+8oauK/SO2ic+dINNH9pvBKeFqw2Iud71/8cNXUx6IrlY9f+PqhSN34R70NyC+rTIhG56KZCDEXrU9YTx+aL0ggM/BD+miZKyflkqq1OTOG5U2fDAyiqmbOgxGPDIq8BjV5Y6MCZcnYa7xWQrGH+MIilYXomUuoO4Yh/BtMrAECnBfs5ppXwL0WMDY3aBaZlS4uMiebJJ9Dp9rXBPNlYsPwTz0/FE1NWN+wO24wIDAQAB" : this.googleKey;
    }

    public String getMetaDataIronsourceKey() {
        return TextUtils.isEmpty(this.ironsourceKey) ? "" : this.ironsourceKey;
    }

    public boolean getMetaDataIsChina() {
        return this.isChina;
    }

    public boolean getMetaDataIsPackNewEngineRes() {
        return this.isPackNewEngineRes;
    }

    public String getMetaDataPackageName() {
        return TextUtils.isEmpty(this.packageName) ? "blockymods" : this.packageName;
    }

    public String getMetaDataPackageType() {
        return TextUtils.isEmpty(this.packageType) ? "Blockymods" : this.packageType;
    }

    public String getMetaDataTalkingDataKey() {
        return TextUtils.isEmpty(this.talkingDataKey) ? "" : this.talkingDataKey;
    }

    public String getMetaDataUmKey() {
        return TextUtils.isEmpty(this.UmKey) ? "5c7894220cafb2931200065c" : this.UmKey;
    }

    public String getPayUrl() {
        return TextUtils.isEmpty(this.payUrl) ? "" : this.payUrl;
    }

    @Deprecated
    public String getThirdPartPayUrl() {
        return TextUtils.isEmpty(this.thirdPartPayUrl) ? "" : this.thirdPartPayUrl;
    }

    public boolean isOpenMtp() {
        return this.isOpenMtp;
    }

    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onCreate(Application application) {
        this.application = application;
        baseModuleApp = this;
        try {
            updateRouterClass(application);
            ARouter.init(application);
        } catch (Exception e2) {
            Log.e("BaseModuleApp", "Call ARouter init throws Exception" + e2.toString());
            makeNewARouterMap();
        }
    }

    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onDestroy(Application application) {
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setAdmobInterstitialKey(String str) {
        this.admobInterstitialKey = str;
    }

    public void setAdmobKey(String str) {
        this.admobKey = str;
    }

    public void setAdmobVideoKey(String str) {
        this.admobVideoKey = str;
    }

    public void setAdsSources(String str) {
        this.adsSources = str;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public void setBeta(boolean z) {
        this.isBeta = z;
    }

    public void setBlockmanOrganizeTeam(String str) {
        this.blockmanOrganizeTeam = str;
    }

    public void setBroadcastType(String str) {
        this.broadcastType = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setChina(boolean z) {
        this.isChina = z;
    }

    public void setCopyV1ToV2(boolean z) {
        this.isCopyV1ToV2 = z;
    }

    public void setDownloadSdk(String str) {
        this.downloadSdk = str;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public void setGoogleKey(String str) {
        this.googleKey = str;
    }

    public void setIronsourceKey(String str) {
        this.ironsourceKey = str;
    }

    public void setIsPackNewEngineRes(boolean z) {
        this.isPackNewEngineRes = z;
    }

    public void setOpenMtp(boolean z) {
        this.isOpenMtp = z;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPackageType(String str) {
        this.packageType = str;
    }

    public void setPayUrl(String str) {
        this.payUrl = str;
    }

    public void setTalkingDataKey(String str) {
        this.talkingDataKey = str;
    }

    @Deprecated
    public void setThirdPartPayUrl(String str) {
        this.thirdPartPayUrl = str;
    }

    public void setUmKey(String str) {
        this.UmKey = str;
    }
}
