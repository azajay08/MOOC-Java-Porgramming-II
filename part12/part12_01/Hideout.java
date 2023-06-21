public class Hideout<T> {
	
	private T hidden;

	public Hideout() {

	}
	public void putIntoHideout(T toHide) {
		this.hidden = toHide;
	}

	public T takeFromHideout() {
		if (this.hidden == null) {
			return null;
		}
		T obj = this.hidden;
		this.hidden = null;
		return obj;
	}

	public boolean isInHideout() {
		if (this.hidden != null) {
			return true;
		}
		return false;
	}
}
