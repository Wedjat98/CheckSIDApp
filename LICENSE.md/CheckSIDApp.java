//正規表現を使ったので、import　Pattern／Matcherクラス利用します。
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// 学籍番号が正しい形式かどうかを判定するメソッド
public class CheckSIDApp extends Application {

	public static String gakuban = "19EC000";//学籍番号を入力すること
	public static String yourname = "千住旭";// 氏名を入力すること
/* 課題2-1のコード
 * checkSID(String)の戻り値 は matchesメソッド の return value に設定しています。
 */


    public static boolean checkSID(String sid) {
		String pattern = "(1[4-9]|2[0-1])[Ee][Cc](\\d{3})";//学籍番号の正規表現
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(sid);
		return  m.matches();

	}

    			// 課題2-2のコード
	public void start(Stage primaryStage)  {
		Label label_1 = new Label("学籍番号");
		TextField textField0 = new TextField();
		Button button = new Button("確認");
		Label label_2 = new Label ("");




        button.setOnAction((ActionEvent event) -> {
            String gakuban = textField0.getText().trim();
            new CheckSIDApp();
            if (CheckSIDApp.checkSID(gakuban)==true)

            	label_2.setText("OK") ;
            else
            	label_2.setText("NG");
        });


        VBox pane = new VBox(label_1,textField0,button,label_2);
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CheckSIDApp");
        primaryStage.show();
	}
	public static void main(String[] args) {		//main メソッド
		// アプリケーションを起動する
		Application.launch(args);
		System.out.println("完了--CheckSIDApp");
	}



}


