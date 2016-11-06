package tw.com.a4040e034.a4040e034test5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class Main2Activity extends AppCompatActivity {
private Button back;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back = (Button) findViewById(R.id.back);
        show = (TextView) findViewById(R.id.show);
        Bundle bundle = getIntent().getExtras();
        String text = "";
        text += "國文" + bundle.getString("show1") + "\n";
        text += "英文 " + bundle.getString("show2") + "\n";
        text += "數學 " + bundle.getString("show3") + "\n";
        text += "法文 " + bundle.getString("show4") + "\n";
        text += "總和" + bundle.getInt("show5") + "\n";
        text += "平均" + bundle.getFloat("show6") + "\n";
        show.setText(text);
        Button nextPageBtn = (Button)findViewById(R.id.back);
        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void bk(View view) {
        finish();
    }
}
