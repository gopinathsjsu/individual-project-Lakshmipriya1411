package inventory.management.client;

public class FailureOutput extends Output{
	@Override
	protected IProcessOutput generateOutput() {
		return new ProcessFailedOutput();
	}
}
