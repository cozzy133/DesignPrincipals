package ie.gmit.single;

public class StorageService {
    // add to database or hashmap etc
    private Store store = new Store();

    public void storageOption(User user) {
        store.store(user);
    }
}
