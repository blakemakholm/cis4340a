// Note that this code does not run, it is simply to document the SEI Java Rule with the non-compliant
// and compliant code as shown below

// Non-compliant solution
class GameWeapon implements Serializable {
    int numOfWeapons = 10;

    public String toString() {
        return String.valueOf(numOfWeapons);
    }
}

// Compliant Solution
class GameWeapon implements Serializable {
    private static final long serialVersionUID = 24L;

    int numOfWeapons = 10;

    public String toString() {
        return String.valueOf(numOfWeapons);
    }
}

// or


class WeaponStore implements Serializable {
    int numOfWeapons = 10; // Total number of weapons
}

public class GameWeapon implements Serializable {
    WeaponStore ws = new WeaponStore();
    private static final ObjectStreamField[] serialPersistentFields
            = {new ObjectStreamField("ws", WeaponStore.class)};

    private void readObject(ObjectInputStream ois)
            throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gf = ois.readFields();
        this.ws = (WeaponStore) gf.get("ws", ws);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        ObjectOutputStream.PutField pf = oos.putFields();
        pf.put("ws", ws);
        oos.writeFields();
    }

    public String toString() {
        return String.valueOf(ws);
    }
}