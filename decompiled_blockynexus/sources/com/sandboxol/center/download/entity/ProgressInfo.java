package com.sandboxol.center.download.entity;

import androidx.databinding.ObservableField;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: loaded from: classes3.dex */
public class ProgressInfo {
    private ObservableField<Boolean> isDownload = new ObservableField<>(false);
    private ObservableField<Integer> progressValue = new ObservableField<>(0);
    public ObservableField<String> progressPercentStr = new ObservableField<>(this.progressValue.get() + "%");
    private ObservableField<String> progressText = new ObservableField<>("");
    private ObservableField<Progress> progress = new ObservableField<>(new Progress());
    private ObservableField<Boolean> isFinish = new ObservableField<>(false);
    private ObservableField<Boolean> isError = new ObservableField<>(false);
    private ObservableField<Boolean> isAnimEnd = new ObservableField<>(false);
    private ObservableField<Integer> isNewEngine = new ObservableField<>(0);
    private ObservableField<Integer> isUgc = new ObservableField<>(0);

    public ObservableField<Boolean> getIsAnimEnd() {
        return this.isAnimEnd;
    }

    public ObservableField<Boolean> getIsDownload() {
        return this.isDownload;
    }

    public ObservableField<Boolean> getIsError() {
        return this.isError;
    }

    public ObservableField<Boolean> getIsFinish() {
        return this.isFinish;
    }

    public ObservableField<Integer> getIsNewEngine() {
        return this.isNewEngine;
    }

    public ObservableField<Integer> getIsUgc() {
        return this.isUgc;
    }

    public ObservableField<Progress> getProgress() {
        return this.progress;
    }

    public ObservableField<String> getProgressPercentStr() {
        return this.progressPercentStr;
    }

    public ObservableField<String> getProgressText() {
        return this.progressText;
    }

    public ObservableField<Integer> getProgressValue() {
        return this.progressValue;
    }

    public void setIsAnimEnd(ObservableField<Boolean> observableField) {
        this.isAnimEnd = observableField;
    }

    public ProgressInfo setIsDownload(ObservableField<Boolean> observableField) {
        this.isDownload = observableField;
        return this;
    }

    public void setIsError(ObservableField<Boolean> observableField) {
        this.isError = observableField;
    }

    public void setIsFinish(ObservableField<Boolean> observableField) {
        this.isFinish = observableField;
    }

    public void setProgress(ObservableField<Progress> observableField) {
        this.progress = observableField;
    }

    public ProgressInfo setProgressPercentStr(ObservableField<String> observableField) {
        this.progressPercentStr = observableField;
        return this;
    }

    public ProgressInfo setProgressText(ObservableField<String> observableField) {
        this.progressText = observableField;
        return this;
    }

    public ProgressInfo setProgressValue(ObservableField<Integer> observableField) {
        this.progressValue = observableField;
        return this;
    }
}
