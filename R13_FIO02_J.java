// Note that this code does not run, it is simply to document the SEI Java Rule with the non-compliant
// and compliant code as shown below

// Non-compliant solution
File file = new File(args[0]);
file.delete();

// Compliant Solution

File file = new File("file");
if (!file.delete()) {
    // Deletion failed, handle error
}

// or

Path file = new File(args[0]).toPath();
try {
    Files.delete(file);
} catch (IOException x) {
    // Deletion failed, handle error
}