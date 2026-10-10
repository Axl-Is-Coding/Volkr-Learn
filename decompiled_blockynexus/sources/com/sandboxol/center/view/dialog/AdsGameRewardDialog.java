package com.sandboxol.center.view.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.databinding.BaseDialogAdsGameRewardBinding;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.rx.BaseRxAppCompatActivity;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class AdsGameRewardDialog extends BaseRxAppCompatActivity {
    private BaseDialogAdsGameRewardBinding binding;
    public ReplyCommand onConfirmClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f16374a.onConfirm();
        }
    });

    private void animRotate(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(5000L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfirm() {
        BillingManager.getInstance().updateUserMoney(this);
        if (isFinishing()) {
            return;
        }
        finish();
    }

    protected void initView() {
        this.binding = (BaseDialogAdsGameRewardBinding) androidx.databinding.e.a(LayoutInflater.from(this), R.layout.base_dialog_ads_game_reward, (ViewGroup) null, false);
        this.binding.setAdsGameRewardDialog(this);
        setContentView(this.binding.getRoot());
    }

    @Override // com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setIntData(R.mipmap.ic_gold, String.valueOf(getIntent().getLongExtra(StringConstant.GAME_AD_REWARD, 0L)));
        animRotate(this.binding.ivFlash);
    }

    public void setIntData(int i, String str) {
        try {
            View viewInflate = getLayoutInflater().inflate(R.layout.base_dialog_item_campaign_reward, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ivRewardGoods);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvRewardName);
            com.bumptech.glide.c.a((FragmentActivity) this).mo53load(Integer.valueOf(i)).into(imageView);
            textView.setText(str);
            this.binding.llReward.addView(viewInflate);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
