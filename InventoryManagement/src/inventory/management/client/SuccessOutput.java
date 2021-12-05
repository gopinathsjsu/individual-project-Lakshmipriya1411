package inventory.management.client;

public class SuccessOutput extends Output{

	@Override
	protected IProcessOutput generateOutput() {
		return new ProcessSuccessOutput();
	}

}
