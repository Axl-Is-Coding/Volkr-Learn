package com.disabngo.blockynexus.e.b.H;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0709re;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: GroupVerificationFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends TemplateFragment<l, AbstractC0709re> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0709re abstractC0709re, l lVar) {
        abstractC0709re.a(lVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_vertification;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public l getViewModel() {
        return new l(this.context);
    }
}
