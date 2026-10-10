package com.disabngo.blockynexus.view.activity.join;

import android.content.Intent;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0585g;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.messager.MessagerClient;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class EnterGameActivity extends BaseActivity<s, AbstractC0585g> {
    private void h() {
        Observable.create(new Observable.OnSubscribe() { // from class: com.disabngo.blockynexus.view.activity.join.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10701a.a((Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new l(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0585g abstractC0585g, s sVar) {
        abstractC0585g.a(sVar);
    }

    public /* synthetic */ void g() {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_enter_game;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10001 && intent != null && this.viewModel != 0) {
            if (intent.getBooleanExtra(GameConstant.IS_NEXT_GAME, false)) {
                ((s) this.viewModel).f();
            } else if (intent.getBooleanExtra(GameConstant.IS_GO_PREPAID, false)) {
                TemplateUtils.startTemplate(this, com.sandboxol.googlepay.view.fragment.recharge.k.class, getString(R.string.me_recharge), R.mipmap.ic_recharge_history);
            } else {
                Messenger.getDefault().send(Boolean.valueOf(intent.getBooleanExtra(GameConstant.IS_EXIT_NORMAL, true)), MessageToken.TOKEN_SHOW_SIGN_IN_FROM_EXIT_ENGINE_V2);
            }
            h();
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessagerClient.getIns().registerMsg0(EnterGameActivity.class, GameBroadcastType.BROADCAST_PARTY_EXIT_GAME, new com.sandboxol.messager.a.a() { // from class: com.disabngo.blockynexus.view.activity.join.b
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f10702a.g();
            }
        });
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MessagerClient.getIns().unRegisterMsg(EnterGameActivity.class);
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

    public /* synthetic */ void a(Subscriber subscriber) {
        try {
            b.h.b.a.g.a(this, 5);
            subscriber.onCompleted();
        } catch (Exception e2) {
            e2.printStackTrace();
            subscriber.onError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public s getViewModel() {
        return new s(this, (Game) getIntent().getSerializableExtra(StringConstant.ENTER_GAME_INFO), getIntent().getLongExtra(StringConstant.ENTER_GAME_TARGET_ID, 0L), getIntent().getBooleanExtra(StringConstant.ENTER_GAME_FROM_LATELY_GAME, false), getIntent().getStringExtra(StringConstant.ENTER_GAME_REGION_ID), (EnterRealmsResult) getIntent().getSerializableExtra(StringConstant.ENTER_GAME_REAlMS_SESULT));
    }
}
