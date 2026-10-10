package io.rong.imkit.mention;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public class SideBar extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f22800b = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private int choose;
    private TextView mTextDialog;
    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    private Paint paint;

    public interface OnTouchingLetterChangedListener {
        void onTouchingLetterChanged(String str);
    }

    public SideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.choose = -1;
        this.paint = new Paint();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.choose;
        OnTouchingLetterChangedListener onTouchingLetterChangedListener = this.onTouchingLetterChangedListener;
        int height = (int) ((y / getHeight()) * f22800b.length);
        if (action == 1) {
            setBackgroundDrawable(new ColorDrawable(0));
            this.choose = -1;
            invalidate();
            TextView textView = this.mTextDialog;
            if (textView != null) {
                textView.setVisibility(4);
            }
        } else {
            setBackgroundResource(R.drawable.rc_bg_sidebar);
            if (i != height && height >= 0) {
                String[] strArr = f22800b;
                if (height < strArr.length) {
                    if (onTouchingLetterChangedListener != null) {
                        onTouchingLetterChangedListener.onTouchingLetterChanged(strArr[height]);
                    }
                    TextView textView2 = this.mTextDialog;
                    if (textView2 != null) {
                        textView2.setText(f22800b[height]);
                        this.mTextDialog.setVisibility(0);
                    }
                    this.choose = height;
                    invalidate();
                }
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int length = height / f22800b.length;
        for (int i = 0; i < f22800b.length; i++) {
            this.paint.setColor(-7829368);
            this.paint.setTypeface(Typeface.DEFAULT);
            this.paint.setAntiAlias(true);
            this.paint.setTextSize(30.0f);
            if (i == this.choose) {
                this.paint.setColor(Color.parseColor("#FFFFFF"));
                this.paint.setFakeBoldText(true);
            }
            canvas.drawText(f22800b[i], (width / 2.0f) - (this.paint.measureText(f22800b[i]) / 2.0f), (length * i * 1.0f) + length, this.paint);
            this.paint.reset();
        }
    }

    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public void setTextView(TextView textView) {
        this.mTextDialog = textView;
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.choose = -1;
        this.paint = new Paint();
    }

    public SideBar(Context context) {
        super(context);
        this.choose = -1;
        this.paint = new Paint();
    }
}
