package io.rong.imlib.model;

import com.umeng.analytics.pro.au;
import io.rong.common.RLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class UserOnlineStatusInfoList {
    private static final String TAG = "UserOnlineStatusInfoList";
    private ArrayList<UserOnlineStatusInfo> userStatusInfoList = new ArrayList<>();

    public UserOnlineStatusInfoList(String str) {
        ArrayList<UserOnlineStatusInfo> arrayList = this.userStatusInfoList;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("us");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(au.aw);
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                    this.userStatusInfoList.add(new UserOnlineStatusInfo(jSONObjectOptJSONObject, 0));
                } else {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        UserOnlineStatusInfo userOnlineStatusInfo = new UserOnlineStatusInfo(jSONObjectOptJSONObject, i2);
                        if (this.userStatusInfoList != null) {
                            this.userStatusInfoList.add(userOnlineStatusInfo);
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            RLog.e(TAG, TAG, e2);
        }
    }

    public ArrayList<UserOnlineStatusInfo> getList() {
        return this.userStatusInfoList;
    }
}
