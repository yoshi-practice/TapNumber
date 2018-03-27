//package名
package com.lifeistech.android.techdragon;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.media.AudioAttributes;
import android.media.SoundPool;


public class MainActivity extends Activity {
    int hp;
    TextView hpTextView;
    ImageView MenterImageView;
    TextView damageTextView;
    int stageNum;
    int[] hairetu;
    String mondai;
    int seikai;
    TextView textView;
    private TextView MenterTextView;
    private ProgressBar progressBar;
    int timeLimit = 0;
    private int  missgauge = 0;
    private SoundPool soundPool;
    private int soundOne;
    private Handler handler;
    String menterName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stageNum = getIntent().getIntExtra("stage", 0); //ステージ名
        hpTextView = (TextView) findViewById(R.id.hpTextView); //相手HP
        progressBar = (ProgressBar)findViewById(R.id.progressBar);//タイムリミット
        MenterImageView = (ImageView) findViewById(R.id.menterImageView); //相手画像
        damageTextView = (TextView) findViewById(R.id.damageTextView); //アニメーション表示用
        MenterTextView = (TextView) findViewById(R.id.MenterTextView); //相手名
        textView = (TextView) findViewById(R.id.numbertextView); //数字を表示
        start();

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                // USAGE_MEDIA
                // USAGE_GAME
                .setUsage(AudioAttributes.USAGE_GAME)
                // CONTENT_TYPE_MUSIC
                // CONTENT_TYPE_SPEECH, etc.
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        soundPool = new SoundPool.Builder()
//                .setAudioAttributes(audioAttributes)
                // ストリーム数に応じて
                .setMaxStreams(1)
                .build();

        // one.wav をロードしておく
        soundOne = soundPool.load(this, R.raw.errorsound, 1);


