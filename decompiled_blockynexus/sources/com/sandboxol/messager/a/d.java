package com.sandboxol.messager.a;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: MsgAction1.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f18791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    b f18792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Type f18793c;

    public d(Type type, String str, b bVar) {
        this.f18793c = type;
        this.f18791a = str;
        this.f18792b = bVar;
    }

    public b a() {
        return this.f18792b;
    }

    public String b() {
        return this.f18791a;
    }

    public Type c() {
        return this.f18793c;
    }
}
