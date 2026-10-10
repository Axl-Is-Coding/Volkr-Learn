package com.disabngo.blockynexus.e.b.ya;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0567ed;
import com.sandboxol.common.base.app.BaseFragment;

/* JADX INFO: compiled from: VideoTotalFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends BaseFragment<g, AbstractC0567ed> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0567ed abstractC0567ed, g gVar) {
        abstractC0567ed.a(gVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_app_video_total;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public g getViewModel() {
        return new g(this.context, (AbstractC0567ed) this.binding);
    }
}
