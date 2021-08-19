//====================================================================
//
// Application: Tabbed Timers
// Class: TimerTask1
// Description:
//   This Android class represents a timer task that runs once per
// second, updates the shared data, and signals that the main screen
// should update the screen.  The updates include:
//   -Timer value.
//
//====================================================================
package com.example.tabbedtimers;

// Import packages
import java.util.TimerTask;

//--------------------------------------------------------------------
// class Task
//--------------------------------------------------------------------
public class TimerTask1 extends TimerTask
{

    //--------------------------------------------------------------------
    // run
    //--------------------------------------------------------------------
    public void run()
    {
        //Update shared value
        Shared.Data.sharedTimerCurrent = Shared.Data.sharedTimerCurrent + 1;

        //Test if message set
        if(Tab1Fragment.timeTaskHandler1.sendEmptyMessage(0))
            System.out.println("[Task] Timer task " + "message sent to main thread.");
        else
            System.out.println("[Task] Error: " + "timer task message NOT sent to main thread.");
    }
}
