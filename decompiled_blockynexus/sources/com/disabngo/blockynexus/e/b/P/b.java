package com.disabngo.blockynexus.e.b.P;

import android.content.Context;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.model.IModel;

/* JADX INFO: compiled from: MiniGameDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements IModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9394a;

    public b(Context context) {
        this.f9394a = context;
    }

    public void a(String str) {
        GameApi.deleteChatRoom(this.f9394a, str, new a(this));
    }
}
