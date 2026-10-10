package com.disabngo.blockynexus.e.b.xa;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0544cd;
import com.sandboxol.common.base.app.BaseFragment;

/* JADX INFO: compiled from: VideoRecommendFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends BaseFragment<q, AbstractC0544cd> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0544cd abstractC0544cd, q qVar) {
        abstractC0544cd.a(qVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_app_video_recommend;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public q getViewModel() {
        return new q(this.context, (AbstractC0544cd) this.binding);
    }
}
