package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public class MainGuideView extends LinearLayout {
    private CountDownTimer countDownTimer;
    private View guideView;
    private boolean isExistMakeRoleActivity;
    private ObservableField<Boolean> isShowGuide;
    private ImageView ivHand;
    private LinearLayout main;

    public MainGuideView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCountDownTimer() {
        try {
            this.main.setVisibility(0);
            if (this.ivHand != null && getContext() != null) {
                this.ivHand.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dress_guide_translate));
            }
            this.countDownTimer = new r(this, 10000L, 1000L).start();
        } catch (Exception unused) {
            this.main.setVisibility(8);
        }
    }

    private boolean isTouchPointInView(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCountDownTimer() {
        this.main.setVisibility(8);
        ImageView imageView = this.ivHand;
        if (imageView != null) {
            imageView.clearAnimation();
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public /* synthetic */ void a(View view) {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_NEW_USER_MAIN_FRAGMENT_GUIDE_CLICK);
        stopCountDownTimer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isTouchPointInView(this.guideView, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return super.dispatchTouchEvent(motionEvent);
        }
        this.main.setVisibility(8);
        this.isShowGuide.set(false);
        ReportDataAdapter.onEvent(getContext(), EventConstant.HOME_NOV_PASS);
        return true;
    }

    public MainGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainGuideView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowGuide = new ObservableField<>(false);
        this.isExistMakeRoleActivity = false;
        this.main = (LinearLayout) LinearLayout.inflate(context, R.layout.content_main_new_user_guide, this);
        this.main.setVisibility(8);
        this.isShowGuide.set(false);
        this.guideView = findViewById(R.id.v_guide);
        this.ivHand = (ImageView) findViewById(R.id.iv_hand);
        boolean z = SharedUtils.getBoolean(context, SharedConstant.SHOW_MAIN_FRAGMENT_GUIDE_DIALOG);
        if (!AppInfoCenter.newInstance().getAppConfig().isShowMainGuide() || z) {
            return;
        }
        this.guideView.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12079a.a(view);
            }
        });
        this.isShowGuide.addOnPropertyChangedCallback(new q(this));
        Messenger.getDefault().register(this, MessageToken.TOKEN_NEW_USER_MAIN_FRAGMENT_GUIDE, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.widget.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f12081a.a(context, (Boolean) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_MAKE_ROLE_ACTIVITY_IS_EXIST, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.widget.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f12080a.a((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void a(Context context, Boolean bool) {
        if (this.isExistMakeRoleActivity) {
            return;
        }
        this.isShowGuide.set(bool);
        if (bool.booleanValue()) {
            ReportDataAdapter.onEvent(context, EventConstant.HOME_NOV_TIME);
        }
    }

    public /* synthetic */ void a(Boolean bool) {
        this.isExistMakeRoleActivity = bool.booleanValue();
    }
}
