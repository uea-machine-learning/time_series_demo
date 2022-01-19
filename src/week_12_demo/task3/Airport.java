package week_12_demo.task3;
/** Notifies Airplanes when its state changes. */
public final class Airport implements Runnable {
  private boolean fHasAvailableRunway = true;
  private String fName;

  public Airport (String aName) {
    super();
    fName = aName;
  }

  public synchronized boolean hasAvailableRunway() {
    return fHasAvailableRunway;
  }

  public void run() {
    System.out.println( "Running " + fName + " Airport." );
    while (true) {
      try {
        synchronized ( this ) {
          //simply toggle the state between available and not available
          fHasAvailableRunway = !fHasAvailableRunway;
          System.out.println(fName + " Has Available Runway: " + fHasAvailableRunway);
          //notify all waiters of the change of state
          notifyAll();
        }
        //pause execution for a few seconds
        Thread.sleep( 1000 );
      }
      catch ( InterruptedException ex ){
        System.err.println( ex );
      }
    }
  }
}

