package io.rong.imkit.plugin.location;

import com.facebook.internal.AnalyticsEvents;
import io.rong.common.RLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AMapLocationParser {
    private static final String TAG = "AMapLocationParser";

    public AMapLocationInfo parserApsJsonResp(String str) {
        JSONObject jSONObject;
        if (str == null) {
            return null;
        }
        AMapLocationInfo aMapLocationInfo = new AMapLocationInfo();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            RLog.e(TAG, "parserApsJsonResp", e2);
        }
        if ("0".equals(jSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS))) {
            aMapLocationInfo.setErrorInfo(jSONObject.optString("info"));
            aMapLocationInfo.setErrorCode(Integer.parseInt(jSONObject.optString("infocode")));
            return aMapLocationInfo;
        }
        aMapLocationInfo.setErrorCode(0);
        aMapLocationInfo.setErrorInfo("success");
        aMapLocationInfo.setRetype(jSONObject.optString("retype"));
        aMapLocationInfo.setRdesc(jSONObject.optString("rdesc"));
        aMapLocationInfo.setAdcode(jSONObject.optString("adcode"));
        aMapLocationInfo.setCitycode(jSONObject.optString("citycode"));
        aMapLocationInfo.setCoord(jSONObject.optString("coord"));
        aMapLocationInfo.setDesc(jSONObject.optString("desc"));
        aMapLocationInfo.setTime(jSONObject.optLong("apiTime"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("location");
        if (jSONObjectOptJSONObject != null) {
            aMapLocationInfo.setAccuracy((float) jSONObjectOptJSONObject.optDouble("radius"));
            aMapLocationInfo.setLon(jSONObjectOptJSONObject.optDouble("cenx"));
            aMapLocationInfo.setLat(jSONObjectOptJSONObject.optDouble("ceny"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("revergeo");
        if (jSONObjectOptJSONObject2 != null) {
            aMapLocationInfo.setCountry(jSONObjectOptJSONObject2.optString("country"));
            aMapLocationInfo.setProvince(jSONObjectOptJSONObject2.optString("province"));
            aMapLocationInfo.setCity(jSONObjectOptJSONObject2.optString("city"));
            aMapLocationInfo.setDistrict(jSONObjectOptJSONObject2.optString("district"));
            aMapLocationInfo.setRoad(jSONObjectOptJSONObject2.optString("road"));
            aMapLocationInfo.setStreet(jSONObjectOptJSONObject2.optString("street"));
            aMapLocationInfo.setNumber(jSONObjectOptJSONObject2.optString("number"));
            aMapLocationInfo.setPoiname(jSONObjectOptJSONObject2.optString("poiname"));
            aMapLocationInfo.setAoiname(jSONObjectOptJSONObject2.optString("aoiname"));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("indoor");
        if (jSONObjectOptJSONObject3 != null) {
            aMapLocationInfo.setPoiid(jSONObjectOptJSONObject3.optString("pid"));
            aMapLocationInfo.setFloor(jSONObjectOptJSONObject3.optString("flr"));
        }
        return aMapLocationInfo;
    }
}
