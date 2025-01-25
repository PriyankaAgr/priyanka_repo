package org.dsa.incubation;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

public class JavaStream {

    public static void main(String[] args) throws ParseException {
        List<Transaction> inputs = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        inputs.add(new Transaction(format.parse("01/01/2023"), 100.44, "FitnessClub", "Exercise"));

        inputs.add(new Transaction(format.parse("05/07/2022"), 50.25, "Xerox", "Instrument"));

        inputs.add(new Transaction(format.parse("09/01/2021"), 70.55, "Apple", "Food"));

        List<Transaction> res = inputs.stream().filter(txn -> (!txn.getDate().before(new Date("01/01/2022")) && !txn.getDate().after(new Date("12/12/2022"))))
                .toList();
        List<Transaction> res1 = inputs.stream().filter(txn -> txn.getCategory().equals("Exercise") && txn.price>100).toList();

    }


}

@Setter
@Getter
class Transaction{
    Date date;
    double price;
    String vendor;
    String category;

    public Transaction(Date date,  double price, String vendor, String category) {
        this.date = date;
        this.price = price;
        this.vendor = vendor;
        this.category = category;

    }

}
