package com.example.comp336_proj1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {
    public static File file;

    static int numberOfSources;
    static TextField tf_Sources = new TextField();
    static TextField tf_LEDs = new TextField();
    //	static ToggleButton click = new ToggleButton("Click in map");
//	static ToggleButton combo = new ToggleButton("Combo Box");
//    static int numOfPointChoice = 0;

    //    static VBox vbox = new VBox();
    static String modified_tf_Sources;
    static Pane pane2 = new Pane();

    static VBox vbImages = new VBox();
    static Pane pane3 = new Pane();
    private Alert error = new Alert(AlertType.ERROR);
    ArrayList<PathTable> tableData = new ArrayList<PathTable>();
    ObservableList<PathTable> data = FXCollections.observableArrayList(tableData);
    static ArrayList<Vertex> sourcesList = new ArrayList<>();
    static ArrayList<VertexLED> ledsList = new ArrayList<>();
    static char[] lightedLEDs;//array of lighted LEDs

    static boolean done = false;

    static boolean done2 = false;
//	private static final String IMAGE_Path = "C:\\Users\\97059\\Desktop\\.BZU\\COMP336\\COMP336_3 RESOURCES\\BZU.gif";
//	private static final int MIN_PIXELS = 700;

    public static String TABLE = "";

    public static String returnedRandom = null;

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {
        primaryStage.setTitle("OsaidB_1203115");


        // Create panel
        StackPane mainPane = new StackPane();

        String imageUrl = getClass().getClassLoader().getResource("wallpaper.jpg").toExternalForm();
        Image m = new Image(imageUrl);
        ImageView image = new ImageView(m);


        ///////////////////////////////////////////////////////////////////////////////////
//        VBox vbox = new VBox();
        pane2.getChildren().clear();
        vbImages.getChildren().clear();
//        pane2.getChildren().add(vbImages);
        vbImages.getChildren().add(image);


        pane2.getChildren().add(vbImages);
//		pane2.getChildren().add(imageDup);

        Label title = new Label("OsaidB_1203115");
//		title.setStyle("-fx-background-color: gray");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 0));
        title.setPadding(new Insets(15));


//		scene.getStylesheets().add(		getClass().getClassLoader().getResource("application.css").toExternalForm());
//		String fileUrl = 				getClass().getClassLoader().getResource("oldData.txt").toExternalForm();
//		file = new File(fileUrl);
//		readFile(file);

generateImage();
//		InputStream inputStream = ReadFileFromResources.class.getClassLoader().getResourceAsStream("example.txt");


////        Path filePath = Paths.get(Main.class.getClassLoader().getResource("oldData.txt").toURI());
//        Path filePath = Paths.get(Main.class.getClassLoader().getResource("newData.txt").toURI());
//        file = new File(filePath.toUri());
////        readFile(file);
//        int[] arrayOfLEDs = readFileNew(file);

//        for (int i = 9; i < numberOfSources; i = i + 9) {
//            String imageUrlD = getClass().getClassLoader().getResource("wallpaper.jpg").toExternalForm();
//            Image mD = new Image(imageUrlD);
//            ImageView imageD = new ImageView(mD);
//            vbox.getChildren().add(imageD);
//        }


        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
//        pane.setTop(title);
//        BorderPane.setAlignment(title, Pos.CENTER);

//        pane.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());

        Label choose = new Label("");
        choose.setPadding(new Insets(15));
//
//		ToggleGroup tg = new ToggleGroup();
//		click.setToggleGroup(tg);
//		combo.setToggleGroup(tg);


        ///////////////////////////////////////////////////////////////////////file chooser section
        //file chooser section
        Button btnFileChooser = new Button("READ DATA FROM AN EXTERNAL FILE");
        btnFileChooser.setPrefWidth(440);
//        btnFileChooser.setMinWidth(440);
        btnFileChooser.setMinHeight(50);
        btnFileChooser.setStyle("-fx-background-color: #b5c2c7 ;-fx-font-size: 20px;-fx-font-weight: bold;");

        Button btnRun = new Button("Run");
        btnRun.setPrefWidth(440);
        btnRun.setDisable(true);
//        btnFileChooser.setMinHeight(50);
        btnRun.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;");

        btnFileChooser.setOnAction(e -> {

            resetALL();

            btnRun.setDisable(false);
            btnFileChooser.setDisable(true);

            //open file chooser
            FileChooser fc1 = new FileChooser();
            fc1.setTitle("Choose Path To Read Data From");

            // Set the initial directory
            File initialDirectory = new File("C:\\Users\\97059\\Desktop\\Testing Ground");
            fc1.setInitialDirectory(initialDirectory);

            File file1 = fc1.showOpenDialog(primaryStage);

            if (file1 != null) {
                System.out.println("Selected File: " + file1.getAbsolutePath());


                //read data from the file
                boolean flag= readFile(file1);
                if(flag){
                    System.out.println(numberOfSources);
                    vbImages.getChildren().clear();
                    pane2.getChildren().clear();

                    for (int i = 2; i < numberOfSources; i = i + 9) {
                        String imageUrlD = getClass().getClassLoader().getResource("wallpaper.jpg").toExternalForm();
                        Image mD = new Image(imageUrlD);
                        ImageView imageD = new ImageView(mD);


                        vbImages.getChildren().add(imageD);
//                    add(vbImages);
                    }

                    pane2.getChildren().add(vbImages);

                    addSources();
                    addLEDs();


                } else {
                    resetALL();
                    btnFileChooser.setDisable(false);
                    btnRun.setDisable(true);
                    System.out.println("No file selected.");
                }

            }else{
                resetALL();
                btnFileChooser.setDisable(false);
                btnRun.setDisable(true);
            }


        });

        btnRun.setOnAction(e -> {


            //duplicate "calculate.setOmAction"
            runIT();

            btnFileChooser.setDisable(false);
            btnRun.setDisable(true);
        });

        VBox vbFileChooser = new VBox(btnFileChooser, btnRun);
        vbFileChooser.setPadding(new Insets(20));
        vbFileChooser.setSpacing(30);
        vbFileChooser.setStyle("-fx-border-color: #9d7463; -fx-border-width: 2px;");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////manually section
        //manually section
        Button btnManually = new Button("ENTER DATA MANUALLY");
        btnManually.setPrefWidth(440);
        btnManually.setMinHeight(50);
        btnManually.setStyle("-fx-background-color: #b5c2c7 ;-fx-font-size: 20px;-fx-font-weight: bold;");

        //////////lblSources
        Label lblSources = new Label("Number Of Power Sources :");
        lblSources.setStyle("-fx-text-fill: #dfdbd8;");

        lblSources.setDisable(true);
        lblSources.setPadding(new Insets(7));
//        sourceCombo.setMinWidth(300);
        tf_Sources.setMinHeight(30);
        tf_Sources.setDisable(true);

        VBox vbSources = new VBox(lblSources, tf_Sources);
        vbSources.setAlignment(Pos.TOP_LEFT);

        //////////lblLEDs
        Label lblLEDs = new Label("LEDs (Separated With Commas) :");
        lblLEDs.setDisable(true);
        lblLEDs.setPadding(new Insets(7));
//        targetCombo.setPrefWidth(300);
//        targetCombo.setPrefWidth(300);
        tf_LEDs.setMinHeight(30);
        tf_LEDs.setDisable(true);

        VBox vbLEDs = new VBox(lblLEDs, tf_LEDs);
        vbLEDs.setAlignment(Pos.TOP_LEFT);

        //////////btns

        Button btnModify = new Button("Modify");
        btnModify.setMinWidth(440);
        btnModify.setDisable(true);
        btnModify.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;");

        Button btnSetUP = new Button("Set Up Sources & LEDs");
        btnSetUP.setMinWidth(440);
        btnSetUP.setDisable(true);
        btnSetUP.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;");

        Button run = new Button("Run");
        run.setMinWidth(440);
        run.setDisable(true);
        run.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;");

        Button reset = new Button("Reset");
        reset.setMinWidth(440);
        reset.setDisable(true);
        reset.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;");

        VBox vbBTNS = new VBox(20, btnModify, btnSetUP, run, reset);
        vbBTNS.setAlignment(Pos.TOP_LEFT);

        btnManually.setOnAction(e -> {
            resetALL();
            btnFileChooser.setDisable(false);
            btnRun.setDisable(true);
            lblSources.setDisable(false);
            tf_Sources.setDisable(false);
            lblLEDs.setDisable(false);
//            tf_LEDs.setDisable(false);
//            btnSetUP.setDisable(false);
//            run.setDisable(false);
//            reset.setDisable(false);

            btnManually.setDisable(true);


//            tf_Sources.setOnAction(event -> {
//
//
//            });

            tf_Sources.focusedProperty().addListener((observable, oldValue, newValue) -> {


                if (!done2) {//data hasn't been taken
                    if (!newValue) { // If tf_Sources loses focus

                        if (tf_Sources != null && !tf_Sources.getText().equals("")) {
                            modified_tf_Sources = tf_Sources.getText().replaceAll("[^0-9]", "");
                            tf_Sources.setText(modified_tf_Sources);

                            if (!modified_tf_Sources.equals("")) {
                                numberOfSources = Integer.parseInt(modified_tf_Sources);
                                from_numberOfSources_toSourcesList();
                                done2 = true;
                            }

                        }
//                    else {
//                        showErrorPopup("Invalid Number Of Sources Input", "Enter A Valid Number Of Sources.");
//                    }


//                    addSources();
                    } else {


                        setEnterHandler(tf_Sources, tf_LEDs);
                    }
                } else {//data has been taken

                }
                if (done2) {
                    tf_Sources.setDisable(true);
                    btnModify.setDisable(false);
                    tf_LEDs.setDisable(false);
                }

            });

            tf_LEDs.focusedProperty().addListener((observable, oldValue, newValue) -> {


                if (!done) {//data hasn't been taken


                    if (!newValue) { // If tf_LEDs loses focus

                        if (tf_LEDs != null && !tf_LEDs.getText().equals("")) {
                            String modified_tf_LEDs = tf_LEDs.getText().replaceAll("[^0-9,]", "");
                            if (!modified_tf_LEDs.equals("")) {
                                String lastCharacter = "" + modified_tf_LEDs.charAt(modified_tf_LEDs.length() - 1);
                                if (lastCharacter.equals(",")) {//case: last input is comma
                                    String withoutLastComma = modified_tf_LEDs.substring(0, modified_tf_LEDs.length() - 1);
                                    modified_tf_LEDs = withoutLastComma;
                                }

                                tf_LEDs.setText(modified_tf_LEDs);
                            }


//                    modified_tf_LEDs

                            boolean flag = true; //true means everything  is alright

                            int[] arrayOfLEDs = new int[0];

                            String[] LEDs = modified_tf_LEDs.split(",");


                            int arraySize = LEDs.length;

                            if (modified_tf_Sources != "" && LEDs.length != 0 && (arraySize == (Integer.parseInt(modified_tf_Sources)))) {//cases: 1- {no LEDs}    2- {20 sources -->21 LEDs}
                                arrayOfLEDs = new int[LEDs.length];

                                for (int i = 0; i < LEDs.length; i++) {
                                    String value = LEDs[i];

                                    if (value.length() > modified_tf_Sources.length()) {//case: {9 sources -->one of LEDs is 10}

                                        showErrorPopup("Invalid LED Input", "Enter the values for LEDs in the order you prefer, following these guidelines:\n- Input exactly " + modified_tf_Sources + " LEDs.\n- Use values between 1 and " + modified_tf_Sources + " .\n-Use values between 1 and 20.\n- Avoid duplicating LED values.\n- Separate each LED value with a comma.");
                                        flag = false;//false means that something is wrong, that break has happened, so we don't get inside the second loop
                                        break;

                                    } else {///////////////////////////////////mmmmmmmmmmmmmmmmmaaaaaaaaaaaaaaaaaaiiiiiiiiiinnnnnnnnnnnnnnnnn
                                        arrayOfLEDs[i] = Integer.parseInt(LEDs[i]);
                                    }


                                }
                                if (flag) {

                                    if (hasDuplicates(arrayOfLEDs)) {
//                                        showErrorPopup("Invalid LED Input", "Enter the values for LEDs in the order you prefer, following these guidelines:\n- Input exactly " + modified_tf_Sources + " LEDs.\n- Use values between 1 and " + modified_tf_Sources + " .\n- Separate each LED value with a comma.");
                                        showErrorPopup("Invalid LED Input", "Enter the values for LEDs in the order you prefer, following these guidelines:\n- Input exactly " + modified_tf_Sources + " LEDs.\n- Use values between 1 and " + modified_tf_Sources + " .\n-Use values between 1 and 20.\n- Avoid duplicating LED values.\n- Separate each LED value with a comma.");
                                        done = false;
                                    } else {
                                        int indexOfLED = 0;
                                        for (int led : arrayOfLEDs) {
                                            VertexLED verLed = new VertexLED(new LED(led), indexOfLED++);
                                            ledsList.add(verLed);
                                        }
                                        done = true;
                                    }


                                }


                            } else {
                                showErrorPopup("Invalid LED Input", "Enter the values for LEDs in the order you prefer, following these guidelines:\n- Input exactly " + modified_tf_Sources + " LEDs.\n- Use values between 1 and " + modified_tf_Sources + " .\n-Use values between 1 and 20.\n- Avoid duplicating LED values.\n- Separate each LED value with a comma.");
                                flag = false;//false means that something is wrong, that break has happened, so we don't get inside the second loop
                            }


////////////////////////////////////////////////////////////////////


                            if (flag) {
                                btnSetUP.setDisable(false);
//                                run.setDisable(false);
                                reset.setDisable(false);
                            }
                        }
//                    addSources();
                    } else {
                        tf_LEDs.setOnKeyPressed(event -> {
                            if (event.getCode() == KeyCode.ENTER) {
                                tf_LEDs.getParent().requestFocus();
                            }
                        });
                    }
                } else {//data has been taken


                }
                if (done) {
                    tf_LEDs.setDisable(true);
                    btnModify.setDisable(false);
                }
            });

            btnModify.setOnAction(event -> {
                String tempSource = tf_Sources.getText();
                String tempLED = tf_LEDs.getText();
                resetALL();
                done2 = false;
                done = false;

                tf_Sources.setText(tempSource);
                tf_LEDs.setText(tempLED);

                tf_LEDs.setDisable(false);
                tf_Sources.setDisable(false);
            });

        });

        btnSetUP.setOnAction(e -> {

//            vbImages.getChildren().clear();
            for (int i = 11; i < numberOfSources; i = i + 9) {
                String imageUrlD = getClass().getClassLoader().getResource("wallpaper.jpg").toExternalForm();
                Image mD = new Image(imageUrlD);
                ImageView imageD = new ImageView(mD);
                vbImages.getChildren().add(imageD);
            }

            pane2.getChildren().clear();
            pane2.getChildren().add(vbImages);

//            resetALL();

            addSources();
            addLEDs();

//            lblSources.setDisable(true);
//            tf_Sources.setDisable(true);
//            lblLEDs.setDisable(true);
//            tf_LEDs.setDisable(true);
            btnSetUP.setDisable(true);
            run.setDisable(false);
//            reset.setDisable(true);
//
//
//            runIT();
//
//
//            btnManually.setDisable(false);
        });

        run.setOnAction(e -> {


            lblSources.setDisable(true);
            tf_Sources.setDisable(true);
            lblLEDs.setDisable(true);
            tf_LEDs.setDisable(true);
            btnSetUP.setDisable(true);
            run.setDisable(true);


            System.out.println("preparing to run it");

            System.out.println("sourcesList:" + sourcesList);
            System.out.println("ledsList" + ledsList);
            runIT();

            reset.setDisable(false);
            btnManually.setDisable(false);
//            resetALL();
        });

        reset.setOnAction(l -> {


            btnModify.setDisable(true);
            reset.setDisable(true);

            resetALL();


        });


        //summing up manually section
        VBox vbManually = new VBox(btnManually, vbSources, vbLEDs, vbBTNS);
        vbManually.setPadding(new Insets(20));
        vbManually.setSpacing(30);
        vbManually.setStyle("-fx-border-color: #9d7463; -fx-border-width: 2px;");

//        vbBtn.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////Result Section
        //Result Section
        Button resultsSec = new Button("Results");
        resultsSec.setDisable(true);
        resultsSec.setPrefWidth(480);
        resultsSec.setMinHeight(50);
        resultsSec.setStyle("-fx-background-color: #455954 ;-fx-opacity: 1;-fx-font-size: 20px;-fx-font-weight: bold;");


        Button btnShowTable = new Button("Show Table");
        btnShowTable.setPrefWidth(440);
//        btnShowTable.setDisable(true);
//        btnFileChooser.setMinHeight(50);
        btnShowTable.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;");

        btnShowTable.setOnAction(e -> {


            //duplicate "calculate.setOmAction"
//            runIT();
            showPopupTable();
//            btnFileChooser.setDisable(false);
//            btnShowTable.setDisable(true);
        });

//        Label lblPath = new Label("Shortest Path:");
//        lblPath.setPadding(new Insets(20));
        // path.setMinHeight(200);

//        TextArea t = new TextArea();
////        t.setPadding(new Insets(20));
//        t.setPrefWidth(440);
//        t.setPrefHeight(300);

        HBox h3 = new HBox(btnShowTable);
        h3.setAlignment(Pos.CENTER);

//        Label lblDistance = new Label("Distance (in meters):");
//        lblDistance.setPadding(new Insets(20));

//        TextField distanceText = new TextField();

        HBox h4 = new HBox();
        h4.setAlignment(Pos.CENTER);

        //summing up Result Section
        VBox vbResult = new VBox(resultsSec, h3, h4);
//        vbResult.setPadding(new Insets(20));
        vbResult.setSpacing(30);
        vbResult.setStyle("-fx-border-color: #9d7463; -fx-border-width: 2px;");

//        vbBtn.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        //summing up the two sections ( file chooser & manually )
        VBox summing = new VBox(vbFileChooser, vbManually, vbResult);


        summing.setSpacing(100);

//        btnManually.setOnAction(e -> {
//
//
//
//
//
//        });

        VBox mix = new VBox(10, summing);                //1+2

        mix.setAlignment(Pos.CENTER);

        mix.setSpacing(50);
//        mix.setPadding(new Insets(170, 0, 0, 0));
        /////////////////////////
//		pane3.setPadding(new Insets(100,100,100,100));

//		pane3.setPadding(new Insets(100, 0, 0, 0));

        pane3.getChildren().add(mix);


        HBox mainHbox = new HBox(pane2, pane3);
//        mainHbox.setHgrow(pane2, Priority.ALWAYS);
//        mainHbox.setHgrow(pane3, Priority.ALWAYS);
        mainHbox.setSpacing(30);
        mainHbox.setPadding(new Insets(30));
//        mainHbox.setPadding(new Insets(0, 0, 100, 100));
        mainHbox.setAlignment(Pos.CENTER);


        pane.setCenter(mainHbox);
        pane.setAlignment(mainHbox, Pos.CENTER);


        //Creating the scroll pane
        ScrollPane scroll = new ScrollPane();

        pane.setStyle("-fx-background-color: #565c5e;");
        pane.setMinWidth(2000);
        pane.setMinHeight(1200);

        scroll.setContent(pane);


        scroll.setFitToWidth(true);
//        scroll.setFitToHeight(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//        scroll.setFitToHeight(true);


        scroll.setStyle("-fx-background-color: #565c5e;");

        Scene scene = new Scene(scroll, 2000, 1200);


        scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
//		pane.setStyle("-fx-background-color: black");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateImage() {
        String imageUrlD = getClass().getClassLoader().getResource("wallpaper.jpg").toExternalForm();
        Image mD = new Image(imageUrlD);
        ImageView imageD = new ImageView(mD);
        vbImages.getChildren().add(imageD);


            pane2.getChildren().clear();
            pane2.getChildren().add(vbImages);
    }

    private void setEnterHandler(TextField tfSources, TextField tfLeDs) {
        System.out.println("setEnterHandler called");

        tfSources.setOnKeyPressed(event -> {

            if (event.getCode() == KeyCode.ENTER) {
                tfLeDs.setDisable(false);

                showIfWantRandom(Integer.parseInt(tfSources.getText()));

                if (returnedRandom == null) {


                    if (tfLeDs != null) {
                        tfLeDs.requestFocus();

                    } else {
                        // Handle the case when there is no next TextField
                        tfSources.getParent().requestFocus();
                    }
                }else{
                    tfLeDs.setText(returnedRandom);
                }
            }
        });


    }

    private void resetALL() {
        TABLE="";
        LED.resetOldLongitude();
        Source.resetOldLongitude();

//
//        pane2.getChildren().clear();
////
//            tf_LEDs.clear();
//            tf_Sources.clear();
//
//            distanceText.setText("");
//
//            data.clear();
//            tableData.clear();
//
////            numOfPointChoice = 0;
//
//            pane2.getChildren().add(image);
        vbImages.getChildren().clear();
        pane2.getChildren().clear();

        tf_LEDs.clear();
        tf_Sources.clear();
        vbImages.getChildren().clear();
//        distanceText.setText("");

        data.clear();
        tableData.clear();

//            numOfPointChoice = 0;
        sourcesList.clear();
        ledsList.clear();

        numberOfSources = 0;

        String imageUrl = getClass().getClassLoader().getResource("wallpaper.jpg").toExternalForm();
        Image m = new Image(imageUrl);
        ImageView image = new ImageView(m);

        vbImages.getChildren().clear();
        vbImages.getChildren().add(image);

        pane2.getChildren().clear();
//        pane2.getChildren().add(vbImages);
        pane2.getChildren().add(vbImages);

//        pane2.getChildren().add(image);


//        Image Image = new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\location-pin (1).png");


//        for (Vertex ve : collegesList) {

//            ImageView vi = new ImageView(Image);

//            vi.setFitHeight(16);
//            vi.setFitWidth(16);
//
//            ve.getCollege().getRadioButton().setGraphic(vi);
//            ve.getCollege().getRadioButton().setSelected(false);

//                t.clear();
//            free();

//        }

//        for (Vertex ver : collegesList) {
//            ver.visited = false;
//            ver.previous = null;
//        }
    }

    private void runIT() {

        setupTable();


        Vertex sourceVer = null;
        VertexLED ledVer = null;


        int index = -1;

        for (VertexLED ver : ledsList) {
            if (ver.getLED().isLighted()) {//if the LED is lighted
                ledVer = ver;


                int theLedIs = ver.getLED().getLedNumber();
                sourceVer = sourcesList.get(theLedIs - 1);

//                TABLE = TABLE + "source number:" + sourceVer.getSource().getResourceNumber() + "\t\t source index (num):" + sourceVer.getNum() + "\n";
//                TABLE = TABLE + "led number number:" + ledVer.getLED().getLedNumber() + "\t\t led index (num):" + ledVer.getNum() + "\n";
//                TABLE = TABLE + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n";
                System.out.println("source number:" + sourceVer.getSource().getResourceNumber() + "\t\t source index (num):" + sourceVer.getNum());
                System.out.println("led number number:" + ledVer.getLED().getLedNumber() + "\t\t led index (num):" + ledVer.getNum());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                drawLine(sourceVer, ledVer);
            }
        }


    }


    private void drawLine(Vertex sourceVer, VertexLED ledVer) {
//        List<Vertex> p = new ArrayList<>();
//        Vertex u = p.get(i);
//        Vertex v = p.get(i + 1);


//        Line line = new Line(u.college.getLatitude(), u.college.getLongitude(), v.college.getLatitude(), v.college.getLongitude());

        Line line = new Line(sourceVer.getSource().getLatitude(), sourceVer.getSource().getLongitude(), ledVer.getLED().getLatitude(), ledVer.getLED().getLongitude());

//        Line line = new Line(ledVer.getLED().getLatitude(), ledVer.getLED().getLongitude(),sourceVer.getCollege().getLatitude(), sourceVer.getCollege().getLongitude());
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);

//        vbox.getChildren().add(line);
//        pane2.getChildren().add(vbox);
        pane2.getChildren().add(line);


//        if (Destination == null) {
//            error.setContentText("No path");
//            error.show();
//            return 0;
//        }
//
//
//
//
//
//
//
//


    }


    private void addSources() {
        System.out.println("==================================================");
        System.out.println("Adding Sources To The Screen ( From sourcesList ):");
        System.out.println("==================================================");
//        System.out.println("adding Sources to their lists:");

        for (Vertex ver : sourcesList) {//ArrayList<Vertex> Colleges;
            Source c = ver.getSource();
            System.out.println(c + "added to the screen");

            RadioButton r = c.getRadioButton();
            r.setLayoutY(c.getLongitude());//X
            r.setLayoutX(c.getLatitude());//Y

            pane2.getChildren().add(r);
        }


//
//		for (int i = 0; i < Colleges.size(); i++) {
//
//			RadioButton r = Colleges.get(i).getCollege().getRadioButton();
//			r.setLayoutX(Colleges.get(i).getCollege().getLatitude());
//			r.setLayoutY(Colleges.get(i).getCollege().getLongitude());
//			pane2.getChildren().add(r);
//		}


    }

    private void addLEDs() {
        System.out.println("============================================");
        System.out.println("Adding LEDs To The Screen ( From ledsList ):");
        System.out.println("============================================");

        for (VertexLED ver : ledsList) {//ArrayList<VertexLED> ledsList;
            LED l = ver.getLED();
            System.out.println(l + "added to the screen");

            RadioButton r = l.getRadioButton();
            r.setLayoutY(l.getLongitude());//X
            r.setLayoutX(l.getLatitude());//Y

            pane2.getChildren().add(r);
        }


    }


