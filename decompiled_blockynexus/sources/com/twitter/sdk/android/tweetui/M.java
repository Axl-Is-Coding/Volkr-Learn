package com.twitter.sdk.android.tweetui;

import android.net.Uri;
import android.text.TextUtils;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.User;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: TweetUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class M {
    static com.twitter.sdk.android.core.models.m a(com.twitter.sdk.android.core.models.m mVar) {
        com.twitter.sdk.android.core.models.m mVar2;
        return (mVar == null || (mVar2 = mVar.y) == null) ? mVar : mVar2;
    }

    static boolean b(com.twitter.sdk.android.core.models.m mVar) {
        User user;
        return (mVar == null || mVar.i <= 0 || (user = mVar.D) == null || TextUtils.isEmpty(user.screenName)) ? false : true;
    }

    static boolean c(com.twitter.sdk.android.core.models.m mVar) {
        com.twitter.sdk.android.core.models.o oVar;
        List<MediaEntity> list;
        return mVar.v != null && mVar.H == null && ((oVar = mVar.f20241d) == null || (list = oVar.f20253d) == null || list.isEmpty());
    }

    static Uri a(String str, long j) {
        if (j <= 0) {
            return null;
        }
        return Uri.parse(TextUtils.isEmpty(str) ? String.format(Locale.US, "https://twitter.com/%s/status/%d?ref_src=twsrc%%5Etwitterkit", "twitter_unknown", Long.valueOf(j)) : String.format(Locale.US, "https://twitter.com/%s/status/%d?ref_src=twsrc%%5Etwitterkit", str, Long.valueOf(j)));
    }

    static String b(String str) {
        return TextUtils.isEmpty(str) ? String.format(Locale.US, "https://twitter.com/%s?ref_src=twsrc%%5Etwitterkit", "twitter_unknown") : String.format(Locale.US, "https://twitter.com/%s?ref_src=twsrc%%5Etwitterkit", str);
    }

    static String c(String str) {
        return String.format(Locale.US, "https://twitter.com/search?q=%%24%s&ref_src=twsrc%%5Etwitterkit", str);
    }

    static String a(String str) {
        return String.format(Locale.US, "https://twitter.com/hashtag/%s?ref_src=twsrc%%5Etwitterkit", str);
    }
}
