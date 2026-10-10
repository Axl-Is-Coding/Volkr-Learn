package com.disabngo.blockynexus.e.b.S;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.ChatRoomResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: PartyCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
class q extends OnResponseListener<ChatRoomResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f9429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f9430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f9431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f9432f;
    final /* synthetic */ int g;
    final /* synthetic */ String h;
    final /* synthetic */ String i;
    final /* synthetic */ ObservableField j;
    final /* synthetic */ t k;

    q(t tVar, Context context, String str, int i, int i2, int i3, int i4, int i5, String str2, String str3, ObservableField observableField) {
        this.k = tVar;
        this.f9427a = context;
        this.f9428b = str;
        this.f9429c = i;
        this.f9430d = i2;
        this.f9431e = i3;
        this.f9432f = i4;
        this.g = i5;
        this.h = str2;
        this.i = str3;
        this.j = observableField;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ChatRoomResponse chatRoomResponse) {
        this.k.a(this.f9427a, chatRoomResponse.getRoomId(), this.f9428b, this.f9429c, this.f9430d, this.f9431e, this.f9432f, this.g, this.h, this.i, this.j);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f9427a, R.string.party_create_chat_room_failed);
        this.j.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f9427a, R.string.party_create_chat_room_failed);
        this.j.set(false);
    }
}
