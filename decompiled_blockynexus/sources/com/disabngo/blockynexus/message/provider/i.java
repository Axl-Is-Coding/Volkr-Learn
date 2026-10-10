package com.disabngo.blockynexus.message.provider;

import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.view.dialog.ScrapMakeSureDialog;
import com.sandboxol.imchat.message.entity.ScrapHelpMessage;

/* JADX INFO: compiled from: ScrapAskHelpProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements ScrapMakeSureDialog.OnMakeSureClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScrapAskHelpProvider$1$1 f10471a;

    i(ScrapAskHelpProvider$1$1 scrapAskHelpProvider$1$1) {
        this.f10471a = scrapAskHelpProvider$1$1;
    }

    @Override // com.sandboxol.center.view.dialog.ScrapMakeSureDialog.OnMakeSureClickListener
    public void onSure(String str) {
        if (str != null) {
            N.a(this.f10471a.f10428b.f10472a.getContext(), new ScrapHelpMessage(AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().nickName.get(), this.f10471a.f10428b.f10473b.getScrapId(), this.f10471a.f10428b.f10473b.getScrapName(), this.f10471a.f10428b.f10473b.getScrapPic(), this.f10471a.f10428b.f10473b.getScrapLevel(), this.f10471a.f10428b.f10473b.getScrapNum(), str, this.f10471a.f10428b.f10473b.getScrapDesc(), this.f10471a.f10428b.f10473b.getScrapValue()), String.valueOf(this.f10471a.f10428b.f10473b.getUserId()), true);
        }
    }
}
