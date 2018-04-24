package commalindahcontactbook.httpsgithub.consecutivesumsandfactorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mUserInput;
    private TextView mResult;
    private TextView mErrorMessage;

    @Override
    /**
     * onCreate is the method that is executed when the Activity begins
     *
     * @param savedInstanceState is a Bundle of data used to restore the activity
     *                           from a previous instance
     * @return "" Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserInput = (EditText) findViewById(R.id.et_user_input);
        mResult = (TextView) findViewById(R.id.tv_result);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);

        mUserInput.addTextChangedListener( numberInputWatcher );
    }

    private final TextWatcher numberInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        /**
         * afterTextChanged is the method that is executed when the user enters text
         * into the Editable object
         *
         * @param editable is the Editable object the user types input into
         * @return "" Nothing is returned
         */
        public void afterTextChanged(Editable editable)
        {
            int userInput;
            int resultFromCalculation;

            if( editable.length() == 0 )
            {
                mResult.setText("");
                mErrorMessage.setText("You must enter a whole number to calculate the consecutive sum and factorial.");
            }
            else if( mUserInput.getText().toString().contains("-") )
            {
                mResult.setText("");
                mErrorMessage.setText("You cannot enter a negative number. It must be positive.");
            }
            else if( mUserInput.getText().toString().contains(".") )
            {
                mResult.setText("");
                mErrorMessage.setText("You cannot enter a decimal number. It must be a whole number.");
            }
            else
            {
                mErrorMessage.setText("");
                mResult.setText("");

                userInput = Integer.parseInt( mUserInput.getText().toString() );

                resultFromCalculation = consecutiveSumCalculator( userInput );

                mResult.append( "Consecutive Sum: " + resultFromCalculation );

                resultFromCalculation = factorialCalculator( userInput );

                mResult.append( "\n\nFactorial: " + resultFromCalculation );
            }
        }
    };

    //This is where the TextWatcher has closed

    /**
     * consecutiveSumCalculator calculates the consecutive sum from a number to 0 recursively
     * (calls itself multiple times to achieve a specific end)
     *
     * @param currentNumber is the current number of the consecutive sum as it counts down to zero
     * @return an integer that stores the consecutive sum result or intermediate numbers for
     *         the calculation of the consecutive sum
     */
    private int consecutiveSumCalculator( int currentNumber )
    {
        int result;

        if( currentNumber == 0 )
        {
            result = currentNumber;
        }
        else
        {
            result = currentNumber + consecutiveSumCalculator( currentNumber - 1 );
        }

        return result;
    }

    /**
     * factorialCalculator calculates the factorial from a number to 1 recursively (calls
     * itself multiple times to achieve a specific end)
     *
     * @param currentNumber is the current number of the factorial calculation as it counts down
     *                      to one
     * @return an integer that stores the factorial result or intermediate numbers for
     *         the calculation of the factorial
     */
    private int factorialCalculator( int currentNumber )
    {
        int result;

        if( currentNumber == 1 )
        {
            result = currentNumber;
        }
        else
        {
            result = currentNumber * factorialCalculator( currentNumber - 1 );
        }

        return result;
    }
}











