package model;


import java.io.*;
import java.util.*;


public class Food extends Item {
    private boolean healthy;

    public Food(String id, String name, int calories, boolean healthy){
        super(id, name, calories);
        this.healthy = healthy;
    }

    @Override
    public boolean getHealthy(){ return healthy;}


    //EFFECTS: returns a log of food eaten for PrintWriter
    @Override
    protected String summary(Item i){
        return (i.id + " " + i.name + ": " + i.calories + " - " + i.getHealthy());
    }


    //REQUIRES: list is non-empty
    //EFFECTS: saves ID of food eaten to file
    @Override
    public void saveToPrevious(ArrayList<Item> list) throws IOException{
        List<String> lines = new ArrayList<>();
        FileWriter fw = new FileWriter("previous.txt", true);
        PrintWriter writer = new PrintWriter(fw);
        for (Item i : list) {
            lines.add(i.getId());
        }
        for (String line : lines){
            writer.println(line);
        }
        writer.close();
    }



    //REQUIRES: food eaten is non-empty
    //EFFECTS: saves log to file
    @Override
    public void saveToInput(ArrayList<Item> list) throws IOException {
        List<String> lines = new ArrayList<>();
        FileWriter file = new FileWriter("inputfile.txt", true);
        PrintWriter writeToInput = new PrintWriter(file);
        lines.add("");
        lines.add("Food: ");
        for (Item i : list) { //change summary parameter to Food f
            lines.add(summary(i));
        }
        lines.add(printTotal());
        lines.add(printRemaining());
        for (String line : lines) {

            writeToInput.println(line);

        }
        writeToInput.println("");
        writeToInput.close();
    }


}