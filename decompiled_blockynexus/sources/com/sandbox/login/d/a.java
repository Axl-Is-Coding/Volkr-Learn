package com.sandbox.login.d;

import com.github.yuweiguocn.library.greendao.a;
import com.sandbox.login.entity.DaoMaster;

/* JADX INFO: compiled from: DBOpenHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements a.InterfaceC0100a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f15705a;

    a(b bVar) {
        this.f15705a = bVar;
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