        // load が終わったか確認する場合
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Log.d("debug","sampleId="+sampleId);
                Log.d("debug","status="+status);
            }
        });
        



        /*//非同期処理　並行処理みたいな？
        final Handler handler = new Handler();
        //別の場所で動かす
        //postは非同期処理を投げる おわったら休んでていいよみたいな感じ
        handler.post(new Runnable() {
            @Override
            public void run() {
                count++;
                Log.d("Handler", count + "残り" + count + "秒");
                //count~~ で何秒まで動かす

                if (count < 10) {
                    //1000m秒=1秒
                    handler.postDelayed(this, 10000);
                }
            }
        });
            //ここのHandlerはAndroid.osの方
            */


        // 選択したステージによって敵を切り替える
        switch (stageNum) {
            case 0: // 異常
                finish();
                break;

            case 1: // ステージ1
                hp = 200;
                MenterImageView.setImageResource(R.drawable.chara2);
                menterName = ("じゃすてぃん");
                timeLimit = 50;
                break;

            case 2: // ステージ2
                hp = 300;
                MenterImageView.setImageResource(R.drawable.tsuyoppe);
                menterName = ("つよっぺ");
                timeLimit = 60;
                break;

            case 3: // ステージ3
                hp = 500;
                MenterImageView.setImageResource(R.drawable.nakami);
                menterName = ("なかみそ");
                timeLimit = 60;
                break;

            case 4: // ステージ4
                hp = 800;
            MenterImageView.setImageResource(R.drawable.tyaarii);
                menterName = ("ちゃらーりー");
                timeLimit = 65;
                break;
            case 5:
                hp = 1000;
                MenterImageView.setImageResource(R.drawable.chara);
                menterName = ("ヤスタカ");
                timeLimit = 65;
                break;
            case 6:
                hp = 1200;
                MenterImageView.setImageResource(R.drawable.camaerasan);
                menterName = ("ゆうちゃん");
                timeLimit = 70;
                break;
            case 7:
                hp = 1400;
                MenterImageView.setImageResource(R.drawable.kaaki);
                menterName = ("カーキ");
                timeLimit = 70;
                break;
            case 8:
                hp = 1500;
                MenterImageView.setImageResource(R.drawable.paakaa);
                menterName = ("ぱーかー");
                Toast.makeText(this, "みんなのアイドル、\nぱーかーが現れた！", Toast.LENGTH_SHORT).show();
                timeLimit = 75;
                break;
            case 9:
                hp = 1700;
                MenterImageView.setImageResource(R.drawable.kataguruma);
                menterName = ("めんたーず");
                timeLimit = 75;
                break;
            case 2000:
                hp = 50000;
                MenterImageView.setImageResource(R.drawable.paakaa2);
                menterName = ("けだるげぱーかー");
                timeLimit = 80;
                break;

            case 11:
                hp = 2200;
                MenterImageView.setImageResource(R.drawable.ao);
                menterName = ("あおちゃん");
                timeLimit = 90;
                break;

            case 12:
                hp = 2400;
                MenterImageView.setImageResource(R.drawable.asahi);
                menterName = ("あさひ");
                timeLimit = 95;
                break;

            case 13:
                hp = 2600;
                MenterImageView.setImageResource(R.drawable.sakopon);
                menterName = ("さこぽん");
                timeLimit = 100;
                break;

            case 14:
                hp = 2800;
                MenterImageView.setImageResource(R.drawable.say);
                menterName = ("うみんちゅ");
                timeLimit =110;
                break;


            case 15:
                hp = 2900;
                MenterImageView.setImageResource(R.drawable.chara3);
                menterName = ("まるちゃん");
                timeLimit = 120;
                break;
            case 16:
                hp = 3000;
                MenterImageView.setImageResource(R.drawable.ikasandayo);
                menterName = ("さぬいちゃん");
                timeLimit = 130;
                break;
            case 17:
                hp = 5000;
                MenterImageView.setImageResource(R.drawable.ukkari);
                menterName = ("うっかりぽん");
                timeLimit = 200;
        }

        hpTextView.setText(String.valueOf(hp));
        MenterTextView.setText(menterName);
        if(stageNum != 8){
            Toast.makeText(this,menterName + "が現れた！",Toast.LENGTH_SHORT).show();
        }
        soundPool.play(soundOne,1.0f,1.0f,0,0,1);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
            timeLimit--;

                progressBar.setProgress(timeLimit);
                //count~~ で何秒まで動かす
                if (timeLimit > 0) {
                    //1000m秒=1秒
                    handler.postDelayed(this, 1000);
                }else{
                    Intent intent = new Intent(MainActivity.this,GameoverActivity.class);
                    startActivity(intent);
                }
            }
        });
        progressBar.setMax(timeLimit);
    }


    // 攻撃アニメーション
    public void damageAnimation() {
        damageTextView.setText(String.valueOf(100));
        AttackAnimation attackAnim = new AttackAnimation(this.getApplicationContext(), MenterImageView, damageTextView);
        MenterImageView.startAnimation(attackAnim);
    }    

    // 消滅アニメーション
    public void clearAnimation() {
        AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.0f);
        alphaAnim.setDuration(1500);
        alphaAnim.setStartOffset(1500);
        alphaAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation anim) {
            }

            @Override
            public void onAnimationRepeat(Animation anim) {
            }

            @Override
            public void onAnimationEnd(Animation anim) {
                MenterImageView.setVisibility(View.INVISIBLE);
            }
        });
        MenterImageView.startAnimation(alphaAnim);
    }

    // 配列
    public void start() {
        Random rand = new Random();
        hairetu = new int[20];
        hairetu[0] = rand.nextInt(9) + 1;
        hairetu[1] = rand.nextInt(9) + 1;
        hairetu[2] = rand.nextInt(9) + 1;
        hairetu[3] = rand.nextInt(9) + 1;
        hairetu[4] = rand.nextInt(9) + 1;
        hairetu[5] = rand.nextInt(9) + 1;
        hairetu[6] = rand.nextInt(9) + 1;
        hairetu[7] = rand.nextInt(9) + 1;
        hairetu[8] = rand.nextInt(9) + 1;
        hairetu[9] = rand.nextInt(9) + 1;
        hairetu[10] = rand.nextInt(9) + 1;
        hairetu[11] = rand.nextInt(9) + 1;
        hairetu[12] = rand.nextInt(9) + 1;
        hairetu[13] = rand.nextInt(9) + 1;
        hairetu[14] = rand.nextInt(9) + 1;
        hairetu[15] = rand.nextInt(9) + 1;
        hairetu[16] = rand.nextInt(9) + 1;
        hairetu[17] = rand.nextInt(9) + 1;
        hairetu[18] = rand.nextInt(9) + 1;
        hairetu[19] = rand.nextInt(9) + 1;


        mondai = Integer.toString(hairetu[0])
                + Integer.toString(hairetu[1])
                + Integer.toString(hairetu[2])
                + Integer.toString(hairetu[3])
                + Integer.toString(hairetu[4])
                + Integer.toString(hairetu[5])
                + Integer.toString(hairetu[6])
                + Integer.toString(hairetu[7])
                + Integer.toString(hairetu[8])
                + Integer.toString(hairetu[9])
                + Integer.toString(hairetu[10])
                + Integer.toString(hairetu[11])
                + Integer.toString(hairetu[12])
                + Integer.toString(hairetu[13])
                + Integer.toString(hairetu[14])
                + Integer.toString(hairetu[15])
                + Integer.toString(hairetu[16])
                + Integer.toString(hairetu[17])
                + Integer.toString(hairetu[18])
                + Integer.toString(hairetu[19]);
        textView.setText(mondai);
        seikai = 0;
    }

    // 1を押したとき
    public void number1(View v) {
        if (hairetu[seikai] == 1) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;

            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp-100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this,clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);
            }
        }
    // 2を押したとき
    public void number2(View v) {
        if (hairetu[seikai] == 2) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;


            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp -100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this, clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);
        }
    }

    // 3を押したとき
    public void number3(View v) {
        if (hairetu[seikai] == 3) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;

            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp-100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this,clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);
        }
    }

    // 4を押したとき
    public void number4(View v) {
        if (hairetu[seikai] == 4) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;


            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp-100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this,clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);
        }
    }

    // 5を押したとき
    public void number5(View v) {
        if (hairetu[seikai] == 5) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;


            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp-100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this,clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);
        }
    }

    // 6を押したとき
    public void number6(View v) {
        if (hairetu[seikai] == 6) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;

            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp-100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this,clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);
        }
    }

    // 7を押したとき
    public void number7(View v) {
        if (hairetu[seikai] == 7) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;


            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp-100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this,clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);
        }
    }

    // 8を押したとき
    public void number8(View v) {
        if (hairetu[seikai] == 8) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;


            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp-100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this,clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);

        }
    }

    // 9を押したとき
    public void number9(View v) {
        if (hairetu[seikai] == 9) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;

            if (seikai == 20) {
                start();
                timeLimit = timeLimit + 5;
                progressBar.setProgress(timeLimit);
                hp = hp-100;
                hpTextView.setText(String.valueOf(hp));
                Toast.makeText(this, "ATTACK!!", Toast.LENGTH_SHORT).show();
                damageAnimation();
                if(hp <= 0 && missgauge == 0){
                    Intent intent = new Intent(this,PerfectActivity.class);
                    startActivity(intent);
                }
                if (hp <= 0) {
                    clearAnimation();
                    Intent intent = new Intent(this,clearActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "MISS…", Toast.LENGTH_SHORT).show();
            missgauge = missgauge + 1;
            timeLimit= timeLimit - missgauge;
            progressBar.setProgress(timeLimit);

        }

    }


    @Override
    protected void onStop() {
        super.onStop();
        handler = null;
    }
}
