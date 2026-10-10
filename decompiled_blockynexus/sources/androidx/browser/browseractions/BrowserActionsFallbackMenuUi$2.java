package androidx.browser.browseractions;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes.dex */
class BrowserActionsFallbackMenuUi$2 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextView f748a;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TextViewCompat.d(this.f748a) == Integer.MAX_VALUE) {
            this.f748a.setMaxLines(1);
            this.f748a.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            this.f748a.setMaxLines(Integer.MAX_VALUE);
            this.f748a.setEllipsize(null);
        }
    }
}
