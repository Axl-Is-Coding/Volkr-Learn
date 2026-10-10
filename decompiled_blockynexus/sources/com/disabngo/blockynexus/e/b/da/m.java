package com.disabngo.blockynexus.e.b.da;

import com.google.android.material.tabs.TabLayout;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: ScrapMainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements TabLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f9713a;

    m(o oVar) {
        this.f9713a = oVar;
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabReselected(TabLayout.f fVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabSelected(TabLayout.f fVar) {
        fVar.b(this.f9713a.f9720f[fVar.c()]);
        if (fVar.c() == 0 || ((Boolean) this.f9713a.i.get(Integer.valueOf(fVar.c()))).booleanValue()) {
            return;
        }
        this.f9713a.i.put(Integer.valueOf(fVar.c()), true);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_SCRAP_LIST + fVar.c());
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabUnselected(TabLayout.f fVar) {
        fVar.b(this.f9713a.g[fVar.c()]);
    }
}
