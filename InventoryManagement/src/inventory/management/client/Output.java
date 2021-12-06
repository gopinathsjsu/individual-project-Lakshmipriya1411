package inventory.management.client;

import java.util.List;

public abstract class Output {
	
	public void writeOutputToFile(List<InputInventory> ii,String filePath) throws Exception {
		IProcessOutput op=generateOutput();
		op.renderOutput(ii,filePath);
	}

	protected abstract IProcessOutput generateOutput();

}
