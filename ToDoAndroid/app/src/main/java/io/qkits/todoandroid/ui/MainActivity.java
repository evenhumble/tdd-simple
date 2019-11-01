package io.qkits.todoandroid.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import io.qkits.todoandroid.R;
import io.qkits.todoandroid.mvp.ui.LoginMVPActivity;
import io.qkits.todoandroid.utils.DateUtil;


public class MainActivity extends AppCompatActivity {

    private CheckBox checkbox;
    private String lifecycle;

    /**
     * init app main page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lifecycle = "onCreate";
//        checkbox = this.findViewById(R.id.checkbox);
    }
    /** jumpt to other vew**/
    public void jumpGithubLogin(View view){

        startActivity(new Intent(this, LoginActivity.class));
//        startActivity(new Intent(this, LoginMVPActivity.class));
//        startActivity(new Intent(this, LoginDaggerActivity.class));
    }

    public void showToast(View view){
        Toast.makeText(this,"Hello UT!",Toast.LENGTH_LONG).show();
    }


    public void showDateDialog(View view){
        AlertDialog alertDate = new AlertDialog.Builder(this).setMessage("this is "+ DateUtil.stampToDate(10000000L))
                .create();
        alertDate.show();
    }
    public void showDialog(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Hello UT！")
                .setTitle("提示")
                .create();
        alertDialog.show();
    }

    public void inverse(View view){
        checkbox.setChecked(!checkbox.isChecked());
    }

    public String getLifecycleState(){
        return lifecycle;
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycle = "onStart";
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycle = "onResume";
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycle = "onPause";
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycle = "onStop";
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        lifecycle = "onRestart";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycle = "onDestroy";
    }
}
