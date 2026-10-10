package com.disabngo.blockynexus.e.b.O;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.entity.TribeClanMembersBean;
import com.sandboxol.center.entity.TribeDetail;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import java.util.List;

/* JADX INFO: compiled from: MakeFriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends OnResponseListener<TribeDetail> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f9383b;

    p(q qVar, Context context) {
        this.f9383b = qVar;
        this.f9382a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeDetail tribeDetail) {
        TribeCenter.newInstance().updateDetailInfo(tribeDetail);
        N.a(tribeDetail.getClanId(), tribeDetail.getName() + "(" + this.f9382a.getString(R.string.main_tribe) + ")", tribeDetail.getHeadPic());
        y.b().a(this.f9382a);
        u.a().a(tribeDetail.getTags());
        u uVarA = u.a();
        q qVar = this.f9383b;
        List<TribeClanMembersBean> clanMembers = tribeDetail.getClanMembers();
        q.a(qVar, clanMembers);
        uVarA.b(clanMembers);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_TRIBE_INFO_TAG);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_TRIBE_INFO_MEMBERS);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9382a, i);
    }
}
