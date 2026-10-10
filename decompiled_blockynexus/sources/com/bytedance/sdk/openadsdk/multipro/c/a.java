package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.b.c;
import com.bytedance.sdk.openadsdk.j.h;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEventProviderImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.sdk.openadsdk.multipro.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7064a;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdEventProviderImpl.java */
    private static class C0094a implements com.bytedance.sdk.openadsdk.f.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        JSONObject f7065a;

        private C0094a(String str) {
            try {
                this.f7065a = new JSONObject(str);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static C0094a b(String str) {
            return new C0094a(str);
        }

        @Override // com.bytedance.sdk.openadsdk.f.a.a
        public JSONObject a() {
            return this.f7065a;
        }
    }

    /* JADX INFO: compiled from: AdEventProviderImpl.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile com.bytedance.sdk.openadsdk.f.b.c f7069a;

        public static com.bytedance.sdk.openadsdk.f.b.c a() {
            if (f7069a == null) {
                synchronized (com.bytedance.sdk.openadsdk.f.b.c.class) {
                    if (f7069a == null) {
                        f7069a = new com.bytedance.sdk.openadsdk.f.b.c();
                    }
                }
            }
            return f7069a;
        }
    }

    /* JADX INFO: compiled from: AdEventProviderImpl.java */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile com.bytedance.sdk.openadsdk.j.a f7070a;

        public static com.bytedance.sdk.openadsdk.j.a a() {
            if (f7070a == null) {
                synchronized (com.bytedance.sdk.openadsdk.j.a.class) {
                    if (f7070a == null) {
                        f7070a = new com.bytedance.sdk.openadsdk.j.b(o.a(), new h(o.a()));
                    }
                }
            }
            return f7070a;
        }
    }

    public static void a(boolean z) {
        if (o.a() == null) {
            return;
        }
        try {
            ContentResolver contentResolverF = f();
            if (contentResolverF != null) {
                contentResolverF.getType(Uri.parse(g() + "logStatusStart" + ("?isRealTime=" + String.valueOf(z))));
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverF = f();
            if (contentResolverF != null) {
                contentResolverF.getType(Uri.parse(g() + "logStatusUpload?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        if (o.a() == null) {
            return;
        }
        try {
            ContentResolver contentResolverF = f();
            if (contentResolverF != null) {
                contentResolverF.getType(Uri.parse(g() + "adEventStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        try {
            ContentResolver contentResolverF = f();
            if (contentResolverF != null) {
                contentResolverF.getType(Uri.parse(g() + "trackFailed"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void e() {
        try {
            ContentResolver contentResolverF = f();
            if (contentResolverF != null) {
                contentResolverF.getType(Uri.parse(g() + "logStatusInit"));
            }
        } catch (Throwable unused) {
        }
    }

    private static ContentResolver f() {
        try {
            if (o.a() != null) {
                return o.a().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String g() {
        return e.f7076b + "/t_event_ad_event/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a() {
        return "t_event_ad_event";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "dispatch event");
        try {
            ContentResolver contentResolverF = f();
            if (contentResolverF != null) {
                contentResolverF.getType(Uri.parse(g() + "adEventDispatch?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str)));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.e("AdEventProviderImpl", "dispatch event Throwable:" + th.toString());
        }
    }

    /* JADX INFO: compiled from: AdEventProviderImpl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f7066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f7067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f7068c;

        static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a() {
            if (f7066a == null) {
                synchronized (o.class) {
                    if (f7066a == null) {
                        f7066a = new com.bytedance.sdk.openadsdk.c.b<>(new f(o.a()), o.f(), g.b.a(), d());
                    }
                }
            }
            return f7066a;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> b() {
            if (f7068c == null) {
                synchronized (o.class) {
                    if (f7068c == null) {
                        f7068c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
            return f7068c;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> c() {
            if (f7067b == null) {
                synchronized (o.class) {
                    if (f7067b == null) {
                        f7067b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
            return f7067b;
        }

        private static g.a d() {
            return new g.a() { // from class: com.bytedance.sdk.openadsdk.multipro.c.a.b.1
                @Override // com.bytedance.sdk.openadsdk.c.g.a
                public boolean a() {
                    return q.a(o.a());
                }
            };
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> a(String str, String str2, boolean z) {
            g.b bVarB;
            com.bytedance.sdk.openadsdk.c.e lVar;
            if (z) {
                lVar = new n(o.a());
                bVarB = g.b.a();
            } else {
                bVarB = g.b.b();
                lVar = new l(o.a());
            }
            g.a aVarD = d();
            return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, bVarB, aVarD, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, bVarB, aVarD));
        }
    }

    public static void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.openadsdk.multipro.c.a(it.next()));
                sb.append(",");
            }
            String str = "?track=" + String.valueOf(com.bytedance.sdk.openadsdk.multipro.c.a(sb.toString()));
            ContentResolver contentResolverF = f();
            if (contentResolverF != null) {
                contentResolverF.getType(Uri.parse(g() + "trackUrl" + str));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverF = f();
            if (contentResolverF != null) {
                contentResolverF.getType(Uri.parse(g() + "logStatusDispatch" + ("?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str) + "&isRealTime=" + String.valueOf(z))));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.f7064a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("adEventStart".equals(str)) {
            com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "====ad event function will be start====");
            b.a().a();
        } else if ("logStatusStart".equals(str)) {
            com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "====log stats function will be start====");
            if (Boolean.valueOf(uri.getQueryParameter("isRealTime")).booleanValue()) {
                b.c().a();
            } else {
                b.b().a();
            }
        } else if ("adEventDispatch".equals(str)) {
            com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "dispatch FUN_AD_EVENT_DISPATCH");
            com.bytedance.sdk.openadsdk.c.a aVarA = com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (aVarA != null) {
                b.a().a(aVarA);
            }
        } else if ("logStatusDispatch".equals(str)) {
            Boolean boolValueOf = Boolean.valueOf(uri.getQueryParameter("isRealTime"));
            c.a aVarA2 = c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (aVarA2 == null) {
                return null;
            }
            if (boolValueOf.booleanValue()) {
                b.c().a(aVarA2);
            } else {
                b.b().a(aVarA2);
            }
        } else if ("trackUrl".equals(str)) {
            try {
                String[] strArrSplit = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("track")).split(",");
                if (strArrSplit.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : strArrSplit) {
                        String strB = com.bytedance.sdk.openadsdk.multipro.c.b(str2);
                        if (!TextUtils.isEmpty(strB)) {
                            arrayList.add(strB);
                        }
                    }
                    d.a().a(arrayList);
                }
            } catch (Throwable unused) {
            }
        } else if ("trackFailed".equals(str)) {
            d.a().a();
            com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "track failed: ");
        } else if ("logStatusInit".equals(str)) {
            c.a().a();
        } else if ("logStatusUpload".equals(str)) {
            String strB2 = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event"));
            if (!TextUtils.isEmpty(strB2)) {
                c.a().a(C0094a.b(strB2));
            }
        }
        return null;
    }
}
