package com.disabngo.blockynexus.e.b.ha;

import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0700qf;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: SecretQuestionVerifyFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends TemplateFragment<i, AbstractC0700qf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0700qf abstractC0700qf, i iVar) {
        iVar.a(abstractC0700qf);
        abstractC0700qf.a(iVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_secret_question_verify;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        ((i) this.viewModel).onBack();
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onLeftButtonClick(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public i getViewModel() {
        return new i(this.context, getArguments());
    }
}
