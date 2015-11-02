package com.collectionexample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.collectionexample.layout.SDCardLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SdcardActivity extends AppCompatActivity implements View.OnClickListener{
    private SDCardLayout SDL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(SDL=new SDCardLayout(this));
        init();
    }
    private void init() {
        setOnClick();
    }
    private void setOnClick() {
        SDL.Savebtn.setOnClickListener(this);
        SDL.Readbtn.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v == SDL.Savebtn) {
            File SDFile = null;

            //檢查有沒有SD卡裝置
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)) {
                Toast.makeText(this, "SD卡不存在!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                //取得SD卡儲存路徑
                SDFile = Environment.getExternalStorageDirectory();
            }

            //建立文件檔儲存路徑
            File mFile = new File(SDFile.getParent() + "/" + SDFile.getName() + "/MyAndroid");

            //若沒有檔案儲存路徑時則建立此檔案路徑
            if (!mFile.exists()) {
                mFile.mkdirs();
            }

            //取得mEdit文字並儲存寫入至SD卡文件裡
            try {
                FileWriter mFileWriter = null;
                mFileWriter = new FileWriter(SDFile.getParent() + "/" +
                        SDFile.getName() + "/MyAndroid/SDCardTest.txt");
                mFileWriter.write(SDL.Edit.getText().toString());
                mFileWriter.close();
            } catch (Exception e) {
            }
            Toast.makeText(this, "已儲存文字", Toast.LENGTH_SHORT).show();
        } else {
            //取得SD卡儲存路徑
            try {
                File mSDFile = Environment.getExternalStorageDirectory();
                //讀取文件檔路徑
                FileReader mFileReader = new FileReader(mSDFile.getParent() +
                        "/" + mSDFile.getName() + "/MyAndroid/SDCardTest.txt");

                BufferedReader mBufferedReader = new BufferedReader(mFileReader);
                String mReadText = "";
                String mTextLine = mBufferedReader.readLine();

                //一行一行取出文字字串裝入String裡，直到沒有下一行文字停止跳出
                while (mTextLine != null) {
                    mReadText += mTextLine + "\n";
                    mTextLine = mBufferedReader.readLine();
                }
                SDL.SDCardtext.setText(mReadText);
                Toast.makeText(this, "已讀取文字", Toast.LENGTH_SHORT).show();
                SDL.Edit.setText("");
            } catch (Exception e) {
            }
        }
    }
}
