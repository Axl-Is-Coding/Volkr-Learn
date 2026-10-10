package com.warkiz.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes5.dex */
public class IndicatorSeekBar extends View {
    private static final String FORMAT_PROGRESS = "${PROGRESS}";
    private static final String FORMAT_TICK_TEXT = "${TICK_TEXT}";
    private static final int THUMB_MAX_WIDTH = 30;
    private float lastProgress;
    private boolean mAdjustAuto;
    private RectF mBackgroundTrack;
    private int mBackgroundTrackColor;
    private int mBackgroundTrackSize;
    private boolean mClearPadding;
    private Context mContext;
    private float mCustomDrawableMaxHeight;
    private boolean mCustomTrackSectionColorResult;
    private float mFaultTolerance;
    private boolean mHideThumb;
    private int mHoveredTextColor;
    private d mIndicator;
    private int mIndicatorColor;
    private View mIndicatorContentView;
    private boolean mIndicatorStayAlways;
    private int mIndicatorTextColor;
    private String mIndicatorTextFormat;
    private int mIndicatorTextSize;
    private View mIndicatorTopContentView;
    private boolean mIsFloatProgress;
    private boolean mIsTouching;
    private float mMax;
    private int mMeasuredWidth;
    private float mMin;
    private boolean mOnlyThumbDraggable;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Bitmap mPressedThumbBitmap;
    private int mPressedThumbColor;
    private float mProgress;
    private float[] mProgressArr;
    private RectF mProgressTrack;
    private int mProgressTrackColor;
    private int mProgressTrackSize;
    private boolean mR2L;
    private Rect mRect;
    private int mScale;
    private float mScreenWidth;
    private int[] mSectionTrackColorArray;
    private float mSeekBlockLength;
    private h mSeekChangeListener;
    private float mSeekLength;
    private i mSeekParams;
    private boolean mSeekSmoothly;
    private Bitmap mSelectTickMarksBitmap;
    private int mSelectedTextsColor;
    private int mSelectedTickMarksColor;
    private boolean mShowBothTickTextsOnly;
    private int mShowIndicatorType;
    private boolean mShowThumbText;
    private int mShowTickMarksType;
    private boolean mShowTickText;
    private Paint mStockPaint;
    private float[] mTextCenterX;
    private TextPaint mTextPaint;
    private Typeface mTextsTypeface;
    private Bitmap mThumbBitmap;
    private int mThumbColor;
    private Drawable mThumbDrawable;
    private float mThumbRadius;
    private int mThumbSize;
    private int mThumbTextColor;
    private float mThumbTextY;
    private float mThumbTouchRadius;
    private Drawable mTickMarksDrawable;
    private boolean mTickMarksEndsHide;
    private int mTickMarksSize;
    private boolean mTickMarksSweptHide;
    private float[] mTickMarksX;
    private float mTickRadius;
    private float mTickTextY;
    private String[] mTickTextsArr;
    private CharSequence[] mTickTextsCustomArray;
    private int mTickTextsHeight;
    private int mTickTextsSize;
    private float[] mTickTextsWidth;
    private int mTicksCount;
    private boolean mTrackRoundedCorners;
    private int mUnSelectedTickMarksColor;
    private Bitmap mUnselectTickMarksBitmap;
    private int mUnselectedTextsColor;
    private boolean mUserSeekable;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    private float adjustTouchX(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int i = this.mPaddingLeft;
        if (x >= i) {
            float x2 = motionEvent.getX();
            int i2 = this.mMeasuredWidth;
            int i3 = this.mPaddingRight;
            if (x2 <= i2 - i3) {
                return motionEvent.getX();
            }
            i = i2 - i3;
        }
        return i;
    }

    private void apply(a aVar) {
        this.mMax = aVar.f21374b;
        this.mMin = aVar.f21375c;
        this.mProgress = aVar.f21376d;
        this.mIsFloatProgress = aVar.f21377e;
        this.mTicksCount = aVar.H;
        this.mSeekSmoothly = aVar.f21378f;
        this.mR2L = aVar.g;
        this.mUserSeekable = aVar.h;
        this.mClearPadding = aVar.j;
        this.mOnlyThumbDraggable = aVar.i;
        this.mShowIndicatorType = aVar.k;
        this.mIndicatorColor = aVar.l;
        this.mIndicatorTextColor = aVar.m;
        this.mIndicatorTextSize = aVar.n;
        this.mIndicatorContentView = aVar.o;
        this.mIndicatorTopContentView = aVar.p;
        this.mBackgroundTrackSize = aVar.q;
        this.mBackgroundTrackColor = aVar.r;
        this.mProgressTrackSize = aVar.s;
        this.mProgressTrackColor = aVar.t;
        this.mTrackRoundedCorners = aVar.u;
        this.mThumbSize = aVar.x;
        this.mThumbDrawable = aVar.A;
        this.mThumbTextColor = aVar.v;
        initThumbColor(aVar.z, aVar.y);
        this.mShowThumbText = aVar.w;
        this.mShowTickMarksType = aVar.I;
        this.mTickMarksSize = aVar.K;
        this.mTickMarksDrawable = aVar.L;
        this.mTickMarksEndsHide = aVar.M;
        this.mTickMarksSweptHide = aVar.N;
        initTickMarksColor(aVar.O, aVar.J);
        this.mShowTickText = aVar.B;
        this.mTickTextsSize = aVar.D;
        this.mTickTextsCustomArray = aVar.E;
        this.mTextsTypeface = aVar.F;
        initTickTextsColor(aVar.G, aVar.C);
    }

    private boolean autoAdjustThumb() {
        if (this.mTicksCount < 3 || !this.mSeekSmoothly || !this.mAdjustAuto) {
            return false;
        }
        int closestIndex = getClosestIndex();
        float f2 = this.mProgress;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(WheelView.DividerConfig.FILL, Math.abs(f2 - this.mProgressArr[closestIndex]));
        valueAnimatorOfFloat.start();
        valueAnimatorOfFloat.addUpdateListener(new f(this, f2, closestIndex));
        return true;
    }

