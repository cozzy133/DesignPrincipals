package ie.gmit.single;
/*
Authors: Padraig O Cosgora, Paul Lennon
Date: 30/03/2020
Version: 2.0
Description: This class enables the user to choose the storage method.

 */

public class StorageService {
    // add to database or hashmap etc
    private Store store = new Store();

    public void storageOption(User user) {
        store.store(user);
    }
}
