package com.disabngo.blockynexus.e.b.S;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C0507d;
import com.disabngo.blockynexus.e.b.y.C0958i;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: PartyCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
class r extends OnResponseListener<PartyAuthInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f9435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f9436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f9437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f9438f;
    final /* synthetic */ String g;
    final /* synthetic */ String h;
    final /* synthetic */ int i;
    final /* synthetic */ Context j;
    final /* synthetic */ ObservableField k;
    final /* synthetic */ t l;

    r(t tVar, String str, String str2, int i, int i2, int i3, int i4, String str3, String str4, int i5, Context context, ObservableField observableField) {
        this.l = tVar;
        this.f9433a = str;
        this.f9434b = str2;
        this.f9435c = i;
        this.f9436d = i2;
        this.f9437e = i3;
        this.f9438f = i4;
        this.g = str3;
        this.h = str4;
        this.i = i5;
        this.j = context;
        this.k = observableField;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.j, str);
        this.k.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.j, R.string.party_create_chat_room_failed);
        this.k.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PartyAuthInfo partyAuthInfo) {
        new C0958i().a(this.j, this.h, C0507d.a(partyAuthInfo, this.f9433a, this.f9434b, this.f9435c, this.f9436d, this.f9437e, this.f9438f, this.g, this.h, this.i, partyAuthInfo.getCountry()), this.k, this.l.f9440a);
    }
}
