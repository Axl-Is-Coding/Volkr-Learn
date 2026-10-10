package com.disabngo.blockynexus.e.b.x;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ud;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class v extends BaseFragment<M, Ud> {
    private void g() {
        MessagerClient.getIns().registerMsg1(v.class, BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, new s(this));
        MessagerClient.getIns().registerMsg1(v.class, BroadcastType.BROADCAST_REFRESH_FRIEND_APPLY_LIST, new t(this));
        MessagerClient.getIns().registerMsg1(v.class, GameBroadcastType.BROADCAST_ENTER_GAME_CHECK, new u(this));
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_friend;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessagerClient.getIns().unRegisterMsg(v.class);
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Ud ud, M m) {
        ud.a(m);
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public M getViewModel() {
        return new M(this.context, (Ud) this.binding);
    }
}
