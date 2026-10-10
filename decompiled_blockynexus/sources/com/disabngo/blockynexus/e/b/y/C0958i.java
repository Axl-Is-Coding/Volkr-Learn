package com.disabngo.blockynexus.e.b.y;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.d.D;
import com.facebook.internal.ServerProtocol;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.utils.GameIdRemarkUtils;
import com.sandboxol.center.utils.GameResVersionManager;
import com.sandboxol.center.view.dialog.NotWifiDialog;
import com.sandboxol.center.view.dialog.TwoTextButtonDialog;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.NetworkUtil;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.c.U;
import com.sandboxol.greendao.entity.Game;
import io.rong.imlib.model.Conversation;
import java.util.List;
import java.util.Locale;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.y.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CheckGameInfoUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0958i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Game f10383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0953d f10384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<Boolean> f10385c = new ObservableField<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, final String str, final List<AppEngineResourceUpdateResult> list, final GameMassage gameMassage, final String str2) {
        new TwoTextButtonDialog(context).setDetailText(R.string.res_no_load).setRightButtonText(R.string.res_load).setListener(new TwoTextButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.y.c
            @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10361a.a(context, str, list, gameMassage, str2);
            }
        }).show();
        ReportDataAdapter.onEvent(context, EventConstant.ACCEPT_PARTY_DOWNWIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(final Context context, final String str, final List<AppEngineResourceUpdateResult> list, final GameMassage gameMassage, final String str2) {
        if (!NetworkUtil.isWifi(context) && !SharedUtils.getBoolean(context, SharedConstant.IS_SHOW_NO_WIFI)) {
            new NotWifiDialog(context).setListener(new NotWifiDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.y.b
                @Override // com.sandboxol.center.view.dialog.NotWifiDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f10355a.a(context, gameMassage, str, list, str2);
                }
            }).show();
            return;
        }
        a(context, gameMassage, str);
        D.a(context, new com.google.gson.j().a(list), context.hashCode(), str2);
        ReportDataAdapter.onEvent(context, EventConstant.ACCEPTWIN_CLICK_LOAD);
    }

    public void a(Context context, String str, GameMassage gameMassage, ObservableField<Boolean> observableField, C0953d c0953d) {
        this.f10384b = c0953d;
        this.f10385c = observableField;
        if (A.a(str.contains("g2"))) {
            AppToastUtils.showLongNegativeTipToast(context, R.string.base_below_kit_kat);
        } else {
            U.newInstance().a(GameIdRemarkUtils.singleGameToHallGame(str), new C0954e(this, context, str, gameMassage));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, GameMassage gameMassage) {
        String str;
        String str2;
        if (gameMassage.getMemberCount() > 4 || Build.VERSION.SDK_INT < 21) {
            str = "conversation";
            str2 = "false";
        } else {
            str = "party";
            str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        }
        if (AppInfoCenter.newInstance().isNowParty()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + context.getApplicationInfo().packageName).buildUpon().appendPath(str).appendPath(Conversation.ConversationType.CHATROOM.getName().toLowerCase(Locale.US)).appendQueryParameter("isTeam", String.valueOf(true)).appendQueryParameter("isPartyPage", str2).appendQueryParameter("targetId", String.valueOf(gameMassage.getChatRoomId())).appendQueryParameter("title", gameMassage.getRoomName()).appendQueryParameter("gameMessage", new com.google.gson.j().a(gameMassage)).build());
        intent.putExtra("createIfNotExist", false);
        context.startActivity(intent);
        DialogUtils.newsInstant().hideLoadingDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, GameMassage gameMassage, ObservableField<Boolean> observableField, Game game) {
        if (game == null) {
            this.f10383a = new Game();
            this.f10383a.setGameId(str);
            this.f10383a.setIsNewEngine(gameMassage.getIsNewEngine());
        } else {
            this.f10383a = game;
        }
        long engineVersion = EngineEnv.getEngineVersion(gameMassage.getIsNewEngine(), gameMassage.getIsUgc());
        String engineType = EngineEnv.getEngineType(gameMassage.getIsNewEngine(), gameMassage.getIsUgc());
        String strSingleGameToHallGame = GameIdRemarkUtils.singleGameToHallGame(str);
        GameApi.getGameResource(context, engineVersion, GameResVersionManager.getOldGameResVersion(this.f10383a, strSingleGameToHallGame), strSingleGameToHallGame, engineType, this.f10383a.getGameUgcType(), new C0956g(this, context, strSingleGameToHallGame, engineVersion, str, gameMassage, observableField));
    }

    public /* synthetic */ void a(Context context, GameMassage gameMassage, String str, List list, String str2) {
        a(context, gameMassage, str);
        D.a(context, new com.google.gson.j().a(list), context.hashCode(), str2);
        ReportDataAdapter.onEvent(context, EventConstant.ACCEPTWIN_CLICK_LOAD);
    }

    private void a(final Context context, final GameMassage gameMassage, final String str) {
        Messenger.getDefault().register(context, MessageToken.TOKEN_DOWNLOAD_SUCCESS_ENTER_PARTY, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.y.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10351a.a(context, str, gameMassage, (Integer) obj);
            }
        });
    }

    public /* synthetic */ void a(Context context, String str, GameMassage gameMassage, Integer num) {
        if (num.intValue() == context.hashCode()) {
            U.newInstance().a(str, new C0957h(this, str, context, gameMassage));
        }
        Messenger.getDefault().unregister(context);
    }
}
