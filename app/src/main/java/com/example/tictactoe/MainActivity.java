package com.example.tictactoe;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Boolean gameActive = true;
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //if gameState is 2 Null, 0 -x ,1 - o

    int[][] winPositions= {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6} };


    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage =  Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            resetGame(view);
            return;
        }
        if(gameState[tappedImage] == 2 && gameActive){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer ==0){
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer =0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
            img.animate().translationY(0).setDuration(300);
            String winner;
            for (int [] winPositon : winPositions) {
                if (gameState[winPositon[0]] == gameState[winPositon[1]] &&
                        gameState[winPositon[1]] == gameState[winPositon[2]] &&
                        gameState[winPositon[0]] != 2) {
                    if (gameState[winPositon[0]] == 0) {
                        winner = "X has won";
                    } else {
                        winner = "O Has won";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winner);
                    gameActive = false;
                    return;
                }
            }
            int count = 0;
            for(int i : gameState){
                if(i==2){
                    count++;
                }
            }
            if(count == 0) {
                TextView status = findViewById(R.id.status);
                status.setText("Game tie No resutls!!");
                gameActive =false;
            }

        }

    }
    public void resetGame(View view){
        gameActive = true;
        activePlayer = 0;
        gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
