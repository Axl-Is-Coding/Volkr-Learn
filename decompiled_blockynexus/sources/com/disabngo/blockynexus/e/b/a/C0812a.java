package com.disabngo.blockynexus.e.b.a;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Tc;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.a.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AboutFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0812a extends TemplateFragment<C0813b, Tc> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Tc tc, C0813b c0813b) {
        tc.a(c0813b);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_about;
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
    public C0813b getViewModel() {
        return new C0813b(this.context);
    }
}
