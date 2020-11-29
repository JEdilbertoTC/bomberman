import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puntuaciones extends World{
    
    int elementos = 0;
    File file = new File("puntaje.txt");
    private final int limitePuntuaciones = 6;
    private int incremento = 0;
    private int incrementoY = 0;
    private int i = 0;
    
    public Puntuaciones(){    
        super(900, 600, 1);
        addObject(new BotonStart(),100,550);
        addObject(new Regresar(),300,549);
        List<GameRecord> gameRecords =  list();
        getBackground().drawRect(40, 130, 420, 290);
        showText("NOMBRE", 90, 150+incrementoY);
        showText("PUNTUACION", 330, 150+incrementoY);
        for(int i = 0; i < 7;i++){
            getBackground().drawRect(40, 130, 420, 4*incremento);
            incremento+= 10;
        }
        for(GameRecord game: gameRecords){
            if(i< limitePuntuaciones){
                showText(game.getPlayerName(), 80, 190+incrementoY);
                showText(game.getScore()+"", 320, 190+incrementoY);
                incrementoY +=40;
                i++;
            }
        }
    }

    public List<GameRecord> list() {
        List<GameRecord> records = new ArrayList<>();
        List<String> lines;

        try{
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
            Iterator<String> linesIterator = lines.iterator();
            while (linesIterator.hasNext()) {
                String csvLine = linesIterator.next();

                String []parts = csvLine.split(",");

                GameRecord record = new GameRecord(Integer.parseInt(parts[0]),parts[1]);
                records.add(record);

            }
        } catch (IOException e){ }
        sort(records);
        return records;
    }

    public static void sort(List<GameRecord> records){
        for(int i = 0; i < records.size();i++){
            for (int j =0; j< records.size(); j++) {
                if (records.get(i).getScore() >records.get(j).getScore()) {

                    int aux = records.get(i).getScore();
                    String saux = records.get(i).getPlayerName();

                    records.get(i).setScore(records.get(j).getScore());
                    records.get(i).setPlayerName(records.get(j).getPlayerName());

                    records.get(j).setScore(aux);
                    records.get(j).setPlayerName(saux);
                }
            }
        }
    }
}
