package com.facebook.appevents.restrictivedatafilter;

import cn.qqtheme.framework.widget.WheelView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.ml.Model;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class AddressFilterManager {
    private static boolean enabled;
    private static boolean isSampleEnabled;

    public static void enable() {
        enabled = true;
        isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureAddressDetectionSample", FacebookSdk.getApplicationId(), false);
    }

    public static void processParameters(Map<String, String> map) {
        if (!enabled || map.size() == 0) {
            return;
        }
        try {
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            JSONObject jSONObject = new JSONObject();
            for (String str : arrayList) {
                String str2 = map.get(str);
                if (shouldFilterKey(str2)) {
                    map.remove(str);
                    if (!isSampleEnabled) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                }
            }
            if (jSONObject.length() != 0) {
                map.put("_onDeviceParams", jSONObject.toString());
            }
        } catch (Exception unused) {
        }
    }

    private static boolean shouldFilterKey(String str) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, WheelView.DividerConfig.FILL);
        String strPredict = ModelManager.predict(ModelManager.MODEL_ADDRESS_DETECTION, fArr, str);
        return strPredict != null && strPredict.equals(Model.SHOULD_FILTER);
    }
}
