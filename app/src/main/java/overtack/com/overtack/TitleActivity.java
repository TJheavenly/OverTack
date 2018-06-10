package overtack.com.overtack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;

public class TitleActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        findViewById(R.id.button).setOnClickListener(this);
    }


    //ボタンが押された時の処理
    public void onClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity (intent);
    }
}
