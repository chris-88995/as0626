package com.example.as0622;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button buttonlow;
    private Button buttonhigh;
    private Button buttonright;
    private TextView random;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonhigh=(Button) findViewById(R.id.buttonhigh);
        buttonlow=(Button) findViewById(R.id.buttonlow);
        buttonright=(Button) findViewById(R.id.buttonright);
        random=(TextView) findViewById(R.id.random);
        textView2=(TextView) findViewById(R.id.textView2);
        class Game implements Runnable {

            int max=999;
            int min=1;
            int ran=0;
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        max=999;
                        min=1;
                        ran=0;

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                ran=(int)(Math.random()* max + min);
                               random.setText(""+ran);
                            }
                        });

                        buttonlow.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        min=ran;
                                        ran=(int)(Math.random()* (max-min) + min);
                                        random.setText(""+ran);
                                        textView2.setText("現在範圍為"+min+"~"+max);
                                    }
                                }
                        );
                        buttonhigh.setOnClickListener(new View.OnClickListener() {
                            @Override

                            public void onClick(View v) {
                                max=ran;
                                ran=(int)(Math.random()* (max-min) + min);;
                                random.setText(""+ran);
                                textView2.setText("現在範圍為"+min+"~"+max);
                            }
                        }

                        );
                        buttonright.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                random.setText("遊戲結束");
                                textView2.setText("你心中想的數字是"+ran);
                            }
                        }

                        );

                        //


                    }
                }).start();
            }
        }

        Game game = new Game();
        game.run();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meunu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.restart) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        } else if (id == R.id.exit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
}
}
/*package com.example.as0622;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button buttonlow;
    private Button buttonhigh;
    private Button buttonright;
    private TextView random;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonhigh=(Button) findViewById(R.id.buttonhigh);
        buttonlow=(Button) findViewById(R.id.buttonlow);
        buttonright=(Button) findViewById(R.id.buttonright);
        random=(TextView) findViewById(R.id.random);
    class game implements  Runnable{
        int max=999;
        int min=1;
        int ran=0;

        @Override

        public void run(){
            ran=(int)(Math.random()* 999 + 1);
            random.setText(""+ran);
            buttonlow.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    max=ran;
                    ran=(int)(Math.random()* max + min);;
                    random.setText(""+ran);
                }
            }

            );
            buttonhigh.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    min=ran;
                    ran=(int)(Math.random()* max + min);;
                    random.setText(""+ran);
                }
            }

            );
            buttonright.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    random.setText("恭喜我拔");
                }
            }

            );

        }
    }



    }



}*/