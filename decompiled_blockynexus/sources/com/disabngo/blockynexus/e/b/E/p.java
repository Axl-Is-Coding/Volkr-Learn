package com.disabngo.blockynexus.e.b.E;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Yd;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: GroupAdmiFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends TemplateFragment<r, Yd> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Yd yd, r rVar) {
        yd.a(rVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_admi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public r getViewModel() {
        Bundle arguments = getArguments();
        return new r(this.context, arguments != null ? (GroupInfo) arguments.getParcelable(SharedConstant.KEY_GROUP_INFO) : null);
    }
}
