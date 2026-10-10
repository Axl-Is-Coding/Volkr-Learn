package com.disabngo.blockynexus.view.activity.tribeshop;

import android.os.Build;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: loaded from: classes2.dex */
public class TribeShopActivity extends BaseActivity<E, com.disabngo.blockynexus.databinding.E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(com.disabngo.blockynexus.databinding.E e2, E e3) {
        e2.a(e3);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_tribe_shop;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MessagerClient.getIns().unRegisterMsg(TribeShopActivity.class);
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
        ReportDataAdapter.onEvent(this, EventConstant.CLAN_ENTER_STOP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public E getViewModel() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(16777216, 16777216);
        }
        MessagerClient.getIns().registerMsg0(TribeShopActivity.class, BroadcastType.BROADCAST_REFRESH_TRIBE_SHOP_LIST, new y(this));
        return new E(this, (com.disabngo.blockynexus.databinding.E) this.binding);
    }
}
