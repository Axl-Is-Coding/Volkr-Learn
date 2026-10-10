package com.alibaba.mtl.appmonitor.c;

import org.json.JSONArray;

/* JADX INFO: compiled from: ReuseJSONArray.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends JSONArray implements b {
    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        for (int i = 0; i < length(); i++) {
            Object objOpt = opt(i);
            if (objOpt != null && (objOpt instanceof b)) {
                a.a().a((b) objOpt);
            }
        }
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
    }
}
