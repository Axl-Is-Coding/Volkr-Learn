package com.sandboxol.center.view.dialog.adsturntable;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.center.R;
import com.sandboxol.center.entity.AdsTurntableInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AdsTurntableAdapter extends RecyclerView.a<ItemViewHolder> {
    private Context context;
    private List<AdsTurntableInfo> list;

    public static class ItemViewHolder extends RecyclerView.w {
        public final ImageView ivReward;

        public ItemViewHolder(View view) {
            super(view);
            this.ivReward = (ImageView) view.findViewById(R.id.ivReward);
        }
    }

    public AdsTurntableAdapter(Context context, List<AdsTurntableInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        if (this.list.isEmpty() || i % this.list.size() >= this.list.size()) {
            return;
        }
        try {
            if (this.context != null && !((Activity) this.context).isFinishing()) {
                com.bumptech.glide.c.c(this.context).mo55load(this.list.get(i % this.list.size()).getPicUrl()).into(itemViewHolder.ivReward);
            } else if (itemViewHolder.ivReward.getContext() != null) {
                com.bumptech.glide.c.c(itemViewHolder.ivReward.getContext()).mo55load(this.list.get(i % this.list.size()).getPicUrl()).into(itemViewHolder.ivReward);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.base_item_ads_turntable, viewGroup, false));
    }
}
