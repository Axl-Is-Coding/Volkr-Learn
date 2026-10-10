package com.disabngo.blockynexus.view.fragment.tribehas;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Af;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: TribalLevelDescriptionFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class F extends TemplateFragment<G, Af> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Af af, G g) {
        af.a(g);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribal_level_description;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public G getViewModel() {
        return new G();
    }
}
