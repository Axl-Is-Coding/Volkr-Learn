package com.disabngo.blockynexus.e.b.K;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0753ve;
import com.google.gson.j;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: HelpDetailFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends TemplateFragment<g, AbstractC0753ve> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0753ve abstractC0753ve, g gVar) {
        abstractC0753ve.a(gVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_help_detail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public g getViewModel() {
        if (getArguments() == null) {
            return new g(this.context, new ArrayList());
        }
        return new g(this.context, (List) new j().a(getArguments().getString(StringConstant.HELP_DETAIL_INFO_DES), new c(this).getType()));
    }
}
