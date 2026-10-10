package com.disabngo.blockynexus.e.b.b;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Vc;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.b.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AccountSafeFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0819f extends TemplateFragment<C0820g, Vc> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Vc vc, C0820g c0820g) {
        vc.a(c0820g);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_account_safe;
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
    public C0820g getViewModel() {
        return new C0820g(this.context);
    }
}
