//====================================================================
//
// Application: Tabbed Timers
// Activity:    ActMain
// Description:
//          This application allows user to use timer and countdown
//
//====================================================================
package com.example.tabbedtimers;
// Import packages
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.tabs.TabLayout;
import java.util.Timer;

public class ActMain extends AppCompatActivity {

    //----------------------------------------------------------------
    // Constants and variables
    //----------------------------------------------------------------

    public static final String APP_NAME = "Tabbed Timers";
    public static final String APP_VERSION = "1.0";
    public final int TIMER_VALUE_DEFAULT = 0;
    public final int CURRENT_DEFAULT = 10;
    public final int STARTING_DEFAULT = 10;
    private TabLayout tlMain;
    private ViewPager vpMain;

    //Declare other variables
    private Toolbar tbrMain;
    public static Timer timer1;
    public static Timer timer2;
    private AlertDialog.Builder builder;

    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laymain);

        //Define and connect to toolbar
        tbrMain = findViewById(R.id.tbrMain);
        setSupportActionBar(tbrMain);
        tbrMain.setNavigationIcon(R.mipmap.ic_launcher_new_round);

        // Connect to controls
        tlMain = findViewById(R.id.tlMain);
        vpMain = findViewById(R.id.vpMain);

        // Create tabs
        tlMain.addTab(tlMain.newTab().setText("TIMER"));
        tlMain.addTab(tlMain.newTab().setText("COUNTDOWN"));

        // Create adapter
        final FragmentPagerAdapterMain fpaMain =
                new FragmentPagerAdapterMain(
                        this,
                        getSupportFragmentManager(),
                        tlMain.getTabCount());
        vpMain.setAdapter(fpaMain);

        // Define listeners
        tlMain.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener()
                {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab)
                    {
                        vpMain.setCurrentItem(tab.getPosition());
                    }
                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {}
                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {}
                });
        vpMain.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tlMain));
    }

    //----------------------------------------------------------------
    // Start timer
    //----------------------------------------------------------------

    public void startTimer(View view)
    {
        //Cancel timer if exists
        if(timer1 != null)
            timer1.cancel();

        //Schedule a time task
        timer1 = new Timer();
        timer1.schedule(new TimerTask1(),0,1000);

        //Show toast message that timer was started
        Toast.makeText(getApplicationContext(), "Timer started.", Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------
    // Stop timer
    //----------------------------------------------------------------

    public void stopTimer(View view)
    {
        //Cancel timer if exists
        if(timer1 != null)
            timer1.cancel();
        timer1 = null;

        //Show toast message
        Toast.makeText(getApplicationContext(), " Timer stopped.", Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------
    // Reset timer
    //----------------------------------------------------------------

    public void resetTimer(View view)
    {
        //Reset the timer value
        Shared.Data.sharedTimerCurrent = TIMER_VALUE_DEFAULT;
        Tab1Fragment.timeTaskHandler1.sendEmptyMessage(0);

        //Show toast message
        Toast.makeText(getApplicationContext(),"Timer reset.", Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------
    // Start countdown
    //----------------------------------------------------------------

    public void startCountdown(View view)
    {
        //Cancel timer if exists
        if(timer2 != null)
            timer2.cancel();

        //Create and start timer
        timer2 = new Timer();
        timer2.schedule(new TimerTask2(), 0, 1000);

        //Show toast message
        Toast.makeText(getApplicationContext(),"Countdown started.", Toast.LENGTH_SHORT).show();

    }

    //----------------------------------------------------------------
    // Stop countdown
    //----------------------------------------------------------------

    public void stopCountdown(View view)
    {
        //Cancel timer if exists
        if(timer2 != null)
            timer2.cancel();
        timer2 = null;

        //Show toast message
        Toast.makeText(getApplicationContext(),"Countdown stopped.", Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------
    // Reset countdown
    //----------------------------------------------------------------

    public void resetCountdown(View view) {
        //Reset values
        Shared.Data.sharedCountdownStart = STARTING_DEFAULT;
        Shared.Data.SharedCountdownCurrent = CURRENT_DEFAULT;
        Tab2Fragment.timerTaskHandler2.sendEmptyMessage(0);

        //Show toast message
        Toast.makeText(getApplicationContext(),"Countdown reset.", Toast.LENGTH_SHORT).show();
    }
}