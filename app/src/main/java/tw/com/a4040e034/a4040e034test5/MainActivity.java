package tw.com.a4040e034.a4040e034test5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText t;
    private EditText e;
    private EditText m;
    private EditText f;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews() {
        submit = (Button) findViewById(R.id.submit);
        t = (EditText) findViewById(R.id.t);
        e = (EditText) findViewById(R.id.e);
        m = (EditText) findViewById(R.id.m);
        f = (EditText) findViewById(R.id.f);


    }

    private boolean isValid(EditText editText) {
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();
        if (!text.matches(pattern)) {
            editText.setError("0  ~  100");
            return false;
        } else {
            return true;
        }
    }

    public void onSubmitClick(View view){
        boolean isValid =
                isValid(t) & isValid(e) & isValid(m) & isValid(f);
        if (!isValid){
            return;
        }
        Button nextPageBtn = (Button)findViewById(R.id.submit);
        nextPageBtn.setOnClickListener(new View.OnClickListener(){
                                           @Override
                                           public void onClick(View v){
                                               Intent intent = new Intent();
                                               Bundle bundle = new Bundle();
                                               int a1= Integer.parseInt(t.getText().toString());//轉成數字型態
                                               int a2= Integer.parseInt(e.getText().toString());
                                               int a3= Integer.parseInt(m.getText().toString());
                                               int a4= Integer.parseInt(f.getText().toString());
                                               int sum = a1+a2+a3+a4;
                                               float average = sum/4;
           /*bundle.putString("這個變數名稱",哪來的資料);*/
                                               bundle.putString("show1",t.getText().toString());//國
                                               bundle.putString("show2",e.getText().toString());//英
                                               bundle.putString("show3",m.getText().toString());//數
                                               bundle.putString("show4",f.getText().toString());//android
                                               bundle.putInt("show5",sum);//總和
                                               bundle.putFloat("show6",average);//平均


                                               intent.setClass(MainActivity.this ,Main2Activity.class);
                                               intent.putExtras(bundle);
                                               startActivity(intent);
                                           }
                                       }

        );

    }
}
