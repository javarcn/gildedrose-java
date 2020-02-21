package com.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println(getOutputString());
    }

    public static String getOutputString() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("OMGHAI!");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                Item.createAgedBrie(2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                Item.createSulfuras(0, 80), //
                Item.createSulfuras(-1, 80),
                Item.createBackstage(15, 20),
                Item.createBackstage(10, 49),
                Item.createBackstage(5, 49),
                Item.createBackstage(1, 20),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 3; i++) {
            printStream.println("-------- day " + i + " --------");
            printStream.println("name, sellIn, quality");
            for (Item item : items) {
                printStream.println(item);
            }
            printStream.println();
            app.updateQuality();
        }

        return outputStream.toString();
    }
}
