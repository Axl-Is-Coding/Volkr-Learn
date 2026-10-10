package com.disabngo.blockynexus.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.InputFilter;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.BlurUtil;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes2.dex */
public class EditTextDialog extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f11283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f11284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EditText f11285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f11286d;

    public interface a {
        void a(EditText editText);

        void a(String str);
    }

    public EditTextDialog(Context context) {
        super(context, R.style.FullScreenTheme);
        this.f11284b = context;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        requestWindowFeature(1);
        a(context);
        d();
        e();
    }

    private void d() {
        setContentView(R.layout.dialog_edittext);
        this.f11286d = (TextView) findViewById(R.id.tv_title);
        this.f11285c = (EditText) findViewById(R.id.et_msg);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_confirm).setOnClickListener(this);
        findViewById(R.id.v_bg).setOnClickListener(this);
    }

    private void e() {
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(48);
        }
    }

    protected int a() {
        return 8;
    }

    public EditTextDialog a(String str) {
        EditText editText = this.f11285c;
        if (editText != null) {
            editText.setText(str);
            EditText editText2 = this.f11285c;
            editText2.setSelection(editText2.getText().length());
        }
        return this;
    }

    protected float b() {
        return 8.0f;
    }

    public EditTextDialog b(String str) {
        EditText editText = this.f11285c;
        if (editText != null) {
            editText.setHint(str);
        }
        return this;
    }

    public EditTextDialog c(String str) {
        TextView textView = this.f11286d;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    protected boolean c() {
        return false;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Context context = this.f11284b;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancel) {
            a aVar = this.f11283a;
            if (aVar != null) {
                aVar.a(this.f11285c);
            }
            cancel();
            return;
        }
        if (id != R.id.btn_confirm) {
            if (id != R.id.v_bg) {
                return;
            }
            com.disabngo.blockynexus.d.A.a(this.f11284b, this.f11285c);
        } else {
            a aVar2 = this.f11283a;
            if (aVar2 != null) {
                aVar2.a(this.f11285c.getText().toString().trim());
            }
            cancel();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = this.f11284b;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        super.show();
    }

    public EditTextDialog a(int i) {
        EditText editText = this.f11285c;
        if (editText != null) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        }
        return this;
    }

    public EditTextDialog a(a aVar) {
        this.f11283a = aVar;
        return this;
    }

    private void a(Context context) {
        if (getWindow() == null) {
            return;
        }
        if (!c()) {
            getWindow().setBackgroundDrawableResource(R.color.dialog_shadow);
            return;
        }
        if (!(context instanceof Activity)) {
            getWindow().setBackgroundDrawableResource(R.color.dialog_shadow);
            return;
        }
        Bitmap bitmapBlur = BlurUtil.blur(context, CommonHelper.getViewBitmap(((Activity) context).getWindow().getDecorView()), b(), a());
        if (bitmapBlur != null) {
            Window window = getWindow();
            Resources resources = context.getResources();
            a(bitmapBlur);
            window.setBackgroundDrawable(new BitmapDrawable(resources, bitmapBlur));
            return;
        }
        getWindow().setBackgroundDrawableResource(R.color.dialog_shadow);
    }

    private Bitmap a(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setAlpha(65);
        canvas.drawRect(new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, bitmap.getWidth(), bitmap.getHeight()), paint);
        return bitmap;
    }
}
