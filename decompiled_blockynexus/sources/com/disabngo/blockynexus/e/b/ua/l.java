package com.disabngo.blockynexus.e.b.ua;

import com.disabngo.blockynexus.entity.TribeTaskList;
import com.disabngo.blockynexus.view.dialog.Sa;
import com.disabngo.blockynexus.view.fragment.tribehas.Q;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeTaskPageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f10210a;

    l(m mVar) {
        this.f10210a = mVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(((ListItemViewModel) this.f10210a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10210a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        Q.a(((ListItemViewModel) this.f10210a).context);
        this.f10210a.f10212b.set(3);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_TRIBE_HAS);
        Sa sa = new Sa(((ListItemViewModel) this.f10210a).context);
        sa.a(((TribeTaskList) ((ListItemViewModel) this.f10210a).item).getExperienceReward(), ((TribeTaskList) ((ListItemViewModel) this.f10210a).item).getCurrencyReward());
        sa.show();
        Messenger.getDefault().send(Integer.valueOf(this.f10210a.f10211a), MessageToken.TOKEN_TRIBE_TASK);
    }
}
