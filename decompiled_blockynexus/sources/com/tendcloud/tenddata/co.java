package com.tendcloud.tenddata;

import java.util.HashMap;
import java.util.TreeSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class co {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static byte[] f19955d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static HashMap<String, String> f19952a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static HashMap<String, String> f19953b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static String f19954c = "utf-8";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile co f19956e = null;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private co() {
        String strC = af.c(ab.g.getPackageName());
        if (ab.g == null || strC == null) {
            f19955d = ab.class.getSimpleName().getBytes();
        } else {
            f19955d = strC.getBytes();
        }
    }

    public TreeSet<cp> a(a aVar) {
        TreeSet treeSet = new TreeSet();
        TreeSet<cp> treeSetA = null;
        try {
            treeSetA = cq.a().a(aVar, 100, (String) null);
            if (treeSetA != null && treeSetA.size() > 0) {
                for (cp cpVar : treeSetA) {
                    try {
                        cpVar.writeData(af.b(cpVar.c(), f19955d));
                    } catch (Throwable unused) {
                    }
                }
                treeSet.addAll(treeSetA);
                treeSetA.clear();
            }
            int size = treeSetA == null ? 0 : treeSetA.size();
            if (size < 100 && (treeSetA = cq.a().a(aVar, 100 - size, aVar.getRootFolder())) != null && treeSetA.size() > 0) {
                for (cp cpVar2 : treeSetA) {
                    try {
                        byte[] bArrB = at.b(cpVar2.c());
                        if (bArrB != null && bArrB.length != 0) {
                            cpVar2.writeData(bArrB);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
            if (treeSet.size() > 0 && treeSetA != null) {
                treeSetA.addAll(treeSet);
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        return treeSetA;
    }

    public final synchronized void onTDEBEventDataStore(bx bxVar) {
        if (bxVar == null) {
            return;
        }
        try {
            if (bxVar.f19905a.getMessageFormat().equals(a.MF_JSON)) {
                if (bxVar.f19905a == null) {
                    return;
                }
                cu cuVar = new cu(bxVar.f19906b, bxVar.f19907c);
                cuVar.setData(bxVar.f19908d);
                JSONObject jSONObjectA = bxVar.f19905a.name().equals("BG") ? null : dj.a().a(cuVar, true, bxVar.f19905a, bxVar.f19909e);
                if (jSONObjectA == null) {
                } else {
                    cq.a().a(new cp(at.a(jSONObjectA.toString().getBytes())), bxVar);
                }
            } else if (bxVar.f19905a.getMessageFormat().equals(a.MF_STRING)) {
                String str = bxVar.g;
                if (af.b(str)) {
                } else {
                    cq.a().a(new cp(at.a(str.getBytes())), bxVar);
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void sendMessageFaild(a aVar) {
        try {
            cq.a().clearDataCache(aVar);
        } catch (Throwable unused) {
        }
    }

    public void sendMessageSuccess(a aVar) {
        try {
            cq.a().confirmRead(aVar);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static co a() {
        if (f19956e == null) {
            synchronized (co.class) {
                if (f19956e == null) {
                    f19956e = new co();
                }
            }
        }
        return f19956e;
    }
}
