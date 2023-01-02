package w1.t1.unterricht.body_mass_index;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{


    private TextView lb1;
    private Button btnBerechnung;
    private EditText groesse;
    private EditText gewicht;




    private class MyOCL_Ausrechnunung implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            double grose = Double.parseDouble(groesse.getText().toString());
            double gewict = Double.parseDouble(gewicht.getText().toString());
            DecimalFormat precision = new DecimalFormat("0.00");
            DecimalFormat precision2 = new DecimalFormat("0");

            double result = gewict / (grose*grose);

           if (result <= 18.5 && result > 0){

               lb1.setText(precision.format(grose)+"cm"+"\n"+precision2.format(gewict)+"kg"+"\nFleischlos\n BMI = "+ precision.format(result));

           }else if (result > 18.5 && result <= 25.0) {

               lb1.setText(precision.format(grose)+"cm"+"\n"+precision2.format(gewict)+"kg"+"\nNormal Gewicht\n BMI = "+ precision.format(result));

           }else if (result > 25.0 && result <= 30.0)
           {
               lb1.setText(precision.format(grose)+"cm"+"\n"+precision2.format(gewict)+"kg"+"\nFettleibigkeit\n BMI = "+precision.format(result));

           }else if (result > 30.0 && result <= 40.0)
           {
               lb1.setText(precision.format(grose)+"cm"+"\n"+precision2.format(gewict)+"kg"+"\nAdipositas-Behandlung ist erforderlich!!\n BMI = "+precision.format(result));

           }else if (result > 40.0 && result <= 186.0)
           {
               lb1.setText(precision.format(grose)+"cm"+"\n"+precision2.format(gewict)+"kg"+"\nüberbewertet\n BMI = "+precision.format(result));
           }
           else {

               lb1.setText("Bitte geben Sie gültige Werte ein");
           }
            try
            {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            } catch (Exception e) {
                // TODO: handle exception
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groesse = (EditText) findViewById(R.id.groesse);
        gewicht = (EditText) findViewById(R.id.gewicht);
        lb1 = (TextView) findViewById(R.id.lb1);



        btnBerechnung = (Button) findViewById(R.id.button);
        btnBerechnung.setOnClickListener(new MyOCL_Ausrechnunung());
        lb1.setText("Result");

    }

}