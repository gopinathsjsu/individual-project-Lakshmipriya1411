package inventory.management.client;

import java.util.List;

public abstract class Output {
	
	public void writeOutputToFile(List<InputInventory> ii) throws Exception {
		IProcessOutput op=generateOutput();
		op.renderOutput(ii);
	}

	protected abstract IProcessOutput generateOutput();

}
