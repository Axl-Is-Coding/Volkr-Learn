package com.sandboxol.center.view.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.request.f;
import com.sandboxol.center.R;
import com.sandboxol.center.utils.ScrapOutlineViewReturnHelper;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.listener.ClickProxy;
import com.sandboxol.common.listener.OnViewClickListener;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapLevelImageView extends ConstraintLayout {
    private View bgMain;
    private View bgOutLine;
    private ImageView ivLevel;
    private ImageView ivPic;
    private ImageView ivScrapDone;
    private ImageView ivScrapLevelVip;
    private ImageView ivScrapLock;
    private OnViewClickListener listener;
    private ObjectAnimator objectAnimator;
    private TextView tvScrapGameText;
    private TextView tvScrapText;
    private View vScrapShadow;

    public ScrapLevelImageView(Context context) {
        this(context, null);
    }

    private void initAnim() {
        if (this.objectAnimator == null) {
            this.objectAnimator = ObjectAnimator.ofFloat(this.ivPic, "rotation", WheelView.DividerConfig.FILL, -15.0f, WheelView.DividerConfig.FILL, 5.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f);
            this.objectAnimator.setDuration(2000L);
            this.objectAnimator.setRepeatCount(-1);
            this.objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.sandboxol.center.view.widget.ScrapLevelImageView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    ObjectAnimator.ofFloat(ScrapLevelImageView.this.ivPic, "rotation", WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL).setDuration(10L).start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        }
    }

    private static boolean isValidContextForGlide(View view) {
        if (view.getContext() == null) {
            return false;
        }
        if (!(view.getContext() instanceof Activity)) {
            return true;
        }
        Activity activityByView = CommonHelper.getActivityByView(view);
        return (Build.VERSION.SDK_INT < 17 || !activityByView.isDestroyed()) && !activityByView.isFinishing();
    }

    private void setGif(ImageView imageView, int i) {
        f fVar = new f();
        fVar.diskCacheStrategy(p.f4584d);
        try {
            c.c(BaseApplication.getContext()).asGif().apply((com.bumptech.glide.request.a<?>) fVar).mo44load(Integer.valueOf(i)).into(imageView);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(View view) {
        this.listener.onClick();
        ObjectAnimator objectAnimator = this.objectAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ObjectAnimator objectAnimator = this.objectAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.objectAnimator = null;
        }
        super.onDetachedFromWindow();
    }

    public void setAnim(boolean z) {
        if (z) {
            initAnim();
            this.objectAnimator.start();
        } else {
            ObjectAnimator objectAnimator = this.objectAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            this.ivPic.clearAnimation();
        }
    }

    public void setClickListener(OnViewClickListener onViewClickListener) {
        this.listener = onViewClickListener;
        if (this.listener != null) {
            setOnClickListener(new ClickProxy(new View.OnClickListener() { // from class: com.sandboxol.center.view.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f16400a.a(view);
                }
            }, 1500L));
        }
    }

    public void setIvLevel(int i) {
        ImageView imageView = this.ivLevel;
        if (imageView != null) {
            imageView.setImageDrawable(ScrapOutlineViewReturnHelper.getLevelIcon(i));
        }
    }

    public void setPic(String str) {
        ImageView imageView = this.ivPic;
        if (imageView == null || !isValidContextForGlide(imageView)) {
            return;
        }
        try {
            c.a(this.ivPic).mo55load(str).override(128).diskCacheStrategy(p.f4584d).into(this.ivPic);
        } catch (Exception e2) {
            e2.printStackTrace();
            ReportDataAdapter.onError(this.ivPic.getContext(), e2);
        }
    }

    public void setResId(int i) {
        ImageView imageView = this.ivPic;
        if (imageView == null || i == 0) {
            return;
        }
        imageView.setBackgroundResource(i);
    }

    public void setScrapDoneStatus(int i) {
        this.ivScrapDone.setVisibility(i);
    }

    public void setScrapGameText(String str) {
        this.tvScrapGameText.setText(str);
        this.tvScrapGameText.setVisibility(0);
        this.tvScrapText.setVisibility(8);
    }

    public void setScrapLockStatus(int i, boolean z) {
        this.ivScrapLock.setVisibility(i);
        this.ivScrapLock.setBackground(ScrapOutlineViewReturnHelper.getScrapLockIcon(z));
    }

    public void setScrapShadowStatus(int i) {
        this.vScrapShadow.setVisibility(i);
    }

    public void setScrapText(String str) {
        this.tvScrapText.setText(str);
        this.tvScrapText.setVisibility(0);
        this.tvScrapGameText.setVisibility(8);
    }

    public void setScrapTextStatus(int i) {
        this.tvScrapText.setVisibility(i);
    }

    public void setType(int i) {
        View view = this.bgOutLine;
        if (view != null) {
            view.setBackground(ScrapOutlineViewReturnHelper.getType(i));
        }
        View view2 = this.bgMain;
        if (view2 != null) {
            view2.setBackgroundColor(ScrapOutlineViewReturnHelper.getInsideBgColor(i));
        }
        if (i == 5) {
            setGif(this.ivScrapLevelVip, R.mipmap.base_ic_scrap_level_vip);
        } else {
            setGif(this.ivScrapLevelVip, 0);
        }
    }

    public ScrapLevelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrapLevelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewGroup.inflate(context, R.layout.base_layout_iv_scrap_level, this);
        this.ivPic = (ImageView) findViewById(R.id.iv_scrap_pic);
        this.ivLevel = (ImageView) findViewById(R.id.iv_scrap_level);
        this.bgOutLine = findViewById(R.id.bg_scrap_outline);
        this.vScrapShadow = findViewById(R.id.v_scrap_shadow);
        this.ivScrapDone = (ImageView) findViewById(R.id.iv_scrap_done);
        this.ivScrapLock = (ImageView) findViewById(R.id.iv_scrap_lock);
        this.tvScrapText = (TextView) findViewById(R.id.iv_scrap_text);
        this.tvScrapGameText = (TextView) findViewById(R.id.iv_scrap_game_text);
        this.ivScrapLevelVip = (ImageView) findViewById(R.id.iv_scrap_level_vip);
        this.bgMain = findViewById(R.id.bg_main);
    }
}