    private float calculateProgress(float f2) {
        this.lastProgress = this.mProgress;
        this.mProgress = this.mMin + ((getAmplitude() * (f2 - this.mPaddingLeft)) / this.mSeekLength);
        return this.mProgress;
    }

    private float calculateTouchX(float f2) {
        if (this.mTicksCount > 2 && !this.mSeekSmoothly) {
            f2 = this.mPaddingLeft + (this.mSeekBlockLength * Math.round((f2 - this.mPaddingLeft) / this.mSeekBlockLength));
        }
        return this.mR2L ? (this.mSeekLength - f2) + (this.mPaddingLeft * 2) : f2;
    }

    private i collectParams(boolean z) {
        String[] strArr;
        if (this.mSeekParams == null) {
            this.mSeekParams = new i(this);
        }
        this.mSeekParams.f21392b = getProgress();
        this.mSeekParams.f21393c = getProgressFloat();
        this.mSeekParams.f21394d = z;
        if (this.mTicksCount > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.mShowTickText && (strArr = this.mTickTextsArr) != null) {
                this.mSeekParams.f21396f = strArr[thumbPosOnTick];
            }
            if (this.mR2L) {
                this.mSeekParams.f21395e = (this.mTicksCount - thumbPosOnTick) - 1;
            } else {
                this.mSeekParams.f21395e = thumbPosOnTick;
            }
        }
        return this.mSeekParams;
    }

    private void collectTicksInfo() {
        int i = this.mTicksCount;
        if (i < 0 || i > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.mTicksCount);
        }
        if (i == 0) {
            return;
        }
        this.mTickMarksX = new float[i];
        if (this.mShowTickText) {
            this.mTextCenterX = new float[i];
            this.mTickTextsWidth = new float[i];
        }
        this.mProgressArr = new float[this.mTicksCount];
        int i2 = 0;
        while (true) {
            float[] fArr = this.mProgressArr;
            if (i2 >= fArr.length) {
                return;
            }
            float f2 = this.mMin;
            fArr[i2] = f2 + ((i2 * (this.mMax - f2)) / (this.mTicksCount + (-1) > 0 ? r4 - 1 : 1));
            i2++;
        }
    }

    private void drawThumb(Canvas canvas) {
        if (this.mHideThumb) {
            return;
        }
        float thumbCenterX = getThumbCenterX();
        if (this.mThumbDrawable == null) {
            if (this.mIsTouching) {
                this.mStockPaint.setColor(this.mPressedThumbColor);
            } else {
                this.mStockPaint.setColor(this.mThumbColor);
            }
            canvas.drawCircle(thumbCenterX, this.mProgressTrack.top, this.mIsTouching ? this.mThumbTouchRadius : this.mThumbRadius, this.mStockPaint);
            return;
        }
        if (this.mThumbBitmap == null || this.mPressedThumbBitmap == null) {
            initThumbBitmap();
        }
        if (this.mThumbBitmap == null || this.mPressedThumbBitmap == null) {
            throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
        }
        this.mStockPaint.setAlpha(255);
        if (this.mIsTouching) {
            canvas.drawBitmap(this.mPressedThumbBitmap, thumbCenterX - (r1.getWidth() / 2.0f), this.mProgressTrack.top - (this.mPressedThumbBitmap.getHeight() / 2.0f), this.mStockPaint);
        } else {
            canvas.drawBitmap(this.mThumbBitmap, thumbCenterX - (r1.getWidth() / 2.0f), this.mProgressTrack.top - (this.mThumbBitmap.getHeight() / 2.0f), this.mStockPaint);
        }
    }

    private void drawThumbText(Canvas canvas) {
        if (this.mShowThumbText) {
            if (!this.mShowTickText || this.mTicksCount <= 2) {
                this.mTextPaint.setColor(this.mThumbTextColor);
                canvas.drawText(getProgressString(this.mProgress), getThumbCenterX(), this.mThumbTextY, this.mTextPaint);
            }
        }
    }

    private void drawTickMarks(Canvas canvas) {
        Bitmap bitmap;
        if (this.mTicksCount != 0) {
            if (this.mShowTickMarksType == 0 && this.mTickMarksDrawable == null) {
                return;
            }
            float thumbCenterX = getThumbCenterX();
            for (int i = 0; i < this.mTickMarksX.length; i++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.mTickMarksSweptHide || thumbCenterX < this.mTickMarksX[i]) && ((!this.mTickMarksEndsHide || (i != 0 && i != this.mTickMarksX.length - 1)) && (i != getThumbPosOnTick() || this.mTicksCount <= 2 || this.mSeekSmoothly))) {
                    float f2 = i;
                    if (f2 <= thumbPosOnTickFloat) {
                        this.mStockPaint.setColor(getLeftSideTickColor());
                    } else {
                        this.mStockPaint.setColor(getRightSideTickColor());
                    }
                    if (this.mTickMarksDrawable != null) {
                        if (this.mSelectTickMarksBitmap == null || this.mUnselectTickMarksBitmap == null) {
                            initTickMarksBitmap();
                        }
                        Bitmap bitmap2 = this.mSelectTickMarksBitmap;
                        if (bitmap2 == null || (bitmap = this.mUnselectTickMarksBitmap) == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        }
                        if (f2 <= thumbPosOnTickFloat) {
                            canvas.drawBitmap(bitmap2, this.mTickMarksX[i] - (bitmap.getWidth() / 2.0f), this.mProgressTrack.top - (this.mUnselectTickMarksBitmap.getHeight() / 2.0f), this.mStockPaint);
                        } else {
                            canvas.drawBitmap(bitmap, this.mTickMarksX[i] - (bitmap.getWidth() / 2.0f), this.mProgressTrack.top - (this.mUnselectTickMarksBitmap.getHeight() / 2.0f), this.mStockPaint);
                        }
                    } else {
                        int i2 = this.mShowTickMarksType;
                        if (i2 == 1) {
                            canvas.drawCircle(this.mTickMarksX[i], this.mProgressTrack.top, this.mTickRadius, this.mStockPaint);
                        } else if (i2 == 3) {
                            int iA = j.a(this.mContext, 1.0f);
                            int leftSideTrackSize = thumbCenterX >= this.mTickMarksX[i] ? getLeftSideTrackSize() : getRightSideTrackSize();
                            float[] fArr = this.mTickMarksX;
                            float f3 = iA;
                            float f4 = fArr[i] - f3;
                            float f5 = this.mProgressTrack.top;
                            float f6 = leftSideTrackSize / 2.0f;
                            canvas.drawRect(f4, f5 - f6, fArr[i] + f3, f5 + f6, this.mStockPaint);
                        } else if (i2 == 2) {
                            float[] fArr2 = this.mTickMarksX;
                            float f7 = fArr2[i];
                            int i3 = this.mTickMarksSize;
                            float f8 = f7 - (i3 / 2.0f);
                            float f9 = this.mProgressTrack.top;
                            canvas.drawRect(f8, f9 - (i3 / 2.0f), fArr2[i] + (i3 / 2.0f), f9 + (i3 / 2.0f), this.mStockPaint);
                        }
                    }
                }
            }
        }
    }

    private void drawTickTexts(Canvas canvas) {
        if (this.mTickTextsArr == null) {
            return;
        }
        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
        int i = 0;
        while (true) {
            if (i >= this.mTickTextsArr.length) {
                return;
            }
            if (!this.mShowBothTickTextsOnly || i == 0 || i == r2.length - 1) {
                if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                    this.mTextPaint.setColor(this.mHoveredTextColor);
                } else if (i < thumbPosOnTickFloat) {
                    this.mTextPaint.setColor(getLeftSideTickTextsColor());
                } else {
                    this.mTextPaint.setColor(getRightSideTickTextsColor());
                }
                int length = this.mR2L ? (this.mTickTextsArr.length - i) - 1 : i;
                if (i == 0) {
                    canvas.drawText(this.mTickTextsArr[length], this.mTextCenterX[i] + (this.mTickTextsWidth[length] / 2.0f), this.mTickTextY, this.mTextPaint);
                } else {
                    String[] strArr = this.mTickTextsArr;
                    if (i == strArr.length - 1) {
                        canvas.drawText(strArr[length], this.mTextCenterX[i] - (this.mTickTextsWidth[length] / 2.0f), this.mTickTextY, this.mTextPaint);
                    } else {
                        canvas.drawText(strArr[length], this.mTextCenterX[i], this.mTickTextY, this.mTextPaint);
                    }
                }
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void drawTrack(android.graphics.Canvas r14) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.widget.IndicatorSeekBar.drawTrack(android.graphics.Canvas):void");
    }

    private float getAmplitude() {
        float f2 = this.mMax;
        float f3 = this.mMin;
        if (f2 - f3 > WheelView.DividerConfig.FILL) {
            return f2 - f3;
        }
        return 1.0f;
    }

    private int getClosestIndex() {
        int i = 0;
        float fAbs = Math.abs(this.mMax - this.mMin);
        int i2 = 0;
        while (true) {
            float[] fArr = this.mProgressArr;
            if (i >= fArr.length) {
                return i2;
            }
            float fAbs2 = Math.abs(fArr[i] - this.mProgress);
            if (fAbs2 <= fAbs) {
                i2 = i;
                fAbs = fAbs2;
            }
            i++;
        }
    }

    private Bitmap getDrawBitmap(Drawable drawable, boolean z) {
        int intrinsicHeight;
        if (drawable == null) {
            return null;
        }
        int iA = j.a(this.mContext, 30.0f);
        if (drawable.getIntrinsicWidth() > iA) {
            int i = z ? this.mThumbSize : this.mTickMarksSize;
            intrinsicHeight = getHeightByRatio(drawable, i);
            if (i > iA) {
                intrinsicHeight = getHeightByRatio(drawable, iA);
            } else {
                iA = i;
            }
        } else {
            iA = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private int getHeightByRatio(Drawable drawable, int i) {
        return Math.round(((i * 1.0f) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
    }

    private int getLeftSideTickColor() {
        return this.mR2L ? this.mUnSelectedTickMarksColor : this.mSelectedTickMarksColor;
    }

    private int getLeftSideTickTextsColor() {
        return this.mR2L ? this.mUnselectedTextsColor : this.mSelectedTextsColor;
    }

    private int getLeftSideTrackSize() {
        return this.mR2L ? this.mBackgroundTrackSize : this.mProgressTrackSize;
    }

    private String getProgressString(float f2) {
        return this.mIsFloatProgress ? c.a(f2, this.mScale) : String.valueOf(Math.round(f2));
    }

    private int getRightSideTickColor() {
        return this.mR2L ? this.mSelectedTickMarksColor : this.mUnSelectedTickMarksColor;
    }

    private int getRightSideTickTextsColor() {
        return this.mR2L ? this.mSelectedTextsColor : this.mUnselectedTextsColor;
    }

    private int getRightSideTrackSize() {
        return this.mR2L ? this.mProgressTrackSize : this.mBackgroundTrackSize;
    }

    private float getThumbCenterX() {
        return this.mR2L ? this.mBackgroundTrack.right : this.mProgressTrack.right;
    }

    private int getThumbPosOnTick() {
        if (this.mTicksCount != 0) {
            return Math.round((getThumbCenterX() - this.mPaddingLeft) / this.mSeekBlockLength);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        return this.mTicksCount != 0 ? (getThumbCenterX() - this.mPaddingLeft) / this.mSeekBlockLength : WheelView.DividerConfig.FILL;
    }

    private String getTickTextByPosition(int i) {
        CharSequence[] charSequenceArr = this.mTickTextsCustomArray;
        return charSequenceArr == null ? getProgressString(this.mProgressArr[i]) : i < charSequenceArr.length ? String.valueOf(charSequenceArr[i]) : "";
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            apply(aVar);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorSeekBar);
        this.mMax = typedArrayObtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_max, aVar.f21374b);
        this.mMin = typedArrayObtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_min, aVar.f21375c);
        this.mProgress = typedArrayObtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_progress, aVar.f21376d);
        this.mIsFloatProgress = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_progress_value_float, aVar.f21377e);
        this.mUserSeekable = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_user_seekable, aVar.h);
        this.mClearPadding = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_clear_default_padding, aVar.j);
        this.mOnlyThumbDraggable = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_only_thumb_draggable, aVar.i);
        this.mSeekSmoothly = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_seek_smoothly, aVar.f21378f);
        this.mR2L = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_r2l, aVar.g);
        this.mBackgroundTrackSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_track_background_size, aVar.q);
        this.mProgressTrackSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_track_progress_size, aVar.s);
        this.mBackgroundTrackColor = typedArrayObtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_track_background_color, aVar.r);
        this.mProgressTrackColor = typedArrayObtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_track_progress_color, aVar.t);
        this.mTrackRoundedCorners = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_track_rounded_corners, aVar.u);
        this.mThumbSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_thumb_size, aVar.x);
        this.mThumbDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.IndicatorSeekBar_isb_thumb_drawable);
        this.mAdjustAuto = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        initThumbColor(typedArrayObtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_thumb_color), aVar.y);
        this.mShowThumbText = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_show_thumb_text, aVar.w);
        this.mThumbTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_thumb_text_color, aVar.v);
        this.mTicksCount = typedArrayObtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_ticks_count, aVar.H);
        this.mShowTickMarksType = typedArrayObtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_show_tick_marks_type, aVar.I);
        this.mTickMarksSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_tick_marks_size, aVar.K);
        initTickMarksColor(typedArrayObtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_tick_marks_color), aVar.J);
        this.mTickMarksDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.IndicatorSeekBar_isb_tick_marks_drawable);
        this.mTickMarksSweptHide = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.N);
        this.mTickMarksEndsHide = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.M);
        this.mShowTickText = typedArrayObtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_show_tick_texts, aVar.B);
        this.mTickTextsSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_tick_texts_size, aVar.D);
        initTickTextsColor(typedArrayObtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_tick_texts_color), aVar.C);
        this.mTickTextsCustomArray = typedArrayObtainStyledAttributes.getTextArray(R.styleable.IndicatorSeekBar_isb_tick_texts_array);
        initTextsTypeface(typedArrayObtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.F);
        this.mShowIndicatorType = typedArrayObtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_show_indicator, aVar.k);
        this.mIndicatorColor = typedArrayObtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_indicator_color, aVar.l);
        this.mIndicatorTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_indicator_text_size, aVar.n);
        this.mIndicatorTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_indicator_text_color, aVar.m);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.mIndicatorContentView = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.mIndicatorTopContentView = View.inflate(this.mContext, resourceId2, null);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initDefaultPadding() {
        if (this.mClearPadding) {
            return;
        }
        int iA = j.a(this.mContext, 16.0f);
        if (getPaddingLeft() == 0) {
            setPadding(iA, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (getPaddingRight() == 0) {
            setPadding(getPaddingLeft(), getPaddingTop(), iA, getPaddingBottom());
        }
    }

    private void initIndicatorContentView() {
        int i = this.mShowIndicatorType;
        if (i != 0 && this.mIndicator == null) {
            this.mIndicator = new d(this.mContext, this, this.mIndicatorColor, i, this.mIndicatorTextSize, this.mIndicatorTextColor, this.mIndicatorContentView, this.mIndicatorTopContentView);
            this.mIndicatorContentView = this.mIndicator.a();
        }
    }

    private void initParams() {
        initProgressRangeValue();
        int i = this.mBackgroundTrackSize;
        int i2 = this.mProgressTrackSize;
        if (i > i2) {
            this.mBackgroundTrackSize = i2;
        }
        if (this.mThumbDrawable == null) {
            this.mThumbRadius = this.mThumbSize / 2.0f;
            this.mThumbTouchRadius = this.mThumbRadius * 1.2f;
        } else {
            this.mThumbRadius = Math.min(j.a(this.mContext, 30.0f), this.mThumbSize) / 2.0f;
            this.mThumbTouchRadius = this.mThumbRadius;
        }
        if (this.mTickMarksDrawable == null) {
            this.mTickRadius = this.mTickMarksSize / 2.0f;
        } else {
            this.mTickRadius = Math.min(j.a(this.mContext, 30.0f), this.mTickMarksSize) / 2.0f;
        }
        this.mCustomDrawableMaxHeight = Math.max(this.mThumbTouchRadius, this.mTickRadius) * 2.0f;
        initStrokePaint();
        measureTickTextsBonds();
        this.lastProgress = this.mProgress;
        collectTicksInfo();
        this.mProgressTrack = new RectF();
        this.mBackgroundTrack = new RectF();
        initDefaultPadding();
        initIndicatorContentView();
    }

    private void initProgressRangeValue() {
        float f2 = this.mMax;
        float f3 = this.mMin;
        if (f2 < f3) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.mProgress < f3) {
            this.mProgress = f3;
        }
        float f4 = this.mProgress;
        float f5 = this.mMax;
        if (f4 > f5) {
            this.mProgress = f5;
        }
    }

    private void initSeekBarInfo() {
        this.mMeasuredWidth = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.mPaddingLeft = getPaddingLeft();
            this.mPaddingRight = getPaddingRight();
        } else {
            this.mPaddingLeft = getPaddingStart();
            this.mPaddingRight = getPaddingEnd();
        }
        this.mPaddingTop = getPaddingTop();
        this.mSeekLength = (this.mMeasuredWidth - this.mPaddingLeft) - this.mPaddingRight;
        this.mSeekBlockLength = this.mSeekLength / (this.mTicksCount + (-1) > 0 ? r1 - 1 : 1);
    }

    private void initStrokePaint() {
        if (this.mStockPaint == null) {
            this.mStockPaint = new Paint();
        }
        if (this.mTrackRoundedCorners) {
            this.mStockPaint.setStrokeCap(Paint.Cap.ROUND);
        }
        this.mStockPaint.setAntiAlias(true);
        int i = this.mBackgroundTrackSize;
        if (i > this.mProgressTrackSize) {
            this.mProgressTrackSize = i;
        }
    }

    private void initTextPaint() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.mTickTextsSize);
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
    }

    private void initTextsArray() {
        int i = this.mTicksCount;
        if (i == 0) {
            return;
        }
        if (this.mShowTickText) {
            this.mTickTextsArr = new String[i];
        }
        for (int i2 = 0; i2 < this.mTickMarksX.length; i2++) {
            if (this.mShowTickText) {
                this.mTickTextsArr[i2] = getTickTextByPosition(i2);
                TextPaint textPaint = this.mTextPaint;
                String[] strArr = this.mTickTextsArr;
                textPaint.getTextBounds(strArr[i2], 0, strArr[i2].length(), this.mRect);
                this.mTickTextsWidth[i2] = this.mRect.width();
                this.mTextCenterX[i2] = this.mPaddingLeft + (this.mSeekBlockLength * i2);
            }
            this.mTickMarksX[i2] = this.mPaddingLeft + (this.mSeekBlockLength * i2);
        }
    }

    private void initTextsTypeface(int i, Typeface typeface) {
        if (i == 0) {
            this.mTextsTypeface = Typeface.DEFAULT;
            return;
        }
        if (i == 1) {
            this.mTextsTypeface = Typeface.MONOSPACE;
            return;
        }
        if (i == 2) {
            this.mTextsTypeface = Typeface.SANS_SERIF;
            return;
        }
        if (i == 3) {
            this.mTextsTypeface = Typeface.SERIF;
        } else if (typeface == null) {
            this.mTextsTypeface = Typeface.DEFAULT;
        } else {
            this.mTextsTypeface = typeface;
        }
    }

    private void initThumbBitmap() {
        Drawable drawable = this.mThumbDrawable;
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof StateListDrawable)) {
            this.mThumbBitmap = getDrawBitmap(drawable, true);
            this.mPressedThumbBitmap = this.mThumbBitmap;
            return;
        }
        try {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            Class<?> cls = stateListDrawable.getClass();
            int iIntValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
            if (iIntValue != 2) {
                throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
            }
            Method method = cls.getMethod("getStateSet", Integer.TYPE);
            Method method2 = cls.getMethod("getStateDrawable", Integer.TYPE);
            for (int i = 0; i < iIntValue; i++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                if (iArr.length <= 0) {
                    this.mThumbBitmap = getDrawBitmap((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                } else {
                    if (iArr[0] != 16842919) {
                        throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                    }
                    this.mPressedThumbBitmap = getDrawBitmap((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                }
            }
        } catch (Exception unused) {
            this.mThumbBitmap = getDrawBitmap(this.mThumbDrawable, true);
            this.mPressedThumbBitmap = this.mThumbBitmap;
        }
    }

    private void initThumbColor(ColorStateList colorStateList, int i) {
        if (colorStateList == null) {
            this.mThumbColor = i;
            this.mPressedThumbColor = this.mThumbColor;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                this.mThumbColor = iArr2[0];
                this.mPressedThumbColor = this.mThumbColor;
                return;
            }
            if (iArr.length != 2) {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
            }
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int[] iArr3 = iArr[i2];
                if (iArr3.length == 0) {
                    this.mPressedThumbColor = iArr2[i2];
                } else {
                    if (iArr3[0] != 16842919) {
                        throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                    }
                    this.mThumbColor = iArr2[i2];
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void initTickMarksBitmap() {
        Drawable drawable = this.mTickMarksDrawable;
        if (!(drawable instanceof StateListDrawable)) {
            this.mUnselectTickMarksBitmap = getDrawBitmap(drawable, false);
            this.mSelectTickMarksBitmap = this.mUnselectTickMarksBitmap;
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        try {
            Class<?> cls = stateListDrawable.getClass();
            int iIntValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
            if (iIntValue != 2) {
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            }
            Method method = cls.getMethod("getStateSet", Integer.TYPE);
            Method method2 = cls.getMethod("getStateDrawable", Integer.TYPE);
            for (int i = 0; i < iIntValue; i++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                if (iArr.length <= 0) {
                    this.mUnselectTickMarksBitmap = getDrawBitmap((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                } else {
                    if (iArr[0] != 16842913) {
                        throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                    }
                    this.mSelectTickMarksBitmap = getDrawBitmap((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                }
            }
        } catch (Exception unused) {
            this.mUnselectTickMarksBitmap = getDrawBitmap(this.mTickMarksDrawable, false);
            this.mSelectTickMarksBitmap = this.mUnselectTickMarksBitmap;
        }
    }

    private void initTickMarksColor(ColorStateList colorStateList, int i) {
        if (colorStateList == null) {
            this.mSelectedTickMarksColor = i;
            this.mUnSelectedTickMarksColor = this.mSelectedTickMarksColor;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                this.mSelectedTickMarksColor = iArr2[0];
                this.mUnSelectedTickMarksColor = this.mSelectedTickMarksColor;
                return;
            }
            if (iArr.length != 2) {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
            }
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int[] iArr3 = iArr[i2];
                if (iArr3.length == 0) {
                    this.mUnSelectedTickMarksColor = iArr2[i2];
                } else {
                    if (iArr3[0] != 16842913) {
                        throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                    }
                    this.mSelectedTickMarksColor = iArr2[i2];
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException("Something wrong happened when parsing thumb selector color." + e2.getMessage());
        }
    }

    private void initTickTextsColor(ColorStateList colorStateList, int i) {
        if (colorStateList == null) {
            this.mUnselectedTextsColor = i;
            int i2 = this.mUnselectedTextsColor;
            this.mSelectedTextsColor = i2;
            this.mHoveredTextColor = i2;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                this.mUnselectedTextsColor = iArr2[0];
                int i3 = this.mUnselectedTextsColor;
                this.mSelectedTextsColor = i3;
                this.mHoveredTextColor = i3;
                return;
            }
            if (iArr.length != 3) {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
            }
            for (int i4 = 0; i4 < iArr.length; i4++) {
                int[] iArr3 = iArr[i4];
                if (iArr3.length == 0) {
                    this.mUnselectedTextsColor = iArr2[i4];
                } else {
                    int i5 = iArr3[0];
                    if (i5 == 16842913) {
                        this.mSelectedTextsColor = iArr2[i4];
                    } else {
                        if (i5 != 16843623) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                        }
                        this.mHoveredTextColor = iArr2[i4];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void initTrackLocation() {
        if (!this.mR2L) {
            RectF rectF = this.mProgressTrack;
            rectF.left = this.mPaddingLeft;
            rectF.top = this.mPaddingTop + this.mThumbTouchRadius;
            rectF.right = (((this.mProgress - this.mMin) * this.mSeekLength) / getAmplitude()) + this.mPaddingLeft;
            RectF rectF2 = this.mProgressTrack;
            rectF2.bottom = rectF2.top;
            RectF rectF3 = this.mBackgroundTrack;
            rectF3.left = rectF2.right;
            float f2 = rectF2.bottom;
            rectF3.top = f2;
            rectF3.right = this.mMeasuredWidth - this.mPaddingRight;
            rectF3.bottom = f2;
            return;
        }
        RectF rectF4 = this.mBackgroundTrack;
        int i = this.mPaddingLeft;
        rectF4.left = i;
        rectF4.top = this.mPaddingTop + this.mThumbTouchRadius;
        rectF4.right = i + (this.mSeekLength * (1.0f - ((this.mProgress - this.mMin) / getAmplitude())));
        RectF rectF5 = this.mBackgroundTrack;
        float f3 = rectF5.top;
        rectF5.bottom = f3;
        RectF rectF6 = this.mProgressTrack;
        rectF6.left = rectF5.right;
        rectF6.top = f3;
        rectF6.right = this.mMeasuredWidth - this.mPaddingRight;
        rectF6.bottom = rectF5.bottom;
    }

    private boolean isTouchSeekBar(float f2, float f3) {
        if (this.mFaultTolerance == -1.0f) {
            this.mFaultTolerance = j.a(this.mContext, 5.0f);
        }
        float f4 = this.mPaddingLeft;
        float f5 = this.mFaultTolerance;
        boolean z = f2 >= f4 - (f5 * 2.0f) && f2 <= ((float) (this.mMeasuredWidth - this.mPaddingRight)) + (f5 * 2.0f);
        float f6 = this.mProgressTrack.top;
        float f7 = this.mThumbTouchRadius;
        float f8 = this.mFaultTolerance;
        return z && ((f3 > ((f6 - f7) - f8) ? 1 : (f3 == ((f6 - f7) - f8) ? 0 : -1)) >= 0 && (f3 > ((f6 + f7) + f8) ? 1 : (f3 == ((f6 + f7) + f8) ? 0 : -1)) <= 0);
    }

    private boolean isTouchThumb(float f2) {
        refreshThumbCenterXByProgress(this.mProgress);
        float f3 = this.mR2L ? this.mBackgroundTrack.right : this.mProgressTrack.right;
        int i = this.mThumbSize;
        return f3 - (((float) i) / 2.0f) <= f2 && f2 <= f3 + (((float) i) / 2.0f);
    }

    private void measureTickTextsBonds() {
        if (needDrawText()) {
            initTextPaint();
            this.mTextPaint.setTypeface(this.mTextsTypeface);
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.mTickTextsHeight = this.mRect.height() + j.a(this.mContext, 3.0f);
        }
    }

    private boolean needDrawText() {
        return this.mShowThumbText || (this.mTicksCount != 0 && this.mShowTickText);
    }

    private boolean progressChange() {
        return this.mIsFloatProgress ? this.lastProgress != this.mProgress : Math.round(this.lastProgress) != Math.round(this.mProgress);
    }

    private void refreshSeekBar(MotionEvent motionEvent) {
        refreshThumbCenterXByProgress(calculateProgress(calculateTouchX(adjustTouchX(motionEvent))));
        setSeekListener(true);
        invalidate();
        updateIndicator();
    }

    private void refreshSeekBarLocation() {
        initTrackLocation();
        if (needDrawText()) {
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.mTickTextY = this.mPaddingTop + this.mCustomDrawableMaxHeight + Math.round(this.mRect.height() - this.mTextPaint.descent()) + j.a(this.mContext, 3.0f);
            this.mThumbTextY = this.mTickTextY;
        }
        if (this.mTickMarksX == null) {
            return;
        }
        initTextsArray();
        if (this.mTicksCount > 2) {
            this.mProgress = this.mProgressArr[getClosestIndex()];
            this.lastProgress = this.mProgress;
        }
        refreshThumbCenterXByProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshThumbCenterXByProgress(float f2) {
        if (this.mR2L) {
            this.mBackgroundTrack.right = this.mPaddingLeft + (this.mSeekLength * (1.0f - ((f2 - this.mMin) / getAmplitude())));
            this.mProgressTrack.left = this.mBackgroundTrack.right;
            return;
        }
        this.mProgressTrack.right = (((f2 - this.mMin) * this.mSeekLength) / getAmplitude()) + this.mPaddingLeft;
        this.mBackgroundTrack.left = this.mProgressTrack.right;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.mSeekChangeListener != null && progressChange()) {
            this.mSeekChangeListener.a(collectParams(z));
        }
    }

    private void updateIndicator() {
        if (this.mIndicatorStayAlways) {
            updateStayIndicator();
            return;
        }
        d dVar = this.mIndicator;
        if (dVar == null) {
            return;
        }
        dVar.c();
        if (this.mIndicator.d()) {
            this.mIndicator.b(getThumbCenterX());
        } else {
            this.mIndicator.a(getThumbCenterX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStayIndicator() {
        d dVar;
        int i;
        if (!this.mIndicatorStayAlways || (dVar = this.mIndicator) == null) {
            return;
        }
        dVar.a(getIndicatorTextString());
        int thumbCenterX = 0;
        this.mIndicatorContentView.measure(0, 0);
        int measuredWidth = this.mIndicatorContentView.getMeasuredWidth();
        float thumbCenterX2 = getThumbCenterX();
        if (this.mScreenWidth == -1.0f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                this.mScreenWidth = displayMetrics.widthPixels;
            }
        }
        float f2 = measuredWidth / 2;
        float f3 = f2 + thumbCenterX2;
        int i2 = this.mMeasuredWidth;
        if (f3 > i2) {
            thumbCenterX = i2 - measuredWidth;
            i = (int) ((thumbCenterX2 - thumbCenterX) - f2);
        } else if (thumbCenterX2 - f2 < WheelView.DividerConfig.FILL) {
            i = -((int) (f2 - thumbCenterX2));
        } else {
            thumbCenterX = (int) (getThumbCenterX() - f2);
            i = 0;
        }
        this.mIndicator.b(thumbCenterX);
        this.mIndicator.a(i);
    }

    public static a with(Context context) {
        return new a(context);
    }

    public void customSectionTrackColor(b bVar) {
        int i = this.mTicksCount;
        int[] iArr = new int[i + (-1) > 0 ? i - 1 : 1];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = this.mBackgroundTrackColor;
        }
        this.mCustomTrackSectionColorResult = bVar.a(iArr);
        this.mSectionTrackColorArray = iArr;
        invalidate();
    }

    public void customTickTexts(String[] strArr) {
        this.mTickTextsCustomArray = strArr;
        if (this.mTickTextsArr != null) {
            int i = 0;
            while (i < this.mTickTextsArr.length) {
                String strValueOf = i < strArr.length ? String.valueOf(strArr[i]) : "";
                int i2 = this.mR2L ? (this.mTicksCount - 1) - i : i;
                this.mTickTextsArr[i2] = strValueOf;
                TextPaint textPaint = this.mTextPaint;
                if (textPaint != null && this.mRect != null) {
                    textPaint.getTextBounds(strValueOf, 0, strValueOf.length(), this.mRect);
                    this.mTickTextsWidth[i2] = this.mRect.width();
                }
                i++;
            }
            invalidate();
        }
    }

    public void customTickTextsTypeface(Typeface typeface) {
        this.mTextsTypeface = typeface;
        measureTickTextsBonds();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public d getIndicator() {
        return this.mIndicator;
    }

    View getIndicatorContentView() {
        return this.mIndicatorContentView;
    }

    String getIndicatorTextString() {
        String[] strArr;
        String str = this.mIndicatorTextFormat;
        if (str == null || !str.contains(FORMAT_TICK_TEXT)) {
            String str2 = this.mIndicatorTextFormat;
            if (str2 != null && str2.contains(FORMAT_PROGRESS)) {
                return this.mIndicatorTextFormat.replace(FORMAT_PROGRESS, getProgressString(this.mProgress));
            }
        } else if (this.mTicksCount > 2 && (strArr = this.mTickTextsArr) != null) {
            return this.mIndicatorTextFormat.replace(FORMAT_TICK_TEXT, strArr[getThumbPosOnTick()]);
        }
        return getProgressString(this.mProgress);
    }

    public float getMax() {
        return this.mMax;
    }

    public float getMin() {
        return this.mMin;
    }

    public h getOnSeekChangeListener() {
        return this.mSeekChangeListener;
    }

    public int getProgress() {
        return Math.round(this.mProgress);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.mProgress).setScale(this.mScale, 4).floatValue();
    }

    public int getTickCount() {
        return this.mTicksCount;
    }

    public void hideThumb(boolean z) {
        this.mHideThumb = z;
        invalidate();
    }

    public void hideThumbText(boolean z) {
        this.mShowThumbText = !z;
        invalidate();
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        drawTrack(canvas);
        drawTickMarks(canvas);
        drawTickTexts(canvas);
        drawThumb(canvas);
        drawThumbText(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.resolveSize(j.a(this.mContext, 170.0f), i), Math.round(this.mCustomDrawableMaxHeight + getPaddingTop() + getPaddingBottom()) + this.mTickTextsHeight);
        initSeekBarInfo();
        refreshSeekBarLocation();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        setProgress(bundle.getFloat("isb_progress"));
        super.onRestoreInstanceState(bundle.getParcelable("isb_instance_state"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("isb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.mProgress);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new e(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.mUserSeekable
            r1 = 0
            if (r0 == 0) goto L68
            boolean r0 = r4.isEnabled()
            if (r0 != 0) goto Lc
            goto L68
        Lc:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L20
            r2 = 2
            if (r0 == r2) goto L1c
            r2 = 3
            if (r0 == r2) goto L20
            goto L63
        L1c:
            r4.refreshSeekBar(r5)
            goto L63
        L20:
            r4.mIsTouching = r1
            com.warkiz.widget.h r0 = r4.mSeekChangeListener
            if (r0 == 0) goto L29
            r0.b(r4)
        L29:
            boolean r0 = r4.autoAdjustThumb()
            if (r0 != 0) goto L32
            r4.invalidate()
        L32:
            com.warkiz.widget.d r0 = r4.mIndicator
            if (r0 == 0) goto L63
            r0.b()
            goto L63
        L3a:
            r4.performClick()
            float r0 = r5.getX()
            float r3 = r5.getY()
            boolean r3 = r4.isTouchSeekBar(r0, r3)
            if (r3 == 0) goto L63
            boolean r3 = r4.mOnlyThumbDraggable
            if (r3 == 0) goto L56
            boolean r0 = r4.isTouchThumb(r0)
            if (r0 != 0) goto L56
            return r1
        L56:
            r4.mIsTouching = r2
            com.warkiz.widget.h r0 = r4.mSeekChangeListener
            if (r0 == 0) goto L5f
            r0.a(r4)
        L5f:
            r4.refreshSeekBar(r5)
            return r2
        L63:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.widget.IndicatorSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setDecimalScale(int i) {
        this.mScale = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z == isEnabled()) {
            return;
        }
        super.setEnabled(z);
        if (isEnabled()) {
            setAlpha(1.0f);
            if (this.mIndicatorStayAlways) {
                this.mIndicatorContentView.setAlpha(1.0f);
                return;
            }
            return;
        }
        setAlpha(0.3f);
        if (this.mIndicatorStayAlways) {
            this.mIndicatorContentView.setAlpha(0.3f);
        }
    }

    void setIndicatorStayAlways(boolean z) {
        this.mIndicatorStayAlways = z;
    }

    public void setIndicatorTextFormat(String str) {
        this.mIndicatorTextFormat = str;
        initTextsArray();
        updateStayIndicator();
    }

    public synchronized void setMax(float f2) {
        this.mMax = Math.max(this.mMin, f2);
        initProgressRangeValue();
        collectTicksInfo();
        refreshSeekBarLocation();
        invalidate();
        updateStayIndicator();
    }

    public synchronized void setMin(float f2) {
        this.mMin = Math.min(this.mMax, f2);
        initProgressRangeValue();
        collectTicksInfo();
        refreshSeekBarLocation();
        invalidate();
        updateStayIndicator();
    }

    public void setOnSeekChangeListener(h hVar) {
        this.mSeekChangeListener = hVar;
    }

    public synchronized void setProgress(float f2) {
        this.lastProgress = this.mProgress;
        if (f2 < this.mMin) {
            f2 = this.mMin;
        } else if (f2 > this.mMax) {
            f2 = this.mMax;
        }
        this.mProgress = f2;
        if (!this.mSeekSmoothly && this.mTicksCount > 2) {
            this.mProgress = this.mProgressArr[getClosestIndex()];
        }
        setSeekListener(false);
        refreshThumbCenterXByProgress(this.mProgress);
        postInvalidate();
        updateStayIndicator();
    }

    public void setR2L(boolean z) {
        this.mR2L = z;
        requestLayout();
        invalidate();
        updateStayIndicator();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.mAdjustAuto = z;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mThumbDrawable = null;
            this.mThumbBitmap = null;
            this.mPressedThumbBitmap = null;
        } else {
            this.mThumbDrawable = drawable;
            this.mThumbRadius = Math.min(j.a(this.mContext, 30.0f), this.mThumbSize) / 2.0f;
            this.mThumbTouchRadius = this.mThumbRadius;
            this.mCustomDrawableMaxHeight = Math.max(this.mThumbTouchRadius, this.mTickRadius) * 2.0f;
            initThumbBitmap();
        }
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i) {
        if (this.mTicksCount < 0 || this.mTicksCount > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.mTicksCount);
        }
        this.mTicksCount = i;
        collectTicksInfo();
        initTextsArray();
        initSeekBarInfo();
        refreshSeekBarLocation();
        invalidate();
        updateStayIndicator();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mTickMarksDrawable = null;
            this.mUnselectTickMarksBitmap = null;
            this.mSelectTickMarksBitmap = null;
        } else {
            this.mTickMarksDrawable = drawable;
            this.mTickRadius = Math.min(j.a(this.mContext, 30.0f), this.mTickMarksSize) / 2.0f;
            this.mCustomDrawableMaxHeight = Math.max(this.mThumbTouchRadius, this.mTickRadius) * 2.0f;
            initTickMarksBitmap();
        }
        invalidate();
    }

    public void setUserSeekAble(boolean z) {
        this.mUserSeekable = z;
    }

    public void showBothEndsTickTextsOnly(boolean z) {
        this.mShowBothTickTextsOnly = z;
    }

    void showStayIndicator() {
        this.mIndicatorContentView.setVisibility(4);
        postDelayed(new g(this), 300L);
    }

    public void thumbColor(int i) {
        this.mThumbColor = i;
        this.mPressedThumbColor = i;
        invalidate();
    }

    public void thumbColorStateList(ColorStateList colorStateList) {
        initThumbColor(colorStateList, this.mThumbColor);
        invalidate();
    }

    public void tickMarksColor(int i) {
        this.mSelectedTickMarksColor = i;
        this.mUnSelectedTickMarksColor = i;
        invalidate();
    }

    public void tickTextsColor(int i) {
        this.mUnselectedTextsColor = i;
        this.mSelectedTextsColor = i;
        this.mHoveredTextColor = i;
        invalidate();
    }

    public void tickTextsColorStateList(ColorStateList colorStateList) {
        initTickTextsColor(colorStateList, this.mSelectedTextsColor);
        invalidate();
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFaultTolerance = -1.0f;
        this.mScreenWidth = -1.0f;
        this.mScale = 1;
        this.mContext = context;
        initAttrs(this.mContext, attributeSet);
        initParams();
    }

    public void tickMarksColor(ColorStateList colorStateList) {
        initTickMarksColor(colorStateList, this.mSelectedTickMarksColor);
        invalidate();
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFaultTolerance = -1.0f;
        this.mScreenWidth = -1.0f;
        this.mScale = 1;
        this.mContext = context;
        initAttrs(this.mContext, attributeSet);
        initParams();
    }

    IndicatorSeekBar(a aVar) {
        super(aVar.f21373a);
        this.mFaultTolerance = -1.0f;
        this.mScreenWidth = -1.0f;
        this.mScale = 1;
        this.mContext = aVar.f21373a;
        int iA = j.a(this.mContext, 16.0f);
        setPadding(iA, getPaddingTop(), iA, getPaddingBottom());
        apply(aVar);
        initParams();
    }
}
