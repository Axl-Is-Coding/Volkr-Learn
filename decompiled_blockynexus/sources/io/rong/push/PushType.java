package io.rong.push;

import android.text.TextUtils;
import com.google.firebase.messaging.FirebaseMessaging;

/* JADX INFO: loaded from: classes5.dex */
public enum PushType {
    UNKNOWN("UNKNOWN"),
    RONG("RONG"),
    HUAWEI("HW"),
    XIAOMI("MI"),
    GOOGLE_FCM(FirebaseMessaging.INSTANCE_ID_SCOPE),
    GOOGLE_GCM("GCM"),
    MEIZU("MEIZU"),
    VIVO("VIVO"),
    OPPO("OPPO");

    private String name;

    PushType(String str) {
        this.name = str;
    }

    public static PushType getType(String str) {
        if (TextUtils.isEmpty(str)) {
            return RONG;
        }
        for (PushType pushType : values()) {
            if (pushType.getName().equals(str)) {
                return pushType;
            }
        }
        return RONG;
    }

    public String getName() {
        return this.name;
    }
}
