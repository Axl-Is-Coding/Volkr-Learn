package c.t.m.g;

import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static N f2963a = new N();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f2964b = new bm();

    private N() {
        a(C0446ma.b("HalleyOperInfo_" + fc.c(), ""), false);
    }

    public static N a() {
        return f2963a;
    }

    public static String a(int i) {
        return i == 1 ? "cm" : i == 3 ? UserDataStore.CITY : i == 2 ? "uni" : "";
    }

    public final String a(String str) {
        if (C0455pa.a(str) || "unknown".equals(str)) {
            return "";
        }
        synchronized (this.f2964b) {
            String str2 = this.f2964b.get(str);
            return !C0455pa.a(str2) ? str2 : "";
        }
    }

    public final void a(String str, boolean z) {
        try {
            if (C0455pa.a(str)) {
                return;
            }
            synchronized (this.f2964b) {
                this.f2964b.clear();
                String[] strArrSplit = str.split("h;l");
                if (strArrSplit != null) {
                    for (String str2 : strArrSplit) {
                        String[] strArrSplit2 = str2.split("h,l");
                        if (strArrSplit2.length == 2) {
                            this.f2964b.put(strArrSplit2[0], strArrSplit2[1]);
                        }
                    }
                }
            }
            if (z) {
                C0446ma.a("HalleyOperInfo_" + fc.c(), str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f2964b) {
            ArrayList arrayList = new ArrayList(this.f2964b.keySet());
            ArrayList arrayList2 = new ArrayList(this.f2964b.values());
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                String str2 = (String) arrayList2.get(i);
                sb.append(str);
                sb.append("h,l");
                sb.append(str2);
                sb.append("h;l");
            }
        }
        return sb.toString();
    }

    public final void a(String str, String str2) {
        if (C0455pa.a(str) || "unknown".equals(str) || C0455pa.a(str2) || "unknown".equals(str2)) {
            return;
        }
        synchronized (this.f2964b) {
            if (!str2.equals(this.f2964b.get(str))) {
                this.f2964b.put(str, str2);
                C0446ma.a("HalleyOperInfo_" + fc.c(), b());
            }
        }
    }
}
