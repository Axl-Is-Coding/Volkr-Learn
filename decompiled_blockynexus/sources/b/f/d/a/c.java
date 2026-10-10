package b.f.d.a;

import android.content.Context;
import com.ironsource.sdk.utils.i;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ISNEventsBaseData.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements b.f.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Object> f2627a = new HashMap();

    /* JADX INFO: compiled from: ISNEventsBaseData.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Context f2630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f2631d;

        a a(String str) {
            this.f2629b = str;
            return this;
        }

        a b(String str) {
            this.f2628a = str;
            return this;
        }

        a c(String str) {
            this.f2631d = str;
            return this;
        }

        a a(Context context) {
            this.f2630c = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private void a(Context context) {
        f2627a.put("connectiontype", b.f.c.b.b(context));
    }

    @Override // b.f.a.d
    public Map<String, Object> getData() {
        return f2627a;
    }

    private c(a aVar) {
        a(aVar);
        a(aVar.f2630c);
    }

    private void a(a aVar) {
        Context context = aVar.f2630c;
        com.ironsource.sdk.utils.a aVarB = com.ironsource.sdk.utils.a.b(context);
        f2627a.put("deviceos", i.b(aVarB.e()));
        f2627a.put("deviceosversion", i.b(aVarB.f()));
        f2627a.put("deviceapilevel", Integer.valueOf(aVarB.a()));
        f2627a.put("deviceoem", i.b(aVarB.d()));
        f2627a.put("devicemodel", i.b(aVarB.c()));
        f2627a.put("bundleid", i.b(context.getPackageName()));
        f2627a.put("applicationkey", i.b(aVar.f2629b));
        f2627a.put("sessionid", i.b(aVar.f2628a));
        f2627a.put("sdkversion", i.b(com.ironsource.sdk.utils.a.g()));
        f2627a.put("applicationuserid", i.b(aVar.f2631d));
        f2627a.put("env", "prod");
        f2627a.put("origin", "n");
    }

    public static void a(String str) {
        f2627a.put("connectiontype", i.b(str));
    }
}
