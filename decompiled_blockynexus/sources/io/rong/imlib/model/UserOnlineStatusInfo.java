package io.rong.imlib.model;

import com.facebook.internal.AnalyticsEvents;
import com.umeng.analytics.pro.au;
import io.rong.common.RLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class UserOnlineStatusInfo {
    private static final String TAG = "UserOnlineStatusInfo";
    private int customerStatus;
    private PlatformInfo platform;
    private int serviceStatus;

    public enum PlatformInfo {
        Platform_Other(0),
        Platform_iOS(1),
        Platform_Android(2),
        Platform_Web(3),
        Platform_PC(4);

        private int code;

        PlatformInfo(int i) {
            this.code = i;
        }

        public int getValue() {
            return this.code;
        }

        public static PlatformInfo valueOf(int i) {
            for (PlatformInfo platformInfo : values()) {
                if (i == platformInfo.getValue()) {
                    return platformInfo;
                }
            }
            return Platform_Other;
        }
    }

    public UserOnlineStatusInfo(JSONObject jSONObject, int i) {
        try {
            this.serviceStatus = jSONObject.getInt("o");
            this.customerStatus = jSONObject.getInt(au.ax);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(au.aw);
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                this.platform = getPlatFormEnum(null);
            } else if (i < jSONArrayOptJSONArray.length()) {
                this.platform = getPlatFormEnum(jSONArrayOptJSONArray.optString(i));
            }
        } catch (JSONException e2) {
            RLog.e(TAG, TAG, e2);
        }
    }

    private PlatformInfo getPlatFormEnum(String str) {
        if (str == null) {
            return PlatformInfo.valueOf(0);
        }
        String lowerCase = str.toLowerCase();
        byte b2 = -1;
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -861391249) {
            if (iHashCode != 3571) {
                if (iHashCode != 104461) {
                    if (iHashCode == 117588 && lowerCase.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB)) {
                        b2 = 2;
                    }
                } else if (lowerCase.equals("ios")) {
                    b2 = 0;
                }
            } else if (lowerCase.equals("pc")) {
                b2 = 3;
            }
        } else if (lowerCase.equals("android")) {
            b2 = 1;
        }
        return b2 != 0 ? b2 != 1 ? b2 != 2 ? b2 != 3 ? PlatformInfo.valueOf(0) : PlatformInfo.valueOf(4) : PlatformInfo.valueOf(3) : PlatformInfo.valueOf(2) : PlatformInfo.valueOf(1);
    }

    public int getCustomerStatus() {
        return this.customerStatus;
    }

    public PlatformInfo getPlatform() {
        return this.platform;
    }

    public int getServiceStatus() {
        return this.serviceStatus;
    }
}
