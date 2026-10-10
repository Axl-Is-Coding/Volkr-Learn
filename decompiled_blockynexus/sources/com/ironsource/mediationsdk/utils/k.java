package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.model.PlacementCappingType;
import com.ironsource.mediationsdk.model.n;
import com.ironsource.mediationsdk.model.o;
import com.ironsource.mediationsdk.model.p;
import com.ironsource.mediationsdk.model.q;
import com.ironsource.mediationsdk.model.r;
import com.ironsource.mediationsdk.model.s;
import io.rong.imlib.common.RongLibConst;
import io.rong.imlib.statistics.UserData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ServerResponseWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {
    private o Ka;
    private q La;
    private com.ironsource.mediationsdk.model.g Ma;
    private String Na;
    private String Oa;
    private JSONObject Pa;
    private Context Qa;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15041a = "error";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15042b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15043c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15044d = 60;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15045e = 10000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15046f = 5000;
    private final int g = 300;
    private final int h = 3;
    private final int i = 3;
    private final int j = 2;
    private final int k = 15;
    private final long l = 10000;
    private final int m = 0;
    private final boolean n = false;
    private final int o = 30000;
    private final String p = "providerOrder";
    private final String q = "providerSettings";
    private final String r = "configurations";
    private final String s = "genericParams";
    private final String t = "adUnits";
    private final String u = "providerLoadName";
    private final String v = "application";
    private final String w = "rewardedVideo";
    private final String x = "interstitial";
    private final String y = "offerwall";
    private final String z = "banner";
    private final String A = "integration";
    private final String B = "loggers";
    private final String C = "segment";
    private final String D = com.umeng.analytics.pro.b.ao;
    private final String E = RongLibConst.KEY_TOKEN;
    private final String F = "maxNumOfAdaptersToLoadOnStart";
    private final String G = "advancedLoading";
    private final String H = "adapterTimeOutInSeconds";
    private final String I = "atim";
    private final String J = "bannerInterval";
    private final String K = "loadRVInterval";
    private final String L = "server";
    private final String M = "publisher";
    private final String N = "console";
    private final String O = "sendUltraEvents";
    private final String P = "sendEventsToggle";
    private final String Q = "serverEventsURL";
    private final String R = "serverEventsType";
    private final String S = "backupThreshold";
    private final String T = "maxNumberOfEvents";
    private final String U = "maxEventsPerBatch";
    private final String V = "optOut";
    private final String W = "optIn";
    private final String X = "triggerEvents";
    private final String Y = "nonConnectivityEvents";
    private final String Z = "placements";
    private final String aa = "placementId";
    private final String ba = "placementName";
    private final String ca = "delivery";
    private final String da = "isDefault";
    private final String ea = "capping";
    private final String fa = "pacing";
    private final String ga = "enabled";
    private final String ha = "maxImpressions";
    private final String ia = "numOfSeconds";
    private final String ja = "unit";
    private final String ka = "virtualItemName";
    private final String la = "virtualItemCount";
    private final String ma = "backFill";
    private final String na = "premium";
    private final String oa = "uuidEnabled";
    private final String pa = "abt";
    private final String qa = "delayLoadFailure";
    private final String ra = "adSourceName";
    private final String sa = "spId";
    private final String ta = "mpis";
    private final String ua = "auction";
    private final String va = "auctionData";
    private final String wa = "auctioneerURL";
    private final String xa = "programmatic";
    private final String ya = "minTimeBeforeFirstAuction";
    private final String za = "timeToWaitBeforeAuction";
    private final String Aa = "timeToWaitBeforeLoad";
    private final String Ba = "auctionRetryInterval";
    private final String Ca = "isAuctionOnShowStart";
    private final String Da = "isLoadWhileShow";
    private final String Ea = "auctionTrials";
    private final String Fa = "auctionTimeout";
    private final String Ga = "auctionSavedHistory";
    private final String Ha = "disableLoadWhileShowSupportFor";
    private final String Ia = "timeToDeleteOldWaterfallAfterAuction";
    private final String Ja = "optInKeys";

    public k(Context context, String str, String str2, String str3) {
        this.Qa = context;
        try {
            if (TextUtils.isEmpty(str3)) {
                this.Pa = new JSONObject();
            } else {
                this.Pa = new JSONObject(str3);
            }
            l();
            j();
            k();
            this.Na = TextUtils.isEmpty(str) ? "" : str;
            this.Oa = TextUtils.isEmpty(str2) ? "" : str2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            h();
        }
    }

    private boolean a(String str) {
        String strA = com.ironsource.environment.c.a(str);
        return this.La.a("Mediation") && (com.ironsource.environment.c.a("SupersonicAds").equals(strA) || com.ironsource.environment.c.a("IronSource").equals(strA));
    }

    private com.ironsource.mediationsdk.model.i c(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean("isDefault", false);
            com.ironsource.mediationsdk.model.n nVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                com.ironsource.mediationsdk.model.i iVar = new com.ironsource.mediationsdk.model.i(iOptInt, strOptString, zOptBoolean, nVarA);
                if (nVarA == null) {
                    return iVar;
                }
                CappingManager.a(this.Qa, iVar);
                return iVar;
            }
        }
        return null;
    }

    private com.ironsource.mediationsdk.model.k d(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean("isDefault", false);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                return new com.ironsource.mediationsdk.model.k(iOptInt, strOptString, zOptBoolean);
            }
        }
        return null;
    }

    private com.ironsource.mediationsdk.model.l e(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean("isDefault", false);
            String strOptString2 = jSONObject.optString("virtualItemName", "");
            int iOptInt2 = jSONObject.optInt("virtualItemCount", -1);
            com.ironsource.mediationsdk.model.n nVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && iOptInt2 > 0) {
                com.ironsource.mediationsdk.model.l lVar = new com.ironsource.mediationsdk.model.l(iOptInt, strOptString, zOptBoolean, strOptString2, iOptInt2, nVarA);
                if (nVarA == null) {
                    return lVar;
                }
                CappingManager.a(this.Qa, lVar);
                return lVar;
            }
        }
        return null;
    }

    private void h() {
        this.Pa = new JSONObject();
        this.Na = "";
        this.Oa = "";
        this.Ka = new o();
        this.La = q.b();
        this.Ma = new com.ironsource.mediationsdk.model.g();
    }

    private Context i() {
        return this.Qa;
    }

    private void j() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject;
        String str6;
        String str7;
        String str8;
        JSONObject jSONObject2;
        r rVar;
        String str9;
        String str10;
        String str11;
        JSONObject jSONObject3;
        String str12;
        com.ironsource.mediationsdk.model.h hVar;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        com.ironsource.mediationsdk.model.e eVar;
        String str19;
        com.ironsource.mediationsdk.model.j jVar;
        JSONObject jSONObjectA;
        JSONArray jSONArrayOptJSONArray;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        int[] iArr8;
        a aVar;
        int i;
        boolean z;
        int[] iArr9;
        int[] iArr10;
        int[] iArr11;
        int[] iArr12;
        a aVar2;
        int i2;
        boolean z2;
        int[] iArr13;
        int[] iArr14;
        int[] iArr15;
        int[] iArr16;
        a aVar3;
        try {
            JSONObject jSONObjectA2 = a(this.Pa, "configurations");
            JSONObject jSONObjectA3 = a(jSONObjectA2, "adUnits");
            JSONObject jSONObjectA4 = a(jSONObjectA2, "application");
            JSONObject jSONObjectA5 = a(jSONObjectA3, "rewardedVideo");
            JSONObject jSONObjectA6 = a(jSONObjectA3, "interstitial");
            JSONObject jSONObjectA7 = a(jSONObjectA3, "offerwall");
            JSONObject jSONObjectA8 = a(jSONObjectA3, "banner");
            JSONObject jSONObjectA9 = a(jSONObjectA4, com.umeng.analytics.pro.b.ao);
            JSONObject jSONObjectA10 = a(jSONObjectA4, "loggers");
            JSONObject jSONObjectA11 = a(jSONObjectA4, RongLibConst.KEY_TOKEN);
            JSONObject jSONObjectA12 = a(jSONObjectA4, "segment");
            JSONObject jSONObjectA13 = a(jSONObjectA4, "auction");
            if (jSONObjectA4 != null) {
                j.b(this.Qa, "uuidEnabled", jSONObjectA4.optBoolean("uuidEnabled", true));
            }
            if (jSONObjectA9 != null) {
                String strOptString = jSONObjectA9.optString("abt");
                if (!TextUtils.isEmpty(strOptString)) {
                    com.ironsource.mediationsdk.b.h.g().a(strOptString);
                    com.ironsource.mediationsdk.b.k.g().a(strOptString);
                }
            }
            if (jSONObjectA5 != null) {
                JSONArray jSONArrayOptJSONArray2 = jSONObjectA5.optJSONArray("placements");
                jSONObject = jSONObjectA8;
                JSONObject jSONObjectA14 = a(jSONObjectA5, com.umeng.analytics.pro.b.ao);
                str = com.umeng.analytics.pro.b.ao;
                str6 = "placements";
                int iA = a(jSONObjectA5, jSONObjectA4, "maxNumOfAdaptersToLoadOnStart", 2);
                int iA2 = a(jSONObjectA5, jSONObjectA4, "advancedLoading", 0);
                if (iA2 > 0) {
                    i2 = iA2;
                    z2 = true;
                } else {
                    i2 = iA;
                    z2 = false;
                }
                int iA3 = a(jSONObjectA5, jSONObjectA4, "adapterTimeOutInSeconds", 60);
                int iA4 = a(jSONObjectA5, jSONObjectA4, "loadRVInterval", 300);
                JSONObject jSONObjectA15 = j.a(jSONObjectA14, jSONObjectA9);
                boolean zOptBoolean = jSONObjectA15.optBoolean("sendUltraEvents", false);
                boolean zOptBoolean2 = jSONObjectA15.optBoolean("sendEventsToggle", false);
                String strOptString2 = jSONObjectA15.optString("serverEventsURL", "");
                String strOptString3 = jSONObjectA15.optString("serverEventsType", "");
                int iOptInt = jSONObjectA15.optInt("backupThreshold", -1);
                int iOptInt2 = jSONObjectA15.optInt("maxNumberOfEvents", -1);
                int iOptInt3 = jSONObjectA15.optInt("maxEventsPerBatch", 5000);
                JSONArray jSONArrayOptJSONArray3 = jSONObjectA15.optJSONArray("optOut");
                if (jSONArrayOptJSONArray3 != null) {
                    int[] iArr17 = new int[jSONArrayOptJSONArray3.length()];
                    str4 = "maxNumberOfEvents";
                    str5 = "backupThreshold";
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        iArr17[i3] = jSONArrayOptJSONArray3.optInt(i3);
                    }
                    iArr13 = iArr17;
                } else {
                    str4 = "maxNumberOfEvents";
                    str5 = "backupThreshold";
                    iArr13 = null;
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObjectA15.optJSONArray("optIn");
                if (jSONArrayOptJSONArray4 != null) {
                    int[] iArr18 = new int[jSONArrayOptJSONArray4.length()];
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        iArr18[i4] = jSONArrayOptJSONArray4.optInt(i4);
                    }
                    iArr14 = iArr18;
                } else {
                    iArr14 = null;
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectA15.optJSONArray("triggerEvents");
                if (jSONArrayOptJSONArray5 != null) {
                    int[] iArr19 = new int[jSONArrayOptJSONArray5.length()];
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                        iArr19[i5] = jSONArrayOptJSONArray5.optInt(i5);
                    }
                    iArr15 = iArr19;
                } else {
                    iArr15 = null;
                }
                JSONArray jSONArrayOptJSONArray6 = jSONObjectA15.optJSONArray("nonConnectivityEvents");
                if (jSONArrayOptJSONArray6 != null) {
                    int[] iArr20 = new int[jSONArrayOptJSONArray6.length()];
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                        iArr20[i6] = jSONArrayOptJSONArray6.optInt(i6);
                    }
                    iArr16 = iArr20;
                } else {
                    iArr16 = null;
                }
                com.ironsource.mediationsdk.model.c cVar = new com.ironsource.mediationsdk.model.c(zOptBoolean, zOptBoolean2, strOptString2, strOptString3, iOptInt, iOptInt2, iOptInt3, iArr13, iArr14, iArr15, iArr16);
                if (jSONObjectA13 != null) {
                    JSONObject jSONObjectA16 = a(jSONObjectA13, "rewardedVideo");
                    str7 = "";
                    jSONObject2 = jSONObjectA13;
                    str3 = "serverEventsType";
                    str2 = "serverEventsURL";
                    str8 = "sendEventsToggle";
                    aVar3 = new a(jSONObjectA13.optString("auctionData", ""), jSONObjectA13.optString("auctioneerURL", ""), jSONObjectA13.optInt("auctionTrials", 2), jSONObjectA13.optInt("auctionSavedHistory", 15), jSONObjectA13.optLong("auctionTimeout", 10000L), jSONObjectA16.optBoolean("programmatic", false), jSONObjectA16.optInt("minTimeBeforeFirstAuction", 2000), jSONObjectA16.optInt("auctionRetryInterval", 30000), jSONObjectA16.optInt("timeToWaitBeforeAuction", 5000), jSONObjectA16.optInt("timeToWaitBeforeLoad", 50), jSONObjectA16.optBoolean("isAuctionOnShowStart", false), jSONObjectA16.optBoolean("isLoadWhileShow", false), jSONObjectA16.optInt("timeToDeleteOldWaterfallAfterAuction", 30000));
                    JSONArray jSONArrayOptJSONArray7 = jSONObjectA16.optJSONArray("disableLoadWhileShowSupportFor");
                    if (jSONArrayOptJSONArray7 != null) {
                        for (int i7 = 0; i7 < jSONArrayOptJSONArray7.length(); i7++) {
                            aVar3.a(jSONArrayOptJSONArray7.optString(i7));
                        }
                    }
                } else {
                    str2 = "serverEventsURL";
                    str3 = "serverEventsType";
                    str7 = "";
                    str8 = "sendEventsToggle";
                    jSONObject2 = jSONObjectA13;
                    aVar3 = new a();
                }
                r rVar2 = new r(i2, z2, iA3, iA4, cVar, aVar3);
                if (jSONArrayOptJSONArray2 != null) {
                    for (int i8 = 0; i8 < jSONArrayOptJSONArray2.length(); i8++) {
                        com.ironsource.mediationsdk.model.l lVarE = e(jSONArrayOptJSONArray2.optJSONObject(i8));
                        if (lVarE != null) {
                            rVar2.a(lVarE);
                        }
                    }
                }
                String strOptString4 = jSONObjectA5.optString("backFill");
                if (!TextUtils.isEmpty(strOptString4)) {
                    rVar2.b(strOptString4);
                }
                String strOptString5 = jSONObjectA5.optString("premium");
                if (!TextUtils.isEmpty(strOptString5)) {
                    rVar2.c(strOptString5);
                }
                rVar = rVar2;
            } else {
                str = com.umeng.analytics.pro.b.ao;
                str2 = "serverEventsURL";
                str3 = "serverEventsType";
                str4 = "maxNumberOfEvents";
                str5 = "backupThreshold";
                jSONObject = jSONObjectA8;
                str6 = "placements";
                str7 = "";
                str8 = "sendEventsToggle";
                jSONObject2 = jSONObjectA13;
                rVar = null;
            }
            if (jSONObjectA6 != null) {
                str10 = str6;
                JSONArray jSONArrayOptJSONArray8 = jSONObjectA6.optJSONArray(str10);
                str9 = str;
                JSONObject jSONObjectA17 = a(jSONObjectA6, str9);
                int iA5 = a(jSONObjectA6, jSONObjectA4, "maxNumOfAdaptersToLoadOnStart", 2);
                int iA6 = a(jSONObjectA6, jSONObjectA4, "advancedLoading", 0);
                if (iA6 > 0) {
                    i = iA6;
                    z = true;
                } else {
                    i = iA5;
                    z = false;
                }
                int iA7 = a(jSONObjectA6, jSONObjectA4, "adapterTimeOutInSeconds", 60);
                int iA8 = a(jSONObjectA6, jSONObjectA4, "delayLoadFailure", 3);
                JSONObject jSONObjectA18 = j.a(jSONObjectA17, jSONObjectA9);
                str12 = str8;
                boolean zOptBoolean3 = jSONObjectA18.optBoolean(str12, false);
                String str20 = str2;
                String strOptString6 = jSONObjectA18.optString(str20, str7);
                String str21 = str3;
                String strOptString7 = jSONObjectA18.optString(str21, str7);
                String str22 = str5;
                int iOptInt4 = jSONObjectA18.optInt(str22, -1);
                str11 = str4;
                int iOptInt5 = jSONObjectA18.optInt(str11, -1);
                int iOptInt6 = jSONObjectA18.optInt("maxEventsPerBatch", 5000);
                JSONArray jSONArrayOptJSONArray9 = jSONObjectA18.optJSONArray("optOut");
                if (jSONArrayOptJSONArray9 != null) {
                    int[] iArr21 = new int[jSONArrayOptJSONArray9.length()];
                    str2 = str20;
                    str3 = str21;
                    for (int i9 = 0; i9 < jSONArrayOptJSONArray9.length(); i9++) {
                        iArr21[i9] = jSONArrayOptJSONArray9.optInt(i9);
                    }
                    iArr9 = iArr21;
                } else {
                    str2 = str20;
                    str3 = str21;
                    iArr9 = null;
                }
                JSONArray jSONArrayOptJSONArray10 = jSONObjectA18.optJSONArray("optIn");
                if (jSONArrayOptJSONArray10 != null) {
                    int[] iArr22 = new int[jSONArrayOptJSONArray10.length()];
                    for (int i10 = 0; i10 < jSONArrayOptJSONArray10.length(); i10++) {
                        iArr22[i10] = jSONArrayOptJSONArray10.optInt(i10);
                    }
                    iArr10 = iArr22;
                } else {
                    iArr10 = null;
                }
                JSONArray jSONArrayOptJSONArray11 = jSONObjectA18.optJSONArray("triggerEvents");
                if (jSONArrayOptJSONArray11 != null) {
                    int[] iArr23 = new int[jSONArrayOptJSONArray11.length()];
                    for (int i11 = 0; i11 < jSONArrayOptJSONArray11.length(); i11++) {
                        iArr23[i11] = jSONArrayOptJSONArray11.optInt(i11);
                    }
                    iArr11 = iArr23;
                } else {
                    iArr11 = null;
                }
                JSONArray jSONArrayOptJSONArray12 = jSONObjectA18.optJSONArray("nonConnectivityEvents");
                if (jSONArrayOptJSONArray12 != null) {
                    int[] iArr24 = new int[jSONArrayOptJSONArray12.length()];
                    for (int i12 = 0; i12 < jSONArrayOptJSONArray12.length(); i12++) {
                        iArr24[i12] = jSONArrayOptJSONArray12.optInt(i12);
                    }
                    iArr12 = iArr24;
                } else {
                    iArr12 = null;
                }
                com.ironsource.mediationsdk.model.c cVar2 = new com.ironsource.mediationsdk.model.c(false, zOptBoolean3, strOptString6, strOptString7, iOptInt4, iOptInt5, iOptInt6, iArr9, iArr10, iArr11, iArr12);
                if (jSONObject2 != null) {
                    jSONObject3 = jSONObject2;
                    str5 = str22;
                    aVar2 = new a(jSONObject3.optString("auctionData", str7), jSONObject3.optString("auctioneerURL", str7), jSONObject3.optInt("auctionTrials", 2), jSONObject3.optInt("auctionSavedHistory", 15), jSONObject3.optLong("auctionTimeout", 10000L), a(jSONObject3, "interstitial").optBoolean("programmatic", false), r2.optInt("minTimeBeforeFirstAuction", 2000), 0L, 0L, 0L, true, true, 0);
                } else {
                    str5 = str22;
                    jSONObject3 = jSONObject2;
                    aVar2 = new a();
                }
                com.ironsource.mediationsdk.model.h hVar2 = new com.ironsource.mediationsdk.model.h(i, z, iA7, cVar2, aVar2, iA8);
                if (jSONArrayOptJSONArray8 != null) {
                    for (int i13 = 0; i13 < jSONArrayOptJSONArray8.length(); i13++) {
                        com.ironsource.mediationsdk.model.i iVarC = c(jSONArrayOptJSONArray8.optJSONObject(i13));
                        if (iVarC != null) {
                            hVar2.a(iVarC);
                        }
                    }
                }
                String strOptString8 = jSONObjectA6.optString("backFill");
                if (!TextUtils.isEmpty(strOptString8)) {
                    hVar2.b(strOptString8);
                }
                String strOptString9 = jSONObjectA6.optString("premium");
                if (!TextUtils.isEmpty(strOptString9)) {
                    hVar2.c(strOptString9);
                }
                hVar = hVar2;
            } else {
                str9 = str;
                str10 = str6;
                str11 = str4;
                jSONObject3 = jSONObject2;
                str12 = str8;
                hVar = null;
            }
            if (jSONObject != null) {
                JSONObject jSONObject4 = jSONObject;
                JSONArray jSONArrayOptJSONArray13 = jSONObject4.optJSONArray(str10);
                JSONObject jSONObjectA19 = a(jSONObject4, str9);
                int iA9 = a(jSONObject4, jSONObjectA4, "maxNumOfAdaptersToLoadOnStart", 1);
                String str23 = str11;
                str16 = str3;
                JSONArray jSONArray = jSONArrayOptJSONArray13;
                str13 = str10;
                JSONObject jSONObject5 = jSONObject3;
                str15 = str23;
                str18 = str5;
                str14 = str9;
                long jA = a(jSONObject4, jSONObjectA4, "atim", 10000L);
                int iA10 = a(jSONObject4, jSONObjectA4, "delayLoadFailure", 3);
                int iA11 = a(jSONObject4, jSONObjectA4, "bannerInterval", 60);
                JSONObject jSONObjectA20 = j.a(jSONObjectA19, jSONObjectA9);
                boolean zOptBoolean4 = jSONObjectA20.optBoolean(str12, false);
                str17 = str2;
                String strOptString10 = jSONObjectA20.optString(str17, str7);
                String strOptString11 = jSONObjectA20.optString(str16, str7);
                int iOptInt7 = jSONObjectA20.optInt(str18, -1);
                int iOptInt8 = jSONObjectA20.optInt(str15, -1);
                int iOptInt9 = jSONObjectA20.optInt("maxEventsPerBatch", 5000);
                JSONArray jSONArrayOptJSONArray14 = jSONObjectA20.optJSONArray("optOut");
                if (jSONArrayOptJSONArray14 != null) {
                    int[] iArr25 = new int[jSONArrayOptJSONArray14.length()];
                    for (int i14 = 0; i14 < jSONArrayOptJSONArray14.length(); i14++) {
                        iArr25[i14] = jSONArrayOptJSONArray14.optInt(i14);
                    }
                    iArr5 = iArr25;
                } else {
                    iArr5 = null;
                }
                JSONArray jSONArrayOptJSONArray15 = jSONObjectA20.optJSONArray("optIn");
                if (jSONArrayOptJSONArray15 != null) {
                    int[] iArr26 = new int[jSONArrayOptJSONArray15.length()];
                    for (int i15 = 0; i15 < jSONArrayOptJSONArray15.length(); i15++) {
                        iArr26[i15] = jSONArrayOptJSONArray15.optInt(i15);
                    }
                    iArr6 = iArr26;
                } else {
                    iArr6 = null;
                }
                JSONArray jSONArrayOptJSONArray16 = jSONObjectA20.optJSONArray("triggerEvents");
                if (jSONArrayOptJSONArray16 != null) {
                    int[] iArr27 = new int[jSONArrayOptJSONArray16.length()];
                    for (int i16 = 0; i16 < jSONArrayOptJSONArray16.length(); i16++) {
                        iArr27[i16] = jSONArrayOptJSONArray16.optInt(i16);
                    }
                    iArr7 = iArr27;
                } else {
                    iArr7 = null;
                }
                JSONArray jSONArrayOptJSONArray17 = jSONObjectA20.optJSONArray("nonConnectivityEvents");
                if (jSONArrayOptJSONArray17 != null) {
                    int[] iArr28 = new int[jSONArrayOptJSONArray17.length()];
                    for (int i17 = 0; i17 < jSONArrayOptJSONArray17.length(); i17++) {
                        iArr28[i17] = jSONArrayOptJSONArray17.optInt(i17);
                    }
                    iArr8 = iArr28;
                } else {
                    iArr8 = null;
                }
                com.ironsource.mediationsdk.model.c cVar3 = new com.ironsource.mediationsdk.model.c(false, zOptBoolean4, strOptString10, strOptString11, iOptInt7, iOptInt8, iOptInt9, iArr5, iArr6, iArr7, iArr8);
                if (jSONObject5 != null) {
                    JSONObject jSONObjectA21 = a(jSONObject5, "banner");
                    aVar = jSONObjectA21 != null ? new a(jSONObject5.optString("auctionData", str7), jSONObject5.optString("auctioneerURL", str7), jSONObject5.optInt("auctionTrials", 2), jSONObject5.optInt("auctionSavedHistory", 15), jSONObject5.optLong("auctionTimeout", 10000L), jSONObjectA21.optBoolean("programmatic", false), jSONObjectA21.optInt("minTimeBeforeFirstAuction", 2000), 0L, 0L, 0L, true, true, 0) : new a();
                } else {
                    aVar = new a();
                }
                com.ironsource.mediationsdk.model.e eVar2 = new com.ironsource.mediationsdk.model.e(iA9, jA, cVar3, iA11, aVar, iA10);
                if (jSONArray != null) {
                    int i18 = 0;
                    while (i18 < jSONArray.length()) {
                        JSONArray jSONArray2 = jSONArray;
                        com.ironsource.mediationsdk.model.f fVarB = b(jSONArray2.optJSONObject(i18));
                        if (fVarB != null) {
                            eVar2.a(fVarB);
                        }
                        i18++;
                        jSONArray = jSONArray2;
                    }
                }
                eVar = eVar2;
            } else {
                str13 = str10;
                str14 = str9;
                str15 = str11;
                str16 = str3;
                str17 = str2;
                str18 = str5;
                eVar = null;
            }
            if (jSONObjectA7 != null) {
                str19 = str14;
                JSONObject jSONObjectA22 = j.a(a(jSONObjectA7, str19), jSONObjectA9);
                boolean zOptBoolean5 = jSONObjectA22.optBoolean(str12, false);
                String strOptString12 = jSONObjectA22.optString(str17, str7);
                String strOptString13 = jSONObjectA22.optString(str16, str7);
                int iOptInt10 = jSONObjectA22.optInt(str18, -1);
                int iOptInt11 = jSONObjectA22.optInt(str15, -1);
                int iOptInt12 = jSONObjectA22.optInt("maxEventsPerBatch", 5000);
                JSONArray jSONArrayOptJSONArray18 = jSONObjectA22.optJSONArray("optOut");
                if (jSONArrayOptJSONArray18 != null) {
                    int[] iArr29 = new int[jSONArrayOptJSONArray18.length()];
                    for (int i19 = 0; i19 < jSONArrayOptJSONArray18.length(); i19++) {
                        iArr29[i19] = jSONArrayOptJSONArray18.optInt(i19);
                    }
                    iArr = iArr29;
                } else {
                    iArr = null;
                }
                JSONArray jSONArrayOptJSONArray19 = jSONObjectA22.optJSONArray("optIn");
                if (jSONArrayOptJSONArray19 != null) {
                    int[] iArr30 = new int[jSONArrayOptJSONArray19.length()];
                    for (int i20 = 0; i20 < jSONArrayOptJSONArray19.length(); i20++) {
                        iArr30[i20] = jSONArrayOptJSONArray19.optInt(i20);
                    }
                    iArr2 = iArr30;
                } else {
                    iArr2 = null;
                }
                JSONArray jSONArrayOptJSONArray20 = jSONObjectA22.optJSONArray("triggerEvents");
                if (jSONArrayOptJSONArray20 != null) {
                    int[] iArr31 = new int[jSONArrayOptJSONArray20.length()];
                    for (int i21 = 0; i21 < jSONArrayOptJSONArray20.length(); i21++) {
                        iArr31[i21] = jSONArrayOptJSONArray20.optInt(i21);
                    }
                    iArr3 = iArr31;
                } else {
                    iArr3 = null;
                }
                JSONArray jSONArrayOptJSONArray21 = jSONObjectA22.optJSONArray("nonConnectivityEvents");
                if (jSONArrayOptJSONArray21 != null) {
                    int[] iArr32 = new int[jSONArrayOptJSONArray21.length()];
                    for (int i22 = 0; i22 < jSONArrayOptJSONArray21.length(); i22++) {
                        iArr32[i22] = jSONArrayOptJSONArray21.optInt(i22);
                    }
                    iArr4 = iArr32;
                } else {
                    iArr4 = null;
                }
                com.ironsource.mediationsdk.model.j jVar2 = new com.ironsource.mediationsdk.model.j(new com.ironsource.mediationsdk.model.c(false, zOptBoolean5, strOptString12, strOptString13, iOptInt10, iOptInt11, iOptInt12, iArr, iArr2, iArr3, iArr4));
                JSONArray jSONArrayOptJSONArray22 = jSONObjectA7.optJSONArray(str13);
                if (jSONArrayOptJSONArray22 != null) {
                    for (int i23 = 0; i23 < jSONArrayOptJSONArray22.length(); i23++) {
                        com.ironsource.mediationsdk.model.k kVarD = d(jSONArrayOptJSONArray22.optJSONObject(i23));
                        if (kVarD != null) {
                            jVar2.a(kVarD);
                        }
                    }
                }
                jVar = jVar2;
            } else {
                str19 = str14;
                jVar = null;
            }
            n nVar = new n();
            if (jSONObjectA11 != null && (jSONArrayOptJSONArray = jSONObjectA11.optJSONArray("optInKeys")) != null) {
                for (int i24 = 0; i24 < jSONArrayOptJSONArray.length(); i24++) {
                    nVar.a(jSONArrayOptJSONArray.optString(i24));
                }
            }
            this.Ma = new com.ironsource.mediationsdk.model.g(rVar, hVar, jVar, eVar, new com.ironsource.mediationsdk.model.b(new com.ironsource.mediationsdk.model.d(jSONObjectA10.optInt("server", 3), jSONObjectA10.optInt("publisher", 3), jSONObjectA10.optInt("console", 3)), jSONObjectA12 != null ? new s(jSONObjectA12.optString("name", str7), jSONObjectA12.optString("id", "-1"), jSONObjectA12.optJSONObject(UserData.CUSTOM_KEY)) : null, nVar, jSONObjectA4.optBoolean("integration", false)));
            JSONObject jSONObjectA23 = a(jSONObjectA9, "genericParams");
            if (jSONObjectA23 != null && (jSONObjectA = a(jSONObjectA23, str19)) != null) {
                jSONObjectA23.remove(str19);
                Map<String, String> mapA = j.a(jSONObjectA);
                com.ironsource.mediationsdk.b.k.g().b(mapA);
                com.ironsource.mediationsdk.b.h.g().b(mapA);
            }
            if (jSONObjectA23 != null) {
                Map<String, String> mapA2 = j.a(jSONObjectA23);
                com.ironsource.mediationsdk.b.k.g().a(mapA2);
                com.ironsource.mediationsdk.b.h.g().a(mapA2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void k() {
        try {
            JSONObject jSONObjectA = a(this.Pa, "providerOrder");
            JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("rewardedVideo");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectA.optJSONArray("interstitial");
            JSONArray jSONArrayOptJSONArray3 = jSONObjectA.optJSONArray("banner");
            this.Ka = new o();
            if (jSONArrayOptJSONArray != null && a() != null && a().e() != null) {
                String strA = a().e().a();
                String strD = a().e().d();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (strOptString.equals(strA)) {
                        this.Ka.f(strA);
                    } else {
                        if (strOptString.equals(strD)) {
                            this.Ka.g(strD);
                        }
                        this.Ka.c(strOptString);
                        p pVarB = q.b().b(strOptString);
                        if (pVarB != null) {
                            pVarB.c(i);
                        }
                    }
                }
            }
            if (jSONArrayOptJSONArray2 != null && a() != null && a().c() != null) {
                String strA2 = a().c().a();
                String strI = a().c().i();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    if (strOptString2.equals(strA2)) {
                        this.Ka.d(strA2);
                    } else {
                        if (strOptString2.equals(strI)) {
                            this.Ka.e(strI);
                        }
                        this.Ka.b(strOptString2);
                        p pVarB2 = q.b().b(strOptString2);
                        if (pVarB2 != null) {
                            pVarB2.b(i2);
                        }
                    }
                }
            }
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    String strOptString3 = jSONArrayOptJSONArray3.optString(i3);
                    this.Ka.a(strOptString3);
                    p pVarB3 = q.b().b(strOptString3);
                    if (pVarB3 != null) {
                        pVarB3.a(i3);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void l() {
        try {
            this.La = q.b();
            JSONObject jSONObjectA = a(this.Pa, "providerSettings");
            Iterator<String> itKeys = jSONObjectA.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("mpis", false);
                    String strOptString = jSONObjectOptJSONObject.optString("spId", "0");
                    String strOptString2 = jSONObjectOptJSONObject.optString("adSourceName", null);
                    String strOptString3 = jSONObjectOptJSONObject.optString("providerLoadName", next);
                    JSONObject jSONObjectA2 = a(jSONObjectOptJSONObject, "adUnits");
                    JSONObject jSONObjectA3 = a(jSONObjectOptJSONObject, "application");
                    JSONObject jSONObjectA4 = a(jSONObjectA2, "rewardedVideo");
                    JSONObject jSONObjectA5 = a(jSONObjectA2, "interstitial");
                    JSONObject jSONObjectA6 = a(jSONObjectA2, "banner");
                    JSONObject jSONObjectA7 = j.a(jSONObjectA4, jSONObjectA3);
                    JSONObject jSONObjectA8 = j.a(jSONObjectA5, jSONObjectA3);
                    JSONObject jSONObjectA9 = j.a(jSONObjectA6, jSONObjectA3);
                    if (this.La.a(next)) {
                        p pVarB = this.La.b(next);
                        JSONObject jSONObjectK = pVarB.k();
                        JSONObject jSONObjectF = pVarB.f();
                        JSONObject jSONObjectD = pVarB.d();
                        pVarB.c(j.a(jSONObjectK, jSONObjectA7));
                        pVarB.b(j.a(jSONObjectF, jSONObjectA8));
                        pVarB.a(j.a(jSONObjectD, jSONObjectA9));
                        pVarB.a(zOptBoolean);
                        pVarB.b(strOptString);
                        pVarB.a(strOptString2);
                    } else if (a(strOptString3)) {
                        p pVarB2 = this.La.b("Mediation");
                        JSONObject jSONObjectK2 = pVarB2.k();
                        JSONObject jSONObjectF2 = pVarB2.f();
                        JSONObject jSONObjectD2 = pVarB2.d();
                        p pVar = new p(next, strOptString3, jSONObjectA3, j.a(new JSONObject(jSONObjectK2.toString()), jSONObjectA7), j.a(new JSONObject(jSONObjectF2.toString()), jSONObjectA8), j.a(new JSONObject(jSONObjectD2.toString()), jSONObjectA9));
                        pVar.a(zOptBoolean);
                        pVar.b(strOptString);
                        pVar.a(strOptString2);
                        this.La.a(pVar);
                    } else {
                        p pVar2 = new p(next, strOptString3, jSONObjectA3, jSONObjectA7, jSONObjectA8, jSONObjectA9);
                        pVar2.a(zOptBoolean);
                        pVar2.b(strOptString);
                        pVar2.a(strOptString2);
                        this.La.a(pVar2);
                    }
                }
            }
            this.La.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public List<IronSource.AD_UNIT> b() {
        o oVar;
        o oVar2;
        if (this.Pa == null || this.Ma == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.Ma.e() != null && (oVar2 = this.Ka) != null && oVar2.e().size() > 0) {
            arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
        if (this.Ma.c() != null && (oVar = this.Ka) != null && oVar.b().size() > 0) {
            arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
        }
        if (this.Ma.d() != null) {
            arrayList.add(IronSource.AD_UNIT.OFFERWALL);
        }
        if (this.Ma.b() != null) {
            arrayList.add(IronSource.AD_UNIT.BANNER);
        }
        return arrayList;
    }

    public String f() {
        try {
            return this.Ka.d();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.INTERNAL, "getRVPremiumProvider", e2);
            return null;
        }
    }

    public boolean g() {
        return ((((this.Pa != null) && !this.Pa.has("error")) && this.Ka != null) && this.La != null) && this.Ma != null;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.Na);
            jSONObject.put("userId", this.Oa);
            jSONObject.put("response", this.Pa);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i) {
        int iOptInt;
        if (jSONObject.has(str)) {
            iOptInt = jSONObject.optInt(str, 0);
        } else {
            iOptInt = jSONObject2.has(str) ? jSONObject2.optInt(str, 0) : 0;
        }
        return iOptInt == 0 ? i : iOptInt;
    }

    public q d() {
        return this.La;
    }

    public o c() {
        return this.Ka;
    }

    private long a(JSONObject jSONObject, JSONObject jSONObject2, String str, long j) {
        long jOptLong;
        if (jSONObject.has(str)) {
            jOptLong = jSONObject.optLong(str, 0L);
        } else {
            jOptLong = jSONObject2.has(str) ? jSONObject2.optLong(str, 0L) : 0L;
        }
        return jOptLong == 0 ? j : jOptLong;
    }

    public String e() {
        try {
            return this.Ka.c();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.INTERNAL, "getRVBackFillProvider", e2);
            return null;
        }
    }

    private com.ironsource.mediationsdk.model.n a(JSONObject jSONObject) {
        PlacementCappingType placementCappingType = null;
        if (jSONObject == null) {
            return null;
        }
        n.a aVar = new n.a();
        aVar.a(jSONObject.optBoolean("delivery", true));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("capping");
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString("unit");
            if (!TextUtils.isEmpty(strOptString)) {
                if (PlacementCappingType.PER_DAY.toString().equals(strOptString)) {
                    placementCappingType = PlacementCappingType.PER_DAY;
                } else if (PlacementCappingType.PER_HOUR.toString().equals(strOptString)) {
                    placementCappingType = PlacementCappingType.PER_HOUR;
                }
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("maxImpressions", 0);
            aVar.a(jSONObjectOptJSONObject.optBoolean("enabled", false) && iOptInt > 0, placementCappingType, iOptInt);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("pacing");
        if (jSONObjectOptJSONObject2 != null) {
            int iOptInt2 = jSONObjectOptJSONObject2.optInt("numOfSeconds", 0);
            aVar.a(jSONObjectOptJSONObject2.optBoolean("enabled", false) && iOptInt2 > 0, iOptInt2);
        }
        return aVar.a();
    }

    private com.ironsource.mediationsdk.model.f b(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean("isDefault", false);
            com.ironsource.mediationsdk.model.n nVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                com.ironsource.mediationsdk.model.f fVar = new com.ironsource.mediationsdk.model.f(iOptInt, strOptString, zOptBoolean, nVarA);
                if (nVarA == null) {
                    return fVar;
                }
                CappingManager.a(this.Qa, fVar);
                return fVar;
            }
        }
        return null;
    }

    private JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public com.ironsource.mediationsdk.model.g a() {
        return this.Ma;
    }

    public k(k kVar) {
        try {
            this.Qa = kVar.i();
            this.Pa = new JSONObject(kVar.Pa.toString());
            this.Na = kVar.Na;
            this.Oa = kVar.Oa;
            this.Ka = kVar.c();
            this.La = kVar.d();
            this.Ma = kVar.a();
        } catch (Exception unused) {
            h();
        }
    }
}
