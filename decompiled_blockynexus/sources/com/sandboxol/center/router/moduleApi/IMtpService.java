package com.sandboxol.center.router.moduleApi;

import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public interface IMtpService extends IBaseService {
    void addReceiver();

    String getApkSignMd5Str();

    String getDescriptionById(String str);

    String getMtpMd5(String str);

    void initGameMTP(int i, String str, Action0 action0);

    Boolean isInBlackList(String str);

    void isOpenMtp(Action1<Boolean> action1);

    void loginGameMTP(int i, int i2, String str, String str2);

    void onAppPause();

    void onAppResume();

    void setOpenMtp(boolean z);

    void testConfig();
}
