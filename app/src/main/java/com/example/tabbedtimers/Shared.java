//====================================================================
//
// Application: Tabbed Timers
// Class:    Shared
// Description:
//   This Android class holds data shared among threads.
//
//====================================================================
package com.example.tabbedtimers;

//--------------------------------------------------------------------
// enum Shared
//--------------------------------------------------------------------
public enum Shared
{
    //enum Shared
    Data;

    //Declare enum for timer
    public int sharedTimerCurrent;

    //Declare enum for countdown
    public int sharedCountdownStart = 10;
    public int SharedCountdownCurrent;
}
