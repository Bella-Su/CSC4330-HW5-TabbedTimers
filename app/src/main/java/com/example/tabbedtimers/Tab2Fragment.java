//====================================================================
//
// Application: Tabbed Timers
// Class:    Tab2Fragment
// Description:
//   This Android class implement activities for countdown
//
//====================================================================
package com.example.tabbedtimers;

// Import packages
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

//--------------------------------------------------------------------
// class Tab2Fragment
//--------------------------------------------------------------------
public class Tab2Fragment extends Fragment
{
    //Declare constants and variables
    public static EditText txtStartingCountdownValue;
    public static EditText txtCurrentCountdownValue;

    //----------------------------------------------------------------
    // Tab2Fragment Constructor
    //   No-parameter constructor is required.
    //----------------------------------------------------------------
    public Tab2Fragment() {}

    //----------------------------------------------------------------
    // onCreateView
    //----------------------------------------------------------------
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        //Inflate view
        View view = inflater.inflate(R.layout.laycountdown, container,false);

        //Connect to and set controls
        txtStartingCountdownValue = view.findViewById(R.id.txtStartingCountdownValue);
        txtCurrentCountdownValue = view.findViewById(R.id.txtCurrentCountdownValue);

        //Put value into starting countdown value text box
        txtStartingCountdownValue.setText(String.valueOf(Shared.Data.sharedCountdownStart));
        txtCurrentCountdownValue.setText(String.valueOf(Shared.Data.sharedCountdownStart));

        //Add listener for starting countdown value changes
        txtStartingCountdownValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Shared.Data.SharedCountdownCurrent = Integer.valueOf(s.toString());


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Shared.Data.SharedCountdownCurrent = Shared.Data.sharedCountdownStart;


        //Return view
        return view;
    }

    //----------------------------------------------------------------
    // timerTaskHandler
    //----------------------------------------------------------------
    public static Handler timerTaskHandler2 = new Handler(Looper.getMainLooper())
    {
        //------------------------------------------------------------
        // handleMessage
        //------------------------------------------------------------
        @Override
        public void handleMessage(Message msg)
        {
            //Update current countdown box
            txtCurrentCountdownValue.setText(String.valueOf(Shared.Data.SharedCountdownCurrent));
        }
    };
}
