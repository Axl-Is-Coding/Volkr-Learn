package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: compiled from: AppCompatTextClassifierHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextClassifier f520b;

    D(TextView textView) {
        androidx.core.f.h.a(textView);
        this.f519a = textView;
    }

    public void a(TextClassifier textClassifier) {
        this.f520b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f520b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f519a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }
}
