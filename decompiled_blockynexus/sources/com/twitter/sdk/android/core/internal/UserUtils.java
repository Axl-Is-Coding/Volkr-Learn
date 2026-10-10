package com.twitter.sdk.android.core.internal;

import android.text.TextUtils;
import com.twitter.sdk.android.core.models.User;

/* JADX INFO: loaded from: classes5.dex */
public final class UserUtils {

    public enum AvatarSize {
        NORMAL("_normal"),
        BIGGER("_bigger"),
        MINI("_mini"),
        ORIGINAL("_original"),
        REASONABLY_SMALL("_reasonably_small");

        private final String suffix;

        AvatarSize(String str) {
            this.suffix = str;
        }

        String getSuffix() {
            return this.suffix;
        }
    }

    public static String a(User user, AvatarSize avatarSize) {
        String str;
        if (user == null || (str = user.profileImageUrlHttps) == null) {
            return null;
        }
        if (avatarSize == null || str == null) {
            return str;
        }
        int i = o.f20184a[avatarSize.ordinal()];
        return (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) ? str.replace(AvatarSize.NORMAL.getSuffix(), avatarSize.getSuffix()) : str;
    }

    public static CharSequence a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        if (charSequence.charAt(0) == '@') {
            return charSequence;
        }
        return "@" + ((Object) charSequence);
    }
}
