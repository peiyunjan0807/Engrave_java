package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class Player extends Application {
    private String songName, songUrl, lyricsFile, ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8;
    private GridPane buttonsPane, operatePane, answersPane;
    private BorderPane allPane, nameBorder;
    private Scene scene;
    private javafx.scene.control.Button homeButton, backOptionButton;
    private Button answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8;
    private Label songNameLabel, lyricsLabel;
    private WebView music;
    private ScrollPane scrollBar;
    private double windowWidth;

    public Player() {}

        @Override
        public void start(Stage stage) throws Exception {
            //set基本資訊
            songName = getParameters().getRaw().get(0);
            songUrl = getParameters().getRaw().get(1);
            lyricsFile = getParameters().getRaw().get(2);
            ans1 = getParameters().getRaw().get(3);
            ans2 = getParameters().getRaw().get(4);
            ans3 = getParameters().getRaw().get(5);
            ans4 = getParameters().getRaw().get(6);
            ans5 = getParameters().getRaw().get(7);
            ans6 = getParameters().getRaw().get(8);
            ans7 = getParameters().getRaw().get(9);
            ans8 = getParameters().getRaw().get(10);

            windowWidth = 1000;
            //allPane整個排版
            allPane = new BorderPane();
            //buttons
            homeButton = new javafx.scene.control.Button("回首頁");
            homeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.close();
                    music.getEngine().load(null);
                    new UI();
                }
            });
            backOptionButton = new Button("題目");
            backOptionButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.close();
                    music.getEngine().load(null);
                    new ListenFrame();
                }
            });
            buttonsPane = new GridPane();
            buttonsPane.setHgap(5);
            buttonsPane.setVgap(8);
            buttonsPane.add(homeButton, 1, 3);
            buttonsPane.add(backOptionButton, 1, 4);
            allPane.setLeft(buttonsPane);

            ///使用者操作部分
            operatePane = new GridPane();
            operatePane.setHgap(10);
            operatePane.setVgap(10);
            //歌名&歌手
            nameBorder = new BorderPane();
            songNameLabel = new Label(songName);
            songNameLabel.setFont(new Font("TimesRoman", 30));
            nameBorder.setCenter(songNameLabel);
            operatePane.add(nameBorder, 0, 0);

            //播放音樂
            music = new WebView();
            music.getEngine().load(songUrl);
            operatePane.add(music, 0, 1);

            //歌詞題目
            lyricsLabel = new Label();
            lyricsLabel.setTooltip(new Tooltip("歌詞"));
            //lyricsLabel
            ReadLyrics rl = new ReadLyrics(lyricsFile);
            String[] temp = rl.read();
            int num = rl.returnNum();
            lyricsLabel.setText(temp[0]);
            for(int i=1; i<num; i++)
                lyricsLabel.setText(lyricsLabel.getText() + "\n" + temp[i]);
            lyricsLabel.setFont(new Font("TimesRoman", 22));
            scrollBar = new ScrollPane(lyricsLabel);
            scrollBar.setMinWidth(windowWidth*0.5);
            operatePane.add(scrollBar, 1, 1);

            //buttons of answers
            answersPane = new GridPane();
            answer1 = new Button("1");
            answer1.setFont(new Font("TimesRoman", 15));
            answer1.setMinWidth(windowWidth*0.125);
            answer1.setMinHeight(50);
            answer1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answer1.setText(ans1);
                }
            });
            answer2 = new Button("2");
            answer2.setFont(new Font("TimesRoman", 15));
            answer2.setMinWidth(windowWidth*0.125);
            answer2.setMinHeight(50);
            answer2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answer2.setText(ans2);
                }
            });
            answer3 = new Button("3");
            answer3.setFont(new Font("TimesRoman", 15));
            answer3.setMinWidth(windowWidth*0.125);
            answer3.setMinHeight(50);
            answer3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answer3.setText(ans3);
                }
            });
            answer4 = new Button("4");
            answer4.setFont(new Font("TimesRoman", 15));
            answer4.setMinWidth(windowWidth*0.125);
            answer4.setMinHeight(50);
            answer4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answer4.setText(ans4);
                }
            });
            answer5 = new Button("5");
            answer5.setFont(new Font("TimesRoman", 15));
            answer5.setMinWidth(windowWidth*0.125);
            answer5.setMinHeight(50);
            answer5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answer5.setText(ans5);
                }
            });
            answer6 = new Button("6");
            answer6.setFont(new Font("TimesRoman", 15));
            answer6.setMinWidth(windowWidth*0.125);
            answer6.setMinHeight(50);
            answer6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answer6.setText(ans6);
                }
            });
            answer7 = new Button("7");
            answer7.setFont(new Font("TimesRoman", 15));
            answer7.setMinWidth(windowWidth*0.125);
            answer7.setMinHeight(50);
            answer7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answer7.setText(ans7);
                }
            });
            answer8 = new Button("8");
            answer8.setFont(new Font("TimesRoman", 15));
            answer8.setMinWidth(windowWidth*0.125);
            answer8.setMinHeight(50);
            answer8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answer8.setText(ans8);
                }
            });

            answersPane.add(answer1, 0, 0);
            answersPane.add(answer2, 1, 0);
            answersPane.add(answer3, 2, 0);
            answersPane.add(answer4, 3, 0);
            answersPane.add(answer5, 0, 1);
            answersPane.add(answer6, 1, 1);
            answersPane.add(answer7, 2, 1);
            answersPane.add(answer8, 3, 1);

            operatePane.add(answersPane, 1, 0);
            allPane.setCenter(operatePane);

            scene = new Scene(allPane, 1000, 625);
            scene.widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    windowWidth = stage.getWidth();
                    scrollBar.setMinWidth(windowWidth*0.5);
                    answer1.setMinWidth(windowWidth*0.125);
                    answer2.setMinWidth(windowWidth*0.125);
                    answer3.setMinWidth(windowWidth*0.125);
                    answer4.setMinWidth(windowWidth*0.125);
                    answer5.setMinWidth(windowWidth*0.125);
                    answer6.setMinWidth(windowWidth*0.125);
                    answer7.setMinWidth(windowWidth*0.125);
                    answer8.setMinWidth(windowWidth*0.125);
                }
            });
            scene.heightProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    windowWidth = stage.getWidth();
                }
            });
            stage.setScene(scene);

            stage.setFullScreen(true);
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    music.getEngine().load(null);
                }
            });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
