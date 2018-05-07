package com.ggg.espressoexample;

import android.support.annotation.StringRes;
import android.support.design.widget.TextInputLayout;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ggg.espressoexample.login.LoginActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.core.IsNot.not;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ajea on 24/04/18.
 */

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void doSuccesLogin(){
        onView(withId(R.id.edit_email))
                .perform(typeText("test@ggg.com.mx"), closeSoftKeyboard());

        onView(withId(R.id.button_next))
                .perform(click());
    }

    @Test
    public void validateEmptyEmail(){

        onView(withId(R.id.button_next))
                .perform(click());

        onView(withId(R.id.input_email))
                .check(matches(withError("Debes ingresar tu correo electrónico.")));

    }

    @Test
    public void loginFailed() {
        onView(withId(R.id.edit_email))
                .perform(typeText("incorrect@email.com"), closeSoftKeyboard());

        onView(withId(R.id.button_next))
                .perform(click());

        onView(withText(getString(R.string.error_login_failed)))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }




    /**
     * Obtain String Resource by id
     * **/
    private String getString(@StringRes int resourceId) {
        return mActivityRule.getActivity().getString(resourceId);
    }

    /**
     * Custom Espresso matcher for TextInputLayout error
     * **/
    private static Matcher withError(final String expected) {
        return new TypeSafeMatcher() {
            @Override
            protected boolean matchesSafely(Object item) {
                if (item instanceof TextInputLayout) {
                    return ((TextInputLayout)item).getError().toString().equals(expected);
                }
                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Not found error message [" + expected + "]");
            }
        };
    }
}
