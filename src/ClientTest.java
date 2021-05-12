import com.sun.deploy.net.HttpRequest;
import sun.net.www.http.HttpClient;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientTest {

    public static void main(String[] args) throws IOException {
        URL urlActive = new URL("http://example.com");
        URL url = new URL("https://target-stgbeta-qfof2.apps.papt.to/biit/api/v2.json?environment=prd&dataPath=metlife.com:_MetLife+Bill+of+IT_Build+12032_Full/CostModels/Default/Budget+Quantity/Sep%3AFY2020/Aggregate+Consumption+Detail");
        HttpURLConnection connection = (HttpURLConnection) urlActive.openConnection();
        connection.setRequestMethod("GET");

        readInputStreamToString(connection);
        readFromTestToJSON();
        //System.out.println(result);
    }

    private String TAG = "MyAwesomeApp";

    private static void readFromTestToJSON (){

    }

    private static void readInputStreamToString(HttpURLConnection connection) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("testJson")));

            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);

                System.out.println("break................................. " + sb.capacity());
            }
            //result = sb.toString();
            bw.close();
        }
        catch (Exception e) {
            //Log.i(TAG, "Error reading InputStream");
            //result = null;
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch ( IOException e) {
                   // Log.i(TAG, "Error closing InputStream");
                }
            }
        }

        //return result;
    }
}
