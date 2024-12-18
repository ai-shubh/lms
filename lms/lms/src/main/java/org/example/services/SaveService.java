package org.example.services;

import com.google.gson.*;
import org.example.models.Book;
import org.example.models.LMS;
import org.example.models.Loan;
import org.example.models.Member;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class LocalDateSerializer implements JsonSerializer<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

    @Override
    public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(localDate));
    }
}


class LocalDateDeserializer implements JsonDeserializer < LocalDate > {
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDate.parse(json.getAsString(),
                DateTimeFormatter.ofPattern("d-MMM-yyyy").withLocale(Locale.ENGLISH));
    }
}



public class SaveService {


   LMS l1;
    public SaveService( LMS l1) {


        this.l1 = l1;
    }

    public String getFilename() {
        return filename;
    }


    String filename = "lms-db";

//-------------------------
//    public void saveAllData(ArrayList<Book> bookList, ArrayList<Member> memberList, ArrayList<Loan> loanList) {
//        try (FileWriter writer = new FileWriter(filename + ".txt", false)) {
//            Gson gson = new Gson();
//            // Create a map to hold all the data
//            Map<String, Object> data = new HashMap<>();
//            data.put("books", bookList);
//            data.put("members", memberList);
//            data.put("loans", loanList);
//
//            // Convert the map to JSON and write it to the file
//            gson.toJson(data, writer);
//            System.out.println("Data saved successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//------------------------------------------------------------

    public void saveAll() {

//        LMS lms = new LMS();
//        lms.setBookList(books);
//        lms.setMemberList(members);
//        lms.setLoanList(loans);


        try (FileWriter writer = new FileWriter(filename+".txt", false))
        {
//            Gson gson = new Gson();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();

            gson.toJson(l1, writer);
            System.out.println("Data saved " );
        }

        catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }



    }

    public void loadDatafromFile() {

        //data = load from json
//        return data;

        try (FileReader reader = new FileReader("lms-db.txt")) {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                        @Override
                        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
                            return LocalDate.parse(json.getAsString(), formatter);
                        }
                    })
                    .create();



            LMS lms = gson.fromJson(reader, LMS.class);
            l1.setBookList(lms.getBookList());
            l1.setMemberList(lms.getMemberList());
            l1.setLoanList(lms.getLoanList());
//            b1.setBookList(lms.getBookList());
//            b1.l.setBookList(lms.getBookList());
//            m1.setMemberList(lms.getMemberList());
//            l1.setLoanList(lms.getLoanList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (DateTimeParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }

    }
}
//    public void saveBookToFile(ArrayList<Book> book){
//
//
//    try (FileWriter writer = new FileWriter(filename+".txt", false))
//    {
//        Gson gson = new Gson();
//        gson.toJson(book, writer);
//        System.out.println("Data saved " );
//            }
//
//    catch (IOException e) {
//                System.err.println("Error saving file: " + e.getMessage());
//         }
//
//    }
//
//    public void saveMemberToFile(ArrayList<Member> member){
//
//
//        try (FileWriter writer = new FileWriter(filename+".txt", false))
//        {
//            Gson gson = new Gson();
//            String jsonString = gson.toJson(member);
//            writer.write(jsonString);
//
////            Gson gson = new Gson();
////            gson.toJson(member, writer);
////            System.out.println("Data saved " );
//        }
//
//        catch (IOException e) {
//            System.err.println("Error saving file: " + e.getMessage());
//        }
//
//    }
//
//    public void saveLoanToFile(ArrayList<Loan> loan){
//
//
//        try (FileWriter writer = new FileWriter(filename+".txt", false))
//        {
//            Gson gson = new Gson();
//            gson.toJson(loan, writer);
//            System.out.println("Data saved " );
//        }
//
//        catch (IOException e) {
//            System.err.println("Error saving file: " + e.getMessage());
//        }
//
//    }
//
