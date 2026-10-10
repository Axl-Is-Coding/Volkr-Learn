package com.sandboxol.center.router.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IChannelService;
import com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes.dex */
public class ChannelManager {
    private static IChannelService iChannelService = (IChannelService) RouteServiceManager.provide(RouterServicePath.EventChannel.CHANNEL_SERVICE);

    public static void facebookLogin(Context context, ILoginListener iLoginListener) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.facebookLogin(context, iLoginListener);
        }
    }

    public static void googleLogin(Activity activity) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.googleLogin(activity);
        }
    }

    public static void handleSignInResult(Intent intent, Context context, ILoginListener iLoginListener) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.handleSignInResult(intent, context, iLoginListener);
        }
    }

    public static void init(Context context) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.initThirdPartySdk(context);
        }
    }

    public static boolean isBeta() {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            return iChannelService2.isBeta();
        }
        return false;
    }

    public static boolean isHasGoogleService(Context context) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            return iChannelService2.isHasGoogleService(context);
        }
        return false;
    }

    public static void onActivityResult(int i, int i2, Intent intent) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.onActivityResult(i, i2, intent);
        }
    }

    public static void onFacebookShare(Activity activity, String str, String str2, Uri uri) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.onFacebookShare(activity, str, str2, uri);
        }
    }

    public static void onGooglePayDestroy(Context context) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.onGooglePayDestroy(context);
        }
    }

    public static void onGooglePayRegister(Context context) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.onGooglePayRegister(context);
        }
    }

    public static void onGooglePayResume(Context context) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.onGooglePayResume(context);
        }
    }

    public static void onGooglePlusShare(Activity activity, String str, String str2, Uri uri) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.onGooglePlusShare(activity, str, str2, uri);
        }
    }

    public static void onTwitterShare(Context context, String str, String str2, Uri uri) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.onTwitterShare(context, str, str2, uri);
        }
    }

    public static void startGooglePayActivity(Context context, String str, String str2, String str3) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.startGooglePayActivity(context, str, str2, str3);
        }
    }

    public static void twitterLogin(Context context, ILoginListener iLoginListener) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.twitterLogin(context, iLoginListener);
        }
    }

    public static void startGooglePayActivity(Context context, String str, String str2, String str3, String str4) {
        IChannelService iChannelService2 = iChannelService;
        if (iChannelService2 != null) {
            iChannelService2.startGooglePayActivity(context, str, str2, str3, str4);
        }
    }
}
