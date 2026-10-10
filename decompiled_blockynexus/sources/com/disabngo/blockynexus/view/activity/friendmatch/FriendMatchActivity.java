package com.disabngo.blockynexus.view.activity.friendmatch;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0607i;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.app.BaseActivity;

/* JADX INFO: loaded from: classes2.dex */
public class FriendMatchActivity extends BaseActivity<FriendMatchViewModel, AbstractC0607i> {
    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_friend_match;
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        SandboxReportManager.onEvent(ReportEvent.NEW_ENTER_GPS_SETTING_SUCCESS, ReportEventType.NEW_USER_BEHAVIOR, "app");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public void bindViewModel(AbstractC0607i abstractC0607i, FriendMatchViewModel friendMatchViewModel) {
        abstractC0607i.a(friendMatchViewModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public FriendMatchViewModel getViewModel() {
        return new FriendMatchViewModel(this, (AbstractC0607i) this.binding);
    }
}
