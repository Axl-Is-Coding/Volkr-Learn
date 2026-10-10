package com.sandboxol.halloween.c;

import android.graphics.drawable.Drawable;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.halloween.R;

/* JADX INFO: compiled from: TextToPicUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static Drawable a(int i) {
        switch (i) {
            case 1:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_1);
            case 2:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_2);
            case 3:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_3);
            case 4:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_4);
            case 5:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_5);
            case 6:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_6);
            case 7:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_7);
            case 8:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_8);
            case 9:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_9);
            case 10:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_10);
            case 11:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_11);
            case 12:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_12);
            case 13:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_13);
            case 14:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_14);
            case 15:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_15);
            case 16:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_16);
            case 17:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_17);
            case 18:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_18);
            case 19:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_19);
            case 20:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_20);
            case 21:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_21);
            case 22:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_22);
            case 23:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_23);
            case 24:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_24);
            default:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_0);
        }
    }

    public static Drawable b() {
        return CommonHelper.getLanguage().contains("zh") ? androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_title_tips_zh) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_title_tips);
    }

    public static Drawable a() {
        if (CommonHelper.getLanguage().contains("zh")) {
            return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_end_tips_zh);
        }
        return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.halloween_num_end_in_tips);
    }
}
