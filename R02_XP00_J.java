// Note that this code does not run, it is simply to document the SEI Java Rule with the non-compliant
// and compliant code as shown below

public void deleteFile(){

    File someFile = new File("someFileName.txt");
    // Do something with someFile
    someFile.delete();

}


public void deleteFile(){

    File someFile = new File("someFileName.txt");
    // Do something with someFile
    if (!someFile.delete()) {
    // Handle failure to delete the file
    }

}