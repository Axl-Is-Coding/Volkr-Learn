package com.twitter.sdk.android.tweetui.internal;

import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: SpanClickHandler.java */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f20418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Layout f20419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f20420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f20421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HighlightedClickableSpan f20422e;

    public k(View view, Layout layout) {
        this.f20418a = view;
        this.f20419b = layout;
    }

    public static void a(TextView textView) {
        final k kVar = new k(textView, null);
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.twitter.sdk.android.tweetui.internal.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return k.a(this.f20407a, view, motionEvent);
            }
        });
    }

    private void b() {
        View view = this.f20418a;
        float f2 = this.f20420c;
        view.invalidate((int) f2, (int) this.f20421d, ((int) f2) + this.f20419b.getWidth(), ((int) this.f20421d) + this.f20419b.getHeight());
    }

    static /* synthetic */ boolean a(k kVar, View view, MotionEvent motionEvent) {
        Layout layout = ((TextView) view).getLayout();
        if (layout == null) {
            return false;
        }
        kVar.f20419b = layout;
        kVar.f20420c = r3.getTotalPaddingLeft() + r3.getScrollX();
        kVar.f20421d = r3.getTotalPaddingTop() + r3.getScrollY();
        return kVar.a(motionEvent);
    }

    public boolean a(MotionEvent motionEvent) {
        HighlightedClickableSpan highlightedClickableSpan;
        CharSequence text = this.f20419b.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) (motionEvent.getX() - this.f20420c);
        int y = (int) (motionEvent.getY() - this.f20421d);
        if (x >= 0 && x < this.f20419b.getWidth() && y >= 0 && y < this.f20419b.getHeight()) {
            int lineForVertical = this.f20419b.getLineForVertical(y);
            float f2 = x;
            if (f2 < this.f20419b.getLineLeft(lineForVertical) || f2 > this.f20419b.getLineRight(lineForVertical)) {
                a();
                return false;
            }
            if (action == 0) {
                int offsetForHorizontal = this.f20419b.getOffsetForHorizontal(lineForVertical, f2);
                HighlightedClickableSpan[] highlightedClickableSpanArr = (HighlightedClickableSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, HighlightedClickableSpan.class);
                if (highlightedClickableSpanArr.length > 0) {
                    a(highlightedClickableSpanArr[0]);
                    return true;
                }
            } else if (action == 1 && (highlightedClickableSpan = this.f20422e) != null) {
                highlightedClickableSpan.onClick(this.f20418a);
                a();
                return true;
            }
            return false;
        }
        a();
        return false;
    }

    private void a(HighlightedClickableSpan highlightedClickableSpan) {
        highlightedClickableSpan.a(true);
        this.f20422e = highlightedClickableSpan;
        b();
    }

    private void a() {
        HighlightedClickableSpan highlightedClickableSpan = this.f20422e;
        if (highlightedClickableSpan == null || !highlightedClickableSpan.a()) {
            return;
        }
        highlightedClickableSpan.a(false);
        this.f20422e = null;
        b();
    }
}
