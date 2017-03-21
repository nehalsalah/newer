/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.app.Activity;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends Activity implements OnClickListener {
    // Tracks the score and foul for Team A
    int scoreTeamA = 0;
    int foulTeamA = 0;
    // Tracks the score and foul for Team B
    int scoreTeamB = 0;
    int foulTeamB = 0;
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.GoolA);
        b2=(Button)findViewById(R.id.GoolB);
        b3=(Button)findViewById(R.id.FoulA);
        b4=(Button)findViewById(R.id.FoulB);
        b5=(Button)findViewById(R.id.Rest);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
         int id=v.getId();
        switch(id) {
            case R.id.GoolA:
                scoreTeamA = scoreTeamA+1 ;
                displayForTeamA(scoreTeamA);
                break;

            case R.id.GoolB:
                scoreTeamB = scoreTeamB + 1;
                displayForTeamB(scoreTeamB);
                break;
            case R.id.FoulA:
                foulTeamA = foulTeamA + 1;
                displayFoulForTeamA(foulTeamA);
                break;

            case R.id.FoulB:
                foulTeamB = foulTeamB + 1;
                displayFoulForTeamB(foulTeamB);
                break;

            case R.id.Rest:
                scoreTeamA = 0;
                scoreTeamB = 0;
                foulTeamB = 0;
                foulTeamA = 0;
                displayForTeamA(scoreTeamA);
                displayFoulForTeamA(foulTeamA);
                displayForTeamB(scoreTeamB);
                displayFoulForTeamB(foulTeamB);
                break;
        }
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given foul for Team A.
     */
    public void displayFoulForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given foul for Team B.
     */
    public void displayFoulForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(score));
    }
}
