package com.bytedance.sdk.openadsdk.f.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.g.g;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogUploaderImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.sdk.openadsdk.f.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f6751b = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f6752c = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f6750a = b.a();

    public static com.bytedance.sdk.openadsdk.f.b.a c() {
        return e.c();
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a() {
        this.f6752c.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                List<a> listD = c.this.f6750a.d();
                if (listD != null) {
                    c.this.f6751b.addAll(listD);
                }
                c.this.f6750a.c();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void b() {
        ExecutorService executorService = this.f6752c;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar) {
        a(aVar, false);
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar, boolean z) {
        if (aVar == null || !g.a()) {
            return;
        }
        a aVar2 = new a(UUID.randomUUID().toString(), aVar.a());
        if (z) {
            o.e().a(aVar2);
        } else {
            o.d().a(aVar2);
        }
    }

    /* JADX INFO: compiled from: LogUploaderImpl.java */
    public static class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f6755b;

        public a(String str, JSONObject jSONObject) {
            this.f6754a = str;
            this.f6755b = jSONObject;
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("localId", null);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event");
                if (!TextUtils.isEmpty(strOptString) && jSONObjectOptJSONObject != null) {
                    return new a(strOptString, jSONObjectOptJSONObject);
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.c.i
        public String b() {
            return this.f6754a;
        }

        public String a() {
            if (TextUtils.isEmpty(this.f6754a) || this.f6755b == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.f6754a);
                jSONObject.put("event", this.f6755b);
            } catch (Throwable unused) {
            }
            return jSONObject.toString();
        }
    }
}
