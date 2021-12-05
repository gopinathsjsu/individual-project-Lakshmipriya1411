package inventory.management.client;

import java.util.List;

public interface IContainer {
	public <T> IIterator getIterator(List<T> lstItems);
}
