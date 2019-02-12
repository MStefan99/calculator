package com.annushkaproject.programmerscalculator.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.annushkaproject.programmerscalculator.R;
import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Operator;
import com.annushkaproject.programmerscalculator.utils.InstanceStateUtil;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

import java.util.ArrayList;

public class StandardFragment extends Fragment {

    private TextView textView;
    private ArrayList<Button> numberButtons = new ArrayList<>();
    private ArrayList<Button> operatorButtons = new ArrayList<>();

    private CalculationModel calcModel = new CalculationModel();
    private boolean secondValueInputStarted = false;
    private boolean secondValueInputInProgress = false;

    private String packageName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME");
            calcModel = InstanceStateUtil.restoreSavedInstance(savedInstanceState);
        }
        return inflater.inflate(R.layout.fragment_standard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = getView().findViewById(R.id.inputField);

        fillNumberButtons();
        fillOperatorButtons();

        setupCalculateButton();
        setupDeleteButton();
        setupClearButton();
        setupSignButton();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        InstanceStateUtil.saveInstanceState(outState, calcModel, packageName);
    }

    public void setupFragment(String packageName) {
        this.packageName = packageName;
    }

    private void fillNumberButtons() {
        for (int i = 0; i < 10; i++) {
            Button button = getView().findViewById(getResources().getIdentifier("button" + i, "id",
                    packageName));
            button.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Button button = (Button)v;
                                              System.out.println(button.getText().toString());

                                              usePressedNumber(button.getText().toString());
                                          }
                                      }
            );

            numberButtons.add(button);
        }

        //Adding "." button separately
        Button button = getView().findViewById(R.id.buttonComma);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Button button = (Button)v;
                                          System.out.println(button.getText().toString());

                                          if (!currentString().contains(".")) {
                                              usePressedNumber(button.getText().toString());
                                          }
                                      }
                                  }
        );
        this.numberButtons.add(button);
    }

    private String currentString() {
        return textView.getText().toString();
    }

    private void fillOperatorButtons() {
        //TODO: add additional operators for landscape.

        this.operatorButtons.add(getView().findViewById(R.id.buttonPlus));
        this.operatorButtons.add(getView().findViewById(R.id.buttonMinus));
        this.operatorButtons.add(getView().findViewById(R.id.buttonDivide));
        this.operatorButtons.add(getView().findViewById(R.id.buttonMultiply));
        this.operatorButtons.add(getView().findViewById(R.id.buttonPercent));

        for (Button button : operatorButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Button button = (Button)v;
                                              System.out.println(button.getText().toString());

                                              Operator operator = Operator.operatorForTitle(button.getText().toString());
                                              usePressedOperator(operator);
                                          }
                                      }

            );
        }
    }

    private void setupCalculateButton() {
        Button equalsButton = getView().findViewById(R.id.buttonEquals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Button button = (Button)v;
                                                System.out.println(button.getText().toString());

                                                useEqualsOperator();
                                            }
                                        }
        );
    }

    private void setupDeleteButton() {
        Button delButton = getView().findViewById(R.id.buttonDel);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentString = currentString();
                if (currentString.length() > 1) {
                    currentString = currentString.substring(0, currentString.length() - 1);
                    textView.setText(currentString);
                } else {
                    setTextViewValue(0.0);
                }
            }
        });
    }

    private void setupClearButton() {
        Button clearButton = getView().findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextViewValue(0.0);
                calcModel.resetCalcState();
            }
        });
    }

    public void setupSignButton() {
        Button signButton = getView().findViewById(R.id.buttonSign);
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double currentValue = Double.parseDouble(currentString());
                String updatedString = currentString();
                if (currentValue > 0) {
                    updatedString = "-" + updatedString;
                } else {
                    updatedString = updatedString.substring(1);
                }

                textView.setText(updatedString);
            }
        });
    }

    private void usePressedNumber(String number) {
        if (currentString().equals("0") && !number.equals(".")) {
            textView.setText(""); //clear text view from 0 value.
        }

        String newString;
        if (secondValueInputStarted) {
            newString = number;
            secondValueInputStarted = false;
            secondValueInputInProgress = true;
        } else {
            newString = textView.getText().toString() + number;
        }

        textView.setText(newString);

        if (secondValueInputInProgress) {
            calcModel.setSecondValue(Double.parseDouble(textView.getText().toString()));
        } else {
            calcModel.setFirstValue(Double.parseDouble(textView.getText().toString()));
        }
    }

    private void usePressedOperator(Operator operator) {
        boolean readyToCalcOneSide = calcModel.getOperator() != null && !calcModel.getOperator().requiresTwoValues() && calcModel.getFirstValue() != null;
        boolean readyToCalcTwoSides = calcModel.getOperator() != null && calcModel.getFirstValue() != null && calcModel.getSecondValue() != null;
        if (readyToCalcOneSide || readyToCalcTwoSides) {
            calculateResult();
        }

        calcModel.setOperator(operator);

        if (operator == Operator.PERCENT) {
            calculateResult();
        } else {
            secondValueInputStarted = true;
        }
    }

    private void useEqualsOperator() {
        if (calcModel.getOperator() == null) {
            return;
        }

        calculateResult();
    }

    private void calculateResult() {
        double result = StandardOperationsUtil.calculateWithData(calcModel);
        setTextViewValue(result);

        calcModel.resetCalcState();
        secondValueInputInProgress = false;

        calcModel.setFirstValue(result);
    }

    private void setTextViewValue(Double value) {
        boolean isWholeValue = value % 1 == 0;

        if (isWholeValue) {
            textView.setText(String.format("%.0f", value));
        } else {
            textView.setText(Double.toString(value));
        }
    }

}
