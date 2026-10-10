package com.sandboxol.mtp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.moduleApi.IMtpService;
import com.sandboxol.center.router.moduleInfo.mtp.ShareConstant;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.mtp.config.BlackList;
import com.sandboxol.mtp.config.EventConstant;
import com.tencent.tersafe2.TP2Sdk;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterServicePath.EventMtp.MTP_SERVICE)
public class MtpService implements IMtpService {
    public static final String TAG = "com.sandboxol.mtp.MtpService";

    static /* synthetic */ void b(Boolean bool) {
        if (bool.booleanValue()) {
            try {
                printResult(TP2Sdk.onAppPause(), "onPause");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static /* synthetic */ void c(Boolean bool) {
        if (bool.booleanValue()) {
            try {
                printResult(TP2Sdk.onAppResume(), "onResume");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static /* synthetic */ void d(Boolean bool) {
        if (bool.booleanValue()) {
            Log.i(TAG, "testConfig: " + TP2Sdk.ioctl("GetSDKInterfaceChkState"));
        }
    }

    private static String encryptionMD5(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            for (int i = 0; i < bArrDigest.length; i++) {
                if (Integer.toHexString(bArrDigest[i] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private static List<String> getBlackList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BlackList.COM_CLAROECUADOR_MICLARO);
        arrayList.add(BlackList.BR_COM_NEXTEL_ECOMMERCE);
        arrayList.add(BlackList.CATCH_ME_IF_YOU_CAN);
        arrayList.add(BlackList.COM_FJHYBBJFJJURYHUUIK_P);
        arrayList.add(BlackList.COM_D_ESQVXO_FAAZILBI);
        arrayList.add(BlackList.COM_LANDLORDGAME_TYCOON);
        arrayList.add(BlackList.COM_HACKGAMING);
        arrayList.add(BlackList.COM_VNPQK);
        arrayList.add(BlackList.COM_CRI_SMARTAD);
        arrayList.add(BlackList.COM_OTECEL_B_2_B_MI_MOVISTAR);
        arrayList.add(BlackList.COM_OTECEL_MIMOVISTAR);
        arrayList.add(BlackList.COM_GMG_ID);
        arrayList.add(BlackList.COM_BDLR_SQ_CFHGQWWXMSKA);
        arrayList.add(BlackList.COM_SURCUMFERENCE_XSPOSED);
        arrayList.add(BlackList.COM_SKZFUEIMAIVBTP);
        arrayList.add(BlackList.COM_JOL);
        arrayList.add(BlackList.COM_UCWFGHIKF);
        arrayList.add(BlackList.COM_WOKVMXSEFM);
        arrayList.add(BlackList.COM_GFBHFKFWVBHT);
        arrayList.add(BlackList.COM_BMWDWGOCFADECYMDKGLU);
        arrayList.add(BlackList.COM_YMP);
        arrayList.add(BlackList.CF_ANDROEFI_XENONE);
        return arrayList;
    }

    private static void printResult(int i, String str) {
        if (i == 0) {
            Log.i(TAG, str + ": successful");
            return;
        }
        Log.i(TAG, str + ": failed, error code is " + i);
    }

    public /* synthetic */ void a(final int i, final String str, final Subscriber subscriber) {
        isOpenMtp(new Action1() { // from class: com.sandboxol.mtp.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MtpService.a(i, str, subscriber, (Boolean) obj);
            }
        });
        subscriber.onCompleted();
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public void addReceiver() {
        isOpenMtp(new Action1() { // from class: com.sandboxol.mtp.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MtpService.a((Boolean) obj);
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public String getApkSignMd5Str() {
        try {
            return encryptionMD5(BaseApplication.getContext().getPackageManager().getPackageInfo(BaseApplication.getContext().getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public String getDescriptionById(String str) {
        if (str.contains("id=1")) {
            return "检测到外挂:触发2选1";
        }
        if (str.contains("id=2")) {
            return "安全列表权限被禁止:2选1失效";
        }
        if (str.contains("id=3")) {
            return "修改器检测:内存被读写";
        }
        if (str.contains("id=4")) {
            return "反调试检测:反调试系统异常";
        }
        if (str.contains("id=5")) {
            return "S级虚拟机检测";
        }
        if (str.contains("id=6")) {
            return "虚拟机检测";
        }
        if (str.contains("id=7")) {
            return "变速器检测";
        }
        if (str.contains("id=8")) {
            return "模拟器检测:模拟器里运行";
        }
        if (str.contains("id=11")) {
            return "so被替换";
        }
        if (str.contains("id=12")) {
            return "可疑的安装应用";
        }
        return "其他" + str;
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public String getMtpMd5(String str) {
        for (String str2 : str.split("\\|")) {
            if (str2.contains("cert_md5")) {
                return str2;
            }
        }
        return "empty";
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public void initGameMTP(final int i, final String str, final Action0 action0) {
        try {
            Observable.create(new Observable.OnSubscribe() { // from class: com.sandboxol.mtp.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f18799a.a(i, str, (Subscriber) obj);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() { // from class: com.sandboxol.mtp.MtpService.1
                @Override // rx.Observer
                public void onCompleted() {
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                }

                @Override // rx.Observer
                public void onNext(Integer num) {
                    if (num.intValue() == 0) {
                        action0.call();
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public Boolean isInBlackList(String str) {
        for (String str2 : getBlackList()) {
            if (str.contains(str2)) {
                ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.MTP_INFO_FORCE_CRASH_REASON, "force crash reason --" + str2);
                ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.MTP_INFO_FORCE_CRASH_REASON_WITH_ID, AccountCenter.newInstance().userId.get() + "force crash reason --" + str2);
                return true;
            }
        }
        Iterator<String> it = AppInfoCenter.newInstance().getAppConfig().getTempMTPBlackList().iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public void isOpenMtp(final Action1<Boolean> action1) {
        MultiProcessSharedUtils.getBoolean(BaseApplication.getContext(), ShareConstant.KEY_MTP_STATUS, new Action1() { // from class: com.sandboxol.mtp.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MtpService.a(action1, (Boolean) obj);
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public void loginGameMTP(final int i, final int i2, final String str, final String str2) {
        isOpenMtp(new Action1() { // from class: com.sandboxol.mtp.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MtpService.a(i, i2, str, str2, (Boolean) obj);
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public void onAppPause() {
        isOpenMtp(new Action1() { // from class: com.sandboxol.mtp.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MtpService.b((Boolean) obj);
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public void onAppResume() {
        isOpenMtp(new Action1() { // from class: com.sandboxol.mtp.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MtpService.c((Boolean) obj);
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public void setOpenMtp(boolean z) {
        MultiProcessSharedUtils.putBoolean(BaseApplication.getContext(), ShareConstant.KEY_MTP_STATUS, z);
    }

    @Override // com.sandboxol.center.router.moduleApi.IMtpService
    public void testConfig() {
        isOpenMtp(new Action1() { // from class: com.sandboxol.mtp.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MtpService.d((Boolean) obj);
            }
        });
    }

    static /* synthetic */ void a(int i, String str, Subscriber subscriber, Boolean bool) {
        if (bool.booleanValue()) {
            int iInitEx = TP2Sdk.initEx(i, str);
            printResult(iInitEx, "init");
            if (iInitEx == 0) {
                subscriber.onNext(Integer.valueOf(iInitEx));
            }
        }
    }

    static /* synthetic */ void a(int i, int i2, String str, String str2, Boolean bool) {
        if (bool.booleanValue()) {
            try {
                printResult(TP2Sdk.onUserLogin(i, i2, str, str2), FirebaseAnalytics.Event.LOGIN);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            try {
                TP2Sdk.registTssInfoReceiver(new TssInfoReceiver());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(Action1 action1, Boolean bool) {
        if (bool.booleanValue() && BaseModuleApp.getBaseModuleApp().isOpenMtp()) {
            if (action1 != null) {
                action1.call(true);
            }
        } else if (action1 != null) {
            action1.call(false);
        }
    }
}
