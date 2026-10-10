package com.sandboxol.videosubmit.view.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.databinding.VideosubmitItemTipBinding;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TipsAdapter extends RecyclerView.a<TipsViewHolder> {
    private Context context;
    private List<String> tips;

    protected static class TipsViewHolder extends RecyclerView.w {
        public TipsViewHolder(VideosubmitItemTipBinding videosubmitItemTipBinding) {
            super(videosubmitItemTipBinding.getRoot());
        }
    }

    public TipsAdapter(Context context, List<String> list) {
        this.context = context;
        this.tips = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        List<String> list = this.tips;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(TipsViewHolder tipsViewHolder, int i) {
        List<String> list;
        VideosubmitItemTipBinding videosubmitItemTipBinding = (VideosubmitItemTipBinding) androidx.databinding.e.a(tipsViewHolder.itemView);
        if (videosubmitItemTipBinding == null || (list = this.tips) == null || list.size() <= 0) {
            return;
        }
        videosubmitItemTipBinding.setTip(this.tips.get(i));
        int i2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? 0 : R.mipmap.videosubmit_ic_light_5 : R.mipmap.videosubmit_ic_light_4 : R.mipmap.videosubmit_ic_light_3 : R.mipmap.videosubmit_ic_light_2 : R.mipmap.videosubmit_ic_light_1;
        if (i2 != 0) {
            videosubmitItemTipBinding.setDrawableStart(this.context.getResources().getDrawable(i2));
        }
        videosubmitItemTipBinding.executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public TipsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TipsViewHolder((VideosubmitItemTipBinding) androidx.databinding.e.a(LayoutInflater.from(viewGroup.getContext()), R.layout.videosubmit_item_tip, viewGroup, false));
    }
}
