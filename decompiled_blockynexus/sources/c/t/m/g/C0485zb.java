package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: c.t.m.g.zb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class C0485zb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f3454a;

    static {
        ArrayList arrayList = new ArrayList();
        f3454a = arrayList;
        arrayList.add("mobile");
        f3454a.add("16wifi");
        f3454a.add("cmcc");
        f3454a.add("360wifi");
        f3454a.add("androidap");
        f3454a.add("htcphone");
        f3454a.add("xiaomi");
        f3454a.add("lenovo");
        f3454a.add("macbook");
    }

    public static void a(List<ScanResult> list) {
        HashSet hashSet = new HashSet();
        Iterator<ScanResult> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next().BSSID;
            if (str == null || str.equals("000000000000") || str.equals("00-00-00-00-00-00") || str.equals("00:00:00:00:00:00")) {
                it.remove();
            } else if (hashSet.contains(str)) {
                it.remove();
            } else {
                hashSet.add(str);
            }
        }
    }
}
