package com.disabngo.blockynexus.view.fragment.partyhall;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleInfo.game.team.listener.IPartyListListener;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyList;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponse;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedParties;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedParties;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import io.grpc.Status;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: PartyHallModel.java */
/* JADX INFO: loaded from: classes2.dex */
class y implements IPartyListListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f11955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f11956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f11957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PartyAuthInfo f11958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ObservableField f11959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ E f11960f;

    y(E e2, ObservableField observableField, List list, Context context, PartyAuthInfo partyAuthInfo, ObservableField observableField2) {
        this.f11960f = e2;
        this.f11955a = observableField;
        this.f11956b = list;
        this.f11957c = context;
        this.f11958d = partyAuthInfo;
        this.f11959e = observableField2;
    }

    static /* synthetic */ void a(List list, PartyItem partyItem) {
        for (int i = 0; i < list.size(); i++) {
            if (partyItem.getTeamId().equals(((PartyItem) list.get(i)).getTeamId())) {
                list.set(i, partyItem);
            }
        }
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.IPartyListListener
    public void onTeamCompleted() {
        DialogUtils.newsInstant().hideLoadingDialog();
        this.f11955a.set(false);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.IPartyListListener
    public void onTeamError(Status status) {
        int i;
        DialogUtils.newsInstant().hideLoadingDialog();
        this.f11955a.set(false);
        if (status == null || (i = D.f11888a[status.getCode().ordinal()]) == 1) {
            return;
        }
        if (i == 2) {
            AppToastUtils.showShortNegativeTipToast(this.f11957c, R.string.team_disconnected_with_the_server);
        } else {
            if (i != 3) {
                return;
            }
            AppToastUtils.showShortNegativeTipToast(this.f11957c, R.string.time_out);
        }
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.listener.IPartyListListener
    public void onTeamNext(PartyListResponse partyListResponse) {
        this.f11955a.set(false);
        if (partyListResponse != null) {
            PartyList parties = partyListResponse.getParties();
            UpdatedParties updates = partyListResponse.getUpdates();
            RemovedParties removes = partyListResponse.getRemoves();
            if (parties != null && !parties.getPartiesList().isEmpty()) {
                this.f11956b.clear();
                this.f11956b.addAll(parties.getPartiesList());
            } else if (updates != null && !updates.getPartiesList().isEmpty()) {
                Observable observableFrom = Observable.from(updates.getPartiesList());
                final List list = this.f11956b;
                observableFrom.subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.d
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        y.a(list, (PartyItem) obj);
                    }
                });
            } else if (removes == null || removes.getTeamIdsList().isEmpty()) {
                this.f11956b.clear();
                DialogUtils.newsInstant().hideLoadingDialog();
            } else {
                Observable observableFrom2 = Observable.from(removes.getTeamIdsList());
                final List list2 = this.f11956b;
                observableFrom2.subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.c
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        y.a(list2, (String) obj);
                    }
                });
                if (this.f11956b.size() < 10) {
                    this.f11960f.a(this.f11957c, this.f11956b, this.f11955a, this.f11958d, this.f11959e);
                }
            }
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_PARTY);
        }
    }

    static /* synthetic */ void a(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(((PartyItem) it.next()).getTeamId())) {
                it.remove();
            }
        }
    }
}
