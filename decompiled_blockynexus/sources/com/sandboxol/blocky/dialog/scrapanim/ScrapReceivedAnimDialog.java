package com.sandboxol.blocky.dialog.scrapanim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.databinding.ObservableField;
import androidx.databinding.e;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.HideNavigationBarDialog;
import com.sandboxol.game.R;
import com.sandboxol.game.a.o;
import com.sandboxol.greendao.c.oa;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes.dex */
public class ScrapReceivedAnimDialog extends HideNavigationBarDialog {
    private o binding;
    private String gameId;
    private List<String> ids;
    private List<ScrapTreasureRewardInfo> infoList;
    public ObservableField<Boolean> isFromMain;
    public ScrapAnimListLayout listLayout;
    public ScrapAnimListModel listModel;
    public ReplyCommand onClose;
    private List<ScrapTreasureRewardInfo> rewardInfos;
    private RotateAnimation rotateAnimation;

    public ScrapReceivedAnimDialog(Context context, String str, List<String> list, List<ScrapTreasureRewardInfo> list2, boolean z) {
        super(context);
        this.listLayout = new ScrapAnimListLayout();
        this.isFromMain = new ObservableField<>(false);
        this.onClose = new ReplyCommand(new Action0() { // from class: com.sandboxol.blocky.dialog.scrapanim.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f16301a.dismiss();
            }
        });
        initView();
        this.ids = list;
        this.infoList = list2;
        this.gameId = str;
        this.isFromMain.set(Boolean.valueOf(z));
        initData();
    }

    private void animRotate(View view) {
        this.rotateAnimation = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
        this.rotateAnimation.setDuration(5000L);
        this.rotateAnimation.setRepeatCount(-1);
        this.rotateAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(this.rotateAnimation);
    }

    private void initData() {
        this.rewardInfos = new ArrayList();
        for (String str : this.ids) {
            Iterator<ScrapTreasureRewardInfo> it = this.infoList.iterator();
            while (true) {
                if (it.hasNext()) {
                    ScrapTreasureRewardInfo next = it.next();
                    if (next.getScrapId().equals(str)) {
                        next.setGameId(this.gameId);
                        next.setUserId(AccountCenter.newInstance().userId.get().longValue());
                        this.rewardInfos.add(next);
                        break;
                    }
                }
            }
        }
        if (this.rewardInfos.size() > 0) {
            oa.newInstance().a(this.rewardInfos);
        }
        this.listModel = new ScrapAnimListModel(this.context, R.string.no_data, this.rewardInfos, this.isFromMain.get().booleanValue());
    }

    private void initView() {
        this.binding = (o) e.a(LayoutInflater.from(this.context), R.layout.dialog_scrap_anim, (ViewGroup) null, false);
        this.binding.a(this);
        setContentView(this.binding.getRoot());
        animRotate(this.binding.f17703b);
        setInnerViews(this.binding.f17702a);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.rotateAnimation.cancel();
        super.dismiss();
    }
}
