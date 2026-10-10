package io.rong.imkit.widget;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class LinkTextViewMovementMethod extends LinkMovementMethod {
    private long mLastActionDownTime;
    private ILinkClickListener mListener;

    public LinkTextViewMovementMethod(ILinkClickListener iLinkClickListener) {
        this.mListener = iLinkClickListener;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1 && action != 0) {
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = x - textView.getTotalPaddingLeft();
        int totalPaddingTop = y - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpanArr.length == 0) {
            Touch.onTouchEvent(textView, spannable, motionEvent);
            return false;
        }
        if (action != 1) {
            this.mLastActionDownTime = System.currentTimeMillis();
        } else {
            if (System.currentTimeMillis() - this.mLastActionDownTime > ViewConfiguration.getLongPressTimeout()) {
                return true;
            }
            String url = clickableSpanArr[0] instanceof URLSpan ? ((URLSpan) clickableSpanArr[0]).getURL() : null;
            ILinkClickListener iLinkClickListener = this.mListener;
            if (iLinkClickListener != null && iLinkClickListener.onLinkClick(url)) {
                return true;
            }
            clickableSpanArr[0].onClick(textView);
        }
        return true;
    }
}
