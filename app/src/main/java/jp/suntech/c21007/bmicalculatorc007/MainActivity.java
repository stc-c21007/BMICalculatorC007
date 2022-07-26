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
                    int color = 0;
                    float t = 0;
                    float hyo = 0;

                    float m = c_he / 100;



                    if(i_age < 6){
                        //6歳未満はカウプ指数
                        //カウプ指数の計算
                        float kau = c_we / (m * m);
                        if(i_age < 1){
                            if(kau < 16){
                                output2.setText("やせすぎ");
                                color = Color.rgb(2, 255,2);
                            }
                            else if(kau < 18){
                                output2.setText("普通");
                                color = Color.rgb(200, 22,230);
                            }
                            else{
                                output2.setText("太りぎみ");
                                color = Color.rgb(20, 22,102);
                            }
                            hyo = 17F;
                        }
                        else if(i_age < 2){
                            if(kau < 15.5){
                                output2.setText("やせすぎ");
                                color = Color.rgb(20, 255,20);
                            }
                            else if(kau < 17.5){
                                output2.setText("普通");
                                color = Color.rgb(100, 102,202);
                            }
                            else{
                                output2.setText("太りぎみ");
                                color = Color.rgb(120, 130,140);
                            }
                            hyo = 16.5F;
                        }
                        else if(i_age < 3){
                            if(kau < 13.5){
                                output2.setText("やせすぎ");
                                color = Color.rgb(30, 255,30);
                            }
                            else if(kau < 15){
                                output2.setText("やせぎみ");
                                color = Color.rgb(120, 200,102);
                            }
                            else if(kau < 17){
                                output2.setText("普通");
                                color = Color.rgb(50, 102,102);
                            }
                            else if(kau < 18.5){
                                output2.setText("太りぎみ");
                                color = Color.rgb(99, 92,32);
                            }
                            else{
                                output2.setText("太りすぎ");
                                color = Color.rgb(250, 40,40);
                            }
                            hyo = 16F;
                        }
                        else if(i_age < 4){
                            if(kau < 13.5){
                                output2.setText("やせすぎ");
                                color = Color.rgb(40, 250,40);
                            }
                            else if(kau < 14.5){
                                output2.setText("やせぎみ");
                                color = Color.rgb(132, 111,23);
                            }
                            else if(kau < 16.5){
                                output2.setText("普通");
                                color = Color.rgb(50, 50,45);
                            }
                            else if(kau < 18){
                                output2.setText("太りぎみ");
                                color = Color.rgb(30, 23,23);
                            }
                            else{
                                output2.setText("太りすぎ");
                                color = Color.rgb(250, 30,30);
                            }
                            hyo = 15.5F;
                        }
                        else if(i_age < 5){
                            if(kau < 13){
                                output2.setText("やせすぎ");
                                color = Color.rgb(50, 250,50);
                            }
                            else if(kau < 14.5){
                                output2.setText("やせぎみ");
                                color = Color.rgb(200, 222,102);
                            }
                            else if(kau < 16.5){
                                output2.setText("普通");
                                color = Color.rgb(20, 200,230);
                            }
                            else if(kau < 18){
                                output2.setText("太りぎみ");
                                color = Color.rgb(29, 29,25);
                            }
                            else{
                                output2.setText("太りすぎ");
                                color = Color.rgb(250, 20,20);
                            }
                            hyo = 15.5F;
                        }
                        else if(i_age < 6){
                            if(kau < 13){
                                output2.setText("やせすぎ");
                                color = Color.rgb(60, 250,60);
                            }
                            else if(kau < 14.5){
                                output2.setText("やせぎみ");
                                color = Color.rgb(245, 13,142);
                            }
                            else if(kau < 16.5){
                                output2.setText("普通");
                                color = Color.rgb(200, 31,213);
                            }
                            else if(kau < 18.5){
                                output2.setText("太りぎみ");
                                color = Color.rgb(64, 12,92);
                            }
                            else{
                                output2.setText("太りすぎ");
                                color = Color.rgb(250, 2,2);
                            }
                            hyo = 15.5F;
                        }
                        t = hyo * m * m;
                    }
                    else if(i_age < 16){ //6～15はローレル指数
                        float ro = c_we / (m * m * m) * 10;
                        t = (m * m * m) / 10 * 130;

                        if(ro < 100){
                            output2.setText("やせすぎ");
                            color = Color.rgb(200, 120,132);
                        }
                        else if(ro < 115){
                            output2.setText("やせてる");
                            color = Color.rgb(200, 122,202);
                        }
                        else if(ro < 145){
                            output2.setText("ふつう");
                            color = Color.rgb(10, 202,23);
                        }
                        else if(ro < 160){
                            output2.setText("ふとっている");
                            color = Color.rgb(123, 92,29);
                        }
                        else{
                            output2.setText("ふとりすぎ");
                            color = Color.rgb(39, 202,202);
                        }
                    }
                    else{
                        //BMIの計算
                        c_bmi = c_we / (m * m);
                        //適正体重の計算
                        t = 22 * m * m;

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
                    }

                    output4.setText(String.format("%.1f", t));

                    //表示
                    output1.setText(R.string.t_hi);
//                    output2.setText(R.string.t_han2_bmi);
                    output3.setText(R.string.t_tek);
//                    output4.setText(R.string.t_w_bmi);
                    output5.setText(R.string.ts_kg);


                    if(i_age < 16){
                        new OrderConfirmDialogFragment().show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
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