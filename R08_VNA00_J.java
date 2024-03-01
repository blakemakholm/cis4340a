// Note that this code does not run, it is simply to document the SEI Java Rule with the non-compliant
// and compliant code as shown below

// Non-compliant solution
final class ControlledStop implements Runnable {
    private boolean done = false;

    @Override public void run() {
        while (!done) {
            try {
                // ...
                Thread.currentThread().sleep(1000); // Do something
            } catch(InterruptedException ie) {
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
        }
    }

    public void shutdown() {
        done = true;
    }
}

// Compliant solution
final class ControlledStop implements Runnable {
    private volatile boolean done = false;

    @Override public void run() {
        while (!done) {
            try {
                // ...
                Thread.currentThread().sleep(1000); // Do something
            } catch(InterruptedException ie) {
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
        }
    }

    public void shutdown() {
        done = true;
    }
}