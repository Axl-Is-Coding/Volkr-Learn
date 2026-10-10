package com.disabngo.blockynexus.e.b.e;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0611id;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.e.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindEmailFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0834f extends TemplateFragment<C0839k, AbstractC0611id> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0611id abstractC0611id, C0839k c0839k) {
        abstractC0611id.a(c0839k);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_bind_email;
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
    public C0839k getViewModel() {
        return new C0839k(this.context, getArguments());
    }
}
