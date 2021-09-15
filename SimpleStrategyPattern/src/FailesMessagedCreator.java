
public class FailesMessagedCreator implements MessageCreator {

	@Override
	public Message create() {
		return new Message("failed");
	}
}
