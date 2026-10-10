package com.disabngo.blockynexus.d;

import android.net.Uri;
import com.sandboxol.greendao.entity.TribeMember;
import io.rong.imlib.model.UserInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.d.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DbTribeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0508e implements com.sandboxol.greendao.a.c<List<TribeMember>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f7219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0509f f7220b;

    C0508e(C0509f c0509f, com.sandboxol.greendao.a.c cVar) {
        this.f7220b = c0509f;
        this.f7219a = cVar;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<TribeMember> list) {
        ArrayList arrayList = new ArrayList();
        for (TribeMember tribeMember : list) {
            arrayList.add(new UserInfo(String.valueOf(tribeMember.getUserId()), tribeMember.getNickName(), tribeMember.getHeadPic() == null ? null : Uri.parse(tribeMember.getHeadPic())));
        }
        this.f7219a.onSuccess(arrayList);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
