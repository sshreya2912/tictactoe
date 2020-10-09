package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive=true;
    int activePlayer=0;
    int[] state={2,2,2,2,2,2,2,2,2};
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};


    public void tapchange(View view)
    {
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {
            gamereset(view);
        }
        else if(state[tappedImage]==2)
        {
            state[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("0's turn, tap where you wanna place 0");

            }
            else
            {
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's turn, tap where you wanna place X");
            }
        }
        img.animate().translationYBy(1000f).setDuration(300);
        for(int[] win: winPositions)
        {
          if(state[win[0]]==state[win[1]] && state[win[0]]==state[win[2]] && state[win[0]]!=2)
          {
              gameactive=false;

              String winnerStr;
              if(state[win[0]]==0)
              {
                  winnerStr="X has won!";

              }
              else
              {
                  winnerStr="0 has won!";


              }
              //update status
              TextView status=findViewById(R.id.status);
              status.setText(winnerStr);

          }

        }


    }

    public void gamereset(View view)
    {
        activePlayer=0;
        int[] state={2,2,2,2,2,2,2,2,2};
        gameactive=true;
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);

     return;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}