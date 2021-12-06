package inventory.management.client;


import java.util.List;

public interface IProcessOutput {

	public void renderOutput(List<InputInventory> ii,String filePath) throws Exception;
	
}
