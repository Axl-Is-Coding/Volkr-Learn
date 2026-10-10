package com.disabngo.blockynexus.d;

import com.sandboxol.greendao.c.ra;
import com.sandboxol.greendao.entity.TribeMember;
import io.rong.imlib.model.UserInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.d.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DbTribeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0509f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0509f f7221a;

    public static C0509f a() {
        if (f7221a == null) {
            f7221a = new C0509f();
        }
        return f7221a;
    }

    public void a(List<TribeMember> list) {
        Iterator<TribeMember> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void a(TribeMember tribeMember) {
        ra.newInstance().a(tribeMember);
    }

    public TribeMember a(long j) {
        return ra.newInstance().a(j);
    }

    public void a(com.sandboxol.greendao.a.c<List<UserInfo>> cVar) {
        ra.newInstance().a(new C0508e(this, cVar));
    }
}
