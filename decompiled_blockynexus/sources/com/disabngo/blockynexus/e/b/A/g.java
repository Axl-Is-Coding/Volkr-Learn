package com.disabngo.blockynexus.e.b.A;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0557de;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: GroupBannedFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends TemplateFragment<m, AbstractC0557de> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GroupInfo f9094a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0557de abstractC0557de, m mVar) {
        abstractC0557de.a(mVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_banned;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public m getViewModel() {
        if (getArguments() != null) {
            this.f9094a = (GroupInfo) getArguments().getParcelable(SharedConstant.KEY_GROUP_INFO);
        } else {
            GroupOnError.showErrorTip(this.context, 1);
        }
        return new m(this.context, this.f9094a);
    }
}
