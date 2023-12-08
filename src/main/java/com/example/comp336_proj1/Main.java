package com.example.comp336_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;


public class Main extends Application {
	public static File file;
	static ComboBox<String> sourceText = new ComboBox<String>();
	static ComboBox<String> targetText = new ComboBox<String>();
//	static ToggleButton click = new ToggleButton("Click in map");
//	static ToggleButton combo = new ToggleButton("Combo Box");
	static int numOfPointChoice = 0;
	static Pane pane2 = new Pane();
	private Alert error = new Alert(AlertType.ERROR);
	ArrayList<PathTable> tableData = new ArrayList<PathTable>();
	ObservableList<PathTable> data = FXCollections.observableArrayList(tableData);
	static ArrayList<Vertex> Colleges = new ArrayList<>();


//	private static final String IMAGE_Path = "C:\\Users\\97059\\Desktop\\.BZU\\COMP336\\COMP336_3 RESOURCES\\BZU.gif";
//	private static final int MIN_PIXELS = 700;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("OsaidB_1203115");



		// Create panel
		StackPane zoomPane = new StackPane();
		zoomPane.getChildren().add(new Circle(100, 100, 10));
		zoomPane.getChildren().add(new Circle(200, 200, 20));

// Create operator


// Listen to scroll events (similarly you could listen to a button click, slider, ...)
//		zoomPane.setOnScroll(new EventHandler<ScrollEvent>() {
//			@Override
//			public void handle(ScrollEvent event) {
//				double zoomFactor = 1.5;
//				if (event.getDeltaY() <= 0) {
//					// zoom out
//					zoomFactor = 1 / zoomFactor;
//				}
//				zoomOperator.zoom(zoomPane, zoomFactor, event.getSceneX(), event.getSceneY());
//			}
//		});











		Image m = new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\BZU.gif");
		ImageView image = new ImageView(m);
		image.setFitWidth(1122);//955
		image.setFitHeight(1309); //536


//		image.setFitHeight(536); //536
//		image.setFitWidth(955);//955















		///////////////////////////////////////////////////////////////////////////////////
		pane2.getChildren().add(image);


		Label title = new Label("OsaidB_1203115");
//		title.setStyle("-fx-background-color: gray");
		title.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 0));
		title.setPadding(new Insets(15));
		file = new File("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\Data.txt");
		readFile(file);

		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10));
		pane.setTop(title);
		BorderPane.setAlignment(title, Pos.CENTER);

		Label choose = new Label("Choose College by :");
		choose.setPadding(new Insets(15));
