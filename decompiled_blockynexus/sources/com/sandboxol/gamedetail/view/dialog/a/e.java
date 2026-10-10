package com.sandboxol.gamedetail.view.dialog.a;

import android.content.Context;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: AuthorListItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class e implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f18120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f18121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ f f18122c;

    e(f fVar, Context context, boolean z) {
        this.f18122c = fVar;
        this.f18120a = context;
        this.f18121b = z;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        if (friend != null && friend.getNickName() != null) {
            this.f18122c.f18124b.set(true);
        }
        this.f18122c.f18123a.set(this.f18120a.getString(R.string.gamedetail_is_friend));
        this.f18122c.f18125c.set(Boolean.valueOf(this.f18121b));
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
