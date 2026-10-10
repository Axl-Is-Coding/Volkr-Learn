package com.sandboxol.common.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.ImageView;
import androidx.appcompat.app.l;

/* JADX INFO: loaded from: classes3.dex */
public class FrameAnimationUtil {
    private static final int SELECTED_A = 1;
    private static final int SELECTED_B = 2;
    private static final int SELECTED_C = 3;
    private static final int SELECTED_D = 4;
    private AnimationListener mAnimationListener;
    private int mCurrentFrame;
    private int mCurrentSelect;
    private int mDelay;
    private int mDuration;
    private int[] mDurations;
    private int[] mFrameRess;
    private ImageView mImageView;
    private boolean mIsRepeat;
    private int mLastFrame;
    private boolean mNext;
    private boolean mPause;

    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationRepeat();

        void onAnimationStart();
    }

    static {
        l.a(true);
    }

    public FrameAnimationUtil(Context context, ImageView imageView, int i, int i2, boolean z) {
        this.mImageView = imageView;
        this.mFrameRess = getRes(context, i);
        this.mDuration = i2;
        this.mLastFrame = this.mFrameRess.length - 1;
        this.mIsRepeat = z;
        play(context, 0);
    }

    private int[] getRes(Context context, int i) {
        TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(i);
        int length = typedArrayObtainTypedArray.length();
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = typedArrayObtainTypedArray.getResourceId(i2, 0);
        }
        typedArrayObtainTypedArray.recycle();
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play(final Context context, final int i) {
        this.mImageView.postDelayed(new Runnable() { // from class: com.sandboxol.common.utils.FrameAnimationUtil.4
            @Override // java.lang.Runnable
            public void run() {
                if (FrameAnimationUtil.this.mPause) {
                    if (FrameAnimationUtil.this.mPause) {
                        FrameAnimationUtil.this.mCurrentSelect = 4;
                        FrameAnimationUtil.this.mCurrentFrame = i;
                        return;
                    }
                    return;
                }
                if (i == 0 && FrameAnimationUtil.this.mAnimationListener != null) {
                    FrameAnimationUtil.this.mAnimationListener.onAnimationStart();
                }
                ImageUtils.setBackgroundResource(context, FrameAnimationUtil.this.mImageView, FrameAnimationUtil.this.mFrameRess[i]);
                if (i != FrameAnimationUtil.this.mLastFrame) {
                    FrameAnimationUtil.this.play(context, i + 1);
                    return;
                }
                if (FrameAnimationUtil.this.mIsRepeat) {
                    if (FrameAnimationUtil.this.mAnimationListener != null) {
                        FrameAnimationUtil.this.mAnimationListener.onAnimationRepeat();
                    }
                    FrameAnimationUtil.this.play(context, 0);
                } else if (FrameAnimationUtil.this.mAnimationListener != null) {
                    FrameAnimationUtil.this.mAnimationListener.onAnimationEnd();
                }
            }
        }, this.mDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAndDelay(final Context context, final int i) {
        int i2;
        ImageView imageView = this.mImageView;
        Runnable runnable = new Runnable() { // from class: com.sandboxol.common.utils.FrameAnimationUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (FrameAnimationUtil.this.mPause) {
                    if (FrameAnimationUtil.this.mPause) {
                        FrameAnimationUtil.this.mCurrentSelect = 2;
                        FrameAnimationUtil.this.mCurrentFrame = i;
                        return;
                    }
                    return;
                }
                FrameAnimationUtil.this.mNext = false;
                if (i == 0 && FrameAnimationUtil.this.mAnimationListener != null) {
                    FrameAnimationUtil.this.mAnimationListener.onAnimationStart();
                }
                ImageUtils.setBackgroundResource(context, FrameAnimationUtil.this.mImageView, FrameAnimationUtil.this.mFrameRess[i]);
                if (i != FrameAnimationUtil.this.mLastFrame) {
                    FrameAnimationUtil.this.playAndDelay(context, i + 1);
                    return;
                }
                if (FrameAnimationUtil.this.mAnimationListener != null) {
                    FrameAnimationUtil.this.mAnimationListener.onAnimationRepeat();
                }
                FrameAnimationUtil.this.mNext = true;
                FrameAnimationUtil.this.playAndDelay(context, 0);
            }
        };
        if (!this.mNext || (i2 = this.mDelay) <= 0) {
            i2 = this.mDuration;
        }
        imageView.postDelayed(runnable, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playByDurations(final Context context, final int i) {
        this.mImageView.postDelayed(new Runnable() { // from class: com.sandboxol.common.utils.FrameAnimationUtil.3
            @Override // java.lang.Runnable
            public void run() {
                if (FrameAnimationUtil.this.mPause) {
                    if (FrameAnimationUtil.this.mPause) {
                        FrameAnimationUtil.this.mCurrentSelect = 3;
                        FrameAnimationUtil.this.mCurrentFrame = i;
                        return;
                    }
                    return;
                }
                if (i == 0 && FrameAnimationUtil.this.mAnimationListener != null) {
                    FrameAnimationUtil.this.mAnimationListener.onAnimationStart();
                }
                ImageUtils.setBackgroundResource(context, FrameAnimationUtil.this.mImageView, FrameAnimationUtil.this.mFrameRess[i]);
                if (i != FrameAnimationUtil.this.mLastFrame) {
                    FrameAnimationUtil.this.playByDurations(context, i + 1);
                    return;
                }
                if (FrameAnimationUtil.this.mIsRepeat) {
                    if (FrameAnimationUtil.this.mAnimationListener != null) {
                        FrameAnimationUtil.this.mAnimationListener.onAnimationRepeat();
                    }
                    FrameAnimationUtil.this.playByDurations(context, 0);
                } else if (FrameAnimationUtil.this.mAnimationListener != null) {
                    FrameAnimationUtil.this.mAnimationListener.onAnimationEnd();
                }
            }
        }, this.mDurations[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playByDurationsAndDelay(final Context context, final int i) {
        int i2;
        ImageView imageView = this.mImageView;
        Runnable runnable = new Runnable() { // from class: com.sandboxol.common.utils.FrameAnimationUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrameAnimationUtil.this.mPause) {
                    FrameAnimationUtil.this.mCurrentSelect = 1;
                    FrameAnimationUtil.this.mCurrentFrame = i;
                    return;
                }
                if (i == 0 && FrameAnimationUtil.this.mAnimationListener != null) {
                    FrameAnimationUtil.this.mAnimationListener.onAnimationStart();
                }
                ImageUtils.setBackgroundResource(context, FrameAnimationUtil.this.mImageView, FrameAnimationUtil.this.mFrameRess[i]);
                if (i != FrameAnimationUtil.this.mLastFrame) {
                    FrameAnimationUtil.this.playByDurationsAndDelay(context, i + 1);
                    return;
                }
                if (FrameAnimationUtil.this.mAnimationListener != null) {
                    FrameAnimationUtil.this.mAnimationListener.onAnimationRepeat();
                }
                FrameAnimationUtil.this.mNext = true;
                FrameAnimationUtil.this.playByDurationsAndDelay(context, 0);
            }
        };
        if (!this.mNext || (i2 = this.mDelay) <= 0) {
            i2 = this.mDurations[i];
        }
        imageView.postDelayed(runnable, i2);
    }

    public boolean isPause() {
        return this.mPause;
    }

    public void pauseAnimation() {
        this.mPause = true;
    }

    public void release() {
        pauseAnimation();
    }

    public void restartAnimation(Context context) {
        if (this.mPause) {
            this.mPause = false;
            int i = this.mCurrentSelect;
            if (i == 1) {
                playByDurationsAndDelay(context, this.mCurrentFrame);
                return;
            }
            if (i == 2) {
                playAndDelay(null, this.mCurrentFrame);
            } else if (i == 3) {
                playByDurations(context, this.mCurrentFrame);
            } else {
                if (i != 4) {
                    return;
                }
                play(context, this.mCurrentFrame);
            }
        }
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mAnimationListener = animationListener;
    }

    public FrameAnimationUtil(Context context, ImageView imageView, int i, int i2, int i3) {
        this.mImageView = imageView;
        this.mFrameRess = getRes(context, i);
        this.mDuration = i2;
        this.mDelay = i3;
        this.mLastFrame = this.mFrameRess.length - 1;
        playAndDelay(context, 0);
    }
}
