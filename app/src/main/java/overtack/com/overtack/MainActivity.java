package overtack.com.overtack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.res.Resources;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListener();
    }

    // TODO:戻るボタン無効化
    // TODO:クリア判定実装
    private void initListener(){
        // TODO:短く書けそう
        findViewById(R.id.toggleButton1_1).setOnClickListener(this);
        findViewById(R.id.toggleButton1_2).setOnClickListener(this);
        findViewById(R.id.toggleButton1_3).setOnClickListener(this);
        findViewById(R.id.toggleButton1_4).setOnClickListener(this);

        findViewById(R.id.toggleButton2_1).setOnClickListener(this);
        findViewById(R.id.toggleButton2_2).setOnClickListener(this);
        findViewById(R.id.toggleButton2_3).setOnClickListener(this);
        findViewById(R.id.toggleButton2_4).setOnClickListener(this);

        findViewById(R.id.toggleButton3_1).setOnClickListener(this);
        findViewById(R.id.toggleButton3_2).setOnClickListener(this);
        findViewById(R.id.toggleButton3_3).setOnClickListener(this);
        findViewById(R.id.toggleButton3_4).setOnClickListener(this);

        findViewById(R.id.toggleButton4_1).setOnClickListener(this);
        findViewById(R.id.toggleButton4_2).setOnClickListener(this);
        findViewById(R.id.toggleButton4_3).setOnClickListener(this);
        findViewById(R.id.toggleButton4_4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Resources res = getResources();
        String tglbtnName = "toggleButton";
        ToggleButton toggleButton;
        goback:
        for(int i = 1; i < 5; i++) {
            for(int j = 1; j < 5; j++) {
               String btnName = tglbtnName +  i + "-"+  j;
               int id = res.getIdentifier(btnName,"id",getPackageName());
                toggleButton = (ToggleButton) findViewById(id);
                if(v.getId() == toggleButton.getId()) {

                    // 押されたボタンは既に切り替わっているのでそのまま
//                    if(toggleButton.isChecked()) {
//                        toggleButton.setChecked(false);
//                    } else {
//                        toggleButton.setChecked(true);
//                    }

                    // 上下左右のボタンのON/OFF切り替え
                    int rowNum = Integer.parseInt(btnName.substring(12,13));
                    int colNum = Integer.parseInt(btnName.substring(14));

                    boolean topFlg = false;
                    boolean bottomFlg = false;
                    boolean rightFlg = false;
                    boolean leftFlg = false;
                    if(rowNum == 1){
                        topFlg = true;
                    } else if (rowNum == 4) {
                        bottomFlg = true;
                    }

                    if(colNum == 1) {
                        leftFlg = true;
                    } else if(colNum == 4) {
                        rightFlg = true;
                    }

                    // 上のボタンのON/OFF切り替え
                    if(!topFlg) {
                        int id1 = res.getIdentifier(tglbtnName + (rowNum - 1) + "-" + colNum,"id",getPackageName());
                        toggleButton = (ToggleButton) findViewById(id1);
                        if(toggleButton.isChecked()) {
                            toggleButton.setChecked(false);
                        } else {
                            toggleButton.setChecked(true);
                        }
                    }

                    // 下のボタンのON/OFF切り替え
                    if(!bottomFlg) {
                        int id2 = res.getIdentifier(tglbtnName + (rowNum + 1) + "-" + colNum,"id",getPackageName());
                        toggleButton = (ToggleButton) findViewById(id2);
                        if(toggleButton.isChecked()) {
                            toggleButton.setChecked(false);
                        } else {
                            toggleButton.setChecked(true);
                        }
                    }

                    // 右のボタンのON/OFF切り替え
                    if(!rightFlg) {
                        int id3 = res.getIdentifier(tglbtnName + rowNum + "-" + (colNum + 1),"id",getPackageName());
                        toggleButton = (ToggleButton) findViewById(id3);
                        if(toggleButton.isChecked()) {
                            toggleButton.setChecked(false);
                        } else {
                            toggleButton.setChecked(true);
                        }
                    }

                    // 左のボタンのON/OFF切り替え
                    if(!leftFlg) {
                        int id4 = res.getIdentifier(tglbtnName + rowNum + "-" + (colNum - 1),"id",getPackageName());
                        toggleButton = (ToggleButton) findViewById(id4);
                        if(toggleButton.isChecked()) {
                            toggleButton.setChecked(false);
                        } else {
                            toggleButton.setChecked(true);
                        }
                    }
                    break goback;
                }
            }
        }
    }
}
