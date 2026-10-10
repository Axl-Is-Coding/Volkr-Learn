package com.sandboxol.common.base.app;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.base.rx.BaseRxAppCompatActivity;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.umeng.analytics.pro.m;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseActivity<VM extends ViewModel, D extends ViewDataBinding> extends BaseRxAppCompatActivity {
    protected D binding;
    protected boolean isActive;
    protected VM viewModel;

    private void bindView() {
        this.binding = (D) e.a(this, getLayoutId());
        this.viewModel = (VM) getViewModel();
        bindViewModel(this.binding, this.viewModel);
    }

    private void hideBottomUIMenu() {
        if (Build.VERSION.SDK_INT < 19) {
            getWindow().getDecorView().setSystemUiVisibility(8);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(m.a.f20904f);
        }
    }

    protected void bindData() {
    }

    protected abstract void bindViewModel(D d2, VM vm);

    protected abstract int getLayoutId();

    protected abstract VM getViewModel();

    protected void initData() {
    }

    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService("activity");
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bindView();
        initData();
    }

    @Override // com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VM vm = this.viewModel;
        if (vm != null) {
            vm.onDestroy();
            this.viewModel = null;
        }
    }

    @Override // com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        VM vm = this.viewModel;
        if (vm != null) {
            vm.onPause();
        }
        ReportDataAdapter.onPause(this);
    }

    @Override // com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        bindData();
        VM vm = this.viewModel;
        if (vm != null) {
            vm.onResume();
        }
        ReportDataAdapter.onResume(this);
    }

    @Override // com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (isAppOnForeground()) {
            return;
        }
        this.isActive = false;
    }
}
