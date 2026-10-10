package c.t.m.g;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: renamed from: c.t.m.g.bb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0414bb implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f3095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f3096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f3097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f3099e;

    public final synchronized String a() {
        return this.f3098d;
    }

    public final synchronized void a(String str) {
        this.f3098d = str;
    }

    public final synchronized void a(Map<String, String> map) {
        this.f3099e = map;
    }

    public final synchronized Map<String, String> b() {
        return this.f3099e;
    }
}
