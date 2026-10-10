package io.rong.imlib.filetransfer.upload.uploader;

import io.rong.imlib.filetransfer.CallDispatcher;
import io.rong.imlib.filetransfer.Request;
import io.rong.imlib.filetransfer.upload.MediaUploadEngine;
import io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader;

/* JADX INFO: loaded from: classes5.dex */
public interface IMediaUploader {
    void buildDownloadUrl(String str, BaseMediaUploader.IGetUrlResultCallback iGetUrlResultCallback);

    Request buildRequest();

    void run(CallDispatcher callDispatcher, MediaUploadEngine.IMediaUploadResultCallback iMediaUploadResultCallback);
}
