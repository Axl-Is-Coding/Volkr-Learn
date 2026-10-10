package com.sandboxol.center.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.R;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCircleView extends ConstraintLayout {
    private AnimatorSet circleSet;
    private String gameId;
    private boolean isFromRecently;
    private boolean isPlaying;
    private ImageView ivRing;
    private ImageView ivTick;
    private ConstraintLayout layout;
    private CustomCircleProgressView progressView;
    private AnimatorSet ringSet;
    private AnimatorSet shadowSet;
    private AnimatorSet tickSet;
    private TextView tvPercent;
    private View vShadow;

    /* JADX INFO: renamed from: com.sandboxol.center.view.widget.DownloadCircleView$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ ObjectAnimator val$ringAlpha;
        final /* synthetic */ ObjectAnimator val$ringScaleX;
        final /* synthetic */ ObjectAnimator val$ringScaleY;
        final /* synthetic */ ObjectAnimator val$tickRotation;

        AnonymousClass2(ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2, ObjectAnimator objectAnimator3, ObjectAnimator objectAnimator4) {
            this.val$tickRotation = objectAnimator;
            this.val$ringAlpha = objectAnimator2;
            this.val$ringScaleX = objectAnimator3;
            this.val$ringScaleY = objectAnimator4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            DownloadCircleView.this.ringSet.playTogether(this.val$tickRotation, this.val$ringAlpha, this.val$ringScaleX, this.val$ringScaleY);
            DownloadCircleView.this.ringSet.start();
            DownloadCircleView.this.ringSet.addListener(new Animator.AnimatorListener() { // from class: com.sandboxol.center.view.widget.DownloadCircleView.2.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    DownloadCircleView.this.layout.setVisibility(8);
                    DownloadCircleView.this.isPlaying = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    ObjectAnimator duration = ObjectAnimator.ofFloat(DownloadCircleView.this.layout, "alpha", 1.0f, WheelView.DividerConfig.FILL).setDuration(500L);
                    duration.start();
                    duration.addListener(new AnimatorListenerAdapter() { // from class: com.sandboxol.center.view.widget.DownloadCircleView.2.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator3) {
                            GameProgressInfo gameProgressInfo;
                            super.onAnimationEnd(animator3);
                            DownloadCircleView.this.layout.setVisibility(8);
                            DownloadCircleView.this.isPlaying = false;
                            DownloadCircleView.this.clearAnim();
                            if (TextUtils.isEmpty(DownloadCircleView.this.gameId) || (gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(DownloadCircleView.this.gameId)) == null) {
                                return;
                            }
                            gameProgressInfo.getIsAnimEnd().set(true);
                        }
                    });
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator2) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                }
            });
        }
    }

    public DownloadCircleView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnim() {
        AnimatorSet animatorSet = this.circleSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.shadowSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.tickSet;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.ringSet;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }

    public void playShadowAnim(boolean z) {
        if (!z || this.isPlaying) {
            return;
        }
        this.isPlaying = true;
        this.layout.setVisibility(0);
        this.vShadow.setVisibility(0);
        this.tvPercent.setVisibility(4);
        this.progressView.setVisibility(4);
        this.ivTick.setVisibility(4);
        this.ivRing.setVisibility(4);
        final ObjectAnimator duration = ObjectAnimator.ofFloat(this.progressView, "scaleX", WheelView.DividerConfig.FILL, 1.0f).setDuration(1000L);
        final ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.progressView, "scaleY", WheelView.DividerConfig.FILL, 1.0f).setDuration(1000L);
        final ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.progressView, "alpha", 0.1f, 1.0f).setDuration(1000L);
        this.circleSet = new AnimatorSet();
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.vShadow, "scaleX", WheelView.DividerConfig.FILL, 4.0f).setDuration(1000L);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(this.vShadow, "scaleY", WheelView.DividerConfig.FILL, 4.0f).setDuration(1000L);
        this.shadowSet = new AnimatorSet();
        this.shadowSet.playTogether(duration4, duration5);
        this.shadowSet.start();
        this.shadowSet.addListener(new AnimatorListenerAdapter() { // from class: com.sandboxol.center.view.widget.DownloadCircleView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                DownloadCircleView.this.vShadow.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DownloadCircleView.this.vShadow.setVisibility(4);
                DownloadCircleView.this.layout.setBackgroundResource(R.drawable.bg_shadow_shape);
                DownloadCircleView.this.progressView.setVisibility(0);
                DownloadCircleView.this.circleSet.playTogether(duration, duration2, duration3);
                DownloadCircleView.this.circleSet.start();
                DownloadCircleView.this.circleSet.addListener(new AnimatorListenerAdapter() { // from class: com.sandboxol.center.view.widget.DownloadCircleView.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                        super.onAnimationCancel(animator2);
                        DownloadCircleView.this.progressView.setVisibility(4);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        DownloadCircleView.this.tvPercent.setVisibility(0);
                    }
                });
            }
        });
    }

    public void playTickAnim(boolean z) {
        if (z && this.isPlaying) {
            this.tvPercent.setVisibility(4);
            this.ivTick.setVisibility(0);
            this.ivRing.setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.ivTick, "scaleX", 0.1f, 1.0f).setDuration(1000L);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ivTick, "scaleY", 0.1f, 1.0f).setDuration(1000L);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.ivTick, "rotation", WheelView.DividerConfig.FILL, -15.0f, WheelView.DividerConfig.FILL, 5.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f, WheelView.DividerConfig.FILL, -0.0f).setDuration(1000L);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.ivTick, "alpha", WheelView.DividerConfig.FILL, 1.0f).setDuration(1000L);
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(this.ivRing, "alpha", WheelView.DividerConfig.FILL, 0.5f, WheelView.DividerConfig.FILL).setDuration(1000L);
            ObjectAnimator duration6 = ObjectAnimator.ofFloat(this.ivRing, "scaleX", 1.0f, 1.5f).setDuration(1000L);
            ObjectAnimator duration7 = ObjectAnimator.ofFloat(this.ivRing, "scaleY", 1.0f, 1.5f).setDuration(1000L);
            this.tickSet = new AnimatorSet();
            this.ringSet = new AnimatorSet();
            this.tickSet.playTogether(duration, duration2, duration4);
            this.tickSet.start();
            this.tickSet.addListener(new AnonymousClass2(duration3, duration5, duration6, duration7));
        }
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setLayoutVisibility(boolean z) {
        if (z) {
            this.layout.setVisibility(0);
        } else {
            this.layout.setVisibility(8);
        }
    }

    public void setPercent(String str) {
        this.tvPercent.setText(str);
    }

    public void setProgress(int i) {
        this.progressView.setProgress(i);
    }

    public DownloadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isPlaying = false;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DownloadCircleView, i, 0);
        this.isFromRecently = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DownloadCircleView_isFromRecently, true);
        typedArrayObtainStyledAttributes.recycle();
        if (this.isFromRecently) {
            this.layout = (ConstraintLayout) ViewGroup.inflate(context, R.layout.base_layout_circle_progress, this);
        } else {
            this.layout = (ConstraintLayout) ViewGroup.inflate(context, R.layout.base_layout_circle_progress_other, this);
        }
        this.vShadow = findViewById(R.id.v_shadow);
        this.tvPercent = (TextView) findViewById(R.id.tv_percent);
        this.progressView = (CustomCircleProgressView) findViewById(R.id.cpv_progress);
        this.ivTick = (ImageView) findViewById(R.id.iv_tick);
        this.ivRing = (ImageView) findViewById(R.id.iv_ring);
        this.layout.setVisibility(8);
    }
}
