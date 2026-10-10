package com.sandboxol.gamedetail.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.c;
import com.sandboxol.center.router.manager.WidgetManager;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.greendao.entity.BannerEntity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GameDetailBannerBindAdapters {

    public static class GlideImageLoader extends ImageLoader {
        @Override // com.youth.banner.loader.ImageLoaderInterface
        public void displayImage(Context context, Object obj, ImageView imageView) {
            try {
                if (Helper.isValidContextForGlide(imageView)) {
                    c.c(context).mo54load(obj).into(imageView);
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Banner banner, int i, int i2) {
        banner.setBannerStyle(i);
        if (i2 != 0) {
            banner.setIndicatorGravity(i2);
        }
    }

    public static void b(Banner banner, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        banner.setBannerTitles(list);
    }

    public static void c(Banner banner, List<?> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        banner.setImages(list).setImageLoader(new GlideImageLoader()).start();
    }

    public static void a(Banner banner, List<BannerEntity> list) {
        WidgetManager.bannerEntities(banner, list);
    }
}
