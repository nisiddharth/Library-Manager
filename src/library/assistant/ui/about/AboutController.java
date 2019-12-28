package library.assistant.ui.about;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import library.assistant.alert.AlertMaker;
import library.assistant.util.LibraryAssistantUtil;

// Copyright © 2020, Nishchal Siddharth Pandey
public class AboutController implements Initializable {

	private static final String LINKED_IN = "https://www.linkedin.com/in/nishchal-siddharth-pandey-ab85b2171/";
	private static final String FACEBOOK = "http://facebook.com/nisiddharth";
	private static final String WEBSITE = "http://nisiddharth.github.io";
	private static final String GITHUB = "https://www.github.com/nisiddharth";

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		AlertMaker.showTrayMessage(String.format("Hello %s!", System.getProperty("user.name")), "Thanks for trying out Library Manager");
	}

	private void loadWebpage(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (IOException | URISyntaxException e1) {
			e1.printStackTrace();
			handleWebpageLoadException(url);
		}
	}

	private void handleWebpageLoadException(String url) {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load(url);
		Stage stage = new Stage();
		Scene scene = new Scene(new StackPane(browser));
		stage.setScene(scene);
		stage.setTitle("Copyright © 2020, Nishchal Siddharth Pandey");
		stage.show();
		LibraryAssistantUtil.setStageIcon(stage);
	}

	@FXML
	private void loadGithub(ActionEvent event) {
		loadWebpage(GITHUB);
	}

	@FXML
	private void loadBlog(ActionEvent event) {
		loadWebpage(WEBSITE);
	}

	@FXML
	private void loadLinkedIN(ActionEvent event) {
		loadWebpage(LINKED_IN);
	}

	@FXML
	private void loadFacebook(ActionEvent event) {
		loadWebpage(FACEBOOK);
	}

	@FXML
	private void easterEgg() {
		AlertMaker.showTrayMessage(String.format("Hey %s!", System.getProperty("user.name")), "Looks like you have free time!");
	}
}
