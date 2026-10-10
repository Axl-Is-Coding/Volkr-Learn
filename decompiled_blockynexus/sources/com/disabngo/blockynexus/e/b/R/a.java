package com.disabngo.blockynexus.e.b.R;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Le;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: NoticeFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends TemplateFragment<b, Le> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Le le, b bVar) {
        le.a(bVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_notice;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public b getViewModel() {
        return new b();
    }
}
