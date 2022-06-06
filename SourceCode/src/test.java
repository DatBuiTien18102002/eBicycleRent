import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.BankCard;
import entity.Bicycle;
import entity.RentalCard;
import entity.RentalInfor;

public class test {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle("02193287", "diaHinh", "vang", "sa", "da thue");
        // Bicycle bicycle2 = new Bicycle("02193288", "diaHinh", "vang", "sa", "da thue");
        // Bicycle bicycle3 = new Bicycle();

        RentalInfor rentalInfor = new RentalInfor("khaitq", "T601", new Date().getTime(), bicycle);
        RentalInfor rentalInfor2 = new RentalInfor("khaitq", "0000", null, new Bicycle());

        BankCard bankCard = new BankCard("2121", "dar", "3232323", 123123, 12345, "ref");

        RentalCard rentalCard = new RentalCard("2121", "dar", "3232323",123123, "khaitq", 1213, "sa@gmail.com", rentalInfor, bankCard );
        RentalCard rentalCard2 = new RentalCard("2131", "we", "43423",1231543, "dattq", 1213, "sa@gmail.com", new RentalInfor(new Bicycle()), new BankCard() );
        //List<Bicycle> list = new ArrayList<>();
        // list.add(bicycle);
        // list.add(bicycle2);
        // list.add(bicycle3);

        // List<RentalInfor> list2 = new ArrayList<>();
        // list2.add(rentalInfor);
        // list2.add(rentalInfor2);
        // String a = null;


         List<RentalCard> list2 = new ArrayList<>();
        list2.add(rentalCard);
        list2.add(rentalCard2);



        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("test3.json")) {
            gson.toJson(list2, writer);
        } catch (Exception e) {
        }

        JsonArray mer = new JsonArray();
    


    }

    public static JsonArray read() {
        JsonArray jsonArray = null;
        
        
        try (FileReader reader = new FileReader("test2.json")) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }
}
