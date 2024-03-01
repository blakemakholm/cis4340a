// Note that this code does not run, it is simply to document the SEI Java Rule with the non-compliant
// and compliant code as shown below

// Non-compliant solution (public primitive field)
public class Widget {
    public int total; // Number of elements

    void add() {
        if (total < Integer.MAX_VALUE) {
            total++;
            // ...
        } else {
            throw new ArithmeticException("Overflow");
        }
    }

    void remove() {
        if (total > 0) {
            total--;
            // ...
        } else {
            throw new ArithmeticException("Overflow");
        }
    }
}

// Compliant solution (Private primitive field)
public class Widget {
    private int total; // Declared private

    public int getTotal () {
        return total;
    }

    // Definitions for add() and remove() remain the same
}