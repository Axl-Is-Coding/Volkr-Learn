package com.sandboxol.videosubmit.view.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.databinding.VideosubmitItemGameBinding;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GamesAdapter extends RecyclerView.a<GamesViewHolder> {
    private Context context;
    private List<String> pics;

    protected static class GamesViewHolder extends RecyclerView.w {
        public GamesViewHolder(VideosubmitItemGameBinding videosubmitItemGameBinding) {
            super(videosubmitItemGameBinding.getRoot());
        }
    }

    public GamesAdapter(Context context, List<String> list) {
        this.pics = list;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        List<String> list = this.pics;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(GamesViewHolder gamesViewHolder, int i) {
        List<String> list;
        VideosubmitItemGameBinding videosubmitItemGameBinding = (VideosubmitItemGameBinding) androidx.databinding.e.a(gamesViewHolder.itemView);
        if (videosubmitItemGameBinding == null || (list = this.pics) == null || list.size() <= 0) {
            return;
        }
        if (TextUtils.isEmpty(this.pics.get(i))) {
            videosubmitItemGameBinding.ivPic.setBackground(androidx.core.content.b.c(this.context, R.mipmap.videosubmit_ic_game_1));
        } else {
            try {
                com.bumptech.glide.c.c(this.context).mo55load(this.pics.get(i)).into(videosubmitItemGameBinding.ivPic);
            } catch (Exception unused) {
                videosubmitItemGameBinding.ivPic.setBackground(androidx.core.content.b.c(this.context, R.mipmap.videosubmit_ic_game_1));
            }
        }
        videosubmitItemGameBinding.executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public GamesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GamesViewHolder((VideosubmitItemGameBinding) androidx.databinding.e.a(LayoutInflater.from(viewGroup.getContext()), R.layout.videosubmit_item_game, viewGroup, false));
    }
}
