package com.sandboxol.greendao.c;

import com.github.yuweiguocn.library.greendao.a;
import com.sandboxol.greendao.entity.DaoMaster;

/* JADX INFO: compiled from: DBOpenHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class H implements a.InterfaceC0100a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f18426a;

    H(I i) {
        this.f18426a = i;
    }

    @Override // com.github.yuweiguocn.library.greendao.a.InterfaceC0100a
    public void a(org.greenrobot.greendao.b.a aVar, boolean z) {
        DaoMaster.createAllTables(aVar, z);
    }

    @Override // com.github.yuweiguocn.library.greendao.a.InterfaceC0100a
    public void b(org.greenrobot.greendao.b.a aVar, boolean z) {
        DaoMaster.dropAllTables(aVar, z);
    }
}
