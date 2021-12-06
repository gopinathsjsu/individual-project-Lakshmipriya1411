package inventory.management.client;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import inventory.management.middleware.CheckQuantityCap;
import inventory.management.middleware.IsValidInventoryQuantity;
import inventory.management.middleware.Middleware;
import inventory.management.server.Inventory;

public class InventoryClient implements FilenameFilter{
	private static Inventory server;
	private static Output ipo;
	
	private static String initials;    
    
    public InventoryClient(String initials)
    {
        InventoryClient.initials = initials;
    }
    
    public boolean accept(File dir, String name)
    {
        return name.startsWith(initials);
    }
	private static void init() throws Exception {
        server = new Inventory();        
        Middleware middleware = new IsValidInventoryQuantity(server);
        middleware.linkWith(new CheckQuantityCap(server));   
        server.setMiddleware(middleware);
    }
	public static void main(String[] args) throws Exception {
        	
			init();
			
			String currentWorkingDir = System.getProperty("user.dir");
			
        	File directory = new File(currentWorkingDir);
        	              
            InventoryClient objClient= new InventoryClient("Input");      
           
            String[] flist = directory.list(objClient);
      
            if (flist == null) {
            	
                System.out.println(
                    "Empty directory or directory does not exists.");
            }
            else {     
               
                for (int i = 0; i < flist.length; i++) {
                    System.out.println(flist[i]+" found");
                    List<List<String>> lstItems= new ArrayList<List<String>>();
                    List<InputInventory> lstInputInv=new ArrayList<InputInventory>();
                    lstItems=ReadInputCSV.readCSV(flist[i]);      
               	 	ItemRepository itemsRepository = new ItemRepository();
                    for(IIterator iter = itemsRepository.getIterator(lstItems); iter.hasNext();){
                       InputInventory iinv=new InputInventory();
       				@SuppressWarnings("unchecked")
       				List<String> itm = (List<String>)iter.next();
       				IIterator iter2 = itemsRepository.getIterator(itm);
       				if(iter2.hasNext())
       					iinv.setItem((String)iter2.next());
       				if(iter2.hasNext())
       					iinv.setQuantity((String)iter2.next());
       				if(iter2.hasNext())
       					iinv.setCardNumber((String)iter2.next());
       				lstInputInv.add(iinv);
                    }
                                 
                   List<InputInventory> failedInventory = server.processInventories(lstInputInv);  
                   
                   if(failedInventory.size()==0)
                   {
                	String path ="Output sheet"+(i+1)+".csv";
                   	configureOutput(true);                   	
                   	runOutput(lstInputInv,path);
                   }
                   else
                   {
                    String path ="Output sheet"+(i+1)+".txt";
                   	configureOutput(false);
                   	runOutput(failedInventory,path);
                   }
                    
                }
            }       	       
    }
	private static void runOutput(List<InputInventory> ii,String filePath) {
		try 
		{		
			ipo.generateOutput().renderOutput(ii,filePath);
		} catch (Exception e) {			
			e.printStackTrace();
		};
	}
	private static void configureOutput(boolean isSuccess) {
		if(isSuccess)
		{
			ipo = new SuccessOutput();
		}
		else
		{
			ipo=new FailureOutput();
		}		
	}
}

