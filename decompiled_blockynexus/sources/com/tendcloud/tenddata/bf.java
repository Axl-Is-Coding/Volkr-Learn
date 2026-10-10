package com.tendcloud.tenddata;

import com.tendcloud.tenddata.zz;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bf f19849a;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private bf() {
    }

    public static bf a() {
        if (f19849a == null) {
            synchronized (bf.class) {
                if (f19849a == null) {
                    f19849a = new bf();
                }
            }
        }
        return f19849a;
    }

    private void a(Map<String, Object> map) {
    }

    private Map<String, Object> b(Map<String, Object> map) {
        TreeMap treeMap = new TreeMap();
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return treeMap;
                }
                int i = 0;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() instanceof Number) {
                        treeMap.put(entry.getKey(), entry.getValue());
                    } else {
                        treeMap.put(af.a(String.valueOf(entry.getKey())), af.a(String.valueOf(entry.getValue())));
                    }
                    i++;
                    if (i == 50) {
                        break;
                    }
                }
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
        return treeMap;
    }

    public final void onTDEBEventAppEvent(zz.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.paraMap != null && Integer.parseInt(String.valueOf(aVar.paraMap.get("apiType"))) == 2) {
                    a aVar2 = (a) aVar.paraMap.get("service");
                    TreeMap treeMap = new TreeMap();
                    String strValueOf = String.valueOf(aVar.paraMap.get("eventId"));
                    Object obj = aVar.paraMap.get("value");
                    if (ab.f19750d.size() > 0 && strValueOf != null) {
                        treeMap.putAll(ab.f19750d);
                    }
                    Object obj2 = aVar.paraMap.get("map");
                    if (obj2 != null && (obj2 instanceof Map)) {
                        treeMap.putAll((Map) obj2);
                    }
                    bx bxVar = new bx();
                    bxVar.f19906b = "appEvent";
                    bxVar.f19907c = strValueOf;
                    bxVar.f19905a = aVar2;
                    TreeMap treeMap2 = new TreeMap();
                    treeMap2.put("eventLabel", String.valueOf(aVar.paraMap.get("eventLabel")));
                    Map<String, Object> mapB = b(treeMap);
                    a(mapB);
                    treeMap2.put("eventParam", new JSONObject(mapB));
                    if (obj instanceof Double) {
                        treeMap2.put("value", obj);
                    }
                    bxVar.f19908d = treeMap2;
                    ag.a().post(bxVar);
                }
            } catch (NumberFormatException e2) {
                bp.postSDKError(e2);
            }
        }
    }
}
