package common;

import list_enums.*;
import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;
import net.bytebuddy.implementation.bytecode.Throw;

import java.io.FileWriter;
import java.io.IOException;

public class FileInteraction {

    public static void createCsvFile() {
        CSVWriter csvWriter = null;

        try {
            csvWriter = new CSVWriter(new FileWriter("users.csv"));
            csvWriter.writeNext(new String[]{"firstname", "middlename", "lastname", "email", "group_name"});

            for(int i = 0; i < 10; i++) {
                csvWriter.writeNext(generateUser());
            }
        } catch(IOException e) {
            throw new RuntimeException("The 'users.csv' file was not created.");
        } finally {
            try {
                csvWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String[] generateUser() {
        Faker faker = new Faker();

        String name = Name.getRandomName();
        String lastName = LastName.getRandomMiddleName();
        String middleName = MiddleName.getRandomMiddleName();
        String email = String.format("%s%s", faker.internet().domainWord(), EmailSignature.getRandomEmailSignature());

        if(name.charAt(name.length() - 1) == 'я'|| name.charAt(name.length() - 1) == 'а') {
            lastName += "а";

            if(middleName.charAt(middleName.length() - 1) == 'ь') {
                    middleName += "евна";
            } else {
                middleName += "овна";
            }
        } else {
            middleName += "ович";
        }

        return new String[]{
                name,
                middleName,
                lastName,
                email,
                GroupName.getRandomGroupName()
        };
    }
}
