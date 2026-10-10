package com.sandboxol.center.utils;

import android.content.Context;
import android.content.Intent;
import com.google.gson.reflect.TypeToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.LatestVersion;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.view.dialog.AdsGameRewardDialog;
import com.sandboxol.center.view.dialog.CampaignOneButtonDialog;
import com.sandboxol.center.view.dialog.CheckAppVersionDialog;
import com.sandboxol.center.view.dialog.CloseAppDialog;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.center.view.dialog.PayGdiamondDialog;
import com.sandboxol.center.view.dialog.teaminvite.TeamInviteDialog;
import com.sandboxol.greendao.c.va;
import com.sandboxol.greendao.entity.TeamMember;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DialogUtils extends DialogUtilsImpl {
    private static DialogUtils instant;
    private LoadingDialog loadingDialog;

    public static DialogUtils newsInstant() {
        if (instant == null) {
            instant = new DialogUtils();
        }
        return instant;
    }

    public static void showTeamInviteDialog(Context context, GameMassage gameMassage, String str) {
        new TeamInviteDialog(context, gameMassage, (List) new com.google.gson.j().a(str, new TypeToken<List<TeamMember>>() { // from class: com.sandboxol.center.utils.DialogUtils.2
        }.getType())).show();
    }

    @Override // com.sandboxol.center.utils.DialogUtilsImpl
    public void hideLoadingDialog() {
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog != null && loadingDialog.isShowing()) {
            this.loadingDialog.cancel();
        }
        this.loadingDialog = null;
    }

    public void showAdsGameRewardDialog(Context context, long j) {
        Intent intent = new Intent(context, (Class<?>) AdsGameRewardDialog.class);
        intent.putExtra(StringConstant.GAME_AD_REWARD, j);
        intent.setFlags(67108864);
        context.startActivity(intent);
    }

    public void showCampaignOneButtonDialog(Context context, int i) {
        new CampaignOneButtonDialog(context).setMsg(i).show();
    }

    public void showCheckAppVersionDialog(Context context, LatestVersion latestVersion, boolean z, boolean z2) {
        new CheckAppVersionDialog(context, latestVersion, z, z2).show();
    }

    public void showCloseAppDialog(Context context) {
        new CloseAppDialog(context).show();
    }

    @Override // com.sandboxol.center.utils.DialogUtilsImpl
    public void showLoadingDialog(Context context) {
        if (this.loadingDialog != null || context == null) {
            return;
        }
        try {
            this.loadingDialog = new LoadingDialog(context);
            this.loadingDialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void showPayGdiamondDialog(final Context context, final int i, final PayGdiamondDialog.OnTwoButtonDialogClickListener onTwoButtonDialogClickListener, final PayGdiamondDialog.OnTwoButtonDialogClickListener onTwoButtonDialogClickListener2) {
        va.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), new com.sandboxol.greendao.a.c<Boolean>() { // from class: com.sandboxol.center.utils.DialogUtils.1
            @Override // com.sandboxol.greendao.a.c
            public void onError(int i2, String str) {
            }

            @Override // com.sandboxol.greendao.a.c
            public void onSuccess(Boolean bool) {
                if (AccountCenter.newInstance().gDiamonds.get().longValue() < i || bool.booleanValue()) {
                    onTwoButtonDialogClickListener.onClick();
                } else {
                    new PayGdiamondDialog(context, i).setListener(onTwoButtonDialogClickListener).setLeftListener(onTwoButtonDialogClickListener2).show();
                }
            }
        });
    }
}
