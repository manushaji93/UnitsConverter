package com.example.manushaji.unitsconverter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity implements OnItemSelectedListener {

    LinearLayout ll;

    public java.math.BigDecimal answer = new java.math.BigDecimal("0");

    public boolean textViewDone = false;
    public List<TextView> answerTextViewList = new ArrayList<TextView>();


    public EditText input;
    Spinner spinnerSelector, spinnerFrom;
    String accelerationArr[];
    float accelerationValArr[] = new float[]{1f, 100f, 0.0254f, 12f, 32.17404856f};

    String anglesArr[];
    float anglesValArr[] = new float[]{1f, 57.29577951f, 0.00000485f, 60f, 21600f, 0.5f, 0.5f, 0.66666666f, 0.75f, 0.8f, 0.83333333f, 0.75f};

    String areaArr[];
    float areaValArr[] = new float[]{1f, 100f, 10000f, 0.00064516f, 144f, 9f, 11959.900463011f, 0.404685642f, 247.105381467f, 2.58998811f,
            0.0000000000003032f, 10f, 100f, 0.0254f, 12f, 3f};

    String circularMeasureArr[];
    float circularMeasureValArr[] = new float[]{1f, 0.5f, 0.31830989f};

    String dataTransArr[];
    float dataTransValArr[] = new float[]{1f, 1000f, 8f, 125f, 8f, 125f, 8f, 125f, 8f};

    String densityArr[];
    float densityValArr[] = new float[]{1f, 0.001f, 0.000001f, 1000f, 1000000000f, 0.001f, 0.000001f, 1000f, 1.72999404f, 0.00057870f,
            0.03703704f, 746496f, 0.0005787f, 0.03703704f, 76.4554858f, 1.12f, 17.85714286f, 1.12f, 0.98420653f, 1.60184634f, 1.12f, 17.85714286f,
            1.12f, 0.00098421f, 1.67997174f, 1.12f, 17.85714286f, 1.12f, 0.00098421f};

    String digitalStorArr[];
    float digitalStorValArr[] = new float[]{1f, 1000f, 1.024f, 976.563f, 1.04858f, 953.674f, 1.07374f, 931.323f, 1.09951f, 909.495f, 1.1259f,
            0.0000000000000071054f, 1000f, 1.024f, 976.563f, 1.04858f, 953.674f, 1.07374f, 931.323f, 1.09951f, 909.495f, 1.1259f};

    String energyArr[];
    float energyValArr[] = new float[]{1f, 9.80665f, 0.138254954f, 778.169262266f, 0.000947817f, 1000f, 4.1868f};

    String flowRateVolArr[];
    float flowRateVolValArr[] = new float[]{1f, 0.016666666f, 0.016666666f, 0.0036f, 0.016666666f, 0.016666666f, 3600000f, 0.016666666f,
            0.016666666f, 3600000000f, 0.016666666f, 0.016666666f, 0.05899343f, 0.016666666f, 0.016666666f, 6220800f, 0.016666666f,
            0.016666666f, 8.020833333f, 1.200950454f, 578.245707155f, 1.200950454f, 0.050360113f, 0.016666666f, 0.041666666f};

    String flowRateMassArr[];
    float flowRateMassValArr[] = new float[]{1f, 0.016666666f, 0.016666666f, 3600000f, 0.016666666f, 0.016666666f, 102.058283250f, 0.016666666f,
            0.016666666f, 57600f, 0.016666666f, 0.016666666f, 360000f, 1.12f, 0.014880952f, 1.12f, 0.014880952f, 1.12f, 17.857142857f, 1.12f, 0.984206528f,
            0.037799364f, 1.12f, 0.984206528f};

    String forceArr[];
    float forceValArr[] = new float[]{1f, 9.80665f, 0.00000101972f, 444822.16152605f, 2000f, 1.12f, 0.98420652761f};

    String frequencyArr[];
    float frequencyValArr[] = new float[]{1f, 1000f, 1000f, 0.000001f, 0.016666666f, 0.016666666f, 3600f, 0.016666666f, 0.016666666f, 572.95779513082f,
            0.016666666f, 0.016666666f, 62.8318530718f, 0.016666666f, 0.016666666f};

    String fuelArr[];
    float fuelValArr[] = new float[]{1f, 0.26417205236f, 0.8326738183f, 7.31622588365f, 0.26417205236f, 0.8326738183f, 2.82481060606f, 3.785411784f, 1.20095045385f,
            0.13668249394f, 3.785411784f, 1.20095045385f};

    String lengthArr[];
    float lengthValArr[] = new float[]{1f, 0.001f, 0.01f, 0.1f, 1609000f, 0.000568182f, 0.333333f, 0.0833333f, 72913.4f,
            0.00005486f, 1980f, 0.009090909f, 100f, 1.2f, 0.00000000000045567220764f, 10000f, 0.0254f};

    String lightingArr[];
    float lightingValArr[] = new float[]{1f, 0.0001f, 1550.0031000062f, 0.00694444444f, 1f};

    String liquidMeasureArr[];
    float liquidMeasureValArr[] = new float[]{1f, 1000f, 3.785411784f, 1.20095045385f, 0.10408422729f, 1.20095045385f, 1.66534763661f, 1.20095045385f, 0.02602105682f,
            0.96076036308f, 5595.56805900101f};

    String massArr[];
    float massValArr[] = new float[]{1f, 0.001f, 0.001f, 0.001f, 1016000000f, 0.892857f, 0.007f, 0.0714286f, 0.0625f};

    String powerArr[];
    float powerValArr[] = new float[]{1f, 1000f, 1000f, 0.000001f, 0.016666666f, 0.016666666f, 35303.94f, 0.016666666f, 0.016666666f, 367.09783667205f, 0.016666666f, 0.016666666f,
            15072480f, 0.016666666f, 0.016666666f, 641.18647599507f, 0.001818181818f, 0.016666666f, 0.016666666f, 2801409.34415747f, 0.016666666f, 0.016666666f, 12000f};

    String pressureArr[];
    float pressureValArr[] = new float[]{1f, 1f, 1000f, 0.1f, 1000f, 0.980665f, 1.0332274528f, 0.00009678411f, 1000f, 0.0254f, 12f, 0.0446033401f, 25.4f, 2.03602096738f, 0.00694444444f,
            288000f, 0.00694444444f, 0.09290304f, 1736.00347200694f, 0.00694444444f, 0.09290304f, 1525.52316884348f, 0.00694444444f, 0.09290304f};

    String torqueArr[];
    float torqueValArr[] = new float[]{1f, 9.80665f, 0.00864093465f, 0.08333333333f, 192f, 0.08333333333f, 84518.3965643706f, 0.74569987158f};

    String temperatureArr[];

    String timeArr[];
    float timeValArr[] = new float[]{1f, 1000f, 1000f, 1000f, 60f, 60f, 24f, 7f, 4.34524f, 12f, 10f, 10f};

    String velocityArr[];
    float velocityValArr[] = new float[]{1f, 0.016666666f, 0.016666666f, 36000f, 0.016666666f, 0.016666666f, 360000f, 0.016666666f, 0.016666666f, 3600000f, 0.016666666f, 0.016666666f,
            0.09144f, 0.016666666f, 0.016666666f, 43200f, 0.016666666f, 0.016666666f, 19008000f, 0.016666666f, 0.016666666f, 1.15077944802f, 661.49028077754f};

    String viscosityDynArr[];
    float viscosityDynValArr[] = new float[]{1f, 100f, 10f, 1f, 0.00980665f, 10.76391041671f, 92.90304f, 10.76391041671f, 0.04214011009f, 10.76391041671f};

    String viscosityKinArr[];
    float viscosityKinValArr[] = new float[]{1f, 10.76391041671f, 0.00002088543f, 100f, 10000f};

    String volumeArr[];
    float volumeValArr[] = new float[]{1f, 0.25f, 0.5f, 0.50721f, 0.123223f, 0.5f, 0.333333f, 202884f, 0.001f, 0.001f, 4546.09f,
            0.25f, 0.5f, 0.5f, 0.1f, 0.625f, 0.333333f, 4783.74f, 0.000578704f};

    int indexFrom = 0;
    String sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.data_linear_layout);

        input = (EditText) findViewById(R.id.from_edit_text);

        spinnerSelector = (Spinner) findViewById(R.id.selector_spinner);
        spinnerFrom = (Spinner) findViewById(R.id.from_spinner);
        spinnerSelector.setOnItemSelectedListener(this);

        Timer timer = new Timer();
        timer.schedule(new calculation(), 0, 500);


    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        sp1 = String.valueOf(spinnerSelector.getSelectedItem());

        if (sp1.equals("Acceleration")) {
            accelerationArr = new String[]{"cm/sec²", "m/sec²", "inch/sec²", "ft/sec²", "Gravitational acc."};
            ArrayAdapter<String> adapterAcceleration = new ArrayAdapter<String>(this, R.layout.spinner_layout, accelerationArr);
            adapterAcceleration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterAcceleration.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterAcceleration);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Angles")) {
            anglesArr = new String[]{"Degrees (angle)", "Radians", "Arcsecond", "Arcminute",
                    "Full Circle", "Semicircle", "1/4 Circle", "1/6 Circle", "1/8 Circle", "1/10 Circle", "1/12 Circle", "1/16 Circle"};
            ArrayAdapter<String> adapterAngles = new ArrayAdapter<String>(this, R.layout.spinner_layout, anglesArr);
            adapterAngles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterAngles.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterAngles);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Area")) {
            areaArr = new String[]{"mm²", "cm²", "m²", "in²", "ft²", "yd²", "Hectare", "Acre",
                    "km²", "mi²", "Millimeter Diamater Circle", "Centimeter Diameter Circle", "Meter Diameter Circle",
                    "Inch Diameter Circle", "Foot Diameter Circle", "Yard Diameter Circle"};
            ArrayAdapter<String> adapterArea = new ArrayAdapter<String>(this, R.layout.spinner_layout, areaArr);
            adapterArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterArea.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterArea);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Circular Measure")) {
            circularMeasureArr = new String[]{"Radius", "Diameter", "Circumference"};
            ArrayAdapter<String> adapterCircularMeasure = new ArrayAdapter<String>(this, R.layout.spinner_layout, circularMeasureArr);
            adapterCircularMeasure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterCircularMeasure.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterCircularMeasure);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Data Transfer Rate")) {
            dataTransArr = new String[]{"Bit per second", "Kilobit per second", "Kilobyte per second", "Megabit per second", "Megabyte per second",
                    "Gigabit per second", "Gigabyte per second", "Terabit per second", "Terabyte per second"};
            ArrayAdapter<String> adapterDataTrans = new ArrayAdapter<String>(this, R.layout.spinner_layout, dataTransArr);
            adapterDataTrans.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterDataTrans.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterDataTrans);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Density")) {
            densityArr = new String[]{"gram/mm³", "gram/cm³", "gram/m³", "gram/liter", "kg/mm³", "kg/cm³", "kg/m³", "kg/liter",
                    "ounce/in³", "ounce/ft³", "ounce/yd³", "lb/in³", "lb/ft³", "lb/yd³", "cwt(short)/m³", "cwt(long)/m³",
                    "ton(short)/m³", "ton(long)/m³", "tonne/m³", "cwt(short)/ft³", "cwt(long)/ft³", "ton(short)/ft³",
                    "ton(long)/ft³", "tonne/ft³", "cwt(short)/yd³", "cwt(long)/yd³", "ton(short)/yd³", "ton(long)/yd³", "tonne/yd³"};
            ArrayAdapter<String> adapterDensity = new ArrayAdapter<String>(this, R.layout.spinner_layout, densityArr);
            adapterDensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterDensity.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterDensity);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Digital Storage")) {
            digitalStorArr = new String[]{"Bit", "Kilobit", "Kibibit", "Megabit", "Mebibit", "Gigabit", "Gibibit", "Terabit", "Tebibit", "Petabit", "Pebibit",
                    "Byte", "Kilobyte", "Kibibyte", "Megabyte", "Mebibyte", "Gigabyte", "Gibibyte", "Terabyte", "Tebibyte", "Petabyte", "Pebibyte"};
            ArrayAdapter<String> adapterDeiditalStor = new ArrayAdapter<String>(this, R.layout.spinner_layout, digitalStorArr);
            adapterDeiditalStor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterDeiditalStor.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterDeiditalStor);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Energy")) {
            energyArr = new String[]{"N-m", "kg-m", "ft-lb", "Btu", "Joule", "Kilojoule", "Kilocalorie"};
            ArrayAdapter<String> adapterEnergy = new ArrayAdapter<String>(this, R.layout.spinner_layout, energyArr);
            adapterEnergy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterEnergy.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterEnergy);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Flow Rate (Volume)")) {
            flowRateVolArr = new String[]{"liter/sec", "liter/min", "liter/hr", "mm³/sec", "mm³/min", "mm³/hr", "cm³/sec (ml/sec)", "cm³/min (ml/min)",
                    "cm³/hr (ml/hr)", "m³/sec", "m³/min", "m³/hr", "in³/sec", "in³/min", "in³/hr", "ft³/sec", "ft³/min", "ft³/hr", "gpm USA",
                    "gpm UK", "MGD USA", "MGD UK", "Barrels/min (oil)", "Barrels/hr (oil)", "Barrels/day (oil)"};
            ArrayAdapter<String> adapterFlowVol = new ArrayAdapter<String>(this, R.layout.spinner_layout, flowRateVolArr);
            adapterFlowVol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterFlowVol.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterFlowVol);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Flow Rate (Mass)")) {
            flowRateMassArr = new String[]{"gram/sec", "gram/min", "gram/hr", "kg/sec", "kg/min", "kg/hr", "ounce/sec", "ounce/min",
                    "ounce/hr", "lb/sec", "lb/min", "lb/hr", "cwt USA/sec", "cwt UK/sec", "cwt USA/min", "cwt UK/min", "cwt USA/hr", "cwt UK/hr",
                    "ton (short) USA/hr", "ton (long) UK/hr", "tonne (metric)/hr", "ton (short) USA/day", "ton (long) UK/day", "tonne (metric)/day"};
            ArrayAdapter<String> adapterFlowMass = new ArrayAdapter<String>(this, R.layout.spinner_layout, flowRateMassArr);
            adapterFlowMass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterFlowMass.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterFlowMass);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Force")) {
            forceArr = new String[]{"Newton", "kg-force", "dyne", "lb-force", "ton-force USA", "ton-force UK", "tonne-force"};
            ArrayAdapter<String> adapterForce = new ArrayAdapter<String>(this, R.layout.spinner_layout, forceArr);
            adapterForce.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterForce.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterForce);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Frequency")) {
            frequencyArr = new String[]{"Hz (Hertz)", "kHz", "MHz", "Cycles/sec", "Cycles/min", "Cycles/hr", "Revolutions/sec", "Revolutions/min (RPM)",
                    "Revolutions/hr", "Radians/sec", "Radians/min", "Radians/hr", "Degrees/sec", "Degrees/min", "Degrees/hr"};
            ArrayAdapter<String> adapterFrequency = new ArrayAdapter<String>(this, R.layout.spinner_layout, frequencyArr);
            adapterFrequency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterFrequency.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterFrequency);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Fuel Consumption")) {
            fuelArr = new String[]{"km/liter", "km/gallon USA", "km/gallon UK", "Mile/liter", "Mile/gallon USA", "Mile/gallon UK", "Liter/km", "Gallon USA/km",
                    "Gallon UK/km", "Liter/mile", "Gallon USA/mile", "Gallon UK/mile"};
            ArrayAdapter<String> adapterFuel = new ArrayAdapter<String>(this, R.layout.spinner_layout, fuelArr);
            adapterFuel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterFuel.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterFuel);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Length")) {
            lengthArr = new String[]{"Kilometer", "Meter", "Centimeter", "Millimeter", "Mile", "Yard", "Foot", "Inch", "Nautical Mile", "Hand",
                    "Furlong", "Fathom", "Cable UK", "Cable USA", "Angstrom", "Micron", "Microinch"};
            ArrayAdapter<String> adapterLength = new ArrayAdapter<String>(this, R.layout.spinner_layout, lengthArr);
            adapterLength.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterLength.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterLength);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Lighting")) {
            lightingArr = new String[]{"Lumen/cm²", "Lumen/m² (Lux)", "Lumen/in²", "Lumen/ft²", "Foot-candle"};
            ArrayAdapter<String> adapterLighting = new ArrayAdapter<String>(this, R.layout.spinner_layout, lightingArr);
            adapterLighting.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterLighting.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterLighting);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Liquid Measure")) {
            liquidMeasureArr = new String[]{"Milliliter (cm³)", "Liter", "Gallon USA", "Gallon UK", "Pint USA", "Pint UK", "Quart USA", "Quart UK",
                    "Fluid Ounce USA", "Fluid Ounce UK", "Barrels (Oil)"};
            ArrayAdapter<String> adapterLiquidMeasure = new ArrayAdapter<String>(this, R.layout.spinner_layout, liquidMeasureArr);
            adapterLiquidMeasure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterLiquidMeasure.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterLiquidMeasure);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Mass")) {
            massArr = new String[]{"Tonne", "Kilogram", "Gram", "Milligram", "Imperial Ton", "US Ton", "Stone", "Pound", "Ounce"};
            ArrayAdapter<String> adapterMass = new ArrayAdapter<String>(this, R.layout.spinner_layout, massArr);
            adapterMass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterMass.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterMass);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Power")) {
            powerArr = new String[]{"Watt", "Kilowatt", "Megawatt", "Joule/sec", "Joule/min", "Joule/hr", "kg-m/sec", "kg-m/min", "kg-m/hr", "N-m/sec",
                    "N-m/min", "N-m/hr", "kcal/sec (Steam)", "kcal/min (Steam)", "kcal/hr (Steam)", "Horse Power", "ft-lb/sec", "ft-lb/min", "ft-lb/hr",
                    "Btu/sec (Steam)", "Btu/min (Steam)", "Btu/hr (Steam)", "Ton of Refrigeration"};
            ArrayAdapter<String> adapterPower = new ArrayAdapter<String>(this, R.layout.spinner_layout, powerArr);
            adapterPower.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterPower.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterPower);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Pressure")) {
            pressureArr = new String[]{"N/m²", "Pascal", "Kilopascal", "Millibar", "Bar", "kgf/cm²", "Atmosphere", "mm.H2O", "m.H2O", "in.H2O", "ft.H2O",
                    "mm.Hg (Torr)", "in.Hg", "lbf/in² (psi)", "lbf/ft²", "ton-force (short)/in²", "ton-force (short)/ft²", "ton-force (short)/m²",
                    "ton-force (long)/in²", "ton-force (long)/ft²", "ton-force (long)/m²", "tonne-force/in²", "tonne-force/ft²", "tonne-force/m²"};
            ArrayAdapter<String> adapterPressure = new ArrayAdapter<String>(this, R.layout.spinner_layout, pressureArr);
            adapterPressure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterPressure.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterPressure);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Torque")) {
            torqueArr = new String[]{"N-m", "kg-m", "ounce-foot", "ounce-inch", "lb-foot", "lb-inch", "kW/rpm", "HP/rpm"};
            ArrayAdapter<String> adapterTorque = new ArrayAdapter<String>(this, R.layout.spinner_layout, torqueArr);
            adapterTorque.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterTorque.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterTorque);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Temperature")) {
            temperatureArr = new String[]{"°Celsius", "°Fahrenheit", "°Kelvin", "°Rankine"};
            ArrayAdapter<String> adapterTemperature = new ArrayAdapter<String>(this, R.layout.spinner_layout, temperatureArr);
            adapterTemperature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterTemperature.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterTemperature);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Time")) {
            timeArr = new String[]{"Nanosecond", "Microsecond", "Millisecond", "Second", "Minute", "Hour", "Day", "Week", "Month", "Year", "Decade", "Century"};
            ArrayAdapter<String> adapterTime = new ArrayAdapter<String>(this, R.layout.spinner_layout, timeArr);
            adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterTime.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterTime);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Velocity")) {
            velocityArr = new String[]{"mm/sec", "mm/min", "mm/hr", "cm/sec", "cm/min", "cm/hr", "m/sec", "m/min", "m/hr", "km/sec", "km/min", "km/hr", "inch/sec", "inch/min",
                    "inch/hr", "ft/sec", "ft/min", "ft/hr", "mile/sec", "mile/min", "mile/hr", "Knot", "Mach (Sea Level)"};
            ArrayAdapter<String> adapterVelocity = new ArrayAdapter<String>(this, R.layout.spinner_layout, velocityArr);
            adapterVelocity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterVelocity.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterVelocity);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Viscosity Dynamic")) {
            viscosityDynArr = new String[]{"Centipoise", "Poise", "Pascal-sec", "N-sec/m²", "Gram-sec/m²", "Gram-sec/ft²", "kg-sec/m²", "kg-sec/ft²", "lbf-sec/m²", "lbf-sec/ft²"};
            ArrayAdapter<String> adapterViscDyn = new ArrayAdapter<String>(this, R.layout.spinner_layout, viscosityDynArr);
            adapterViscDyn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterViscDyn.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterViscDyn);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Viscosity Kinematic")) {
            viscosityKinArr = new String[]{"lbf-sec/m²", "lbf-sec/ft²", "Centistokes (mm²/sec)", "Stokes (cm²/sec)", "m²/sec"};
            ArrayAdapter<String> adapterViscKin = new ArrayAdapter<String>(this, R.layout.spinner_layout, viscosityKinArr);
            adapterViscKin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterViscKin.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterViscKin);
            textViewDone = false;
            deleteTextViews();
        }
        if (sp1.equals("Volume / Capacity")) {
            volumeArr = new String[]{"US Liquid Gallon", "US Liquid Quart", "US Liquid Pint", "US Legal Cup", "US Fluid Ounce", "US Tablespoon", "US Teaspoon",
                    "m³", "Liter", "Milliliter", "Imperial Gallon", "Imperial Quart", "Imperial Pint", "Imperial Cup", "Imperial Fluid Ounce",
                    "Imperial Tablespoon", "Imperial Teaspoon", "ft³", "in³"};
            ArrayAdapter<String> adapterVolume = new ArrayAdapter<String>(this, R.layout.spinner_layout, volumeArr);
            adapterVolume.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterVolume.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterVolume);
            textViewDone = false;
            deleteTextViews();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    class calculation extends TimerTask {
        public void run() {

            if (!input.getText().toString().equals("")) {

                String spFrom = String.valueOf(spinnerFrom.getSelectedItem());
                java.math.BigDecimal inputFloat = new java.math.BigDecimal(input.getText().toString());

            /*------START OF ACCELERATION CONVERIONS------*/
                if (sp1.equals("Acceleration")) {


                    for (int indexTo = 0; indexTo < accelerationValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(accelerationArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(accelerationValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(accelerationValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), accelerationArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF ACCELERATION CONVERSIONS------*/

            /*------START OF ANGLES CONVERIONS------*/
                if (sp1.equals("Angles")) {


                    for (int indexTo = 0; indexTo < anglesValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(anglesArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(anglesValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(anglesValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), anglesArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF ANGLES CONVERSIONS------*/

            /*------START OF AREA CONVERIONS------*/
                if (sp1.equals("Area")) {


                    for (int indexTo = 0; indexTo < areaValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(areaArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(areaValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(areaValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), areaArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF AREA CONVERSIONS------*/

            /*------START OF CIRCULAR MEASURE CONVERIONS------*/
                if (sp1.equals("Circular Measure")) {


                    for (int indexTo = 0; indexTo < circularMeasureValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(circularMeasureArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(circularMeasureValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(circularMeasureValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), circularMeasureArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF CIRCULAR MEASURE CONVERSIONS------*/

            /*------START OF DATA TRANSFER RATE CONVERIONS------*/
                if (sp1.equals("Data Transfer Rate")) {


                    for (int indexTo = 0; indexTo < dataTransValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(dataTransArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(dataTransValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(dataTransValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), dataTransArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF DATA TRANSFER RATE CONVERSIONS------*/

            /*------START OF DENSITY CONVERIONS------*/
                if (sp1.equals("Density")) {


                    for (int indexTo = 0; indexTo < densityValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(densityArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(densityValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(densityValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), densityArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF DENSITY CONVERSIONS------*/

            /*------START OF DIGITAL STORAGE CONVERIONS------*/
                if (sp1.equals("Digital Storage")) {


                    for (int indexTo = 0; indexTo < digitalStorValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(digitalStorArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(digitalStorValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(digitalStorValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), digitalStorArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF DIGITAL STORAGE CONVERSIONS------*/

            /*------START OF ENERGY CONVERIONS------*/
                if (sp1.equals("Energy")) {


                    for (int indexTo = 0; indexTo < energyValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(energyArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(energyValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(energyValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), energyArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF ENERGY CONVERSIONS------*/

            /*------START OF FLOW RATE (VOLUME) CONVERIONS------*/
                if (sp1.equals("Flow Rate (Volume)")) {


                    for (int indexTo = 0; indexTo < flowRateVolValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(flowRateVolArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(flowRateVolValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(flowRateVolValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), flowRateVolArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF FLOW RATE (VOLUME) CONVERSIONS------*/

            /*------START OF FLOW RATE (MASS) CONVERIONS------*/
                if (sp1.equals("Flow Rate (Mass")) {


                    for (int indexTo = 0; indexTo < flowRateMassValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(flowRateMassArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(flowRateMassValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(flowRateMassValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), flowRateMassArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF FLOW RATE (MASS) CONVERSIONS------*/

            /*------START OF FORCE CONVERIONS------*/
                if (sp1.equals("Force")) {


                    for (int indexTo = 0; indexTo < forceValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(forceArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(forceValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(forceValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), forceArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF FORCE CONVERSIONS------*/

            /*------START OF FREQUENCY CONVERIONS------*/
                if (sp1.equals("Frequency")) {


                    for (int indexTo = 0; indexTo < frequencyValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(frequencyArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(frequencyValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(frequencyValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), frequencyArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF FREQUENCY CONVERSIONS------*/

            /*------START OF FUEL CONSUMPTION CONVERIONS------*/
                if (sp1.equals("Fuel Consumption")) {


                    for (int indexTo = 0; indexTo < fuelValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(fuelArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(fuelValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(fuelValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), fuelArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF FUEL CONSUMPTION CONVERSIONS------*/

            /*------START OF LENGTH CONVERIONS------*/
                if (sp1.equals("Length")) {


                    for (int indexTo = 0; indexTo < lengthValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(lengthArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(lengthValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(lengthValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), lengthArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF LENGTH CONVERSIONS------*/

            /*------START OF LIGHTING CONVERIONS------*/
                if (sp1.equals("Lighting")) {


                    for (int indexTo = 0; indexTo < lightingValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(lightingArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(lightingValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(lightingValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), lightingArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF LIGHTING CONVERSIONS------*/

            /*------START OF LIQUID MEASURE CONVERIONS------*/
                if (sp1.equals("Liquid Measure")) {


                    for (int indexTo = 0; indexTo < liquidMeasureValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(liquidMeasureArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(liquidMeasureValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(liquidMeasureValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), liquidMeasureArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF LIQUID MEASURE CONVERSIONS------*/

            /*------START OF MASS CONVERIONS------*/
                if (sp1.equals("Mass")) {


                    for (int indexTo = 0; indexTo < massValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(massArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(massValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(massValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), massArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF MASS CONVERSIONS------*/

            /*------START OF POWER CONVERIONS------*/
                if (sp1.equals("Power")) {


                    for (int indexTo = 0; indexTo < powerValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(powerArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(powerValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(powerValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), powerArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF POWER CONVERSIONS------*/

            /*------START OF PRESSURE CONVERIONS------*/
                if (sp1.equals("Pressure")) {


                    for (int indexTo = 0; indexTo < pressureValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(pressureArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(pressureValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(pressureValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), pressureArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF PRESSURE CONVERSIONS------*/

            /*------START OF TORQUE CONVERIONS------*/
                if (sp1.equals("Torque")) {


                    for (int indexTo = 0; indexTo < torqueValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(torqueArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(torqueValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(torqueValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), torqueArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF TORQUE CONVERSIONS------*/

            /*------START OF TEMPERATURE CONVERIONS------*/
                if (sp1.equals("Temperature")) {

                    answer = inputFloat;
                    java.math.BigDecimal temp = inputFloat;
                    java.math.BigDecimal nine = new java.math.BigDecimal("9");
                    java.math.BigDecimal five = new java.math.BigDecimal("5");
                    java.math.BigDecimal thirtyTwo = new java.math.BigDecimal("32");
                    java.math.BigDecimal twoSeventyThree = new java.math.BigDecimal("273.15");
                    java.math.BigDecimal fourFiftyNine = new java.math.BigDecimal("459.67");
                    java.math.BigDecimal onePointEight = new java.math.BigDecimal("1.8");

                    switch (spFrom) {
                        case "°Celsius":
                            if (!textViewDone) {
                                createTextview(temp.toPlainString(), "°Celsius");

                                answer = ((temp.multiply(nine, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN)).divide(five,
                                        new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN)).add(thirtyTwo).stripTrailingZeros();
                                createTextview(answer.toPlainString(), "°Fahrenheit");

                                answer = temp.add(twoSeventyThree);
                                createTextview(answer.toPlainString(), "°Kelvin");

                                answer = ((temp.add(twoSeventyThree)).multiply(nine, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN)).divide(five, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                createTextview(answer.toPlainString(), "°Rankine");

                                textViewDone = true;
                            } else if (textViewDone) {
                                updateTextViews(answer.toPlainString(), 0);

                                answer = ((temp.multiply(nine, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN)).divide(five,
                                        new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN)).add(thirtyTwo).stripTrailingZeros();
                                updateTextViews(answer.toPlainString(), 1);

                                answer = temp.add(twoSeventyThree);
                                updateTextViews(answer.toPlainString(), 2);

                                answer = ((temp.add(twoSeventyThree)).multiply(nine, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN)).divide(five, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                updateTextViews(answer.toPlainString(), 3);
                            }
                            break;

                        case "°Fahrenheit":
                            if (!textViewDone) {
                                answer = ((temp.subtract(thirtyTwo)).multiply(five, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN)).divide(nine, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                createTextview(answer.toPlainString(), "°Celsius");

                                createTextview(temp.toPlainString(), "°Fahrenheit");

                                answer = ((temp.subtract(thirtyTwo)).multiply(five, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN).divide(nine, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN)).add(twoSeventyThree).stripTrailingZeros();
                                createTextview(answer.toPlainString(), "°Kelvin");

                                answer = temp.add(fourFiftyNine);
                                createTextview(answer.toPlainString(), "°Rankine");

                                textViewDone = true;
                            } else if (textViewDone) {
                                answer = ((temp.subtract(thirtyTwo)).multiply(five, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN)).divide(nine, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                updateTextViews(answer.toPlainString(), 0);

                                updateTextViews(temp.toPlainString(), 1);

                                answer = ((temp.subtract(thirtyTwo)).multiply(five, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN).divide(nine, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN)).add(twoSeventyThree).stripTrailingZeros();
                                updateTextViews(answer.toPlainString(), 2);

                                answer = temp.add(fourFiftyNine);
                                updateTextViews(answer.toPlainString(), 3);
                            }
                            break;

                        case "°Kelvin":
                            if (!textViewDone) {
                                answer = temp.subtract(twoSeventyThree);
                                createTextview(answer.toPlainString(), "°Celsius");

                                answer = (temp.multiply(onePointEight, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN)).subtract(fourFiftyNine).stripTrailingZeros();
                                createTextview(answer.toPlainString(), "°Fahrenheit");

                                createTextview(temp.toPlainString(), "°Kelvin");

                                answer = temp.multiply(onePointEight, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                createTextview(answer.toPlainString(), "°Rankine");

                                textViewDone = true;
                            } else if (textViewDone) {
                                answer = temp.subtract(twoSeventyThree);
                                updateTextViews(answer.toPlainString(), 0);

                                answer = (temp.multiply(onePointEight, new MathContext(15, RoundingMode.HALF_UP)).setScale(6,
                                        RoundingMode.HALF_DOWN)).subtract(fourFiftyNine).stripTrailingZeros();
                                updateTextViews(answer.toPlainString(), 1);

                                updateTextViews(temp.toPlainString(), 2);

                                answer = temp.multiply(onePointEight, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                updateTextViews(answer.toPlainString(), 3);
                            }
                            break;

                        case "°Rankine":
                            if (!textViewDone) {
                                answer = (temp.subtract(thirtyTwo).subtract(fourFiftyNine)).divide(onePointEight,
                                        new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                createTextview(answer.toPlainString(), "°Celsius");

                                answer = temp.subtract(fourFiftyNine);
                                createTextview(answer.toPlainString(), "°Fahrenheit");

                                answer = temp.divide(onePointEight, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                createTextview(answer.toPlainString(), "°Kelvin");

                                createTextview(temp.toPlainString(), "°Rankine");

                                textViewDone = true;
                            } else if (textViewDone) {
                                answer = (temp.subtract(thirtyTwo).subtract(fourFiftyNine)).divide(onePointEight,
                                        new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                updateTextViews(answer.toPlainString(), 0);

                                answer = temp.subtract(fourFiftyNine);
                                updateTextViews(answer.toPlainString(), 1);

                                answer = temp.divide(onePointEight, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                                updateTextViews(answer.toPlainString(), 2);

                                updateTextViews(temp.toPlainString(), 3);
                            }
                            break;

                        default:
                            break;
                    }
                }

            /*------END OF TEMPERATURE CONVERSIONS------*/

            /*------START OF TIME CONVERIONS------*/
                if (sp1.equals("Time")) {


                    for (int indexTo = 0; indexTo < timeValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(timeArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(timeValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(timeValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), timeArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF TIME CONVERSIONS------*/

            /*------START OF VELOCITY CONVERIONS------*/
                if (sp1.equals("Velocity")) {


                    for (int indexTo = 0; indexTo < velocityValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(velocityArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(velocityValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(velocityValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), velocityArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF VELOCITY CONVERSIONS------*/

            /*------START OF VISCOSITY DYNAMIC CONVERIONS------*/
                if (sp1.equals("Viscosity Dynamic")) {


                    for (int indexTo = 0; indexTo < viscosityDynValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(viscosityDynArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(viscosityDynValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(viscosityDynValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), viscosityDynArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF VISCOSITY DYNAMIC CONVERSIONS------*/

            /*------START OF VISCOSITY KINEMATIC CONVERIONS------*/
                if (sp1.equals("Viscosity Kinematic")) {


                    for (int indexTo = 0; indexTo < viscosityKinValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(viscosityKinArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(viscosityKinValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(viscosityKinValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), viscosityKinArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF VISCOSITY KINEMATIC CONVERSIONS------*/

            /*------START OF VOLUME CONVERIONS------*/
                if (sp1.equals("Volume")) {


                    for (int indexTo = 0; indexTo < volumeValArr.length; indexTo++) {
                        indexFrom = Arrays.asList(volumeArr).indexOf(spFrom);
                        answer = inputFloat;
                        if (indexFrom < indexTo) {
                            indexFrom += 1;
                            for (int x = indexFrom; x <= indexTo; x++) {
                                java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(volumeValArr[x]));
                                answer = answer.divide(divNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                        } else if (indexFrom > indexTo) {
                            int temp = indexTo;
                            indexTo += 1;
                            for (int x = indexTo; x <= indexFrom; x++) {
                                java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(volumeValArr[x]));
                                answer = answer.multiply(mulNum, new MathContext(15, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_DOWN).stripTrailingZeros();
                            }
                            indexTo = temp;

                        } else if (indexFrom == indexTo)
                            answer = inputFloat;

                        if (!textViewDone)
                            createTextview(answer.toPlainString(), volumeArr[indexTo]);
                        else
                            updateTextViews(answer.toPlainString(), indexTo);

                    }
                    textViewDone = true;
                }

            /*------END OF VOLUME CONVERSIONS------*/

            }

        }

    }


    public void createTextview(String value, String name) {

        final String answerText = value;
        final String unitName = name;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayout llHor = new LinearLayout(getBaseContext());
                llHor.setOrientation(LinearLayout.HORIZONTAL);
                llHor.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                llHor.setPadding(0, 0, 0, 0);

                TextView tv = new TextView(getBaseContext());
                tv.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                tv.setText(answerText);
                tv.setBackgroundResource(R.drawable.data_text_view_left);
                tv.setGravity(Gravity.END);
                tv.setPadding(40, 40, 80, 40);
                tv.setTextColor(Color.parseColor("#3F51B5"));
                tv.setTextSize(20);
                llHor.addView(tv);
                answerTextViewList.add(tv);

                TextView tv1 = new TextView(getBaseContext());
                tv1.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                tv1.setText(unitName);
                tv1.setTextSize(20);
                tv1.setBackgroundResource(R.drawable.data_text_view_right);
                tv1.setTextColor(Color.parseColor("#000000"));
                tv1.setGravity(Gravity.START);
                tv1.setPadding(80, 40, 40, 40);
                llHor.addView(tv1);

                ll.addView(llHor);
            }
        });
    }

    public void updateTextViews(String answer, int index) {
        final String x = answer;
        final int y = index;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                TextView textView = answerTextViewList.get(y);
                textView.setText(x);
            }
        });

    }

    public void deleteTextViews() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ll.removeAllViewsInLayout();
                answerTextViewList.clear();
            }
        });

    }

    public void infoPressed(View view) {
        Intent i = new Intent(MainActivity.this, InfoPage.class);
        startActivity(i);
    }
}
