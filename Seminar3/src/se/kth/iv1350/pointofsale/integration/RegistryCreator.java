package se.kth.iv1350.pointofsale.integration;

public class RegistryCreator {
    private ItemCatalog itemCatalog = new ItemCatalog();
    private ExternalSystem externalSystem = new ExternalSystem();
    
    public RegistryCreator(){
    	getItemCatalog();
    	getExternalSystem();
    }
    /********************************************
     * Get the value of itemCatalog
     *
     * @return the value of itemCatalog
     *******************************************/
    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }

    /********************************************
     * Get the value of externalSystem
     *
     * @return the value of externalSystem
     *******************************************/
    public ExternalSystem getExternalSystem() {
        return externalSystem;
    } 
}
