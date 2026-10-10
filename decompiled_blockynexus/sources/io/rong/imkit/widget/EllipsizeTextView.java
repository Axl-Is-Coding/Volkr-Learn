package io.rong.imkit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.RLog;
import io.rong.imkit.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class EllipsizeTextView extends TextView {
    private static final String DEFAULT_ELLIPSIZE_TEXT = "...";
    private static final String TAG = "EllipsizeTextView";
    private int mEllipsizeIndex;
    private CharSequence mEllipsizeText;
    private boolean mEnableUpdateOriginText;
    private boolean mIsExactlyMode;
    private int mMaxLines;
    private CharSequence mOriginText;

    public static final class Range<T extends Comparable<? super T>> {
        private final T mLower;
        private final T mUpper;

        public Range(T t, T t2) {
            this.mLower = t;
            this.mUpper = t2;
            if (t.compareTo(t2) > 0) {
                throw new IllegalArgumentException("lower must be less than or equal to upper");
            }
        }

        public boolean contains(T t) {
            return (t.compareTo(this.mLower) >= 0) && (t.compareTo(this.mUpper) < 0);
        }

        public T getLower() {
            return this.mLower;
        }

        public T getUpper() {
            return this.mUpper;
        }
    }

    public EllipsizeTextView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String adaptiveText(TextView textView) {
        boolean z;
        String string = textView.getText().toString();
        TextPaint paint = textView.getPaint();
        float width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        String[] strArrSplit = string.replaceAll("\r", "").split(UMCustomLogInfoBuilder.LINE_SEP);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z2 = true;
        for (String str : strArrSplit) {
            if (paint.measureText(str) <= width) {
                sb.append(str);
            } else {
                int i2 = i;
                boolean z3 = z2;
                int i3 = 0;
                float fMeasureText = WheelView.DividerConfig.FILL;
                while (i3 != str.length()) {
                    char cCharAt = str.charAt(i3);
                    fMeasureText += paint.measureText(String.valueOf(cCharAt));
                    if (z3 && fMeasureText > width) {
                        return string;
                    }
                    if (fMeasureText <= width) {
                        sb.append(cCharAt);
                        z3 = false;
                    } else {
                        if (i2 < getMaxLines() - 1) {
                            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                            i2++;
                            z = true;
                        } else {
                            z = z3;
                        }
                        i3--;
                        z3 = z;
                        fMeasureText = WheelView.DividerConfig.FILL;
                    }
                    i3++;
                }
                z2 = z3;
                i = i2;
            }
        }
        return sb.toString();
    }

    private void adjustEllipsizeEndText(Layout layout) {
        CharSequence charSequence = this.mOriginText;
        CharSequence charSequenceSubSequence = charSequence.subSequence(charSequence.length() - this.mEllipsizeIndex, charSequence.length());
        int width = (layout.getWidth() - getPaddingLeft()) - getPaddingRight();
        int iMax = Math.max(1, computeMaxLineCount(layout)) - 1;
        int lineWidth = (int) layout.getLineWidth(iMax);
        int lineEnd = layout.getLineEnd(iMax);
        int desiredWidth = ((int) (Layout.getDesiredWidth(this.mEllipsizeText, getPaint()) + Layout.getDesiredWidth(charSequenceSubSequence, getPaint()))) + 1;
        this.mEnableUpdateOriginText = false;
        int i = lineWidth + desiredWidth;
        if (i > width) {
            setText(charSequence.subSequence(0, lineEnd - computeRemovedEllipsizeEndCharacterCount(i - width, charSequence.subSequence(0, lineEnd))));
            append(this.mEllipsizeText);
            append(charSequenceSubSequence);
        } else {
            setText(charSequence.subSequence(0, lineEnd));
            append(this.mEllipsizeText);
            append(charSequenceSubSequence);
        }
        this.mEnableUpdateOriginText = true;
    }

    private Range<Integer> computeCharacterStyleRange(List<Range<Integer>> list, int i) {
        if (list != null && !list.isEmpty()) {
            for (Range<Integer> range : list) {
                if (range.contains(Integer.valueOf(i))) {
                    return range;
                }
            }
        }
        return null;
    }

    private List<Range<Integer>> computeCharacterStyleRanges(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(charSequence);
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) spannableStringBuilderValueOf.getSpans(0, spannableStringBuilderValueOf.length(), CharacterStyle.class);
        if (characterStyleArr == null || characterStyleArr.length == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (CharacterStyle characterStyle : characterStyleArr) {
            arrayList.add(new Range(Integer.valueOf(spannableStringBuilderValueOf.getSpanStart(characterStyle)), Integer.valueOf(spannableStringBuilderValueOf.getSpanEnd(characterStyle))));
        }
        return arrayList;
    }

    private int computeMaxLineCount(Layout layout) {
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i = 0; i < layout.getLineCount(); i++) {
            if (measuredHeight < layout.getLineBottom(i)) {
                return i;
            }
        }
        return layout.getLineCount();
    }

    private int computeRemovedEllipsizeEndCharacterCount(int i, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        List<Range<Integer>> listComputeCharacterStyleRanges = computeCharacterStyleRanges(charSequence);
        String string = charSequence.toString();
        charSequence.length();
        int iCodePointCount = string.codePointCount(0, charSequence.length());
        int desiredWidth = 0;
        while (iCodePointCount > 0 && i > desiredWidth) {
            iCodePointCount--;
            int iOffsetByCodePoints = string.offsetByCodePoints(0, iCodePointCount);
            Range<Integer> rangeComputeCharacterStyleRange = computeCharacterStyleRange(listComputeCharacterStyleRanges, iOffsetByCodePoints);
            if (rangeComputeCharacterStyleRange != null) {
                iOffsetByCodePoints = ((Integer) rangeComputeCharacterStyleRange.getLower()).intValue();
                iCodePointCount = string.codePointCount(0, iOffsetByCodePoints);
            }
            desiredWidth = (int) Layout.getDesiredWidth(charSequence.subSequence(iOffsetByCodePoints, charSequence.length()), getPaint());
        }
        return charSequence.length() - string.offsetByCodePoints(0, iCodePointCount);
    }

    private boolean isExceedMaxLine(Layout layout) {
        int lineCount = layout.getLineCount();
        int i = this.mMaxLines;
        return lineCount > i && i > 0;
    }

    private boolean isOutOfBounds(Layout layout) {
        return layout.getHeight() > (getMeasuredHeight() - getPaddingBottom()) - getPaddingTop();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        try {
            this.mIsExactlyMode = View.MeasureSpec.getMode(i) == 1073741824;
            Layout layout = getLayout();
            if (layout != null) {
                if (isExceedMaxLine(layout) || isOutOfBounds(layout)) {
                    adjustEllipsizeEndText(layout);
                }
            }
        } catch (Exception e2) {
            RLog.d(TAG, "onMeasure:" + e2);
        }
    }

    public void setAdaptiveText(final String str) {
        post(new Runnable() { // from class: io.rong.imkit.widget.EllipsizeTextView.1
            @Override // java.lang.Runnable
            public void run() {
                EllipsizeTextView.this.setText(str);
                EllipsizeTextView ellipsizeTextView = EllipsizeTextView.this;
                ellipsizeTextView.setText(ellipsizeTextView.adaptiveText(ellipsizeTextView));
            }
        });
    }

    public void setEllipsizeText(CharSequence charSequence, int i) {
        this.mEllipsizeText = charSequence;
        this.mEllipsizeIndex = i;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (this.mMaxLines != i) {
            super.setMaxLines(i);
            this.mMaxLines = i;
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.mEnableUpdateOriginText) {
            this.mOriginText = charSequence;
        }
        super.setText(charSequence, bufferType);
        if (this.mIsExactlyMode) {
            requestLayout();
        }
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnableUpdateOriginText = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EllipsizeTextView);
        this.mEllipsizeIndex = typedArrayObtainStyledAttributes.getInt(R.styleable.EllipsizeTextView_RCEllipsizeIndex, 0);
        this.mEllipsizeText = typedArrayObtainStyledAttributes.getText(R.styleable.EllipsizeTextView_RCEllipsizeText);
        if (this.mEllipsizeText == null) {
            this.mEllipsizeText = "...";
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
