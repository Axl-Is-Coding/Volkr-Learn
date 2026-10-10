package com.ironsource.mediationsdk;

import com.alibaba.android.arouter.utils.Consts;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AdapterRepository.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2313c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C2313c f14793a = new C2313c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f14794b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean f14798f;
    private Boolean g;
    private AtomicBoolean i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, AbstractC2311b> f14795c = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<String>> h = new ConcurrentHashMap<>();

    private C2313c() {
    }

    public static C2313c a() {
        return f14793a;
    }

    private void b(AbstractC2311b abstractC2311b) {
        try {
            if (this.f14798f != null) {
                abstractC2311b.setConsent(this.f14798f.booleanValue());
            }
        } catch (Throwable th) {
            b("error while setting consent of " + abstractC2311b.getProviderName() + ": " + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    private void c(AbstractC2311b abstractC2311b) {
        for (String str : this.h.keySet()) {
            try {
                abstractC2311b.setMetaData(str, this.h.get(str));
            } catch (Throwable th) {
                b("error while setting metadata of " + abstractC2311b.getProviderName() + ": " + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
    }

    public void a(String str, String str2) {
        this.f14796d = str;
        this.f14797e = str2;
    }

    public AbstractC2311b a(com.ironsource.mediationsdk.model.p pVar) {
        String strB = b(pVar);
        if (pVar.i().equalsIgnoreCase("SupersonicAds")) {
            return this.f14795c.get(strB);
        }
        return b(strB, pVar.i());
    }

    private AbstractC2311b b(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.ironsource.adapters." + com.ironsource.environment.c.a(str2) + Consts.DOT + str2 + "Adapter");
            return (AbstractC2311b) cls.getMethod("startAdapter", String.class).invoke(cls, str);
        } catch (Exception e2) {
            a("Error while loading adapter - exception = " + e2);
            return null;
        }
    }

    public AbstractC2311b a(com.ironsource.mediationsdk.model.p pVar, JSONObject jSONObject) {
        return a(pVar, jSONObject, false);
    }

    private void b(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "AdapterRepository: " + str, 0);
    }

    public AbstractC2311b a(com.ironsource.mediationsdk.model.p pVar, JSONObject jSONObject, boolean z) {
        return a(b(pVar), z ? "IronSource" : pVar.i(), jSONObject);
    }

    public ConcurrentHashMap<String, List<String>> b() {
        return this.h;
    }

    private String b(com.ironsource.mediationsdk.model.p pVar) {
        return pVar.m() ? pVar.i() : pVar.h();
    }

    private AbstractC2311b a(String str, String str2, JSONObject jSONObject) {
        b(str + " (" + str2 + ") - Getting adapter");
        synchronized (f14794b) {
            if (this.f14795c.containsKey(str)) {
                b(str + " was already allocated");
                return this.f14795c.get(str);
            }
            AbstractC2311b abstractC2311bB = b(str, str2);
            if (abstractC2311bB == null) {
                a(str + " adapter was not loaded");
                return null;
            }
            b(str + " was allocated (adapter version: " + abstractC2311bB.getVersion() + ", sdk version: " + abstractC2311bB.getCoreSDKVersion() + ")");
            abstractC2311bB.setLogListener(com.ironsource.mediationsdk.logger.c.c());
            c(abstractC2311bB);
            b(abstractC2311bB);
            a(abstractC2311bB);
            a(jSONObject, abstractC2311bB, str2);
            this.f14795c.put(str, abstractC2311bB);
            return abstractC2311bB;
        }
    }

    private void a(JSONObject jSONObject, AbstractC2311b abstractC2311b, String str) {
        if ((str.equalsIgnoreCase("SupersonicAds") || str.equalsIgnoreCase("IronSource")) && this.i.compareAndSet(false, true)) {
            b("SDK5 earlyInit  <" + str + ">");
            abstractC2311b.earlyInit(this.f14796d, this.f14797e, jSONObject);
        }
    }

    private void a(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "AdapterRepository: " + str, 3);
    }

    private void a(AbstractC2311b abstractC2311b) {
        Boolean bool = this.g;
        if (bool != null) {
            try {
                abstractC2311b.setAdapterDebug(bool);
            } catch (Throwable th) {
                b("error while setting adapterDebug of " + abstractC2311b.getProviderName() + ": " + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
    }
}
