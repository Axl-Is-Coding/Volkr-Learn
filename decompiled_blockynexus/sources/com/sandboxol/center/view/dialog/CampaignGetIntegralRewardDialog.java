package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.R;
import com.sandboxol.center.databinding.BaseDialogCampaignGetIntegralRewardBinding;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.listener.OnViewClickListener;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class CampaignGetIntegralRewardDialog extends FullScreenDialog {
    private BaseDialogCampaignGetIntegralRewardBinding binding;
    private OnViewClickListener listener;
    public ReplyCommand onConfirmClickCommand;

    public CampaignGetIntegralRewardDialog(Context context) {
        super(context);
        this.onConfirmClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f16375a.onConfirm();
            }
        });
        initView();
        animRotate(this.binding.ivFlash);
    }

    private void animRotate(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(5000L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfirm() {
        OnViewClickListener onViewClickListener = this.listener;
        if (onViewClickListener != null) {
            onViewClickListener.onClick();
        }
        if (isShowing()) {
            cancel();
        }
    }

    protected void initView() {
        this.binding = (BaseDialogCampaignGetIntegralRewardBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.base_dialog_campaign_get_integral_reward, (ViewGroup) null, false);
        this.binding.setCampaignGetIntegralRewardDialog(this);
        setContentView(this.binding.getRoot());
    }

    public CampaignGetIntegralRewardDialog setIntData(int i, String str) {
        try {
            View viewInflate = getLayoutInflater().inflate(R.layout.base_dialog_item_campaign_reward, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ivRewardGoods);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvRewardName);
            com.bumptech.glide.c.c(this.context).mo53load(Integer.valueOf(i)).into(imageView);
            textView.setText(str);
            this.binding.llReward.addView(viewInflate);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public CampaignGetIntegralRewardDialog setIntDataList(int i, List<Integer> list, List<String> list2) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                View viewInflate = getLayoutInflater().inflate(R.layout.base_dialog_item_campaign_reward, (ViewGroup) null);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ivRewardGoods);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tvRewardName);
                com.bumptech.glide.c.c(this.context).mo53load(list.get(i2)).into(imageView);
                textView.setText(list2 == null ? "" : list2.get(i2));
                this.binding.llReward.addView(viewInflate);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public CampaignGetIntegralRewardDialog setOnViewClick(OnViewClickListener onViewClickListener) {
        this.listener = onViewClickListener;
        return this;
    }

    public CampaignGetIntegralRewardDialog setStringData(String str, String str2) {
        try {
            View viewInflate = getLayoutInflater().inflate(R.layout.base_dialog_item_campaign_reward, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ivRewardGoods);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvRewardName);
            com.bumptech.glide.c.c(this.context).mo55load(str).into(imageView);
            textView.setText(str2);
            this.binding.llReward.addView(viewInflate);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public CampaignGetIntegralRewardDialog setStringDataList(int i, List<String> list, List<String> list2) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                View viewInflate = getLayoutInflater().inflate(R.layout.base_dialog_item_campaign_reward, (ViewGroup) null);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ivRewardGoods);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tvRewardName);
                com.bumptech.glide.c.c(this.context).mo55load(list.get(i2)).into(imageView);
                textView.setText(list2 == null ? "" : list2.get(i2));
                this.binding.llReward.addView(viewInflate);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public CampaignGetIntegralRewardDialog setIntData(String str, String str2) {
        try {
            View viewInflate = getLayoutInflater().inflate(R.layout.base_dialog_item_campaign_reward, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ivRewardGoods);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvRewardName);
            com.bumptech.glide.c.c(this.context).mo55load(str).into(imageView);
            textView.setText(str2);
            this.binding.llReward.addView(viewInflate);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }
}
