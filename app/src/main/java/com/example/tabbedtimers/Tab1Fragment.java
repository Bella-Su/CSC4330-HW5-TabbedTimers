//====================================================================
//
// Application: Tabbed Timers
// Class:    Tab1Fragment
// Description:
//   This Android class implement activities for timer
//
//====================================================================
package com.example.tabbedtimers;

// Import packages
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

//--------------------------------------------------------------------
// class Tab1Fragment
//--------------------------------------------------------------------
public class Tab1Fragment extends Fragment
{
    //Declare constants and variables
    public static EditText txtTimerValue;

    //----------------------------------------------------------------
    // Tab1Fragment Constructor
    //   No-parameter constructor is required.
    //----------------------------------------------------------------
    public Tab1Fragment() {}

    //----------------------------------------------------------------
    // onCreateView
    //----------------------------------------------------------------
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        //Inflate view
        View view = inflater.inflate(R.layout.laytimer, container,false);

        //Connect to and set controls
        txtTimerValue = view.findViewById(R.id.txtTimerValue);

        //Return view
        return view;
    }

    //----------------------------------------------------------------
    // timerTaskHandler
    //----------------------------------------------------------------
    public static Handler timeTaskHandler1 = new Handler(Looper.getMainLooper())
    {
        //HandleMessage
        @Override
        public void handleMessage(Message msg)
        {
            //Update timer text box
            txtTimerValue.setText(String.valueOf(Shared.Data.sharedTimerCurrent));
        }
    };

}