import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
public class personalisedChatbot {
    public static void main(String[] args) throws IOException {
        // Read the content of the text file
        String text = readTextFile("./handbook.txt");

        // Perform a query on the text
        String query = "What’s the interest rate I can earn daily?";
        String result = "User Question = " + query + "\nHandbook = { " + text + " }";

        String prompt = "[INST] <<SYS>>\nYou are a helpful, respectful and honest personalised customer service assistant, handbook is your extra knowledge to help the customer service system. Response professionally as customer service of E-Gringotts, digital bank.\n<</SYS>>\n" + result + "[/INST]";

        // Call a method to make an HTTP request with the prompt
        makeHTTPRequest(prompt);
    }

    private static String readTextFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    private static void makeHTTPRequest(String prompt) throws IOException {
        String apiUrl = "https://api.replicate.com/v1/predictions";
        String apiKey = "r8_3bqhys1gVHboYiB8cdOlDH3ah4pxa7O0S8MrP";
        String requestBody = "{\"prompt\":" +
                "\"[INST] <<SYS>>\\nYou are a helpful, respectful and honest assistant. Always answer as helpfully as possible, while being safe. If a question does not make any sense, or is not factually coherent, explain why instead of answering something not correct.\\n<</SYS>>\\n " +
                prompt + " [/INST]\"}}";

        // Create URL object
        URL url = new URL(apiUrl);

        // Create connection object
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method
        connection.setRequestMethod("POST");

        // Set request headers
        connection.setRequestProperty("Authorization", "Token " + apiKey);
        connection.setRequestProperty("Content-Type", "application/json");

        // Enable output & input
        connection.setDoOutput(true);
        connection.setDoInput(true);

        // Write the request body to the connection
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Read the response from the server
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response: " + response.toString());
        }

        // Disconnect the connection
        connection.disconnect();
    }
}
