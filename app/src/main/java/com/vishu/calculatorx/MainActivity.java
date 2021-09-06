package com.vishu.calculatorx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnadd,btnminus,btnmultiply,btndivide,btnac,btndel,btnequal,btnDot;
    private TextView textViewResult,textViewHistory;
    private String number=null;
    double firstNumber=0;
    double lastNumber=0;
    String status=null;
    boolean operator=false;
    boolean dot=true;
    boolean btnACcontrol=false;
    boolean btnEqualControl=false;
    String history,currentResult;
    DecimalFormat myFormatter =new DecimalFormat("######.######");
    public void numberClick(String view)
    {

        if(number == null)
        {
            number=view;
        }
        else if(btnEqualControl)
        {
            firstNumber=0;
            lastNumber=0;
            number=view;
        }
        else
        {
            number=number+view;
        }

        textViewResult.setText(number);
        operator=true;
        btnACcontrol=false;
        btndel.setClickable(true);
        btnEqualControl=false;

    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnadd = findViewById(R.id.btnPlus);
        btnminus = findViewById(R.id.btnMinus);
        btnmultiply = findViewById(R.id.btnMultiply);
        btndivide = findViewById(R.id.btnDivide);
        btnac = findViewById(R.id.btnAC);
        btndel = findViewById(R.id.btnDel);
        btnequal = findViewById(R.id.btnEquals);
        btnDot = findViewById(R.id.btnDot);
        textViewHistory=findViewById(R.id.textViewHistory);
        textViewResult=findViewById(R.id.textViewResult);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });
        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              number=null;
              status=null;
              textViewResult.setText("0");
              textViewHistory.setText("");
              firstNumber=0;
              lastNumber=0;
              dot=true;
              btnACcontrol=true;
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(operator)
               {
                   if(status=="multiplication")
                       multiply();
                   else if(status=="division")
                       divide();
                   else if(status=="subtraction")
                       minus();
                   else
                       add();
               }
               status="addition";
               operator=false;
               number=null;
               dot=true;
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator)
                {
                    if(status=="multiplication")
                        multiply();
                    else if(status=="division")
                        divide();
                    else if(status=="subtraction")
                        minus();
                    else
                        add();
                }
                status="subtraction";
                operator=false;
                number=null;
                dot=true;
            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator)
                {
                    if(status=="multiplication")
                        multiply();
                    else if(status=="division")
                        divide();
                    else if(status=="subtraction")
                        minus();
                    else
                        add();
                }
                status="multiplication";
                operator=false;
                number=null;
                dot=true;
            }
        });
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator)
                {
                    if(status=="multiplication")
                        multiply();
                    else if(status=="division")
                        divide();
                    else if(status=="subtraction")
                        minus();
                    else
                        add();
                }
                status="division";
                operator=false;
                number=null;
                dot=true;
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(dot==true)
              {
                  if(number==null)
                      number="0.";
                  else
                      number=number+".";
              }

              textViewResult.setText(number);
              dot=false;
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator)
                {
                    if(status=="multiplication")
                        multiply();
                    else if(status=="division")
                        divide();
                    else if(status=="subtraction")
                        minus();
                    else if(status=="addition")
                        add();
                    else
                    {
                        firstNumber=Double.parseDouble(textViewResult.getText().toString());
                    }
                }

                operator=false;
                btnEqualControl=true;

            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnACcontrol)
                    textViewResult.setText("0");
                else
                {
                    if(number.length()==0)
                        btndel.setClickable(false);
                    else if(number.contains("."))
                        dot=false;
                    else
                        dot=true;
                    number=number.substring(0,number.length()-1);
                    textViewResult.setText(number);
                }

            }
        });





    }
    public void add()
    {
        history=textViewHistory.getText().toString();
        currentResult=textViewResult.getText().toString();
        if(status=="multiplication")
        textViewHistory.setText(history+"*"+currentResult);
    else if(status=="division")
        textViewHistory.setText(history+"/"+currentResult);
    else if(status=="subtraction")
        textViewHistory.setText(history+"-"+currentResult);
    else if(status=="addition")
        textViewHistory.setText(history+"+"+currentResult);
    else
        textViewHistory.setText(history+""+currentResult);






        lastNumber=Double.parseDouble(textViewResult.getText().toString());
        firstNumber=firstNumber+lastNumber;
        textViewResult.setText(myFormatter.format(firstNumber));
    }
    public void minus()
    {
        history=textViewHistory.getText().toString();
        currentResult=textViewResult.getText().toString();

        if(status=="multiplication")
            textViewHistory.setText(history+"*"+currentResult);
        else if(status=="division")
            textViewHistory.setText(history+"/"+currentResult);
        else if(status=="subtraction")
            textViewHistory.setText(history+"-"+currentResult);
        else if(status=="addition")
            textViewHistory.setText(history+"+"+currentResult);
        else
            textViewHistory.setText(history+""+currentResult);



        if(firstNumber==0)
        {
         firstNumber=Double.parseDouble(textViewResult.getText().toString());

        }
        else
        {
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=firstNumber-lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
    }
    public void multiply()
    {
        history=textViewHistory.getText().toString();
        currentResult=textViewResult.getText().toString();

        if(status=="multiplication")
            textViewHistory.setText(history+"*"+currentResult);
        else if(status=="division")
            textViewHistory.setText(history+"/"+currentResult);
        else if(status=="subtraction")
            textViewHistory.setText(history+"-"+currentResult);
        else if(status=="addition")
            textViewHistory.setText(history+"+"+currentResult);
        else
            textViewHistory.setText(history+""+currentResult);

        if(firstNumber==0)
        {
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=lastNumber;
        }
        else
        {
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=firstNumber*lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
    }
    public void divide()
    {
        history=textViewHistory.getText().toString();
        currentResult=textViewResult.getText().toString();


        if(status=="multiplication")
            textViewHistory.setText(history+"*"+currentResult);
        else if(status=="division")
            textViewHistory.setText(history+"/"+currentResult);
        else if(status=="subtraction")
            textViewHistory.setText(history+"-"+currentResult);
        else if(status=="addition")
            textViewHistory.setText(history+"+"+currentResult);
        else
            textViewHistory.setText(history+""+currentResult);

        if(firstNumber==0)
        {
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=lastNumber;
        }
        else
        {
            lastNumber=Double.parseDouble(textViewResult.getText().toString());
            firstNumber=firstNumber/lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
    }


}