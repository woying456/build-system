/*
 * Copyright (C) 2008 The Android Open Source Project
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

package com.android.tests.libstest.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    private TextView mAppTextView1;
    private TextView mAppTextView2;
    private TextView mLib1TextView1;
    private TextView mLib1TextView2;


    @Before
    public void setUp() throws Exception {
        final MainActivity a = rule.getActivity();
        // ensure a valid handle to the activity has been returned
        assertNotNull(a);

        mAppTextView1 = (TextView) a.findViewById(R.id.app_text1);
        mAppTextView2 = (TextView) a.findViewById(R.id.app_text1);
        mLib1TextView1 = (TextView) a.findViewById(R.id.lib1_text1);
        mLib1TextView2 = (TextView) a.findViewById(R.id.lib1_text2);
    }

    /**
     * The name 'test preconditions' is a convention to signal that if this test doesn't pass, the
     * test case was not set up properly and it might explain any and all failures in other tests.
     * This is not guaranteed to run before other tests, as junit uses reflection to find the tests.
     */
    @Test
    @MediumTest
    public void testPreconditions() {
        assertNotNull(mAppTextView1);
        assertNotNull(mAppTextView2);
        assertNotNull(mLib1TextView1);
        assertNotNull(mLib1TextView2);
    }

    @Test
    @MediumTest
    public void testAndroidStrings() {
        assertEquals("SUCCESS-APP", mAppTextView1.getText().toString());
        assertEquals("SUCCESS-LIB1", mLib1TextView1.getText().toString());
    }

    @Test
    @MediumTest
    public void testJavaStrings() {
        assertEquals("SUCCESS-APP", mAppTextView2.getText().toString());
        assertEquals("SUCCESS-LIB1", mLib1TextView2.getText().toString());
    }
}
