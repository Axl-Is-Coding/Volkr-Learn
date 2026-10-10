package com.disabngo.blockynexus.e.b.F;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.CreateGroupPrice;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupMemberModel.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends OnResponseListener<CreateGroupPrice> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f9264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f9265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f9266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f9267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ q f9268e;

    o(q qVar, ObservableField observableField, ObservableField observableField2, ObservableField observableField3, Context context) {
        this.f9268e = qVar;
        this.f9264a = observableField;
        this.f9265b = observableField2;
        this.f9266c = observableField3;
        this.f9267d = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(CreateGroupPrice createGroupPrice) {
        this.f9264a.set(Integer.valueOf(createGroupPrice.getCurrency()));
        if (createGroupPrice.getPrice() == 0) {
            this.f9265b.set(3);
            this.f9266c.set(0);
        } else {
            this.f9265b.set(Integer.valueOf(createGroupPrice.getCurrency()));
            this.f9266c.set(Integer.valueOf(createGroupPrice.getPrice()));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9267d, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9267d, i);
    }
}
