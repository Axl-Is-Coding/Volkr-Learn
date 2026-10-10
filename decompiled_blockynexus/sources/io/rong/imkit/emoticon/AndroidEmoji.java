package io.rong.imkit.emoticon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ReplacementSpan;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class AndroidEmoji {
    private static final int MAX_DISPLAY_EMOJI = 600;
    private static float density;
    private static Context mContext;
    private static List<EmojiInfo> sEmojiList;
    private static Map<Integer, EmojiInfo> sEmojiMap;

    public static class EmojiImageSpan extends ReplacementSpan {
        public static final int ALIGN_BOTTOM = 0;
        Drawable mDrawable;
        private WeakReference<Drawable> mDrawableRef;

        private Drawable getCachedDrawable() {
            WeakReference<Drawable> weakReference = this.mDrawableRef;
            Drawable drawable = weakReference != null ? weakReference.get() : null;
            if (drawable != null) {
                return drawable;
            }
            Drawable drawable2 = getDrawable();
            this.mDrawableRef = new WeakReference<>(drawable2);
            return drawable2;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
            Drawable cachedDrawable = getCachedDrawable();
            canvas.save();
            canvas.translate(f2, (int) ((i5 - cachedDrawable.getBounds().bottom) - AndroidEmoji.density));
            cachedDrawable.draw(canvas);
            canvas.restore();
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getCachedDrawable().getBounds();
            if (fontMetricsInt != null) {
                fontMetricsInt.ascent = -bounds.bottom;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = fontMetricsInt.ascent;
                fontMetricsInt.bottom = 0;
            }
            return bounds.right;
        }

        private EmojiImageSpan(int i) {
            this(i, WheelView.DividerConfig.FILL);
        }

        public EmojiImageSpan(int i, float f2) {
            EmojiInfo emojiInfo;
            if (AndroidEmoji.sEmojiMap == null || !AndroidEmoji.sEmojiMap.containsKey(Integer.valueOf(i)) || (emojiInfo = (EmojiInfo) AndroidEmoji.sEmojiMap.get(Integer.valueOf(i))) == null) {
                return;
            }
            this.mDrawable = AndroidEmoji.mContext.getResources().getDrawable(emojiInfo.resId);
            int i2 = f2 == WheelView.DividerConfig.FILL ? -((int) (AndroidEmoji.density * 4.0f)) : (int) (f2 - (AndroidEmoji.density * 21.0f));
            int intrinsicWidth = this.mDrawable.getIntrinsicWidth() + i2;
            int intrinsicHeight = this.mDrawable.getIntrinsicHeight() + i2;
            this.mDrawable.setBounds(0, 0, intrinsicWidth <= 0 ? 0 : intrinsicWidth, intrinsicHeight <= 0 ? 0 : intrinsicHeight);
        }
    }

    private static StringBuilder appendSpanStr(boolean z, StringBuilder sb, char[] cArr, int i) {
        if (sb == null) {
            return null;
        }
        if (z) {
            int i2 = i - 1;
            if (i2 >= 0) {
                sb.append(cArr[i2]);
                sb.append(cArr[i]);
            }
        } else if (i >= 0) {
            sb.append(cArr[i]);
        }
        return sb;
    }

    public static CharSequence ensure(String str) {
        boolean z;
        int codePoint;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isHighSurrogate(charArray[i])) {
                if (!Character.isLowSurrogate(charArray[i])) {
                    z = false;
                    codePoint = charArray[i];
                } else if (i > 0) {
                    int i2 = i - 1;
                    if (Character.isSurrogatePair(charArray[i2], charArray[i])) {
                        z = true;
                        codePoint = Character.toCodePoint(charArray[i2], charArray[i]);
                    }
                }
                if (sEmojiMap.containsKey(Integer.valueOf(codePoint))) {
                    spannableStringBuilder.setSpan(new EmojiImageSpan(codePoint), z ? i - 1 : i, i + 1, 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    public static int getEmojiCode(int i) {
        return sEmojiList.get(i).code;
    }

    public static int getEmojiCount(String str) {
        int codePoint;
        if (str == null) {
            return 0;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (!Character.isHighSurrogate(charArray[i2])) {
                if (!Character.isLowSurrogate(charArray[i2])) {
                    codePoint = charArray[i2];
                } else if (i2 > 0) {
                    int i3 = i2 - 1;
                    if (Character.isSurrogatePair(charArray[i3], charArray[i2])) {
                        codePoint = Character.toCodePoint(charArray[i3], charArray[i2]);
                    }
                }
                if (sEmojiMap.containsKey(Integer.valueOf(codePoint))) {
                    i++;
                }
            }
        }
        return i;
    }

    public static Drawable getEmojiDrawable(Context context, int i) {
        if (i < 0 || i >= sEmojiList.size()) {
            return null;
        }
        return context.getResources().getDrawable(sEmojiList.get(i).resId);
    }

    public static List<EmojiInfo> getEmojiList() {
        return sEmojiList;
    }

    public static int getEmojiSize() {
        return sEmojiMap.size();
    }

    private static String getReplaceEmojiText(char[] cArr, String str) {
        boolean z;
        int codePoint;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (!Character.isHighSurrogate(cArr[i2])) {
                if (!Character.isLowSurrogate(cArr[i2])) {
                    z = false;
                    codePoint = cArr[i2];
                } else if (i2 > 0) {
                    int i3 = i2 - 1;
                    if (Character.isSurrogatePair(cArr[i3], cArr[i2])) {
                        z = true;
                        codePoint = Character.toCodePoint(cArr[i3], cArr[i2]);
                    }
                }
                if (sEmojiMap.containsKey(Integer.valueOf(codePoint))) {
                    i++;
                    char[] charArray = str.toCharArray();
                    if (charArray == null || charArray.length <= 0) {
                        sb = appendSpanStr(z, sb, cArr, i2);
                    } else if (i > 600) {
                        sb.append("[");
                        EmojiInfo emojiInfo = sEmojiMap.get(Integer.valueOf(codePoint));
                        if (emojiInfo != null) {
                            sb.append(mContext.getResources().getString(emojiInfo.strId));
                        }
                        sb.append("]");
                    } else {
                        sb = appendSpanStr(z, sb, cArr, i2);
                    }
                } else {
                    sb = appendSpanStr(z, sb, cArr, i2);
                }
            }
        }
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public static void init(Context context) {
        sEmojiMap = new HashMap();
        sEmojiList = new ArrayList();
        mContext = context.getApplicationContext();
        int[] intArray = context.getResources().getIntArray(context.getResources().getIdentifier("rc_emoji_code", "array", context.getPackageName()));
        TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(context.getResources().getIdentifier("rc_emoji_res", "array", context.getPackageName()));
        TypedArray typedArrayObtainTypedArray2 = context.getResources().obtainTypedArray(context.getResources().getIdentifier("rc_emoji_description", "array", context.getPackageName()));
        if (intArray.length != typedArrayObtainTypedArray.length()) {
            throw new RuntimeException("Emoji resource init fail.");
        }
        int i = -1;
        while (true) {
            i++;
            if (i >= intArray.length) {
                density = context.getResources().getDisplayMetrics().density;
                typedArrayObtainTypedArray.recycle();
                return;
            } else {
                EmojiInfo emojiInfo = new EmojiInfo(intArray[i], typedArrayObtainTypedArray.getResourceId(i, -1), typedArrayObtainTypedArray2.getResourceId(i, -1));
                sEmojiMap.put(Integer.valueOf(intArray[i]), emojiInfo);
                sEmojiList.add(emojiInfo);
            }
        }
    }

    public static boolean isEmoji(String str) {
        int codePoint;
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (!Character.isHighSurrogate(charArray[i])) {
                if (!Character.isLowSurrogate(charArray[i])) {
                    codePoint = charArray[i];
                } else if (i > 0) {
                    int i2 = i - 1;
                    if (Character.isSurrogatePair(charArray[i2], charArray[i])) {
                        codePoint = Character.toCodePoint(charArray[i2], charArray[i]);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
                if (sEmojiMap.containsKey(Integer.valueOf(codePoint))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static SpannableStringBuilder replaceEmojiWithText(Spannable spannable) {
        if (spannable == null) {
            return null;
        }
        return new SpannableStringBuilder(getReplaceEmojiText(spannable.toString().toCharArray(), spannable.toString()));
    }

    private static class EmojiInfo {
        int code;
        int resId;
        int strId;

        public EmojiInfo(int i, int i2) {
            this.code = i;
            this.resId = i2;
        }

        public EmojiInfo(int i, int i2, int i3) {
            this.code = i;
            this.resId = i2;
            this.strId = i3;
        }
    }

    public static String replaceEmojiWithText(String str) {
        if (str == null) {
            return null;
        }
        return getReplaceEmojiText(str.toCharArray(), str);
    }

    public static void ensure(Spannable spannable, float f2) {
        boolean z;
        int codePoint;
        char[] charArray = spannable.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isHighSurrogate(charArray[i])) {
                if (!Character.isLowSurrogate(charArray[i])) {
                    z = false;
                    codePoint = charArray[i];
                } else if (i > 0) {
                    int i2 = i - 1;
                    if (Character.isSurrogatePair(charArray[i2], charArray[i])) {
                        z = true;
                        codePoint = Character.toCodePoint(charArray[i2], charArray[i]);
                    }
                }
                if (sEmojiMap.containsKey(Integer.valueOf(codePoint))) {
                    spannable.setSpan(new EmojiImageSpan(codePoint, f2), z ? i - 1 : i, i + 1, 34);
                }
            }
        }
    }

    public static void ensure(Spannable spannable) {
        ensure(spannable, WheelView.DividerConfig.FILL);
    }
}
