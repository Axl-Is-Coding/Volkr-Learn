package com.sandboxol.center.utils;

import android.graphics.drawable.Drawable;
import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapOutlineViewReturnHelper {
    public static final int LEVEL_1 = 1;
    public static final int LEVEL_2 = 2;
    public static final int LEVEL_3 = 3;
    public static final int LEVEL_4 = 4;
    public static final int LEVEL_5 = 5;
    public static final int NUM_1 = 1;
    public static final int NUM_2 = 2;
    public static final int NUM_3 = 3;
    public static final int NUM_4 = 4;
    public static final int NUM_5 = 5;
    public static final int NUM_6 = 6;

    public static int getInsideBgColor(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_level_bg_1) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_level_bg_5) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_level_bg_4) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_level_bg_3) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_level_bg_2);
    }

    public static int getInsideBgShadowColor(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_shadow_color_3) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_shadow_color_5) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_shadow_color_1) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_shadow_color_4) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_shadow_color_2);
    }

    public static Drawable getLevelIcon(int i) {
        switch (i) {
            case 1:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_num_1);
            case 2:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_num_2);
            case 3:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_num_3);
            case 4:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_num_4);
            case 5:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_num_5);
            case 6:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_num_6);
            default:
                return androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_default);
        }
    }

    public static Drawable getOutline(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_1) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_5) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_4) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_3) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_2) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_1);
    }

    public static Drawable getRewardOutline(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.base_scrap_details_outline_4) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.base_scrap_details_outline_5) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.base_scrap_details_outline_1) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.base_scrap_details_outline_2) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.base_scrap_details_outline_3);
    }

    public static Drawable getScrapBagBg(boolean z) {
        return z ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_bag_main_shape) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_bag_shape);
    }

    public static Drawable getScrapBagTitleBg(boolean z) {
        return z ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_bag_title_main_shape) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_bag_title_shape);
    }

    public static String getScrapBoxLevel(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "Ⅴ" : "Ⅳ" : "Ⅲ" : "Ⅱ" : "Ⅰ";
    }

    public static int getScrapBoxResId(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i > 4 ? R.mipmap.ic_box_4 : R.mipmap.ic_box_bg : R.mipmap.ic_box_4 : R.mipmap.ic_box_3 : R.mipmap.ic_box_2 : R.mipmap.ic_box_1;
    }

    public static Drawable getScrapLockIcon(boolean z) {
        return z ? androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_lock) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_scrap_lock_vip);
    }

    public static int getScrapTabColor(boolean z) {
        return z ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_bag_tab_bg_main) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_bag_tab_bg);
    }

    public static int getScrapTabIndicatorColor(boolean z) {
        return z ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_bag_tab_main_bg_unselected) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_bag_tab_bg_selected);
    }

    public static int getScrapTabSelectedTextColor(boolean z) {
        return z ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_bag_tab_main_bg_unselected) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_bag_tab_bg_selected);
    }

    public static int getScrapTabTextColor(boolean z) {
        return z ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_bag_tab_main_bg_unselected) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_scrap_bag_tab_bg_unselected);
    }

    public static int getTextColor(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? R.color.base_scrap_level_bg_1 : R.color.base_scrap_level_bg_5 : R.color.base_scrap_level_bg_4 : R.color.base_scrap_level_bg_3 : R.color.base_scrap_level_bg_2;
    }

    public static Drawable getType(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_1) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_5) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_4) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_3) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_2) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_scrap_level_1);
    }
}