//
//		ToggleGroup tg = new ToggleGroup();
//		click.setToggleGroup(tg);
//		combo.setToggleGroup(tg);
//
//
//		click.setOnAction(e -> {
//			click.setStyle("-fx-border-radius: 25 25 25 25;\n" + "-fx-font-size: 14;\n"
//					+ "-fx-font-family: Times New Roman;\n" + "-fx-font-weight: Bold;\n" + " -fx-text-fill: #ff6800;\n"
//					+ "-fx-background-color: #d8d9e0;\n" + "-fx-border-color: #d8d9e0;\n" + "-fx-border-width:  3.5;"
//					+ "-fx-background-radius: 25 25 25 25");
//			combo.setStyle("-fx-border-radius: 25 25 25 25;\n" + "-fx-font-size: 14;\n"
//					+ "-fx-font-family: Times New Roman;\n" + "-fx-font-weight: Bold;\n"
//					+ "-fx-background-color: #f6f6f6;\n" + "-fx-border-color: #d8d9e0;\n" + "-fx-border-width:  3.5;"
//					+ "-fx-background-radius: 25 25 25 25");
//
//		});
//
//		combo.setOnAction(e -> {
//			combo.setStyle("-fx-border-radius: 25 25 25 25;\n" + "-fx-font-size: 14;\n"
//					+ "-fx-font-family: Times New Roman;\n" + "-fx-font-weight: Bold;\n" + " -fx-text-fill: #ff6800;\n"
//					+ "-fx-background-color: #d8d9e0;\n" + "-fx-border-color: #d8d9e0;\n" + "-fx-border-width:  3.5;"
//					+ "-fx-background-radius: 25 25 25 25");
//			click.setStyle("-fx-border-radius: 25 25 25 25;\n" + "-fx-font-size: 14;\n"
//					+ "-fx-font-family: Times New Roman;\n" + "-fx-font-weight: Bold;\n"
//					+ "-fx-background-color: #f6f6f6;\n" + "-fx-border-color: #d8d9e0;\n" + "-fx-border-width:  3.5;"
//					+ "-fx-background-radius: 25 25 25 25");
//
//		});

		sourceText.setOnAction(e -> {
//
//			if (/*a collage selected-> use it in combobox*/) {
//
//			}


				for (int i = 0; i < Colleges.size(); i++) {
					if (Colleges.get(i).getCollege().getName().equals(sourceText.getSelectionModel().getSelectedItem())) {

						ImageView vi0 = new ImageView(new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\location-pin.png"));
						vi0.setFitHeight(16);
						vi0.setFitWidth(16);

						Colleges.get(i).getCollege().getRadioButton().setGraphic(vi0);
						Colleges.get(i).getCollege().getRadioButton().setSelected(true);//////////////////////////////////
						numOfPointChoice += 1;
//						if (numOfPointChoice == 2) {
//							lock();
//						}
						break;
					}
				}

		});

//		targetText.setOnAction(e -> {
//
//				for (int i = 0; i < Colleges.size(); i++) {
//					if (Colleges.get(i).getCollege().getName()
//							.equals(targetText.getSelectionModel().getSelectedItem())) {
//						ImageView vi0 = new ImageView(new Image(
//								"C:\\Users\\97059\\Desktop\\.BZU\\COMP336\\COMP336_3 RESOURCES\\location-pin (2).png"));
//						vi0.setFitHeight(16);
//						vi0.setFitWidth(16);
//						Colleges.get(i).getCollege().getRadioButton().setGraphic(vi0);
//						Colleges.get(i).getCollege().getRadioButton().setSelected(true);
//						numOfPointChoice += 1;
//						if (numOfPointChoice == 2) {
//							lock();
//						}
//						break;
//					}
//				}
//
//		});
		targetText.setOnAction(e -> {

			for (Vertex v:Colleges) {
				if (v.getCollege().getName()
						.equals(targetText.getSelectionModel().getSelectedItem())) {

					ImageView vi0 = new ImageView(new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\location-pin (2).png"));

					vi0.setFitHeight(16);
					vi0.setFitWidth(16);

					v.getCollege().getRadioButton().setGraphic(vi0);
					v.getCollege().getRadioButton().setSelected(true);
					numOfPointChoice += 1;
					if (numOfPointChoice == 2) {
						lock();
					}
					break;
				}


			}

//			for (int i = 0; i < Colleges.size(); i++) {
//
//			}

		});

		/////////////////////////////////////////////////////////////////////
		Label source = new Label("Source :");
		source.setPadding(new Insets(7));
		sourceText.setMinWidth(150);
		for (int i = 0; i < Colleges.size(); i++) {
			sourceText.getItems().add(Colleges.get(i).getCollege().getName());
		}


		Label target = new Label("Target :");
		target.setPadding(new Insets(7));
		targetText.setMinWidth(150);
		for (int i = 0; i < Colleges.size(); i++) {
			targetText.getItems().add(Colleges.get(i).getCollege().getName());
		}

		HBox h1 = new HBox(source, sourceText);
		h1.setAlignment(Pos.CENTER);

		HBox h2 = new HBox(target, targetText);
		h2.setAlignment(Pos.CENTER);
		/////////////////////////////////////////////////////////////////////

		Button run = new Button("Calculate");
		Button reset = new Button("Reset");

		HBox butBox = new HBox(20, run, reset);
		butBox.setAlignment(Pos.CENTER);

		/////////////////////////////////////////////////////////////////////

		Label path = new Label("Shortest Path:");
		path.setPadding(new Insets(7));
		// path.setMinHeight(200);
		path.setPadding(new Insets(7));

		TextArea t = new TextArea();
		t.setPrefWidth(300);
		t.setPrefHeight(300);

		HBox h3 = new HBox(path, t);
		h3.setAlignment(Pos.CENTER);

		/////////////////////////////////////////////////////////////////////

		Label distance = new Label("Distance (in meters):");
		distance.setPadding(new Insets(7));
		TextField distanceText = new TextField();

		HBox h4 = new HBox(distance, distanceText);
		h4.setAlignment(Pos.CENTER);

		/////////////////////////////////////////////////////////////////////

		VBox v = new VBox(30, h1, h2, butBox);		//1
		v.setAlignment(Pos.CENTER);
		v.setPadding(new Insets(10));

		VBox v1 = new VBox(30, h3, h4);				//2
		v1.setAlignment(Pos.CENTER);
		v1.setPadding(new Insets(10));

		VBox mix = new VBox(10, v, v1);				//1+2
		mix.setAlignment(Pos.CENTER);

		VBox vMap = new VBox(pane2);					///////
		vMap.setAlignment(Pos.CENTER);

		HBox mainBox = new HBox(20, vMap, mix);		//all
		mainBox.setAlignment(Pos.CENTER);

		/////////////////////////////////////////////////////////////////////
		pane.setCenter(mainBox);

		addPins();///////////////////////////////////////////////////////////

		run.setOnAction(e -> {
			Vertex vertx1 = null;
			Vertex vertx2 = null;

			String s1 = sourceText.getValue();
			System.out.println(s1);

			String s2 = targetText.getValue();
			System.out.println(s2);

			for (int i = 0; i < Colleges.size(); i++) {
				if (Colleges.get(i).getCollege().getName().equals(s1)) {
					vertx1 = Colleges.get(i);
				}
				if (Colleges.get(i).getCollege().getName().equals(s2)) {
					vertx2 = Colleges.get(i);
				}
			}

			if (vertx1 != null && vertx2 != null) {
				int i = drawLine(Dijkstra(vertx1, vertx2));
				if (i == 0)
					distanceText.setText("0");
				else if (i == 1)
					distanceText.setText(String.valueOf(vertx2.distance));
				data = FXCollections.observableArrayList(tableData);
				t.setText("" + data);

			}

		});

		reset.setOnAction(l -> {
			pane2.getChildren().clear();

			targetText.getSelectionModel().select(null);
			sourceText.getSelectionModel().select(null);

			distanceText.setText("");

			data.clear();
			tableData.clear();

			numOfPointChoice = 0;

			pane2.getChildren().add(image);

			Image Image = new Image("H:\\.BZU MAIN\\.BZU\\.BZU.OLD\\3.2\\COMP336\\COMP336_3 RESOURCES\\location-pin (1).png");



			for (Vertex ve : Colleges) {

				ImageView vi = new ImageView(Image);

				vi.setFitHeight(16);
				vi.setFitWidth(16);

				ve.getCollege().getRadioButton().setGraphic(vi);
				ve.getCollege().getRadioButton().setSelected(false);

				t.clear();
				free();

			}

			for (Vertex ver : Colleges) {
				ver.visited = false;
				ver.previous = null;
			}

			addPins();

		});

//		addPoint();
//		pane.getChildren().add(zoomPane);

		zoomPane.getChildren().add(pane);
		zoomPane.setAlignment(Pos.CENTER);


		//Creating the scroll pane
		ScrollPane scroll = new ScrollPane(zoomPane);

//		scroll.setPrefSize(595, 200);

		//Setting content to the scroll pane

//		scroll.setContent(zoomPane);

		//Setting the stage
//		Group root = new Group();
//		root.getChildren().addAll(scroll);



		Scene scene = new Scene(scroll);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		pane.setStyle("-fx-background-color: black");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private int drawLine(Vertex Destination) {
		if (Destination == null) {
			error.setContentText("No path");
			error.show();
			return 0;

		} else {
			List<Vertex> p = new ArrayList<>();
			for (Vertex v = Destination; v != null; v = v.previous) {
				System.out.print("-->" + v.college.getName() + " ");

				p.add(v);
			}
			System.out.println();
			// V
			Collections.reverse(p);

			if (p.size() >= 1) {
				for (int i = 1; i < p.size(); i++) {
					double d = Destination.getDistance();
					// double d = Distance(p.get(i - 1), p.get(i));
					tableData.add(new PathTable(d, p.get(i - 1).getCollege().getName(), p.get(i).getCollege().getName()));
				}

			} else if (p.size() <= 1) {
				error.setContentText("No path");
				error.show();
			}


			for (int i = 0; i < p.size() - 1; i++) {
				Vertex u = p.get(i);
				Vertex v = p.get(i + 1);

//				if (i != 0 && i != p.size() - 1) {
//					ImageView vi0 = new ImageView(new Image(
//							"C:\\Users\\97059\\Desktop\\.BZU\\COMP336\\COMP336_3 RESOURCES\\location-pin (4).png"));
//					vi0.setFitHeight(16);
//					vi0.setFitWidth(16);
//					u.getCollege().getRadioButton().setGraphic(vi0);
//				}

				Line line = new Line(u.college.getLatitude(), u.college.getLongitude(), v.college.getLatitude(), v.college.getLongitude());
				pane2.getChildren().add(line);
			}
		}
		return 1;

	}

	private void addPins() {

		for (Vertex ver : Colleges) {
			College c=ver.getCollege();

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

	public static void main(String[] args) {

		launch(args);
	}

	public static void lock() {
		try {
			for (int i = 0; i < Colleges.size(); i++) {
				Colleges.get(i).getCollege().getRadioButton().setDisable(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void free() {
		try {
			for (int i = 0; i < Colleges.size(); i++) {
				Colleges.get(i).getCollege().getRadioButton().setDisable(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Vertex Dijkstra(Vertex SourceVer, Vertex targetVer) {// O(n) = (V(logV+E))
		SourceVer.distance = 0;
		if (SourceVer == targetVer) {
			return null;
		}

		PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() { // Log V
			@Override
			public int compare(Vertex v1, Vertex v2) {
				return Double.compare(v1.distance, v2.distance);
			}
		});

		pq.add(SourceVer);

		while (!pq.isEmpty()) { // V
			Vertex u = pq.poll(); //// Log V

			u.visited = true;
			if (u.college.getName().equals(targetVer.getCollege().getName())) {
				break;
			}
			for (edges e : u.getE()) { // E
				Vertex v = e.desination;
				if (!v.visited) {
					double weight = e.weight;
					double distanceThroughU = u.distance + weight;
					if (distanceThroughU < v.distance) {
						v.distance = distanceThroughU;
						v.previous = u;
						pq.add(v);
					}
				}
			}
		}

		return targetVer;
	}

	public static void readFile(File file) {
		try {
			Scanner sc = new Scanner(file);
			String[] l = sc.nextLine().split(":");

			int numCounter = Integer.parseInt(l[0]);
			int numEdge = Integer.parseInt(l[1]);


			int num = 0;
			int count = 0;
			while (count < numCounter) {
				String line = sc.nextLine();
				System.out.println(line);
				Vertex ver = new Vertex(new College(line), num++);
				Colleges.add(ver);
				count++;
			}

			count = 0;
			while (count < numEdge) {
				String tokens[] = sc.nextLine().split(":");
				System.out.println(tokens[2]);
				for (int i = 0; i < Colleges.size(); i++) {
					if (Colleges.get(i).getCollege().getName().compareToIgnoreCase(tokens[0]) == 0) {
						for (int j = 0; j < Colleges.size(); j++) {

							if (Colleges.get(j).getCollege().getName().compareToIgnoreCase(tokens[1]) == 0) {
								Colleges.get(i).e.add(
										new edges(Colleges.get(i), Colleges.get(j), Double.parseDouble(tokens[2])));
							}
						}
					}
				}
				count++;
			}
			sc.close();
		} catch (FileNotFoundException t) {
			System.out.println(t);
		}


//		Collections.sort(Colleges, Colleges.coNameComparator);

//		Collections.sort(Colleges);

	}

}
