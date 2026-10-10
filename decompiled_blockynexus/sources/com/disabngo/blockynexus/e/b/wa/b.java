package com.disabngo.blockynexus.e.b.wa;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0520ad;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: VideoFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends TemplateFragment<d, AbstractC0520ad> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0520ad abstractC0520ad, d dVar) {
        abstractC0520ad.a(dVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_app_video;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public d getViewModel() {
        return new d(this.context, this);
    }
}
