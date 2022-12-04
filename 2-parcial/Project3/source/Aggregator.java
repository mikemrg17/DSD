/*
    Proyecto 3
    Murga Dionicio Miguel Angel
    4CM14
*/

import networking.WebClient;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Aggregator {
    private WebClient webClient;

    public Aggregator() {
        this.webClient = new WebClient();
    }

    public List<String> sendTasksToWorkers(List<String> workersAddresses, List<String> tasks) {
        CompletableFuture<String>[] futures = new CompletableFuture[tasks.size()];
        int[] currentTasks = new int[3];

        int taskNumber = 0;

        for (int i = 0; i < workersAddresses.size(); i++) {
            String workerAddress = workersAddresses.get(i);
            String task = tasks.get(i);
            currentTasks[i] = taskNumber;

            byte[] requestPayload = task.getBytes();
            futures[i] = webClient.sendTask(workerAddress, requestPayload);
            taskNumber++;
            System.out.println("Servidor " + workerAddress + " -> Tarea: " + task);
        }

        boolean bandera = true;

        while(bandera){
            for(int j = 0; j < currentTasks.length; j++){ //Recorre el arreglo con las últimas tareas
                if ( futures[currentTasks[j]].isDone() == true ){
                    if(taskNumber == 26){
                        bandera = false;
                        break;
                    }
                    System.out.println("\nEl primer servidor en terminar fue: " + workersAddresses.get(j) + ". Y se le asigna la tarea: " + tasks.get(taskNumber));
                    futures[taskNumber] = webClient.sendTask(workersAddresses.get(j), tasks.get(taskNumber).getBytes());
                    currentTasks[j] = taskNumber;
                    taskNumber++;
                }
            }
        }

        List<String> results = new ArrayList();
        for (int i = 0; i < tasks.size(); i++) {
            results.add(futures[i].join());
        }

        return results;
    }
}
