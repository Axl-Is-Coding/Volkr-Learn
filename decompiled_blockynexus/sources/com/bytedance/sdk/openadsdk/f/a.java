package com.bytedance.sdk.openadsdk.f;

import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a.c;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: compiled from: StatsLogManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f6734b = Executors.newFixedThreadPool(5);

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(c cVar) {
        return cVar == null;
    }

    public void b(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.a("load_ad_duration_no_ad");
        cVar.c(System.currentTimeMillis() / 1000);
        o.j().a(cVar);
    }

    public void c(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.a("express_ad_render");
        cVar.c(System.currentTimeMillis() / 1000);
        o.j().a(cVar);
    }

    public void d(final c cVar) {
        if (h(cVar)) {
            return;
        }
        this.f6734b.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.h(cVar) || !a.this.a(cVar.e(), 1)) {
                    return;
                }
                cVar.a("reg_creative");
                o.j().a(cVar);
            }
        });
    }

    public void e(final c cVar) {
        if (h(cVar)) {
            return;
        }
        this.f6734b.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.h(cVar) || !a.this.a(cVar.e(), 0)) {
                    return;
                }
                cVar.a("no_reg_creative");
                o.j().a(cVar);
            }
        });
    }

    public void f(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.a("load_icon_error");
        o.j().a(cVar);
    }

    public void g(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.a("show_backup_endcard");
        cVar.c(System.currentTimeMillis() / 1000);
        o.j().a(cVar);
    }

    public static a a() {
        if (f6733a == null) {
            synchronized (a.class) {
                if (f6733a == null) {
                    f6733a = new a();
                }
            }
        }
        return f6733a;
    }

    public void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable unused) {
        }
        o.j().a(c.b().a("close_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void a(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.c(System.currentTimeMillis() / 1000);
        o.j().a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, int i) {
        d dVarA = d.a(o.a());
        int iB = dVarA.b(str, 0);
        boolean z = (iB & 2) == 0 || (iB & 1) != i;
        if (z) {
            dVarA.a(str, i + 2);
        }
        return z;
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable unused) {
        }
        o.j().a(c.b().a("click_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void a(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2);
        } catch (Throwable unused) {
        }
        o.j().a(c.b().a("use_playable_test_tool_error").b(jSONObject.toString()), false);
    }
}
