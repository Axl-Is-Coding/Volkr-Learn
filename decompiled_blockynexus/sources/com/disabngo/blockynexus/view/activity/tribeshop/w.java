package com.disabngo.blockynexus.view.activity.tribeshop;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0765wf;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: TribalCurrencyDescriptionFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends TemplateFragment<x, AbstractC0765wf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0765wf abstractC0765wf, x xVar) {
        abstractC0765wf.a(xVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribal_currency_description;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public x getViewModel() {
        return new x();
    }
}
