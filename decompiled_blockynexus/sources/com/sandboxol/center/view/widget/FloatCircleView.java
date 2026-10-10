package com.sandboxol.center.view.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.greendao.a.c;
import com.sandboxol.greendao.c.K;
import com.sandboxol.greendao.entity.FloatViewInfo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class FloatCircleView extends ConstraintLayout {
    private ObjectAnimator alpha;
    private int downX;
    private int downY;
    private boolean isDrag;
    private boolean isHasPress;
    private ObservableField<Boolean> isTouchDown;
    private boolean isTranslucent;
    private int lastX;
    private int lastY;
    private FloatCircleListener listener;
    private FloatCircleLocationListener locationListener;
    private int locationX;
    private int locationY;
    private CircleProgressView mCircleProgressView;
    private ImageView mIvFloatViewBoxPic;
    private int mTouchSlop;
    private TextView mTvAvailableCount;
    private TextView mTvRemainingTimeBox;
    private int offsetY;
    private int parentHeight;
    private int parentWidth;
    private Queue<ObjectAnimator> queue;

    /* JADX INFO: renamed from: com.sandboxol.center.view.widget.FloatCircleView$2, reason: invalid class name */
    class AnonymousClass2 extends Observable.a {
        AnonymousClass2() {
        }

        public /* synthetic */ void a(Long l) {
            if (FloatCircleView.this.isTranslucent || FloatCircleView.this.mTvAvailableCount.getVisibility() != 4) {
                return;
            }
            FloatCircleView floatCircleView = FloatCircleView.this;
            floatCircleView.alpha = ObjectAnimator.ofFloat(floatCircleView, "alpha", 1.0f, 0.2f).setDuration(3000L);
            FloatCircleView.this.isTranslucent = true;
            FloatCircleView.this.alpha.start();
        }

        @Override // androidx.databinding.Observable.a
        public void onPropertyChanged(Observable observable, int i) {
            if (!((Boolean) FloatCircleView.this.isTouchDown.get()).booleanValue()) {
                rx.Observable.timer(3L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.center.view.widget.a
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f16399a.a((Long) obj);
                    }
                });
                return;
            }
            if (FloatCircleView.this.isTranslucent) {
                if (FloatCircleView.this.alpha != null && FloatCircleView.this.alpha.isRunning()) {
                    FloatCircleView.this.alpha.cancel();
                }
                FloatCircleView floatCircleView = FloatCircleView.this;
                floatCircleView.alpha = ObjectAnimator.ofFloat(floatCircleView, "alpha", 0.2f, 1.0f).setDuration(3000L);
                FloatCircleView.this.isTranslucent = false;
                FloatCircleView.this.alpha.start();
            }
        }
    }

    public interface FloatCircleListener {
        void onClick();
    }

    public interface FloatCircleLocationListener {
        void onInitSuccess();
    }

    public FloatCircleView(Context context, FloatCircleLocationListener floatCircleLocationListener) {
        this(context, null, floatCircleLocationListener);
    }

    private boolean isLeftSide() {
        return getX() == WheelView.DividerConfig.FILL;
    }

    private boolean isRightSide() {
        return getX() == ((float) (this.parentWidth - getWidth()));
    }

    private void welt(int i) {
        if (isLeftSide() && isRightSide()) {
            return;
        }
        if (i >= this.parentWidth / 2) {
            animate().setInterpolator(new AccelerateInterpolator()).setDuration(500L).xBy((this.parentWidth - getWidth()) - getX()).start();
            this.locationX = this.parentWidth - getWidth();
            this.locationY = this.lastY - this.offsetY;
            if (this.locationY > this.parentHeight - getHeight()) {
                this.locationY = this.parentHeight - getHeight();
            }
            if (this.locationY < 0) {
                this.locationY = 0;
                return;
            }
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "x", getX(), WheelView.DividerConfig.FILL);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
        this.locationX = 0;
        this.locationY = this.lastY - this.offsetY;
        if (this.locationY > this.parentHeight - getHeight()) {
            this.locationY = this.parentHeight - getHeight();
        }
        if (this.locationY < 0) {
            this.locationY = 0;
        }
    }

    public int getLocationX() {
        return this.locationX;
    }

    public int getLocationY() {
        return this.locationY;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FloatCircleListener floatCircleListener;
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            setPressed(true);
            this.isDrag = false;
            this.isTouchDown.set(true);
            getParent().requestDisallowInterceptTouchEvent(true);
            this.lastX = rawX;
            this.lastY = rawY;
            this.downX = rawX;
            this.downY = rawY;
            if (!this.isHasPress) {
                this.offsetY = this.downY - getTop();
                this.isHasPress = true;
            }
            if (getParent() != null) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                this.parentHeight = viewGroup.getHeight();
                this.parentWidth = viewGroup.getWidth();
            }
        } else if (action == 1) {
            this.isTouchDown.set(false);
            this.isDrag = Math.abs(rawX - this.downX) > this.mTouchSlop || Math.abs(rawY - this.downY) > this.mTouchSlop;
            if (this.isDrag) {
                setPressed(false);
            }
            if (!this.isDrag && (floatCircleListener = this.listener) != null) {
                floatCircleListener.onClick();
            }
            welt(rawX);
        } else if (action == 2) {
            int i = rawX - this.lastX;
            int i2 = rawY - this.lastY;
            float x = getX() + i;
            float y = getY() + i2;
            if (x < WheelView.DividerConfig.FILL) {
                x = WheelView.DividerConfig.FILL;
            } else if (x > this.parentWidth - getWidth()) {
                x = this.parentWidth - getWidth();
            }
            if (y < WheelView.DividerConfig.FILL) {
                y = WheelView.DividerConfig.FILL;
            } else if (y > this.parentHeight - getHeight()) {
                y = this.parentHeight - getHeight();
            }
            setX(x);
            setY(y);
            this.lastX = rawX;
            this.lastY = rawY;
        }
        return true;
    }

    public void setBoxPic(int i) {
        ImageView imageView = this.mIvFloatViewBoxPic;
        if (imageView != null) {
            imageView.setBackgroundResource(i);
        }
    }

    public FloatCircleView setListener(FloatCircleListener floatCircleListener) {
        this.listener = floatCircleListener;
        return this;
    }

    public FloatCircleView setLocationListener(FloatCircleLocationListener floatCircleLocationListener) {
        this.locationListener = floatCircleLocationListener;
        return this;
    }

    public void setProgressPercent(int i, int i2) {
        CircleProgressView circleProgressView = this.mCircleProgressView;
        if (circleProgressView != null) {
            circleProgressView.setProgressPercent(i, i2);
        }
    }

    public void setRedPoint(int i, String str) {
        ObjectAnimator objectAnimator;
        TextView textView = this.mTvAvailableCount;
        if (textView != null) {
            textView.setVisibility(i);
            this.mTvAvailableCount.setText(str);
            if (i == 4 && this.mTvRemainingTimeBox.getVisibility() == 4 && (((objectAnimator = this.alpha) == null || !objectAnimator.isRunning()) && !this.isTranslucent)) {
                this.alpha = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.2f).setDuration(3000L);
                this.isTranslucent = true;
                this.alpha.start();
            } else if (i == 0 && this.mTvAvailableCount.getVisibility() == 0) {
                ObjectAnimator objectAnimator2 = this.alpha;
                if ((objectAnimator2 == null || !objectAnimator2.isRunning()) && this.isTranslucent) {
                    this.alpha = ObjectAnimator.ofFloat(this, "alpha", 0.2f, 1.0f).setDuration(3000L);
                    this.isTranslucent = false;
                    this.alpha.start();
                }
            }
        }
    }

    public void setRemainingTime(int i, String str) {
        TextView textView = this.mTvRemainingTimeBox;
        if (textView != null) {
            textView.setVisibility(i);
            this.mTvRemainingTimeBox.setText(str);
        }
    }

    public FloatCircleView(Context context, AttributeSet attributeSet, FloatCircleLocationListener floatCircleLocationListener) {
        this(context, attributeSet, 0, floatCircleLocationListener);
    }

    public FloatCircleView(Context context, AttributeSet attributeSet, int i, FloatCircleLocationListener floatCircleLocationListener) {
        super(context, attributeSet, i);
        this.isTranslucent = false;
        this.isTouchDown = new ObservableField<>(false);
        this.locationListener = floatCircleLocationListener;
        ViewGroup.inflate(context, R.layout.base_layout_float_circle, this);
        this.mCircleProgressView = (CircleProgressView) findViewById(R.id.cpv_progress);
        this.mTvAvailableCount = (TextView) findViewById(R.id.tv_available_count);
        this.mTvRemainingTimeBox = (TextView) findViewById(R.id.tv_remaining_time_box);
        this.mIvFloatViewBoxPic = (ImageView) findViewById(R.id.iv_pic);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.queue = new LinkedList();
        K.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), new c<FloatViewInfo>() { // from class: com.sandboxol.center.view.widget.FloatCircleView.1
            @Override // com.sandboxol.greendao.a.c
            public void onError(int i2, String str) {
                if (FloatCircleView.this.locationListener != null) {
                    FloatCircleView.this.locationListener.onInitSuccess();
                }
            }

            @Override // com.sandboxol.greendao.a.c
            public void onSuccess(FloatViewInfo floatViewInfo) {
                if (floatViewInfo != null) {
                    FloatCircleView.this.locationX = floatViewInfo.getLocationX();
                    FloatCircleView.this.locationY = floatViewInfo.getLocationY();
                }
                if (FloatCircleView.this.locationListener != null) {
                    FloatCircleView.this.locationListener.onInitSuccess();
                }
            }
        });
        this.isTouchDown.addOnPropertyChangedCallback(new AnonymousClass2());
    }
}
