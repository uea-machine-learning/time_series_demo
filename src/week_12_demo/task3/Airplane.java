package week_12_demo.task3;
public final class Airplane implements Runnable {

  private Airport fAirport;
  private String fFlightId;

  public Airplane ( Airport aAirport, String aFlightId ){
    fAirport = aAirport;
    fFlightId = aFlightId;
  }

  public void run() {
    takeOff();
    fly();
    land();
  }

  private void takeOff() {
    synchronized( fAirport ) {
      //always use a while loop, never an if-statement:
      while ( !fAirport.hasAvailableRunway() ) {
        System.out.println( fFlightId + ": waiting for runway..." );
        try {
          //wait for notification from the airport that
          //the state of the airport has changed.
          //wait must always occur within a synchronized block
          fAirport.wait();
        }
        catch (InterruptedException ex) {
          System.err.println( ex );
        }
      }
      //there is an available runway now, so we may take off
      System.out.println( fFlightId + ": taking off now..." );
    }
  }

  private void fly() {
    System.out.println( fFlightId + ": flying now..." );
    try {
      //do nothing for several seconds
      Thread.sleep(10000);
    }
    catch ( InterruptedException ex ){
      System.err.println( ex );
    }
  }

  private void land() {
    synchronized( fAirport ) {
      while ( !fAirport.hasAvailableRunway() ) {
        //wait for notification from the airport that
        //the state of the airport has changed.
        System.out.println( fFlightId + ": waiting for runway..." );
        try {
          fAirport.wait();
        }
        catch (InterruptedException ex) {
          System.err.println( ex );
        }
      }
      //there is an available runway now, so we may take off
      System.out.println( fFlightId + ": landing now..." );
    }
  }
} 

