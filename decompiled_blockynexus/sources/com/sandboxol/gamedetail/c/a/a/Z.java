package com.sandboxol.gamedetail.c.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.router.manager.RongIMManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.utils.ViewReturnTextUtils;
import com.sandboxol.center.view.dialog.PayGdiamondDialog;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.app.SingleTemplateActivity;
import com.sandboxol.common.base.model.IModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GamePayInfo;
import com.sandboxol.messager.MessagerClient;
import java.util.List;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class Z implements IModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17962a;

    public Z(Context context) {
        this.f17962a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(Context context, String str, ObservableField<Boolean> observableField, ObservableField<Drawable> observableField2, ObservableField<Boolean> observableField3, ObservableField<String> observableField4, Game game) {
        com.sandboxol.gamedetail.web.c.a(context, str, new V(this, game, observableField2, observableField4, observableField3, context, observableField));
    }

    public void b(Context context, String str) {
        GameApi.getAdsTurntableInfo(context, str, new W(this, context, str));
    }

    public void a(String str, long j, OnResponseListener<Game> onResponseListener) {
        GameApi.gameDetail(this.f17962a, str, j, onResponseListener);
    }

    public void a(long j, long j2, String str, String str2, String str3, OnResponseListener<List<AppEngineResourceUpdateResult>> onResponseListener) {
        GameApi.getGameResource(this.f17962a, j, j2, str, str2, str3, onResponseListener);
    }

    void a(String str, ObservableField<Game> observableField, ObservableField<Boolean> observableField2, ObservableField<String> observableField3) {
        if (observableField.get() == null || observableField.get().getAppreciate()) {
            return;
        }
        GameApi.appreciation(this.f17962a, str, new S(this, observableField, observableField2, observableField3));
    }

    public void a(String str, Game game, String str2) {
        GameApi.getChatRoomId(this.f17962a, str, new T(this, game, str2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2, Game game, String str3, String str4) {
        RongIMManager.startPartyDressChat(this.f17962a, str2, str4, true, true, RongIMManager.game2GameMassage(i, str, str2, game, str3, str4));
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Game game, String str2, String str3) {
        GameApi.getTeamMiniGameToken(this.f17962a, str2, (int) EngineEnv.getEngineVersion(game.getIsNewEngine(), game.getIsUgc()), new U(this, str, game, str2, str3));
    }

    public void a(final Context context, final String str, final ObservableField<Boolean> observableField, final ObservableField<Drawable> observableField2, final ObservableField<Boolean> observableField3, final ObservableField<String> observableField4, final Game game) {
        GamePayInfo gamePayInfo = game.getGamePayInfo();
        if (gamePayInfo.getCurrency() != 2 && gamePayInfo.getQty() > AccountCenter.newInstance().diamonds.get().longValue()) {
            DialogUtils.newsInstant().showPayGdiamondDialog(context, (int) (((long) gamePayInfo.getQty()) - AccountCenter.newInstance().diamonds.get().longValue()), new PayGdiamondDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.k
                @Override // com.sandboxol.center.view.dialog.PayGdiamondDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f18000a.b(context, str, observableField, observableField2, observableField3, observableField4, game);
                }
            }, new PayGdiamondDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.l
                @Override // com.sandboxol.center.view.dialog.PayGdiamondDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    observableField.set(true);
                }
            });
        } else {
            b(context, str, observableField, observableField2, observableField3, observableField4, game);
        }
    }

    void a(ObservableField<Drawable> observableField, ObservableField<String> observableField2, ObservableField<Boolean> observableField3, Game game) {
        observableField3.set(Boolean.valueOf(game.getIsPay() == 1));
        observableField.set(ViewReturnTextUtils.buyGame(game.getGamePayInfo()));
        observableField2.set(game.getIsPay() == 0 ? this.f17962a.getString(R.string.gamedetail_game_detail_quick_enter) : String.valueOf(game.getGamePayInfo().getQty()));
    }

    public void a(String str) {
        UserApi.loadEditorConfig(this.f17962a, new X(this, str));
    }

    public void a(int i, int i2, String str) {
        ImageButton imageButton;
        Context context = this.f17962a;
        if (!(context instanceof SingleTemplateActivity) || (imageButton = (ImageButton) ((Activity) context).findViewById(com.sandboxol.common.R.id.ibTemplateRight)) == null) {
            return;
        }
        if (1 == i && (i2 == -1 || i2 > 0)) {
            imageButton.setVisibility(0);
            if (str != null && str.equals("g1025")) {
                imageButton.setImageResource(R.mipmap.ic_ads_game_detail_g1025_entrance);
            } else {
                imageButton.setImageResource(R.mipmap.ic_ads_game_detail_entrance);
            }
            imageButton.startAnimation(AnimationUtils.loadAnimation(this.f17962a, R.anim.first_top_up_icon_anim));
            a(str, true);
            return;
        }
        imageButton.clearAnimation();
        imageButton.setAnimation(null);
        imageButton.setVisibility(8);
        a(8);
    }

    public void a(String str, boolean z) {
        GameApi.getAdsTurnHaveReward(this.f17962a, str, new Y(this, z));
    }

    public void a(int i) {
        TextView textView = (TextView) ((Activity) this.f17962a).findViewById(com.sandboxol.common.R.id.tvTip);
        if (textView != null) {
            if (i == 8) {
                textView.setBackground(null);
            } else {
                textView.setBackground(this.f17962a.getResources().getDrawable(R.drawable.ic_friend_add_guide_chat));
                textView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_friend_add_guide_smile, 0, 0, 0);
            }
            textView.setVisibility(i);
        }
    }

    @SuppressLint({"CheckResult"})
    public void a(final String str, final Game game) {
        new RxPermissions2((FragmentActivity) this.f17962a).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").subscribe(new io.reactivex.b.g() { // from class: com.sandboxol.gamedetail.c.a.a.m
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                this.f18011a.a(game, str, (Boolean) obj);
            }
        }, new io.reactivex.b.g() { // from class: com.sandboxol.gamedetail.c.a.a.h
            @Override // io.reactivex.b.g
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    public /* synthetic */ void a(Game game, String str, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            try {
                com.sandboxol.greendao.c.U.newInstance().a(game.getGameId(), new Q(this, game, str));
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        AppToastUtils.showLongNegativeTipToast(this.f17962a, R.string.gamedetail_please_set_write_read_jurisdiction);
    }

    public String a(Game game, String str) {
        return (game == null || game.getRealPlayGameList() == null || game.getRealPlayGameList().size() == 0 || game.getRealPlayGameList().get(0) == null || game.getRealPlayGameList().get(0).getGameId() == null) ? str : game.getRealPlayGameList().get(0).getGameId();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 96630153(0x5c27589, float:1.8286848E-35)
            r2 = 1
            if (r0 == r1) goto L1a
            r1 = 96630186(0x5c275aa, float:1.8286895E-35)
            if (r0 == r1) goto L10
            goto L24
        L10:
            java.lang.String r0 = "g1037"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L24
            r5 = 1
            goto L25
        L1a:
            java.lang.String r0 = "g1025"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L24
            r5 = 0
            goto L25
        L24:
            r5 = -1
        L25:
            if (r5 == 0) goto L30
            if (r5 == r2) goto L2a
            goto L35
        L2a:
            java.lang.String r5 = "game_page_hide"
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r4, r5)
            goto L35
        L30:
            java.lang.String r5 = "game_page_hero"
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r4, r5)
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.c.a.a.Z.a(android.content.Context, java.lang.String):void");
    }
}
