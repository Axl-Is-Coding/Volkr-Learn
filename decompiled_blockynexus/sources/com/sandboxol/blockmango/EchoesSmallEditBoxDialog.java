package com.sandboxol.blockmango;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.umeng.analytics.pro.m;

/* JADX INFO: loaded from: classes2.dex */
public class EchoesSmallEditBoxDialog extends Dialog {
    private final int kEditBoxInputFlagInitialCapsAllCharacters;
    private final int kEditBoxInputFlagInitialCapsSentence;
    private final int kEditBoxInputFlagInitialCapsWord;
    private final int kEditBoxInputFlagPassword;
    private final int kEditBoxInputFlagSensitive;
    private final int kEditBoxInputModeAny;
    private final int kEditBoxInputModeDecimal;
    private final int kEditBoxInputModeEmailAddr;
    private final int kEditBoxInputModeNumeric;
    private final int kEditBoxInputModePhoneNumber;
    private final int kEditBoxInputModeSingleLine;
    private final int kEditBoxInputModeUrl;
    private final int kKeyboardReturnTypeDefault;
    private final int kKeyboardReturnTypeDone;
    private final int kKeyboardReturnTypeGo;
    private final int kKeyboardReturnTypeSearch;
    private final int kKeyboardReturnTypeSend;
    private EditText mInputEditText;
    private final int mInputFlag;
    private int mInputFlagConstraints;
    private final int mInputMode;
    private int mInputModeContraints;
    private boolean mIsMultiline;
    private final int mMaxLength;
    private final String mMessage;
    private final int mReturnType;
    private TextView mTextViewTitle;
    private final String mTitle;
    private int rootViewMaxHeight;
    private int rootViewVisibleHeight;

