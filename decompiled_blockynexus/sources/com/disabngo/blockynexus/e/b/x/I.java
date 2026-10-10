package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: compiled from: FriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class I implements com.sandboxol.greendao.a.c<List<Friend>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f10286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f10289d;

    I(boolean z, Context context, OnResponseListener onResponseListener, String str) {
        this.f10286a = z;
        this.f10287b = context;
        this.f10288c = onResponseListener;
        this.f10289d = str;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Friend> list) {
        J.b((List<Friend>) list, this.f10286a);
        FriendApi.friendStatus(this.f10287b, new H(this, list));
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f10288c.onError(i, str);
        Context context = this.f10287b;
        AppToastUtils.showShortNegativeTipToast(context, HttpUtils.getHttpErrorMsg(context, -1));
    }
}
