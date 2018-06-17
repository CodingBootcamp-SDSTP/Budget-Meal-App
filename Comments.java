public class Comments
{
	private static Comments _instance = null;

	public static Comments instance() {
		if(_instance == null) {
			_instance = new Comments();
		}
		return(_instance);
	}

	private String comment;

	private Comments() {

	}
}
