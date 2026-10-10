package com.disabngo.blockynexus.e.b.q;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ed;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.q.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskGameManageFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0905f extends TemplateFragment<n, Ed> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Ed ed, n nVar) {
        ed.a(nVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_disk_game_manage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public n getViewModel() {
        return new n(this.context);
    }
}
