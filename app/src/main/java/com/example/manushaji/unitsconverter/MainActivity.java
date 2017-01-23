package com.example.manushaji.unitsconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity implements OnItemSelectedListener {

    public java.math.BigDecimal answer = new java.math.BigDecimal("0");
    public TextView result;
    public EditText input;
    Spinner spinnerSelector, spinnerFrom, spinnerTo;
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
            0.00005486f, 1980f, 0.009090909f, 100f, 1.2f, 0.00000000000045567220764f, 10000f, 0.0254f, 5889679948464570000f, 63241.077088071f};

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
    int indexTo = 0;
    String sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.to_text_view);
        input = (EditText) findViewById(R.id.from_edit_text);

        spinnerSelector = (Spinner) findViewById(R.id.selector_spinner);
        spinnerFrom = (Spinner) findViewById(R.id.from_spinner);
        spinnerTo = (Spinner) findViewById(R.id.to_spinner);

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
            accelerationArr = new String[]{"cm/sec²", "m/sec²", "inch/sec²", "ft/sec²", "g (acc. due to gravity)"};
            ArrayAdapter<String> adapterAcceleration = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, accelerationArr);
            adapterAcceleration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterAcceleration.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterAcceleration);
            spinnerTo.setAdapter(adapterAcceleration);
        }
        if (sp1.equals("Angles")) {
            anglesArr = new String[]{"Degrees (angle)", "Radians", "Arcsecond", "Arcminute",
                    "Full Circle", "Semicircle", "1/4 Circle", "1/6 Circle", "1/8 Circle", "1/10 Circle", "1/12 Circle", "1/16 Circle"};
            ArrayAdapter<String> adapterAngles = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, anglesArr);
            adapterAngles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterAngles.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterAngles);
            spinnerTo.setAdapter(adapterAngles);
        }
        if (sp1.equals("Area")) {
            areaArr = new String[]{"mm²", "cm²", "m²", "in²", "ft²", "yd²", "Hectare", "Acre",
                    "km²", "mi²", "Millimeter Diamater Circle", "Centimeter Diameter Circle", "Meter Diameter Circle",
                    "Inch Diameter Circle", "Foot Diameter Circle", "Yard Diameter Circle"};
            ArrayAdapter<String> adapterArea = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, areaArr);
            adapterArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterArea.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterArea);
            spinnerTo.setAdapter(adapterArea);
        }
        if (sp1.equals("Circular Measure")) {
            circularMeasureArr = new String[]{"Radius", "Diameter", "Circumference"};
            ArrayAdapter<String> adapterCircularMeasure = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, circularMeasureArr);
            adapterCircularMeasure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterCircularMeasure.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterCircularMeasure);
            spinnerTo.setAdapter(adapterCircularMeasure);
        }
        if (sp1.equals("Data Transfer Rate")) {
            dataTransArr = new String[]{"Bit per second", "Kilobit per second", "Kilobyte per second", "Megabit per second", "Megabyte per second",
                    "Gigabit per second", "Gigabyte per second", "Terabit per second", "Terabyte per second"};
            ArrayAdapter<String> adapterDataTrans = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dataTransArr);
            adapterDataTrans.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterDataTrans.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterDataTrans);
            spinnerTo.setAdapter(adapterDataTrans);
        }
        if (sp1.equals("Density")) {
            densityArr = new String[]{"gram/mm³", "gram/cm³", "gram/m³", "gram/liter", "kg/mm³", "kg/cm³", "kg/m³", "kg/liter",
                    "ounce/in³", "ounce/ft³", "ounce/yd³", "lb/in³", "lb/ft³", "lb/yd³", "cwt(short)/m³", "cwt(long)/m³",
                    "ton(short)/m³", "ton(long)/m³", "tonne/m³", "cwt(short)/ft³", "cwt(long)/ft³", "ton(short)/ft³",
                    "ton(long)/ft³", "tonne/ft³", "cwt(short)/yd³", "cwt(long)/yd³", "ton(short)/yd³", "ton(long)/yd³", "tonne/yd³"};
            ArrayAdapter<String> adapterDensity = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, densityArr);
            adapterDensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterDensity.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterDensity);
            spinnerTo.setAdapter(adapterDensity);
        }
        if (sp1.equals("Digital Storage")) {
            digitalStorArr = new String[]{"Bit", "Kilobit", "Kibibit", "Megabit", "Mebibit", "Gigabit", "Gibibit", "Terabit", "Tebibit", "Petabit", "Pebibit",
                    "Byte", "Kilobyte", "Kibibyte", "Megabyte", "Mebibyte", "Gigabyte", "Gibibyte", "Terabyte", "Tebibyte", "Petabyte", "Pebibyte"};
            ArrayAdapter<String> adapterDeiditalStor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, digitalStorArr);
            adapterDeiditalStor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterDeiditalStor.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterDeiditalStor);
            spinnerTo.setAdapter(adapterDeiditalStor);
        }
        if (sp1.equals("Energy")) {
            energyArr = new String[]{"N-m", "kg-m", "ft-lb", "Btu", "Joule", "Kilojoule", "Kilocalorie"};
            ArrayAdapter<String> adapterEnergy = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, energyArr);
            adapterEnergy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterEnergy.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterEnergy);
            spinnerTo.setAdapter(adapterEnergy);
        }
        if (sp1.equals("Flow Rate (Volume)")) {
            flowRateVolArr = new String[]{"liter/sec", "liter/min", "liter/hr", "mm³/sec", "mm³/min", "mm³/hr", "cm³/sec (ml/sec)", "cm³/min (ml/min)",
                    "cm³/hr (ml/hr)", "m³/sec", "m³/min", "m³/hr", "in³/sec", "in³/min", "in³/hr", "ft³/sec", "ft³/min", "ft³/hr", "gpm USA",
                    "gpm UK", "MGD USA", "MGD UK", "Barrels/min (oil)", "Barrels/hr (oil)", "Barrels/day (oil)"};
            ArrayAdapter<String> adapterFlowVol = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, flowRateVolArr);
            adapterFlowVol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterFlowVol.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterFlowVol);
            spinnerTo.setAdapter(adapterFlowVol);
        }
        if (sp1.equals("Flow Rate (Mass)")) {
            flowRateMassArr = new String[]{"gram/sec", "gram/min", "gram/hr", "kg/sec", "kg/min", "kg/hr", "ounce/sec", "ounce/min",
                    "ounce/hr", "lb/sec", "lb/min", "lb/hr", "cwt USA/sec", "cwt UK/sec", "cwt USA/min", "cwt UK/min", "cwt USA/hr", "cwt UK/hr",
                    "ton (short) USA/hr", "ton (long) UK/hr", "tonne (metric)/hr", "ton (short) USA/day", "ton (long) UK/day", "tonne (metric)/day"};
            ArrayAdapter<String> adapterFlowMass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, flowRateMassArr);
            adapterFlowMass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterFlowMass.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterFlowMass);
            spinnerTo.setAdapter(adapterFlowMass);
        }
        if (sp1.equals("Force")) {
            forceArr = new String[]{"Newton", "kg-force", "dyne", "lb-force", "ton-force USA", "ton-force UK", "tonne-force"};
            ArrayAdapter<String> adapterForce = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, forceArr);
            adapterForce.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterForce.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterForce);
            spinnerTo.setAdapter(adapterForce);
        }
        if (sp1.equals("Frequency")) {
            frequencyArr = new String[]{"Hz (Hertz)", "kHz", "MHz", "Cycles/sec", "Cycles/min", "Cycles/hr", "Revolutions/sec", "Revolutions/min (RPM)",
                    "Revolutions/hr", "Radians/sec", "Radians/min", "Radians/hr", "Degrees/sec", "Degrees/min", "Degrees/hr"};
            ArrayAdapter<String> adapterFrequency = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, frequencyArr);
            adapterFrequency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterFrequency.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterFrequency);
            spinnerTo.setAdapter(adapterFrequency);
        }
        if (sp1.equals("Fuel Consumption")) {
            fuelArr = new String[]{"km/liter", "km/gallon USA", "km/gallon UK", "Mile/liter", "Mile/gallon USA", "Mile/gallon UK", "Liter/km", "Gallon USA/km",
                    "Gallon UK/km", "Liter/mile", "Gallon USA/mile", "Gallon UK/mile"};
            ArrayAdapter<String> adapterFuel = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, fuelArr);
            adapterFuel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterFuel.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterFuel);
            spinnerTo.setAdapter(adapterFuel);
        }
        if (sp1.equals("Length")) {
            lengthArr = new String[]{"Kilometer", "Meter", "Centimeter", "Millimeter", "Mile", "Yard", "Foot", "Inch", "Nautical Mile", "Hand",
                    "Furlong", "Fathom", "Cable UK", "Cable USA", "Angstrom", "Micron", "Microinch", "Astronomical Unit", "Lightyear"};
            ArrayAdapter<String> adapterLength = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, lengthArr);
            adapterLength.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterLength.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterLength);
            spinnerTo.setAdapter(adapterLength);
        }
        if (sp1.equals("Lighting")) {
            lightingArr = new String[]{"Lumen/cm²", "Lumen/m² (Lux)", "Lumen/in²", "Lumen/ft²", "Foot-candle"};
            ArrayAdapter<String> adapterLighting = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, lightingArr);
            adapterLighting.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterLighting.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterLighting);
            spinnerTo.setAdapter(adapterLighting);
        }
        if (sp1.equals("Liquid Measure")) {
            liquidMeasureArr = new String[]{"Milliliter (cm³)", "Liter", "Gallon USA", "Gallon UK", "Pint USA", "Pint UK", "Quart USA", "Quart UK",
                    "Fluid Ounce USA", "Fluid Ounce UK", "Barrels (Oil)"};
            ArrayAdapter<String> adapterLiquidMeasure = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, liquidMeasureArr);
            adapterLiquidMeasure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterLiquidMeasure.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterLiquidMeasure);
            spinnerTo.setAdapter(adapterLiquidMeasure);
        }
        if (sp1.equals("Mass")) {
            massArr = new String[]{"Tonne", "Kilogram", "Gram", "Milligram", "Imperial Ton", "US Ton", "Stone", "Pound", "Ounce"};
            ArrayAdapter<String> adapterMass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, massArr);
            adapterMass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterMass.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterMass);
            spinnerTo.setAdapter(adapterMass);
        }
        if (sp1.equals("Power")) {
            powerArr = new String[]{"Watt", "Kilowatt", "Megawatt", "Joule/sec", "Joule/min", "Joule/hr", "kg-m/sec", "kg-m/min", "kg-m/hr", "N-m/sec",
                    "N-m/min", "N-m/hr", "kcal/sec (Steam)", "kcal/min (Steam)", "kcal/hr (Steam)", "Horse Power", "ft-lb/sec", "ft-lb/min", "ft-lb/hr",
                    "Btu/sec (Steam)", "Btu/min (Steam)", "Btu/hr (Steam)", "Ton of Refrigeration"};
            ArrayAdapter<String> adapterPower = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, powerArr);
            adapterPower.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterPower.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterPower);
            spinnerTo.setAdapter(adapterPower);
        }
        if (sp1.equals("Pressure")) {
            pressureArr = new String[]{"N/m²", "Pascal", "Kilopascal", "Millibar", "Bar", "kgf/cm²", "Atmosphere", "mm.H2O", "m.H2O", "in.H2O", "ft.H2O",
                    "mm.Hg (Torr)", "in.Hg", "lbf/in² (psi)", "lbf/ft²", "ton-force (short)/in²", "ton-force (short)/ft²", "ton-force (short)/m²",
                    "ton-force (long)/in²", "ton-force (long)/ft²", "ton-force (long)/m²", "tonne-force/in²", "tonne-force/ft²", "tonne-force/m²"};
            ArrayAdapter<String> adapterPressure = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pressureArr);
            adapterPressure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterPressure.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterPressure);
            spinnerTo.setAdapter(adapterPressure);
        }
        if (sp1.equals("Torque")) {
            torqueArr = new String[]{"N-m", "kg-m", "ounce-foot", "ounce-inch", "lb-foot", "lb-inch", "kW/rpm", "HP/rpm"};
            ArrayAdapter<String> adapterTorque = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, torqueArr);
            adapterTorque.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterTorque.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterTorque);
            spinnerTo.setAdapter(adapterTorque);
        }
        if (sp1.equals("Temperature")) {
            temperatureArr = new String[]{"°Celsius", "°Fahrenheit", "°Kelvin", "°Rankine"};
            ArrayAdapter<String> adapterTemperature = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, temperatureArr);
            adapterTemperature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterTemperature.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterTemperature);
            spinnerTo.setAdapter(adapterTemperature);
        }
        if (sp1.equals("Time")) {
            timeArr = new String[]{"Nanosecond", "Microsecond", "Millisecond", "Second", "Minute", "Hour", "Day", "Week", "Month", "Year", "Decade", "Century"};
            ArrayAdapter<String> adapterTime = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, timeArr);
            adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterTime.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterTime);
            spinnerTo.setAdapter(adapterTime);
        }
        if (sp1.equals("Velocity")) {
            velocityArr = new String[]{"mm/sec", "mm/min", "mm/hr", "cm/sec", "cm/min", "cm/hr", "m/sec", "m/min", "m/hr", "km/sec", "km/min", "km/hr", "inch/sec", "inch/min",
                    "inch/hr", "ft/sec", "ft/min", "ft/hr", "mile/sec", "mile/min", "mile/hr", "Knot", "Mach (Sea Level)"};
            ArrayAdapter<String> adapterVelocity = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, velocityArr);
            adapterVelocity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterVelocity.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterVelocity);
            spinnerTo.setAdapter(adapterVelocity);
        }
        if (sp1.equals("Viscosity Dynamic")) {
            viscosityDynArr = new String[]{"Centipoise", "Poise", "Pascal-sec", "N-sec/m²", "Gram-sec/m²", "Gram-sec/ft²", "kg-sec/m²", "kg-sec/ft²", "lbf-sec/m²", "lbf-sec/ft²"};
            ArrayAdapter<String> adapterViscDyn = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, viscosityDynArr);
            adapterViscDyn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterViscDyn.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterViscDyn);
            spinnerTo.setAdapter(adapterViscDyn);
        }
        if (sp1.equals("Viscosity Kinematic")) {
            viscosityKinArr = new String[]{"lbf-sec/m²", "lbf-sec/ft²", "Centistokes (mm²/sec)", "Stokes (cm²/sec)", "m²/sec"};
            ArrayAdapter<String> adapterViscKin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, viscosityKinArr);
            adapterViscKin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterViscKin.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterViscKin);
            spinnerTo.setAdapter(adapterViscKin);
        }
        if (sp1.equals("Volume / Capacity")) {
            volumeArr = new String[]{"US Liquid Gallon", "US Liquid Quart", "US Liquid Pint", "US Legal Cup", "US Fluid Ounce", "US Tablespoon", "US Teaspoon",
                    "m³", "Liter", "Milliliter", "Imperial Gallon", "Imperial Quart", "Imperial Pint", "Imperial Cup", "Imperial Fluid Ounce",
                    "Imperial Tablespoon", "Imperial Teaspoon", "ft³", "in³"};
            ArrayAdapter<String> adapterVolume = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, volumeArr);
            adapterVolume.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterVolume.notifyDataSetChanged();
            spinnerFrom.setAdapter(adapterVolume);
            spinnerTo.setAdapter(adapterVolume);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void infoPressed(View view) {
        Intent i = new Intent(MainActivity.this, InfoPage.class);
        startActivity(i);
    }

    class calculation extends TimerTask {
        public void run() {

            if (!input.getText().toString().equals("")) {

                String spFrom = String.valueOf(spinnerFrom.getSelectedItem());
                String spTo = String.valueOf(spinnerTo.getSelectedItem());
                java.math.BigDecimal inputFloat = new java.math.BigDecimal(input.getText().toString());

            /*------START OF ACCELERATION CONVERIONS------*/
                if (sp1.equals("Acceleration")) {
                    indexFrom = Arrays.asList(accelerationArr).indexOf(spFrom);
                    indexTo = Arrays.asList(accelerationArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(accelerationValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(accelerationValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF ACCELERATION CONVERSIONS------*/

            /*------START OF ANGLES CONVERIONS------*/
                if (sp1.equals("Angles")) {
                    indexFrom = Arrays.asList(anglesArr).indexOf(spFrom);
                    indexTo = Arrays.asList(anglesArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(anglesValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(anglesValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF ANGLES CONVERSIONS------*/

            /*------START OF AREA CONVERIONS------*/
                if (sp1.equals("Area")) {
                    indexFrom = Arrays.asList(areaArr).indexOf(spFrom);
                    indexTo = Arrays.asList(areaArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(areaValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(areaValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF AREA CONVERSIONS------*/

            /*------START OF CIRCULAR MEASURE CONVERIONS------*/
                if (sp1.equals("Circular Measure")) {
                    indexFrom = Arrays.asList(circularMeasureArr).indexOf(spFrom);
                    indexTo = Arrays.asList(circularMeasureArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(circularMeasureValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(circularMeasureValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF CIRCULAR MEASURE CONVERSIONS------*/

            /*------START OF DATA TRANSFER RATE CONVERIONS------*/
                if (sp1.equals("Data Transfer Rate")) {
                    indexFrom = Arrays.asList(dataTransArr).indexOf(spFrom);
                    indexTo = Arrays.asList(dataTransArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(dataTransValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(dataTransValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF DATA TRANSFER RATE CONVERSIONS------*/

            /*------START OF DENSITY CONVERIONS------*/
                if (sp1.equals("Density")) {
                    indexFrom = Arrays.asList(densityArr).indexOf(spFrom);
                    indexTo = Arrays.asList(densityArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(densityValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(densityValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF DENSITY CONVERSIONS------*/

            /*------START OF DIGITAL STORAGE CONVERIONS------*/
                if (sp1.equals("Digital Storage")) {
                    indexFrom = Arrays.asList(digitalStorArr).indexOf(spFrom);
                    indexTo = Arrays.asList(digitalStorArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(digitalStorValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(digitalStorValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF DIGITAL STORAGE CONVERSIONS------*/

            /*------START OF ENERGY CONVERIONS------*/
                if (sp1.equals("Energy")) {
                    indexFrom = Arrays.asList(energyArr).indexOf(spFrom);
                    indexTo = Arrays.asList(energyArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(energyValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(energyValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF ENERGY CONVERSIONS------*/

            /*------START OF FLOW RATE (VOLUME) CONVERIONS------*/
                if (sp1.equals("Flow Rate (Volume)")) {
                    indexFrom = Arrays.asList(flowRateVolArr).indexOf(spFrom);
                    indexTo = Arrays.asList(flowRateVolArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(flowRateVolValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(flowRateVolValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF FLOW RATE (VOLUME) CONVERSIONS------*/

            /*------START OF FLOW RATE (MASS) CONVERIONS------*/
                if (sp1.equals("Flow Rate (Mass)")) {
                    indexFrom = Arrays.asList(flowRateMassArr).indexOf(spFrom);
                    indexTo = Arrays.asList(flowRateMassArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(flowRateMassValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(flowRateMassValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF FLOW RATE (MASS) CONVERSIONS------*/

            /*------START OF FORCE CONVERIONS------*/
                if (sp1.equals("Force")) {
                    indexFrom = Arrays.asList(forceArr).indexOf(spFrom);
                    indexTo = Arrays.asList(forceArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(forceValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(forceValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF FORCE CONVERSIONS------*/

            /*------START OF FREQUENCY CONVERIONS------*/
                if (sp1.equals("Frequency")) {
                    indexFrom = Arrays.asList(frequencyArr).indexOf(spFrom);
                    indexTo = Arrays.asList(frequencyArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(frequencyValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(frequencyValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF FREQUENCY CONVERSIONS------*/

            /*------START OF FUEL CONSUMPTION CONVERIONS------*/
                if (sp1.equals("Fuel Consumption")) {
                    indexFrom = Arrays.asList(fuelArr).indexOf(spFrom);
                    indexTo = Arrays.asList(fuelArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(fuelValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(fuelValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF FUEL CONSUMPTION CONVERSIONS------*/

            /*------START OF LENGTH CONVERIONS------*/
                if (sp1.equals("Length")) {
                    indexFrom = Arrays.asList(lengthArr).indexOf(spFrom);
                    indexTo = Arrays.asList(lengthArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(lengthValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(lengthValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF LENGTH CONVERSIONS------*/

            /*------START OF LIGHTING CONVERIONS------*/
                if (sp1.equals("Lighting")) {
                    indexFrom = Arrays.asList(lightingArr).indexOf(spFrom);
                    indexTo = Arrays.asList(lightingArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(lightingValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(lightingValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF LIGHTING CONVERSIONS------*/

            /*------START OF LIQUID MEASURE CONVERIONS------*/
                if (sp1.equals("Liquid Measure")) {
                    indexFrom = Arrays.asList(liquidMeasureArr).indexOf(spFrom);
                    indexTo = Arrays.asList(liquidMeasureArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(liquidMeasureValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(liquidMeasureValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF LIQUID MEASURE CONVERSIONS------*/

            /*------START OF MASS CONVERIONS------*/
                if (sp1.equals("Mass")) {

                    indexFrom = Arrays.asList(massArr).indexOf(spFrom);
                    indexTo = Arrays.asList(massArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(massValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(massValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF MASS CONVERSIONS------*/

            /*------START OF POWER CONVERIONS------*/
                if (sp1.equals("Power")) {

                    indexFrom = Arrays.asList(powerArr).indexOf(spFrom);
                    indexTo = Arrays.asList(powerArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(powerValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(powerValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF POWER CONVERSIONS------*/

            /*------START OF PRESSURE CONVERIONS------*/
                if (sp1.equals("Pressure")) {

                    indexFrom = Arrays.asList(pressureArr).indexOf(spFrom);
                    indexTo = Arrays.asList(pressureArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(pressureValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(pressureValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF PRESSURE CONVERSIONS------*/

            /*------START OF TORQUE CONVERIONS------*/
                if (sp1.equals("Torque")) {

                    indexFrom = Arrays.asList(torqueArr).indexOf(spFrom);
                    indexTo = Arrays.asList(torqueArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(torqueValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(torqueValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF TORQUE CONVERSIONS------*/

            /*------START OF TEMPERATURE CONVERIONS------*/
                if (sp1.equals("Temperature")) {

                    answer = inputFloat;
                    java.math.BigDecimal nine = new java.math.BigDecimal("9");
                    java.math.BigDecimal five = new java.math.BigDecimal("5");
                    java.math.BigDecimal thirtyTwo = new java.math.BigDecimal("32");
                    java.math.BigDecimal twoSeventyThree = new java.math.BigDecimal("273.15");
                    java.math.BigDecimal fourFiftyNine = new java.math.BigDecimal("459.67");
                    java.math.BigDecimal onePointEight = new java.math.BigDecimal("1.8");

                    switch (spFrom) {
                        case "°Celsius":
                            if (spTo.equals("°Fahrenheit"))
                                answer = ((answer.multiply(nine)).divide(five, 5)).add(thirtyTwo);
                            else if (spTo.equals("°Kelvin"))
                                answer = answer.add(twoSeventyThree);
                            else if (spTo.equals("°Rankine"))
                                answer = ((answer.add(twoSeventyThree)).multiply(nine)).divide(five, 5);
                            break;


                        case "°Fahrenheit":
                            if (spTo.equals("°Celsius"))
                                answer = ((answer.subtract(thirtyTwo)).multiply(five)).divide(nine, 5);
                            else if (spTo.equals("°Kelvin"))
                                answer = ((answer.subtract(thirtyTwo)).multiply(five).divide(nine, 5)).add(twoSeventyThree);
                            else if (spTo.equals("°Rankine"))
                                answer = answer.add(fourFiftyNine);
                            break;

                        case "°Kelvin":
                            if (spTo.equals("°Celsius"))
                                answer = answer.subtract(twoSeventyThree);
                            else if (spTo.equals("°Fahrenheit"))
                                answer = (answer.multiply(onePointEight)).subtract(fourFiftyNine);
                            else if (spTo.equals("°Rankine"))
                                answer = answer.multiply(onePointEight);
                            break;

                        case "°Rankine":
                            if (spTo.equals("°Celsius"))
                                answer = (answer.subtract(thirtyTwo).subtract(fourFiftyNine)).divide(onePointEight, 5);
                            else if (spTo.equals("°Fahrenheit"))
                                answer = answer.subtract(fourFiftyNine);
                            else if (spTo.equals("°Kelvin"))
                                answer = answer.divide(onePointEight, 5);
                            break;

                        default:
                            break;
                    }
                }

            /*------END OF TEMPERATURE CONVERSIONS------*/

            /*------START OF TIME CONVERIONS------*/
                if (sp1.equals("Time")) {

                    indexFrom = Arrays.asList(timeArr).indexOf(spFrom);
                    indexTo = Arrays.asList(timeArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(timeValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(timeValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF TIME CONVERSIONS------*/

            /*------START OF VELOCITY CONVERIONS------*/
                if (sp1.equals("Velocity")) {

                    indexFrom = Arrays.asList(velocityArr).indexOf(spFrom);
                    indexTo = Arrays.asList(velocityArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(velocityValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(velocityValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF VELOCITY CONVERSIONS------*/

            /*------START OF VISCOSITY DYNAMIC CONVERIONS------*/
                if (sp1.equals("Viscosity Dynamic")) {

                    indexFrom = Arrays.asList(viscosityDynArr).indexOf(spFrom);
                    indexTo = Arrays.asList(viscosityDynArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(viscosityDynValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(viscosityDynValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF VISCOSITY DYNAMIC CONVERSIONS------*/

            /*------START OF VISCOSITY KINEMATIC CONVERIONS------*/
                if (sp1.equals("Viscosity Kinematic")) {

                    indexFrom = Arrays.asList(viscosityKinArr).indexOf(spFrom);
                    indexTo = Arrays.asList(viscosityKinArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(viscosityKinValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(viscosityKinValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF VISCOSITY KINEMATIC CONVERSIONS------*/

            /*------START OF VOLUME CONVERIONS------*/
                if (sp1.equals("Volume / Capacity")) {

                    indexFrom = Arrays.asList(volumeArr).indexOf(spFrom);
                    indexTo = Arrays.asList(volumeArr).indexOf(spTo);
                    answer = inputFloat;

                    if (indexFrom < indexTo) {
                        indexFrom += 1;
                        for (int x = indexFrom; x <= indexTo; x++) {
                            java.math.BigDecimal divNum = new java.math.BigDecimal(String.valueOf(volumeValArr[x]));
                            answer = answer.divide(divNum, 5);
                        }
                    } else if (indexFrom > indexTo) {
                        indexTo += 1;
                        for (int x = indexTo; x <= indexFrom; x++) {
                            java.math.BigDecimal mulNum = new java.math.BigDecimal(String.valueOf(volumeValArr[x]));
                            answer = answer.multiply(mulNum);
                        }
                    }
                }

            /*------END OF VOLUME CONVERSIONS------*/


            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (!input.getText().toString().equals(""))
                        result.setText(answer.toPlainString());
                    else
                        result.setText("0");
                }
            });

        }

    }
}
