package com.sandboxol.blocky.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import androidx.databinding.e;
import com.sandboxol.blocky.router.ControllerType;
import com.sandboxol.blocky.router.RealmsController;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.utils.GameSharedUtils;
import com.sandboxol.game.R;
import com.sandboxol.messager.MessagerClient;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes.dex */
public class StartMcActivity extends Activity {
    Intent result;
    private long startTime = 0;

    /* JADX INFO: renamed from: com.sandboxol.blocky.activity.StartMcActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$blocky$router$ControllerType = new int[ControllerType.values().length];

        static {
            try {
                $SwitchMap$com$sandboxol$blocky$router$ControllerType[ControllerType.BLOCK_MAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public /* synthetic */ void a(int i) {
        if ((i & 4) == 0) {
            toggleHideBar();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            ControllerType controllerType = (ControllerType) getIntent().getSerializableExtra("controllerType");
            if (controllerType != null) {
                RealmsController me2 = AnonymousClass1.$SwitchMap$com$sandboxol$blocky$router$ControllerType[controllerType.ordinal()] != 1 ? null : RealmsController.getMe();
                if (me2 != null) {
                    me2.unbindMcService(this);
                    me2.stop();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        setResult(10001, this.result);
        GameSharedUtils.newInstance().putStartGameInfo(null);
        super.finish();
        MessagerClient.getIns().unRegisterMsg(StartMcActivity.class);
        onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10001) {
            this.result = intent;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (System.currentTimeMillis() - this.startTime > 10000) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            Log.e("StartMcActivity", "<-----  onCreate  -----> " + System.currentTimeMillis());
            getWindow().setBackgroundDrawable(null);
            toggleHideBar();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.sandboxol.blocky.activity.a
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public final void onSystemUiVisibilityChange(int i) {
                    this.f16294a.a(i);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(6);
        }
        super.onCreate(bundle);
        e.a(this, R.layout.activity_start_mc);
        this.startTime = System.currentTimeMillis();
        if (((ControllerType) getIntent().getSerializableExtra("controllerType")) == null) {
            finish();
        } else {
            AccountCenter.getAccountInfo(new Action0() { // from class: com.sandboxol.blocky.activity.b
                @Override // rx.functions.Action0
                public final void call() {
                    this.f16295a.a();
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        Log.e("router-jni", "onNewIntent");
        setIntent(new Intent());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.e("StartMcActivity", "onResume:" + System.currentTimeMillis());
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            toggleHideBar();
        }
    }

    public void toggleHideBar() {
        if (Build.VERSION.SDK_INT > 18) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public /* synthetic */ void a() {
        RealmsController.newInstance(this);
    }
}
