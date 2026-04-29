package vaultmind.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vaultmind.service.DatabaseManager;
import vaultmind.web.WebServer;

public class JavaFXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        Thread serverThread = new Thread(() -> {
            try {
                int port = Integer.parseInt(
                        System.getenv().getOrDefault("VAULTMIND_PORT", "8080")
                );
                DatabaseManager.bootstrapAdminFromEnv();
                WebServer server = new WebServer("127.0.0.1", port);
                server.start();
                System.out.println("VaultMind running at http://127.0.0.1:" + port);

                try { Thread.sleep(500); } catch (InterruptedException ignored) {}

                Platform.runLater(() -> {
                    WebView webView = new WebView();
                    WebEngine engine = webView.getEngine();
                    engine.load("http://127.0.0.1:8080");

                    StackPane root = new StackPane(webView);
                    Scene scene = new Scene(root, 1280, 820);

                    primaryStage.setTitle("VaultMind — Chat With Your Documents, Privately");
                    primaryStage.setScene(scene);
                    primaryStage.setMinWidth(900);
                    primaryStage.setMinHeight(600);
                    primaryStage.show();
                });

            } catch (Exception e) {
                System.err.println("Failed to start VaultMind: " + e.getMessage());
                e.printStackTrace();
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();
    }

    @Override
    public void stop() {
        System.out.println("VaultMind shutting down.");
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}