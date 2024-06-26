package com.example.comp336_proj1;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LED {

    private boolean lighted=false;

    private int ledNumber;
    private double longitude;
    private double latitude; //fixed (250)
    static private double oldLongitude=100;
    private RadioButton radioButton = new RadioButton();        ///////////////////
    private ToggleGroup group;


    public LED() {
        // TODO Auto-generated constructor stub
    }

    public LED(int ledNumber) {

        double newLongitude=oldLongitude+100;
        oldLongitude=oldLongitude+100;

        this.ledNumber = ledNumber;
        this.latitude = 250;
        this.longitude=newLongitude;


        radioButton.setToggleGroup(group);
        radioButton.setPadding(new Insets(-7.5));
//////////////////////////////////////////////////////////////////////////////////
        Canvas canvas = new Canvas();
        canvas.setHeight(64);
        canvas.setWidth(64);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Color backgroundColor = Color.BLACK;
        gc.setFill(backgroundColor);

        Image img=  new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\led (1).png");

        gc.drawImage(img, 0, 0);

        gc.setFont(Font.font(32));

        // Use Text to calculate text width
        Text text = new Text(String.valueOf(ledNumber));
        text.setFont(gc.getFont()); // Set the font for the Text to match the GraphicsContext font
        double textWidth = text.getLayoutBounds().getWidth();

        double x = (canvas.getWidth() - textWidth) / 2;
        double y = (canvas.getHeight() + gc.getFont().getSize()) / 2;

        gc.fillText(String.valueOf(ledNumber), x, y);

        radioButton.setGraphic(canvas);

//////////////////////////////////////////////////////////////////////////////////
//        String toParse=(this.getResourceNumber()).to
        Tooltip tip = new Tooltip(""+this.getLedNumber());
        tip.setFont(new Font(16));

        tip.setStyle("-fx-background-color:grey;");
        tip.setShowDelay(Duration.seconds(0));
        radioButton.setTooltip(tip);

//        radioButton.setOnAction(o -> {
//            if (Main.numOfPointChoice == 0) {
//                ImageView vi0 = new ImageView(new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\location-pin.png"));
//                vi0.setFitHeight(16);
//                vi0.setFitWidth(16);
//                radioButton.setGraphic(vi0);
//            }
//
//            if (Main.numOfPointChoice == 1) {
//                ImageView vi0 = new ImageView(new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\location-pin (2).png"));
//                vi0.setFitHeight(16);
//                vi0.setFitWidth(16);
//                radioButton.setGraphic(vi0);
//            }
//            radioButton.setSelected(true);
//            Main.numOfPointChoice += 1;
//            if (Main.numOfPointChoice == 2) {
//                Main.lock();
//            }
//
////			if (Main.click.isSelected()) {
//            if (Main.numOfPointChoice == 2) {
//                Main.targetCombo.getSelectionModel().select(getLedNumber());
//            }
//            if (Main.numOfPointChoice == 1) {
//                Main.sourceCombo.getSelectionModel().select(getLedNumber());
//            }
////			}
//
//        });
        /////////////////////////////////////////////////
    }

    public int getLedNumber() {
        return ledNumber;
    }

    public void setLedNumber(int ledNumber) {
        this.ledNumber = ledNumber;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(RadioButton radioButton) {
        this.radioButton = radioButton;
    }

    public ToggleGroup getGroup() {
        return group;
    }

    public void setGroup(ToggleGroup group) {
        this.group = group;
    }


    public boolean isLighted() {
        return lighted;
    }

    public void setLighted(boolean lighted) {
        this.lighted = lighted;
    }

    @Override
    public String toString() {
        return "{  @\t" + ledNumber +"\t@  }";
    }
    static public void resetOldLongitude(){
        oldLongitude=100;
    }
}
