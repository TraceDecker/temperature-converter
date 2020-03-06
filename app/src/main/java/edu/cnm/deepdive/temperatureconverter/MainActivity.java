package edu.cnm.deepdive.temperatureconverter;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener, OnTouchListener {

  private EditText fahr;
  private EditText celc;
  private EditText kelv;
  private Button button;
  private double newFahr = 0.0;
  private double newCelc = 0.0;
  private double newKelv = 0.0;
  private View lastEdit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    fahr = findViewById(R.id.fahrenheit);
    celc = findViewById(R.id.celcius);
    kelv = findViewById(R.id.kelvin);
    button = findViewById(R.id.button);

    fahr.setOnTouchListener(this);
    celc.setOnTouchListener(this);
    kelv.setOnTouchListener(this);

    button.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {

//    double fahrValue = 0;
//    if (!fahr.getText().toString().equals("")) {
//      fahrValue = Double.parseDouble(fahr.getText().toString());
//    }
//
//    double celcValue = 0;
//    if (!celc.getText().toString().equals("")) {
//      celcValue = Double.parseDouble(celc.getText().toString());
//    }
//
//    double kelvValue = 0;
//    if (!kelv.getText().toString().equals("")) {
//      kelvValue = Double.parseDouble(kelv.getText().toString());
//    }

//    if (fahrValue != newFahr) {
//      newFahr = fahrValue;
//      celc.setText(Double.toString(convertF2C(newFahr)));
//      kelv.setText(Double.toString(convertF2K(newFahr)));
//    }
//    if (celcValue != newCelc) {
//      newCelc = celcValue;
//      fahr.setText(Double.toString(convertC2F(newCelc)));
//      kelv.setText(Double.toString(convertC2K(newCelc)));
//    }
//    if (kelvValue != newKelv) {
//      newKelv = kelvValue;
//      fahr.setText(Double.toString(convertK2F(newKelv)));
//      celc.setText(Double.toString(convertK2C(newKelv)));
//    }

    if (lastEdit.getId() == fahr.getId()) {
      String str = fahr.getText().toString();
      celc.setText(Double.toString(convertF2C(Double.parseDouble(str))));
      kelv.setText(Double.toString(convertF2K(Double.parseDouble(str))));
    } else if (lastEdit.getId() == celc.getId()) {
      String str = celc.getText().toString();
      fahr.setText(Double.toString(convertC2F(Double.parseDouble(str))));
      kelv.setText(Double.toString(convertC2K(Double.parseDouble(str))));
    } else {
      String str = kelv.getText().toString();
      fahr.setText(Double.toString(convertK2F(Double.parseDouble(str))));
      celc.setText(Double.toString(convertK2C(Double.parseDouble(str))));
    }
  }

  private double convertF2C(double fa) {
    return (fa - 32) * 5 / 9;
  }

  private double convertF2K(double fa) {
    return (fa - 32) * 5 / 9 + 273.15;
  }

  private double convertC2F(double ce) {
    return ce * 9 / 5 + 32;
  }

  private double convertC2K(double ce) {
    return ce + 273.15;
  }

  private double convertK2F(double kel) {
    return (kel -273.15) * 9 / 5 + 32;
  }

  private double convertK2C(double kel) {
    return kel - 273.15;
  }


  @Override
  public boolean onTouch(View v, MotionEvent event) {
    lastEdit = v;
    return false;
  }
}
