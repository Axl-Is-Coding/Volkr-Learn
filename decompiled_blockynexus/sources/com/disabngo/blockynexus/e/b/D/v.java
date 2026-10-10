package com.disabngo.blockynexus.e.b.D;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0601he;
import com.disabngo.blockynexus.entity.ConversationClickStateHolder;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: GroupInfoFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class v extends TemplateFragment<I, AbstractC0601he> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9195a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0601he abstractC0601he, I i) {
        abstractC0601he.a(i);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_info;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        ConversationClickStateHolder.getInstance().setGourpIconState(1);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public I getViewModel() {
        boolean z = false;
        if (getArguments() != null) {
            this.f9195a = Long.valueOf(getArguments().getString("key.group.id")).longValue();
            z = getArguments().getBoolean(SharedConstant.KEY_GROUP_FROM_INVITE_CARD, false);
        }
        return new I(this.context, this.f9195a, z);
    }
}
