package sumTest;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import jeremysiocon.lab3.MainActivity;
import jeremysiocon.lab3.R;

/**
 * Created by Jeremy on 4/17/2016.
 */
public class JUnit_Test extends ActivityInstrumentationTestCase2<MainActivity>{

    MainActivity testActivity;

    public JUnit_Test () {

        super(MainActivity.class);
    }

    @UiThreadTest
    public void test_sum() {

        testActivity = getActivity();

        Button addButton = (Button) testActivity.findViewById(R.id.add_button);
        EditText numOne = (EditText) testActivity.findViewById(R.id.num1);
        EditText numTwo = (EditText) testActivity.findViewById(R.id.num2);
        TextView sumNum = (TextView) testActivity.findViewById(R.id.sum);

        numOne.setText("3");
        numTwo.setText("2");

        addButton.performClick();

        String Tester = sumNum.getText().toString();

        assertEquals("5", Tester);

        numOne.setText("400");
        numTwo.setText("250");

        addButton.performClick();

        Tester = sumNum.getText().toString();

        assertEquals("650", Tester);

        numOne.setText("-5");
        numTwo.setText("5");

        addButton.performClick();

        Tester = sumNum.getText().toString();

        assertEquals("0", Tester);
    }
}
