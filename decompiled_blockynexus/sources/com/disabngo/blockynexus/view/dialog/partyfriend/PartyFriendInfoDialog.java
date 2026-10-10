package com.disabngo.blockynexus.view.dialog.partyfriend;

import android.content.Intent;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0531bc;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class PartyFriendInfoDialog extends BaseActivity<j, AbstractC0531bc> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f11656a;

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.EXIT_PARTY_CLOSE_DIALOG, new Action0() { // from class: com.disabngo.blockynexus.view.dialog.partyfriend.h
            @Override // rx.functions.Action0
            public final void call() {
                this.f11664a.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0531bc abstractC0531bc, j jVar) {
        abstractC0531bc.a(jVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.dialog_party_friend_info;
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(34);
        initMessenger();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(R.anim.base_start_loading, R.anim.base_start_loading_back);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public j getViewModel() {
        Friend friend;
        this.f11656a = getIntent();
        Intent intent = this.f11656a;
        long longExtra = 0;
        if (intent != null) {
            longExtra = intent.getLongExtra("friend.id", 0L);
            friend = (Friend) this.f11656a.getParcelableExtra("friend.data");
        } else {
            friend = null;
        }
        return new j(this, longExtra, friend);
    }
}
