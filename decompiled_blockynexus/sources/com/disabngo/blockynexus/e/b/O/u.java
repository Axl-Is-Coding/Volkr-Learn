package com.disabngo.blockynexus.e.b.O;

import com.sandboxol.center.entity.TribeClanMembersBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MakefriendCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f9390a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f9391b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<TribeClanMembersBean> f9392c = new ArrayList();

    public static u a() {
        return f9390a;
    }

    public void b(List<TribeClanMembersBean> list) {
        this.f9392c.clear();
        this.f9392c.addAll(list);
    }

    public List<TribeClanMembersBean> c() {
        return this.f9392c;
    }

    public void a(List<String> list) {
        this.f9391b = list;
    }

    public List<String> b() {
        return this.f9391b;
    }
}
