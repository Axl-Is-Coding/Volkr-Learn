package com.disabngo.blockynexus.view.fragment.main;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C0507d;
import com.disabngo.blockynexus.e.b.y.C0958i;
import com.disabngo.blockynexus.entity.StatusBean;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.greendao.entity.FriendPartyStatus;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GamingInfo;
import com.sandboxol.imchat.web.ChatGameApi;

/* JADX INFO: compiled from: OtherWayEnterGameLogic.java */
/* JADX INFO: loaded from: classes2.dex */
public class Q {
    public static void a(Context context, long j, boolean z, OnDataListener<StatusBean> onDataListener) {
        FriendApi.friendGamingInfo(context, j, new L(j, context, z, onDataListener));
    }

    public static void a(Context context, long j, StatusBean statusBean, boolean z) {
        com.disabngo.blockynexus.d.n.c(context);
        if (statusBean.getGamingInfo() != null && statusBean.getGameId() != null && statusBean.getGameName() != null) {
            a(context, j, a(statusBean.getGameName(), statusBean.getGameId()), statusBean.getGamingInfo());
            com.disabngo.blockynexus.d.n.a(context, z);
        } else if (statusBean.getPartyInfo() == null || statusBean.getGameName() == null) {
            AppToastUtils.showLongNegativeTipToast(context, R.string.follow_friend_not_support);
        } else {
            a(context, statusBean.getPartyInfo(), statusBean.getGameName());
            com.disabngo.blockynexus.d.n.b(context, z);
        }
    }

    @SuppressLint({"CheckResult"})
    private static void a(final Context context, final long j, final Game game, final GamingInfo gamingInfo) {
        new RxPermissions2((FragmentActivity) context).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.view.fragment.main.q
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                Q.a(context, game, j, gamingInfo, (Boolean) obj);
            }
        }, new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.view.fragment.main.e
            @Override // io.reactivex.b.g
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    static /* synthetic */ void a(Context context, Game game, long j, GamingInfo gamingInfo, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            new C0958i().a(context, game.getGameId(), C0507d.a(game), (ObservableField<Boolean>) null, new M(game, j, gamingInfo));
        }
    }

    @SuppressLint({"CheckResult"})
    private static void a(Context context, FriendPartyStatus friendPartyStatus, String str) {
        if (EngineEnv.isEngineVersion(friendPartyStatus.getEngineVersion())) {
            DialogUtils.newsInstant().showLoadingDialog(context);
            ChatGameApi.getPartyAuth(context, AccountCenter.newInstance().userId.get().longValue(), friendPartyStatus.getPsid(), ((long) friendPartyStatus.getEngineVersion()) == EngineEnv.v2().getEngineVersion(), new P(context, friendPartyStatus, str));
        } else {
            AppToastUtils.showShortNegativeTipToast(context, R.string.party_version_different);
            com.disabngo.blockynexus.d.n.a(context, context.getString(R.string.party_version_different));
        }
    }

    private static Game a(String str, String str2) {
        Game game = new Game();
        game.setGameName(str);
        game.setGameId(str2);
        game.setIsNewEngine(str2.contains("g2") ? 1 : 0);
        return game;
    }
}
