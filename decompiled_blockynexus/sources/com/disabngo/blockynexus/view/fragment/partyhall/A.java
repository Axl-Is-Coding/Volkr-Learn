package com.disabngo.blockynexus.view.fragment.partyhall;

import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleInfo.game.team.listener.IQuickInListener;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyList;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponse;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.utils.AppToastUtils;
import io.grpc.Status;

/* JADX INFO: compiled from: PartyHallModel.java */
/* JADX INFO: loaded from: classes2.dex */
class A implements IQuickInListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PartyAuthInfo f11879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f11880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f11881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ E f11882e;

    A(E e2, Context context, PartyAuthInfo partyAuthInfo, String str, String str2) {
        this.f11882e = e2;
        this.f11878a = context;
        this.f11879b = partyAuthInfo;
        this.f11880c = str;
        this.f11881d = str2;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.IQuickInListener
    public void onTeamCompleted() {
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.IQuickInListener
    public void onTeamError(Status status) {
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.IQuickInListener
    public void onTeamNext(PartyListResponse partyListResponse) {
        if (partyListResponse != null) {
            PartyList parties = partyListResponse.getParties();
            if (parties != null && parties.getPartiesList() != null && parties.getPartiesList().size() > 0) {
                this.f11882e.a(this.f11878a, this.f11879b, parties.getPartiesList().get(0));
                return;
            }
            if (!TextUtils.isEmpty(this.f11880c) && !TextUtils.isEmpty(this.f11881d)) {
                DialogUtils.newsInstant().hideLoadingDialog();
                AppToastUtils.showLongNegativeTipToast(this.f11878a, R.string.app_party_quick_in_gameid_language_no_room);
            } else if (!TextUtils.isEmpty(this.f11880c)) {
                DialogUtils.newsInstant().hideLoadingDialog();
                AppToastUtils.showLongNegativeTipToast(this.f11878a, R.string.app_party_quick_in_gameid_no_room);
            } else if (TextUtils.isEmpty(this.f11881d)) {
                DialogUtils.newsInstant().hideLoadingDialog();
                AppToastUtils.showLongNegativeTipToast(this.f11878a, R.string.app_party_quick_in_no_room);
            } else {
                DialogUtils.newsInstant().hideLoadingDialog();
                AppToastUtils.showLongNegativeTipToast(this.f11878a, R.string.app_party_quick_in_language_no_room);
            }
        }
    }
}
