package com.facebook.appevents.ml;

import android.os.AsyncTask;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Model {
    private static final String DIR_NAME = "facebook_ml/";
    private static final int EMBEDDING_SIZE = 64;
    private static final int SEQ_LEN = 128;
    public static final String SHOULD_FILTER = "SHOULD_FILTER";
    private static final List<String> SUGGESTED_EVENTS_PREDICTION = Arrays.asList(AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, "other", AppEventsConstants.EVENT_NAME_PURCHASED);
    private static final Map<String, String> WEIGHTS_KEY_MAPPING = new HashMap<String, String>() { // from class: com.facebook.appevents.ml.Model.1
        {
            put("embedding.weight", "embed.weight");
            put("dense1.weight", "fc1.weight");
            put("dense2.weight", "fc2.weight");
            put("dense3.weight", "fc3.weight");
            put("dense1.bias", "fc1.bias");
            put("dense2.bias", "fc2.bias");
            put("dense3.bias", "fc3.bias");
        }
    };
    private Weight convs_1_bias;
    private Weight convs_1_weight;
    private Weight convs_2_bias;
    private Weight convs_2_weight;
    private Weight convs_3_bias;
    private Weight convs_3_weight;
    private File dir = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
    private Weight embedding;
    private Weight fc1_bias;
    private Weight fc1_weight;
    private Weight fc2_bias;
    private Weight fc2_weight;
    private Weight fc3_bias;
    private Weight fc3_weight;
    private File modelFile;
    private String modelUri;
    private File ruleFile;
    private String ruleUri;
    private float[] thresholds;
    private String useCase;
    private int versionID;

    static class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
        File destFile;
        Runnable onSuccess;
        String uriStr;

        FileDownloadTask(String str, File file, Runnable runnable) {
            this.uriStr = str;
            this.destFile = file;
            this.onSuccess = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(this.uriStr);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                this.onSuccess.run();
            }
        }
    }

    private static class Weight {
        public float[] data;
        public int[] shape;

        Weight(int[] iArr, float[] fArr) {
            this.shape = iArr;
            this.data = fArr;
        }
    }

    Model(String str, int i, String str2, String str3, float[] fArr) {
        this.useCase = str;
        this.versionID = i;
        this.thresholds = fArr;
        this.modelUri = str2;
        this.ruleUri = str3;
        if (!this.dir.exists()) {
            this.dir.mkdirs();
        }
        this.modelFile = new File(this.dir, str + "_" + i);
        this.ruleFile = new File(this.dir, str + "_" + i + "_rule");
    }

    private void deleteOldFiles() {
        File[] fileArrListFiles = this.dir.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        String str = this.useCase + "_" + this.versionID;
        for (File file : fileArrListFiles) {
            String name = file.getName();
            if (name.startsWith(this.useCase) && !name.startsWith(str)) {
                file.delete();
            }
        }
    }

    private void downloadModel(Runnable runnable) {
        if (this.modelFile.exists()) {
            runnable.run();
            return;
        }
        String str = this.modelUri;
        if (str != null) {
            new FileDownloadTask(str, this.modelFile, runnable).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadRule(Runnable runnable) {
        String str;
        if (this.ruleFile.exists() || (str = this.ruleUri) == null) {
            runnable.run();
        } else {
            new FileDownloadTask(str, this.ruleFile, runnable).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initializeWeights() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.modelFile);
            int iAvailable = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[iAvailable];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (iAvailable < 4) {
                return false;
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 4);
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            int i = byteBufferWrap.getInt();
            int i2 = i + 4;
            if (iAvailable < i2) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr, 4, i));
            JSONArray jSONArrayNames = jSONObject.names();
            String[] strArr = new String[jSONArrayNames.length()];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                strArr[i3] = jSONArrayNames.getString(i3);
            }
            Arrays.sort(strArr);
            HashMap map = new HashMap();
            int length = strArr.length;
            int i4 = i2;
            int i5 = 0;
            while (i5 < length) {
                String str = strArr[i5];
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int[] iArr = new int[jSONArray.length()];
                int i6 = 1;
                for (int i7 = 0; i7 < iArr.length; i7++) {
                    iArr[i7] = jSONArray.getInt(i7);
                    i6 *= iArr[i7];
                }
                int i8 = i6 * 4;
                int i9 = i4 + i8;
                if (i9 > iAvailable) {
                    return false;
                }
                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr, i4, i8);
                byteBufferWrap2.order(ByteOrder.LITTLE_ENDIAN);
                float[] fArr = new float[i6];
                byteBufferWrap2.asFloatBuffer().get(fArr, 0, i6);
                if (WEIGHTS_KEY_MAPPING.containsKey(str)) {
                    str = WEIGHTS_KEY_MAPPING.get(str);
                }
                map.put(str, new Weight(iArr, fArr));
                i5++;
                i4 = i9;
            }
            this.embedding = (Weight) map.get("embed.weight");
            this.convs_1_weight = (Weight) map.get("convs.0.weight");
            this.convs_2_weight = (Weight) map.get("convs.1.weight");
            this.convs_3_weight = (Weight) map.get("convs.2.weight");
            this.convs_1_weight.data = Operator.transpose3D(this.convs_1_weight.data, this.convs_1_weight.shape[0], this.convs_1_weight.shape[1], this.convs_1_weight.shape[2]);
            this.convs_2_weight.data = Operator.transpose3D(this.convs_2_weight.data, this.convs_2_weight.shape[0], this.convs_2_weight.shape[1], this.convs_2_weight.shape[2]);
            this.convs_3_weight.data = Operator.transpose3D(this.convs_3_weight.data, this.convs_3_weight.shape[0], this.convs_3_weight.shape[1], this.convs_3_weight.shape[2]);
            this.convs_1_bias = (Weight) map.get("convs.0.bias");
            this.convs_2_bias = (Weight) map.get("convs.1.bias");
            this.convs_3_bias = (Weight) map.get("convs.2.bias");
            this.fc1_weight = (Weight) map.get("fc1.weight");
            this.fc2_weight = (Weight) map.get("fc2.weight");
            this.fc3_weight = (Weight) map.get("fc3.weight");
            this.fc1_weight.data = Operator.transpose2D(this.fc1_weight.data, this.fc1_weight.shape[0], this.fc1_weight.shape[1]);
            this.fc2_weight.data = Operator.transpose2D(this.fc2_weight.data, this.fc2_weight.shape[0], this.fc2_weight.shape[1]);
            this.fc3_weight.data = Operator.transpose2D(this.fc3_weight.data, this.fc3_weight.shape[0], this.fc3_weight.shape[1]);
            this.fc1_bias = (Weight) map.get("fc1.bias");
            this.fc2_bias = (Weight) map.get("fc2.bias");
            this.fc3_bias = (Weight) map.get("fc3.bias");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    File getRuleFile() {
        return this.ruleFile;
    }

    void initialize(final Runnable runnable) {
        downloadModel(new Runnable() { // from class: com.facebook.appevents.ml.Model.2
            @Override // java.lang.Runnable
            public void run() {
                if (Model.this.initializeWeights()) {
                    Model.this.downloadRule(runnable);
                }
            }
        });
        deleteOldFiles();
    }

    String predict(float[] fArr, String str) {
        float[] fArrEmbedding = Operator.embedding(Utils.vectorize(str, 128), this.embedding.data, 1, 128, 64);
        Weight weight = this.convs_1_weight;
        float[] fArr2 = weight.data;
        int[] iArr = weight.shape;
        float[] fArrConv1D = Operator.conv1D(fArrEmbedding, fArr2, 1, 128, 64, iArr[2], iArr[0]);
        Weight weight2 = this.convs_2_weight;
        float[] fArr3 = weight2.data;
        int[] iArr2 = weight2.shape;
        float[] fArrConv1D2 = Operator.conv1D(fArrEmbedding, fArr3, 1, 128, 64, iArr2[2], iArr2[0]);
        Weight weight3 = this.convs_3_weight;
        float[] fArr4 = weight3.data;
        int[] iArr3 = weight3.shape;
        float[] fArrConv1D3 = Operator.conv1D(fArrEmbedding, fArr4, 1, 128, 64, iArr3[2], iArr3[0]);
        float[] fArr5 = this.convs_1_bias.data;
        int[] iArr4 = this.convs_1_weight.shape;
        Operator.add(fArrConv1D, fArr5, 1, (128 - iArr4[2]) + 1, iArr4[0]);
        float[] fArr6 = this.convs_2_bias.data;
        int[] iArr5 = this.convs_2_weight.shape;
        Operator.add(fArrConv1D2, fArr6, 1, (128 - iArr5[2]) + 1, iArr5[0]);
        float[] fArr7 = this.convs_3_bias.data;
        int[] iArr6 = this.convs_3_weight.shape;
        Operator.add(fArrConv1D3, fArr7, 1, (128 - iArr6[2]) + 1, iArr6[0]);
        int[] iArr7 = this.convs_1_weight.shape;
        Operator.relu(fArrConv1D, ((128 - iArr7[2]) + 1) * iArr7[0]);
        int[] iArr8 = this.convs_2_weight.shape;
        Operator.relu(fArrConv1D2, ((128 - iArr8[2]) + 1) * iArr8[0]);
        int[] iArr9 = this.convs_3_weight.shape;
        Operator.relu(fArrConv1D3, ((128 - iArr9[2]) + 1) * iArr9[0]);
        int[] iArr10 = this.convs_1_weight.shape;
        float[] fArrMaxPool1D = Operator.maxPool1D(fArrConv1D, (128 - iArr10[2]) + 1, iArr10[0], (128 - iArr10[2]) + 1);
        int[] iArr11 = this.convs_2_weight.shape;
        float[] fArrMaxPool1D2 = Operator.maxPool1D(fArrConv1D2, (128 - iArr11[2]) + 1, iArr11[0], (128 - iArr11[2]) + 1);
        int[] iArr12 = this.convs_3_weight.shape;
        float[] fArrConcatenate = Operator.concatenate(Operator.concatenate(Operator.concatenate(fArrMaxPool1D, fArrMaxPool1D2), Operator.maxPool1D(fArrConv1D3, (128 - iArr12[2]) + 1, iArr12[0], (128 - iArr12[2]) + 1)), fArr);
        Weight weight4 = this.fc1_weight;
        float[] fArr8 = weight4.data;
        float[] fArr9 = this.fc1_bias.data;
        int[] iArr13 = weight4.shape;
        float[] fArrDense = Operator.dense(fArrConcatenate, fArr8, fArr9, 1, iArr13[1], iArr13[0]);
        Operator.relu(fArrDense, this.fc1_bias.shape[0]);
        Weight weight5 = this.fc2_weight;
        float[] fArr10 = weight5.data;
        float[] fArr11 = this.fc2_bias.data;
        int[] iArr14 = weight5.shape;
        float[] fArrDense2 = Operator.dense(fArrDense, fArr10, fArr11, 1, iArr14[1], iArr14[0]);
        Operator.relu(fArrDense2, this.fc2_bias.shape[0]);
        Weight weight6 = this.fc3_weight;
        float[] fArr12 = weight6.data;
        float[] fArr13 = this.fc3_bias.data;
        int[] iArr15 = weight6.shape;
        float[] fArrDense3 = Operator.dense(fArrDense2, fArr12, fArr13, 1, iArr15[1], iArr15[0]);
        Operator.softmax(fArrDense3, this.fc3_bias.shape[0]);
        return processPredictionResult(fArrDense3);
    }

    String processAddressDetectionResult(float[] fArr) {
        if (fArr[1] >= this.thresholds[0]) {
            return SHOULD_FILTER;
        }
        return null;
    }

    String processPredictionResult(float[] fArr) {
        if (fArr.length != 0 && this.thresholds.length != 0) {
            if (this.useCase.equals(ModelManager.MODEL_SUGGESTED_EVENTS)) {
                return processSuggestedEventResult(fArr);
            }
            if (this.useCase.equals(ModelManager.MODEL_ADDRESS_DETECTION)) {
                return processAddressDetectionResult(fArr);
            }
        }
        return null;
    }

    String processSuggestedEventResult(float[] fArr) {
        if (this.thresholds.length != fArr.length) {
            return null;
        }
        int i = 0;
        while (true) {
            float[] fArr2 = this.thresholds;
            if (i >= fArr2.length) {
                return "other";
            }
            if (fArr[i] >= fArr2[i]) {
                return SUGGESTED_EVENTS_PREDICTION.get(i);
            }
            i++;
        }
    }
}