    public EchoesSmallEditBoxDialog(Context context, String str, String str2, int i, int i2, int i3, int i4) {
        super(context, R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        this.kEditBoxInputModeAny = 0;
        this.kEditBoxInputModeEmailAddr = 1;
        this.kEditBoxInputModeNumeric = 2;
        this.kEditBoxInputModePhoneNumber = 3;
        this.kEditBoxInputModeUrl = 4;
        this.kEditBoxInputModeDecimal = 5;
        this.kEditBoxInputModeSingleLine = 6;
        this.kEditBoxInputFlagPassword = 0;
        this.kEditBoxInputFlagSensitive = 1;
        this.kEditBoxInputFlagInitialCapsWord = 2;
        this.kEditBoxInputFlagInitialCapsSentence = 3;
        this.kEditBoxInputFlagInitialCapsAllCharacters = 4;
        this.kKeyboardReturnTypeDefault = 0;
        this.kKeyboardReturnTypeDone = 1;
        this.kKeyboardReturnTypeSend = 2;
        this.kKeyboardReturnTypeSearch = 3;
        this.kKeyboardReturnTypeGo = 4;
        this.mTitle = str;
        this.mMessage = str2;
        this.mInputMode = i;
        this.mInputFlag = i2;
        this.mReturnType = i3;
        this.mMaxLength = i4;
    }

    private void close(int i) {
        EchoesHelper.setEditTextDialogResult(this.mInputEditText.getText().toString(), i);
        closeKeyboard();
        dismiss();
    }

    private void closeKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mInputEditText.getWindowToken(), 0);
    }

    private int convertDipsToPixels(float f2) {
        return Math.round(f2 * getContext().getResources().getDisplayMetrics().density);
    }

    private void openKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.mInputEditText, 0);
    }

    public /* synthetic */ void a(View view, LinearLayout linearLayout) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        if (this.rootViewMaxHeight != rect.height()) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.blockmango.Ya
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f16145a.a(view2);
                }
            });
        }
    }

    public /* synthetic */ void b(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int iHeight = rect.height();
        if (this.rootViewMaxHeight < iHeight) {
            this.rootViewMaxHeight = iHeight;
        }
        int i = this.rootViewVisibleHeight;
        if (i == 0) {
            this.rootViewVisibleHeight = iHeight;
            return;
        }
        if (i == iHeight) {
            return;
        }
        if (i - iHeight > 200) {
            this.rootViewVisibleHeight = iHeight;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int iConvertDipsToPixels = convertDipsToPixels(10.0f);
            layoutParams.rightMargin = iConvertDipsToPixels;
            layoutParams.leftMargin = iConvertDipsToPixels;
            this.mInputEditText.setLayoutParams(layoutParams);
            this.mInputEditText.setAlpha(1.0f);
        }
        if (iHeight - this.rootViewVisibleHeight > 200) {
            this.rootViewVisibleHeight = iHeight;
            close(1);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mTextViewTitle = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int iConvertDipsToPixels = convertDipsToPixels(10.0f);
        layoutParams2.rightMargin = iConvertDipsToPixels;
        layoutParams2.leftMargin = iConvertDipsToPixels;
        this.mTextViewTitle.setTextSize(1, 20.0f);
        linearLayout.addView(this.mTextViewTitle, layoutParams2);
        this.mInputEditText = new EditText(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
        int iConvertDipsToPixels2 = convertDipsToPixels(10.0f);
        layoutParams3.rightMargin = iConvertDipsToPixels2;
        layoutParams3.leftMargin = iConvertDipsToPixels2;
        linearLayout.addView(this.mInputEditText, layoutParams3);
        setContentView(linearLayout, layoutParams);
        getWindow().addFlags(1024);
        final View decorView = getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sandboxol.blockmango._a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f16153a.b(decorView);
            }
        });
        this.mTextViewTitle.setText(this.mTitle);
        this.mInputEditText.setText(this.mMessage);
        this.mInputEditText.setAlpha(WheelView.DividerConfig.FILL);
        this.mInputEditText.addTextChangedListener(new TextWatcher() { // from class: com.sandboxol.blockmango.EchoesSmallEditBoxDialog.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                EchoesHelper.setEditTextDialogResult(EchoesSmallEditBoxDialog.this.mInputEditText.getText().toString(), 2);
            }
        });
        this.mInputEditText.setImeOptions(301989888);
        int imeOptions = this.mInputEditText.getImeOptions();
        switch (this.mInputMode) {
            case 0:
                this.mInputModeContraints = 131073;
                break;
            case 1:
                this.mInputModeContraints = 33;
                break;
            case 2:
                this.mInputModeContraints = m.a.f20900b;
                break;
            case 3:
                this.mInputModeContraints = 3;
                break;
            case 4:
                this.mInputModeContraints = 17;
                break;
            case 5:
                this.mInputModeContraints = 12290;
                break;
            case 6:
                this.mInputModeContraints = 1;
                break;
        }
        if (this.mIsMultiline) {
            this.mInputModeContraints |= 131072;
        }
        this.mInputEditText.setInputType(this.mInputModeContraints | this.mInputFlagConstraints);
        int i = this.mInputFlag;
        if (i == 0) {
            this.mInputFlagConstraints = 129;
        } else if (i == 1) {
            this.mInputFlagConstraints = 524288;
        } else if (i == 2) {
            this.mInputFlagConstraints = 8192;
        } else if (i == 3) {
            this.mInputFlagConstraints = 16384;
        } else if (i == 4) {
            this.mInputFlagConstraints = 4096;
        }
        this.mInputEditText.setInputType(this.mInputFlagConstraints | this.mInputModeContraints);
        int i2 = this.mReturnType;
        if (i2 == 0) {
            this.mInputEditText.setImeOptions(imeOptions | 1);
        } else if (i2 == 1) {
            this.mInputEditText.setImeOptions(imeOptions | 6);
        } else if (i2 == 2) {
            this.mInputEditText.setImeOptions(imeOptions | 4);
        } else if (i2 == 3) {
            this.mInputEditText.setImeOptions(imeOptions | 3);
        } else if (i2 != 4) {
            this.mInputEditText.setImeOptions(imeOptions | 1);
        } else {
            this.mInputEditText.setImeOptions(imeOptions | 2);
        }
        int i3 = this.mMaxLength;
        if (i3 > 0) {
            this.mInputEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        }
        new Handler().postDelayed(new Runnable() { // from class: com.sandboxol.blockmango.Za
            @Override // java.lang.Runnable
            public final void run() {
                this.f16150a.b(decorView, linearLayout);
            }
        }, 200L);
        this.mInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sandboxol.blockmango.Xa
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                return this.f16142a.a(textView, i4, keyEvent);
            }
        });
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getWindow() != null && EchoesGLSurfaceView.getInstance() != null) {
            View decorView = getWindow().getDecorView();
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            if (this.rootViewMaxHeight == rect.height()) {
                int action = motionEvent.getAction() & 255;
                if (action == 6 || action == 1 || action == 3) {
                    close(1);
                }
                EchoesGLSurfaceView.getInstance().onTouchEvent(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public /* synthetic */ void a(View view) {
        close(1);
    }

    public /* synthetic */ boolean a(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 0 && (keyEvent == null || keyEvent.getAction() != 0)) {
            return false;
        }
        close(0);
        return true;
    }

    public /* synthetic */ void b(final View view, final LinearLayout linearLayout) {
        this.mInputEditText.requestFocus();
        EditText editText = this.mInputEditText;
        editText.setSelection(editText.length());
        openKeyboard();
        view.postDelayed(new Runnable() { // from class: com.sandboxol.blockmango.ab
            @Override // java.lang.Runnable
            public final void run() {
                this.f16160a.a(view, linearLayout);
            }
        }, 1000L);
    }
}
