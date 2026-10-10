package com.sandboxol.common.binding.adapter;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.RoundedCornersTransform;
import com.sandboxol.common.utils.SizeUtil;

/* JADX INFO: loaded from: classes3.dex */
public class ImageViewBindingAdapters {
    public static void assetsImage(ImageView imageView, String str) {
        if (imageView.getContext() == null) {
            return;
        }
        try {
            imageView.setImageBitmap(BitmapFactory.decodeStream(imageView.getContext().getAssets().open(str)));
        } catch (Exception unused) {
        }
    }

    public static void imageAnim(ImageView imageView, boolean z, String str) {
        if (!str.equals("round") || imageView.getContext() == null) {
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        imageView.setAnimation(rotateAnimation);
        if (z) {
            rotateAnimation.start();
        } else {
            rotateAnimation.cancel();
        }
    }

    public static void isEnable(ImageView imageView, boolean z) {
        imageView.setEnabled(z);
    }

    public static void isStartAnim(ImageView imageView, boolean z) {
        if (z) {
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
            if (animationDrawable.isRunning()) {
                return;
            }
            animationDrawable.start();
        }
    }

    public static void isStartAnimByXml(ImageView imageView, int i) {
        if (imageView.getContext() == null) {
            return;
        }
        if (i == 1) {
            imageView.clearAnimation();
        } else if (i != 0) {
            imageView.startAnimation(AnimationUtils.loadAnimation(imageView.getContext(), i));
        }
    }

    public static void isStartRoundAnim(ImageView imageView, boolean z) {
        if (z) {
            RotateAnimation rotateAnimation = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(5000L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            imageView.startAnimation(rotateAnimation);
        }
    }

    private static boolean isValidContextForGlide(View view) {
        if (view.getContext() == null) {
            return false;
        }
        if (!(view.getContext() instanceof Activity)) {
            return true;
        }
        Activity activityByView = CommonHelper.getActivityByView(view);
        return (Build.VERSION.SDK_INT < 17 || !activityByView.isDestroyed()) && !activityByView.isFinishing();
    }

    public static void loadImage(final ImageView imageView, int i, String str, int i2, final int i3, boolean z, boolean z2, boolean z3, boolean z4, float f2, final ReplyCommand<Drawable> replyCommand) {
        if (i3 == 0 && i2 != 0) {
            i3 = i2;
        }
        if (com.bumptech.glide.e.n.d() && isValidContextForGlide(imageView)) {
            try {
                com.bumptech.glide.k kVarC = com.bumptech.glide.c.c(imageView.getContext());
                com.bumptech.glide.i<Drawable> iVarMo53load = i > 0 ? kVarC.mo53load(Integer.valueOf(i)) : kVarC.mo55load(str);
                if (i2 != 0) {
                    ((com.bumptech.glide.i) iVarMo53load.placeholder(i2)).fallback(i2);
                }
                com.bumptech.glide.request.f fVar = new com.bumptech.glide.request.f();
                if (f2 > WheelView.DividerConfig.FILL) {
                    RoundedCornersTransform roundedCornersTransform = new RoundedCornersTransform(imageView.getContext(), SizeUtil.dp2px(imageView.getContext(), f2));
                    roundedCornersTransform.setNeedCorner(z, z2, z3, z4);
                    fVar = (com.bumptech.glide.request.f) fVar.transform(roundedCornersTransform);
                }
                fVar.diskCacheStrategy(com.bumptech.glide.load.engine.p.f4585e);
                iVarMo53load.apply((com.bumptech.glide.request.a<?>) fVar).listener(new com.bumptech.glide.request.e<Drawable>() { // from class: com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.1
                    @Override // com.bumptech.glide.request.e
                    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z5) {
                        int i4 = i3;
                        if (i4 == 0) {
                            return true;
                        }
                        imageView.setImageResource(i4);
                        return true;
                    }

                    @Override // com.bumptech.glide.request.e
                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z5) {
                        ReplyCommand replyCommand2 = replyCommand;
                        if (replyCommand2 == null) {
                            return false;
                        }
                        replyCommand2.execute(drawable);
                        return false;
                    }
                });
                Activity activityByView = CommonHelper.getActivityByView(imageView);
                if (activityByView == null || !activityByView.isFinishing()) {
                    iVarMo53load.into(imageView);
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setDrawable(ImageView imageView, Drawable drawable) {
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawable);
        }
    }

    public static void setGif(ImageView imageView, int i, String str, int i2, int i3) {
        if (imageView.getContext() != null) {
            if (i != 0) {
                com.bumptech.glide.request.f fVar = new com.bumptech.glide.request.f();
                fVar.diskCacheStrategy(com.bumptech.glide.load.engine.p.f4584d);
                try {
                    com.bumptech.glide.c.c(BaseApplication.getContext()).asGif().apply((com.bumptech.glide.request.a<?>) fVar).mo44load(Integer.valueOf(i)).into(imageView);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.bumptech.glide.request.f fVar2 = new com.bumptech.glide.request.f();
            fVar2.diskCacheStrategy(com.bumptech.glide.load.engine.p.f4584d).error(i3).placeholder(i2);
            try {
                com.bumptech.glide.c.c(BaseApplication.getContext()).asGif().mo46load(str).apply((com.bumptech.glide.request.a<?>) fVar2).into(imageView);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
        }
    }
}
