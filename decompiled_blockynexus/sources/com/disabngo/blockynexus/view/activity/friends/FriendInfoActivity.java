package com.disabngo.blockynexus.view.activity.friends;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0628k;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: loaded from: classes2.dex */
public class FriendInfoActivity extends BaseActivity<M, AbstractC0628k> {
    private static final String TAG = "com.disabngo.blockynexus.view.activity.friends.FriendInfoActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f10639a;
    private M viewModel;

    private void g() {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(StringConstant.KEY_MAIN_LOCK, true);
        MessagerClient.getIns().sendMsg1(MessageToken.TOKEN_MAIN_CLICK_CLOCK, fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0628k abstractC0628k, M m) {
        abstractC0628k.a(m);
        MessagerClient.getIns().registerMsg1(FriendInfoActivity.class, BroadcastType.BROADCAST_FRIEND_MATCH_PERFECT_USER_INFO, new J(this, m));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        MessagerClient.getIns().unRegisterMsg(FriendInfoActivity.class);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_friends_info;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.viewModel.onBack();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(16777216, 16777216);
        }
        FriendActivityIntentInfo friendActivityIntentInfo = new FriendActivityIntentInfo();
        Friend friend = null;
        this.f10639a = intent;
        int intExtra = 0;
        if (intent != null) {
            try {
                FriendActivityIntentInfo friendActivityIntentInfo2 = (FriendActivityIntentInfo) intent.getParcelableExtra("friend.info");
                try {
                    Friend friend2 = (Friend) intent.getParcelableExtra("friend.data");
                    try {
                        intExtra = intent.getIntExtra(StringConstant.FROM_PAGE, 0);
                        friend = friend2;
                        friendActivityIntentInfo = friendActivityIntentInfo2;
                    } catch (RuntimeException e2) {
                        e = e2;
                        friend = friend2;
                        friendActivityIntentInfo = friendActivityIntentInfo2;
                        Log.e(TAG, "getViewModel RuntimeException onNewIntent");
                        ReportDataAdapter.onError(BaseApplication.getContext(), e);
                    }
                } catch (RuntimeException e3) {
                    e = e3;
                }
            } catch (RuntimeException e4) {
                e = e4;
            }
        }
        this.viewModel.h.push(friendActivityIntentInfo);
        this.viewModel.a(this, intExtra, friendActivityIntentInfo, friend);
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
        ReportDataAdapter.onEvent(this, EventConstant.CHAT_USERINFO_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.disabngo.blockynexus.view.activity.friends.M getViewModel() {
        /*
            r10 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto Lf
            android.view.Window r0 = r10.getWindow()
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0.setFlags(r1, r1)
        Lf:
            android.content.Intent r0 = r10.getIntent()
            r10.f10639a = r0
            android.content.Intent r0 = r10.f10639a
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L57
            java.lang.String r3 = "friend.info"
            android.os.Parcelable r0 = r0.getParcelableExtra(r3)     // Catch: java.lang.RuntimeException -> L44
            com.disabngo.blockynexus.entity.FriendActivityIntentInfo r0 = (com.disabngo.blockynexus.entity.FriendActivityIntentInfo) r0     // Catch: java.lang.RuntimeException -> L44
            android.content.Intent r3 = r10.f10639a     // Catch: java.lang.RuntimeException -> L3f
            java.lang.String r4 = "friend.data"
            android.os.Parcelable r3 = r3.getParcelableExtra(r4)     // Catch: java.lang.RuntimeException -> L3f
            com.sandboxol.greendao.entity.Friend r3 = (com.sandboxol.greendao.entity.Friend) r3     // Catch: java.lang.RuntimeException -> L3f
            android.content.Intent r2 = r10.f10639a     // Catch: java.lang.RuntimeException -> L39
            java.lang.String r4 = "from.page"
            int r1 = r2.getIntExtra(r4, r1)     // Catch: java.lang.RuntimeException -> L39
            r2 = r0
            r8 = r1
            r7 = r3
            goto L59
        L39:
            r2 = move-exception
            r9 = r2
            r2 = r0
            r0 = r3
            r3 = r9
            goto L47
        L3f:
            r3 = move-exception
            r9 = r2
            r2 = r0
            r0 = r9
            goto L47
        L44:
            r0 = move-exception
            r3 = r0
            r0 = r2
        L47:
            java.lang.String r4 = com.disabngo.blockynexus.view.activity.friends.FriendInfoActivity.TAG
            java.lang.String r5 = "getViewModel RuntimeException"
            android.util.Log.e(r4, r5)
            android.content.Context r4 = com.sandboxol.common.base.app.BaseApplication.getContext()
            com.sandboxol.common.interfaces.ReportDataAdapter.onError(r4, r3)
            r7 = r0
            goto L58
        L57:
            r7 = r2
        L58:
            r8 = 0
        L59:
            if (r2 != 0) goto L60
            com.disabngo.blockynexus.entity.FriendActivityIntentInfo r2 = new com.disabngo.blockynexus.entity.FriendActivityIntentInfo
            r2.<init>()
        L60:
            r6 = r2
            com.disabngo.blockynexus.view.activity.friends.M r0 = new com.disabngo.blockynexus.view.activity.friends.M
            D extends androidx.databinding.ViewDataBinding r1 = r10.binding
            r5 = r1
            com.disabngo.blockynexus.databinding.k r5 = (com.disabngo.blockynexus.databinding.AbstractC0628k) r5
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r10.viewModel = r0
            com.disabngo.blockynexus.view.activity.friends.M r0 = r10.viewModel
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.activity.friends.FriendInfoActivity.getViewModel():com.disabngo.blockynexus.view.activity.friends.M");
    }
}
