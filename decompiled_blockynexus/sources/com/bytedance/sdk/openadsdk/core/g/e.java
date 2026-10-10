package com.bytedance.sdk.openadsdk.core.g;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.just.agentweb.DefaultWebClient;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SdkDnsHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f6198d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e f6199e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f6202c;

    /* JADX INFO: compiled from: SdkDnsHelper.java */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getIntExtra("b_msg_id", -1) == 1) {
                String stringExtra = intent.getStringExtra("b_msg_data");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    if (e.this.f6200a != null) {
                        e.this.f6200a.a(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private e(d dVar) {
        this.f6200a = dVar == null ? o.h() : dVar;
        this.f6201b = o.a();
        this.f6202c = Executors.newSingleThreadExecutor();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                this.f6201b.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.dnsSettingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    public void a() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (q.a(this.f6201b)) {
            new com.bytedance.sdk.adnet.b.f(0, a(null, null), (String) null, new m.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.g.e.1
                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<JSONObject> mVar) {
                    JSONObject jSONObject;
                    e.f6198d.set(false);
                    if (mVar == null || (jSONObject = mVar.f5538a) == null) {
                        try {
                            e.this.f6200a.a();
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    JSONObject jSONObject2 = jSONObject;
                    try {
                        e.this.f6200a.a(jSONObject2);
                    } catch (Throwable unused2) {
                    }
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        e.a(jSONObject2.toString());
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<JSONObject> mVar) {
                    e.f6198d.set(false);
                    try {
                        e.this.f6200a.a();
                    } catch (Throwable unused) {
                    }
                }
            }).setResponseOnMain(false).build(com.bytedance.sdk.openadsdk.g.d.a(this.f6201b).d());
            return;
        }
        try {
            this.f6200a.a();
            f6198d.set(false);
        } catch (Throwable unused) {
        }
    }

    public static e a(d dVar) {
        if (f6199e == null) {
            synchronized (e.class) {
                if (f6199e == null) {
                    f6199e = new e(dVar);
                }
            }
        }
        return f6199e;
    }

    private String a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(DefaultWebClient.HTTPS_SCHEME);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("dig.bdurl.net");
        }
        stringBuffer.append("/q?host=");
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append("is.snssdk.com");
        }
        stringBuffer.append("&aid=");
        stringBuffer.append("1371");
        return stringBuffer.toString();
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str) || o.a() == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.dnsSettingReceiver");
            intent.putExtra("b_msg_id", 1);
            intent.putExtra("b_msg_data", str);
            o.a().sendBroadcast(intent);
        } catch (Throwable unused) {
        }
    }
}
