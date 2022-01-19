package week_12_demo.task3;

public final class FlightSimulator {

  public static void main(String... arguments) {
    System.out.println( "Running Flight Simulator." );

    //build an airport and start it running
    Airport naarwich = new Airport("Norwich International");
    Thread airport = new Thread( naarwich );
    airport.start();

    //build a plane and start it running
    Thread planeOne = new Thread( new Airplane(naarwich, "Flight 8875") );
    Thread planeTwo = new Thread( new Airplane(naarwich, "Flight 111") );
    Thread planeThree = new Thread( new Airplane(naarwich, "Flight 222") );
    Thread planeFour = new Thread( new Airplane(naarwich, "Flight 333") );
    planeOne.start();
    planeTwo.start();
    planeThree.start();
    planeFour.start();

    //notice that this user thread now ends, but the program itself does
    //NOT end since the threads created above are also user
    //threads. All user threads have equal status, and there
    //is nothing special about the thread which launches a program.
    System.out.println("Terminating the original user thread.");
  }
} 

