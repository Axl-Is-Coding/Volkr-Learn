package com.bytedance.sdk.a.b.a.e;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: PushObserver.java */
/* JADX INFO: loaded from: classes.dex */
public interface m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f5149a = new m() { // from class: com.bytedance.sdk.a.b.a.e.m.1
        @Override // com.bytedance.sdk.a.b.a.e.m
        public void a(int i, b bVar) {
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i, com.bytedance.sdk.a.a.e eVar, int i2, boolean z) throws IOException {
            eVar.h(i2);
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i, List<c> list) {
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i, List<c> list, boolean z) {
            return true;
        }
    };

    void a(int i, b bVar);

    boolean a(int i, com.bytedance.sdk.a.a.e eVar, int i2, boolean z) throws IOException;

    boolean a(int i, List<c> list);

    boolean a(int i, List<c> list, boolean z);
}
