package com.disabngo.blockynexus.e.b.oa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Of;
import com.disabngo.blockynexus.e.b.na.c;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeMemberManage.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends TemplateFragment<b, Of> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Of of, b bVar) {
        of.a(bVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_member_manage;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this.context);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_MORE_MEMBER_CLICK);
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onRightButtonClick(View view) {
        super.onRightButtonClick(view);
        Bundle bundle = new Bundle();
        bundle.putBoolean(StringConstant.TRIBE_IS_FINISH_INVITE, false);
        Activity activity = this.activity;
        TemplateUtils.startTemplate(activity, c.class, activity.getString(R.string.tribe_invite_friend), bundle);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_MORE_ADD_MEMBER_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public b getViewModel() {
        return new b(this.context);
    }
}
