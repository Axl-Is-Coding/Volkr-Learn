package io.rong.imkit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseActivity;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes5.dex */
public class FileManagerActivity extends RongBaseActivity implements View.OnClickListener {
    private static final int ALL_AUDIO_FILES = 3;
    private static final int ALL_FILE_FILES = 1;
    private static final int ALL_OTHER_FILES = 4;
    private static final int ALL_RAM_FILES = 5;
    private static final int ALL_SD_FILES = 6;
    private static final int ALL_VIDEO_FILES = 2;
    private static final int FILE_TRAVERSE_TYPE_ONE = 200;
    private static final int FILE_TRAVERSE_TYPE_TWO = 201;
    private static final int REQUEST_FOR_SELECTED_FILES = 730;
    private static final int ROOT_DIR = 100;
    private static final int SD_CARD_ROOT_DIR = 101;
    private TextView mAudioTextView;
    private TextView mFileTextView;
    private TextView mMobileMemoryTextView;
    private TextView mOtherTextView;
    private String[] mPath;
    private LinearLayout mSDCardLinearLayout;
    private LinearLayout mSDCardOneLinearLayout;
    private String mSDCardPath;
    private String mSDCardPathOne;
    private String mSDCardPathTwo;
    private TextView mSDCardTextView;
    private LinearLayout mSDCardTwoLinearLayout;
    private TextView mVideoTextView;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != REQUEST_FOR_SELECTED_FILES || intent == null) {
            return;
        }
        HashSet hashSet = (HashSet) intent.getSerializableExtra("selectedFiles");
        Intent intent2 = new Intent();
        intent2.putExtra("sendSelectedFiles", hashSet);
        setResult(-1, intent2);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this, (Class<?>) FileListActivity.class);
        if (view == this.mFileTextView) {
            intent.putExtra("rootDirType", 100);
            intent.putExtra("fileFilterType", 1);
            intent.putExtra("fileTraverseType", 200);
        }
        if (view == this.mVideoTextView) {
            intent.putExtra("rootDirType", 100);
            intent.putExtra("fileFilterType", 2);
            intent.putExtra("fileTraverseType", 200);
        }
        if (view == this.mAudioTextView) {
            intent.putExtra("rootDirType", 100);
            intent.putExtra("fileFilterType", 3);
            intent.putExtra("fileTraverseType", 200);
        }
        if (view == this.mOtherTextView) {
            intent.putExtra("rootDirType", 100);
            intent.putExtra("fileFilterType", 4);
            intent.putExtra("fileTraverseType", 200);
        }
        if (view == this.mMobileMemoryTextView) {
            intent.putExtra("rootDirType", 100);
            intent.putExtra("fileFilterType", 5);
            intent.putExtra("fileTraverseType", 201);
        }
        if (view == this.mSDCardTextView) {
            intent.putExtra("rootDirType", 101);
            intent.putExtra("fileFilterType", 6);
            intent.putExtra("fileTraverseType", 201);
            intent.putExtra("rootDir", this.mSDCardPath);
        }
        if (view == this.mSDCardOneLinearLayout) {
            intent.putExtra("rootDirType", 101);
            intent.putExtra("fileFilterType", 6);
            intent.putExtra("fileTraverseType", 201);
            intent.putExtra("rootDir", this.mSDCardPathOne);
        }
        if (view == this.mSDCardTwoLinearLayout) {
            intent.putExtra("rootDirType", 101);
            intent.putExtra("fileFilterType", 6);
            intent.putExtra("fileTraverseType", 201);
            intent.putExtra("rootDir", this.mSDCardPathTwo);
        }
        startActivityForResult(intent, REQUEST_FOR_SELECTED_FILES);
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_ac_file_manager);
        this.mFileTextView = (TextView) findViewById(R.id.rc_ac_tv_file_manager_file);
        this.mVideoTextView = (TextView) findViewById(R.id.rc_ac_tv_file_manager_video);
        this.mAudioTextView = (TextView) findViewById(R.id.rc_ac_tv_file_manager_audio);
        this.mOtherTextView = (TextView) findViewById(R.id.rc_ac_tv_file_manager_picture);
        this.mMobileMemoryTextView = (TextView) findViewById(R.id.rc_ac_tv_file_manager_mobile_memory);
        this.mSDCardTextView = (TextView) findViewById(R.id.rc_ac_tv_file_manager_SD_card);
        this.mSDCardLinearLayout = (LinearLayout) findViewById(R.id.rc_ac_ll_sd_card);
        this.mSDCardOneLinearLayout = (LinearLayout) findViewById(R.id.rc_ac_ll_sd_card_one);
        this.mSDCardTwoLinearLayout = (LinearLayout) findViewById(R.id.rc_ac_ll_sd_card_two);
        this.mFileTextView.setOnClickListener(this);
        this.mVideoTextView.setOnClickListener(this);
        this.mAudioTextView.setOnClickListener(this);
        this.mOtherTextView.setOnClickListener(this);
        this.mMobileMemoryTextView.setOnClickListener(this);
        this.mSDCardTextView.setOnClickListener(this);
        this.mSDCardOneLinearLayout.setOnClickListener(this);
        this.mSDCardTwoLinearLayout.setOnClickListener(this);
        ((TextView) findViewById(R.id.rc_action_bar_title)).setText(R.string.rc_ac_file_send_preview);
        this.mPath = FileTypeUtils.getExternalStorageDirectories(this);
        if (this.mPath.length == 1) {
            this.mSDCardLinearLayout.setVisibility(0);
            this.mSDCardPath = this.mPath[0];
        }
        String[] strArr = this.mPath;
        if (strArr.length == 2) {
            this.mSDCardPathOne = strArr[0];
            this.mSDCardPathTwo = strArr[1];
            this.mSDCardOneLinearLayout.setVisibility(0);
            this.mSDCardTwoLinearLayout.setVisibility(0);
        }
    }
}
