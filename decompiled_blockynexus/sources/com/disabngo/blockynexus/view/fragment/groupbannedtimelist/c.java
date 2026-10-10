package com.disabngo.blockynexus.view.fragment.groupbannedtimelist;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0533be;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: GroupBannedTimeFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends TemplateFragment<h, AbstractC0533be> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11724c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0533be abstractC0533be, h hVar) {
        abstractC0533be.a(hVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_ban_time;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public h getViewModel() {
        if (getArguments() != null) {
            this.f11722a = getArguments().getLong("key.group.id");
            this.f11723b = getArguments().getLong(SharedConstant.KEY_GROUP_MEMBER_ID);
            this.f11724c = getArguments().getString(SharedConstant.KEY_GROUP_MEMBER_NAME);
        }
        if (this.f11722a == 0 || this.f11723b == 0 || this.f11724c == null) {
            GroupOnError.showErrorTip(this.context, 1);
            this.f11724c = "";
        }
        return new h(this.context, this.f11722a, this.f11723b, this.f11724c);
    }
}
