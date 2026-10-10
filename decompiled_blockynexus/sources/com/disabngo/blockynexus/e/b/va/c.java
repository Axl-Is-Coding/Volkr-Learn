package com.disabngo.blockynexus.e.b.va;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0581fg;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: VerificationFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends TemplateFragment<d, AbstractC0581fg> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10249a = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0581fg abstractC0581fg, d dVar) {
        abstractC0581fg.a(dVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_verification;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public d getViewModel() {
        if (getArguments() != null) {
            this.f10249a = getArguments().getInt(SharedConstant.KEY_GROUP_NEW_STATUS);
        }
        return new d(this.context, this, this.f10249a);
    }
}
