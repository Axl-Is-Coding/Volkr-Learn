package io.rong.push.pushconfig;

import android.text.TextUtils;
import io.rong.push.PushType;
import io.rong.push.common.RLog;
import io.rong.push.core.PushUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class PushConfig {
    private static final String TAG = "PushConfig";
    private String appKey;
    private Set<PushType> enabledPushTypes;
    private String miAppId;
    private String miAppKey;
    private String mzAppId;
    private String mzAppKey;
    private String oppoAppKey;
    private String oppoAppSecret;
    private String pushNaviAddress;

    public static class Builder {
        private String appKey;
        private Set<PushType> enabledPushTypes = new LinkedHashSet();
        private String miAppId;
        private String miAppKey;
        private String mzAppId;
        private String mzAppKey;
        private String oppoAppKey;
        private String oppoAppSecret;
        private String pushNaviAddress;

        public PushConfig build() {
            PushConfig pushConfig = new PushConfig();
            pushConfig.miAppId = this.miAppId;
            pushConfig.miAppKey = this.miAppKey;
            pushConfig.mzAppId = this.mzAppId;
            pushConfig.mzAppKey = this.mzAppKey;
            pushConfig.oppoAppKey = this.oppoAppKey;
            pushConfig.oppoAppSecret = this.oppoAppSecret;
            pushConfig.enabledPushTypes = this.enabledPushTypes;
            this.enabledPushTypes.add(PushType.RONG);
            pushConfig.appKey = this.appKey;
            pushConfig.pushNaviAddress = this.pushNaviAddress;
            return pushConfig;
        }

        public Builder enableFCM(boolean z) {
            if (z) {
                if (this.enabledPushTypes.contains(PushType.GOOGLE_GCM)) {
                    RLog.e(PushConfig.TAG, "the push types of GOOGLE_FCM and GOOGLE_GCM can only enable one.");
                } else {
                    this.enabledPushTypes.add(PushType.GOOGLE_FCM);
                }
            }
            return this;
        }

        public Builder enableGCM(boolean z) {
            if (z) {
                if (this.enabledPushTypes.contains(PushType.GOOGLE_FCM)) {
                    RLog.e(PushConfig.TAG, "the push types of GOOGLE_GCM and GOOGLE_FCM can only enable one.");
                } else {
                    this.enabledPushTypes.add(PushType.GOOGLE_GCM);
                }
            }
            return this;
        }

        public Builder enableHWPush(boolean z) {
            if (z) {
                this.enabledPushTypes.add(PushType.HUAWEI);
            }
            return this;
        }

        public Builder enableMeiZuPush(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                RLog.e(PushConfig.TAG, "appid or appkey can't be empty when enable MEIZU push !");
                return this;
            }
            this.mzAppId = str;
            this.mzAppKey = str2;
            this.enabledPushTypes.add(PushType.MEIZU);
            return this;
        }

        public Builder enableMiPush(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                RLog.d(PushConfig.TAG, "appid or appkey can't be empty when enable MI push !");
                return this;
            }
            this.miAppId = str;
            this.miAppKey = str2;
            this.enabledPushTypes.add(PushType.XIAOMI);
            return this;
        }

        public Builder enableOppoPush(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                RLog.e(PushConfig.TAG, "appid or appkey can't be empty when enable OPPO push !");
                return this;
            }
            this.oppoAppKey = str;
            this.oppoAppSecret = str2;
            this.enabledPushTypes.add(PushType.OPPO);
            return this;
        }

        public Builder enableVivoPush(boolean z) {
            if (z) {
                this.enabledPushTypes.add(PushType.VIVO);
            }
            return this;
        }

        public Builder setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder setPushNaviAddress(String str) {
            this.pushNaviAddress = str;
            return this;
        }
    }

    public String getAppKey() {
        return this.appKey;
    }

    public Set<PushType> getEnabledPushTypes() {
        return this.enabledPushTypes;
    }

    public String getEncodedEnabledPushTypes() {
        StringBuilder sb = new StringBuilder();
        Iterator<PushType> it = this.enabledPushTypes.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getName());
            sb.append("|");
        }
        RLog.d(TAG, "enabledPushTypes:" + sb.toString());
        return sb.toString();
    }

    public String getMiAppId() {
        return this.miAppId;
    }

    public String getMiAppKey() {
        return this.miAppKey;
    }

    public String getMzAppId() {
        return this.mzAppId;
    }

    public String getMzAppKey() {
        return this.mzAppKey;
    }

    public String getOppoAppKey() {
        return this.oppoAppKey;
    }

    public String getOppoAppSecret() {
        return this.oppoAppSecret;
    }

    public String getPushDomain() {
        if (TextUtils.isEmpty(this.pushNaviAddress)) {
            this.pushNaviAddress = PushUtils.getDefaultNavi();
        }
        return this.pushNaviAddress;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setPushNaviAddress(String str) {
        this.pushNaviAddress = str;
    }
}
