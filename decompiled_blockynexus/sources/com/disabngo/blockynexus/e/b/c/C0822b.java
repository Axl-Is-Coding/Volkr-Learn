package com.disabngo.blockynexus.e.b.c;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Zc;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.c.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0822b extends TemplateFragment<C0827g, Zc> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Zc zc, C0827g c0827g) {
        zc.a(c0827g);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public C0827g getViewModel() {
        return new C0827g(this.activity);
    }
}
