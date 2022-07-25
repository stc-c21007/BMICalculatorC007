package jp.suntech.c21007.bmicalculatorc007;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSend = findViewById(R.id.btzan);
        HelloListener listener = new HelloListener();   //リスナのインスタンス生成
        btSend.setOnClickListener(listener);           //ボタンにリスナを組み込む

        Button btClear = findViewById(R.id.btclear);
        btClear.setOnClickListener(listener);
    }

    //リスナ・クラス <= イベントの監視
    private class HelloListener implements View.OnClickListener{

        //イベントハンドラ <= イベント発生時の処理
        @Override
        public void onClick(View view) {
            //トーストメッセージ用文字列変数を用意
            String msg = "";
            //名前入力欄であるEditTextオブジェクトを取得
            EditText input1 = findViewById(R.id.ageText);
            EditText input2 = findViewById(R.id.heText);
            EditText input3 = findViewById(R.id.weText);
            //メッセージを送信するTextViewオブジェクトを取得
            TextView output1 = findViewById(R.id.thi);
            TextView output2 = findViewById(R.id.text4);
            TextView output3 = findViewById(R.id.ttek);
            TextView output4 = findViewById(R.id.twbmi);
            TextView output5 = findViewById(R.id.textView9);



            //タップされた画面部品のidのR値を取得
            int id  = view.getId();

            String inputStr1 = input1.getText().toString();
            String inputStr2 = input2.getText().toString();
            String inputStr3 = input3.getText().toString();

            //idのR値に応じて処理を分岐
            switch (id){
                //計算ボタンの場合・・・
                case R.id.btzan:
                    float c_bmi;
                    int i_age = Integer.parseInt(inputStr1);
                    float c_he = Float.parseFloat(inputStr2);
                    float c_we = Float.parseFloat(inputStr3);
                    int color;

                    if(i_age < 16){
                        new OrderConfirmDialogFragment().show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
                    }

                    //BMIの計算
                    float m = c_he / 100;
                    c_bmi = c_we / (m * m);

                    //適正体重の計算
                    float t = 22 * m * m;

                    output4.setText(String.format("%.1f", t));

                    //表示
                    output1.setText(R.string.t_hi);
//                    output2.setText(R.string.t_han2_bmi);
                    output3.setText(R.string.t_tek);
//                    output4.setText(R.string.t_w_bmi);
                    output5.setText(R.string.ts_kg);

                    if(c_bmi < 18.5){
                        output2.setText(R.string.t_han1_bmi);
                        color = Color.BLUE;
                    }
                    else if(c_bmi < 25){
                        output2.setText(R.string.t_han2_bmi);
                        color = Color.GREEN;
                    }
                    else if(c_bmi < 30){
                        output2.setText(R.string.t_han3_bmi);
                        color = Color.GRAY;
                    }
                    else if(c_bmi < 35){
                        output2.setText(R.string.t_han4_bmi);
                        color = Color.CYAN;
                    }
                    else if(c_bmi < 40){
                        output2.setText(R.string.t_han5_bmi);
                        color = Color.YELLOW;
                    }
                    else{
                        output2.setText(R.string.t_han6_bmi);
                        color = Color.RED;
                    }

                    output2.setTextColor(color);

                    //メッセージを表示
//                    Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_LONG).show();
                    break;

                //クリアボタンの場合・・・
                case R.id.btclear:
                    input1.setText("");
                    input2.setText("");
                    input3.setText("");

                    output1.setText("");
                    output2.setText("");
                    output3.setText("");
                    output4.setText("");
                    output5.setText("");
                    break;
            }

        }
    }
}