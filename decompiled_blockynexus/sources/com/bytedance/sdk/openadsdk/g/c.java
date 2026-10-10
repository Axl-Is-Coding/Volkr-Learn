package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.Map;

/* JADX INFO: compiled from: TTAdNetDepend.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.sdk.adnet.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f6806a = "sp_multi_ttadnet_config";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f6807b;

    public c(Context context) {
        this.f6807b = context;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public int a() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public Address a(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String b() {
        return "pangle_sdk";
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String c() {
        return "android";
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public int d() {
        return 3153;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String e() {
        return j.a(this.f6807b);
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String[] f() {
        String[] strArr = {"dm16-useast1a.byteoversea.com", "dm16-useast2a.byteoversea.com"};
        String strT = o.h().t();
        if (!TextUtils.isEmpty(strT)) {
            return "SG".equals(strT) ? new String[]{"dm16-alisg.byteoversea.com"} : "CN".equals(strT) ? new String[]{"dm.toutiao.com", "dm-hl.toutiao.com", "dm-lq.toutiao.com", "dm.bytedance.com"} : strArr;
        }
        int iL = ab.l();
        return iL == 2 ? new String[]{"dm16-alisg.byteoversea.com"} : iL == 1 ? new String[]{"dm.toutiao.com", "dm-hl.toutiao.com", "dm-lq.toutiao.com", "dm.bytedance.com"} : strArr;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String a(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.d.a.b(this.f6806a, str, str2);
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f6806a, entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f6806a, entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f6806a, entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f6806a, entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f6806a, entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
