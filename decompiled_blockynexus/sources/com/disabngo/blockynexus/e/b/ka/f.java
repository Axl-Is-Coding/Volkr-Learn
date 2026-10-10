package com.disabngo.blockynexus.e.b.ka;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0787yf;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: TribalDonationInstructionsFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends TemplateFragment<g, AbstractC0787yf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0787yf abstractC0787yf, g gVar) {
        abstractC0787yf.a(gVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribal_donation_instructions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public g getViewModel() {
        return new g();
    }
}
