package io.rong.imkit.widget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongConfigurationManager;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.FileInfo;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class FileListAdapter extends android.widget.BaseAdapter {
    private Context mContext;
    private List<FileInfo> mFileList;
    private HashSet<FileInfo> mSelectedFiles;

    private class ViewHolder {
        ImageView fileCheckStateImageView;
        TextView fileDetailsTextView;
        ImageView fileIconImageView;
        TextView fileNameTextView;

        private ViewHolder() {
        }
    }

    public FileListAdapter(Context context, List<FileInfo> list, HashSet<FileInfo> hashSet) {
        this.mFileList = list;
        this.mContext = context;
        this.mSelectedFiles = hashSet;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FileInfo> list = this.mFileList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<FileInfo> list = this.mFileList;
        if (list != null && i < list.size()) {
            return this.mFileList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.rc_wi_file_list_adapter, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.fileCheckStateImageView = (ImageView) viewInflate.findViewById(R.id.rc_wi_ad_iv_file_check_state);
        viewHolder.fileIconImageView = (ImageView) viewInflate.findViewById(R.id.rc_wi_ad_iv_file_icon);
        viewHolder.fileNameTextView = (TextView) viewInflate.findViewById(R.id.rc_wi_ad_tv_file_name);
        viewHolder.fileDetailsTextView = (TextView) viewInflate.findViewById(R.id.rc_wi_ad_tv_file_details);
        FileInfo fileInfo = this.mFileList.get(i);
        viewHolder.fileNameTextView.setText(fileInfo.getFileName());
        if (fileInfo.isDirectory()) {
            long fileSize = fileInfo.getFileSize();
            if (fileSize == 0) {
                viewHolder.fileDetailsTextView.setText(RongIM.getInstance().getApplicationContext().getString(R.string.rc_ad_folder_no_files));
            } else {
                viewHolder.fileDetailsTextView.setText(RongIM.getInstance().getApplicationContext().getString(R.string.rc_ad_folder_files_number, Long.valueOf(fileSize)));
            }
            viewHolder.fileIconImageView.setImageResource(FileTypeUtils.getFileIconResource(RongIM.getInstance().getApplicationContext(), fileInfo));
        } else {
            if (this.mSelectedFiles.contains(fileInfo)) {
                viewHolder.fileCheckStateImageView.setImageResource(R.drawable.rc_ad_list_file_checked);
            } else {
                viewHolder.fileCheckStateImageView.setImageResource(R.drawable.rc_ad_list_file_unchecked);
            }
            viewHolder.fileDetailsTextView.setText(RongIM.getInstance().getApplicationContext().getString(R.string.rc_ad_file_size, FileTypeUtils.formatFileSize(fileInfo.getFileSize())));
            viewHolder.fileIconImageView.setImageResource(FileTypeUtils.getFileIconResource(RongIM.getInstance().getApplicationContext(), fileInfo));
            if (fileInfo.getFileSize() > ((long) RongConfigurationManager.getInstance().getFileMaxSize(viewInflate.getContext())) * 1024 * 1024) {
                viewInflate.setAlpha(0.4f);
            }
        }
        return viewInflate;
    }
}
