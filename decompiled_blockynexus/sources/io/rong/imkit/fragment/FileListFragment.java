package io.rong.imkit.fragment;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import io.rong.imkit.RongConfigurationManager;
import io.rong.imkit.activity.FileListActivity;
import io.rong.imkit.model.FileInfo;
import io.rong.imkit.utils.FileTypeUtils;
import io.rong.imkit.widget.LoadingDialogFragment;
import io.rong.imkit.widget.adapter.FileListAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class FileListFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int ALL_AUDIO_FILES = 3;
    private static final int ALL_FILE_FILES = 1;
    private static final int ALL_RAM_FILES = 5;
    private static final int ALL_SD_FILES = 6;
    private static final int ALL_VIDEO_FILES = 2;
    private static final int ALL_other_FILES = 4;
    private static final int FILE_TRAVERSE_TYPE_ONE = 200;
    private static final int FILE_TRAVERSE_TYPE_TWO = 201;
    private static final String MOBILE_DIR = "directory";
    private static final int ROOT_DIR = 100;
    private static final int SD_CARD_ROOT_DIR = 101;
    private File currentDir;
    private int fileFilterType;
    private int fileTraverseType;
    private String mFileInfoMessage;
    private FileListAdapter mFileListAdapter;
    private ImageView mFileListTitleImageBack;
    private LinearLayout mFileLoadingLinearLayout;
    private TextView mFileSelectStateTextView;
    private TextView mFilesCategoryTitleTextView;
    private List<FileInfo> mFilesList;
    private ListView mFilesListView;
    private AsyncTask mLoadFilesTask;
    private LoadingDialogFragment mLoadingDialogFragment;
    private TextView mNoFileMessageTextView;
    private HashSet<FileInfo> mSelectedFiles = new HashSet<>();
    private File startDir;

    @TargetApi(11)
    private void loadFileList() {
        if (this.mLoadFilesTask != null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            this.mLoadFilesTask = new AsyncTask<File, Void, List<FileInfo>>() { // from class: io.rong.imkit.fragment.FileListFragment.1
                @Override // android.os.AsyncTask
                protected void onCancelled() {
                    FileListFragment.this.mLoadFilesTask = null;
                    if (FileListFragment.this.mLoadingDialogFragment != null) {
                        FileListFragment.this.mLoadingDialogFragment.dismiss();
                    }
                    super.onCancelled();
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    FileListFragment.this.mLoadingDialogFragment.show(FileListFragment.this.getFragmentManager());
                    if (FileListFragment.this.fileTraverseType == 200) {
                        FileListFragment.this.showLoadingFileView();
                    }
                    super.onPreExecute();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public List<FileInfo> doInBackground(File... fileArr) {
                    FileListFragment.this.mFileInfoMessage = "";
                    try {
                        List<FileInfo> arrayList = new ArrayList<>();
                        if (FileListFragment.this.fileTraverseType == 201) {
                            arrayList = FileTypeUtils.getFileInfosFromFileArray(fileArr[0].listFiles(FileTypeUtils.ALL_FOLDER_AND_FILES_FILTER));
                        } else if (FileListFragment.this.fileTraverseType == 200) {
                            if (FileListFragment.this.getActivity() == null) {
                                return arrayList;
                            }
                            FileListFragment.this.startDir = new File(Environment.getExternalStorageDirectory().getPath());
                            int i = FileListFragment.this.fileFilterType;
                            if (i == 1) {
                                arrayList = FileTypeUtils.getTextFilesInfo(FileListFragment.this.getActivity(), FileListFragment.this.startDir);
                                FileListFragment.this.mFileInfoMessage = FileListFragment.this.getString(R.string.rc_fr_file_category_title_text);
                            } else if (i == 2) {
                                arrayList = FileTypeUtils.getVideoFilesInfo(FileListFragment.this.getActivity(), FileListFragment.this.startDir);
                                FileListFragment.this.mFileInfoMessage = FileListFragment.this.getString(R.string.rc_fr_file_category_title_video);
                            } else if (i == 3) {
                                arrayList = FileTypeUtils.getAudioFilesInfo(FileListFragment.this.getActivity(), FileListFragment.this.startDir);
                                FileListFragment.this.mFileInfoMessage = FileListFragment.this.getString(R.string.rc_fr_file_category_title_audio);
                            } else if (i == 4) {
                                arrayList = FileTypeUtils.getOtherFilesInfo(FileListFragment.this.getActivity(), FileListFragment.this.startDir);
                                FileListFragment.this.mFileInfoMessage = FileListFragment.this.getString(R.string.rc_fr_file_category_title_other);
                            }
                        }
                        if (arrayList == null) {
                            return new ArrayList();
                        }
                        if (isCancelled()) {
                            return new ArrayList();
                        }
                        Collections.sort(arrayList, new FileTypeUtils.FileNameComparator());
                        if (FileListFragment.this.mLoadingDialogFragment != null) {
                            FileListFragment.this.mLoadingDialogFragment.dismiss();
                        }
                        return arrayList;
                    } catch (Exception unused) {
                        if (FileListFragment.this.mLoadingDialogFragment != null) {
                            FileListFragment.this.mLoadingDialogFragment.dismiss();
                        }
                        return new ArrayList();
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(List<FileInfo> list) {
                    FileListFragment.this.mFileLoadingLinearLayout.setVisibility(8);
                    FileListFragment.this.mFilesListView.setVisibility(0);
                    FileListFragment.this.mLoadFilesTask = null;
                    try {
                        FileListFragment.this.mFilesList = list;
                    } catch (Exception e2) {
                        FileListFragment.this.showNoFileMessage(e2.getMessage());
                    }
                    if (FileListFragment.this.mFilesList.isEmpty()) {
                        FileListFragment.this.showNoFileMessage(FileListFragment.this.mFileInfoMessage);
                        return;
                    }
                    FileListFragment.this.mFileListAdapter = new FileListAdapter(FileListFragment.this.getActivity(), FileListFragment.this.mFilesList, FileListFragment.this.mSelectedFiles);
                    FileListFragment.this.setListViewAdapter(FileListFragment.this.mFileListAdapter);
                    super.onPostExecute(list);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.currentDir);
        } else {
            this.mLoadFilesTask = new AsyncTask<File, Void, List<FileInfo>>() { // from class: io.rong.imkit.fragment.FileListFragment.2
                @Override // android.os.AsyncTask
                protected void onCancelled() {
                    FileListFragment.this.mLoadFilesTask = null;
                    if (FileListFragment.this.mLoadingDialogFragment != null) {
                        FileListFragment.this.mLoadingDialogFragment.dismiss();
                    }
                    super.onCancelled();
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    if (FileListFragment.this.fileTraverseType == 200) {
                        FileListFragment.this.showLoadingFileView();
                    }
                    super.onPreExecute();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public List<FileInfo> doInBackground(File... fileArr) {
                    FileListFragment.this.mFileInfoMessage = "";
                    try {
                        List<FileInfo> arrayList = new ArrayList<>();
                        if (FileListFragment.this.fileTraverseType == 201) {
                            arrayList = FileTypeUtils.getFileInfosFromFileArray(fileArr[0].listFiles(FileTypeUtils.ALL_FOLDER_AND_FILES_FILTER));
                        } else if (FileListFragment.this.fileTraverseType == 200) {
                            int i = FileListFragment.this.fileFilterType;
                            if (i == 1) {
                                arrayList = FileTypeUtils.getTextFilesInfo(FileListFragment.this.getActivity(), FileListFragment.this.startDir);
                                FileListFragment.this.mFileInfoMessage = FileListFragment.this.getString(R.string.rc_fr_file_category_title_text);
                            } else if (i == 2) {
                                arrayList = FileTypeUtils.getVideoFilesInfo(FileListFragment.this.getContext(), FileListFragment.this.startDir);
                                FileListFragment.this.mFileInfoMessage = FileListFragment.this.getString(R.string.rc_fr_file_category_title_video);
                            } else if (i == 3) {
                                arrayList = FileTypeUtils.getAudioFilesInfo(FileListFragment.this.getContext(), FileListFragment.this.startDir);
                                FileListFragment.this.mFileInfoMessage = FileListFragment.this.getString(R.string.rc_fr_file_category_title_audio);
                            } else if (i == 4) {
                                arrayList = FileTypeUtils.getOtherFilesInfo(FileListFragment.this.getContext(), FileListFragment.this.startDir);
                                FileListFragment.this.mFileInfoMessage = FileListFragment.this.getString(R.string.rc_fr_file_category_title_other);
                            }
                        }
                        if (arrayList == null) {
                            return new ArrayList();
                        }
                        if (isCancelled()) {
                            return new ArrayList();
                        }
                        Collections.sort(arrayList, new FileTypeUtils.FileNameComparator());
                        if (FileListFragment.this.mLoadingDialogFragment != null) {
                            FileListFragment.this.mLoadingDialogFragment.dismiss();
                        }
                        return arrayList;
                    } catch (Exception unused) {
                        return new ArrayList();
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(List<FileInfo> list) {
                    FileListFragment.this.mFileLoadingLinearLayout.setVisibility(8);
                    FileListFragment.this.mFilesListView.setVisibility(0);
                    FileListFragment.this.mLoadFilesTask = null;
                    try {
                        FileListFragment.this.mFilesList = list;
                    } catch (Exception e2) {
                        FileListFragment.this.showNoFileMessage(e2.getMessage());
                    }
                    if (FileListFragment.this.mFilesList.isEmpty()) {
                        FileListFragment.this.showNoFileMessage(FileListFragment.this.mFileInfoMessage);
                        return;
                    }
                    FileListFragment.this.mFileListAdapter = new FileListAdapter(FileListFragment.this.getActivity(), FileListFragment.this.mFilesList, FileListFragment.this.mSelectedFiles);
                    FileListFragment.this.setListViewAdapter(FileListFragment.this.mFileListAdapter);
                    super.onPostExecute(list);
                }
            }.execute(this.currentDir);
        }
    }

    private void navigateTo(File file) {
        FileListActivity fileListActivity = (FileListActivity) getActivity();
        FileListFragment fileListFragment = new FileListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MOBILE_DIR, file.getAbsolutePath());
        fileListFragment.setArguments(bundle);
        if (fileListActivity != null) {
            fileListActivity.showFragment(fileListFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewAdapter(FileListAdapter fileListAdapter) {
        this.mFileListAdapter = fileListAdapter;
        ListView listView = this.mFilesListView;
        if (listView != null) {
            listView.setAdapter((ListAdapter) fileListAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingFileView() {
        this.mFilesListView.setVisibility(8);
        this.mNoFileMessageTextView.setVisibility(8);
        this.mFileLoadingLinearLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoFileMessage(String str) {
        this.mFilesListView.setVisibility(8);
        this.mFileLoadingLinearLayout.setVisibility(8);
        this.mNoFileMessageTextView.setVisibility(0);
        this.mNoFileMessageTextView.setText(getResources().getString(R.string.rc_fr_no_file_message, str));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getActivity() == null) {
            return;
        }
        if (view == this.mFileSelectStateTextView) {
            Intent intent = new Intent();
            intent.putExtra("selectedFiles", this.mSelectedFiles);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
        if (view == this.mFileListTitleImageBack) {
            getActivity().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        Intent intent = getActivity().getIntent();
        int intExtra = intent.getIntExtra("rootDirType", -1);
        this.fileFilterType = intent.getIntExtra("fileFilterType", -1);
        this.fileTraverseType = intent.getIntExtra("fileTraverseType", -1);
        String stringExtra = intent.getStringExtra("rootDir");
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(MOBILE_DIR)) {
            this.currentDir = new File(arguments.getString(MOBILE_DIR));
        } else if (intExtra == 100) {
            this.currentDir = new File(Environment.getExternalStorageDirectory().getPath());
        } else if (intExtra == 101) {
            this.currentDir = new File(stringExtra);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.rc_fr_file_list, viewGroup, false);
        this.mFileListTitleImageBack = (ImageView) viewInflate.findViewById(R.id.rc_ad_iv_file_list_go_back);
        this.mFilesCategoryTitleTextView = (TextView) viewInflate.findViewById(R.id.rc_ad_tv_file_list_title);
        this.mFileSelectStateTextView = (TextView) viewInflate.findViewById(R.id.rc_ad_tv_file_list_select_state);
        this.mFilesListView = (ListView) viewInflate.findViewById(R.id.rc_fm_lv_storage_folder_list_files);
        this.mFileLoadingLinearLayout = (LinearLayout) viewInflate.findViewById(R.id.rc_fm_ll_storage_folder_list_load);
        this.mNoFileMessageTextView = (TextView) viewInflate.findViewById(R.id.rc_fm_tv_no_file_message);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AsyncTask asyncTask = this.mLoadFilesTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mFilesListView = null;
        this.mLoadingDialogFragment = null;
        super.onDestroyView();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        if (itemAtPosition instanceof FileInfo) {
            FileInfo fileInfo = (FileInfo) itemAtPosition;
            if (fileInfo.isDirectory()) {
                navigateTo(new File(fileInfo.getFilePath()));
                return;
            }
            int fileMaxSize = RongConfigurationManager.getInstance().getFileMaxSize(getActivity());
            String str = fileMaxSize >= 1024 ? "GB" : "MB";
            if (fileInfo.getFileSize() > ((long) fileMaxSize) * 1024 * 1024) {
                if (str.equals("GB")) {
                    fileMaxSize /= 1024;
                }
                Toast.makeText(getActivity(), String.format(getResources().getString(R.string.rc_fr_file_size_limit), Integer.valueOf(fileMaxSize), str), 0).show();
                return;
            }
            if (this.mSelectedFiles.contains(fileInfo)) {
                this.mSelectedFiles.remove(fileInfo);
                this.mFileListAdapter.notifyDataSetChanged();
            } else if (view.isSelected() || this.mSelectedFiles.size() >= 20) {
                Toast.makeText(getActivity(), getResources().getString(R.string.rc_fr_file_list_most_selected_files), 0).show();
            } else {
                this.mSelectedFiles.add(fileInfo);
                this.mFileListAdapter.notifyDataSetChanged();
            }
            if (this.mSelectedFiles.size() > 0) {
                this.mFileSelectStateTextView.setClickable(true);
                this.mFileSelectStateTextView.setSelected(true);
                this.mFileSelectStateTextView.setText(getResources().getString(R.string.rc_ad_send_file_select_file, Integer.valueOf(this.mSelectedFiles.size())));
            } else {
                this.mFileSelectStateTextView.setClickable(false);
                this.mFileSelectStateTextView.setSelected(false);
                this.mFileSelectStateTextView.setText(getResources().getString(R.string.rc_ad_send_file_no_select_file));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String string = "";
        this.mLoadingDialogFragment = LoadingDialogFragment.newInstance("", getResources().getString(R.string.rc_notice_data_is_loading));
        loadFileList();
        switch (this.fileFilterType) {
            case 1:
                string = getString(R.string.rc_fr_file_category_title_text);
                break;
            case 2:
                string = getString(R.string.rc_fr_file_category_title_video);
                break;
            case 3:
                string = getString(R.string.rc_fr_file_category_title_audio);
                break;
            case 4:
                string = getString(R.string.rc_fr_file_category_title_other);
                break;
            case 5:
                string = getString(R.string.rc_fr_file_category_title_ram);
                break;
            case 6:
                string = getString(R.string.rc_fr_file_category_title_sd);
                break;
        }
        this.mFilesCategoryTitleTextView.setText(string);
        this.mFilesListView.setOnItemClickListener(this);
        this.mFileListTitleImageBack.setOnClickListener(this);
        this.mFileSelectStateTextView.setOnClickListener(this);
        this.mFileSelectStateTextView.setClickable(false);
        this.mFileSelectStateTextView.setSelected(false);
    }
}
