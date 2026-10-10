package com.disabngo.blockynexus.e.b.t;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Kd;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.t.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnsureEmailFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0924c extends TemplateFragment<C0927f, Kd> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Kd kd, C0927f c0927f) {
        kd.a(c0927f);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_ensure_email;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public C0927f getViewModel() {
        return new C0927f(this.context, getArguments().getString(StringConstant.UID));
    }
}
