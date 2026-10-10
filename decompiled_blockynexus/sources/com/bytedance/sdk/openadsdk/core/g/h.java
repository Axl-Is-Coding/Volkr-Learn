package com.bytedance.sdk.openadsdk.core.g;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.v;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTDnsSettings.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f6215b;

    private void c() {
        if (TextUtils.isEmpty(this.f6214a)) {
            return;
        }
        try {
            this.f6215b = b.a(new JSONObject(this.f6214a));
        } catch (Exception unused) {
        }
    }

    private void d() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            if (TextUtils.isEmpty(this.f6214a)) {
                return;
            }
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_dns_settings", "dnsinfo", this.f6214a);
        } else {
            v vVarE = e();
            if (TextUtils.isEmpty(this.f6214a)) {
                return;
            }
            vVarE.a("dnsinfo", this.f6214a);
        }
    }

    private v e() {
        return v.a("tt_dns_settings", o.a());
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.d
    public void a() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            this.f6214a = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_dns_settings", "dnsinfo", "");
            c();
        } else {
            this.f6214a = e().b("dnsinfo", "");
            c();
        }
    }

    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.d
    public void a(JSONObject jSONObject) {
        this.f6215b = b.a(jSONObject);
        b bVar = this.f6215b;
        if (bVar != null) {
            this.f6214a = bVar.c().toString();
        }
        d();
    }
}
