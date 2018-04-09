package com.xxxxxx.android_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;

import com.xxxxxx.android_demo.activities.AuthenticationActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


import static org.junit.Assert.*;

public class ExampleInstrumentedTest {
    @Rule
    /* Launch Authentication Activity - Login View */// TODO: 1st attempt: System UI isn't responding  Close app/Wait
    public ActivityTestRule <AuthenticationActivity> activityActivityTestRule = new ActivityTestRule <AuthenticationActivity> ( AuthenticationActivity.class );

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext ();

        assertEquals ( "com.mytaxi.android_demo", appContext.getPackageName () );

        //Login valid credentials entered
        onView ( withId ( R.id.edt_username ) ).perform ( replaceText ( "username" ) );
        onView ( withId ( R.id.edt_password ) ).perform ( replaceText ( "pw" ) );

        //Validate Login button showing up and successfully clicked on
        onView ( withId ( R.id.btn_login ) ).check ( matches ( withText ( "Login" ) ) );
        onView ( withId ( R.id.btn_login ) ).perform ( click () );


        //Select valid Driver from Search List
        onView ( withId ( R.id.textSearch ) ).perform ( replaceText ( "Sara" ) );
        onView ( withText ( "Sarah F...." ) ).inRoot ( RootMatchers.isPlatformPopup () ).perform ( click () );
    }
}
