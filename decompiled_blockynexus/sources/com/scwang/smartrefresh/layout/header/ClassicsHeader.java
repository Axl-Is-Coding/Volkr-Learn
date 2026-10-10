package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cn.qqtheme.framework.widget.WheelView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.i;
import com.scwang.smartrefresh.layout.a.j;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements g {
    protected String KEY_LAST_UPDATE_TIME;
    protected boolean mEnableLastTime;
    protected Date mLastTime;
    protected DateFormat mLastUpdateFormat;
    protected TextView mLastUpdateText;
    protected SharedPreferences mShared;
    protected String mTextFailed;
    protected String mTextFinish;
    protected String mTextLoading;
    protected String mTextPulling;
    protected String mTextRefreshing;
    protected String mTextRelease;
    protected String mTextSecondary;
    protected String mTextUpdate;
    public static final int ID_TEXT_UPDATE = R.id.srl_classics_update;
    public static String REFRESH_HEADER_PULLING = null;
    public static String REFRESH_HEADER_REFRESHING = null;
    public static String REFRESH_HEADER_LOADING = null;
    public static String REFRESH_HEADER_RELEASE = null;
    public static String REFRESH_HEADER_FINISH = null;
    public static String REFRESH_HEADER_FAILED = null;
    public static String REFRESH_HEADER_UPDATE = null;
    public static String REFRESH_HEADER_SECONDARY = null;

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public int onFinish(j jVar, boolean z) {
        if (z) {
            this.mTitleText.setText(this.mTextFinish);
            if (this.mLastTime != null) {
                setLastUpdateTime(new Date());
            }
        } else {
            this.mTitleText.setText(this.mTextFailed);
        }
        return super.onFinish(jVar, z);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.f
    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.mArrowView;
        TextView textView = this.mLastUpdateText;
        switch (b.f19168a[refreshState2.ordinal()]) {
            case 1:
                textView.setVisibility(this.mEnableLastTime ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.mTitleText.setText(this.mTextRefreshing);
                imageView.setVisibility(8);
                return;
            case 5:
                this.mTitleText.setText(this.mTextRelease);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.mTitleText.setText(this.mTextSecondary);
                imageView.animate().rotation(WheelView.DividerConfig.FILL);
                return;
            case 7:
                imageView.setVisibility(8);
                textView.setVisibility(this.mEnableLastTime ? 4 : 8);
                this.mTitleText.setText(this.mTextLoading);
                return;
            default:
                return;
        }
        this.mTitleText.setText(this.mTextPulling);
        imageView.setVisibility(0);
        imageView.animate().rotation(WheelView.DividerConfig.FILL);
    }

    public ClassicsHeader setEnableLastTime(boolean z) {
        TextView textView = this.mLastUpdateText;
        this.mEnableLastTime = z;
        textView.setVisibility(z ? 0 : 8);
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.a(this);
        }
        return this;
    }

    public ClassicsHeader setLastUpdateText(CharSequence charSequence) {
        this.mLastTime = null;
        this.mLastUpdateText.setText(charSequence);
        return this;
    }

    public ClassicsHeader setLastUpdateTime(Date date) {
        this.mLastTime = date;
        this.mLastUpdateText.setText(this.mLastUpdateFormat.format(date));
        if (this.mShared != null && !isInEditMode()) {
            this.mShared.edit().putLong(this.KEY_LAST_UPDATE_TIME, date.getTime()).apply();
        }
        return this;
    }

    public ClassicsHeader setTextSizeTime(float f2) {
        this.mLastUpdateText.setTextSize(f2);
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.a(this);
        }
        return this;
    }

    public ClassicsHeader setTextTimeMarginTop(float f2) {
        TextView textView = this.mLastUpdateText;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = com.scwang.smartrefresh.layout.c.c.a(f2);
        textView.setLayoutParams(marginLayoutParams);
        return this;
    }

    public ClassicsHeader setTimeFormat(DateFormat dateFormat) {
        this.mLastUpdateFormat = dateFormat;
        Date date = this.mLastTime;
        if (date != null) {
            this.mLastUpdateText.setText(this.mLastUpdateFormat.format(date));
        }
        return this;
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        AbstractC0336n supportFragmentManager;
        List<Fragment> listE;
        super(context, attributeSet, 0);
        this.KEY_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
        this.mEnableLastTime = true;
        View.inflate(context, R.layout.srl_classics_header, this);
        ImageView imageView = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.mArrowView = imageView;
        TextView textView = (TextView) findViewById(R.id.srl_classics_update);
        this.mLastUpdateText = textView;
        ImageView imageView2 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.mProgressView = imageView2;
        this.mTitleText = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, com.scwang.smartrefresh.layout.c.c.a(WheelView.DividerConfig.FILL));
        layoutParams2.rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, com.scwang.smartrefresh.layout.c.c.a(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.height);
        this.mFinishDuration = typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.mFinishDuration);
        this.mEnableLastTime = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.mEnableLastTime);
        this.mSpinnerStyle = com.scwang.smartrefresh.layout.constant.b.f19154f[typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.mSpinnerStyle.g)];
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableArrow)) {
            this.mArrowView.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableArrow));
        } else if (this.mArrowView.getDrawable() == null) {
            this.mArrowDrawable = new com.scwang.smartrefresh.layout.internal.a();
            this.mArrowDrawable.a(-10066330);
            this.mArrowView.setImageDrawable(this.mArrowDrawable);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableProgress)) {
            this.mProgressView.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableProgress));
        } else if (this.mProgressView.getDrawable() == null) {
            this.mProgressDrawable = new com.scwang.smartrefresh.layout.internal.c();
            this.mProgressDrawable.a(-10066330);
            this.mProgressView.setImageDrawable(this.mProgressDrawable);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.mTitleText.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTitle, com.scwang.smartrefresh.layout.c.c.a(16.0f)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.mLastUpdateText.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTime, com.scwang.smartrefresh.layout.c.c.a(12.0f)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlPrimaryColor)) {
            super.setPrimaryColor(typedArrayObtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlPrimaryColor, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlAccentColor)) {
            setAccentColor(typedArrayObtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlAccentColor, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextPulling)) {
            this.mTextPulling = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextPulling);
        } else {
            String str = REFRESH_HEADER_PULLING;
            if (str != null) {
                this.mTextPulling = str;
            } else {
                this.mTextPulling = context.getString(R.string.srl_header_pulling);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextLoading)) {
            this.mTextLoading = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextLoading);
        } else {
            String str2 = REFRESH_HEADER_LOADING;
            if (str2 != null) {
                this.mTextLoading = str2;
            } else {
                this.mTextLoading = context.getString(R.string.srl_header_loading);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRelease)) {
            this.mTextRelease = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRelease);
        } else {
            String str3 = REFRESH_HEADER_RELEASE;
            if (str3 != null) {
                this.mTextRelease = str3;
            } else {
                this.mTextRelease = context.getString(R.string.srl_header_release);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFinish)) {
            this.mTextFinish = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFinish);
        } else {
            String str4 = REFRESH_HEADER_FINISH;
            if (str4 != null) {
                this.mTextFinish = str4;
            } else {
                this.mTextFinish = context.getString(R.string.srl_header_finish);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFailed)) {
            this.mTextFailed = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFailed);
        } else {
            String str5 = REFRESH_HEADER_FAILED;
            if (str5 != null) {
                this.mTextFailed = str5;
            } else {
                this.mTextFailed = context.getString(R.string.srl_header_failed);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSecondary)) {
            this.mTextSecondary = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextSecondary);
        } else {
            String str6 = REFRESH_HEADER_SECONDARY;
            if (str6 != null) {
                this.mTextSecondary = str6;
            } else {
                this.mTextSecondary = context.getString(R.string.srl_header_secondary);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRefreshing)) {
            this.mTextRefreshing = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRefreshing);
        } else {
            String str7 = REFRESH_HEADER_REFRESHING;
            if (str7 != null) {
                this.mTextRefreshing = str7;
            } else {
                this.mTextRefreshing = context.getString(R.string.srl_header_refreshing);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextUpdate)) {
            this.mTextUpdate = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextUpdate);
        } else {
            String str8 = REFRESH_HEADER_UPDATE;
            if (str8 != null) {
                this.mTextUpdate = str8;
            } else {
                this.mTextUpdate = context.getString(R.string.srl_header_update);
            }
        }
        this.mLastUpdateFormat = new SimpleDateFormat(this.mTextUpdate, Locale.getDefault());
        typedArrayObtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        textView.setVisibility(this.mEnableLastTime ? 0 : 8);
        this.mTitleText.setText(isInEditMode() ? this.mTextRefreshing : this.mTextPulling);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (listE = supportFragmentManager.e()) != null && listE.size() > 0) {
                setLastUpdateTime(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.KEY_LAST_UPDATE_TIME += context.getClass().getName();
        this.mShared = context.getSharedPreferences("ClassicsHeader", 0);
        setLastUpdateTime(new Date(this.mShared.getLong(this.KEY_LAST_UPDATE_TIME, System.currentTimeMillis())));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics
    public ClassicsHeader setAccentColor(int i) {
        this.mLastUpdateText.setTextColor((16777215 & i) | (-872415232));
        return (ClassicsHeader) super.setAccentColor(i);
    }
}
