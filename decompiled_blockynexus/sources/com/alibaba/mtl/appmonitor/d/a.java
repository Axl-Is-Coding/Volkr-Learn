package com.alibaba.mtl.appmonitor.d;

import org.json.JSONObject;

/* JADX INFO: compiled from: AbstractSampling.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends JSONObject> {
    protected int n;

    public a(int i) {
        this.n = i;
    }

    protected void a(T t) {
        try {
            Integer numValueOf = Integer.valueOf(t.getInt("sampling"));
            if (numValueOf != null) {
                this.n = numValueOf.intValue();
            }
        } catch (Exception unused) {
        }
    }

    protected boolean a(int i) {
        return i < this.n;
    }
}
