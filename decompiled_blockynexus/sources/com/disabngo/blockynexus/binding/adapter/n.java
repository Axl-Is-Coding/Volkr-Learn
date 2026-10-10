package com.disabngo.blockynexus.binding.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableArrayList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.sandboxol.common.utils.SizeUtil;

/* JADX INFO: compiled from: RelativeLayoutBindingAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    public static void a(RelativeLayout relativeLayout, ObservableArrayList<FriendRequests> observableArrayList) {
        String picUrl;
        if (relativeLayout.getChildCount() > 0) {
            relativeLayout.removeAllViews();
        }
        int i = 0;
        for (int i2 = 0; i2 < observableArrayList.size(); i2++) {
            View viewInflate = LayoutInflater.from(relativeLayout.getContext()).inflate(R.layout.item_friend_apply_data_list, (ViewGroup) null, false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(relativeLayout.getContext(), 40.0f), (int) SizeUtil.dp2px(relativeLayout.getContext(), 40.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            if (i2 != 0) {
                int i3 = 15 + i;
                layoutParams.setMargins(0, 0, (int) SizeUtil.dp2px(relativeLayout.getContext(), i3), 0);
                i = i3;
            }
            viewInflate.setLayoutParams(layoutParams);
            try {
                picUrl = observableArrayList.get(i2).getPicUrl();
            } catch (Exception e2) {
                e2.printStackTrace();
                picUrl = "";
            }
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ivHead);
            try {
                com.bumptech.glide.k kVarC = com.bumptech.glide.c.c(relativeLayout.getContext());
                boolean zIsEmpty = TextUtils.isEmpty(picUrl);
                Object objValueOf = picUrl;
                if (zIsEmpty) {
                    objValueOf = Integer.valueOf(R.mipmap.ic_head_default_circle);
                }
                com.bumptech.glide.i<Drawable> iVarMo54load = kVarC.mo54load(objValueOf);
                new com.bumptech.glide.request.f();
                iVarMo54load.apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.bitmapTransform(new com.bumptech.glide.load.resource.bitmap.k())).into(imageView);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
            relativeLayout.addView(viewInflate);
        }
    }
}
