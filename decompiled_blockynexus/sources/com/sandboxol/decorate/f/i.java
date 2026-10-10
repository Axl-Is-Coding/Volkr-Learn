package com.sandboxol.decorate.f;

import android.graphics.drawable.Drawable;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressViewReturnResUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static Drawable a(int i) {
        try {
            if (i == 1) {
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_diamond_all);
            }
            if (i == 2) {
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_gold);
            }
            if (i == 3) {
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_tribe_golds);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable b(int i) {
        return i == 1 ? androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_diamond_all) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_gold);
    }
}