//    private void addPins() {//oldddddddddddddddddddddddddddddddddddddddddddddddddddddd
//
//        for (Vertex ver : sourcesList) {
//            Source c = ver.getSource();
//
//            RadioButton r = c.getRadioButton();
//            r.setLayoutY(c.getLongitude());//X
//            r.setLayoutX(c.getLatitude());//Y
//
//            pane2.getChildren().add(r);
//        }
//
////
////		for (int i = 0; i < Colleges.size(); i++) {
////
////			RadioButton r = Colleges.get(i).getCollege().getRadioButton();
////			r.setLayoutX(Colleges.get(i).getCollege().getLatitude());
////			r.setLayoutY(Colleges.get(i).getCollege().getLongitude());
////			pane2.getChildren().add(r);
////		}
//
//
//    }

    public static void main(String[] args) {

        launch(args);
    }
//
//    public static void lock() {
//        try {
//            for (int i = 0; i < sourcesList.size(); i++) {
//                sourcesList.get(i).getSource().getRadioButton().setDisable(true);
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

//    public static void free() {
//        try {
//            for (int i = 0; i < collegesList.size(); i++) {
//                collegesList.get(i).getCollege().getRadioButton().setDisable(false);
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

    public void setupTable() {// O(n) = (V(logV+E))
//        String sources = "";    //s2
//        String LEDs = "";       //s1

//        for (int i = 1; i <= numberOfSources; i++) {
//
//            sources = sources + "" + i;
//
//        }


//        for (VertexLED ver : ledsList) {//ArrayList<VertexLED> ledsList;
//            LED l = ver.getLED();
//
//            int t = l.getLedNumber();
//            LEDs = LEDs + "" + t;
//        }
/////////////////////////////////////////////////////////////////////////////////////

        int sourcesSize = sourcesList.size();     // storing length of sources string
        int ledsSize = ledsList.size();            // storing length of LEDs string

        int k = 8 + (4 * sourcesSize) + 2; // #here variable k represents the number of hyphens to print in the first line
        TABLE = TABLE + space(k);
        System.out.print(space(k)); // #printing k number of hyphens
//        TABLE = TABLE + "\n    |    ";
//        System.out.print("\n    |    ");

/////////////////////////////////////////////////////////////////////////////////////

        //     #printing 2nd line of the output where we print the second string letter by letter
//        for (int i = 1; i <= sourcesSize; i++) {
//            TABLE = TABLE + "   " + i;
//            System.out.print("   " + i);
//        }
        TABLE = TABLE + "\n      | S";
        System.out.print("\n      | S");

        for (int i = 1; i <= sourcesSize; i++) {
            TABLE = TABLE + "\t" + sourcesList.get(i - 1).getSource().getResourceNumber();
            System.out.print("\t" + sourcesList.get(i - 1).getSource().getResourceNumber());
        }
//        TABLE = TABLE + "\n";
//        System.out.print("\n");

/////////////////////////////////////////////////////////////////////////////////////
//        TABLE = TABLE + space(k);
//        System.out.print(space(k)); // #printing a line of spaces

        TABLE = TABLE + "\n";
        System.out.print("\n");
        TABLE = TABLE + "    L|";
        System.out.print("    L|");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //core algo.:
        algo(ledsSize, sourcesSize);
//      lcs(sources, LEDs, sourcesLeng, ledsLeng);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TABLE = TABLE + "\n\n\n";
        System.out.println("\n\n\n");

//        char[] lcs = new char[index + 1];

    }

    public static String space(int k) {
        StringBuilder sb = new StringBuilder(150);
        for (int n = 0; n < k; ++n)
            sb.append(' ');
        return sb.toString();
    }

    public static void algo(int ledsSize, int sourcesSize) {
        int[][] L = new int[ledsSize + 1][sourcesSize + 1];     //to store the length of the LCS at each pair of indices (i, j),
        // where i is an index in string X and j is an index in string Y.
//        String m2 = LEDs;
        int nip = 0;

        // #Finding the count and storing the comparsion results
        for (int i = 0; i <= ledsSize; i++) {
            // #iterating through first string
            for (int j = 0; j <= sourcesSize; j++) {
                // #iterating through second string and comparing every letter with 'i'th letter of the first string


                if (i == 0 || j == 0) { // #if either i or j is 0, then comparison result is o and comparsion notation is "  "
                    L[i][j] = 0;
                    TABLE = TABLE + "\t" + L[i][j];
                    System.out.print("\t" + L[i][j]);

                } else if (ledsList.get(i - 1).getLED().getLedNumber() == sourcesList.get(j - 1).getSource().getResourceNumber()) { // # if the letters are same, then the comparison result is diagonal+1 and notation is "\"
                    L[i][j] = L[i - 1][j - 1] + 1;
                    TABLE = TABLE + "\t \\ " + L[i][j];
                    System.out.print("\t \\ " + L[i][j]);
                } else { // # if letters are not same, then comparison result is maximum of the value between the value to the left and to the top
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);

                    if (L[i][j] == L[i - 1][j]) { // # if the value on top is the max then comparison result will be the same value as the top and notation is "^"
                        TABLE = TABLE + "\t^ " + L[i][j];
                        System.out.print("\t^ " + L[i][j]);
                    } else { // # if the value on left is the max then comparison result will be the same value as the left and notation is "<"
                        TABLE = TABLE + "\t< " + L[i][j];
                        System.out.print("\t< " + L[i][j]);
                    }
                }

            }

            if (nip < ledsSize) {
                if (nip < 9) { // # if the number is 2 digits then spaces should be adjusted
                    TABLE = TABLE + "\n" + String.valueOf(nip + 1) + "  " + ledsList.get(nip).getLED().getLedNumber() + "|";
                    System.out.print("\n" + String.valueOf(nip + 1) + "  " + ledsList.get(nip).getLED().getLedNumber() + "|");
                } else {
                    TABLE = TABLE + "\n" + String.valueOf(nip + 1) + " " + ledsList.get(nip).getLED().getLedNumber() + "|";
                    System.out.print("\n" + String.valueOf(nip + 1) + " " + ledsList.get(nip).getLED().getLedNumber() + "|");
                }
                nip += 1;
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //creating algo
        int index = L[ledsSize][sourcesSize];
        int temp = index;

        lightedLEDs = new char[index + 1];/////////////////////////////////////////////////////////////lcs is array of lighted leds
        lightedLEDs[index] = '\u0000'; // Set the terminating character


        //ledsLeng, sourcesLeng);
        //m         n
//        int i = m;//ledsLeng
//        int j = n;//sourcesLeng


//        static ArrayList<Vertex> collegesList = new ArrayList<>();
//        static ArrayList<VertexLED> ledsList = new ArrayList<>();

        int ledsLength = ledsList.size();             //i = m
        int sourcesLength = sourcesList.size();      //j = n

        int i = ledsLength;     //ledsLeng
        int j = sourcesLength;  //sourcesLeng

        int lastIndexX = i;
        while (i > 0 && j > 0) { // # iterating through the stored comparison values from bottom up and storing each matches value in variable 'subsequence'


            //LEDs.charAt(i - 1)        ======>
            int ledNum = ledsList.get(i - 1).getLED().getLedNumber();

            //sources.charAt(j - 1)     ======>
            int sourceNum = sourcesList.get(j - 1).getSource().getResourceNumber();


            if (ledNum == sourceNum) {
                lightedLEDs[index - 1] = (char) ledsList.get(i - 1).getLED().getLedNumber();//     ======> lcs[index - 1] = ledNum
                ledsList.get(i - 1).getLED().setLighted(true);


                lastIndexX = i - 1; // Update the index of the last picked element from string X
                i--;
                j--;
                index--;
            } else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;


        }

        TABLE = TABLE + "\n\n";
        System.out.println("\n");
        //printing the length and value of common leds
        TABLE = TABLE + "Number Of Connected Pairs is: " + String.valueOf(temp) + "\n";
        System.out.println("Number Of Connected Pairs is: " + String.valueOf(temp));


//        String s = "";
//        for (VertexLED ver : ledsList) {
//            s = s + "," + ver.getLED().getLedNumber();
//        }
//        String s2 = "";
//        for (Vertex ver : sourcesList) {
//            s2 = s2 + "," + ver.getSource().getResourceNumber();
//        }

        TABLE = TABLE + "The lighted pairs is ";
        System.out.print("The lighted pairs is ");
        for (VertexLED ver : ledsList) {
            if (ver.getLED().isLighted()) {
                TABLE = TABLE + ver.getLED().getLedNumber();
                System.out.print(ver.getLED().getLedNumber());
                TABLE = TABLE + " ";
                System.out.print(" ");
            }
        }
//        TABLE = TABLE + "\n\nsuiiiiiiiiiiiiii";
//        System.out.println("\nsuiiiiiiiiiiiiii");
        for (int k = 0; k <= temp - 1; k++) {
            TABLE = TABLE + lightedLEDs[k];
            System.out.print(lightedLEDs[k]);
        }

    }


    private static boolean hasDuplicates(int[] array) {
//        int[] temprr = array;
//        Arrays.sort(temprr);
//
//        for (int i = 0; i < temprr.length - 1; i++) {
//            if (temprr[i] == temprr[i + 1]) {
//                return true; // Duplicate found
//            }
//        }
//
//        return false; // No duplicates found

        int n = array.length;

        // Iterate through each element
        for (int i = 0; i < n - 1; i++) {
            // Compare the current element with all subsequent elements
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    // If a duplicate is found, return true
                    return true;
                }
            }
        }

        // If no duplicates are found, return false
        return false;
    }

    public boolean readFile(File file) {
        numberOfSources = 0;
        int[] arrayOfLEDs = new int[0];

        try {
            Scanner sc = new Scanner(file);
//
            String line1 = sc.nextLine();
            numberOfSources = Integer.parseInt(line1);


            String stringWithoutSpaces = sc.nextLine().replaceAll("\\s", "");


            String[] LEDs = stringWithoutSpaces.split(",");


            arrayOfLEDs = new int[LEDs.length];

            for (int i = 0; i < LEDs.length; i++) {

                String resultString = LEDs[i].replaceAll("[^0-9]", "");


                // Parse each string and store the result in the intArray
                arrayOfLEDs[i] = Integer.parseInt(resultString);
            }

            if (hasDuplicates(arrayOfLEDs)) {
                showErrorPopup("Invalid LED Input", "Enter the values for LEDs in the order you prefer, following these guidelines:\n- Input exactly " + modified_tf_Sources + " LEDs.\n- Use values between 1 and " + modified_tf_Sources + " .\n-Use values between 1 and 20.\n- Avoid duplicating LED values.\n- Separate each LED value with a comma.");
                return false;
            }
            sc.close();
        } catch (FileNotFoundException t) {
            TABLE = TABLE + t;
            System.out.println(t);
        }

////////////////////////////////////////////////////////////////////
        from_numberOfSources_toSourcesList();

        int indexOfLED = 0;
        for (int led : arrayOfLEDs) {
            VertexLED verLed = new VertexLED(new LED(led), indexOfLED++);
            ledsList.add(verLed);
        }
        return true;
    }

    public void from_numberOfSources_toSourcesList() {
        int indexOfSource = 0;
        for (int i = 1; i <= numberOfSources; i++) {

            Vertex ver = new Vertex(new Source(i), indexOfSource++);
            sourcesList.add(ver);
        }
    }

    private void showErrorPopup(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.getDialogPane().setStyle("-fx-font-size: 20px;");

        // Show the alert in a pop-up window
        alert.showAndWait();
    }

    private void showPopupTable() {
        // Create a new stage for the popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL); // Prevent interaction with the main stage while the popup is open
        popupStage.setTitle("Header");

        // Create a TextArea inside a ScrollPane
        TextArea textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        textArea.setPadding(new Insets(20));
        textArea.setPrefRowCount(50);
        textArea.setStyle("-fx-font-size: 25;");
        // Add content to the TextArea (you can replace this with your actual content)
        textArea.setText(TABLE);
        TABLE="";
        // Create a layout for the popup scene
        VBox popupLayout = new VBox(10);
        popupLayout.getChildren().addAll(scrollPane);

        // Create the popup scene
        Scene popupScene = new Scene(popupLayout, 1000, 1000);

        // Set the scene for the popup stage
        popupStage.setScene(popupScene);

        // Show the popup stage
        popupStage.showAndWait(); // Show and wait for it to be closed before returning to the main stage
    }

    private String showIfWantRandom(int numberOfLEDs) {
        // Create a confirmation dialog
        Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Confirmation Dialog");
        confirmationDialog.setHeaderText("Do you want to fill The LEDs Randomly?");
        confirmationDialog.setContentText("Choose your option.");

        // Customize the buttons (Yes/No)
        confirmationDialog.getButtonTypes().setAll(javafx.scene.control.ButtonType.YES, javafx.scene.control.ButtonType.NO);
        returnedRandom = null;
        // Show the dialog and wait for a result
        confirmationDialog.showAndWait().ifPresent(response -> {
            if (response == javafx.scene.control.ButtonType.YES) {
                // User clicked Yes, perform the action
                System.out.println("User clicked Yes. Performing the action...");

                returnedRandom = generateRandomOrder(numberOfLEDs);
                // Add your code here to perform the desired action
            } else if (response == javafx.scene.control.ButtonType.NO) {
                // User clicked No, do nothing
                System.out.println("User clicked No. Doing nothing...");
                returnedRandom = null;
            }
        });
//        return returnedRandom;//if null Doing nothing
        return null;
    }

    private String generateRandomOrder(int numberOfLEDs) {
        int[] orderArray = new int[numberOfLEDs];

        // Populate the array with LED numbers from 1 to numberOfLEDs
        for (int i = 0; i < numberOfLEDs; i++) {
            orderArray[i] = i + 1;
        }

        // Shuffle the array to get a random order
        shuffleArray(orderArray);

        // Convert the array to a comma separated string
        return Arrays.stream(orderArray).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    private void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap elements at i and index
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }


}
