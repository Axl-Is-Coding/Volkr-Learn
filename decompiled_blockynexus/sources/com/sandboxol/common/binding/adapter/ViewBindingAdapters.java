package com.sandboxol.common.binding.adapter;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.command.ResponseCommand;
import com.sandboxol.common.listener.ClickProxy;

/* JADX INFO: loaded from: classes3.dex */
public class ViewBindingAdapters {
    static /* synthetic */ void a(ReplyCommand replyCommand, View view) {
        if (replyCommand != null) {
            replyCommand.execute();
        }
    }

    static /* synthetic */ void b(ReplyCommand replyCommand, View view) {
        if (replyCommand != null) {
            replyCommand.execute();
        }
    }

    public static void backgroundColor(View view, int i) {
        view.setBackgroundColor(i);
    }

    public static void clickCommand(View view, final ReplyCommand replyCommand, boolean z, int i) {
        if (z) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.common.binding.adapter.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ViewBindingAdapters.a(replyCommand, view2);
                }
            });
        } else {
            view.setOnClickListener(new ClickProxy(new View.OnClickListener() { // from class: com.sandboxol.common.binding.adapter.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ViewBindingAdapters.b(replyCommand, view2);
                }
            }, i == 0 ? 1500L : i));
        }
    }

    public static void isEnable(View view, boolean z) {
        view.setEnabled(z);
    }

    public static void isShowLoadingShadow(View view, boolean z) {
        if (z) {
            AnimationDrawable animationDrawable = (AnimationDrawable) view.getBackground();
            animationDrawable.setEnterFadeDuration(250);
            animationDrawable.setExitFadeDuration(500);
            animationDrawable.start();
        }
    }

    public static void onAnimate(final View view, int i, int i2, boolean z, int i3, boolean z2) {
        if (i != 0 && z) {
            try {
                final Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), i);
                view.clearAnimation();
                if (i2 > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.sandboxol.common.binding.adapter.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewBindingAdapters.a(view, animationLoadAnimation);
                        }
                    }, i2);
                } else {
                    view.startAnimation(animationLoadAnimation);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (i3 != 0 && z2) {
            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(view.getContext(), i3);
            view.clearAnimation();
            view.startAnimation(animationLoadAnimation2);
        }
        if (z || z2) {
            return;
        }
        view.clearAnimation();
    }

    public static void onFocusChangeCommand(View view, final ReplyCommand<Boolean> replyCommand) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sandboxol.common.binding.adapter.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                ViewBindingAdapters.a(replyCommand, view2, z);
            }
        });
    }

    public static void onTouchCommand(View view, final ResponseCommand<MotionEvent, Boolean> responseCommand) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.sandboxol.common.binding.adapter.o
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ViewBindingAdapters.a(responseCommand, view2, motionEvent);
            }
        });
    }

    public static void requestFocusCommand(View view, Boolean bool) {
        if (!bool.booleanValue()) {
            view.clearFocus();
        } else {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
    }

    public static void setRoundBackground(View view, int i, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i);
        if (!TextUtils.isEmpty(str)) {
            gradientDrawable.setColor(Color.parseColor(str));
        }
        view.setBackground(gradientDrawable);
    }

    public static void showAnimate(View view, int i) {
        if (i == 0) {
            AnimationSet animationSet = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(WheelView.DividerConfig.FILL, 1.0f);
            alphaAnimation.setDuration(100L);
            animationSet.addAnimation(alphaAnimation);
            view.startAnimation(animationSet);
            return;
        }
        if (i == 8) {
            AnimationSet animationSet2 = new AnimationSet(true);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, WheelView.DividerConfig.FILL);
            alphaAnimation2.setDuration(100L);
            animationSet2.addAnimation(alphaAnimation2);
            view.startAnimation(animationSet2);
        }
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, View view, boolean z) {
        if (replyCommand != null) {
            replyCommand.execute(Boolean.valueOf(z));
        }
    }

    static /* synthetic */ boolean a(ResponseCommand responseCommand, View view, MotionEvent motionEvent) {
        if (responseCommand != null) {
            return ((Boolean) responseCommand.execute(motionEvent)).booleanValue();
        }
        return false;
    }

    static /* synthetic */ void a(View view, Animation animation) {
        view.setVisibility(0);
        view.startAnimation(animation);
    }
}
