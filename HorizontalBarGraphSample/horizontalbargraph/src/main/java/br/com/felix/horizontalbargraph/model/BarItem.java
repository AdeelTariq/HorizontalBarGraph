package br.com.felix.horizontalbargraph.model;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by user on 16/01/2018.
 */

public class BarItem {

    private String description;

    private String text1;
    private String text2;

    private Double value1;
    private Double value2;

    private int colorBar1;
    private int colorBar2;

    private int textColorBar1;
    private int textColorBar2;

    public BarItem (String descript, Double value) {
        this.setDescription (descript);
        this.setValue1 (value);
        this.setText1 (String.valueOf (value));
    }

    public BarItem (String descript, Double value, String text) {
        this.setDescription (descript);
        this.setValue1 (value);
        this.setText1 (text);
    }


    public BarItem (String descript, Double value, Double secondValue) {
        this.setDescription (descript);
        this.setValue1 (value);
        this.setValue2 (secondValue);
        this.setText1 (String.valueOf (value));
        this.setText2 (String.valueOf (secondValue));
    }

    public BarItem (String descript, Double value, int colorBar, int textColorBar) {
        this.setDescription (descript);
        this.setValue1 (value);
        this.setColorBar1 (colorBar);
        this.setTextColorBar1 (textColorBar);
        this.setText1 (String.valueOf (value));
    }


    public BarItem (String descript, Double value, int colorBar, int textColorBar,
                    String text) {
        this.setDescription (descript);
        this.setValue1 (value);
        this.setColorBar1 (colorBar);
        this.setTextColorBar1 (textColorBar);
        this.setText1 (text);
    }

    public BarItem (String descript, Double value, Double secondValue, int colorBar, int
            secondColorBar, int textColorBar, int secondTextColorBar) {
        this.setDescription (descript);
        this.setValue1 (value);
        this.setValue2 (secondValue);
        this.setColorBar1 (colorBar);
        this.setColorBar2 (secondColorBar);
        this.setTextColorBar1 (textColorBar);
        this.setTextColorBar2 (secondTextColorBar);
        this.setText1 (String.valueOf (value));
        this.setText2 (String.valueOf (secondValue));
    }

    public BarItem (String descript, Double value, Double secondValue, int colorBar, int
            secondColorBar,
                    int textColorBar, int secondTextColorBar, String text, String secondText) {
        this.setDescription (descript);
        this.setValue1 (value);
        this.setValue2 (secondValue);
        this.setColorBar1 (colorBar);
        this.setColorBar2 (secondColorBar);
        this.setTextColorBar1 (textColorBar);
        this.setTextColorBar2 (secondTextColorBar);
        this.setText1 (text);
        this.setText2 (secondText);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue1() {
        return value1;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    public int getColorBar1() {
        return colorBar1 != 0 ? colorBar1 : getRandomColor();
    }

    public void setColorBar1(int colorBar1) {
        this.colorBar1 = colorBar1;
    }

    public int getColorBar2() {
        return colorBar2 != 0 ? colorBar2 : getRandomColor();
    }

    public void setColorBar2(int colorBar2) {
        this.colorBar2 = colorBar2;
    }

    public int getTextColorBar1() {
        return textColorBar1 != 0 ? textColorBar1 : getRandomColor();
    }

    public void setTextColorBar1(int textColorBar1) {
        this.textColorBar1 = textColorBar1;
    }

    public int getTextColorBar2() {
        return textColorBar2 != 0 ? textColorBar2 : getRandomColor();
    }

    public void setTextColorBar2(int textColorBar2) {
        this.textColorBar2 = textColorBar2;
    }

    public String getText1 () {
        return text1;
    }

    public void setText1 (String text1) {
        this.text1 = text1;
    }

    public String getText2 () {
        return text2;
    }

    public void setText2 (String text2) {
        this.text2 = text2;
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
