package com.example.comp336_proj1;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Source {

    private int resourceNumber;
    private double longitude;
    private double latitude; //fixed (1100)
    static private double oldLongitude=100;
    private RadioButton radioButton = new RadioButton();        ///////////////////
    private ToggleGroup group;


    public Source() {
        // TODO Auto-generated constructor stub
    }

    public Source(int resourceNumber) {

        double newLongitude=oldLongitude+100;
        oldLongitude=oldLongitude+100;

        this.resourceNumber = resourceNumber;
        this.latitude = 1100;
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

        Image img=  new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\location-pin (1).png");

        gc.drawImage(img, 0, 0);

        gc.setFont(Font.font(32));

        // Use Text to calculate text width
        Text text = new Text(String.valueOf(resourceNumber));
        text.setFont(gc.getFont()); // Set the font for the Text to match the GraphicsContext font
        double textWidth = text.getLayoutBounds().getWidth();

        double x = (canvas.getWidth() - textWidth) / 2;
        double y = (canvas.getHeight() + gc.getFont().getSize()) / 2;

        gc.fillText(String.valueOf(resourceNumber), x, y);

        radioButton.setGraphic(canvas);

//////////////////////////////////////////////////////////////////////////////////////
//        String toParse=(this.getResourceNumber()).to
        Tooltip tip = new Tooltip(""+this.getResourceNumber());
        tip.setFont(new Font(16));

        tip.setStyle("-fx-background-color:grey;");
        tip.setShowDelay(Duration.seconds(0));
        radioButton.setTooltip(tip);
        
    }

    public int getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(int resourceNumber) {
        this.resourceNumber = resourceNumber;
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

//	@Override
//	public String compareTo(College compareCol) {
//		String compareName		= ((College)compareCol).getName();
//
//
//		//  For Ascending order
//		return compareName;
//
//
//	}


//	public double getX() {
//		return latitude;
//	}
//
//	public void setX(double x) {
//		this.x = x;
//	}
//
//	public double getY() {
//		return longitude;
//	}
//
//	public void setY(double y) {
//		this.y = y;
//	}

    @Override
    public String toString() {
        return "{" + resourceNumber + '}';
    }
    static public void resetOldLongitude(){
        oldLongitude=100;
    }
}
