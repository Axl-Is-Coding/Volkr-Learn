package b.f.d.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.b;
import com.iab.omid.library.ironsrc.adsession.c;
import com.iab.omid.library.ironsrc.adsession.d;
import com.iab.omid.library.ironsrc.adsession.e;
import com.ironsource.sdk.data.f;
import com.ironsource.sdk.utils.i;
import com.sandboxol.center.config.VipSubscribeStatus;
import org.json.JSONObject;

/* JADX INFO: compiled from: OMIDManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f2726b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e f2725a = e.a("Ironsrc", VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2727c = false;

    /* JADX INFO: renamed from: b.f.d.d.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OMIDManager.java */
    static class C0043a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Owner f2729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Owner f2730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f2731d;

        public static C0043a a(JSONObject jSONObject) throws IllegalArgumentException {
            C0043a c0043a = new C0043a();
            c0043a.f2728a = jSONObject.optBoolean("isolateVerificationScripts", false);
            String strOptString = jSONObject.optString("impressionOwner", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IllegalArgumentException(String.format("Missing OMID impressionOwner", strOptString));
            }
            try {
                c0043a.f2729b = Owner.valueOf(strOptString.toUpperCase());
                String strOptString2 = jSONObject.optString("videoEventsOwner", "");
                if (TextUtils.isEmpty(strOptString)) {
                    throw new IllegalArgumentException(String.format("Missing OMID videoEventsOwner", strOptString2));
                }
                try {
                    c0043a.f2730c = Owner.valueOf(strOptString2.toUpperCase());
                    c0043a.f2731d = jSONObject.optString("customReferenceData", "");
                    return c0043a;
                } catch (IllegalArgumentException unused) {
                    throw new IllegalArgumentException(String.format("%s | Invalid OMID videoEventsOwner", strOptString2));
                }
            } catch (IllegalArgumentException unused2) {
                throw new IllegalArgumentException(String.format("%s | Invalid OMID impressionOwner", strOptString));
            }
        }
    }

    public static void a(Context context) throws IllegalArgumentException {
        if (f2727c) {
            return;
        }
        f2727c = b.e.a.a.a.a.a(b.e.a.a.a.a.a(), context);
    }

    public static f b() {
        f fVar = new f();
        fVar.a(i.b("omidVersion"), i.b(b.e.a.a.a.a.a()));
        fVar.a(i.b("omidPartnerName"), i.b("Ironsrc"));
        fVar.a(i.b("omidPartnerVersion"), i.b(VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD));
        return fVar;
    }

    public static void c() throws IllegalStateException, IllegalArgumentException {
        d();
        com.iab.omid.library.ironsrc.adsession.a.a(f2726b).a();
    }

    private static void d() throws IllegalStateException {
        if (!f2727c) {
            throw new IllegalStateException("OMID has not been activated");
        }
        if (f2726b == null) {
            throw new IllegalStateException("OMID Session has not started");
        }
    }

    public static void a(JSONObject jSONObject, WebView webView) throws IllegalStateException, IllegalArgumentException {
        a(C0043a.a(jSONObject), webView);
    }

    public static void a(C0043a c0043a, WebView webView) throws IllegalStateException, IllegalArgumentException {
        if (f2727c) {
            if (f2726b == null) {
                f2726b = b(c0043a, webView);
                f2726b.b();
                return;
            }
            throw new IllegalStateException("OMID Session has already started");
        }
        throw new IllegalStateException("OMID has not been activated");
    }

    private static b b(C0043a c0043a, WebView webView) throws IllegalArgumentException {
        b bVarA = b.a(c.a(c0043a.f2729b, c0043a.f2730c, c0043a.f2728a), d.a(f2725a, webView, c0043a.f2731d));
        bVarA.a(webView);
        return bVarA;
    }

    public static void a() throws IllegalStateException {
        d();
        f2726b.a();
        f2726b = null;
    }
}
