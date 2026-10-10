package com.sandbox.login.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import com.bumptech.glide.load.engine.p;
import com.sandbox.login.R;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.SizeUtil;

/* JADX INFO: compiled from: ResHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static Drawable a(boolean z) {
        return z ? BaseApplication.getContext().getResources().getDrawable(R.mipmap.login_ic_select_up) : BaseApplication.getContext().getResources().getDrawable(R.mipmap.login_ic_select_down);
    }

    public static void a(Context context, String str, ObservableField<Drawable> observableField) {
        if (str != null && !"".equals(str)) {
            try {
                com.bumptech.glide.request.f fVar = new com.bumptech.glide.request.f();
                fVar.diskCacheStrategy(p.f4585e);
                com.bumptech.glide.c.c(BaseApplication.getContext()).asBitmap().mo46load(str).apply((com.bumptech.glide.request.a<?>) fVar).override((int) SizeUtil.dp2px(context, 32.0f), (int) SizeUtil.dp2px(context, 32.0f)).into(new g(observableField, context));
                return;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return;
            }
        }
        observableField.set(BaseApplication.getContext().getResources().getDrawable(R.mipmap.login_ic_head_default));
    }
}
