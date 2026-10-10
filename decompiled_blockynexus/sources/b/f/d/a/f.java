package b.f.d.a;

import android.app.Activity;
import android.util.Pair;
import b.f.a.a;
import b.f.d.a.c;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISNEventsUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static c a(Activity activity, String str, String str2, Map<String, String> map) throws Exception {
        c.a aVar = new c.a();
        if (map != null && map.containsKey("sessionid")) {
            aVar.b(map.get("sessionid"));
        }
        if (activity != null) {
            aVar.a(activity.getApplicationContext());
        }
        aVar.c(str);
        aVar.a(str2);
        return aVar.a();
    }

    public static b.f.a.a a(JSONObject jSONObject) {
        a.C0041a c0041a = new a.C0041a(jSONObject.optString("endpoint"));
        c0041a.b();
        c0041a.b(jSONObject.optBoolean("enabled"));
        c0041a.a(new d());
        c0041a.a(a());
        c0041a.a(false);
        return c0041a.a();
    }

    private static ArrayList<Pair<String, String>> a() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE));
        arrayList.add(new Pair<>(HybridPlusWebView.CHARSET, "utf-8"));
        return arrayList;
    }

    public static boolean a(com.ironsource.sdk.data.d dVar) {
        if (dVar == null || dVar.e().get("inAppBidding") == null) {
            return false;
        }
        return Boolean.parseBoolean(dVar.e().get("inAppBidding"));
    }

    public static SSAEnums$ProductType a(com.ironsource.sdk.data.d dVar, SSAEnums$ProductType sSAEnums$ProductType) {
        return (dVar == null || dVar.e() == null || dVar.e().get("rewarded") == null) ? sSAEnums$ProductType : Boolean.parseBoolean(dVar.e().get("rewarded")) ? SSAEnums$ProductType.RewardedVideo : SSAEnums$ProductType.Interstitial;
    }
}
