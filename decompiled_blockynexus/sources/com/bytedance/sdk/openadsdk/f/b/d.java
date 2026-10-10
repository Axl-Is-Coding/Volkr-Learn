package com.bytedance.sdk.openadsdk.f.b;

import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.UUID;

/* JADX INFO: compiled from: LogUploaderImpl4MultiProcess.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements a {
    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a() {
        com.bytedance.sdk.openadsdk.multipro.c.a.e();
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar) {
        try {
            com.bytedance.sdk.openadsdk.multipro.c.a.b(aVar.a().toString());
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar, boolean z) {
        try {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(new c.a(UUID.randomUUID().toString(), aVar.a()).a(), z);
        } catch (Throwable unused) {
        }
    }
}
