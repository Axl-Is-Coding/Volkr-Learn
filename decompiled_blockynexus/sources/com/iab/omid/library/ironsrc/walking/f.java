package com.iab.omid.library.ironsrc.walking;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f14579a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, View> f14580b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<View, ArrayList<String>> f14581c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f14582d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f14583e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f14584f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private boolean h;

    private void a(View view, com.iab.omid.library.ironsrc.adsession.g gVar) {
        ArrayList<String> arrayList = this.f14581c.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f14581c.put(view, arrayList);
        }
        arrayList.add(gVar.i());
    }

    private void a(com.iab.omid.library.ironsrc.adsession.g gVar) {
        Iterator<b.e.a.a.a.e.a> it = gVar.c().iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null) {
                a(view, gVar);
            }
        }
    }

    private String d(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strE = b.e.a.a.a.d.f.e(view);
            if (strE != null) {
                return strE;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f14582d.addAll(hashSet);
        return null;
    }

    public String a(View view) {
        if (this.f14579a.size() == 0) {
            return null;
        }
        String str = this.f14579a.get(view);
        if (str != null) {
            this.f14579a.remove(view);
        }
        return str;
    }

    public String a(String str) {
        return this.g.get(str);
    }

    public HashSet<String> a() {
        return this.f14583e;
    }

    public View b(String str) {
        return this.f14580b.get(str);
    }

    public ArrayList<String> b(View view) {
        if (this.f14581c.size() == 0) {
            return null;
        }
        ArrayList<String> arrayList = this.f14581c.get(view);
        if (arrayList != null) {
            this.f14581c.remove(view);
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public HashSet<String> b() {
        return this.f14584f;
    }

    public c c(View view) {
        return this.f14582d.contains(view) ? c.PARENT_VIEW : this.h ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void c() {
        b.e.a.a.a.b.a aVarA = b.e.a.a.a.b.a.a();
        if (aVarA != null) {
            for (com.iab.omid.library.ironsrc.adsession.g gVar : aVarA.c()) {
                View viewE = gVar.e();
                if (gVar.f()) {
                    String strI = gVar.i();
                    if (viewE != null) {
                        String strD = d(viewE);
                        if (strD == null) {
                            this.f14583e.add(strI);
                            this.f14579a.put(viewE, strI);
                            a(gVar);
                        } else {
                            this.f14584f.add(strI);
                            this.f14580b.put(strI, viewE);
                            this.g.put(strI, strD);
                        }
                    } else {
                        this.f14584f.add(strI);
                        this.g.put(strI, "noAdView");
                    }
                }
            }
        }
    }

    public void d() {
        this.f14579a.clear();
        this.f14580b.clear();
        this.f14581c.clear();
        this.f14582d.clear();
        this.f14583e.clear();
        this.f14584f.clear();
        this.g.clear();
        this.h = false;
    }

    public void e() {
        this.h = true;
    }
}
