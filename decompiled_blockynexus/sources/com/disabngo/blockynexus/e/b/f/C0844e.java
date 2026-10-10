package com.disabngo.blockynexus.e.b.f;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0632kd;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.f.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindPhoneFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0844e extends TemplateFragment<C0848i, AbstractC0632kd> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0632kd abstractC0632kd, C0848i c0848i) {
        abstractC0632kd.a(c0848i);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_bind_phone;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public C0848i getViewModel() {
        return new C0848i(this.context);
    }
}
