package com.example.romankolinproducts;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    TextView textView1total;
    CheckBox[] checkbox = new CheckBox[9];
    EditText[] edittextnumberdecimal = new EditText[9];
    EditText[] edittextnumber = new EditText[9];
    RadioButton radioButton1field;
    RadioButton radioButton2toast;
    RadioButton radioButton3dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1total = findViewById(R.id.textView1total);

        checkbox[0] = findViewById(R.id.checkBox1fanta);
        checkbox[1] = findViewById(R.id.checkBox2coffee);
        checkbox[2] = findViewById(R.id.checkBox3milk);
        checkbox[3] = findViewById(R.id.checkBox4vanillasugar);
        checkbox[4] = findViewById(R.id.checkBox5cinnamon);
        checkbox[5] = findViewById(R.id.checkBox6tea);
        checkbox[6] = findViewById(R.id.checkBox7cheese);
        checkbox[7] = findViewById(R.id.checkBox8egg);
        checkbox[8] = findViewById(R.id.checkBox9bread);

        edittextnumberdecimal[0] = findViewById(R.id.editTextNumberDecimal1fanta);
        edittextnumberdecimal[1] = findViewById(R.id.editTextNumberDecimal2coffee);
        edittextnumberdecimal[2] = findViewById(R.id.editTextNumberDecimal3milk);
        edittextnumberdecimal[3] = findViewById(R.id.editTextNumberDecimal4vanillasugar);
        edittextnumberdecimal[4] = findViewById(R.id.editTextNumberDecimal5cinnamon);
        edittextnumberdecimal[5] = findViewById(R.id.editTextNumberDecimal6tea);
        edittextnumberdecimal[6] = findViewById(R.id.editTextNumberDecimal7cheese);
        edittextnumberdecimal[7] = findViewById(R.id.editTextNumberDecimal8egg);
        edittextnumberdecimal[8] = findViewById(R.id.editTextNumberDecimal9bread);

        edittextnumber[0] = findViewById(R.id.editTextNumber1fanta);
        edittextnumber[1] = findViewById(R.id.editTextNumber2coffee);
        edittextnumber[2] = findViewById(R.id.editTextNumber3milk);
        edittextnumber[3] = findViewById(R.id.editTextNumber4vanillasugar);
        edittextnumber[4] = findViewById(R.id.editTextNumber5cinnamon);
        edittextnumber[5] = findViewById(R.id.editTextNumber6tea);
        edittextnumber[6] = findViewById(R.id.editTextNumber7cheese);
        edittextnumber[7] = findViewById(R.id.editTextNumber8egg);
        edittextnumber[8] = findViewById(R.id.editTextNumber9bread);

        radioButton1field = findViewById(R.id.radioButton1field);
        radioButton2toast = findViewById(R.id.radioButton2toast);
        radioButton3dialog = findViewById(R.id.radioButton3dialog);
    }

    public void onclickfield(View f)
    {
        if (radioButton1field.isChecked())
        {
            radioButton2toast.setChecked(false);
            radioButton3dialog.setChecked(false);
        }
    }
    public void onclicktoast(View t)
    {
        if (radioButton2toast.isChecked())
        {
            radioButton1field.setChecked(false);
            radioButton3dialog.setChecked(false);
        }
    }
    public void onclickdialog(View d)
    {
        if (radioButton3dialog.isChecked())
        {
            radioButton1field.setChecked(false);
            radioButton2toast.setChecked(false);
        }
    }

    public void onclicktotal(View total)
    {
        try
        {
            double tot = 0;
            for (int i = 0; i <= 8; i++)
            {
                if (checkbox[i].isChecked())
                {
                    if (edittextnumberdecimal[i].getText().toString().equals("0") || edittextnumber[i].getText().toString().equals("0"))
                    {
                        Toast unexp = Toast.makeText(getApplicationContext(), "Print a non-zero number", Toast.LENGTH_SHORT);
                        unexp.show();
                    }
                    else
                    {
                        double pr = Double.parseDouble(edittextnumberdecimal[i].getText().toString());
                        int quant = Integer.parseInt(edittextnumber[i].getText().toString());
                        tot += pr * quant;
                    }
                }
            }
            DecimalFormat df = new DecimalFormat("0.##");
            if (radioButton1field.isChecked())
                textView1total.setText(df.format(tot));
            if (radioButton2toast.isChecked())
            {
                Toast res = Toast.makeText(getApplicationContext(), df.format(tot), Toast.LENGTH_LONG);
                res.show();
            }
            if (radioButton3dialog.isChecked())
            {
                AlertDialog.Builder res = new AlertDialog.Builder(this).setTitle("Total");
                res.setMessage(df.format(tot));
                res.setPositiveButton("Ok", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id)
                    {
                        dialogInterface.cancel();
                    }
                });
                res.setIcon(R.drawable.dollar);
                res.show();
            }
        }
        catch (Exception unexpected)
        {
            Toast unexp = Toast.makeText(getApplicationContext(), "Print a non-zero number", Toast.LENGTH_SHORT);
            unexp.show();
        }
    }
    
    public void onclickclear(View clear)
    {
        textView1total.setText("");
        for (int i = 0; i <= 8; i++)
        {
            if (edittextnumberdecimal[i].getText().toString().length() != 0)
                edittextnumberdecimal[i].setText("");
            if (edittextnumber[i].getText().toString().length() != 0)
                edittextnumber[i].setText("");
            checkbox[i].setChecked(false);
            radioButton1field.setChecked(true);
            radioButton2toast.setChecked(false);
            radioButton3dialog.setChecked(false);
        }
    }
}