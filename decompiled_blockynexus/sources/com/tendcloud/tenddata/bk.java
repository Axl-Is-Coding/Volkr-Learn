package com.tendcloud.tenddata;

import com.tendcloud.tenddata.bw;
import com.tendcloud.tenddata.zz;
import java.util.Map;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bk f19860a;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bk() {
    }

    public static bk a() {
        if (f19860a == null) {
            synchronized (bk.class) {
                if (f19860a == null) {
                    f19860a = new bk();
                }
            }
        }
        return f19860a;
    }

    public final void onTDEBEventIAP(zz.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.paraMap != null && Integer.parseInt(String.valueOf(aVar.paraMap.get("apiType"))) == 8) {
                    bx bxVar = new bx();
                    Object obj = aVar.paraMap.get("data");
                    a aVar2 = (a) aVar.paraMap.get("service");
                    bxVar.f19906b = String.valueOf(aVar.paraMap.get("domain"));
                    bxVar.f19907c = String.valueOf(aVar.paraMap.get("action"));
                    if (obj instanceof Map) {
                        bxVar.f19908d = (Map) obj;
                    }
                    bxVar.f19905a = aVar2;
                    ag.a().post(bxVar);
                    bw bwVar = new bw();
                    bwVar.f19903a = aVar2;
                    bwVar.f19904b = bw.a.IMMEDIATELY;
                    ag.a().post(bwVar);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
