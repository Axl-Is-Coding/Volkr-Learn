package com.disabngo.blockynexus.d;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: compiled from: ViewReturnTextUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class L {
    public static Drawable a(int i) {
        if (i == 1) {
            return BaseApplication.getContext().getResources().getDrawable(R.mipmap.ic_diamond_all);
        }
        if (i == 2) {
            return BaseApplication.getContext().getResources().getDrawable(R.mipmap.ic_gold);
        }
        if (i == 3) {
            return BaseApplication.getContext().getResources().getDrawable(R.mipmap.ic_tribe_golds);
        }
        return null;
    }

    public static String b(int i) {
        return BaseApplication.getContext().getString(i);
    }

    public static Drawable c(int i) {
        try {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_none) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_mvp_plus) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_mvp) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_vip_up) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_vip);
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable d(int i) {
        return i == 20 ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_user_info_chief) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_user_info_elder);
    }

    public static Drawable a(boolean z) {
        if (z) {
            return BaseApplication.getContext().getResources().getDrawable(R.mipmap.app_search_friend_add_finish_btn);
        }
        return BaseApplication.getContext().getResources().getDrawable(R.mipmap.app_search_friend_add_btn);
    }
}
