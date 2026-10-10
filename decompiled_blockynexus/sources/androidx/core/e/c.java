package androidx.core.e;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PrecomputedTextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1124a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Executor f1125b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Spannable f1126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f1127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PrecomputedText f1128e;

    /* JADX INFO: compiled from: PrecomputedTextCompat.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextPaint f1129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f1130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f1132d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f1133e;

        /* JADX INFO: renamed from: androidx.core.e.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PrecomputedTextCompat.java */
        public static class C0011a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final TextPaint f1134a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f1135b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f1136c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f1137d;

            public C0011a(TextPaint textPaint) {
                this.f1134a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f1136c = 1;
                    this.f1137d = 1;
                } else {
                    this.f1137d = 0;
                    this.f1136c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f1135b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f1135b = null;
                }
            }

            public C0011a a(int i) {
                this.f1136c = i;
                return this;
            }

            public C0011a b(int i) {
                this.f1137d = i;
                return this;
            }

            public C0011a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f1135b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f1134a, this.f1135b, this.f1136c, this.f1137d);
            }
        }

        @SuppressLint({"NewApi"})
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f1133e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f1133e = null;
            }
            this.f1129a = textPaint;
            this.f1130b = textDirectionHeuristic;
            this.f1131c = i;
            this.f1132d = i2;
        }

        public int a() {
            return this.f1131c;
        }

        public int b() {
            return this.f1132d;
        }

        public TextDirectionHeuristic c() {
            return this.f1130b;
        }

        public TextPaint d() {
            return this.f1129a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar)) {
                return Build.VERSION.SDK_INT < 18 || this.f1130b == aVar.c();
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            return i >= 24 ? androidx.core.f.c.a(Float.valueOf(this.f1129a.getTextSize()), Float.valueOf(this.f1129a.getTextScaleX()), Float.valueOf(this.f1129a.getTextSkewX()), Float.valueOf(this.f1129a.getLetterSpacing()), Integer.valueOf(this.f1129a.getFlags()), this.f1129a.getTextLocales(), this.f1129a.getTypeface(), Boolean.valueOf(this.f1129a.isElegantTextHeight()), this.f1130b, Integer.valueOf(this.f1131c), Integer.valueOf(this.f1132d)) : i >= 21 ? androidx.core.f.c.a(Float.valueOf(this.f1129a.getTextSize()), Float.valueOf(this.f1129a.getTextScaleX()), Float.valueOf(this.f1129a.getTextSkewX()), Float.valueOf(this.f1129a.getLetterSpacing()), Integer.valueOf(this.f1129a.getFlags()), this.f1129a.getTextLocale(), this.f1129a.getTypeface(), Boolean.valueOf(this.f1129a.isElegantTextHeight()), this.f1130b, Integer.valueOf(this.f1131c), Integer.valueOf(this.f1132d)) : i >= 18 ? androidx.core.f.c.a(Float.valueOf(this.f1129a.getTextSize()), Float.valueOf(this.f1129a.getTextScaleX()), Float.valueOf(this.f1129a.getTextSkewX()), Integer.valueOf(this.f1129a.getFlags()), this.f1129a.getTextLocale(), this.f1129a.getTypeface(), this.f1130b, Integer.valueOf(this.f1131c), Integer.valueOf(this.f1132d)) : i >= 17 ? androidx.core.f.c.a(Float.valueOf(this.f1129a.getTextSize()), Float.valueOf(this.f1129a.getTextScaleX()), Float.valueOf(this.f1129a.getTextSkewX()), Integer.valueOf(this.f1129a.getFlags()), this.f1129a.getTextLocale(), this.f1129a.getTypeface(), this.f1130b, Integer.valueOf(this.f1131c), Integer.valueOf(this.f1132d)) : androidx.core.f.c.a(Float.valueOf(this.f1129a.getTextSize()), Float.valueOf(this.f1129a.getTextScaleX()), Float.valueOf(this.f1129a.getTextSkewX()), Integer.valueOf(this.f1129a.getFlags()), this.f1129a.getTypeface(), this.f1130b, Integer.valueOf(this.f1131c), Integer.valueOf(this.f1132d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1129a.getTextSize());
            sb.append(", textScaleX=" + this.f1129a.getTextScaleX());
            sb.append(", textSkewX=" + this.f1129a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f1129a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1129a.isElegantTextHeight());
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                sb.append(", textLocale=" + this.f1129a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f1129a.getTextLocale());
            }
            sb.append(", typeface=" + this.f1129a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f1129a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1130b);
            sb.append(", breakStrategy=" + this.f1131c);
            sb.append(", hyphenationFrequency=" + this.f1132d);
            sb.append("}");
            return sb.toString();
        }

        public boolean a(a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f1131c != aVar.a() || this.f1132d != aVar.b())) || this.f1129a.getTextSize() != aVar.d().getTextSize() || this.f1129a.getTextScaleX() != aVar.d().getTextScaleX() || this.f1129a.getTextSkewX() != aVar.d().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f1129a.getLetterSpacing() != aVar.d().getLetterSpacing() || !TextUtils.equals(this.f1129a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) || this.f1129a.getFlags() != aVar.d().getFlags()) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                if (!this.f1129a.getTextLocales().equals(aVar.d().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f1129a.getTextLocale().equals(aVar.d().getTextLocale())) {
                return false;
            }
            return this.f1129a.getTypeface() == null ? aVar.d().getTypeface() == null : this.f1129a.getTypeface().equals(aVar.d().getTypeface());
        }

        public a(PrecomputedText.Params params) {
            this.f1129a = params.getTextPaint();
            this.f1130b = params.getTextDirection();
            this.f1131c = params.getBreakStrategy();
            this.f1132d = params.getHyphenationFrequency();
            this.f1133e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }

    public a a() {
        return this.f1127d;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f1126c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f1126c.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1126c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1126c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1126c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f1128e.getSpans(i, i2, cls) : (T[]) this.f1126c.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1126c.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f1126c.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1128e.removeSpan(obj);
        } else {
            this.f1126c.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1128e.setSpan(obj, i, i2, i3);
        } else {
            this.f1126c.setSpan(obj, i, i2, i3);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f1126c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f1126c.toString();
    }
}
