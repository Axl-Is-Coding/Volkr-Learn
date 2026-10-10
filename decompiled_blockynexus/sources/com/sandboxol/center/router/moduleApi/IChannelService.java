package com.sandboxol.center.router.moduleApi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener;

/* JADX INFO: loaded from: classes3.dex */
public interface IChannelService extends IBaseService {
    void facebookLogin(Context context, ILoginListener iLoginListener);

    void googleLogin(Activity activity);

    void handleSignInResult(Intent intent, Context context, ILoginListener iLoginListener);

    void initThirdPartySdk(Context context);

    boolean isBeta();

    boolean isHasGoogleService(Context context);

    void onActivityResult(int i, int i2, Intent intent);

    void onFacebookShare(Activity activity, String str, String str2, Uri uri);

    void onGooglePayDestroy(Context context);

    void onGooglePayRegister(Context context);

    void onGooglePayResume(Context context);

    void onGooglePlusShare(Activity activity, String str, String str2, Uri uri);

    void onTwitterShare(Context context, String str, String str2, Uri uri);

    void startGooglePayActivity(Context context, String str, String str2, String str3);

    void startGooglePayActivity(Context context, String str, String str2, String str3, String str4);

    void twitterLogin(Context context, ILoginListener iLoginListener);
}
