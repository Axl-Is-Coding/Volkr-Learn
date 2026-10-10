package com.disabngo.blockynexus.e.b.n;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.ModifyNameFreeResponse;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: ChangeNameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener<ModifyNameFreeResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f9958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f9959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f9960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ f f9961d;

    e(f fVar, ObservableField observableField, ObservableField observableField2, Context context) {
        this.f9961d = fVar;
        this.f9958a = observableField;
        this.f9959b = observableField2;
        this.f9960c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ModifyNameFreeResponse modifyNameFreeResponse) {
        this.f9958a.set(modifyNameFreeResponse);
        this.f9959b.set(Boolean.valueOf(modifyNameFreeResponse.isFree()));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f9960c, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9960c, i);
    }
}
