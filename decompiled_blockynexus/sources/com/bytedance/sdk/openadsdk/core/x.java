package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.b;

/* JADX INFO: compiled from: WebHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f6684a;

    public static void a(boolean z) {
        f6684a = z;
    }

    public static boolean a(final Context context, final com.bytedance.sdk.openadsdk.core.d.h hVar, final int i, TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, final String str, b.a.a.a.a.a.b bVar, final boolean z) {
        String strA;
        if (context == null || hVar == null || i == -1) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.d.e eVarL = hVar.L();
        if (eVarL != null) {
            strA = eVarL.a();
            if (!TextUtils.isEmpty(strA)) {
                Uri uri = Uri.parse(eVarL.a());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                if (ab.a(context, intent)) {
                    if (o.h().c()) {
                        ab.a(hVar, str);
                    }
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.x.1
                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            if (o.h().c()) {
                                return;
                            }
                            x.a(context, hVar.A(), hVar, i, str, z);
                            com.bytedance.sdk.openadsdk.utils.o.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                        }
                    });
                    com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_url_app", null);
                    com.bytedance.sdk.openadsdk.c.k.a().a(hVar, str);
                    return true;
                }
            }
            if (eVarL.c() != 2 || hVar.N() == 5 || hVar.N() == 15) {
                strA = eVarL.c() == 1 ? eVarL.b() : hVar.A();
            } else if (bVar != null) {
                if (bVar.d()) {
                    com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_fallback_url", null);
                    return true;
                }
                if (bVar.c()) {
                    com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_fallback_url", null);
                    return true;
                }
                com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_fallback_url", null);
                return false;
            }
            com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_fallback_url", null);
        } else {
            strA = hVar.A();
        }
        if (TextUtils.isEmpty(strA) && !hVar.r()) {
            return false;
        }
        if (hVar.x() != 2) {
            com.bytedance.sdk.openadsdk.utils.b.a(context, a(context, strA, hVar, i, tTNativeAd, tTNativeExpressAd, str, z), null);
            f6684a = false;
        } else {
            if (!com.bytedance.sdk.openadsdk.utils.q.a(strA)) {
                return false;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            try {
                intent2.setData(Uri.parse(strA));
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                com.bytedance.sdk.openadsdk.utils.b.a(context, intent2, null);
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.h hVar, int i, String str2, boolean z) {
        try {
            context.startActivity(a(context, str, hVar, i, (TTNativeAd) null, (TTNativeExpressAd) null, str2, z));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.h hVar, int i, TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, String str2, boolean z) {
        Intent intent;
        if (hVar.r() && (tTNativeAd != null || tTNativeExpressAd != null)) {
            intent = new Intent(context, (Class<?>) TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", a(hVar, z));
            if (hVar.v() != null && !TextUtils.isEmpty(hVar.v().i())) {
                String strI = hVar.v().i();
                if (strI.contains("?")) {
                    str = strI + "&orientation=portrait";
                } else {
                    str = strI + "?orientation=portrait";
                }
            }
        } else {
            intent = ((tTNativeAd instanceof TTDrawFeedAd) || hVar.N() != 5 || f6684a) ? new Intent(context, (Class<?>) TTLandingPageActivity.class) : new Intent(context, (Class<?>) TTVideoLandingPageActivity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("web_title", hVar.G());
        intent.putExtra("sdk_version", 3153);
        intent.putExtra("adid", hVar.J());
        intent.putExtra("log_extra", hVar.M());
        intent.putExtra("icon_url", hVar.y() == null ? null : hVar.y().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, hVar.Z().toString());
        } else {
            s.a().g();
            s.a().a(hVar);
        }
        if (hVar.N() == 5) {
            if (tTNativeAd != null) {
                videoModel = tTNativeAd instanceof a.InterfaceC0093a ? ((a.InterfaceC0093a) tTNativeAd).a() : null;
                if (videoModel != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, videoModel.a().toString());
                }
            }
            if (tTNativeExpressAd != null && (videoModel = tTNativeExpressAd.getVideoModel()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, videoModel.a().toString());
            }
            if (videoModel != null) {
                intent.putExtra("video_is_auto_play", videoModel.f7061d);
                com.bytedance.sdk.openadsdk.utils.o.c("videoDataModel", "videoDataModel=" + videoModel.a().toString());
            }
        }
        return intent;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.h hVar, boolean z) {
        return z && hVar != null && hVar.x() == 4 && hVar.r();
    }
}
