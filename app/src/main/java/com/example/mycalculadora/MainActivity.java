package com.example.mycalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtNro1;
    private EditText txtNro2;
    private TextView tvResultado;
    private Button btSumar;
    private Button btRestar;
    private Button btMultiplicar;
    private Button btDividir;
    private Button btFactorial;
    private Button btFibonacci;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNro1 = findViewById(R.id.txtNro1);
        txtNro2 = findViewById(R.id.txtNro2);
        tvResultado = findViewById(R.id.tvResultado);

        btSumar = findViewById(R.id.btSumar);
        btRestar = findViewById(R.id.btRestar);
        btMultiplicar = findViewById(R.id.btMultiplicar);
        btDividir = findViewById(R.id.btDividir);
        btFactorial = findViewById(R.id.btfactorial);
        btFibonacci = findViewById(R.id.btfibonacci);

        Button btn_Atras = findViewById(R.id.btn_Atras);
        btn_Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        Button btn_Salir = findViewById(R.id.btn_Salir);
        btn_Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar();
            }
        });

        btRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restar();
            }
        });

        btMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplicar();
            }
        });

        btDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dividir();
            }
        });

        btFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFactorial();
            }
        });
        btFibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFibonacci();
            }
        });
    }

    public void sumar(){
        int valor1 = Integer.parseInt(txtNro1.getText().toString());
        int valor2 = Integer.parseInt(txtNro2.getText().toString());
        tvResultado.setText(String.valueOf(valor1+valor2));
    }

    public void restar(){
        int valor1 = Integer.parseInt(txtNro1.getText().toString());
        int valor2 = Integer.parseInt(txtNro2.getText().toString());
        tvResultado.setText(String.valueOf(valor1-valor2));
    }

    public void multiplicar(){
        int valor1 = Integer.parseInt(txtNro1.getText().toString());
        int valor2 = Integer.parseInt(txtNro2.getText().toString());
        tvResultado.setText(String.valueOf(valor1*valor2));
    }

    public void dividir(){
        int valor1 = Integer.parseInt(txtNro1.getText().toString());
        int valor2 = Integer.parseInt(txtNro2.getText().toString());
        if (valor2 != 0) {
            tvResultado.setText(String.valueOf(valor1 / valor2));
        } else {
            tvResultado.setText("Error: División por cero");
        }
    }
    public void calcularFibonacci() {
        try {
            int valor = Integer.parseInt(txtNro1.getText().toString());
            int resultadoFibonacci = Calculadora.fibonacci(valor);
            tvResultado.setText(String.valueOf(resultadoFibonacci));
        } catch (NumberFormatException e) {
            tvResultado.setText("Error: Ingresa un número válido para calcular Fibonacci");
        }
    }

    public void calcularFactorial() {
        try {
            int valor = Integer.parseInt(txtNro1.getText().toString());
            int resultadoFactorial = Calculadora.factorial(valor);
            tvResultado.setText(String.valueOf(resultadoFactorial));
        } catch (NumberFormatException e) {
            tvResultado.setText("Error: Ingresa un número válido para calcular el factorial");
        }
    }

    public static class Calculadora {

        public static int factorial(int n) {
            if (n == 0 || n == 1) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
        }
        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }

    }
}

