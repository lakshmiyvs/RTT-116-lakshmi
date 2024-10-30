package coffee_shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductLoader {
    public List<Product> loadProducts() {
        List<Product> result = new ArrayList<>();

        try {

            File file = new File("src/products.txt");

            // create the buffered reader
            BufferedReader br = new BufferedReader(new FileReader(file));

            // read the file line by line
            String line;
            while ((line = br.readLine()) != null) {

                // Tokenize the line that we just read from the file by spliting
                String[] tokens = line.split(",");
                // Create a product and set the values that we just "parsed" from the file
                Product p = new Product();
                p.setName(tokens[0]);
                p.setPrice(Double.parseDouble(tokens[1]));
                result.add(p);
                System.out.println(line);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        new ProductLoader().loadProducts();
    }
}
