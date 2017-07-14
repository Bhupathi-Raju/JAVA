import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by zemoso on 11/7/17.
 */
 class Ping {
    private String command;
    protected int count;
    private String websiteAddress;
    //private ArrayList<Float> timeArray = new ArrayList<>();

    /**
     * This method initialises the arguments.
     * @param command This takes the command to be run in the process
     * @param count   This takes the number of times the user want to ping
     * @param websiteAddress   This takes the address of the host the user want to ping
     */

    public Ping(String command, int count, String websiteAddress)
    {
        this.command = command;
        this.count = count;
        this.websiteAddress = websiteAddress;
    }

    /**
     * This method runs the command and takes the value of the time by verifying the string start and end with 64 bytes
     * and ms respectively and add it into a timeArray ArrayList.
     * @throws IOException When a host is unreachable it throws IOException or when the process cannot execute
     * the command.
     * @return returns an ArrayList<Double> which contains the time values of each ping.
     */
    protected ArrayList<Double> runCommand() throws IOException {
        ArrayList<Double> timeArray = new ArrayList<>();
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader errorStream = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            if (errorStream.readLine() != null)  // If there is no error the s==NUll.
                throw new IOException();
            String s;
            while ((s = inputStream.readLine()) != null) {
                if (s.endsWith("ms") && s.startsWith("64 bytes")) {
                    int index = s.indexOf("time");
                    if (index != -1) {
                        Double time = Double.parseDouble(s.substring(index + 5, s.length() - 2));
                        timeArray.add(time);
                    }
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Unable to reach Host"+" "+ websiteAddress);
        }
        return timeArray;
    }

    /**
     * This method is used to calculate the median of the ping times which are stored in timeArray.
     * It also checks if there is no reply from the host by checking the timeArray size and packet loss by comparing
     * the timeArray size with count.
     * @throws IndexOutOfBoundsException When we are trying to access the index of timeArray that is not yet been
     * initialised , this error is thrown.
     * @return returns the median value
     */
    protected String median(ArrayList<Double> timeArray) throws IndexOutOfBoundsException
    {
        String s ="";
        if(timeArray.size()==0)
            return ("There is a no reply from this host");

        if(count!=timeArray.size()) {
             s = "There is packet loss, Ping again to get the correct value.";
          // return (((float) (count - timeArray.size()) / (float) (count)) * 100);
        }
        Collections.sort(timeArray);
        if (timeArray.size() % 2 == 0) {

            return s+"The median is "+((timeArray.get(timeArray.size() / 2) + timeArray.get(timeArray.size() / 2 - 1)) / 2);
        }
        else
        {
            return s+"The median is "+(timeArray.get((timeArray.size() - 1) / 2));
        }
    }

    /**
     * This method is used to take inputs from the user and build a command string and pass on it to the rumCommand
     * method and then finding its median by calling a median method.
     * This method also takes care when user enters wrong inputs by catching a InputMismatchException
     * @param args arguments for the main method
     * @throws IOException This error is thrown when runCommand method is called and an error occurs there
     */
    public static void main(String[] args) throws IOException{
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the websiteAddress address you want to ping:");
            String websiteAddress = scan.nextLine();
            System.out.println("How many times do u want to ping?");
            int count = scan.nextInt();
            Ping p = new Ping("ping -c" + count + " " + websiteAddress,count,websiteAddress);
            ArrayList<Double> timeArray = p.runCommand();
            if(timeArray.size()==0) {
                System.out.println("auishd");
                System.exit(0);

            }
            System.out.println(p.median(timeArray));
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please enter an integer for number of times to ping");
        }
    }
}