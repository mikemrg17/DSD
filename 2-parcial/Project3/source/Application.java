/*
    Proyecto 3
    Murga Dionicio Miguel Angel
    4CM14
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Application {
    private static final String WORKER_ADDRESS_1 = "http://localhost:8081/searchtoken";
    private static final String WORKER_ADDRESS_2 = "http://localhost:8082/searchtoken";
    private static final String WORKER_ADDRESS_3 = "http://localhost:8084/searchtoken";

    public static void main(String[] args) {
        List<String> tasks = new ArrayList<String>();
        Aggregator aggregator = new Aggregator();
        for(int i = 65; i < 91; i++){
            Random random = new Random();
            String taskString = "";
            int tokens = random.nextInt(17576000 - 1757600) + 1757600;
            String tokensN = String.valueOf(tokens);
            taskString += tokensN + ",";
            char letter = (char) i;
            String letterS = String.valueOf(letter);
            for(int j = 0; j < 3; j++){
                taskString += letterS;
            }
            System.out.println(taskString);
            tasks.add(taskString);
        }

        System.out.println("En el método sendTasksToWorkers se asignaron tareas a los servidores:");
        List<String> results = aggregator.sendTasksToWorkers(Arrays.asList(WORKER_ADDRESS_1, WORKER_ADDRESS_2, WORKER_ADDRESS_3), tasks);

        int i = 0;
        for (String result : results) {
            System.out.println("Para la tarea " + tasks.get(i) + " " + result);
            i++;
        }
    }
}
