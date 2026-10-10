package com.disabngo.blockynexus.view.fragment.partyhall;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.center.utils.AppSharedUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TemplateHelper;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;

/* JADX INFO: compiled from: PartyHallModel.java */
/* JADX INFO: loaded from: classes2.dex */
class z extends OnResponseListener<List<AllGameIdInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f11961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnDataListener f11962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f11963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f11964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ E f11965e;

    z(E e2, ObservableField observableField, OnDataListener onDataListener, boolean z, Context context) {
        this.f11965e = e2;
        this.f11961a = observableField;
        this.f11962b = onDataListener;
        this.f11963c = z;
        this.f11964d = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11964d, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<AllGameIdInfo> list) {
        AppSharedUtils.newInstance().putAllGameIdInfo(list);
        this.f11961a.set(true);
        OnDataListener onDataListener = this.f11962b;
        if (onDataListener != null) {
            onDataListener.onSuccess(list);
            return;
        }
        if (this.f11963c) {
            if (list == null || list.size() <= 0) {
                AppToastUtils.showShortNegativeTipToast(this.f11964d, R.string.party_not_start);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(StringConstant.PARTY_CREATE_ALL_GAME_ID_INFO, new com.google.gson.j().a(list));
            Context context = this.f11964d;
            TemplateHelper.startTemplate(context, com.disabngo.blockynexus.e.b.S.l.class, context.getString(R.string.party_create_party), bundle);
        }
    }
}
