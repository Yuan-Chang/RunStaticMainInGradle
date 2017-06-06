package yuan.com.runstaticmainingradle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yuan.com.mytestsdk.MyMain;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyMain myMain = new MyMain();

    }
}
