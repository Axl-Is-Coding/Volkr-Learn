package com.disabngo.blockynexus.e.b.Q;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.databinding.Je;
import com.disabngo.blockynexus.view.activity.main.MainActivity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: NewFriendFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends TemplateFragment<j, Je> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Je je, j jVar) {
        je.a(jVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_new_friend;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        super.onBackPressed();
        if (A.a(this.context, "MainActivity")) {
            return;
        }
        Context context = this.context;
        context.startActivity(new Intent(context, (Class<?>) MainActivity.class).putExtra(StringConstant.RONGCLOUD_PUSH_SELECT_TYPE, StringConstant.RONGCLOUD_PUSH_SELECT_ADD_FRIEND).addFlags(268435456));
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onLeftButtonClick(View view) {
        super.onLeftButtonClick(view);
        onBackPressed();
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
        ReportDataAdapter.onEvent(this.context, EventConstant.CHAT_NEW_FRIEND);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public j getViewModel() {
        return new j(this.context);
    }
}
