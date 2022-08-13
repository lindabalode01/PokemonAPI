import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Frame {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button = new JButton();
    JLabel display = new JLabel();

    public void layout(){
        frame.setVisible(true);
        frame.setBounds(400, 400, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("API");

        frame.add(display);

        display.setBounds(20, 70, 250, 200);

        frame.add(button);

        button.setBounds(20, 10, 250, 50);
        button.setText("Pokemon");

     button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             HttpClient client = HttpClient.newHttpClient();
             HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://pokeapi.co/api/v2/pokemon/ditto")).build();

             client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                     .thenApply(HttpResponse::body)
                     .thenAccept(System.out::println)
                     .join();

         }
     });

    }
}
