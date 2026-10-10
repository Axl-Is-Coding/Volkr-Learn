package com.disabngo.blockynexus.view.activity.start;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0759w;
import com.disabngo.blockynexus.view.activity.base.HideNavigationActivity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.FirebaseUtils;
import io.grpc.internal.GrpcUtil;

/* JADX INFO: loaded from: classes2.dex */
public class StartActivity extends HideNavigationActivity<q, AbstractC0759w> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f11101a = new long[2];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0759w abstractC0759w, q qVar) {
        abstractC0759w.a(qVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2002 && i2 == 0) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REQUEST_PERMISSION);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        long[] jArr = this.f11101a;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f11101a;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (SystemClock.uptimeMillis() - this.f11101a[0] < 1000) {
            Process.killProcess(Process.myPid());
        } else {
            AppToastUtils.showShortPositiveTipToast(this, R.string.exit);
        }
    }

    @Override // com.disabngo.blockynexus.view.activity.base.HideNavigationActivity, com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ((getIntent().getFlags() & GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE) != 0) {
            finish();
        }
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Messenger.getDefault().unregister(this);
        super.onDestroy();
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
        ReportDataAdapter.onEvent(this, "home_startapp");
        FirebaseUtils.onEvent(this, EventConstant.START_APP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public q getViewModel() {
        return new q(this);
    }
}
