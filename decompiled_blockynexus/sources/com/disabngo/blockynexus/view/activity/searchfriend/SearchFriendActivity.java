package com.disabngo.blockynexus.view.activity.searchfriend;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0737u;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class SearchFriendActivity extends BaseActivity<q, AbstractC0737u> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0737u abstractC0737u, q qVar) {
        abstractC0737u.a(qVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_search_friend;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public q getViewModel() {
        return new q(this, getIntent() != null ? getIntent().getBooleanExtra(StringConstant.IS_SHOW_FRIEND_DETAIL, true) : true);
    }
}
