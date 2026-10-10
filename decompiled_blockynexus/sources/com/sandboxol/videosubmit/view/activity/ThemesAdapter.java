package com.sandboxol.videosubmit.view.activity;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.databinding.VideosubmitItemThemeBinding;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ThemesAdapter extends RecyclerView.a<ThemesViewHolder> {
    private List<String> themes;

    protected static class ThemesViewHolder extends RecyclerView.w {
        public ThemesViewHolder(VideosubmitItemThemeBinding videosubmitItemThemeBinding) {
            super(videosubmitItemThemeBinding.getRoot());
        }
    }

    public ThemesAdapter(List<String> list) {
        this.themes = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        List<String> list = this.themes;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(ThemesViewHolder themesViewHolder, int i) {
        List<String> list;
        VideosubmitItemThemeBinding videosubmitItemThemeBinding = (VideosubmitItemThemeBinding) androidx.databinding.e.a(themesViewHolder.itemView);
        if (videosubmitItemThemeBinding == null || (list = this.themes) == null || list.size() <= 0) {
            return;
        }
        videosubmitItemThemeBinding.tvTheme.setText(this.themes.get(i));
        videosubmitItemThemeBinding.executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ThemesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ThemesViewHolder((VideosubmitItemThemeBinding) androidx.databinding.e.a(LayoutInflater.from(viewGroup.getContext()), R.layout.videosubmit_item_theme, viewGroup, false));
    }
}
