package com.llb.llb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdActivity extends AppCompatActivity {
    TextView iv_count;
    Handler handler=new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);





          iv_count=      findViewById(R.id.iv_count);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=5;i>=0;i--){
                        SystemClock.sleep(Long.parseLong("1000"));
                        final int count=i;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iv_count.setText("点击跳转"+count);
                            }
                        });

                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent  intent=new Intent(AdActivity.this, MainActivity.class);
                            startActivity(intent);

                            finish();
                        }
                    });
                }
            }).start();

    }
}
