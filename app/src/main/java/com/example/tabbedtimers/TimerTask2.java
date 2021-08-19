//====================================================================
//
// Application: Tabbed Timers
// Class: TimerTask2
// Description:
//   This Android class represents a timer task that runs once per
// second, updates the shared data, and signals that the main screen
// should update the screen.  The updates include:
//   -current countdown value.
//
//====================================================================
package com.example.tabbedtimers;

import java.util.TimerTask;

//--------------------------------------------------------------------
// class Task
//--------------------------------------------------------------------
public class TimerTask2 extends TimerTask
{
    //----------------------------------------------------------------
    // run
    //----------------------------------------------------------------
    public void run()
    {
        //Update shared value
        if(Shared.Data.SharedCountdownCurrent > 0)
            Shared.Data.SharedCountdownCurrent = Shared.Data.SharedCountdownCurrent - 1;

        //Test if message set
        if(Tab2Fragment.timerTaskHandler2.sendEmptyMessage(0))
            System.out.println("[Task] Timer task " + "message sent to main thread.");
        else
            System.out.println("[Task] Error: " + "timer task message NOT sent to main thread.");
    }
}
