/*
    Proyecto 3
    Murga Dionicio Miguel Angel
    4CM14
*/

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.Random;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class WebServer {
    private static final String GENERATECURPS_ENDPOINT = "/generateCURPs";
    private static final String CURPSPERSECOND_ENDPOINT = "/CURPsPerSecond";
    private static final String REGISTERS_ENDPOINT = "/registers";
    private static final String REGISTERSDB_ENDPOINT = "/registersDB";
    private static final String BYTES_ENDPOINT = "/bytes";
    private static final String REGISTERSSEX_ENDPOINT = "/registersSex";
    private static final String REGISTERSSTATE_ENDPOINT = "/registersState";

    private final int port;
    private HttpServer server;

    public static void main(String[] args) {
        int serverPort = 8080;
        if (args.length == 1) {
            serverPort = Integer.parseInt(args[0]);
        }

        WebServer webServer = new WebServer(serverPort); 
        webServer.startServer();

        System.out.println("Servidor escuchando en el puerto " + serverPort);
    }

    public WebServer(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HttpContext generateCURPsContext = server.createContext(GENERATECURPS_ENDPOINT);
        HttpContext CURPsPerSecondContext = server.createContext(CURPSPERSECOND_ENDPOINT);
        HttpContext registersContext = server.createContext(REGISTERS_ENDPOINT);
        HttpContext registersDBContext = server.createContext(REGISTERSDB_ENDPOINT);
        HttpContext bytesContext = server.createContext(BYTES_ENDPOINT);
        HttpContext registersSexContext = server.createContext(REGISTERSSEX_ENDPOINT);
        HttpContext registersStateContext = server.createContext(REGISTERSSTATE_ENDPOINT);

        generateCURPsContext.setHandler(this::handleGenerateCURPs);
        CURPsPerSecondContext.setHandler(this::handleCURPsPerSecond);
        registersContext.setHandler(this::handleRegisters);
        registersDBContext.setHandler(this::handleRegistersDB);
        bytesContext.setHandler(this::handleBytes);
        registersSexContext.setHandler(this::handleRegistersSex);
        registersStateContext.setHandler(this::handleRegistesState);

        server.setExecutor(Executors.newFixedThreadPool(8)); //8 hilos
        server.start(); //Nuevo hilo en segundo plano
    }

    private void handleTaskRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
            exchange.close();
            return;
        }

        Headers headers = exchange.getRequestHeaders();
        if (headers.containsKey("X-Test") && headers.get("X-Test").get(0).equalsIgnoreCase("true")) {
            String dummyResponse = "123\n";
            sendResponse(dummyResponse.getBytes(), exchange);
            return;
        }

        boolean isDebugMode = false;
        if (headers.containsKey("X-Debug") && headers.get("X-Debug").get(0).equalsIgnoreCase("true")) {
            isDebugMode = true;
        }

        long startTime = System.nanoTime();

        byte[] requestBytes = exchange.getRequestBody().readAllBytes();
        byte[] responseBytes = calculateResponse(requestBytes);

        long finishTime = System.nanoTime();



        if (isDebugMode) {
            long tiempo = finishTime - startTime;
            long segundos = tiempo / 100000000;
            long milisegundos = (tiempo%100000000)/1000000;

            String debugMessage = String.format("La operacion tomo %d nanosegundos = %d segundos con %d milisegundos", finishTime - startTime, segundos, milisegundos);
            exchange.getResponseHeaders().put("X-Debug-Info", Arrays.asList(debugMessage));
        }

        sendResponse(responseBytes, exchange);
    }

    private byte[] calculateResponse(byte[] requestBytes) {
        String bodyString = new String(requestBytes);
        String[] stringNumbers = bodyString.split(",");

        BigInteger result = BigInteger.ONE;

        for (String number : stringNumbers) {
            BigInteger bigInteger = new BigInteger(number);
            result = result.multiply(bigInteger);
        }

        return String.format("El resultado de la multiplicación es %s\n", result).getBytes();
    }

    private void handleSearchToken(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
            exchange.close();
            return;
        }

        Headers headers = exchange.getRequestHeaders();
        if (headers.containsKey("X-Test") && headers.get("X-Test").get(0).equalsIgnoreCase("true")) {
            String dummyResponse = "123\n";
            sendResponse(dummyResponse.getBytes(), exchange);
            return;
        }

        boolean isDebugMode = false;
        if (headers.containsKey("X-Debug") && headers.get("X-Debug").get(0).equalsIgnoreCase("true")) {
            isDebugMode = true;
        }

        long startTime = System.nanoTime();

        byte[] requestBytes = exchange.getRequestBody().readAllBytes();
        byte[] responseBytes = buscarCadena(requestBytes);

        long finishTime = System.nanoTime();

        if (isDebugMode) {
            long tiempo = finishTime - startTime;
            long segundos = NANOSECONDS.toSeconds(tiempo);
            long milisegundos = (tiempo%1000000000)/1000000;

            String debugMessage = String.format("La operacion tomo %d nanosegundos = %d segundos con %d milisegundos", finishTime - startTime, segundos, milisegundos);
            exchange.getResponseHeaders().put("X-Debug-Info", Arrays.asList(debugMessage));
        }

        sendResponse(responseBytes, exchange);
    }

    private byte[] buscarCadena(byte[] requestBytes) {
        String bodyString = new String(requestBytes);
        String[] stringArguments = bodyString.split(",");

        int n = Integer.parseInt(stringArguments[0]); //Cantidad de tokens
        String subcadena = stringArguments[1]; //Token a buscar

        //Random random = new Random();
        
        //StringBuilder cadenota = new StringBuilder(n*4);
        char[] cadenota = new char[n*4];

        String palabra = "";
        int contador = 0;
        int i = 0;
        while( i < cadenota.length){
            if(contador == 3){
                cadenota[i] = ' ';
                contador = 0;
                i++;
                continue;
            }
            cadenota[i] = (char)((Math.random()) * (91 - 65) + 65);
            i++;
            contador++;
        }

        /*for(int i = 0; i<n; i++){
            for (int a=0; a<3; a++){ 
                char letra = (char)(random.nextInt(26)+ 'A');
                cadenota.append(letra);
            }
            cadenota.append(" ");    
        }*/
            
        contador = 0;
        for(i = 0; i < cadenota.length; i++){
            if(cadenota[i++] != subcadena.charAt(0))
                continue;
            
            if(cadenota[i++] != subcadena.charAt(1))
                continue;

            if(cadenota[i++] != subcadena.charAt(2))
                continue;
            
            i++;
            contador++;
        }
        
        /*int s = 0;
        long t1 = System.nanoTime();
        while(cadenota.substring(s).indexOf(subcadena) > -1){
            apariciones++;
            if((s+4)<(n*4)){
                s= s + cadenota.indexOf(subcadena) + 4;
            }
        }*/
        
        return String.format("El numero de apariciones es %s\n", contador).getBytes();
        //return String.format("El numero de apariciones es %s\n", apariciones).getBytes();
    }


    private void handleStatusCheckRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("get")) {
            exchange.close();
            return;
        }

        String responseMessage = "El servidor está vivo\n";
        sendResponse(responseMessage.getBytes(), exchange);
    }

    private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.flush();
        outputStream.close();
        exchange.close();
    }
}